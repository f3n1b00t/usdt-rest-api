# 🌐 USDT REST API Wrapper

![GitHub stars](https://img.shields.io/github/stars/f3n1b00t/usdt-rest-api?style=social)
![GitHub forks](https://img.shields.io/github/forks/f3n1b00t/usdt-rest-api?style=social)
![GitHub issues](https://img.shields.io/github/issues/f3n1b00t/usdt-rest-api)
![GitHub pull requests](https://img.shields.io/github/issues-pr/f3n1b00t/usdt-rest-api)
![GitHub license](https://img.shields.io/github/license/f3n1b00t/usdt-rest-api)

**The USDT REST API Wrapper project is a tool that wraps the USDT (Tether) contract and provides a convenient REST API for interacting with it.**

## 🚀 Key Features

- 🌟 **Convenient USDT Contract Interaction:** The project wraps a complex USDT contract and offers a user-friendly REST API, enabling users to interact with the contract easily.

- 🧩 **Modular Architecture:** The project utilizes Spring Boot and follows a modular architecture, making it easy to add new features and maintain.

- 📚 **API Documentation:** With the use of Swagger V3 and Springdoc-openapi, the project provides comprehensive API documentation, helping users quickly explore available endpoints and their functionality.

- 🛠️ **Code Simplicity with Lombok:** Leveraging Lombok simplifies the project's code, making it more readable and maintainable.

- 🐳 **Easy Deployment with Docker Compose:** Docker Compose allows for straightforward project deployment, simplifying its setup and scalability.

- 📈 **Monitoring with Zipkin:** Integration with Zipkin through Brave offers monitoring and tracking capabilities to ensure stability and performance.

- 🧪 **Unit Testing:** The project's code is equipped with unit tests, enhancing its reliability and ensuring stable performance.


## 🛠️ Technology Stack
- [Spring Boot Actuator](https://spring.io/projects/spring-boot): Monitoring and management of application.
- [Spring Boot Validation](https://spring.io/guides/gs/validating-form-input/): Input validation.
- [Spring Boot Web](https://spring.io/guides/gs/serving-web-content/): Building web-based applications.
- [Spring Boot AOP](https://spring.io/guides/gs/aspect-oriented-programming/): Modularization and cross-cutting concerns.
- [Web3j](https://web3j.io/): Interaction with the USDT contract.
- [Swagger V3](https://swagger.io/): API documentation.
- [Springdoc-openapi](https://springdoc.org/): OpenAPI documentation generation.
- [Lombok](https://projectlombok.org/): Code simplification.
- [Docker Compose](https://docs.docker.com/compose/): Deployment orchestration.
- [Zipkin](https://zipkin.io/) via [Brave](https://github.com/openzipkin/brave): Distributed tracing for monitoring.

## 🏁 Installation and Running

To run the project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/f3n1b00t/usdt-rest-api.git
   cd usdt-rest-api
   ```
2. Build service:
   ```bash
   cd contract-service
   ./gradlew build 
   ```
3. Run docker:
   ```bash
   cd ..
   docker compose up
   ```
4. Enjoy the project! 🎉

## 📖 API Documentation
After a successful launch, you can visit the following link to explore the API documentation:

[API Documentation](http://127.0.0.1:8080/swagger-ui/index.html)

## 🤝 Contribution
We welcome contributions to the project! If you would like to contribute, please review the [CONTRIBUTING.md](https://github.com/f3n1b00t/usdt-rest-api/CONTRIBUTING.md) for more information.

## 📄 License
Spring Boot is Open Source software released under the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).