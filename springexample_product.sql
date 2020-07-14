-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: springexample
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_id` varchar(10) DEFAULT NULL,
  `p_name` varchar(30) DEFAULT NULL,
  `p_des` varchar(50) DEFAULT NULL,
  `p_img` varchar(50) DEFAULT NULL,
  `catalog_id` varchar(10) DEFAULT NULL,
  `topProduct` tinyint(1) DEFAULT NULL,
  `onSale` tinyint(1) DEFAULT NULL,
  `p_loc` varchar(30) DEFAULT NULL,
  `p_pri` varchar(30) DEFAULT NULL,
  `p_bigImg` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','Banana','Great banana','/MvcWeb/img/banana.jpg','ca2',1,NULL,'viet nam','13000 vnd/kg','/MvcWeb/img/bigImg/big_banana.jpg'),('2','Watermelon','Great Watermelon','/MvcWeb/img/watermelon.jpg','ca1',1,NULL,'viet nam',NULL,NULL),('3','Apple','Not belong to Steve Job','/MvcWeb/img/apple.png','ca2',1,NULL,'viet nam',NULL,NULL),('4','Durian','Best Vietnam Fruit','/MvcWeb/img/durian.jpg','ca2',1,1,'viet nam',NULL,NULL),('5','Orrange','Best Vietnam Fruit','/MvcWeb/img/orrange.jpg','ca2',NULL,1,'viet nam',NULL,NULL),('6','Star Fruit','Best Vietnam Fruit','/MvcWeb/img/starfruit.jpg','ca2',NULL,1,'viet nam',NULL,NULL),('7','Manger','Best Vietnam Fruit','/MvcWeb/img/mango.jpg','ca2',NULL,1,'viet nam',NULL,NULL),('8','Vu sua','Best Vietnam Fruit','/MvcWeb/img/vusua.jpg','ca2',NULL,1,'viet nam',NULL,NULL),(NULL,'ban','test banana','/MvcWeb/img/banana.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'ban2','test banana','/MvcWeb/img/banana.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'ban','test banana','/MvcWeb/img/banana.jpg','ca2',NULL,NULL,NULL,NULL,NULL),(NULL,'ban2','test banana','/MvcWeb/img/banana.jpg','ca2',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-14 13:50:29
