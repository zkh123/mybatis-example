/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : news_test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-24 17:23:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ping_tb
-- ----------------------------
DROP TABLE IF EXISTS `ping_tb`;
CREATE TABLE `ping_tb` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userid` bigint(20) NOT NULL COMMENT '用户标识',
  `listingid` bigint(20) DEFAULT NULL COMMENT '标的',
  `bizid` int(11) DEFAULT NULL COMMENT '业务标识',
  `zuid` int(11) DEFAULT NULL COMMENT '业务分组',
  `dingid` int(11) DEFAULT NULL COMMENT '业务定义',
  `months` int(11) DEFAULT NULL COMMENT '区分业务',
  `credit_score` decimal(20,16) DEFAULT NULL,
  `credit_level` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信用评级',
  `credit_bin` int(11) DEFAULT NULL COMMENT 'bin值',
  `credit_level_pro` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '前台评级',
  `model_label` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模型标签',
  `model_ver` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模型版本',
  `process_flag` int(11) DEFAULT NULL COMMENT '审批结论',
  `block_days` int(11) DEFAULT NULL COMMENT '禁言天数',
  `info` text COLLATE utf8mb4_unicode_ci COMMENT '扩展Json',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `idx_inserttime` (`inserttime`),
  KEY `idx_updatetime` (`updatetime`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ping /*# Owner: huanglijun ;Manager: wuyiming #*/';

-- ----------------------------
-- Records of ping_tb
-- ----------------------------
INSERT INTO `ping_tb` VALUES ('1', '10000', '-1', '1201', '103', '103', '-2', '0.1230000033974648', 'A', '1', 'AA', 'yici', 'v3_201804', '1', '31', '{\"a\": 123, \"b\": 456}', '2018-04-02 16:24:50', '2018-04-02 16:24:50', '1');
INSERT INTO `ping_tb` VALUES ('2', '10000', '-1', '1201', '103', '-1', '-2', '-1.0000000000000000', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '{\"credit_jiangji\": \"AA\", \"credit_duotou\": \"BB\"}', '2018-04-02 18:00:33', '2018-04-02 18:00:33', '1');
INSERT INTO `ping_tb` VALUES ('56', '2000', '-20', '110', '103', '-1', '-2', '-1.0000000000000000', 'B', '-1', 'BB', 'appyi', 'v3_201804', '-1', '300', '{\"上海\":\"shanghai\",\"北京\":\"beijing\"}', '2018-10-24 15:17:56', '2018-10-24 17:11:32', '1');
