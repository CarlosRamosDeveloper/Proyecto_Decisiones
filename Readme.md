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
> Ayudar: El gato huye en cuanto toca el suelo.  
> No ayudar: El niño intenta trepar al arbol para bajar al gato, pero se termina cayendo y se parte una pierna.  
> La afinidad del niño bajará varios puntos por que va a echar la culpa al jugador de haberse roto una pierna.

## Tables

### users

>Información básica del usuario  
>Los personajes están vinculados al usuario

- id 
- username
- mail

### character_preset

>Almacena la información común del personaje predefinido

- id
- race

### player_characters

>Almacena la información del personaje jugable

- id
- player_id
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