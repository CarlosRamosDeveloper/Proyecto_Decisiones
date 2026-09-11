# Decisions-RPG API REST

- API REST diseñada para ser consumida por una aplicación web o móvil

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
