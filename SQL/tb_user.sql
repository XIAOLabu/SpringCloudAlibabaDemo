/*
Navicat MySQL Data Transfer

Source Server         : hk
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : dev_cloud_product

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-12-24 16:07:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `c_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `up_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `level` int(4) DEFAULT NULL COMMENT '级别',
  `spare` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `display` int(4) DEFAULT NULL COMMENT '是否展示；1展示；0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
