# Registro de uso de IA

Este documento recoge los usos relevantes de inteligncia artificial realizados durante el proyecto.

## Principios

- La IA puede proponer, pero el equipo decide.
- Todo cambio debe ser comprendido y revisado.
- Las propuestas deben verificarse mediante las herramientas correspondientes.
- No se integrará código generado por IA sin revisión humana.

## Hito 1 - Desarrollo funcional

> Para información más detallada consultar docs/ai/HITO_1.md

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


## Crear JavaDoc
Tu tarea es crear la documentación Javadoc completa, clara y detallada para el proyecto para todos los archivos pertinentes en java. Debes documentar el propósito de las clases, métodos, parámetros (@param), valores de retorno (@return) y excepciones (@throws), siguiendo las convenciones oficiales de Oracle. Usa las skills planteadas en el documento AGENTS.md. cualquier duda que tengas planteamela antes de hacer nada 

## Arreglar errores
### Simular persistencia
Analiza la issue #35 y el repositorio.
Antes de modificar código:

Indica qué archivos revisarías
Propón un plan de implementación
Señala dependencias, supuestos o dudas
relevantes
No hagas cambios hasta aprobar el plan.
Contexto: Java + Spring Boot + Maven,
capas domain/repository/service/web.

### Agregar enlace para volver a la pantalla de inicio
Añade la opción de volver a la pantalla de inicio desde la vista de registro de propiedades.
Antes de modificar código:

Indica qué archivos revisarías
Propón un plan de implementación
Señala dependencias, supuestos o dudas
relevantes
No hagas cambios hasta aprobar el plan.
Contexto: Java + Spring Boot + Maven,
capas domain/repository/service/web.

