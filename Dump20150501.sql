CREATE DATABASE  IF NOT EXISTS `ccec` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ccec`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: ccec
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `idCountry` int(11) NOT NULL,
  `countryName` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `visaCharge` double DEFAULT NULL,
  PRIMARY KEY (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (101,'Sweden','SEK','Swedish',5000),(102,'Denmark','DKK','Danish',6000),(103,'Norway','NOK','Norwegian',10000),(104,'Finland','Euro','Finnish',9000);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idEmployee` int(11) NOT NULL,
  `nameEmployee` varchar(45) DEFAULT NULL,
  `telephoneEmployee` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEmployee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (51,'Peter','07230000','25000'),(52,'Jessica','07234000','26000'),(53,'Micheal','07123455','24000');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `idStudent` int(11) NOT NULL DEFAULT '0',
  `studentName` varchar(45) DEFAULT NULL,
  `phnumberStudent` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `admitted` tinyint(1) DEFAULT NULL,
  `idUniversity` int(11) DEFAULT NULL,
  `idCountry` int(11) DEFAULT NULL,
  `idEmployee` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `idUniversity_idx` (`idUniversity`),
  KEY `idCountry_idx` (`idCountry`),
  KEY `idEmployee_idx` (`idEmployee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Harry','123456','Delhi, India','hary@gmail.com',1,81,101,51),(2,'Rita','123457','Kathmandu, Nepal','rita@hotmail.com',1,82,101,51),(3,'Richard','234561','Capetown, SA','richi@gmail.com',1,85,102,52),(4,'Katman','234567','Kathmandu, Nepal','katmanlukash@gmail.com',1,90,103,52),(5,'Paul','2356798','Sydney, Australia','paul@gmail.com',1,95,104,53);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `university` (
  `idUniversity` int(11) NOT NULL,
  `universityName` varchar(45) DEFAULT NULL,
  `faculty` varchar(45) DEFAULT NULL,
  `fee` double DEFAULT NULL,
  `dateOfEnrollment` date DEFAULT NULL,
  `idCountry` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUniversity`),
  KEY `idCountry_idx` (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--

LOCK TABLES `university` WRITE;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
INSERT INTO `university` VALUES (81,'HKR','Computer Science',300000,'2015-10-01',101),(82,'Malmö University','Political Science',280000,'2015-10-01',101),(85,'Copenhegan University','Medicine',400000,'2015-09-20',102),(86,'Copenhegan University','Dental Science',350000,'2016-01-20',102),(90,'Norwegian University','Physics',0,'2015-08-15',103),(91,'Oslo University','Space Science',0,'2015-08-15',103),(95,'Helsinki Polyteknik','Environmental Science',0,'2015-08-20',104);
/*!40000 ALTER TABLE `university` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-01 14:34:09
