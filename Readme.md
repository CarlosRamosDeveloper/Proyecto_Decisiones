# Decisions RPG - REST API

- API REST diseñada para ser consumida por una aplicación web o móvil
- Mi responsabilidad principal en el proyecto fue el desarrollo del backend y la API REST, incluyendo el diseño del modelo de datos, persistencia, lógica de negocio y endpoints consumidos por la aplicación móvil.

## Arquitectura

Backend desarrollado siguiendo una arquitectura por capas, separando controladores, casos de uso, servicios, repositorios y entidades de dominio.

La lógica de aplicación se encapsula en casos de uso específicos, mientras que los servicios gestionan el acceso a los repositorios mediante Spring Data JPA. 
La API utiliza DTOs y mappers para desacoplar las entidades de persistencia de los modelos expuestos al cliente.

El backend proporciona tanto una interfaz web de administración mediante Thymeleaf como una API REST consumida por la 
aplicación móvil desarrollada por otro miembro del equipo.

## Tecnologías

- Kotlin
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Docker
- REST API
- Thymeleaf
- Maven

## API

La API REST está disponible bajo:

```text
http://localhost:8080/api
```

El proyecto incluye una colección de **Postman** (`Decisiones.postman_collection.json`) con ejemplos de las principales operaciones disponibles en la API.

La colección fue utilizada durante el desarrollo para facilitar las pruebas del backend y mantener documentados los endpoints consumidos por la aplicación móvil.

Incluye operaciones para:

* Usuarios
* Personajes
* Localizaciones
* NPCs
* Presets de personajes
* Decisiones
* Opciones de decisión
* Decisiones tomadas por los personajes

### Importar la colección

Desde Postman:

1. Seleccionar **Import**.
2. Seleccionar `Decisiones.postman_collection.json`.
3. Con la aplicación levantada, ejecutar las peticiones contra `http://localhost:8080`.

## Ejecución del proyecto

El proyecto incluye una configuración de Docker Compose que permite levantar la aplicación y la base de datos sin necesidad de instalar Java, Maven o MySQL en el sistema.

### Requisitos

* Git
* Docker
* Docker Compose

### Clonar el proyecto

```bash
git clone https://github.com/CarlosRamosDeveloper/Proyecto_Decisiones.git
cd Proyecto_Decisiones
```

### Levantar la aplicación

```bash
docker compose up -d
```

Docker se encargará de:

1. Construir la aplicación Spring Boot.
2. Crear e iniciar el contenedor de MySQL.
3. Inicializar la base de datos a partir del script SQL incluido en el proyecto.
4. Esperar a que MySQL esté disponible antes de iniciar el backend.
5. Exponer la aplicación en el puerto `8080`.

Una vez iniciada, la aplicación estará disponible en:

```text
http://localhost:8080
```

La API REST está disponible bajo:

```text
http://localhost:8080/api
```

### Detener la aplicación

Para detener los servicios sin eliminar los contenedores:

```bash
docker compose stop
```

Los datos de la base de datos se conservarán al volver a iniciar los servicios:

```bash
docker compose start
```

### Detener y eliminar los contenedores

```bash
docker compose down
```

> La base de datos se inicializa mediante `decisions_database.sql` cuando MySQL crea una nueva instancia. El script no se ejecuta de nuevo sobre una base de datos ya inicializada.
