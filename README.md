## Device Status API

### Settings

<img width="1000" alt="spring initializr" src="https://github.com/shusuke0812/Kikurage-API/assets/33107697/bca4da21-19c6-4bc2-bcd1-8dfc7709aa63">

### APIs

1. Run docker

```bash
$ cd {this project root}
$ docker-compose up -d
```

2. Launch `http://localhost:8003/` in your browser

<img width="760" alt="swagger-ui" src="https://github.com/shusuke0812/Kikurage-API/assets/33107697/0c1fdaaa-1575-4fb6-9b53-880aedd97cc0">

### Development
- IntelliJ IDEA 2023.1.3
- JDK 17

**ER Diagram**

<img width="600" src="https://github.com/shusuke0812/Kikurage-API/assets/33107697/42ade923-6ddf-4bfc-9bc6-dbd8076688b5">

**API Architecture**
- Kotlin / Spring Boot
- My Batis (O/R)

<img width="300" src="https://github.com/shusuke0812/Kikurage-API/assets/33107697/42003d34-3a16-4c0b-a03f-a4c8645b97be">

**How to generate HASH of user password**

```bash
$ htpasswd -n -B pass
```

### Reference
- OpenAPI
  - [Data types](https://spec.openapis.org/oas/latest.html#data-types)