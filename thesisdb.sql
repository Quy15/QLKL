-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: thesisdb
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
-- Table structure for table `criteria`
--

DROP TABLE IF EXISTS `criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria`
--

LOCK TABLES `criteria` WRITE;
/*!40000 ALTER TABLE `criteria` DISABLE KEYS */;
INSERT INTO `criteria` VALUES (1,'Chủ đề và ý tưởng nghiên cứu'),(2,'Phương pháp nghiên cứu'),(3,'Đóng góp khoa học và thực tiễn'),(4,'Quá trình thực hiện'),(5,'Báo cáo viết '),(6,'Trình bày trước hội'),(7,'Công bố khoa học/ứng dụng thực tế');
/*!40000 ALTER TABLE `criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteria_has_thesis_score`
--

DROP TABLE IF EXISTS `criteria_has_thesis_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria_has_thesis_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `criteria_id` int unsigned NOT NULL,
  `thesis_score_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_criteria_has_thesis_score_thesis_score1_idx` (`thesis_score_id`),
  KEY `fk_criteria_has_thesis_score_criteria1_idx` (`criteria_id`),
  CONSTRAINT `fk_criteria_has_thesis_score_criteria1` FOREIGN KEY (`criteria_id`) REFERENCES `criteria` (`id`),
  CONSTRAINT `fk_criteria_has_thesis_score_thesis_score1` FOREIGN KEY (`thesis_score_id`) REFERENCES `thesis_score` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria_has_thesis_score`
--

LOCK TABLES `criteria_has_thesis_score` WRITE;
/*!40000 ALTER TABLE `criteria_has_thesis_score` DISABLE KEYS */;
INSERT INTO `criteria_has_thesis_score` VALUES (5,1,21),(6,2,21),(7,4,21),(8,5,21);
/*!40000 ALTER TABLE `criteria_has_thesis_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defense_committee`
--

DROP TABLE IF EXISTS `defense_committee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defense_committee` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defense_committee`
--

LOCK TABLES `defense_committee` WRITE;
/*!40000 ALTER TABLE `defense_committee` DISABLE KEYS */;
INSERT INTO `defense_committee` VALUES (1,'HOIDONG1'),(15,'HOIDONG2'),(18,'HOIDONG3'),(22,'HOIDONG4'),(28,'HOIDONG7'),(30,'HOIDONG8');
/*!40000 ALTER TABLE `defense_committee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defense_committee_role`
--

DROP TABLE IF EXISTS `defense_committee_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defense_committee_role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defense_committee_role`
--

LOCK TABLES `defense_committee_role` WRITE;
/*!40000 ALTER TABLE `defense_committee_role` DISABLE KEYS */;
INSERT INTO `defense_committee_role` VALUES (1,'Chủ tịch'),(2,'Thư ký'),(3,'Phản biện'),(4,'Thành viên');
/*!40000 ALTER TABLE `defense_committee_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_thesis`
--

DROP TABLE IF EXISTS `instructor_thesis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_thesis` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `thesis_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_thesis_thesis1_idx` (`thesis_id`),
  KEY `fk_user_has_thesis_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_thesis_thesis1` FOREIGN KEY (`thesis_id`) REFERENCES `thesis` (`id`),
  CONSTRAINT `fk_user_has_thesis_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_thesis`
--

LOCK TABLES `instructor_thesis` WRITE;
/*!40000 ALTER TABLE `instructor_thesis` DISABLE KEYS */;
INSERT INTO `instructor_thesis` VALUES (1,3,2),(2,7,5),(3,7,3),(21,15,61),(22,16,61),(23,16,71),(24,15,71),(25,19,1),(26,20,1),(27,25,4),(28,26,4),(29,27,7),(30,28,7),(31,33,8),(32,34,8);
/*!40000 ALTER TABLE `instructor_thesis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'CNTT'),(2,'HTTTQL'),(3,'NN Anh'),(4,'Luật'),(5,'Kinh tế'),(6,'Tài chính - Ngân hàng'),(7,'Quản trị kinh doanh'),(8,'Kế toán'),(9,'Công nghệ sinh học'),(10,'Xã hội học'),(11,'Công nghệ kỹ thuật công trình xây dựng'),(12,'Logistic'),(13,'Marketing'),(14,'Quản trị nhân lực'),(15,'Du lịch');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thesis`
--

DROP TABLE IF EXISTS `thesis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thesis` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thesis`
--

LOCK TABLES `thesis` WRITE;
/*!40000 ALTER TABLE `thesis` DISABLE KEYS */;
INSERT INTO `thesis` VALUES (1,'Hệ thống dự đoán kẹt xe thời gian thực dựa trên phân tích dữ liệu lớn chuỗi thời gian','2023-07-27 00:00:00','Đã thực hiện'),(2,'Xây dựng nền tảng giao dịch trực tuyến dựa trên công nghệ Blockchain','2020-04-19 00:00:00','Đã thực hiện'),(3,'Nghiên cứu bài toán kiểm tra lỗi và xây dựng ứng dụng sửa lỗi trong bài viết Tiếng Anh','2021-06-05 00:00:00','Đã thực hiện'),(4,'Nghiên cứu sự tác động của các yếu tố nhập khẩu, xuất khẩu, đầu tư ảnh hưởng đến tổng sản phẩm quốc nội (GDP) Việt Nam','2021-09-15 00:00:00','Đã thực hiện'),(5,'Một số giải pháp nhằm hoàn thiện chính sách thuế để khuyến khích hoạt động đầu tư trực tiếp nước ngoài tại Việt Nam','2020-10-20 00:00:00','Đã thực hiện'),(7,'Xây dựng hệ thống quản lý nhập xuất kho bằng Barcode trên thiết bị di động','2023-10-12 00:00:00','Sắp thực hiện'),(8,'Tìm hiểu phương pháp sơ đồ mạng lưới trong quản lý dự án và ứng dụng giải quyết bài toán lập lịch thi công công trình','2023-12-25 00:00:00','Sắp thực hiện'),(9,'Phân tích thực trạng, từ đó đề xuất một số giải pháp nhằm hòan thiện công tác quản trị kênh phân phối sản phẩm tại công ty','2019-01-10 00:00:00','Đã thực hiện'),(61,'Tranh chấp trong thực hiện hợp đồng và việc giải quyết các tranh chấp phát sinh trong thực hiện các loại hợp đồng','2023-08-27 00:00:00','Sắp thực hiện'),(71,'Test Add Thesis','2023-09-20 00:00:00','Sắp thực hiện');
/*!40000 ALTER TABLE `thesis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thesis_participant`
--

DROP TABLE IF EXISTS `thesis_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thesis_participant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `thesis_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_thesis1_thesis1_idx` (`thesis_id`),
  KEY `fk_user_has_thesis1_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_thesis1_thesis1` FOREIGN KEY (`thesis_id`) REFERENCES `thesis` (`id`),
  CONSTRAINT `fk_user_has_thesis1_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thesis_participant`
--

LOCK TABLES `thesis_participant` WRITE;
/*!40000 ALTER TABLE `thesis_participant` DISABLE KEYS */;
INSERT INTO `thesis_participant` VALUES (1,1,2),(2,2,2),(3,5,3),(4,6,5),(23,9,61),(24,5,61),(33,9,71),(34,21,1),(35,17,1),(36,22,4),(37,23,4),(38,29,7),(39,30,7),(40,31,8),(41,32,8);
/*!40000 ALTER TABLE `thesis_participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thesis_score`
--

DROP TABLE IF EXISTS `thesis_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thesis_score` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `score` varchar(45) DEFAULT NULL,
  `thesis_id` int unsigned NOT NULL,
  `user_defense_committee_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_thesis_score_thesis1_idx` (`thesis_id`) /*!80000 INVISIBLE */,
  KEY `fk_thesis_score_user_defense_committee1_idx` (`user_defense_committee_id`),
  CONSTRAINT `fk_thesis_score_thesis1` FOREIGN KEY (`thesis_id`) REFERENCES `thesis` (`id`),
  CONSTRAINT `fk_thesis_score_user_defense_committee1` FOREIGN KEY (`user_defense_committee_id`) REFERENCES `user_defense_committee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thesis_score`
