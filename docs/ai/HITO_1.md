## AI-01 — Hito 1 · Implementación de una issue funcional

> **Ingeniería del Software II · Laboratorio 2026-2027**
>
> Esta ficha documenta la ejecución del **Hito 1 de IA agéntica**.
>
> El objetivo es dejar evidencia de cómo el equipo utiliza un agente para apoyar la implementación de una issue funcional, qué revisa o modifica antes de aceptar la propuesta y cómo verifica el resultado.

---

### 1. Identificación

- **Equipo / empresa: Groundbnb**  
- **Integrantes: Ángel Leonardo Curiel Cañizalez, Pablo Dalda Sánchez, Pedro Jesús de los Reyes Cabañas, Nuria Sanhonorato Ruiz y Nicolás Carlos Vladila Nastasoiu.**  
- **Repositorio: https://github.com/NCVN06/Groundbnb**  
- **Issue relacionada: #13**  
- **Historia de usuario: #13**  
- **Rama de trabajo: feat/02-Alta-propiedades**  
- **Responsable principal del Hito 1: Nicolás Carlos Vladila Nastasoiu**  
-**Participantes y contribución de cada uno: Ángel Leonardo Curiel Cañizalez: Documentacion, Pablo Dalda Sánchez: configuracion de la IA agentica en la rama.  Pedro Jesús de los Reyes Cabañas: Revision, Nuria Sanhonorato Ruiz : Calidad Nicolás Carlos Vladila Nastasoiu: Revision**

---

### 2. Alcance de la issue

#### Objetivo

Permitir a los usuarios registrar nuevas propiedades en la plataforma, asegurando que se capturen todos los datos obligatorios y se persistan correctamente en la base de datos para su posterior alquiler.


#### Criterios de aceptación relevantes

- [ Los campos obligatorios (nombre, descripción, dirección, precio por noche) deben estar completos para poder guardar.]  
- [ El sistema permite seleccionar y diferenciar el tipo de propiedad (vivienda completa o habitación)]  
- [ El sistema permite marcar si la propiedad acepta reservas directas o si requiere confirmación manual]  
- [ La propiedad se persiste correctamente en la base de datos y queda asociada al propietario que la ha creado]  

#### Fuera de alcance

- Subida de imágenes o contenido multimedia de la propiedad (se deja para una iteración/issue posterior)
- Validación de la dirección mediante una API externa (ej. Google Maps) para evitar direcciones falsas (se asume validación básica de texto por ahora)
- Gestión del calendario de disponibilidad del inmueble (solo se abarca el registro estático de la propiedad).

---

### 3. Plan humano previo

> Configurar la IA agentica para que tenga el contexto completo del proyecto y a su vez proponer la implementacion cuya validación se va a gestionar por el equipo 

#### Plan inicial del equipo

1.  Tener encuenta los requisitos para el desarrollo de la funcionalidad.
2.  Plantear el prompt a la IA agentica para el desarrollo del código 
3.  Validar y corregir en caso de ser necesario la implementacion propuesta por la IA agentica

#### Archivos o capas que se prevé modificar

- Capa de Dominio: rental_platform/domain/Property.java (Nueva entidad).
- Capa de Persistencia: rental_platform/repository/PropertyRepository.java (Nueva interfaz).
-Capa de Presentación: rental_platform/web/PropertyController.java (Nuevo controlador).

#### Dependencias, supuestos o dudas

- La configuracion de base de datos H2, esta implementada 
- el servidor web por medio de spring boot esta implementado 


#### Cómo se comprobará que funciona

- Prueba de camino feliz (Happy path): Se enviará un formulario  con todos los campos obligatorios rellenos correctamente. Se verificará que el servidor responde con éxito  y que al consultar la base de datos (SELECT * FROM property) aparece el nuevo registro asociado al propietario.
- Prueba de validación (Camino alternativo): Se intentará enviar el formulario dejando campos clave vacíos (por ejemplo, sin poner precio o dirección). Se verificará que el controlador intercepta el error, no guarda nada en la base de datos, y devuelve los mensajes de error correspondientes al cliente.


---

### 4. Contexto y propuesta del agente

#### Contexto proporcionado

