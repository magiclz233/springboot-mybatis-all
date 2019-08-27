/*
Navicat MySQL Data Transfer

Source Server         : magic
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : mybatis-all

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2019-08-27 18:04:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bonus
-- ----------------------------
DROP TABLE IF EXISTS `bonus`;
CREATE TABLE `bonus` (
  `ename` varchar(10) DEFAULT NULL COMMENT '雇员姓名',
  `job` varchar(9) DEFAULT NULL COMMENT '雇员职位',
  `sal` decimal(7,2) DEFAULT NULL COMMENT '雇员工资',
  `comm` decimal(7,2) DEFAULT NULL COMMENT '雇员资金'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资表';

-- ----------------------------
-- Records of bonus
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(10) unsigned NOT NULL COMMENT '部门编号',
  `dname` varchar(15) DEFAULT NULL COMMENT '部门名称',
  `loc` varchar(50) DEFAULT NULL COMMENT '部门所在位置',
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO `dept` VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO `dept` VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO `dept` VALUES ('40', 'OPERATIONS', 'BOSTON');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '雇员编号',
  `ename` varchar(15) DEFAULT NULL COMMENT '雇员姓名',
  `job` varchar(10) DEFAULT NULL COMMENT '雇员职位',
  `mgr` int(10) unsigned DEFAULT NULL COMMENT '雇员对应的领导的编号',
  `hiredate` date DEFAULT NULL COMMENT '雇员的雇佣日期',
  `sal` decimal(7,2) DEFAULT NULL COMMENT '雇员的基本工资',
  `comm` decimal(7,2) DEFAULT NULL COMMENT '奖金',
  `deptno` int(10) unsigned DEFAULT NULL COMMENT '所在部门',
  PRIMARY KEY (`empno`),
  KEY `deptno` (`deptno`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=7935 DEFAULT CHARSET=utf8 COMMENT='雇员表';

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('7369', 'SMITH', 'CLERK', '7902', '1980-12-17', '800.00', null, '20');
INSERT INTO `emp` VALUES ('7499', 'ALLEN', 'SALESMAN', '7698', '1981-02-20', '1600.00', '300.00', '30');
INSERT INTO `emp` VALUES ('7521', 'WARD', 'SALESMAN', '7698', '1981-02-22', '1250.00', '500.00', '30');
INSERT INTO `emp` VALUES ('7566', 'JONES', 'MANAGER', '7839', '1981-04-02', '2975.00', null, '20');
INSERT INTO `emp` VALUES ('7654', 'MARTIN', 'SALESMAN', '7698', '1981-09-28', '1250.00', '1400.00', '30');
INSERT INTO `emp` VALUES ('7698', 'BLAKE', 'MANAGER', '7839', '1981-05-01', '2850.00', null, '30');
INSERT INTO `emp` VALUES ('7782', 'CLARK', 'MANAGER', '7839', '1981-06-09', '2450.00', null, '10');
INSERT INTO `emp` VALUES ('7788', 'SCOTT', 'ANALYST', '7566', '1987-04-19', '3000.00', null, '20');
INSERT INTO `emp` VALUES ('7839', 'KING', 'PRESIDENT', null, '1981-11-17', '5000.00', null, '10');
INSERT INTO `emp` VALUES ('7844', 'TURNER', 'SALESMAN', '7698', '1981-09-08', '1500.00', '0.00', '30');
INSERT INTO `emp` VALUES ('7876', 'ADAMS', 'CLERK', '7788', '1987-05-23', '1100.00', null, '20');
INSERT INTO `emp` VALUES ('7900', 'JAMES', 'CLERK', '7698', '1981-12-03', '950.00', null, '30');
INSERT INTO `emp` VALUES ('7902', 'FORD', 'ANALYST', '7566', '1981-12-03', '3000.00', null, '20');
INSERT INTO `emp` VALUES ('7934', 'MILLER', 'CLERK', '7782', '1982-01-23', '1300.00', null, '10');

-- ----------------------------
-- Table structure for salgrade
-- ----------------------------
DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `grade` int(10) unsigned DEFAULT NULL COMMENT '工资等级',
  `losal` int(10) unsigned DEFAULT NULL COMMENT '此等级的最低工资',
  `hisal` int(10) unsigned DEFAULT NULL COMMENT '此等级的最高工资'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资等级表';

-- ----------------------------
-- Records of salgrade
-- ----------------------------
INSERT INTO `salgrade` VALUES ('1', '700', '1200');
INSERT INTO `salgrade` VALUES ('2', '1201', '1400');
INSERT INTO `salgrade` VALUES ('3', '1401', '2000');
INSERT INTO `salgrade` VALUES ('4', '2001', '3000');
INSERT INTO `salgrade` VALUES ('5', '3001', '9999');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` int(10) NOT NULL,
  `class_name` varchar(20) DEFAULT NULL,
  `grade` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '901', '计算机', '98');
INSERT INTO `score` VALUES ('2', '901', '英语', '80');
INSERT INTO `score` VALUES ('3', '902', '计算机', '65');
INSERT INTO `score` VALUES ('4', '902', '中文', '88');
INSERT INTO `score` VALUES ('5', '903', '中文', '95');
INSERT INTO `score` VALUES ('6', '904', '计算机', '70');
INSERT INTO `score` VALUES ('7', '904', '英语', '92');
INSERT INTO `score` VALUES ('8', '905', '英语', '94');
INSERT INTO `score` VALUES ('9', '906', '计算机', '90');
INSERT INTO `score` VALUES ('10', '906', '英语', '85');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birthday` year(4) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=907 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('901', '张老大', '男', '1985', '计算机系', '北京市海淀区');
INSERT INTO `student` VALUES ('902', '张老二', '男', '1986', '中文系', '北京市昌平区');
INSERT INTO `student` VALUES ('903', '张三', '女', '1990', '中文系', '湖南省永州市');
INSERT INTO `student` VALUES ('904', '李四', '男', '1990', '英语系', '辽宁省阜新市');
INSERT INTO `student` VALUES ('905', '王五', '女', '1991', '英语系', '福建省厦门市');
INSERT INTO `student` VALUES ('906', '王六', '男', '1988', '计算机系', '湖南省衡阳市');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '刘备0', null, null, null);
INSERT INTO `user` VALUES ('2', '妲己1', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('3', '李白2', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('4', '刘备3', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('5', '妲己4', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('6', '李白5', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('7', '刘备6', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('8', '妲己7', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('9', '李白8', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('10', '刘备9', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('11', '妲己10', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('12', '李白11', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('13', '刘备12', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('14', '妲己13', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('15', '李白14', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('16', '刘备15', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('17', '妲己16', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('18', '李白17', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('19', '刘备18', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('20', '妲己19', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('21', '李白20', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('22', '刘备21', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('23', '妲己22', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('24', '李白23', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('25', '刘备24', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('26', '妲己25', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('27', '李白26', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('28', '刘备27', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('29', '妲己28', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('30', '李白29', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('31', '刘备30', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('32', '妲己31', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('33', '李白32', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('34', '刘备33', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('35', '妲己34', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('36', '李白35', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('37', '刘备36', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('38', '妲己37', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('39', '李白38', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('40', '刘备39', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('41', '妲己40', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('42', '李白41', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('43', '刘备42', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('44', '妲己43', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('45', '李白44', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('46', '刘备45', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('47', '妲己46', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('48', '李白47', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('49', '刘备48', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('50', '妲己49', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('51', '李白50', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('52', '刘备51', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('53', '妲己52', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('54', '李白53', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('55', '刘备54', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('56', '妲己55', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('57', '李白56', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('58', '刘备57', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('59', '妲己58', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('60', '李白59', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('61', '刘备60', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('62', '妲己61', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('63', '李白62', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('64', '刘备63', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('65', '妲己64', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('66', '李白65', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('67', '刘备66', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('68', '妲己67', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('69', '李白68', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('70', '刘备69', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('71', '妲己70', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('72', '李白71', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('73', '刘备72', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('74', '妲己73', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('75', '李白74', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('76', '刘备75', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('77', '妲己76', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('78', '李白77', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('79', '刘备78', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('80', '妲己79', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('81', '李白80', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('82', '刘备81', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('83', '妲己82', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('84', '李白83', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('85', '刘备84', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('86', '妲己85', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('87', '李白86', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('88', '刘备87', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('89', '妲己88', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('90', '李白89', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('91', '刘备90', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('92', '妲己91', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('93', '李白92', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('94', '刘备93', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('95', '妲己94', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('96', '李白95', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('97', '刘备96', '1985', '男', '西安市');
INSERT INTO `user` VALUES ('98', '妲己97', '1995', '女', '上海市');
INSERT INTO `user` VALUES ('99', '李白98', '2005', '男', '上海市');
INSERT INTO `user` VALUES ('100', '刘备99', '1985', '男', '西安市');
