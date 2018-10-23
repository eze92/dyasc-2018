Repositorio de Ezequiel Ledesma
=============

[![Build Status](https://travis-ci.org/eze92/dyasc-2018.svg?branch=master)](https://travis-ci.org/eze92/dyasc-2018)


La carpeta ejercicio_base contiene un ejemplo de lo que es el punto de partida para los demás ejercicios. O sea que para cada nuevo ejercicio debe copiarse la carpeta ejercicio0.

Este proyecto es un ejemplo para tomar como base para los distintos proyecto de la materia. El proyecto está basado en Maven 3 y ya cuenta con un conjunto de herramientas preconfiguradas:

* JUnit
* Cucumber-JVM
* Cobertura
* PMD
* CheckStyle

## Comandos:

* Para compilar y correr los tests: mvn clean test
* Para generar un paquete jar ejecutable: mvn clean package. El package resultante se encontrará en el directorio target con el nombre que haya sido especificado en el finalName del pom.xml.
* Para correr los tests y medir la cobertura: mvn clean cobertura:cobertura. El reporte resultante se encontrará en target/site/cobertura/index.html.
* Para verificar el estilo con CheckStyle: mvn clean checkstyle:checkstyle. El reporte resultante se encontrará en target/site/checkstyle.html
