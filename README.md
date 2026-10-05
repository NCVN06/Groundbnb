# Plataforma de alquiler de viviendas
Proyecto desarrollado para el laboratorio de Ingeniería del Software II (Curso 2026-2027). 

## Equipo

Empresa: Groundbnb

Integrantes:
- Ángel Leonardo Curiel Cañizalez
- Pablo Dalda Sánchez
- Pedro Jesús de los Reyes Cabañas
- Nuria Sanhonorato Ruiz
- Nicolás Carlos Vladila Nastasoiu

Portavoz:
- Nicolás Carlos Vladila Nastasoiu

## Objetivo

Desarrollar una plataforma para la gestión de alquiler de viviendas siguiendo un proceso iterativo e incremental de ingeniería del software.

## Estado

### Sprint 0
09/09/2026 - 15/09/2026

- Construcción de la empresa.    
- Preparar entorno de trabajo. 
- Preparación y planificación del backlog.

### Sprint 1
16/09/2026 - 22/09/2026

- Implementar Maven y Spring Boot al proyecto

### Sprint 2
23/09/2026 - 30/09/2026

- Documentación y pull requests.
- Añadir funcionalidades al backlog.

### Sprint 3
01/10/2026 - 06/10/2026

- Impelementar JPA y H2DB en el proyecto
- Terminar el backlog orientativo

### Sprint 4
07/10/2026 - 13/10/2026

Por concretar.

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

## Funcionalidad candidata para el hito 1

**Dar de alta propiedades**

Seleccionamos esta funcionalidad para tener una primera interfaz usable y una funcionalidad básica.

## Documentación del proyecto

La documentación viva del proyecto se mantiene en:

- `docs/technical/`: base técnica y dependencias.
- `docs/diagrams/`: diagramas y modelos.
- `docs/decisions/`: decisiones relevantes.



