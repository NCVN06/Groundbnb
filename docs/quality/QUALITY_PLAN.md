# Plan de Calidad — Versión inicial

> **Objetivo:** definir de forma preliminar qué entendemos por calidad en el proyecto, qué problemas, limitaciones y deuda técnica conocemos y qué acciones se irán realizando durante su evolución.

Esta versión inicial se prepara antes de la entrega intermedia con carácter formativo. **El Plan de Calidad se evaluará íntegramente en la entrega final**, una vez incorporadas las evidencias de Sonar y la evolución del proyecto.

## 1. Identificación

- **Equipo / empresa: Groundbnb**  
- **Fecha:14/10/2026** 
- **Versión del documento:** 0.3
- **Responsable de mantener el plan: Nuria** 
- **Sprint actual del equipo:** Sprint 3 

---

## 2. Alcance del Plan de Calidad

Este plan se aplica al estado actual del proyecto y se irá actualizando a medida que se incorporen nuevas técnicas y herramientas.

En este momento se centra en:

- fiabilidad básica de los flujos funcionales;
- mantenibilidad de la arquitectura;
- coherencia entre modelo, código y documentación;
- gestión correcta de configuración e integración;
- visibilidad y seguimiento de deuda técnica, limitaciones y problemas conocidos;
- protección de credenciales y datos sensibles;
- preparación para las sesiones posteriores de pruebas, verificación automatizada, cobertura, Sonar y mantenimiento de la calidad.

> En esta versión inicial todavía no se establecen objetivos de cobertura ni resultados de Sonar, ya que estas técnicas se introducirán en sesiones posteriores.
>
> Esta versión se revisa en la entrega intermedia con finalidad formativa; la dimensión de **Calidad se evalúa al 100 % en la entrega final**.

---

## 3. Objetivos de calidad

### 3.1. Fiabilidad

Objetivo:

> Los flujos funcionales implementados deben poder ejecutarse de forma repetible y sin errores no controlados.

Criterios actuales:

- la aplicación arranca correctamente desde `main`;
- el build desde limpio finaliza correctamente;
- los datos persistentes aún no se guardan ni recuperan correctamente, pero la base de datos está implementada;
- las entradas inválidas reciben un tratamiento controlado;
- los errores conocidos no se ocultan.

---

### 3.2. Mantenibilidad

Objetivo:

> El código debe mantener una estructura comprensible y coherente con la arquitectura definida.

Criterios actuales:

- separación clara entre Controller, Service, Repository y entidades;
- la lógica de negocio no se concentra en los controladores;
- las clases y métodos tienen responsabilidades acotadas;
- las issues se mantienen con un alcance razonable;
- los cambios incluidos en una PR son comprensibles y están relacionados con su issue;
- las decisiones técnicas relevantes quedan documentadas.

---

### 3.3. Trazabilidad y configuración

Objetivo:

> Todo cambio relevante debe poder seguirse desde su requisito o issue hasta su integración.

Criterios actuales:

- cada funcionalidad relevante tiene issue;
- las ramas siguen la convención del proyecto;
- existe una Pull Request para integrar cambios;
- otra persona revisa la PR;
- `main` no recibe cambios directos injustificados;
- GitHub Project refleja el estado real del trabajo;
- la versión entregada puede identificarse y recuperarse.

---

### 3.4. Seguridad básica

Objetivo:

> El repositorio no debe contener información sensible ni configuraciones inseguras evidentes.

Criterios actuales:

- no se versionan contraseñas;
- no se versionan tokens;
- no se incluyen códigos temporales de autenticación;
- no se incluyen datos personales innecesarios;
- los archivos locales o sensibles se excluyen mediante `.gitignore` cuando corresponda.

---

### 3.5. Usabilidad mínima

Objetivo:

> La interfaz puede ser sencilla, pero debe permitir demostrar correctamente los casos de uso implementados.

Criterios actuales:

- los flujos principales son accesibles;
- los formularios muestran los campos necesarios;
- los mensajes de error son comprensibles;
- el resultado de una operación puede comprobarse;
- la demo puede repetirse desde una versión recuperada de `main`.

---

## 4. Problemas, limitaciones y aspectos pendientes

| Aspecto pendiente | Tipo | Acción prevista | Responsable | Estado |
|---|---|---|---|---|
| Persistencia | Funcional | Implementar script que simule persistencia | Nicolás | Pendiente |