--

LOCK TABLES `thesis_score` WRITE;
/*!40000 ALTER TABLE `thesis_score` DISABLE KEYS */;
INSERT INTO `thesis_score` VALUES (1,NULL,'10',1,9),(2,NULL,'8.5',2,10),(3,NULL,'9',3,11),(4,NULL,'7',4,12),(5,NULL,'6',4,13),(6,NULL,'7',8,14),(17,NULL,'5',1,28),(18,NULL,'5',2,29),(19,NULL,'6',3,30),(20,NULL,'8',4,31),(21,NULL,'10',5,32),(22,NULL,'9',71,33),(23,NULL,'9',61,34),(24,NULL,'8.5',9,35);
/*!40000 ALTER TABLE `thesis_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `avatar` varchar(10000) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `major_id` int unsigned NOT NULL,
  `user_role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_major_idx` (`major_id`),
  CONSTRAINT `fk_user_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Trần Hùng','Quý','quy','$2y$10$f5tEL2Ro/1CHGH7t4QZZFerFhs774wJ463N6dWbfZGehhGqxJ1pui','https://res.cloudinary.com/dt3oasocf/image/upload/v1692499918/msknq5d8a5td0plkgvco.jpg',NULL,'tranhungquy2002@gmail.com',1,'ROLE_SV'),(2,'Nguyễn Phú','Vang','vang','$2y$10$f5tEL2Ro/1CHGH7t4QZZFerFhs774wJ463N6dWbfZGehhGqxJ1pui','https://res.cloudinary.com/dt3oasocf/image/upload/v1692090015/lmhefcnpeuyhgmvre7ah.jpg',NULL,'vang@gmail.com',4,'ROLE_SV'),(3,'Nguyễn Minh','Nhật','nhat','$2y$10$d2iajMLGUom6aCpYt4bFgeC6b3aH.HIuGIIBYWc5Fv7yBgwoPH5HO','https://res.cloudinary.com/dt3oasocf/image/upload/v1690875767/ys_fpeabn.jpg',NULL,'nhat@gmail.com',2,'ROLE_GV'),(4,NULL,NULL,'admin','$2y$10$d2iajMLGUom6aCpYt4bFgeC6b3aH.HIuGIIBYWc5Fv7yBgwoPH5HO','https://res.cloudinary.com/dt3oasocf/image/upload/v1691498440/admin_pbanat.jpg',NULL,'',1,'ROLE_ADMIN'),(5,'Phan Minh ','Quân','quan','$2y$10$d2iajMLGUom6aCpYt4bFgeC6b3aH.HIuGIIBYWc5Fv7yBgwoPH5HO','https://res.cloudinary.com/dt3oasocf/image/upload/v1690875767/ys_fpeabn.jpg',NULL,'quan@gmail.com',3,'ROLE_SV'),(6,'Nguyễn Hữu','Phúc','phuc','$2y$10$f5tEL2Ro/1CHGH7t4QZZFerFhs774wJ463N6dWbfZGehhGqxJ1pui','https://res.cloudinary.com/dt3oasocf/image/upload/v1690875767/ys_fpeabn.jpg',NULL,'phuc@gmail.com',6,'ROLE_SV'),(7,'Nguyễn Hoàng','Vũ','vu','$2y$10$V3HCdKrDCE7AGXj0XmoQ..r7moJtJcOQjdAexpjo0uxm0WTjLgZ8u','https://res.cloudinary.com/dt3oasocf/image/upload/v1692090068/idg7zhzv5kdxfermcwue.jpg',NULL,'vu@gmail.com',4,'ROLE_GV'),(9,'Nguyễn Văn','B','b','$2a$10$vI4wnXTdTpeMDEopZ2Xhhuqb/jW/06cW.enqRGXaHqW4hCEsBwcs.','https://res.cloudinary.com/dt3oasocf/image/upload/v1692498961/ybxyu1wu8llyggai9f7s.jpg',NULL,'b@gmail.com',7,'ROLE_SV'),(10,'Trần Thị ','Thu','thudan','$2a$10$4Ag/GhRMynHdp0WeGueAxuiXNOd7pnMB0kMv/8Wg/F/o56Ou8zkxW','https://res.cloudinary.com/dt3oasocf/image/upload/v1692498936/fgx1ia9q2ovffgi8tw4s.jpg',NULL,'thudan@gmail.com',1,'ROLE_GV'),(11,'Lê Văn','Tám','tam','$2a$10$G5GVSJG5j7kwvTdDdyJ/s.5NST7qD//JsQotq05QtAuYuuUp0UVxu','https://res.cloudinary.com/dt3oasocf/image/upload/v1692256782/equxyziv69iz3bxwpog0.jpg',NULL,'tam@gmail.com',6,'ROLE_GVU'),(15,'Trần Thiên','Hoàng','hoang','$2a$10$wMtYyoap54mxNxGF1xfXjOiZVfp/MW4z97R82axaepzvXruvFU056','https://res.cloudinary.com/dt3oasocf/image/upload/v1692498800/axphv64rxfv3wfar4ddg.jpg',NULL,'hoang@gmail.com',4,'ROLE_GV'),(16,'Nguyễn Thành','Công','cong','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1692502592/zy1clipek7bqr3oxed3m.jpg',NULL,'tranhungquy2002@gmail.com',5,'ROLE_GV'),(17,'Lý Liên','Kiệt','kiet','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1692502592/zy1clipek7bqr3oxed3m.jpg',NULL,'wildrifttest1504@gmail.com',10,'ROLE_SV'),(18,'Thành','Long','long','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1692502592/zy1clipek7bqr3oxed3m.jpg',NULL,'2051052114@gmail.com',14,'ROLE_GV'),(19,'Nguyễn Thanh','Danh','danh','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1692502592/zy1clipek7bqr3oxed3m.jpg',NULL,'danh@gmail.com',8,'ROLE_GV'),(20,'Hồ Ngọc','Hà','ha','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693468383/Ha_Ho_in_2019_l3ueis.png',NULL,'ha@gmail.com',15,'ROLE_GV'),(21,'Nguyễn Thanh','Tùng','tung','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693468645/250px-Son_Tung_M-TP_1__2017_e9vusm.png',NULL,'tung@gmail.com',13,'ROLE_SV'),(22,'Nghiêm Vũ Hoàng','Long','long','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693468973/netizen-bat-ngua-voi-mck-phien-ban-ha-anh-tuan-fan-suyt-khong-nhan-ra-vi-nhin-cu-sai-sai-71c-6247932_sev1yi.jpg',NULL,'mck@gmail.com',12,'ROLE_SV'),(23,'Phạm Nam','Hải','hai','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693469146/download_grqhj6.jpg',NULL,'wrxdie@gmail.com',11,'ROLE_SV'),(24,'Lê','Phan','phan','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693469268/wren-evans-the-hien-muon-kieu-si-tinh-trong-mv-gap-may_v9v13y.jpg',NULL,'wren@gmail.com',13,'ROLE_SV'),(25,'Đàm Vĩnh','Hưng','hung','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693469388/Ong_hoang_nhac_Viet_co_suc_hut_khung_khiep_khi_chuyen_sang_nghe_ban_hang_online_zecux6.jpg',NULL,'hung@gmail.com',12,'ROLE_GV'),(26,'Đan','Trường','truong','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693469483/dep-trai-giau-nhu-dan-truong-nhung-hon-nhan-van-khong-tron-ven_dd7pqh.jpg',NULL,'trương@gmail.com',9,'ROLE_GV'),(27,'Trần Trung','Hiếu','hieu','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693470172/image2_jh7esj.jpg',NULL,'lilwuyn@gmail.com',10,'ROLE_GV'),(28,'Huỳnh Công','Hiếu','hieu2','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693470299/bf4m_eg7ppg.jpg',NULL,'conghieu@gmail.com',5,'ROLE_GV'),(29,'Châu Việt','Sơn','son','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693470474/1562067088091_fyutuz.jpg',NULL,'son@gmail.com',3,'ROLE_SV'),(30,'Trần Chris','Bum','bum','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693470674/20230531122015_screenshot-20230531-121938-instagram-1-_tvugoe.jpg',NULL,'cbum@gmail.com',1,'ROLE_SV'),(31,'Trần Quốc','Sang','sang','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693493000/channels4_profile_gz7vjd.jpg',NULL,'sang@gmail.com',2,'ROLE_SV'),(32,'Trịnh Công','Sơn','sol','$2y$10$4Kaw/JlRsTsPj9QwxUX30.mRKbj3URHXl167a9F9qvJnJXoF0MCPC','https://res.cloudinary.com/dt3oasocf/image/upload/v1693493277/channels4_profile_bpr2pb.jpg',NULL,'sol@gmail.com',5,'ROLE_SV'),(33,'Lưu Ngọc','Quân','lquan','$2a$10$tTTuVUZfI/bfjO1j.GmJieRsObnD5oBjscdsRtNjQrp/kMK.GsVc.','https://res.cloudinary.com/dt3oasocf/image/upload/v1693493721/365231928_10232138261385125_4258241513361865566_n_p1sqly.jpg',NULL,'nquan@gmail.com',8,'ROLE_GV'),(34,'Nguyễn Anh','Quốc','quoc','$2y$10$4Kaw/JlRsTsPj9QwxUX30.mRKbj3URHXl167a9F9qvJnJXoF0MCPC','https://res.cloudinary.com/dt3oasocf/image/upload/v1693493808/342559239_816964313099815_6009677126743698824_n_skb6xc.jpg',NULL,'quoc@gmail.com',9,'ROLE_GV');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_defense_committee`
--

DROP TABLE IF EXISTS `user_defense_committee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_defense_committee` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `defense_committee_id` int unsigned NOT NULL,
  `defense_committee_role_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_defense_committee_defense_committee1_idx` (`defense_committee_id`),
  KEY `fk_user_has_defense_committee_user1_idx` (`user_id`),
  KEY `fk_user_has_defense_committee_defense_committee_role1_idx` (`defense_committee_role_id`),
  CONSTRAINT `fk_user_has_defense_committee_defense_committee1` FOREIGN KEY (`defense_committee_id`) REFERENCES `defense_committee` (`id`),
  CONSTRAINT `fk_user_has_defense_committee_defense_committee_role1` FOREIGN KEY (`defense_committee_role_id`) REFERENCES `defense_committee_role` (`id`),
  CONSTRAINT `fk_user_has_defense_committee_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_defense_committee`
--

LOCK TABLES `user_defense_committee` WRITE;
/*!40000 ALTER TABLE `user_defense_committee` DISABLE KEYS */;
INSERT INTO `user_defense_committee` VALUES (1,3,1,1),(4,7,15,1),(5,10,15,2),(6,15,15,3),(7,16,15,4),(8,3,15,4),(9,15,18,1),(10,3,18,3),(11,16,18,2),(12,10,18,4),(13,7,18,4),(14,7,22,1),(15,15,22,2),(16,10,22,3),(17,16,22,4),(28,7,28,1),(29,10,28,2),(30,15,28,3),(31,16,28,4),(32,3,28,4),(33,3,30,1),(34,7,30,2),(35,16,30,3);
/*!40000 ALTER TABLE `user_defense_committee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-06 19:09:59
