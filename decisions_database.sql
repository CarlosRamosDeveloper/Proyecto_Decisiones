-- MySQL dump 10.13  Distrib 8.0.45, for Linux (aarch64)
--
-- Host: localhost    Database: decisions_database
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `character_flags`
--

DROP TABLE IF EXISTS `character_flags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_flags` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `flag_key` varchar(255) NOT NULL,
  `flag_value` varchar(255) NOT NULL,
  `player_character_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldg6m4sfqhyen46jvh1x2vjqw` (`player_character_id`),
  CONSTRAINT `FKldg6m4sfqhyen46jvh1x2vjqw` FOREIGN KEY (`player_character_id`) REFERENCES `player_characters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_flags`
--

LOCK TABLES `character_flags` WRITE;
/*!40000 ALTER TABLE `character_flags` DISABLE KEYS */;
/*!40000 ALTER TABLE `character_flags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character_presets`
--

DROP TABLE IF EXISTS `character_presets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_presets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `race` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `initial_location` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs8u1woh5aoo5rjs5m9k6xut09` (`initial_location`),
  CONSTRAINT `FKs8u1woh5aoo5rjs5m9k6xut09` FOREIGN KEY (`initial_location`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_presets`
--

LOCK TABLES `character_presets` WRITE;
/*!40000 ALTER TABLE `character_presets` DISABLE KEYS */;
INSERT INTO `character_presets` VALUES (1,'Esbeltos y silenciosos como el viento entre los árboles, los elfos poseen rasgos afilados y una mirada antigua que parece haber visto siglos pasar.','Elfo','Másculino',1),(2,'Esbeltos y silenciosos como el viento entre los árboles, los elfos poseen rasgos afilados y una mirada antigua que parece haber visto siglos pasar.','Elfo','Femenino',1),(3,'Sus cuerpos son fuertes y resistentes, sus brazos gruesos como troncos y sus espaldas curtida por el trabajo y la batalla.','Enano','Masculino',2),(4,'Sus cuerpos son fuertes y resistentes, sus brazos gruesos como troncos y sus espaldas curtida por el trabajo y la batalla.','Enano','Femenino',2),(5,'Los humanos son tan diversos como impredecibles. De complexión y rasgos variables, destaca por su adaptabilidad y ambición.','Humano','Masculino',3),(6,'Los humanos son tan diversos como impredecibles. De complexión y rasgos variables, destaca por su adaptabilidad y ambición.','Humano','Femenino',3);
/*!40000 ALTER TABLE `character_presets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decision_options`
--

DROP TABLE IF EXISTS `decision_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decision_options` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `option_key` varchar(255) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `decision_id` bigint NOT NULL,
  `display_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2hrbuvvjgv3yjr2ij2085nu2r` (`decision_id`,`option_key`),
  CONSTRAINT `FKs8r1f9ttraqq036ep3odmo1j2` FOREIGN KEY (`decision_id`) REFERENCES `decisions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decision_options`
--

LOCK TABLES `decision_options` WRITE;
/*!40000 ALTER TABLE `decision_options` DISABLE KEYS */;
INSERT INTO `decision_options` VALUES (1,'guild_ninja','Siempre me ha gustado el subterfugio y el sigilo',1,'Gremio de Ninjas'),(2,'guild_wizard','Siempre he querido estudiar el origen de la magia',1,'Gremio de Magos'),(3,'guild_mercenary','Siempre he querido ganarme la vida ofreciendo mi fuerza al servicio de los demás',1,'Gremio de Mercenarios'),(4,'artisan_blacksmith','El herrero provee a la ciudad de herramientas, armas y armaduras, voy con el',2,'Herrero'),(5,'artisan_jeweler','Ayudar al joyero puede repercutirse en la mejora económica de la ciudad (y la mía...) ',2,'Joyero'),(6,'thief_kid_beat','Darle una paliza al niño le enseñará modales',3,'Le diste una paliza'),(7,'thief_kid_help','Distraeré a los guardias para hacerle ganar tiempo al niño',3,'Le ayudaste'),(8,'thief_kid_justice','Derribo al niño para asegurarme de que no escape de la justicia',3,'Le derribaste'),(9,'way_left','Elijo el camino de la izquierda',4,'Camino de la izquierda'),(10,'way_right','Elijo el camino de la derecha',4,'Camino de la derecha');
/*!40000 ALTER TABLE `decision_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decisions`
--

DROP TABLE IF EXISTS `decisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decisions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `decision_key` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsr0n3xk05gusu6n3pokhyf5yt` (`decision_key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decisions`
--

LOCK TABLES `decisions` WRITE;
/*!40000 ALTER TABLE `decisions` DISABLE KEYS */;
INSERT INTO `decisions` VALUES (1,'Gremio al que te has unido','joined_guild'),(2,'A que artesano de StoneHold ayudaste','stonehold_helped_artisan'),(3,'Que acción tomaste con el niño que robó la manzana','thief_kid'),(4,'Camino inicial que tomaste','initial_way');
/*!40000 ALTER TABLE `decisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Una pequeña aldea élfica en la entrada del bosque','Timber','Timber.png'),(2,'Una antigua ciudad enana en lo profundo de las montañas','Stonehold','Stonehold.png'),(3,'Una gran ciudad de origen desconocido. Atravesada por un enorme rio','Longriver','Longriver.png'),(4,'Una urbe comercial fundada en un un paso de montaña en el que convergen caminos a diferentes capitales','Lemsys','NYI.png');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `npcs`
--

DROP TABLE IF EXISTS `npcs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `npcs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `location_id` bigint NOT NULL,
  `preset_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1x6xewa2t22qubmudx5f7gpja` (`location_id`),
  KEY `FK98nft59ialwg0d6llcavf3egw` (`preset_id`),
  CONSTRAINT `FK1x6xewa2t22qubmudx5f7gpja` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FK98nft59ialwg0d6llcavf3egw` FOREIGN KEY (`preset_id`) REFERENCES `character_presets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `npcs`
--

LOCK TABLES `npcs` WRITE;
/*!40000 ALTER TABLE `npcs` DISABLE KEYS */;
INSERT INTO `npcs` VALUES (1,'Arquero silencioso y observador, siempre acompañado de su lira que toca al atardecer. Ama la naturaleza y rara vez se enfada, pero cuando lo hace, sus flechas son precisas y letales.','Thalion Virelian',1,1),(2,'Místico y estudioso de los antiguos cantos élficos. Su voz tiene un tono hipnótico que calma incluso a las bestias más salvajes.','Elandor Mithrion',1,1),(3,'Viajero incansable con un ojo crítico para la belleza del mundo. Lleva tatuajes de runas élficas que brillan ligeramente al contacto con la magia.','Faelar Ilyndor',1,1),(4,'Guardiana de los bosques, experta en rastreo y herbología. Su risa es como un murmullo de hojas en el viento.','Ariwen Selthiel',1,2),(5,'Hechicera con una inclinación por los encantamientos protectores. Siempre viste túnicas con bordados que representan constelaciones.','Luthiel Arandor',1,2),(6,'Forjador de armas con gran paciencia, conocido por sus martillazos rítmicos que parecen música.','Bromli Harnak',2,3),(7,'Minero veterano con un sentido del humor seco; habla poco, pero siempre da buenos consejos.','Durgan Krelm',2,3),(8,'Maestra herrera y estratega en combates cercanos. Tiene un fuerte sentido de la justicia y la lealtad.','Thora Gildem',2,4),(9,'Experta en gemología y joyería, con ojo crítico para detalles que otros pasarían por alto.','Brynna Stonem',2,4),(10,'Niño de 8 años, curioso y valiente, siempre explorando rincones ocultos y haciendo preguntas difíciles.','Caelum Veyrin',3,5),(11,'Guerrero en entrenamiento, serio y concentrado, con cicatrices que muestran su experiencia pese a su juventud.','Arion Drelis',3,5),(12,'Mago aprendiz, estudioso y reflexivo, con un pequeño cuaderno lleno de fórmulas y símbolos mágicos.','Tavros Nymel',3,5),(13,'Niña de 6 años, traviesa y risueña, con gran imaginación y siempre creando historias sobre dragones y héroes.','Elara Fenris',3,6),(14,'Niña de 9 años, tímida pero inteligente, capaz de resolver acertijos y aprender hechizos básicos con facilidad.','Lyra Vandel',3,6),(15,'Joven de 17 años, fuerte y decidida, con pasión por la defensa de su gente y la justicia.','Seren Valis',3,6),(16,'Viajera y diplomática, conocida por su habilidad para mediar conflictos y leer a las personas.','Kaelis Orwen',3,6);
/*!40000 ALTER TABLE `npcs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_characters`
--

DROP TABLE IF EXISTS `player_characters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_characters` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `last_location_id` bigint NOT NULL,
  `preset_id` bigint NOT NULL,
  `player_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKele6kf0vu2qfjltqw2vtwfst9` (`last_location_id`),
  KEY `FKfur9eipn25gg0d1n6hjjeyi3i` (`preset_id`),
  KEY `FK4s2eu0e7dyh8reow7bfnncvry` (`player_id`),
  CONSTRAINT `FK4s2eu0e7dyh8reow7bfnncvry` FOREIGN KEY (`player_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKele6kf0vu2qfjltqw2vtwfst9` FOREIGN KEY (`last_location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FKfur9eipn25gg0d1n6hjjeyi3i` FOREIGN KEY (`preset_id`) REFERENCES `character_presets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_characters`
--

LOCK TABLES `player_characters` WRITE;
/*!40000 ALTER TABLE `player_characters` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_characters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_decisions`
--

DROP TABLE IF EXISTS `player_decisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_decisions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `decision_id` bigint NOT NULL,
  `player_character_id` bigint DEFAULT NULL,
  `decision_option_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKammo6nltrxox2x7khgepd0khe` (`player_character_id`,`decision_id`),
  KEY `FKbeynrhlwr12dtv48bsrhgcd15` (`decision_id`),
  KEY `FKg8cxj5qiedbl9xvpfnx00662c` (`decision_option_id`),
  CONSTRAINT `FK7lug2p2anekj12r9bdx58y8fc` FOREIGN KEY (`player_character_id`) REFERENCES `player_characters` (`id`),
  CONSTRAINT `FKbeynrhlwr12dtv48bsrhgcd15` FOREIGN KEY (`decision_id`) REFERENCES `decisions` (`id`),
  CONSTRAINT `FKg8cxj5qiedbl9xvpfnx00662c` FOREIGN KEY (`decision_option_id`) REFERENCES `decision_options` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_decisions`
--

LOCK TABLES `player_decisions` WRITE;
/*!40000 ALTER TABLE `player_decisions` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_decisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-11 20:57:35
