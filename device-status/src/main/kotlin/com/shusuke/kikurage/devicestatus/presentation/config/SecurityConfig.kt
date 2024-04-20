package com.shusuke.kikurage.devicestatus.presentation.config

import com.shusuke.kikurage.devicestatus.application.AuthenticationService
import com.shusuke.kikurage.devicestatus.domain.RoleType
import com.shusuke.kikurage.devicestatus.presentation.handler.DeviceStatusAccessDeniedHandler
import com.shusuke.kikurage.devicestatus.presentation.handler.DeviceStatusAuthenticationEntryPoint
import com.shusuke.kikurage.devicestatus.presentation.handler.DeviceStatusAuthenticationFailureHandler
import com.shusuke.kikurage.devicestatus.presentation.handler.DeviceStatusAuthenticationSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

/**
 * Spring doc: https://spring.pleiades.io/spring-security/reference/servlet/configuration/kotlin.html#kotlin-config-httpsecurity
 * sample code: https://github.com/spring-projects/spring-security-samples/blob/main/servlet/spring-boot/kotlin/hello-security/src/main/kotlin/org/springframework/security/samples/config/SecurityConfig.kt
 */

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationService: AuthenticationService
) {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize("/login", permitAll)
                authorize("/admin/**", hasAnyAuthority(RoleType.ADMIN.toString()))
                authorize(anyRequest, authenticated)
            }
            csrf { disable() }
            httpBasic { disable() }
            formLogin {
                loginProcessingUrl = "/login"
                authenticationSuccessHandler = DeviceStatusAuthenticationSuccessHandler()
                authenticationFailureHandler = DeviceStatusAuthenticationFailureHandler()
                // TODO: addUsernameParam, passwordParam using security package 6.3.0 (https://github.com/spring-projects/spring-security/pull/14488)
            }
            exceptionHandling {
                defaultAuthenticationEntryPointFor(
                    entryPoint = DeviceStatusAuthenticationEntryPoint(),
                    preferredMatcher = AntPathRequestMatcher("/device/**")
                )
                defaultAccessDeniedHandlerFor(
                    deniedHandler = DeviceStatusAccessDeniedHandler(),
                    preferredMatcher = AntPathRequestMatcher("/device/**")
                )
            }
            cors {
                configurationSource = corsConfigurationSource()
            }
        }
        return http.build()
    }

    @Bean
    fun users(): UserDetailsService {
        val user = User.builder()
            .username("user")
            .password(passwordEncoder()?.encode("password"))
            .roles(RoleType.USER.toString())
            .build()
        return InMemoryUserDetailsManager(user)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration()
        config.addAllowedMethod(CorsConfiguration.ALL)
        config.addAllowedHeader(CorsConfiguration.ALL)
        config.addAllowedOrigin("http://localhost:8081")
        config.allowCredentials = true

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", config)

        return corsConfigurationSource
    }
}