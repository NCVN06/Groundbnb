# Registro de uso de IA

Este documento recoge los usos relevantes de inteligncia artificial realizados durante el proyecto.

## Principios

- La IA puede proponer, pero el equipo decide.
- Todo cambio debe ser comprendido y revisado.
- Las propuestas deben verificarse mediante las herramientas correspondientes.
- No se integrará código generado por IA sin revisión humana.

## AI-01 — Hito 1 · Implementación de una issue funcional

> **Ingeniería del Software II · Laboratorio 2026-2027**
>
> Esta ficha documenta la ejecución del **Hito 1 de IA agéntica**.
>
> El objetivo es dejar evidencia de cómo el equipo utiliza un agente para apoyar la implementación de una issue funcional, qué revisa o modifica antes de aceptar la propuesta y cómo verifica el resultado.

---

### 1. Identificación

- **Equipo / empresa:**  
- **Integrantes:**  
- **Repositorio:**  
- **Issue relacionada:**  
- **Historia de usuario:**  
- **Rama de trabajo:**  
- **Responsable principal del Hito 1:**  
- **Participantes y contribución de cada uno:**  

---

### 2. Alcance de la issue

#### Objetivo

<!-- Explicar en 3-5 líneas qué funcionalidad se pretende implementar. -->



#### Criterios de aceptación relevantes

- [ ]  
- [ ]  
- [ ]  
- [ ]  

#### Fuera de alcance

- 
- 
- 

---

### 3. Plan humano previo

> Completar antes de pedir al agente que proponga su solución.

#### Plan inicial del equipo

1.  
2.  
3.  
4.  

#### Archivos o capas que se prevé modificar

- 
- 
- 

#### Dependencias, supuestos o dudas

- 
- 
- 

#### Cómo se comprobará que funciona

- 
- 
- 

---

### 4. Contexto y propuesta del agente

#### Contexto proporcionado

- [ ] Repositorio abierto
- [ ] Rama correcta
- [ ] `AGENTS.md` y skills aplicables
- [ ] Issue y criterios de aceptación
- [ ] Código existente relevante
- [ ] Estructura Maven / Spring Boot
- [ ] Otro:  

**Herramienta / agente:**  
**Entorno:**  
**Modelo, si procede:**  

#### Prompt principal

```text
[Incluir el prompt utilizado o una versión resumida fiel.]
```

#### Plan propuesto por el agente

1.  
2.  
3.  
4.  

**Archivos o componentes propuestos:**

- 
- 
- 

---

### 5. Revisión humana del plan

| Propuesta del agente | Decisión | Justificación |
|---|---|---|
|  | Aceptada / Modificada / Rechazada |  |
|  | Aceptada / Modificada / Rechazada |  |
|  | Aceptada / Modificada / Rechazada |  |

#### Cambios solicitados antes de implementar

- 
- 

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

- [ ] Los cambios pertenecen a la issue.
- [ ] No se ha ampliado innecesariamente el alcance.
- [ ] La separación por capas se mantiene.
- [ ] La lógica de negocio no se concentra en el controlador.
- [ ] Las entidades y relaciones JPA se pueden justificar, si procede.
- [ ] Las validaciones y errores son controlados.
- [ ] No se han añadido archivos temporales o ajenos.
- [ ] El equipo comprende los cambios realizados.

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

- [ ] `BUILD SUCCESS`
- [ ] Fallo

**Observaciones:**  



#### Ejecución de la funcionalidad

```powershell
.\mvnw.cmd spring-boot:run
```

- [ ] La aplicación arranca correctamente.
- [ ] La funcionalidad puede ejecutarse desde la interfaz o endpoint previsto.

#### Comprobación funcional

**Caso válido**

- **Entrada / acción:**  
- **Resultado esperado:**  
- **Resultado obtenido:**  

**Caso inválido o error controlado**

- **Entrada / acción:**  
- **Resultado esperado:**  
- **Resultado obtenido:**  

#### Persistencia, si procede

- **Qué se comprobó:**  
- **Resultado:**  

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
