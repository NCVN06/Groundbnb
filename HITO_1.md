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
-**Participantes y contribución de cada uno: Ángel Leonardo Curiel Cañizalez: Documentacion, Pablo Dalda Sánchez: configuracion de la IA agentica en la rama.  Pedro Jesús de los Reyes Cabañas, Nuria Sanhonorato Ruiz : Nicolás Carlos Vladila Nastasoiu**

---

### 2. Alcance de la issue

#### Objetivo

Permitir a los usuarios registrar nuevas propiedades en la plataforma, asegurando que se capturen todos los datos obligatorios y se persistan correctamente en la base de datos para su posterior alquiler.


#### Criterios de aceptación relevantes

- [ Los campos obligatorios (nombre, descripción, dirección, precio por noche) deben estar completos para poder guardar.]  
- [ El sistema permite seleccionar y diferenciar el tipo de propiedad (vivienda completa o habitación]  
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

1.  Modelar la entidad: Crear la clase Property en la capa de dominio con los atributos solicitados (nombre, descripción, dirección, precio, comodidades, tipo [Enum: VIVIENDA, HABITACION], y reservaDirecta) aplicando validaciones de Spring (@NotNull, @NotBlank).
2.  apa de persistencia: Crear la interfaz PropertyRepository extendiendo de JpaRepository para gestionar el acceso a la base de datos sin escribir SQL manual.
3.  Capa de negocio (Servicio): Implementar PropertyService con un método para registrar la propiedad, encargándose de asociar el objeto Property con el usuario con rol de "Propietario" que está realizando la petición


#### Archivos o capas que se prevé modificar

- Capa de Dominio: rental_platform/domain/Property.java (Nueva entidad).
- Capa de Persistencia: rental_platform/repository/PropertyRepository.java (Nueva interfaz).
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

- [ ] Repositorio abierto
- [ feature/02-issue-13-alta-propiedades] Rama correcta
- [ ] `AGENTS.md` y skills aplicables
- [ ] Issue y criterios de aceptación
- [ ] Código existente relevante
- [ ] Estructura Maven / Spring Boot (Archivos: Property.java, PropertyRepository.java, PropertyService.java, PropertyController.java)

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
Genera el código para la entidad (Property.java), el repositorio JPA (PropertyRepository.java), el servicio con la lógica de guardado (PropertyService.java) y el controlador REST/MVC (PropertyController.java).

#### Plan propuesto por el agente

Representar tipo de anuncio (vivienda/habitación), descripción, dirección, precio por noche, comodidades y modalidad de reserva en Property, con restricciones apropiadas y persistencia JPA.
Implementar repositorio y servicio para validar y guardar el anuncio, evitando lógica de negocio en el controlador.
Crear el flujo web para capturar y enviar el formulario; exigir los campos obligatorios tanto en servidor como en la interfaz y mostrar errores de validación/resultado.
Añadir pruebas para validación, persistencia y flujo web; ejecutar mvnw.cmd test y mvnw.cmd package.

**Archivos o componentes propuestos:**

- Dominio/persistencia: Property.java, PropertyRepository.java y application.properties.

- Caso de uso/web: PropertyService.java, PropertyController.java, home.html y posiblemente una plantilla Thymeleaf de formulario/confirmación.

- Verificación y dependencias: RentalPlatformApplicationTests.java y pom.xml; añadiría pruebas dirigidas por capa según las convenciones existentes.

- Documentación técnica si se incorpora una decisión de modelo: technical.md.


### 5. Revisión humana del plan

En el archivo propertiesform cambiado en el html, hemos simplificado la interacción persona ordenador mejorando el affordance y usabilidad

el agente queria quitar el campo City, necesario para una buena exactitud del formulario



#### Cambios solicitados antes de implementar

- mantener el campo de City porque es necesario y el agente queria eliminarlo.
- confirmar el uso que es necesario del BigDecimal


#### Plan final aprobado

1.  
2.  
3.  
4.  

---

### 6. Implementación y revisión del código

#### Cambios principales

| Archivo / componente | Cambio realizado | Motivo |
|---|---|---|
|  |  |  |
|  |  |  |
|  |  |  |

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
|  |  |
|  |  |

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
- [ ] La funcionalidad puede ejecutarse desde la interfaz o endpoint previsto.

#### Comprobación funcional

**Caso válido**

- **Entrada / acción:**  
- **Resultado esperado: Mensaje de exito en la alta de la propiedad y la informacion en la fila de base de datos**  

- **Resultado obtenido: Mensaje de exito en la alta de la propiedad y la informacion en la fila de base de datos**  

**Caso inválido o error controlado**

- **Entrada / acción:**  
- **Resultado esperado:**  
- **Resultado obtenido:**  

#### Persistencia, si procede

- **Qué se comprobó: Qué se comprobó: Se consultó la consola H2 / Base de datos (SELECT * FROM property**  
- **Resultado: La fila se insertó correctamente con todos los valores mapeados**  

#### Revisión final del cambio

```powershell
git status
git diff
```

- [ ] Solo aparecen cambios relacionados con la issue.
- [ ] El equipo ha revisado y comprende el diff.
- [ ] No hay archivos generados, temporales o ajenos.

---

### 8. Evidencias

| Evidencia | Captura / enlace |
|---|---|
| Plan propuesto por el agente |  |
| Revisión / cambio humano relevante |  |
| Funcionalidad ejecutada |  |
| Verificación / persistencia, si procede |  |
| Pull Request |  |

---

### 9. Pull Request y cierre

- **PR:**  
- **Issue vinculada:**  
- **Revisor/a:**  
- **Estado:** Abierta / En revisión / Aprobada / Integrada  

#### Revisión de la PR

- [ ] Alcance correcto.
- [ ] Diseño y separación por capas revisados.
- [ ] Build correcto.
- [ ] Persistencia y validaciones revisadas, si procede.
- [ ] Documentación actualizada.
- [ ] Uso de IA declarado.
- [ ] Deuda técnica, limitaciones o cuestiones pendientes identificadas.

#### Observaciones del revisor

- 
- 

---

### 10. Conclusión y defensa

#### Conclusión

- **Qué aportó el agente:**  
- **Qué tuvo que revisar o corregir el equipo:**  
- **Qué propuesta no debía aceptarse directamente:**  
- **Qué decisión humana fue más importante:**  
- **Cómo se verificó:**  

#### Estado final

- [ ] Issue implementada.
- [ ] Build correcto.
- [ ] Funcionalidad verificada.
- [ ] Persistencia comprobada, si procede.
- [ ] Diff revisado.
- [ ] Evidencias completadas.
- [ ] PR revisable.
- [ ] Documentación actualizada cuando corresponde.

#### Resumen breve para defensa

**Issue:**  
**Qué hizo el agente:**  
**Qué modificó o rechazó el equipo:**  
**Cómo se verificó:**  
**Conclusión:**  

---

#### Regla final

> **La IA puede proponer e implementar cambios, pero no puede aprobar su propio trabajo.**
>
> El equipo es responsable de comprender, revisar, verificar y justificar todo lo que se integra en el proyecto.
