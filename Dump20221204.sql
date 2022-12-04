-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: healthcaredb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `idadmin` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idadmin`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (2,'Me Me','me@gmail.com','1000:260fdb695b215ca969c55b45088be5f0:0fd04ea017dbaf24fe18b1a301e7c58856ee98515f978651668de112fcd594ae1011e038a9ed1cc30eeaa34efd0369818010a55b05ef407d8a7cfccac3263c17'),(4,'Thura','tr@gmail.com','1000:a835134bb718726470670550560e4363:44e34d8914a81e1f92e3c6c6e52735063fc1fbcb150102aaaea068860747a82e1aacab0c8b40af1ffcb0d0bff404d401a170e01e4e5892262bca423d52b2cb1b');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `idappointment` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `doc_name` varchar(45) DEFAULT NULL,
  `pt_contact` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idappointment`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (3,'Aye Aye','Dr.Kyaw Soe Win','092500270','2022-12-21','Book an appointment'),(4,'Myo Myo','Dr.Kyaw Kyaw','092300356','2022-11-22','Book for appointment'),(8,'Aye Sandar Kyaw','Dr.Kyaw Kyaw','092300459','2022-11-21','Change the patient name'),(16,'Nge Nge','Dr. Nyo Me','09234567','2022-11-30','Testing appointment'),(17,'Aye Aye','Dr. Thein Htay','092345677','2022-11-22','Want to check my abdomen.'),(18,'Aye Aye','Dr. Nyo Me','0923456789','2022-11-22','Want to discuss my liver.'),(19,'Yu Yu','Dr. Thein Htay','092030456','2022-11-21','Want to check my health....'),(20,'Aye Sandar Kyaw','Dr. Sandar','092347898','2022-11-23','Book an appointment.'),(21,'Nge Nge','Dr. Sandar','09777234568','2022-11-24','Check my health...'),(22,'Nge Nge','Prof. Than Than Kyaing','0923456788','2022-11-26','Check for my heart attack.'),(23,'Myo Myo','Dr. Nyo Me','0924004568','2022-11-21','Book an appointment.'),(25,'Yu Yu','Dr. Kyaw Soe Win','0923456788','2022-11-24','Want to check about my heart attack.'),(29,'Thiri Aung','Dr. Han Su','092400678','2022-11-25','Annual medical checkup.'),(30,'Mya Mya','Dr. Han Su','092400678','2022-11-24','Check');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `iddoctor` int NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(100) DEFAULT NULL,
  `work_exp` varchar(100) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `fees` varchar(100) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iddoctor`)
) ENGINE=InnoDB AUTO_INCREMENT=441 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (5,'Dr.Khin Pyone Naing','15 years','Doctor.Med.SC(Radiology)','15000','Radiology'),(6,'Dr.Kyaw Kyaw','10 years','M.Med.SC(Hepatology)','15000','Hepatology'),(8,'Dr. Nyo Me','15 years','Doctor.Med.SC(Hepatology)','17000','Hepatology'),(435,'Dr. Khin Mg Win','10 years','M.Med.SC(Cardiology)','10000','Cardiology'),(436,'Dr. Thein Htay','14 years','M.Med.SC(Radiology)','12000','Radiology'),(437,'Dr. Sandar','5 years','M.Med.SC(Int. Medicine)','10000','General Health'),(438,'Dr. Aye Aye','13 years','M.Med.SC(Cardiology)','15000','Cardiology'),(439,'Dr. Kyaw Soe Win','14 years','M.Med.SC(Cardiology)','15000','Cardiology'),(440,'Dr. Han Su','10 years','M.Med.SC(Radiology)','12000','Radiology');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `idpatient` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `dateofbirth` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpatient`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (39,'Aye Sandar Kyaw','092132894','1991-09-23','Thitsar Street,Pyay','Aye Sandar','sandar@gmail.com','1000:e4185a048aa71280931a74a2ad40ded3:7668ada9e3273b6c499139d8df65e3b32803cfb2c796568cd76dfe09ff54f81f402ed6373b8382216052b99e47e21fd9d2088130886ca3c03145de4a6c8d29dc'),(40,'Thiri Aung','0977781234','1986-10-05','Mingalar Street, Myitkyina','Thiri','ta@gmail.com','1000:6282f609d5d1be60c2278a53c64fa2df:d2098baa14d7b82aef9ae7cd4ea6ec42d890c48307125b23bb58e996c14b2c515330362a297d2246501af66ba32e78224fc5dded3f19059ae2e446311357d01c'),(41,'Aye Aye','09345678','1989-06-12','Thiri Street, Mandalay','Aye Aye','aye@gmail.com','1000:5471e2e0f39cfb0df86b0d24370102e9:06031485148e04f6947778f989f05370ced316fde00d8c29c35acac323056331ae93f19b5d67832346aabc0164b65411f0555af2967897d1bf51fc7e9a9d8d53'),(42,'Nge Nge','094567890','1989-05-15','Thiri Street, Mohnyin','Nge Nge','nge@gmail.com','1000:308413e86df238675bbd091f098a1a88:1b4e0268aaa952d93076248207a81fcf877cbb6159efe545e6d4bb695b6d46ef31b81c01bbe1b341c2e8372d8cd169255aa7b94aaf2712ff4d1d16a5e54cdd52'),(43,'Myo Myo','092134567','2007-10-08','Sabal Street, Magway','Myo Myo','myo@gmail.com','1000:19ed582d444a6e47eaa3b83386f200c1:768e1c1658eec87fd86426dfceecd3610e2515460a37189caad493960031cf862a51a13c4fa3150bc2bd08c6907f54cefcd33bb26c3bd054aff236e70ec72d5b'),(44,'Yu Yu','092030457','1998-06-15','Taunggyi','Yu Yu','yu@gmail.com','1000:fe0ab94f0f52394f475a3db5e6192640:7bfa9f50ed2c98306c64e96b8f43f612814218e365ca1225d113eee73b88f7145192fb071e032449072c4e2fc2b9775982da7a24cb62feb38a70ddbd51c09662'),(45,'Aung Aung','09777864235','1999-06-07','Maharaungmyay, Mandalay','Aung Aung','ag@gmail.com','1000:961398271b59e2a9a9f66ce3ba30f7db:ef298918473112b4902e26f5db63ea6c304b645d03b2f105306be164c2c976eed4efee902a3999c1a4c3ce2581a66da3303fd85c6b39c239aa31e6aeeb8f4a3f'),(46,'Mya Mya','0920506789','2010-06-07','Thiri Street, Mandalay','mya','mya@gmail.com','1000:0292da3296df1669cb1b324cf34e1cc0:3f6c2b1cbb35c6b8c52129ebd9e0925012e464c32a734a6e26ccabad88ae6ff82a952ac9f44f3aeef2d8fef9da0ef12cb03b7d33541898cda33d7fd7ee5d201f');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 22:29:42
