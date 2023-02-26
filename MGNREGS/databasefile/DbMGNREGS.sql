-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: MGNREGS
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `bdo`
--

DROP TABLE IF EXISTS `bdo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bdo` (
  `BDO_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`BDO_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdo`
--

LOCK TABLES `bdo` WRITE;
/*!40000 ALTER TABLE `bdo` DISABLE KEYS */;
INSERT INTO `bdo` VALUES (1,'LOKESH','123456789','lokesh@gmail.com','7777777777'),(2,'Anjali','123','anjali@gmail.com','8529637410');
/*!40000 ALTER TABLE `bdo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) NOT NULL,
  `emp_phone` varchar(13) NOT NULL,
  `emp_type` int NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `emp_type` (`emp_type`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`emp_type`) REFERENCES `ocupation` (`ocupation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'dhanraj','7418529638',1),(2,'nithin','7418528520',1),(3,'gowtham','9638529639',2),(4,'ranjith','7417417410',1),(5,'bharath','741085208520',2),(6,'ganesh','64662',2),(7,'rakesh','741852415',2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpm`
--

DROP TABLE IF EXISTS `gpm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpm` (
  `GPM_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`GPM_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpm`
--

LOCK TABLES `gpm` WRITE;
/*!40000 ALTER TABLE `gpm` DISABLE KEYS */;
INSERT INTO `gpm` VALUES (1,'rama','rama','rama@gmail.com','1234567890'),(2,'ravinder','ravinder','ravinder@gmail.com','9638527410'),(3,'sunil','sunil','sunil@gmail.com','7418529630'),(5,'ramesh','ramesh','ramesh@gmail.com','1233211230');
/*!40000 ALTER TABLE `gpm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpmtopro`
--

DROP TABLE IF EXISTS `gpmtopro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpmtopro` (
  `GPM_ID` int NOT NULL,
  `Project_id` int NOT NULL,
  PRIMARY KEY (`GPM_ID`),
  UNIQUE KEY `Project_id` (`Project_id`),
  CONSTRAINT `gpmtopro_ibfk_1` FOREIGN KEY (`GPM_ID`) REFERENCES `gpm` (`GPM_id`),
  CONSTRAINT `gpmtopro_ibfk_2` FOREIGN KEY (`Project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpmtopro`
--

LOCK TABLES `gpmtopro` WRITE;
/*!40000 ALTER TABLE `gpmtopro` DISABLE KEYS */;
INSERT INTO `gpmtopro` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `gpmtopro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocupation`
--

DROP TABLE IF EXISTS `ocupation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ocupation` (
  `ocupation_id` int NOT NULL,
  `ocupation_name` varchar(20) NOT NULL,
  `salary_wage` int DEFAULT NULL,
  PRIMARY KEY (`ocupation_id`),
  UNIQUE KEY `ocupation_name` (`ocupation_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocupation`
--

LOCK TABLES `ocupation` WRITE;
/*!40000 ALTER TABLE `ocupation` DISABLE KEYS */;
INSERT INTO `ocupation` VALUES (1,'superviser',320),(2,'manual_worker',280);
/*!40000 ALTER TABLE `ocupation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) DEFAULT NULL,
  `project_location` varchar(20) DEFAULT NULL,
  `Start_date` date DEFAULT NULL,
  `End_date` date DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'abc','hyd','2023-01-01','2023-03-01'),(2,'digging','hyderabad','2023-01-01','2023-04-11'),(3,'war','warangal','2023-01-01','2023-04-11'),(4,'siddi','siddi','2023-01-01','2023-04-11'),(5,'sircilla','sircilla','2023-01-01','2023-04-11');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workerslog`
--

DROP TABLE IF EXISTS `workerslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workerslog` (
  `emp_id` int NOT NULL,
  `project_id` int NOT NULL,
  `Start_date` date DEFAULT NULL,
  `releving_date` date DEFAULT NULL,
  `days` int DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `workerslog_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `workerslog_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workerslog`
--

LOCK TABLES `workerslog` WRITE;
/*!40000 ALTER TABLE `workerslog` DISABLE KEYS */;
INSERT INTO `workerslog` VALUES (1,2,'2023-02-23',NULL,NULL),(2,1,'2023-01-01',NULL,NULL),(3,2,'2023-01-01',NULL,NULL),(4,2,'2023-01-01',NULL,NULL),(5,1,'2023-01-01',NULL,NULL),(6,1,'2023-01-01',NULL,NULL);
/*!40000 ALTER TABLE `workerslog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 15:46:58
