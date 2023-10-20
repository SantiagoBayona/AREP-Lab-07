# APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

Aplicación Web segura

### Prerrequisitos
- Java
- Maven
- Docker

### Instalación

1. Clonar el repositorio

```
git clone https://github.com/SantiagoBayona/AREP-Lab-07
```

2. Dentro del directorio del proyecto lo construimos e instalamos

```
mvn package
```

```
mvn clean install
```

## Ejecución

### En local

1. Corremos el servidor

```
java -cp "target/classes;target/dependency/*" org.example.HelloWorld
```

```
java -cp "target/classes;target/dependency/*" org.example.LoggedIn
```

### En la instancia ec2

A través de sftp subimos a la instancia las clases y las dependencias

![img1](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/d02c562d-c316-41e6-acb6-4ebb95582564)

Y las descomprimimos

![img2](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/8bcd8eb9-829f-4e4d-ad2f-d4766cbebdb8)

Ejecutamos las clases con los comandos

```
java -cp "./bin/classes:./bin/dependency/*" org.example.LoggedIn
```

```
java -cp "./bin/classes:./bin/dependency/*" org.example.HelloWorld
```

![img3](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/0484330e-05a6-441f-b463-f0ba3b3b71c1)

## Pruebas

Accedemos al recurso

```
https://localhost:5000/login.html
```

Iniciamos sesión

![img5](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/75792e5b-7343-493c-9daa-ec44f9f5842b)

#### Credenciales
- Username: user
- Password: password

Y vemos que la aplicación funciona correctamente

![img4](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/2738b534-07b4-4c18-94a1-d31aef086887)

## Arquitectura de la aplicación

![img6](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/f2332ef6-9094-48da-9f0a-76ccf62d8aff)

## ¿Como el proyecto podria escalar, permitiendo agregar nuevos servicios?

La manera en la que los elementos están dispuestos y distribuidos en clases independientes nos permite realizar tareas de mantenimiento y extensión con mayor facilidad

## Video despliege AWS

[Despliegue en AWS](https://pruebacorreoescuelaingeduco-my.sharepoint.com/:v:/g/personal/santiago_bayona_mail_escuelaing_edu_co/ESGdOWsERSlFqG0NISTDRegBWzATJhrF2VuVBLK_xRSfQw?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0RpcmVjdCJ9fQ&e=X7lHz5)

## Construido con

* Java
* Maven
* Git
* Docker