- [X] Repositorio abierto
- [X] Rama correcta: feature/02-Alta-propiedades
- [X] `AGENTS.md` y skills aplicables
- [X] Issue y criterios de aceptación
- [X] Código existente relevante
- [X] Estructura Maven / Spring Boot (Archivos: Property.java, PropertyRepository.java, PropertyService.java, PropertyController.java)

Herramienta / agente: GitHub Copilot / ChatGPT
Entorno: VS Code 
Modelo, si procede: GPT-4o



#### Prompt principal

Analiza este repositorio.
1. Lee AGENTS.md.
2. Identifica tecnología
y estructura.
3. Resume las reglas que
debes respetar.
4. Indica la rama actual.
No modifiques archivos.
No ejecutes cambios.

Actúa como desarrollador Java experto en Spring Boot. Necesitamos implementar la historia de usuario "Alta de propiedades" (Issue #13). 
Crea la estructura para registrar una propiedad. Los campos obligatorios son: nombre, descripción, dirección, precio por noche, comodidades, tipo de propiedad (vivienda o habitación) y un booleano para reserva directa.
Genera el código para la entidad (Property.java), el repositorio JPA (PropertyRepository.java), el servicio con la lógica de guardado (PropertyService.java) y el controlador (PropertyController.java).

#### Plan propuesto por el agente

Representar tipo de anuncio (vivienda/habitación), descripción, dirección, precio por noche, comodidades y modalidad de reserva en Property, con restricciones apropiadas y persistencia JPA.
Implementar repositorio y servicio para validar y guardar el anuncio, evitando lógica de negocio en el controlador.
Crear el flujo web para capturar y enviar el formulario; exigir los campos obligatorios tanto en servidor como en la interfaz y mostrar errores de validación/resultado.
Añadir pruebas para validación, persistencia y flujo web; ejecutar mvnw.cmd test y mvnw.cmd package.

Esta propuesta de pruebas automatizadas no se incluyó en el plan aprobado por el equipo: se decidió crear `PropertyRegistrationTests.java` como archivo vacío y no implementar casos de prueba porque no forman parte del alcance actual.

**Archivos o componentes propuestos:**

- Dominio/persistencia: Property.java, PropertyRepository.java

- Caso de uso/web: PropertyService.java, PropertyController.java, home.html 



### 5. Revisión humana del plan


#### Cambios solicitados antes de implementar

- mantener el campo de City porque es necesario y el agente queria eliminarlo.
- confirmar el uso que es necesario del BigDecimal
- En el archivo propertiesform cambiado en el html, hemos simplificado la interacción persona ordenador mejorando el affordance y usabilidad


#### Plan final aprobado

1.  PropertyType.java Property.java (modifca constructor y termina la implementacion) 
2.  Resources/ templates property-form.html Crear e implementar
3.  Crear `PropertyRegistrationTests.java` vacío, sin implementar pruebas automatizadas, porque no entran en el alcance actual
4.  PropertyRepository.java Crear e implementar
5. PropertyService.java Crear e implementar 
6. PropertyForm  y PropertyController Crear e implementar
7. Home.htlm implementar 

---

### 6. Implementación y revisión del código

#### Cambios principales

| Archivo / componente           | Cambio realizado                        | Motivo |
|PropertyType.java               |  Crear e implementar                    |        |
|Property.java                   |  Añadir columnas para la base de datos  |        |
| property-form.html             |  Crear e implementar                    |        |
|PropertyRegistrationTests.java  |  Crear el archivo vacío, sin implementar casos de prueba | Decisión del equipo: las pruebas automatizadas no entran en el alcance actual |
| Home.htlm                      | Crear e implementar                     |
| PropertyService.java           |  Crear e implementar                    |
| PropertyForm                   |  Crear e implementar                    |                            
| PopertyController              | Crear e implementar                     |


#### Revisión humana

- [X]Los cambios pertenecen a la issue.
- [X]No se ha ampliado innecesariamente el alcance.
- [X]La separación por capas se mantiene.
- [X]La lógica de negocio no se concentra en el controlador.
- [X]Las entidades y relaciones JPA se pueden justificar, si procede.
- [X]Las validaciones y errores son controlados.
- [X]No se han añadido archivos temporales o ajenos.
- [X]El equipo comprende los cambios realizados.

#### Problemas o carencias detectados

| Problema | Corrección / decisión |
|---|---|
| Se cuestionó el uso de `BigDecimal` para el precio por noche. | Se mantuvo porque representa importes monetarios sin los errores de precisión habituales de los tipos de coma flotante. La entidad limita la escala a dos decimales y el formulario valida también el número de dígitos. |

| El campo `city` Se decidió conservarlo y se incluyó en el formulario, el modelo y la persistencia. Conviene mantener documentada esta decisión para que el requisito adicional sea explícito. |



---

### 7. Verificación

#### Build

```powershell
.\mvnw.cmd verify
```

- [X] `BUILD SUCCESS`
- [ ] Fallo

**Observaciones:**  
Compilación limpia, las pruebas de contexto de Spring arrancan correctamente.


#### Ejecución de la funcionalidad

```powershell
.\mvnw.cmd spring-boot:run
```

- [X] La aplicación arranca correctamente.
- [X] La funcionalidad puede ejecutarse desde la interfaz o endpoint previsto.



#### Comprobación funcional

Las comprobaciones funcionales siguientes se realizaron manualmente. `PropertyRegistrationTests.java` permanece vacío por decisión del equipo, por lo que no contiene pruebas automatizadas del registro; su implementación queda fuera del alcance actual.

**Caso válido**

- **Entrada / acción: Rellenar formulario con datos validos**  
- **Resultado esperado: Mensaje de exito en la alta de la propiedad y la informacion en la fila de base de datos**  

- **Resultado obtenido: Mensaje de exito en la alta de la propiedad y la informacion en la fila de base de datos**  

**Caso inválido o error controlado**

- **Entrada/ acción: dejar campos vacios**  
- **Resultado esperado: mensaje avisando obligatoriedad del campo**  
- **Resultado obtenido: mensaje avisando obligatoriedad del campo**

- **Entrada/ acción: Poner precio negativo**  
- **Resultado esperado: mensaje avisando necesidad de un precio mayor o igual que 0**  
- **Resultado obtenido: mensaje avisando necesidad de un precio mayor o igual que 0**



#### Persistencia, si procede

- **Qué se comprobó: Qué se comprobó: Se consultó la consola H2 / Base de datos (SELECT * FROM property)**  
- **Resultado: La fila se insertó correctamente con todos los valores mapeados**  

#### Revisión final del cambio

```powershell
git status
git diff
```

- [X] Solo aparecen cambios relacionados con la issue.
- [X] El equipo ha revisado y comprende el diff.
- [X] No hay archivos generados, temporales o ajenos.

---

### 8. Evidencias

| Evidencia | Captura / enlace |
|---|---|
| Plan propuesto por el agente | [Ver captura del plan de IA](../PlanIAagentica.png) |
| Funcionalidad ejecutada | [Ver captura de la funcionalidad](../funcionalidad.png) |
| Verificación / persistencia | [Ver captura de la prueba en base de datos](../basedatosprueba.png) |
| Pull Request | |


---

### 9. Pull Request y cierre

- **PR:**  
- **Issue vinculada: #13**  
- **Revisor/a: Nicolás Carlos Vladila Nastasoiu, Pedro Jesús de los Reyes Cabañas**  
- **Estado:** Abierta / En revisión / Aprobada / Integrada  

#### Revisión de la PR

- [X] Alcance correcto.
- [X] Diseño y separación por capas revisados.
- [X] Build correcto.
- [X] Persistencia y validaciones revisadas, si procede.
- [X] Documentación actualizada.
- [X] Uso de IA declarado.
- [X] Deuda técnica, limitaciones o cuestiones pendientes identificadas.

#### Observaciones del revisor

- 
- 

---

### 10. Conclusión y defensa

#### Conclusión

- **Qué aportó el agente:** Propuso e implementó la estructura de alta de propiedades, incluyendo el modelo y su persistencia, el servicio, el controlador y el formulario web con validaciones.

- **Qué tuvo que revisar o corregir el equipo:** El equipo revisó el alcance y la separación por capas, decidió conservar el campo `city`, confirmó el uso de `BigDecimal` para el precio y ajustó el formulario para mejorar su usabilidad.
- **Qué propuesta no debía aceptarse directamente:** La propuesta de eliminar `city` no debía aceptarse sin revisión, porque el equipo considera necesario conservar ese dato para el registro de la propiedad.
- **Qué decisión humana fue más importante:** Mantener `city` y comprobar que las decisiones de implementación respondían al contexto del proyecto, en vez de aceptar automáticamente la propuesta del agente.
- **Cómo se verificó:** Se probó el formulario con datos válidos y con campos vacíos, se probó un precio negativo y se consultó la base de datos H2 para comprobar la fila insertada. Las capturas disponibles se enlazan en la sección 8.

#### Estado final

- [X] Issue implementada.
- [X] Build correcto.
- [X] Funcionalidad verificada.
- [X] Persistencia comprobada, si procede.
- [X] Diff revisado.
- [X] Evidencias completadas.
- [X] PR revisable: https://github.com/NCVN06/Groundbnb/pull/31
- [X] Documentación actualizada cuando corresponde.

#### Resumen breve para defensa

**Issue:** #13, alta de propiedades.  
**Qué hizo el agente:** Propuso e implementó el flujo de registro de propiedades y su persistencia.  
**Qué modificó o rechazó el equipo:** El equipo decidió mantener `city`, confirmó `BigDecimal` para el precio y revisó la usabilidad del formulario; no aceptó sin revisión la propuesta de eliminar `city`.  
**Cómo se verificó:** Se documentaron el build, las pruebas funcionales de formulario y la consulta de persistencia en H2; las capturas están enlazadas en la sección 8.  
**Conclusión:** La IA aceleró la implementación, pero las decisiones y la validación quedaron bajo responsabilidad del equipo.

---

#### Regla final

> **La IA puede proponer e implementar cambios, pero no puede aprobar su propio trabajo.**
>
> El equipo es responsable de comprender, revisar, verificar y justificar todo lo que se integra en el proyecto.

--------------------------------------------------------------------------------------------------------------------------
### 2. Alcance de la issue #11

#### Objetivo

Permitir a cualquier usuario (incluso sin estar registrado) visualizar el catálogo de alojamientos disponibles y realizar búsquedas básicas por texto libre, facilitando la exploración inicial de las opciones de alquiler en el sistema

#### Criterios de aceptación relevantes

[ El sistema debe presentar una pantalla inicial que muestre los alojamientos registrados disponibles. ]

[ Un usuario debe poder iniciar y ejecutar una búsqueda de alojamientos en el sistema introduciendo texto de forma libre. ]

[ El sistema debe procesar la búsqueda y mostrar el listado de propiedades resultantes que coincidan con el texto introducido. ]

[El sistema no debe distinguir entre  mayúsculas y minusculas para decidir la ausencia de resultados.]


#### Fuera de alcance

- puntos de acceso (botones o enlaces) para aplicar filtros avanzados, iniciar una reserva o agregar a favoritos, sirviendo como punto de entrada para futuras issues. 
- Implementación de búsqueda difusa avanzada (fuzzy search) o autocorrección ortográfica (la búsqueda se limitará a coincidencias de texto exactas o parciales básicas).
- Implementación de autocorrección ortográfica (la búsqueda se limitará a coincidencias de texto exactas o parciales básicas).

---

### 3. Plan humano previo


#### Plan inicial del equipo

1.  Tener encuenta los requisitos para el desarrollo de la funcionalidad.
2.  Plantear el prompt a la IA agentica para el desarrollo del código 
3.  Validar y corregir en caso de ser necesario la implementacion propuesta por la IA agentica

#### Archivos o capas que se prevé modificar

- Capa de Dominio: rental_platform/domain/Property.java (Nueva entidad).
                    rental_platform/domain/PropertyService
- Capa de Persistencia: rental_platform/repository/PropertyRepository.java (Nueva interfaz).
-Capa de Presentación: rental_platform/web/PropertyController.java (Nuevo controlador).
                                            HomeController.java

#### Dependencias, supuestos o dudas

- La configuracion de base de datos H2, esta implementada 
- el servidor web por medio de spring boot esta implementado
- van a estar en diferentes enlaces cada funcionalidad  


#### Cómo se comprobará que funciona

- Prueba de camino feliz (Happy path): 

El usuario accede a la plataforma web sin haber iniciado sesión (estado de invitado). La base de datos contiene alojamientos de prueba. El usuario hace clic en la barra de búsqueda y escribe un término válido que sabe que existe y sl sistema carga y muestra únicamente los alojamientos que contienen la palabra, con su descripción, ubicación y precio por noche


- Prueba de validación (Camino alternativo): 

El usuario introduce un término de búsqueda muy específico o con errores tipográficos graves.
El sistema no se rompe ni muestra errores técnicos. En su lugar, la pantalla se limpia de alojamientos y muestra un mensaje e indicando que no hay resultados

---

### 4. Contexto y propuesta del agente

#### Contexto proporcionado

- [X] Repositorio abierto
- [X] Rama correcta: feature/03-Busqueda-propiedades
- [X] `AGENTS.md` y skills aplicables
- [X] Issue y criterios de aceptación
- [X] Código existente relevante
- [X] Estructura Maven / Spring Boot (Archivos: Property.java, PropertyRepository.java, PropertyService.java, PropertyController.java)

Herramienta / agente: GitHub Copilot / ChatGPT
Entorno: VS Code 
Modelo, si procede: GPT-4o



#### Prompt principal

Analiza este repositorio.
1. Lee AGENTS.md.
2. Identifica tecnología
y estructura.
3. Resume las reglas que
debes respetar.
4. Indica la rama actual.
No modifiques archivos.
No ejecutes cambios.

Actúa como desarrollador Java experto en Spring Boot. Necesitamos implementar la historia de usuario "Busqueda de propiedades" (Issue #11). 

Tu tarea es generar el código para implementar la Issue #11, creando un catálogo de propiedades en la página de inicio y un buscador de texto básico para usuarios no registrados. Debes respetar estrictamente una arquitectura por capas y evitar programar cualquier funcionalidad que esté fuera de alcance. Solo debes proporcionarme el código necesario y explicar brevemente a qué archivo pertenece cada bloque.

En el backend, debes crear un endpoint GET en el Controlador que reciba el parámetro de búsqueda. La capa de Servicio concentrará la lógica, decidiendo devolver todo el catálogo si la búsqueda está vacía, o filtrar los datos si el usuario introdujo texto. El Repositorio se encargará de ejecutar una consulta a la base de datos que busque coincidencias parciales, sin distinguir entre mayúsculas y minúsculas, revisando los campos de título, descripción, dirección y ciudad de los alojamientos.

Para la vista, genera el código necesario que incluya una barra de búsqueda y el listado de tarjetas con los resultados. Debes contemplar un estado inicial sin búsqueda y un diseño para cuando no haya coincidencias, mostrando un mensaje al usuario

#### Plan propuesto por el agente

Plan propuesto para implementar la issue #11 

Añadir el catálogo a la pantalla inicial y permitir buscar con texto mediante una petición GET.
Mantener la arquitectura por capas: el repositorio consultará propiedades y el servicio concentrará la búsqueda; el controlador solo enlazará la consulta con la vista.
Mostrar en la vista los resultados, un estado inicial sin búsqueda y un mensaje cuando no haya coincidencias.
Incluir en la vista los puntos de acceso a filtros avanzados, reserva y lista de deseos, sin implementar esas funcionalidades fuera del alcance descrito.
Añadir pruebas de búsqueda y vista, y ejecutar las pruebas Maven pertinentes.
Para hacer el comportamiento concreto, propongo que la búsqueda encuentre coincidencias sin distinguir mayúsculas/minúsculas en título, descripción, dirección y ciudad; que una consulta vacía muestre todo el catálogo; y que las tres extensiones se representen como accesos visuales sin acciones funcionales. El repositorio no contiene el diagrama referido por la issue (el documento de diagramas solo es un marcador), así que no puedo verificar otras formas o destinos para esos accesos. 

**Archivos o componentes propuestos:**

- Dominio/persistencia: Property.java, PropertyRepository.java

- Caso de uso/web: PropertyService.java, HomeController.java

¡

### 5. Revisión humana del plan


#### Cambios solicitados antes de implementar

- No implementar ni funcionalidades ni botones de filtros avanzados porque no entran en el alance actual
- No implementar ni funcionalidades ni botones de añadir a favoritos porque no entran en el alcance actual
- 

#### Plan final aprobado

    En PropertyRepository.java añadirñe una consulta insensible a mayúsculas/minúsculas que busca en título, descripción, dirección y ciudad.En PropertyService.java añadí la búsqueda por capas: elimina espacios externos y devuelve todas las propiedades si la consulta está vacía.

    En HomeController.java conecté la página inicial con el servicio y envié los resultados y el estado de búsqueda a la vista.
    En home.html añadí el formulario GET, el catálogo y mensajes para el catálogo vacío o las búsquedas sin resultados.

    En PropertySearchTests.java añadí pruebas para consulta vacía, coincidencia sin distinguir mayúsculas y ausencia de resultados.


Tal como acordamos, quedan fuera los filtros, reservas, lista de deseos y sus accesos visuales
---

### 6. Implementación y revisión del código

#### Cambios principales

**Archivo Component:e**        
    
PropertyRepository.java         

**Cambio realizado:**

Adición de una consulta de búsqueda insensible a mayúsculas/minúsculas  que filtra por título, descripción, dirección y ciudad.

**Motivo:**

Permitir la búsqueda flexible de propiedades en la base de datos sin obligar al usuario a ser exacto con las mayúsculas, mejorando la experiencia de búsqueda básica.

**Archivo Component:e**        
    
PropertyService.java        

**Cambio realizado:**

Implementación de la lógica de negocio para la búsqueda y retorno de todo el catálogo si el parámetro de búsqueda está vacío.

**Motivo:**

Era necesaria la implementacion
**Motivo:**

Permitir la búsqueda flexible de propiedades en la base de datos sin obligar al usuario a ser exacto con las mayúsculas, mejorando la experiencia de búsqueda básica.

**Archivo Componente:**        
    
HomeController.java     

**Cambio realizado:**

Conexión del endpoint de la página inicial con PropertyService, inyectando el término de búsqueda y los resultados obtenidos en el modelo de la vista.

**Motivo:**

Exponer la funcionalidad de búsqueda a través de peticiones HTTP GET y suministrar a la plantilla frontend los datos necesarios 

**Archivo Componente:**      

PropertySearchTests.java

**Cambio realizado:**

Creación de casos de prueba para validar tres escenarios: consulta vacía (devuelve todo), coincidencias  y búsqueda sin resultados.

**Motivo:**

Asegurar la calidad del código y verificar que los requerimientos de la Issue #11 (Happy Path y Caminos Alternativos) funcionan correctamente sin regresiones



#### Revisión humana

- [X]Los cambios pertenecen a la issue.
- [X]No se ha ampliado innecesariamente el alcance.
- [X]La separación por capas se mantiene.
- [X]La lógica de negocio no se concentra en el controlador.
- [X]Las entidades y relaciones JPA se pueden justificar, si procede.
- [X]Las validaciones y errores son controlados.
- [X]No se han añadido archivos temporales o ajenos.
- [X]El equipo comprende los cambios realizados.

#### Problemas o carencias detectados

| Problema | Corrección / decisión |

Se tuvo que pedir e implementar control de errores 

Se tuvo que descartar la idea de implementar frontend de funcionalidades que no aplican a la issue



### 7. Verificación

#### Build

```powershell
.\mvnw.cmd verify
```

- [X] `BUILD SUCCESS`
- [ ] Fallo

**Observaciones:**  
Compilación limpia, las pruebas de contexto de Spring arrancan correctamente.


#### Ejecución de la funcionalidad

```powershell
.\mvnw.cmd spring-boot:run
```

- [X] La aplicación arranca correctamente.
- [X] La funcionalidad puede ejecutarse desde la interfaz o endpoint previsto.



#### Comprobación funcional

**Caso válido**

- **Entrada / acción: Bucar una casa/habitación que existe en la base de datos**  
- **Resultado esperado: Mostrar liste de coincidencias con las cracteristicas de las propiedades**  

- **Resultado obtenido: Mostrar liste de coincidencias con las cracteristicas de las propiedades**  



- **Entrada/ acción: sin ingresar ningún texto en el formulario de búsqueda**  
- **Resultado esperado: se muestra el formulario de búsqueda y la totalidad del catálogo**  
- **Resultado obtenido: se muestra el formulario de búsqueda y la totalidad del catálogo**


**Caso inválido o error controlado**

- **Entrada/ acción: s**  
- **Resultado esperado:  Mostrar Todas  **  
- **Resultado obtenido: mensaje avisando obligatoriedad del campo**

- **Entrada/ acción:**  
- **Resultado esperado:** 
- **Resultado obtenido:**



#### Persistencia, si procede

-- No procede debido a que la issue se basa en la consulta de la Base de Datos, todas las pruebas se han hecho en la web


#### Revisión final del cambio

```powershell
git status
git diff
```

- [X] Solo aparecen cambios relacionados con la issue.
- [X] El equipo ha revisado y comprende el diff.
- [X] No hay archivos generados, temporales o ajenos.

---

### 8. Evidencias

| Evidencia | Captura / enlace |
|---|---|
| Plan propuesto por el agente | [Ver captura del plan de IA](../PlanIAagentica.png) |
| Funcionalidad ejecutada | [Ver captura de la funcionalidad](../funcionalidad.png) |
| Verificación / persistencia | [Ver captura de la prueba en base de datos](../basedatosprueba.png) |
| Pull Request | |


---

### 9. Pull Request y cierre

- **PR:**  
- **Issue vinculada: #11**  
- **Revisor/a: Nicolás Carlos Vladila Nastasoiu, Pedro Jesús de los Reyes Cabañas**  
- **Estado:** Integrada  

#### Revisión de la PR

- [X] Alcance correcto.
- [X] Diseño y separación por capas revisados.
- [X] Build correcto.
- [X] Persistencia y validaciones revisadas, si procede.
- [X] Documentación actualizada.
- [X] Uso de IA declarado.
- [X] Deuda técnica, limitaciones o cuestiones pendientes identificadas.

#### Observaciones del revisor

- 
- 

---

### 10. Conclusión y defensa de Issue #11

#### Conclusión

- **Qué aportó el agente:** Propuso e implementó un catálogo de propiedades en la página inicial y una búsqueda básica por texto mediante una petición GET. La solución documentada separa responsabilidades: el repositorio consulta por título, descripción, dirección y ciudad sin distinguir mayúsculas; el servicio trata las consultas vacías y el controlador proporciona los resultados a la vista.
- **Qué tuvo que revisar o corregir el equipo:** El equipo acotó el alcance y decidió no incluir accesos visuales para filtros avanzados ni para añadir propiedades a favoritos. También pidió incorporar control de errores.
- **Qué propuesta no debía aceptarse directamente:** La propuesta de incluir accesos visuales a filtros avanzados, reservas y lista de deseos no debía incorporarse, porque esas funcionalidades y sus accesos quedaron fuera del alcance acordado.
- **Qué decisión humana fue más importante:** Delimitar el trabajo a la búsqueda y al catálogo básicos, evitando ampliar la interfaz con puntos de entrada a funcionalidades futuras que no forman parte de la issue.
- **Cómo se verificó:** La sección 7 documenta la ejecución de `mvnw.cmd verify`, el arranque de la aplicación y comprobaciones funcionales desde la web: búsqueda con coincidencias y consulta vacía, que muestra el catálogo se han hecho de manera manual

#### Estado final

- [X] Issue #11 implementada según los cambios descritos en la sección 6.
- [X] Build verificado según el resultado documentado en la sección 
- [X] Catálogo y búsqueda comprobados manualmente en la interfaz, según los casos descritos en la sección 7.
- [X] PR revisable: https://github.com/NCVN06/Groundbnb/pull/32
- [X] Documentación del hito actualizada.

#### Resumen breve para defensa

**Issue:** #11, búsqueda de propiedades.

**Qué hizo el agente:** Propuso e implementó un catálogo inicial y una búsqueda textual básica por capas, incluyendo el tratamiento de una consulta vacía y la presentación de resultados.

**Qué decidió el equipo:** Mantener el alcance centrado en catálogo y búsqueda; no incluir accesos visuales a filtros avanzados ni a favoritos, y solicitar control de errores.

**Cómo se verificó:** El documento registra un build correcto, el arranque de la aplicación y comprobaciones web. La búsqueda sin texto mostró el catálogo 

**Conclusión:** La implementación cubre el flujo básico descrito para la búsqueda, mientras que el equipo definió los límites del alcance 
---

#### Regla final

> **La IA puede proponer e implementar cambios, pero no puede aprobar su propio trabajo.**
>
> El equipo es responsable de comprender, revisar, verificar y justificar todo lo que se integra en el proyecto.
