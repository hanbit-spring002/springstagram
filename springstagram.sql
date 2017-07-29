-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: springstagram
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `tbl_comments`
--

DROP TABLE IF EXISTS `tbl_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_comments` (
  `photo_id` varchar(8) NOT NULL,
  `id` varchar(8) NOT NULL,
  `author` varchar(100) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `update_dt` datetime NOT NULL,
  PRIMARY KEY (`photo_id`,`id`),
  CONSTRAINT `fk_table1_tbl_photos` FOREIGN KEY (`photo_id`) REFERENCES `tbl_photos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comments`
--

LOCK TABLES `tbl_comments` WRITE;
/*!40000 ALTER TABLE `tbl_comments` DISABLE KEYS */;
INSERT INTO `tbl_comments` VALUES ('LgfXVBlh','dds3l0E2','북극곰','ㅎㅎㅎㅎ','2017-07-29 17:31:26'),('LgfXVBlh','MA3aYcKw','북극곰','친구하자','2017-07-29 17:31:16'),('UU2e6GiV','92ZJqlgj','해파리','맛있겠다','2017-07-29 17:19:28'),('UU2e6GiV','KzDe7jvQ','해파리','파리파리','2017-07-29 17:20:33'),('UU2e6GiV','LghVtJz3','중국집','어서와','2017-07-29 17:28:56'),('UU2e6GiV','VEl8riEp','잠수부','저리가','2017-07-29 17:30:27');
/*!40000 ALTER TABLE `tbl_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_files`
--

DROP TABLE IF EXISTS `tbl_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_files` (
  `photo_id` varchar(8) NOT NULL,
  `file_path` varchar(1000) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  `file_length` bigint(20) NOT NULL,
  PRIMARY KEY (`photo_id`),
  CONSTRAINT `fk_table1_tbl_photos1` FOREIGN KEY (`photo_id`) REFERENCES `tbl_photos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_files`
--

LOCK TABLES `tbl_files` WRITE;
/*!40000 ALTER TABLE `tbl_files` DISABLE KEYS */;
INSERT INTO `tbl_files` VALUES ('HmH2bwc2','/hanbit/files/photos/HmH2bwc2','image/jpeg',845941),('iMJ6Y6f1','/hanbit/files/photos/iMJ6Y6f1','image/jpeg',561276),('lbYZbELS','/hanbit/files/photos/lbYZbELS','image/jpeg',620888),('LgfXVBlh','/hanbit/files/photos/LgfXVBlh','image/jpeg',777835),('UU2e6GiV','/hanbit/files/photos/UU2e6GiV','image/jpeg',775702),('WGwI9nCJ','/hanbit/files/photos/WGwI9nCJ','image/jpeg',780831);
/*!40000 ALTER TABLE `tbl_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_photos`
--

DROP TABLE IF EXISTS `tbl_photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_photos` (
  `id` varchar(8) NOT NULL,
  `name` varchar(200) NOT NULL,
  `content` varchar(500) NOT NULL,
  `likes` int(11) NOT NULL,
  `update_dt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_photos`
--

LOCK TABLES `tbl_photos` WRITE;
/*!40000 ALTER TABLE `tbl_photos` DISABLE KEYS */;
INSERT INTO `tbl_photos` VALUES ('HmH2bwc2','사막','사막입니다.',10,'2017-07-29 12:17:40'),('iMJ6Y6f1','등대','등대입니다.',12,'2017-07-22 18:00:07'),('lbYZbELS','튤립','튤립입니다.',6,'2017-07-29 09:43:34'),('LgfXVBlh','팽귄들','팽귄 세마리',16,'2017-07-29 15:39:10'),('UU2e6GiV','해파리','냉채',1,'2017-07-29 16:01:44'),('WGwI9nCJ','코알라','코알라라라라라',12,'2017-07-29 10:29:44');
/*!40000 ALTER TABLE `tbl_photos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-29 17:50:08
