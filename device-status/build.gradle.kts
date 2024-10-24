import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.thinkimi.gradle.MybatisGenerator") version "2.4"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}

group = "com.shusuke.kikurage.devicestatus"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.3.4")
	implementation("org.springframework.boot:spring-boot-starter-web:3.3.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// MySQL
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
	implementation("mysql:mysql-connector-java:8.0.23")
	mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")

	// Auth
	implementation("org.springframework.boot:spring-boot-starter-security:3.3.4")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.4")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3")
	implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

mybatisGenerator {
	verbose = true
	configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "1.8"
}