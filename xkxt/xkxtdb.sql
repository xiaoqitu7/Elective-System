/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : xkxtdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-24 10:01:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `kh` char(8) NOT NULL,
  `km` varchar(10) NOT NULL,
  `xf` int(2) NOT NULL,
  `yxh` char(2) NOT NULL,
  PRIMARY KEY (`kh`),
  KEY `kh` (`kh`),
  KEY `department` (`yxh`),
  CONSTRAINT `department` FOREIGN KEY (`yxh`) REFERENCES `department` (`yxh`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('01014125', '微积分（1）', '6', '04');
INSERT INTO `course` VALUES ('01014126', '微积分（2）', '6', '04');
INSERT INTO `course` VALUES ('01014127', '微积分（3）', '4', '04');
INSERT INTO `course` VALUES ('08305010', '数据结构（2）', '4', '01');
INSERT INTO `course` VALUES ('08305013', '编译原理', '5', '01');
INSERT INTO `course` VALUES ('08305014', '数据库原理（1）', '4', '01');
INSERT INTO `course` VALUES ('08305015', '数据库原理（2）', '4', '01');
INSERT INTO `course` VALUES ('08305124', '计算机系统结构', '4', '01');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `yxh` char(2) NOT NULL,
  `mc` varchar(6) NOT NULL,
  PRIMARY KEY (`yxh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('01', '计算机学院');
INSERT INTO `department` VALUES ('02', '通讯学院');
INSERT INTO `department` VALUES ('03', '材料学院');
INSERT INTO `department` VALUES ('04', '理学院');

-- ----------------------------
-- Table structure for elective
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective` (
  `xh` char(4) NOT NULL,
  `kh` char(8) NOT NULL,
  `gh` char(4) NOT NULL,
  `pscj` int(3) DEFAULT NULL,
  `kscj` int(3) DEFAULT NULL,
  `zpcj` int(3) DEFAULT NULL,
  PRIMARY KEY (`xh`,`kh`,`gh`),
  KEY `opencourse` (`kh`,`gh`),
  KEY `opengh` (`gh`,`kh`),
  CONSTRAINT `opengh` FOREIGN KEY (`gh`) REFERENCES `open` (`gh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `openkh` FOREIGN KEY (`kh`) REFERENCES `open` (`kh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student` FOREIGN KEY (`xh`) REFERENCES `student` (`xh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elective
-- ----------------------------
INSERT INTO `elective` VALUES ('1101', '08305015', '2101', '88', '87', '87');
INSERT INTO `elective` VALUES ('1101', '08305124', '2103', null, null, null);
INSERT INTO `elective` VALUES ('1102', '08305015', '2101', '85', '82', '82');
INSERT INTO `elective` VALUES ('1102', '08305124', '2103', null, null, null);

-- ----------------------------
-- Table structure for open
-- ----------------------------
DROP TABLE IF EXISTS `open`;
CREATE TABLE `open` (
  `kh` char(8) NOT NULL,
  `gh` char(4) NOT NULL,
  `sksj` varchar(20) NOT NULL,
  `rs` int(3) NOT NULL,
  PRIMARY KEY (`kh`,`gh`),
  KEY `kh` (`kh`),
  KEY `teacher` (`gh`),
  CONSTRAINT `course` FOREIGN KEY (`kh`) REFERENCES `course` (`kh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher` FOREIGN KEY (`gh`) REFERENCES `teacher` (`gh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of open
-- ----------------------------
INSERT INTO `open` VALUES ('01014125', '2401', '一3-4 三3-4', '150');
INSERT INTO `open` VALUES ('01014127', '2402', '一3-4 三3-4', '111');
INSERT INTO `open` VALUES ('01014127', '2403', '一5-6 三5-6', '110');
INSERT INTO `open` VALUES ('08305013', '2102', '二7-9 四7-10', '1');
INSERT INTO `open` VALUES ('08305014', '2104', '三1-2 五1-4', '60');
INSERT INTO `open` VALUES ('08305015', '2101', '三1-2 五1-4', '50');
INSERT INTO `open` VALUES ('08305124', '2103', '一1-4 三7-8', '50');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `xh` char(4) NOT NULL,
  `xm` varchar(6) NOT NULL,
  `yxh` char(2) NOT NULL,
  `kl` char(10) NOT NULL,
  PRIMARY KEY (`xh`),
  KEY `department1` (`yxh`),
  CONSTRAINT `department1` FOREIGN KEY (`yxh`) REFERENCES `department` (`yxh`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1101', '余加', '01', '123123');
INSERT INTO `student` VALUES ('1102', '杨洋', '01', '123123');
INSERT INTO `student` VALUES ('1103', '刘晓明', '01', '123123');
INSERT INTO `student` VALUES ('1104', '刘晶晶', '01', '123123');
INSERT INTO `student` VALUES ('1201', '李明', '02', '123123');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `gh` char(4) NOT NULL,
  `xm` varchar(6) NOT NULL,
  `yxh` char(2) NOT NULL,
  `kl` char(10) NOT NULL,
  PRIMARY KEY (`gh`),
  KEY `department2` (`yxh`),
  CONSTRAINT `department2` FOREIGN KEY (`yxh`) REFERENCES `department` (`yxh`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2101', '宋安平', '01', '123123');
INSERT INTO `teacher` VALUES ('2102', '沈俊', '01', '123123');
INSERT INTO `teacher` VALUES ('2103', '朱永华', '01', '123123');
INSERT INTO `teacher` VALUES ('2104', '郑宇', '01', '123123');
INSERT INTO `teacher` VALUES ('2401', '杨永建', '04', '123123');
INSERT INTO `teacher` VALUES ('2402', '郭伟娟', '04', '123123');
INSERT INTO `teacher` VALUES ('2403', '刘巧华', '04', '123123');
INSERT INTO `teacher` VALUES ('2404', '佟丽宁', '04', '123123');

-- ----------------------------
-- Procedure structure for sumxuefen
-- ----------------------------
DROP PROCEDURE IF EXISTS `sumxuefen`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sumxuefen`(IN`stu_xh` char(4),OUT `sumxf` int)
BEGIN
select sum(xf) into sumxf from course where kh in (select kh from elective where xh = stu_xh);
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `grade`;
DELIMITER ;;
CREATE TRIGGER `grade` BEFORE UPDATE ON `elective` FOR EACH ROW BEGIN
IF ((NEW.pscj > 100) OR (NEW.pscj < 0))
THEN
        SET NEW.pscj = OLD.pscj;
END IF;
IF ((NEW.kscj > 100) OR (NEW.kscj < 0))
THEN
     SET NEW.kscj = OLD.kscj;
END IF;
IF ((NEW.zpcj > 100) OR (NEW.zpcj < 0))
THEN
        SET NEW.zpcj = OLD.zpcj;
END IF;
END
;;
DELIMITER ;
