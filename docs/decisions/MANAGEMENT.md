# Plan de gestión

## Ramas principales
- develop -> Rama en la que se desarrolla el proyecto.
- release -> Rama de pre-producción. Aquí se testean las funcionalidades antes de pasarlas a producción.
- main -> Rama que ve el usuario/cliente (producción). Solo se hacen merges cuando se ha comprobado que el producto funciona sin fallos, o bien cuando haya fallos inesperados y se tengan que arreglar cuanto antes.

## Ramas de trabajo
Las ramas se crean con el siguiente formato de nombre:
<tipo>/<num_tipo>-nombre-descriptivo

Los tipos de ramas que usamos son los siguientes:
- feat -> Añade una funcionalidad asociada a un issue o a un sub-issue cuando este sea muy grande y haya que desglosarlo.
- fix -> Para arreglar fallos que se hayan encontrado
- docs -> Cuando se realicen cambios sobre archivos .md no asociados a un issue o fix específico.

<num_tipo> hace referencia al número de issue del tipo del que es la rama. La primera rama en la que se añada una funcionalidad tendrá el formato feat/01-funcionalidad-desarrollada, aumentando el número por cada rama que se cree de ese tipo. Esto implica que el número no está relacionado con el número de issue.

Toda Pull Request debe ser bien verificada por alguien diferente a quien haya hecho la solicitud.

## Convención de commits

Los commits deberán tener un nombre descriptivo del cambio realizado.
Cada commit contendrá cambios en un único archivo, exceptuando cambios de contenido de un archivo a otro o cambios pequeños y genéricos (como introducir documentación de código).


## Resolución de conflictos
Cuando haya conflictos, los afectados deberán ponerse en contacto para llegar a un convenio sobre qué se debe quedar y que se debe ir.