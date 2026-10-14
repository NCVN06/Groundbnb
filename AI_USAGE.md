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
