<p align="right"><img width=10% src="https://ucema.edu.ar/themes/ucema_bootstrap/logo.svg"></p>


<h2 align="center"> TP de Programación III - Backend</h2><br>


_Trabajo práctico de Programación III, Ingeniería Infotmática, Universidad del CEMA._
_Link al Repositorio de Github: https://github.com/camicodina/progra3ucema-backend_ 

## Objetivos 📌
El objetivo de este trabajo es crear un desarrollo web completo, que comprende:

1) Un backend funcional, que implemente persistencia y exponga la información por medio de una interfaz API RestFul;

2) Un frontend funcional, que obtenga y muestre correctamente la información proporcionada por el backend.


## El desarrollo 🚀 
El proyecto es una implementación de un un foro donde alumnos y/o profesores pueden compartir material de ciencia, tecnología (ej: papers y noticias interesantes) y contenido de utilidad para las cursadas. 

El rol de profesores tiene la potestad de borrar contenido ajeno si lo considera necesario.

Funcionalidades: 
- Creación de usuarios: profesores (usuarios con permisos de administrador) y alumnos (usuarios comunes);
- Crear, borrar y listar posts asociados a etiquetas.

Diagrama de clases:
<p align="center"><img width=70% src="images/Backend - TP Programación 3.drawio.png"></p>


## Modo de Uso 📝

Paso 1: Compilar el Proyecto
> $ mvn clean install

Paso 2: Ejecutar la Aplicación
> $ mvn spring-boot:run

o bien:
> $ java -jar progra3ucemabackend.jar

Paso 3: Verificar la Ejecución
Si todo está configurado correctamente, el siguiente mensaje aparecerá en la consola:
> Progra3ucemaBackendApplication started

## Instrucciones 🦆
Esta aplicación fue creada con un set de datos de prueba iniciales.

Podemos validar que los datos de prueba se han creado correctamente de las siguientes formas:
- Verificar en la Base de Datos: Accede a tu base de datos MySQL y verifica que las tablas
- Consultar los Endpoints: usando Postman o ejecutando comandos CURL podemos realizar solicitudes HTTP a la API

```shell
# Obtener todos los posts
curl -X GET http://localhost:8081/api/muro/posts

# Obtener el perfil de un usuario
curl -X GET http://localhost:8081/api/muro/perfil/alumno1

# Obtener posts de un usuario específico
curl -X GET http://localhost:8081/api/muro/posts/alumno1
```

## Contruido con... ⚙
- Java (Spring)


---
_Author: Camila Codina_ <br>
_Licence: MIT_

