# TEST_PLAN — Plan de Pruebas del Proyecto

> **Ingeniería del Software II · Laboratorio 2026-2027**  
> Este documento recoge la estrategia global de pruebas del proyecto y se actualiza progresivamente durante las sesiones S6–S8 y el resto del desarrollo.
>
> **Es un único documento para todo el proyecto.** No debe duplicarse por cada issue, historia de usuario o prueba. Los casos y pruebas relevantes se registran de forma resumida en las tablas y solo se documentan con mayor detalle cuando exista una decisión, carencia, defecto o evidencia especialmente significativa.
>
> El objetivo no es maximizar el número de tests ni alcanzar un porcentaje aislado de cobertura, sino comprobar comportamientos relevantes mediante pruebas comprensibles, reproducibles y capaces de detectar defectos.

---

## 1. Identificación

- **Equipo / empresa:**  Groundbnb
- **Repositorio:** github.com/NCVN06/Groundbnb
- **Versión del documento:** 0.1  
- **Responsable de mantener el plan:** Pedro Jesús
- **Sprint / iteración actual:** 5  
- **Última actualización:** 04/11/2026 

---

## 2. Estrategia general de pruebas

### Objetivo

> Indicar brevemente qué pretende conseguir el equipo con las pruebas automatizadas y qué comportamientos considera prioritario proteger.

### Prioridades actuales

- Flujos funcionales críticos.
- Reglas de negocio relevantes.
- Validaciones y errores controlados.
- Persistencia y consultas significativas.
- Comportamientos propensos a fallo.
- Funcionalidades modificadas o susceptibles de regresión.

### Tipos de prueba utilizados

| Tipo | Cuándo se utiliza | Ejemplos en el proyecto |
|---|---|---|
| Unitaria | Para comprobar una clase, método o regla de negocio de forma aislada |  |
| Integración | Para comprobar la colaboración entre varios componentes o con persistencia |  |
| Web / controlador | Para comprobar rutas, formularios o respuestas cuando aporte valor |  |

> El equipo no tiene que utilizar todos los tipos de prueba en todas las funcionalidades. Debe seleccionar el nivel de prueba adecuado al comportamiento que quiere proteger.

---

## 3. Funcionalidades y comportamientos prioritarios

> Registrar aquí los principales flujos o comportamientos que el equipo considera relevantes para probar. No es necesario incluir todas las issues del proyecto.

| ID | Funcionalidad / comportamiento | Issue o requisito relacionado | Motivo de prioridad | Estado de pruebas |
|---|---|---|---|---|
| FP-01 |  |  |  | Pendiente / Parcial / Cubierto |
| FP-02 |  |  |  | Pendiente / Parcial / Cubierto |
| FP-03 |  |  |  | Pendiente / Parcial / Cubierto |

---

## 4. Catálogo de casos de prueba

> Los casos se diseñan primero en lenguaje natural. Después, cuando proceda, se automatizan con JUnit.

| ID | Funcionalidad | Criterio protegido | Tipo de caso | Entrada / situación | Resultado esperado | Prioridad |
|---|---|---|---|---|---|---|
| CP-01 |  |  | Válido |  |  | Alta / Media / Baja |
| CP-02 |  |  | Inválido |  |  | Alta / Media / Baja |
| CP-03 |  |  | Límite |  |  | Alta / Media / Baja |

### Convención

- **Válido:** comprueba comportamiento esperado con datos correctos.
- **Inválido:** comprueba que una entrada o situación incorrecta se trata de forma controlada.
- **Límite:** comprueba valores frontera o casos especialmente sensibles.
- **Regresión:** protege un comportamiento ante cambios futuros.

---

## 5. Particiones de equivalencia y valores límite

> Utilizar esta sección únicamente en los comportamientos donde estas técnicas aporten valor. No es necesario rellenarla para cada prueba.

### Particiones de equivalencia

| Dato / condición | Partición válida | Partición inválida | Casos asociados |
|---|---|---|---|
|  |  |  |  |
|  |  |  |  |

### Valores límite

| Dato / condición | Valores límite relevantes | Comportamiento esperado | Casos asociados |
|---|---|---|---|
|  |  |  |  |
|  |  |  |  |

---

## 6. Pruebas automatizadas implementadas

> Relacionar los casos diseñados con las pruebas JUnit existentes. Una prueba puede cubrir uno o varios casos relacionados si está justificado.

| ID caso | Clase / método JUnit | Tipo | Comportamiento protegido | Estado |
|---|---|---|---|---|
| CP-01 |  | Unitaria / Integración / Web |  | Implementada / Pendiente |
| CP-02 |  | Unitaria / Integración / Web |  | Implementada / Pendiente |

### Criterios de diseño

Las pruebas implementadas deberían, cuando resulte aplicable:

- seguir una estructura comprensible **Arrange – Act – Assert**;
- tener nombres descriptivos;
- utilizar datos de prueba claros;
- contener aserciones significativas;
- comprobar un objetivo entendible;
- fallar cuando se rompe el comportamiento protegido;
- evitar dependencias innecesarias de detalles internos;
- ser repetibles desde Maven.

---

## 7. Revisión de calidad de las pruebas

> Esta sección sirve para revisar el conjunto de pruebas, no para crear una ficha por cada test.

### Checklist general

