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
INSERT INTO `character_presets` VALUES (1,'Esbelto y silencioso como el viento entre los árboles, el elfo posee rasgos afilados y una mirada antigua que parece haber visto siglos pasar.','Elfo','Másculino',1),(2,'De belleza etérea, su presencia es tan hipnótica como la luz de la luna entre las hojas.','Elfo','Femenino',1),(3,'Sus cuerpos son fuertes y resistentes, sus brazos gruesos como troncos y su espalda curtida por el trabajo y la batalla.','Enano','Masculino',2),(4,'La enana comparte la fortaleza de su pueblo, con una presencia imponente pese a su estatura. Sus rasgos son duros pero orgullosos, y su mirada refleja determinación inquebrantable.','Enano','Femenino',2),(5,'El humano es tan diverso como impredecible. De complexión y rasgos variables, destaca por su adaptabilidad y ambición.','Humano','Masculino',3),(6,'La humana refleja la fuerza de la emoción y la voluntad. Puede ser tan feroz como compasiva, tan sabia como impulsiva.','Humano','Femenino',3);
/*!40000 ALTER TABLE `character_presets` ENABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Una pequeña aldea élfica en la entrada del bosque','Timber'),(2,'Una antigua ciudad enana en lo profundo de las montañas','Stonehold'),(3,'Una gran ciudad de origen desconocido. Atravesada por un enorme rio','Longriver'),(4,'Una urbe comercial fundada en un un paso de montaña en el que convergen caminos a diferentes capitales','Lemsys');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `npcs`
--

LOCK TABLES `npcs` WRITE;
/*!40000 ALTER TABLE `npcs` DISABLE KEYS */;
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

-- Dump completed on 2026-02-04 14:37:03
