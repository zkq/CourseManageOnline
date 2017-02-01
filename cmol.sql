/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : cmol

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-02-01 11:51:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for actiontype
-- ----------------------------
DROP TABLE IF EXISTS `actiontype`;
CREATE TABLE `actiontype` (
  `aid` char(1) NOT NULL,
  `actionname` varchar(10) NOT NULL,
  `tip` varchar(255) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of actiontype
-- ----------------------------
INSERT INTO `actiontype` VALUES ('1', '开设了新课程', '若希望加入该课程，请联系老师获取加入码吧！');
INSERT INTO `actiontype` VALUES ('2', '发布了新作业', '别忘了及时提交作品哦！');
INSERT INTO `actiontype` VALUES ('3', '上传了新图片', '可点击下方链接下载！');
INSERT INTO `actiontype` VALUES ('4', '上传了新视频', '可点击下方链接下载！');
INSERT INTO `actiontype` VALUES ('5', '上传了新文档', '可点击下方链接下载！');
INSERT INTO `actiontype` VALUES ('6', '上传了新资源', '可点击下方链接下载！');

-- ----------------------------
-- Table structure for concern
-- ----------------------------
DROP TABLE IF EXISTS `concern`;
CREATE TABLE `concern` (
  `roleid1` char(32) NOT NULL,
  `roleid2` char(32) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`roleid1`,`roleid2`),
  KEY `concern_ibfk_2` (`roleid2`),
  CONSTRAINT `concern_ibfk_1` FOREIGN KEY (`roleid1`) REFERENCES `role` (`roleid`) ON DELETE CASCADE,
  CONSTRAINT `concern_ibfk_2` FOREIGN KEY (`roleid2`) REFERENCES `role` (`roleid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concern
-- ----------------------------
INSERT INTO `concern` VALUES ('4028d08159f788ce0159f797c2340000', '4028d08159f779ee0159f77e098f0000', '2017-02-01 10:54:02');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` char(32) NOT NULL,
  `tid` char(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `code` char(5) NOT NULL,
  `type` varchar(20) NOT NULL,
  `introduction` varchar(500) DEFAULT NULL,
  `creattime` datetime NOT NULL,
  `starttime` date NOT NULL,
  `joinendtime` date NOT NULL,
  `finishtime` date NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `tid` (`tid`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('4028d08159f788ce0159f799b6940002', '4028d08159f779ee0159f77e098f0000', '软件工程', 'LULQL', '', '', '2017-02-01 10:56:03', '2017-02-01', '2017-02-08', '2017-06-30');

-- ----------------------------
-- Table structure for download
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download` (
  `downid` char(32) NOT NULL,
  `rid` char(32) NOT NULL,
  `roleid` char(32) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`downid`),
  KEY `download_ibfk_1` (`rid`),
  KEY `download_ibfk_2` (`roleid`),
  CONSTRAINT `download_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `resource` (`rid`) ON DELETE CASCADE,
  CONSTRAINT `download_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of download
-- ----------------------------
INSERT INTO `download` VALUES ('4028d08159f788ce0159f79dfa780008', '4028d08159f788ce0159f79d59050006', '4028d08159f779ee0159f77e098f0000', '2017-02-01 11:00:42');
INSERT INTO `download` VALUES ('4028d08159f788ce0159f7a027f60009', '4028d08159f788ce0159f79d59050006', '4028d08159f788ce0159f797c2340000', '2017-02-01 11:03:05');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` char(32) NOT NULL,
  `sid` char(32) NOT NULL,
  `tid` char(32) NOT NULL,
  `actiontype` char(1) NOT NULL,
  `actiontime` datetime NOT NULL,
  `content` varchar(500) NOT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `readed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `sid` (`sid`),
  KEY `tid` (`tid`),
  KEY `actiontype` (`actiontype`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `message_ibfk_3` FOREIGN KEY (`actiontype`) REFERENCES `actiontype` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('4028d08159f788ce0159f799b69e0003', '4028d08159f788ce0159f797c2340000', '4028d08159f779ee0159f77e098f0000', '1', '2017-02-01 10:56:03', '软件工程', '0', null);
INSERT INTO `message` VALUES ('4028d08159f788ce0159f79cbf9a0005', '4028d08159f788ce0159f797c2340000', '4028d08159f779ee0159f77e098f0000', '2', '2017-02-01 10:59:22', '12', '0', null);
INSERT INTO `message` VALUES ('4028d08159f788ce0159f79d59080007', '4028d08159f788ce0159f797c2340000', '4028d08159f779ee0159f77e098f0000', '3', '2017-02-01 11:00:01', 'b2fa0c375dda972baa41d182bddab6c7 屏幕截图(2).png', '0', null);
INSERT INTO `message` VALUES ('4028d08159f7af7e0159f7b4bcfa0001', '4028d08159f779ee0159f77e098f0000', '4028d08159f788ce0159f797c2340000', '4', '2017-02-01 11:25:34', 'b2fa0c375dda972baa41d182bddab6c7 屏幕截图(2).png', '0', null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `rid` char(32) NOT NULL,
  `cid` char(32) NOT NULL,
  `roleid` char(32) NOT NULL,
  `type` char(1) NOT NULL,
  `resourcemd5` char(32) NOT NULL,
  `resourcename` varchar(100) NOT NULL,
  `introduction` varchar(500) DEFAULT NULL,
  `creattime` datetime NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `cid` (`cid`),
  KEY `roleid` (`roleid`),
  KEY `type` (`type`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`),
  CONSTRAINT `resource_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `resource_ibfk_3` FOREIGN KEY (`type`) REFERENCES `resourcetype` (`rtid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('4028d08159f788ce0159f79d59050006', '4028d08159f788ce0159f799b6940002', '4028d08159f779ee0159f77e098f0000', '1', 'b2fa0c375dda972baa41d182bddab6c7', '屏幕截图(2).png', '', '2017-02-01 11:00:01');
INSERT INTO `resource` VALUES ('4028d08159f7af7e0159f7b4bcf50000', '4028d08159f788ce0159f799b6940002', '4028d08159f788ce0159f797c2340000', '2', 'b2fa0c375dda972baa41d182bddab6c7', '屏幕截图(2).png', '三大大幅度', '2017-02-01 11:25:34');

-- ----------------------------
-- Table structure for resourcetype
-- ----------------------------
DROP TABLE IF EXISTS `resourcetype`;
CREATE TABLE `resourcetype` (
  `rtid` char(1) NOT NULL,
  `rtname` varchar(255) NOT NULL,
  PRIMARY KEY (`rtid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resourcetype
-- ----------------------------
INSERT INTO `resourcetype` VALUES ('1', '图片');
INSERT INTO `resourcetype` VALUES ('2', '视频');
INSERT INTO `resourcetype` VALUES ('3', '文档');
INSERT INTO `resourcetype` VALUES ('4', '其他');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` char(32) NOT NULL,
  `type` char(1) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `education` varchar(5) DEFAULT NULL,
  `nativeplace` varchar(10) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `school` varchar(15) DEFAULT NULL,
  `college` varchar(10) DEFAULT NULL,
  `major` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('4028d08159f779ee0159f77e098f0000', '1', '牛旭', '', null, '', '', '', '', '', '', '');
INSERT INTO `role` VALUES ('4028d08159f788ce0159f797c2340000', '2', '朱科潜', '', null, '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for selectc
-- ----------------------------
DROP TABLE IF EXISTS `selectc`;
CREATE TABLE `selectc` (
  `cid` char(32) NOT NULL,
  `sid` char(32) NOT NULL,
  `selecttime` datetime NOT NULL,
  `gread` char(2) DEFAULT NULL,
  PRIMARY KEY (`cid`,`sid`),
  KEY `cid` (`cid`) USING BTREE,
  KEY `sid` (`sid`) USING BTREE,
  CONSTRAINT `selectc_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`),
  CONSTRAINT `selectc_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of selectc
-- ----------------------------
INSERT INTO `selectc` VALUES ('4028d08159f788ce0159f799b6940002', '4028d08159f788ce0159f797c2340000', '2017-02-01 11:10:31', null);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `taskid` char(32) NOT NULL,
  `cid` char(32) NOT NULL,
  `title` varchar(50) NOT NULL,
  `requirement` varchar(500) NOT NULL,
  `creattime` datetime NOT NULL,
  `endtime` date NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`taskid`),
  KEY `cid` (`cid`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('4028d08159f788ce0159f79cbf8a0004', '4028d08159f788ce0159f799b6940002', '12', '                                    ', '2017-02-01 10:59:22', '2017-02-08', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` char(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` char(32) NOT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `roleid` char(32) NOT NULL,
  PRIMARY KEY (`uid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4028d08159f779ee0159f77e09a40001', '牛旭', '96e79218965eb72c92a549dd5a330112', '2017-02-01 11:26:15', '4028d08159f779ee0159f77e098f0000');
INSERT INTO `user` VALUES ('4028d08159f788ce0159f797c2530001', 'zkq', '96e79218965eb72c92a549dd5a330112', '2017-02-01 11:21:28', '4028d08159f788ce0159f797c2340000');

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `taskid` char(32) NOT NULL,
  `sid` char(32) NOT NULL,
  `handtime` datetime NOT NULL,
  `title` varchar(50) NOT NULL,
  `explain` varchar(500) DEFAULT NULL,
  `attachmd5` char(32) DEFAULT NULL,
  `attachname` varchar(100) DEFAULT NULL,
  `tcomment` varchar(500) DEFAULT NULL,
  `score` float(2,0) DEFAULT NULL,
  `commenttime` datetime DEFAULT NULL,
  PRIMARY KEY (`taskid`,`sid`),
  KEY `work_ibfk_2` (`sid`),
  CONSTRAINT `work_ibfk_1` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`) ON DELETE CASCADE,
  CONSTRAINT `work_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `role` (`roleid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('4028d08159f788ce0159f79cbf8a0004', '4028d08159f788ce0159f797c2340000', '2017-02-01 11:22:08', 'dsa', 'asd', 'e7d17eacc4ace6935899003abed481aa', '屏幕截图(3).png', '', '12', '2017-02-01 11:36:00');
