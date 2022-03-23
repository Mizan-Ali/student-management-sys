drop database student_db;
create database student_db;
use student_db;

DROP TABLE IF EXISTS `student_details`;

CREATE TABLE `student_details` (
  `student_id` int NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `teacher_id` int DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `student_details` VALUES(1, 'Rachel', 3);
INSERT INTO `student_details` VALUES(2, 'Zane', 2);
INSERT INTO `student_details` VALUES(3, 'Donna', 3);
INSERT INTO `student_details` VALUES(4, 'Paulsen', null);