- [ ] Las pruebas están relacionadas con requisitos, criterios o comportamientos relevantes.
- [ ] Existen casos válidos, inválidos y límite cuando corresponda.
- [ ] Las aserciones comprueban resultados significativos.
- [ ] Las pruebas pueden fallar ante defectos reales relacionados con el comportamiento protegido.
- [ ] No existen pruebas vacías o que siempre pasen.
- [ ] No se mezclan demasiados objetivos no relacionados en una misma prueba.
- [ ] Se han detectado y corregido pruebas frágiles cuando ha sido necesario.
- [ ] El equipo comprende qué protege cada prueba relevante.
- [ ] Las pruebas pueden ejecutarse de forma reproducible con Maven.

### Pruebas frágiles, débiles o poco significativas detectadas

| Prueba | Problema detectado | Decisión | Estado |
|---|---|---|---|
|  |  | Modificar / Dividir / Eliminar / Mantener justificada | Pendiente / Resuelto |
|  |  |  |  |

---

## 8. Defecto deliberado — Evidencia S6

> Durante S6 el equipo debe introducir de forma controlada al menos un defecto para comprobar si una prueba es capaz de detectarlo.

- **Prueba seleccionada:**  
- **Comportamiento protegido:**  
- **Defecto introducido:**  
- **Resultado esperado:**  
- **¿La prueba falló?:** Sí / No  
- **Corrección realizada:**  
- **Resultado después de corregir:**  

### Evidencia de ejecución

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

- **Resultado antes del defecto:**  
- **Resultado con el defecto:**  
- **Resultado tras la corrección:**  

> La finalidad no es romper el proyecto sin motivo, sino demostrar que la prueba puede detectar el defecto que afirma proteger.

---

## 9. Ejecución reproducible del conjunto de pruebas

### Comandos de referencia

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

### Estado actual

- [ ] El conjunto de pruebas puede ejecutarse desde Maven.
- [ ] El build completo finaliza correctamente.
- [ ] Los fallos existentes están identificados y documentados.
- [ ] No existen pruebas deshabilitadas o eliminadas únicamente para obtener un build verde.

### Última ejecución

- **Fecha:**  
- **Resultado:**  
- **Incidencias:**  

---

## 10. Verificación y relación con cobertura y calidad

> Esta sección se completa progresivamente durante S7 y S8.
>
> **Importante:** la cobertura y Sonar aportan evidencias complementarias, pero no sustituyen el diseño de buenos casos de prueba. El **Hito 2** se cierra en **S7** con pruebas y verificación automatizada; Sonar pertenece a la dimensión de **Calidad** y prepara información para el mantenimiento posterior.

### 10.1 Verificación — S7 · Maven y Surefire

> Registrar aquí la evidencia mínima de que el conjunto de pruebas puede ejecutarse de forma reproducible fuera del IDE.

- **Fecha de verificación:**  
- **Rama / commit verificado:**  
- **Comandos ejecutados:**

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

- **Resultado de `test`:**  
- **Resultado de `verify`:**  
- **Número de tests ejecutados:**  
- **Fallos o errores relevantes:**  
- **Informe Surefire revisado:** `target/surefire-reports/`  
- **Evidencia / enlace:**  

### 10.2 Cobertura — S7 · JaCoCo

- **Informe generado:** `target/site/jacoco/index.html`  
- **Cobertura observada de forma global:**  
- **Clase / paquete / comportamiento revisado:**  
- **Zonas importantes con cobertura insuficiente:**
  - 
  - 

- **Ramas o casos relevantes no ejercitados:**
  - 
  - 

- **Justificación de zonas no cubiertas cuando proceda:**
  - 
  - 

> No se exige perseguir un porcentaje concreto por sí mismo. La cobertura debe interpretarse en relación con comportamientos, requisitos, casos de prueba y riesgos reales.

### 10.3 Interpretación y decisión — S7

> La cobertura debe provocar una decisión técnica explícita, aunque la decisión sea no añadir ninguna prueba.

- **Carencia o riesgo detectado:**  
- **Caso(s) del plan afectados:**  
- **Decisión:** Añadir prueba / Mejorar prueba / Mantener sin cambios / Justificar no cobertura  
- **Cambio realizado:**  
- **Motivo:**  
- **Resultado tras repetir `test` / `verify`:**  
- **Relación con AI-02, si procede:**  
- **Evidencia / enlace:**  

### 10.4 Sonar — S8 · Contexto para nuevas necesidades de prueba

- Problemas o incidencias que sugieren añadir o revisar pruebas:
  - 
  - 

- Pruebas añadidas o modificadas como consecuencia del análisis de calidad:
  - 
  - 

> **La cobertura no se interpreta como un objetivo aislado.** Debe relacionarse con requisitos, casos de prueba, defectos que se pretende detectar y zonas relevantes del código.

---

## 11. Pendientes y evolución del plan

| Pendiente / mejora | Motivo | Prioridad | Responsable | Estado |
|---|---|---|---|---|
|  |  |  |  | Pendiente |
|  |  |  |  | Pendiente |

El plan debe actualizarse cuando:

- se incorporen nuevas funcionalidades relevantes;
- cambien criterios o reglas de negocio;
- se detecten defectos significativos;
- se añadan o eliminen pruebas importantes;
- se detecten pruebas frágiles;
- JaCoCo muestre zonas relevantes no ejercitadas;
- la verificación S7 produzca una decisión sobre añadir, mejorar o justificar pruebas;
- Sonar revele nuevas necesidades de verificación;
- cambie la estrategia de pruebas del equipo.

---

## 12. Resumen del estado de pruebas

> Completar en 3–5 líneas y mantenerlo actualizado.

- **Principales comportamientos protegidos:**  
- **Pruebas automatizadas relevantes:**  
- **Carencias actuales:**  
- **Próxima prioridad de pruebas:**  
- **Estado general:** Pendiente / En progreso / Suficiente para la iteración
