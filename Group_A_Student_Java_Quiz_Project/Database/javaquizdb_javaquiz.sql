-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: javaquizdb
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `javaquiz`
--

DROP TABLE IF EXISTS `javaquiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `javaquiz` (
  `id` int DEFAULT NULL,
  `java_question` varchar(4000) DEFAULT NULL,
  `optionA` varchar(400) DEFAULT NULL,
  `optionB` varchar(400) DEFAULT NULL,
  `optionC` varchar(400) DEFAULT NULL,
  `option_yes` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `javaquiz`
--

LOCK TABLES `javaquiz` WRITE;
/*!40000 ALTER TABLE `javaquiz` DISABLE KEYS */;
INSERT INTO `javaquiz` VALUES (1,'When an array is passed to a method, what does the method receive?','A copy of the array','Length of the array','Copy of first element','The reference of the array'),(2,'Which of the following option leads to the portability and security of Java? ','The applet makes the Java code secure and portable','Use of exception handling ','Dynamic binding between objects ','Bytecode is executed by JVM '),(3,' The SQL command to create a table is: ','MAKE TABLE.','ALTER TABLE. ','DEFINE TABLE.','CREATE TABLE.'),(4,'An on-line commercial site such as Amazon.com is an example of a(n) ____ .','single-user database application','multiuser database application','Data mining database application','E-commerce database application'),(5,'___ is used to find and fix bugs in the Java programs.','JRE','JDK',' JKB','JDB'),(6,' Which of the following will directly stop the execution of a Thread?','notify()','notifyall()','exits synchronized code','wait '),(7,' The following are components of a database except ____ .','user data','metadata','indexes','reports'),(8,' What is Collection in Java?','A group of classes','A group of interfaces','None of the mentioned','A group of objects'),(9,' Which of these interface extends DataOutput interface?','Serializable','Externalization','ObjectInput','ObjectOutput'),(10,' replace(‘e’,’s’)','Replaces all occurrences of ‘e’ to ‘s’.','Replaces single occurrence of ‘s’ to ‘e’.','None','Replaces single occurrence of ‘e’ to ‘s’.');
/*!40000 ALTER TABLE `javaquiz` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-18 14:33:20