> El equipo debe adaptar esta tabla a los problemas, limitaciones o dependencias reales de su proyecto. No es necesario conservar ejemplos que no apliquen.

---

## 5. Deuda técnica conocida

Registrar únicamente deuda que el equipo conoce y ha decidido posponer de forma consciente.

| Deuda técnica | Motivo por el que se pospone | Prioridad | Acción futura |
|---|---|---|---|
| Mostrar propiedades cuando la cadena de búsqueda esté vacia | No es un error que impida el funcionamiento de la aplicación | 1 | Buscar donde reside el error y solucionarlo |
|  |  |  |  |

Ejemplos posibles:

- validaciones todavía incompletas;
- manejo de errores mejorable;
- documentación pendiente;
- clases demasiado grandes;
- relaciones JPA provisionales;
- funcionalidades implementadas con una solución temporal.

> La deuda técnica no es un error oculto. Debe ser visible, justificada y planificada.

---

## 6. Criterios de revisión actuales

Antes de considerar una issue lista para integrarse, se comprobará:

- [X] tiene criterios de aceptación;
- [X] el cambio es trazable y está correctamente aislado cuando corresponde;
- [X] el código compila;
- [X] el proyecto ejecuta el build acordado;
- [X] existe una Pull Request cuando el cambio vaya a integrarse en `main`;
- [X] otra persona ha revisado el cambio;
- [X] el equipo comprende los cambios realizados;
- [X] la documentación afectada está actualizada;
- [X] el modelo está actualizado cuando corresponde;
- [X] el uso relevante de IA está declarado;
- [X] no se han incluido credenciales o datos sensibles.

---

## 7. Acciones iniciales antes de la entrega intermedia

| Acción | Responsable | Fecha límite | Estado                  |
| --- | --- | --- | --- |
| Comprobar `main` desde limpio | Nicolás | 20/10/2026 | Pendiente |
| Cerrar e integrar el Hito 1 | Nicolás | 20/10/2026 | Pendiente |
| Completar `AI-01-hito-funcional.md` | Ángel | 20/10/2026 | Hecho |
| Revisar README y documentación | Pedro Jesús | 20/10/2026 | Pendiente |
| Actualizar modelo/diagramas |Aún no aplica| - | Pendiente |
| Revisar problemas pendientes y deuda técnica | Nicolás | 20/10/2026 | Hecho |
| Identificar versión intermedia | Pablo | 20/10/2026 | Pendiente |
| Preparar demo | Nicolás | 20/10/2026 | Pendiente |

---

## 8. Preparación para el siguiente bloque de trabajo

Antes de la Sesión 6, el equipo debería identificar:

- flujos funcionales más críticos;
- comportamientos más propensos a fallo;
- entradas válidas e inválidas relevantes;
- casos límite que deberían probarse;
- zonas del código que previsiblemente necesitarán mayor verificación.

Estos elementos servirán como punto de partida para:

- **S6:** diseño e implementación de pruebas con JUnit;
- **S7:** verificación automatizada con Maven, Surefire y JaCoCo;
- **S8:** análisis de calidad con Sonar;
- **Hito 2:** pruebas y verificación con IA agéntica.

El equipo deberá incorporar estas actividades a sus propios sprints o iteraciones, de acuerdo con su planificación y estado real del proyecto.

---

## 9. Revisión del plan

Este documento debe actualizarse cuando:

- cambie el alcance del proyecto;
- aparezcan nuevos problemas, limitaciones o dependencias relevantes;
- se detecte nueva deuda técnica;
- se incorporen pruebas;
- se obtenga la línea base de Sonar;
- se introduzcan métricas o criterios nuevos;
- se cierre una acción de calidad relevante.

### Próxima revisión prevista

- **Fecha / sesión:** 04/11/2026
- **Responsable:** Nuria

---

## 10. Resumen

> En 3–5 líneas, indicar cuáles son ahora mismo los principales objetivos de calidad del equipo, qué problema o limitación considera más importante y cuál es la acción prioritaria antes de la entrega intermedia.
    Como objetivos principales de calidad, antes de la entrega intermedia, el proyecto debe ofrecer un registro de propiedades correcto y comprensible, validar los datos obligatorios, guardar la información de forma consistente y mantener la separación entre presentación, servicio y persistencia. También que los requisitos esten alineados con las evidencias de verificación.