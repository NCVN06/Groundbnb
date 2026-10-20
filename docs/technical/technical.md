## Aspectos tecnicos

## Construcción y ejecución

Requisitos:
- Java 17

Comandos:

.\mvnw.cmd clean
.\mvnw.cmd test
.\mvnw.cmd package
.\mvnw.cmd verify
.\mvnw.cmd spring-boot:run

URL local:

http://localhost:8080

## Dependencias

- spring-boot-starter-webmvc → aplicación web con Spring MVC: controladores y peticiones HTTP.
- spring-boot-starter-thymeleaf → vistas HTML mediante plantillas Thymeleaf.
- spring-boot-starter-webmvc-test → soporte para pruebas de Spring MVC.
- spring-boot-starter-thymeleaf-test → soporte para pruebas de Thymeleaf.
- spring-boot-starter-data-jpa -> infraestructura necesaria para trabajar con entidades
- h2 -> motor de base de datos embebido
- spring-boot-h2console -> consola web de H2
- spring-boot-starter-validation -> Soporte para la validación de datos basada en especificaciones de Java Bean Validation (Jakarta Validation).