Repositorio de Ezequiel Ledesma
=============

[![Build Status](https://travis-ci.org/eze92/dyasc-2018.svg?branch=master)](https://travis-ci.org/eze92/dyasc-2018)

## Entrega 1
Desarrollar un toolkit de Logging ( de eventos que pueda ser utilizado para registrar el flujo de eventos en un programa.

Deberá soportar registrar eventos como mensajes de texto, agregando la fecha y hora del mismo.

Se pide la clase Bitacora y una clase Ejemplo con un programa principal que  ejemplique el uso de la bitácora.

La Bitácora debe generar los registros por pantalla.

## Entrega 2
Modificar la Bitácora para que además de en la pantalla envíe los registros a un archivo, por default llamado bitacora.txt.

## Entrega 3
Modificar la bitácora para que según el valor de la variable de entorno bitacora.destino envíe los registros a la CONSOLA o al archivo bitacora.txt.

+ La variable bitacora.destino=CONSOLA deberá enviar los registros a la consola.
+ La variable bitacora.destino=[nombrearchvo] , por ejemplo, bitacora.txt, deberá enviarlo al archivo.

Ejemplo

+ java -Dbitacora.destino=bitacora.txt Ejemplo

## Entrega 4

+ Deberá soportar ambos valores separados por comas para la variable bitacora.destino.

Ejemplos 1

+ java -Dbitacora.destino=bitacora.txt Ejemplo

Ejemplo 2

+ java -Dbitacora.destino=bitacora.txt, CONSOLA Ejemplo

## Entrega 5

¿Cómo mejoraría la configuración de salida para los registros manteniendo la variable bitacora.destino?
Implemente una solución mejorada.
