# AI-02 — Hito 2 · Pruebas y verificación con IA agéntica

> **Ingeniería del Software II · Laboratorio 2026-2027**
>
> Esta ficha documenta el **Hito 2 de IA agéntica**, centrado exclusivamente en la revisión, mejora y verificación de una prueba automatizada propuesta por IA.
>
> Se completa progresivamente durante **S6 y S7**. La sesión **S8 (Sonar y gestión de la calidad)** pertenece a la dimensión de Calidad y prepara evidencias que podrán alimentar posteriormente el **Hito 3 · Mantenimiento de la calidad**, pero **no forma parte del Hito 2**.

---

## 1. Identificación

- **Equipo / empresa:**  
- **Integrantes:**  
- **Repositorio:**  
- **Issue / requisito relacionado:**  
- **Criterio o comportamiento protegido:**  
- **Responsable principal del Hito 2:**  
- **Participantes y contribución de cada uno:**  

---

## 2. Diseño humano previo

> Completar antes de pedir al agente una propuesta de prueba.

- **Caso relacionado de `docs/testing/TEST_PLAN.md`, si procede:**  
- **Entrada / situación:**  
- **Resultado esperado:**  
- **Tipo de caso:** Válido / Inválido / Límite / Regresión  
- **Qué defecto debería detectar una buena prueba:**  
- **Qué aserción o resultado observable debería comprobar:**  

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
[Incluir el prompt utilizado o una versión resumida fiel.]
```

---

## 3. Propuesta inicial de la IA

### Prueba propuesta

- **Clase / método:**  
- **Datos de prueba:**  
- **Aserciones:**  
- **Qué pretende comprobar:**  
- **Tipo de prueba:** Unitaria / Integración / Web / Otra  

### Valoración inicial del equipo

- **¿Protege realmente el criterio seleccionado?:** Sí / No / Parcial  
- **¿Los datos de entrada son adecuados?:** Sí / No / Parcial  
- **¿Las aserciones son significativas?:** Sí / No / Parcial  
- **¿Incluye los casos límite relevantes?:** Sí / No / No aplica  
- **¿Podría pasar aunque exista un defecto importante?:** Sí / No  

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
