# CONSULTORIO ODONTOLÓGICO  

## Descripcion General:
El proyecto consiste en un sistema para la administración de un Consultorio Odontológico. Está pensado principalmente para ser manejado por un secretario administrativo y los distintos odontólogos.

 Permite básicamente la carga de pacientes, con sus respectivos datos, tratamientos, y  asignaciones de turnos. 
 
 Posee un sistema de login para seguridad.

## Uso:
La dirección de la app es: https://consultorio-odontologico.onrender.com

El usuario de prueba es: 

##### Usuario: Admin
##### Login: 1234

 IMPORTANTE: al usarse un servidor de pruebas (Clever Cloud) se debe tener paciencia en cuanto a la carga de información ya que puede tener demoras.

## Front:
Se utiliza como base una plantilla confeccionada en Boostrap, la cuál se le da una estructura de componentes para las distintas páginas. Se utiliza JSP.

## Back:
El back se construye en base a Servlets para las distinas funciones.  Las tecnologías usadas principalmente son:

- ##### JAVA
- ##### Servlets
- ##### Docker
- ##### MySQL
- ##### JPA (EclipseLink)
- ##### JSP 

## Arquitectura:
Se sigue el modelo MVC para trabajar por capas, principalmente las de Logica y Persistencia.

## Base de Datos:
Utilización de MySQL mediante el servicio de Clever Cloud. 

## Docker:
La app se dockerizó para su posterior despliegue.

## Diagrama UML:
Se adjunta el diagrama UML donde se muestran las distintas relaciones de clases.

https://drive.google.com/file/d/13NLkbEsxkjllju42LSSjwZ-1V499CiKj/view?usp=sharing
