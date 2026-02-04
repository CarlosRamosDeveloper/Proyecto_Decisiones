# Decisions RPG

- Como concepto, esto parece haber sido una mala.

## Idea

- El jugador tiene n personajes
- Existen varias ciudades a las que el personaje puede viajar
- En las ciudades existen personajes no jugables (NPCs)
- El usuario puede interactuar con los npcs
- Los npcs recordarán las decisiones que haya tomado el jugador

> Ejemplo:  
> El personaje llega a una ciudad y hay un gato subido en un arbol, un niño le pide ayuda para bajar al gato.  
>> Ayudar: El gato huye en cuanto toca el suelo.
> No ayudar: El niño intenta trepar al arbol para bajar al gato, pero se termina cayendo y se parte una pierna.  
> La afinidad del niño bajará varios puntos por que va a echar la culpa al jugador de haberse roto una pierna.

## Requisitos

El equipo del usuario requiere de la instalación del siguiente software para que el proyecto funcione:

- Git
- Docker
- Java >= 17
- Intellij IDEA o VSC

## Iniciando el proyecto

### Descargar el repositorio

En el terminal escribimos:

``` bash
git clone https://github.com/CarlosRamosDeveloper/Proyecto_Decisiones.git
```

### Preparar el entorno

- Activar el daemon de docker
- Mover decisions_database.sql y docker-compose.yml a la raiz del proyecto

### Levantar el servidor

1. Dirigirse a la ubicación del proyecto.
2. Ejecutar el comando:

``` bash
docker compose up -d
```
3. Importamos la base de datos:

Nota: Es necesario tener el fichero decisions_database.sql y docker-compose.yml en la raiz del proyecto.

``` bash
docker exec -i mysql_db mysql \
-u root -prootPassword decisions_database < decisions_database.sql
```

4. Abrimos el IDE y levantamos el servidor ejecutándolo.

>Nota: Si queremos copiar la base de datos, ejecutaron el comando en el terminal, a la altura del docker-compose.yml
> 
> ``` bash
> docker exec mysql_db mysqldump \
> -u root -prootPassword decisions_database > decisions_database.sql
> ```

## Tables

### users

>Información básica del usuario  
>Los personajes están vinculados al usuario

- id - Long
- username - 
- mail

### character_preset

>Almacena la información común del personaje predefinido

- id
- race

### player_characters

>Almacena la información del personaje jugable

- id
- user_id
- preset_id
- name
- last_location_id

### npcs

> Los NPCs permiten al usuario interactuar con ellos  
> Hay que darle una vuelta al tema de las opciones aquí

- id
- name
- description

### commentaries 

>Están relacionados con los npcs
>Los comentarios tienen una afinidad mínima y máxima

- id
- npc_id
- minimum_affinity
- maximum_affinity
- commentary

### npcs_attitude

>Almacena la afinidad entre los npc y los personajes

- npc_id
- player_id
- total_affinity

### choices

>Almacena la información de las decisiones

- id
- choice
- description

### npc_choices

>Tabla auxiliar con el listado de decisiones por npc

- npc_id
- choice_id

### locations

>Almacena la información de las ubicaciones

- id
- name

### locations_npcs

>Tabla auxiliar con la lista de los npcs de cada ubicación

- npc_id
- location_id


## Gestión

TODO

## Endpoints

> Este es el listado de todos los endpoints REST del servidor.

### Users

>La API expone en el endpoint /api/users la información para los clientes relacionada con los usuarios, estos son
> los métodos http y los endpoints con ejemplos.

| HTTP method | Endpoint                                             | Resultado                      |
|-------------|------------------------------------------------------|--------------------------------|
| Get         | localhost:8080/api/users                             | Obtiene todos los usuarios     |
| Get         | localhost:8080/api/users/1                           | Obtiene el usuario con el id 1 |
| Get         | localhost:8080/api/users/email?email=carlos@mail.com | Obtiene el usuario por email   |
| Post        | localhost:8080/api/users                             | Crea un usuario                |
| Delete      | localhost:8080/api/users/3                           | Elimina al usuario con id 3    |

>Ejemplo del body de crear usuario
> ``` Json 
> {
>   "username": String,
>   "email": String,
> }
> ```

>Ejemplo de respuesta de usuario
> ``` json
> { 
>   "id": Long,
>   "username": String,
>   "email": String,
>   "characters": [
>       {
>           "id": Long,
>           "user": String,
>           "name": String,
>           "location": String,
>           "race": String,
>           "sex": String
>       }
>   ]
> }
> ```

### Locations

> La API expone en el endpoint /api/locations la información para los clientes relacionada con 
> las ubicaciones del juego. Estos son los métodos Http y los endpoints a los que el usuario tiene acceso.

| HTTP method | Endpoint                       | Resultado                        |
|-------------|--------------------------------|----------------------------------|
| Get         | localhost:8080/api/locations   | Obtiene todas las ubicaciones    |
| Get         | localhost:8080/api/locations/1 | Obtiene la ubicación con el id 1 |

### Presets

>La api expone en el endpoint /api/presets la información para los clientes relacionada con los presets
> del juego. Estos son los métodos http y los endpoints a los que el usuario tiene acceso.

| HTTP method | Endpoint                     | Resultado                         |
|-------------|------------------------------|-----------------------------------|
| Get         | localhost:8080/api/presets   | Obtiene todos los presets         |
| Get         | localhost:8080/api/presets/1 | Obtiene la ubicación del preset 1 |

### Characters

> La api expone en el endpoint /api/characters la información para los clientes relacionada con los personajes
> del juego. Estos son métodos http y sus endpoints a los que el usuario tiene acceso

| HTTP method | Endpoint                                | Resultado                                  |
|-------------|-----------------------------------------|--------------------------------------------|
| Get         | localhost:8080/api/characters           | Obtiene todos los personajes               |
| Get         | localhost:8080/api/characters/1         | Obtiene la información del personaje 1     |
| Get         | localhost:8080/api/characters/by-user/3 | Obtiene todos los personajes del usuario 3 |
| Post        | localhost:8080/api/characters           | Permite crear un nuevo personaje           |
| Delete      | localhost:8080/api/characters/1         | Elimina al personaje 1                     |

>Ejemplo del body de crear un personaje
> ``` Json 
> {
>   "userId": Long,
>   "presetId": Long,
>   "name": String,
>   "lastLocation": Long
> }
> ```
