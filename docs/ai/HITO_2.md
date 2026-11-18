# AI-02 — Hito 2 · Pruebas y verificación con IA agéntica

> **Ingeniería del Software II · Laboratorio 2026-2027**
>
> Esta ficha documenta el **Hito 2 de IA agéntica**, centrado exclusivamente en la revisión, mejora y verificación de una prueba automatizada propuesta por IA.
>
> Se completa progresivamente durante **S6 y S7**. La sesión **S8 (Sonar y gestión de la calidad)** pertenece a la dimensión de Calidad y prepara evidencias que podrán alimentar posteriormente el **Hito 3 · Mantenimiento de la calidad**, pero **no forma parte del Hito 2**.

---

## 1. Identificación

- **Equipo / empresa:Groundbnb** 
- **Integrantes: Ángel Leonardo Curiel Cañizalez, Pablo Dalda Sánchez, Pedro Jesús de los Reyes Cabañas, Nuria Sanhonorato Ruiz y Nicolás Carlos Vladila Nastasoiu.** 
- **Repositorio: https://github.com/NCVN06/Groundbnb**  
- **Issue / requisito relacionado: Issue #13 — Alta de propiedades. Caso CP-02 del plan de pruebas**  
- **Criterio o comportamiento protegido: Un formulario de alta incompleto debe rechazarse mostrando errores de validación y sin persistir una nueva propiedad.**  
- **Responsable principal del Hito 2:Nuria Sanhonorato**  
- **Participantes y contribución de cada uno: (PENDIENTE) Ángel Leonardo Curiel Cañizalez: tests, Pablo Dalda Sánchez: creación del test PropertyAddressTests.java, Pedro Jesús de los Reyes Cabañas: Documentación, Nuria Sanhonorato Ruiz : Documentación , Nicolás Carlos Vladila Nastasoiu: Documentación**  

---

## 2. Diseño humano previo

> Completar antes de pedir al agente una propuesta de prueba.

- **Caso relacionado de `docs/testing/TEST_PLAN.md`, si procede:** CP-02 — Alta de propiedades con datos inválidos 
- **Entrada / situación:** Enviar una petición POST a `/properties` con el formulario vacío, sin proporcionar los campos obligatorios. 
- **Resultado esperado:** El servidor devuelve la vista `property-form`, informa de errores de validación en los campos obligatorios y no aumenta el número de propiedades almacenadas.
- **Tipo de caso:** Inválido  
- **Qué defecto debería detectar una buena prueba:** Que el sistema acepte un registro incompleto, omita validaciones obligatorias o persista una propiedad pese a haber rechazado el formulario. 
- **Qué aserción o resultado observable debería comprobar:** Respuesta HTTP 200 y vista `property-form`; errores asociados a `propertyForm` en los campos obligatorios; mismo número de propiedades en el repositorio antes y después de la petición.

### Contexto proporcionado al agente

- [ ] Repositorio abierto.
- [ ] `AGENTS.md` y skill de revisión de pruebas aplicable.
- [ ] Issue / criterio de aceptación.
- [ ] `docs/testing/TEST_PLAN.md`.
- [ ] Código de producción relevante.
- [ ] Pruebas existentes relacionadas.

**Herramienta / agente:**  

**Prompt principal:**

```text
Revisa AGENTS.md, la issue #13, docs/testing/TEST_PLAN.md,
PropertyRegistrationTests.java y el código de producción relacionado.

El equipo ha seleccionado CP-02: rechazar un formulario de alta
incompleto sin crear una propiedad.

Propón una prueba JUnit de integración/web que proteja ese criterio.
Identifica datos de entrada, resultado esperado, aserciones y el
posible defecto que detectaría. Analiza si el test existente es
suficiente y si conviene complementarlo con un caso inválido concreto.

No modifiques archivos. Espera aprobación humana.
```

---

## 3. Propuesta inicial de la IA

### Prueba propuesta

