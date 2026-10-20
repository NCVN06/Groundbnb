## Aspectos tecnicos

## Construcción y ejecución

Requisitos:
- Java 17

Comandos:

.\mvnw.cmd clean -> Borra los archivos y carpetas producidos por Maven al compilar el programa.

.\mvnw.cmd test -> Ejecuta los test de integración del programa.

.\mvnw.cmd package -> Empaqueta el código compilado en su formato de distribución, como es JAR.

.\mvnw.cmd verify -> Comprueba los resultados de los test de integración para comprobar que concuerda con los criterios de calidad.

.\mvnw.cmd spring-boot:run -> Lanza la aplicación con el programa spring-boot.

URL local:

http://localhost:8080

## Datos de demostración

Al iniciar la aplicación se cargan cinco propiedades de ejemplo si la base de datos está vacía. H2 se ejecuta en memoria, por lo que los registros creados durante una ejecución no se conservan al reiniciar la aplicación; las propiedades de ejemplo vuelven a cargarse en el siguiente inicio.

## Dependencias

- spring-boot-starter-webmvc → aplicación web con Spring MVC: controladores y peticiones HTTP.
- spring-boot-starter-thymeleaf → vistas HTML mediante plantillas Thymeleaf.
- spring-boot-starter-webmvc-test → soporte para pruebas de Spring MVC.
- spring-boot-starter-thymeleaf-test → soporte para pruebas de Thymeleaf.
- spring-boot-starter-data-jpa -> infraestructura necesaria para trabajar con entidades.
- h2 -> motor de base de datos embebido.
- spring-boot-h2console -> consola web de H2.
- spring-boot-starter-validation -> Soporte para la validación de datos basada en especificaciones de Java Bean Validation (Jakarta Validation).


**Plugins**

- spring-boot-maven-plugin -> permite utilizar las funcionalidades que ofrece maven (clean/test/package/verify/spring-boot:run ...) y añadir al JAR las dependencias del proyecto.