-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tattootest
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Database creation
--

DROP DATABASE IF EXISTS tattoo;
CREATE DATABASE tattoo;
USE tattoo;

--
-- Table structure for table `styles`
--

DROP TABLE IF EXISTS `styles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `styles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `style` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `style` (`style`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `styles`
--

LOCK TABLES `styles` WRITE;
/*!40000 ALTER TABLE `styles` DISABLE KEYS */;
INSERT INTO `styles` VALUES (4,'Blackwork'),(10,'Geometric'),(5,'Minimalist'),(2,'Realism'),(8,'Script/Text'),(7,'Sketch'),(6,'Surrealism'),(11,'testUpdate'),(1,'Traditional'),(3,'Tribal'),(9,'Watercolor');
/*!40000 ALTER TABLE `styles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestions`
--

DROP TABLE IF EXISTS `suggestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suggestions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `suggestion` text NOT NULL,
  `user_id` int NOT NULL,
  `style_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `style_id` (`style_id`),
  CONSTRAINT `suggestions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `suggestions_ibfk_2` FOREIGN KEY (`style_id`) REFERENCES `styles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestions`
--

LOCK TABLES `suggestions` WRITE;
/*!40000 ALTER TABLE `suggestions` DISABLE KEYS */;
INSERT INTO `suggestions` VALUES (1,'A stylized, geometric wolf howling at the moon with intricate patterns and designs incorporated into the background.',1,10,'2025-03-01 03:18:09'),(2,'test',1,4,'2025-03-01 03:20:21'),(3,'An intricate and detailed portrait of Iron Man\'s iconic helmet with glowing eyes, surrounded by flames and gears to represent his high-tech armor and engineering prowess. In the background, include the skyline of New York City to pay homage to Tony Stark\'s roots as a powerful and influential superhero.  Add the quote \"I am Iron Man\" to complete the design and capture the essence of this beloved character.\n',1,2,'2025-03-02 02:44:07'),(4,'testing',1,1,'2025-03-20 03:43:48'),(143,'A tattoo suggestion could be a design featuring the iconic red and white striped guitar from Eddie Van Halen, with the band\'s logo and lightning bolts incorporated into the design. This would be a distinctive and recognizable tribute to the legendary rock band.',3,5,'2025-05-02 14:56:04'),(192,'A tattoo design idea for the band Rush could be a symbolic representation of their music, such as a stylized guitar and drumset with the band\'s iconic star logo incorporated into the design. This design could be placed on the forearm or shoulder for a bold and rock-inspired look.',3,9,'2025-05-02 17:45:46'),(193,'A tattoo of the iconic prism and rainbow imagery from the cover of Pink Floyd\'s album with references to the songs throughout.',3,10,'2025-05-02 17:46:09'),(229,'A playful and whimsical tattoo idea could be a bunch of bananas with each banana representing a different aspect of your personality or important people in your life. Each banana could have a unique design or symbol that holds personal significance to you. This tattoo would not only be visually appealing but also have a deeper, more personal meaning.',3,7,'2025-05-02 20:21:45'),(253,'testing',2,1,'2025-05-08 03:33:12');
/*!40000 ALTER TABLE `suggestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ptaylor'),(2,'testUpdate'),(3,'webappTester');
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

-- Dump completed on 2025-05-08 20:57:41