- **Clase / método:** `PropertyRegistrationTests.shouldRejectIncompletePropertyWhenTitleIsBlank()` (método nuevo propuesto, **no implementado todavía**).  
- **Datos de prueba:**  petición POST a `/properties` con `title = " "` (solo un espacio); `description = "Casa junto al parque"`, `streetType = "Calle"`, `streetName = "Mayor"`, `number = "10"`, `postalCode = "45001"`, `city = "Toledo"`, `province = "Toledo"`, `pricePerNight = "85.50"`, `amenities = "Wi-Fi, cocina"`, `type = "HOME"` e `instantBooking = "true"`.
- **Aserciones:** respuesta HTTP 200 (`status().isOk()`), vista `property-form`, error de validación específico `model().attributeHasFieldErrors("propertyForm", "title")` y `propertyRepository.count()` sin cambios respecto al valor anterior a la petición.
- **Qué pretende comprobar:** que un título obligatorio formado solo por espacios se rechaza aunque los demás datos sean válidos, y que la propiedad no se persiste.
- **Tipo de prueba:** integración / web, caso inválido aislado, vinculado al CP-02 y a la issue #13.

**Código propuesto por la IA (sin aplicar todavía):**

```java
@Test
void shouldRejectIncompletePropertyWhenTitleIsBlank() throws Exception {
    // Arrange
    long propertyCountBeforeRequest = propertyRepository.count();

    // Act + Assert web
    mockMvc.perform(post("/properties")
            .param("title", " ")
            .param("description", "Casa junto al parque")
            .param("streetType", "Calle")
            .param("streetName", "Mayor")
            .param("number", "10")
            .param("postalCode", "45001")
            .param("city", "Toledo")
            .param("province", "Toledo")
            .param("pricePerNight", "85.50")
            .param("amenities", "Wi-Fi, cocina")
            .param("type", "HOME")
            .param("instantBooking", "true"))
        .andExpect(status().isOk())
        .andExpect(view().name("property-form"))
        .andExpect(model().attributeHasFieldErrors("propertyForm", "title"));

    // Assert persistence
    assertThat(propertyRepository.count())
        .isEqualTo(propertyCountBeforeRequest);
}
```

### Resultado de la inspección y ejecución inicial realizada por la IA

El agente informó de que la issue #13 exige impedir el alta si faltan campos obligatorios. Señaló que `PropertyForm.java` contiene las restricciones y que `PropertyController.java` interrumpe el flujo antes de crear la propiedad cuando existen errores de validación.

El agente ejecutó `./mvnw.cmd -Dtest=PropertyRegistrationTests test` (en Windows: `.\mvnw.cmd -Dtest=PropertyRegistrationTests test`) y comunicó **`BUILD FAILURE`**, con dos fallos relacionados con el formulario antiguo:

1. `shouldRejectPropertyWhenDataIsInvalid`: espera un error en `address`, campo que ya no existe como tal en el formulario actual.
2. `shouldCreatePropertyWhenDataIsValid`: envía el parámetro antiguo `address`; por ello recibe HTTP 200 en lugar de la redirección esperada.

Según el agente, `PropertyAddressTests.requiredAddressComponentsAreValidatedBeforePersisting` ya comprueba un caso inválido de `streetName` vacío, pero no sustituye una comprobación específica del título para CP-02.

**Alcance de esta evidencia:** resultado comunicado por el agente en la conversación; 

**PENDIENTE** adjuntar captura o informe Surefire de la ejecución. Este fallo por desactualización **no es** la demostración de defecto deliberado verde → rojo → verde.


### Valoración inicial del equipo

- **¿Protege realmente el criterio seleccionado?:** **Sí, de forma específica**, porque comprueba un campo obligatorio y la ausencia de persistencia.
- **¿Los datos de entrada son adecuados?:** **Sí, en principio**; los demás campos se presentan como válidos. Confirmar con ejecución real que no generan otros errores. 
- **¿Las aserciones son significativas?:** **Sí**; cubren respuesta, vista, error del campo y persistencia.  
- **¿Incluye los casos límite relevantes?:** **Parcial**; prueba título con solo espacios, pero no cubre todas las variantes inválidas ni todos los campos.  
- **¿Podría pasar aunque exista un defecto importante?:** **Sí**; una validación defectuosa de otro campo podría quedar sin detectar, por lo que se conserva el resto del conjunto de pruebas.  
---

## 4. Revisión humana y mejora

### Carencia detectada

-  

### Cambio realizado

-  

### Motivo del cambio

-  

### Defecto que ahora puede detectar

-  

### Decisión sobre la propuesta

- [ ] Aceptada sin cambios.
- [ ] Modificada.
- [ ] Rechazada y sustituida por otra propuesta.

**Justificación:**

-  

---

## 5. Verificación de la prueba

### Ejecución reproducible

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

- **Resultado:**  

### Defecto deliberado

- **Defecto introducido:**  
- **Resultado esperado con el defecto:**  
- **¿La prueba falló?:** Sí / No  
- **Qué demuestra ese fallo:**  
- **Corrección realizada:**  
- **Resultado tras corregir:**  

### Evidencia mínima obligatoria

- **Prueba propuesta por IA:**  
- **Carencia detectada:**  
- **Cambio realizado:**  
- **Motivo:**  
- **Defecto que ahora puede detectar:**  
- **Resultado de ejecución:**  

---

## 6. Verificación automatizada y cobertura · S7

> En S7 se completa la parte de verificación del Hito 2 y se actualiza también `docs/testing/TEST_PLAN.md` con la ejecución reproducible, la cobertura observada y la decisión tomada a partir de esa evidencia.

- [ ] Las pruebas se ejecutan correctamente mediante Maven / Surefire.
- [ ] El build completo es reproducible.
- [ ] Se ha generado el informe de cobertura con JaCoCo.
- [ ] La cobertura se ha interpretado en relación con requisitos, casos de prueba y defectos.
- [ ] Se han identificado zonas relevantes poco ejercitadas cuando proceda.
- [ ] Se ha decidido si hace falta añadir, mejorar o mantener una prueba sin cambios.
- [ ] La decisión adoptada se ha reflejado en `docs/testing/TEST_PLAN.md`.
- [ ] La prueba trabajada en el Hito 2 sigue siendo válida dentro del conjunto completo.

### Evidencia de verificación S7

- **Resultado Maven / Surefire:**  
- **Zona de cobertura revisada:**  
- **Carencia o riesgo detectado, si existe:**  
- **Decisión tomada:** Añadir prueba / Mejorar prueba / Mantener y justificar  
- **Actualización realizada en `docs/testing/TEST_PLAN.md`:**  
- **Evidencia enlazada:**  

### Decisiones tomadas a partir de la ejecución y cobertura

-  
-  

> **Cobertura alta no implica automáticamente buenas pruebas.** La evidencia debe demostrar capacidad real para detectar defectos relevantes.

---

## 7. Evidencias

| Evidencia | Captura / enlace |
|---|---|
| Propuesta inicial de prueba por IA |  |
| Revisión / carencia detectada |  |
| Mejora realizada por el equipo |  |
| Defecto deliberado y ejecución |  |
| Resultado Maven / Surefire |  |
| Cobertura JaCoCo interpretada |  |

---

## 8. Conclusión y defensa

### Conclusión

- **Qué aportó la IA:**  
- **Qué tuvo que revisar o corregir el equipo:**  
- **Qué decisión humana fue más importante:**  
- **Qué defecto puede detectar ahora la prueba:**  
- **Cómo se verificó:**  

### Estado final

- [ ] Prueba IA revisada críticamente.
- [ ] Carencia identificada.
- [ ] Mejora aplicada o rechazo justificado.
- [ ] Defecto deliberado detectado.
- [ ] Build y pruebas correctos.
- [ ] Ejecución reproducible con Maven / Surefire.
- [ ] Cobertura JaCoCo interpretada.
- [ ] Evidencias completadas.

### Resumen breve para defensa

**Prueba seleccionada:**  
**Carencia detectada:**  
**Cambio realizado:**  
**Defecto que ahora detecta:**  
**Resultado de ejecución:**  
**Decisión tomada a partir de la cobertura:**  
**Conclusión:**  

---

### Regla final

> **La IA puede proponer una prueba, pero el equipo debe revisar si protege realmente el comportamiento esperado, mejorarla cuando sea necesario y demostrar mediante ejecución reproducible que detecta el defecto que afirma proteger.**
>
> La evidencia de **Sonar y calidad** se trabaja fuera de este hito y se incorpora al **Hito 3 · Mantenimiento de la calidad** cuando corresponda.
