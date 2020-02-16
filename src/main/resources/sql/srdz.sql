/*
 Navicat Premium Data Transfer

 Source Server         : my_mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : srdz

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 16/02/2020 14:31:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer_addr
-- ----------------------------
DROP TABLE IF EXISTS `customer_addr`;
CREATE TABLE `customer_addr` (
  `customer_addr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` int(10) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `province` smallint(6) NOT NULL COMMENT '地区表中省份的ID',
  `city` smallint(6) NOT NULL COMMENT '地区表中城市的ID',
  `district` smallint(6) NOT NULL COMMENT '地区表中的区ID',
  `address` varchar(200) NOT NULL COMMENT '具体的地址门牌号',
  `is_default` tinyint(4) NOT NULL COMMENT '是否默认',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `zip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_addr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='用户地址表';

-- ----------------------------
-- Records of customer_addr
-- ----------------------------
BEGIN;
INSERT INTO `customer_addr` VALUES (1, 1, 1, 1, 1, '1', 1, '2019-10-16 13:10:00', NULL);
INSERT INTO `customer_addr` VALUES (2, 1, 1, 1, 1, '1', 1, '2019-10-16 13:10:00', NULL);
INSERT INTO `customer_addr` VALUES (3, 8, 2, 1, 2, '上海市普陀区中山北路华东师范大学', 1, '2020-01-13 11:40:54', NULL);
INSERT INTO `customer_addr` VALUES (4, 8, 2, 1, 2, '上海市普陀区中山北路华东师范大学', 1, '2020-01-13 11:42:50', NULL);
INSERT INTO `customer_addr` VALUES (5, 8, 2, 1, 2, '上海市普陀区中山北路华东师范大学', 1, '2020-01-13 11:44:47', NULL);
INSERT INTO `customer_addr` VALUES (6, 8, 2, 1, 2, '上海市普陀区中山北路华东师范大学', 1, '2020-01-13 11:47:52', NULL);
INSERT INTO `customer_addr` VALUES (7, 8, 2, 1, 2, '上海市普陀区中山北路华东师范大学', 1, '2020-01-13 12:06:06', NULL);
INSERT INTO `customer_addr` VALUES (8, 8, 2, 1, 2, '上海市普陀区中山北路华东师范大学', 1, '2020-01-13 12:40:00', NULL);
INSERT INTO `customer_addr` VALUES (9, 14, 1, 1, 1, '上海市普陀区中山北路华东师范大学', 1, '2020-01-18 20:58:10', '2356775');
INSERT INTO `customer_addr` VALUES (10, 14, 1, 1, 1, '上海市普陀区中山北路华东师范大学', 1, '2020-01-26 17:49:37', '2356775');
INSERT INTO `customer_addr` VALUES (11, 14, 1, 1, 1, '上海市普陀区中山北路华东师范大学', 1, '2020-01-26 20:37:15', '2356775');
INSERT INTO `customer_addr` VALUES (12, 8, 1, 1, 1, '无', 1, '2020-02-13 16:31:46', '201000');
COMMIT;

-- ----------------------------
-- Table structure for customer_inf
-- ----------------------------
DROP TABLE IF EXISTS `customer_inf`;
CREATE TABLE `customer_inf` (
  `customer_inf_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` int(10) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `customer_name` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `identity_card_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `identity_card_no` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `customer_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `user_point` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `birthday` datetime DEFAULT NULL COMMENT '会员生日',
  `customer_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  `user_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `mobile_phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`customer_inf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of customer_inf
-- ----------------------------
BEGIN;
INSERT INTO `customer_inf` VALUES (1, 1, 'jas', 1, '232', '1232', '1', 2, '2019-09-23 00:00:00', '2019-10-16 13:10:00', 1, 12.34, '2019-10-16 13:10:00', '12');
INSERT INTO `customer_inf` VALUES (2, 14, '将同TEST', 1, '100010100110', '1962424201@qq.com', '1', 1, '2020-01-18 12:58:10', '2020-01-18 12:58:10', 1, 0.00, '2020-01-18 20:58:10', '13955846598');
INSERT INTO `customer_inf` VALUES (3, 14, '将同TEST', 1, '100010100110', '1962424201@qq.com', '1', 1, '2020-01-26 09:49:37', '2020-01-26 09:49:37', 1, 0.00, '2020-01-26 17:49:37', '13955846598');
INSERT INTO `customer_inf` VALUES (4, 14, '将同TEST', 1, '100010100110', '1962424201@qq.com', '1', 1, '2020-01-26 12:37:15', '2020-01-26 12:37:15', 1, 0.00, '2020-01-26 20:37:15', '13955846598');
INSERT INTO `customer_inf` VALUES (5, 8, 'Tong Jasen', 1, '100010100110', '1962424201@qq.comcn', '男', 1, '2020-02-13 08:31:46', '2020-02-13 08:31:46', 1, 0.00, '2020-02-13 16:31:46', '15710631292');
COMMIT;

-- ----------------------------
-- Table structure for customer_login
-- ----------------------------
DROP TABLE IF EXISTS `customer_login`;
CREATE TABLE `customer_login` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(20) NOT NULL COMMENT '用户登录名',
  `password` char(32) NOT NULL COMMENT 'md5加密的密码',
  `user_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='customer登录表';

-- ----------------------------
-- Records of customer_login
-- ----------------------------
BEGIN;
INSERT INTO `customer_login` VALUES (1, 'walt', 'walt', 1, '2020-01-12 08:10:22');
INSERT INTO `customer_login` VALUES (2, 'walt', 'walt', 1, '2020-01-12 08:52:00');
INSERT INTO `customer_login` VALUES (3, 'walt', 'walt', 1, '2020-01-12 08:52:36');
INSERT INTO `customer_login` VALUES (4, 'walt', 'walt', 1, '2020-01-12 08:53:09');
INSERT INTO `customer_login` VALUES (5, 'walt', 'walt', 1, '2020-01-12 08:54:35');
INSERT INTO `customer_login` VALUES (6, 'walt', 'walt', 1, '2020-01-12 09:51:03');
INSERT INTO `customer_login` VALUES (7, 'walt', 'walt', 1, '2020-01-12 10:12:03');
INSERT INTO `customer_login` VALUES (8, 'jasen', '123456', 1, '2020-01-13 09:56:27');
INSERT INTO `customer_login` VALUES (9, 'walt', 'walt', 1, '2020-01-13 12:38:38');
INSERT INTO `customer_login` VALUES (10, 'jasen', '123456', 1, '2020-01-13 12:40:01');
INSERT INTO `customer_login` VALUES (11, 'walt', 'walt', 1, '2020-01-13 12:40:01');
INSERT INTO `customer_login` VALUES (12, 'walt', 'walt', 1, '2020-01-13 12:42:38');
INSERT INTO `customer_login` VALUES (13, 'jasen', '123456', 1, '2020-01-18 20:43:51');
INSERT INTO `customer_login` VALUES (14, 'jasenTEST', 'change202014', 1, '2020-01-18 20:48:16');
INSERT INTO `customer_login` VALUES (15, 'jasenTEST', '123456TEST', 1, '2020-01-18 20:51:48');
INSERT INTO `customer_login` VALUES (16, 'jasenTEST', '123456TEST', 1, '2020-01-18 20:57:21');
INSERT INTO `customer_login` VALUES (17, 'jasenTEST', '123456TEST', 1, '2020-01-18 20:58:10');
INSERT INTO `customer_login` VALUES (18, 'jasenTEST', '123456TEST', 1, '2020-01-26 17:49:36');
INSERT INTO `customer_login` VALUES (19, 'jasenTEST', '123456TEST', 1, '2020-01-26 20:37:15');
INSERT INTO `customer_login` VALUES (20, 'jasen', '123456', 1, '2020-02-13 16:31:46');
COMMIT;

-- ----------------------------
-- Table structure for customer_login_log
-- ----------------------------
DROP TABLE IF EXISTS `customer_login_log`;
CREATE TABLE `customer_login_log` (
  `login_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '登陆日志ID',
  `customer_id` int(10) unsigned NOT NULL COMMENT '登陆用户ID',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户登陆时间',
  `login_ip` int(10) unsigned NOT NULL COMMENT '登陆IP',
  `login_type` tinyint(4) NOT NULL COMMENT '登陆类型：0未成功，1成功',
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登陆日志表';

-- ----------------------------
-- Table structure for designer_inf
-- ----------------------------
DROP TABLE IF EXISTS `designer_inf`;
CREATE TABLE `designer_inf` (
  `designer_inf_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `designer_id` int(10) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `designer_name` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `identity_card_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `identity_card_no` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `mobile_phone` varchar(30) DEFAULT NULL,
  `designer_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `user_point` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `birthday` datetime DEFAULT NULL COMMENT '会员生日',
  `designer_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  `user_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`designer_inf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of designer_inf
-- ----------------------------
BEGIN;
INSERT INTO `designer_inf` VALUES (1, 6, '将同TEST', 1, '100010100110', '13955846598', '1962424201@qq.com', '1', 1, '2020-01-26 11:57:33', '2020-01-26 11:57:33', 1, 0.00, '2020-01-26 19:57:33');
INSERT INTO `designer_inf` VALUES (2, 6, '将同TEST', 1, '100010100110', '13955846598', '1962424201@qq.com', '1', 1, '2020-01-26 12:36:19', '2020-01-26 12:36:19', 1, 0.00, '2020-01-26 20:36:19');
INSERT INTO `designer_inf` VALUES (3, 6, '将同TEST', 1, '100010100110', '13955846598', '1962424201@qq.com', '1', 1, '2020-01-26 12:36:22', '2020-01-26 12:36:22', 1, 0.00, '2020-01-26 20:36:22');
INSERT INTO `designer_inf` VALUES (4, 6, '将同TEST', 1, '100010100110', '13955846598', '1962424201@qq.com', '1', 1, '2020-01-26 12:36:25', '2020-01-26 12:36:25', 1, 0.00, '2020-01-26 20:36:24');
COMMIT;

-- ----------------------------
-- Table structure for designer_login
-- ----------------------------
DROP TABLE IF EXISTS `designer_login`;
CREATE TABLE `designer_login` (
  `designer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(20) NOT NULL COMMENT '用户登录名',
  `password` char(32) NOT NULL COMMENT 'md5加密的密码',
  `user_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `page_url` varchar(1000) DEFAULT NULL COMMENT '每个designer的页面地址',
  PRIMARY KEY (`designer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='用户登录表';

-- ----------------------------
-- Records of designer_login
-- ----------------------------
BEGIN;
INSERT INTO `designer_login` VALUES (1, 'jasen', '123456', 1, '2020-01-26 18:30:09', NULL);
INSERT INTO `designer_login` VALUES (3, 'jasen', '123456', 1, '2020-01-26 19:49:21', 'www.qq.com');
INSERT INTO `designer_login` VALUES (4, 'jasen', '123456', 1, '2020-01-26 19:53:35', 'www.qq.com');
INSERT INTO `designer_login` VALUES (6, 'jasenTEST', '123456TEST', 1, '2020-01-26 19:57:33', NULL);
INSERT INTO `designer_login` VALUES (7, 'jasenTEST', '123456TEST', 1, '2020-01-26 20:36:19', NULL);
INSERT INTO `designer_login` VALUES (8, 'jasenTEST', '123456TEST', 1, '2020-01-26 20:36:22', NULL);
INSERT INTO `designer_login` VALUES (9, 'jasenTEST', '123456TEST', 1, '2020-01-26 20:36:24', NULL);
COMMIT;

-- ----------------------------
-- Table structure for need_content
-- ----------------------------
DROP TABLE IF EXISTS `need_content`;
CREATE TABLE `need_content` (
  `need_content_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '需求详情表ID',
  `costomer_id` int(10) unsigned NOT NULL COMMENT '消费者id from cache',
  `designer_id` int(10) unsigned NOT NULL COMMENT '设计师id from cache',
  `content` text NOT NULL,
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `plan_content` text COMMENT '定制方案',
  `status` smallint(6) DEFAULT NULL,
  `need_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '方案价格',
  `need_title` text COMMENT '需求标题',
  `need_count` int(10) unsigned NOT NULL COMMENT '需求个数',
  PRIMARY KEY (`need_content_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='提交需求详情';

-- ----------------------------
-- Records of need_content
-- ----------------------------
BEGIN;
INSERT INTO `need_content` VALUES (1, 1, 1, 'hello!jasen\'s first trying,I will success', '2020-02-14 13:06:39', 'ok,I will give the plan', 100, 23.45, NULL, 0);
INSERT INTO `need_content` VALUES (2, 1, 1, 'hello!jasen\'s first trying,I will success', '2020-01-24 20:06:15', NULL, 1, 0.00, NULL, 0);
INSERT INTO `need_content` VALUES (3, 1, 1, 'hello!jasen\'s first trying,I will success', '2020-01-26 21:33:07', 'ok,I will give the plan', 2, 234.50, '蛋糕定制', 0);
INSERT INTO `need_content` VALUES (4, 1, 1, 'hello!jasen\'s first trying,I will success', '2020-01-26 21:34:21', 'ok,I will give the plan', 2, 234.50, '蛋糕定制', 10);
COMMIT;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
  `order_id` int(10) unsigned NOT NULL COMMENT '订单表ID',
  `content_id` int(10) unsigned NOT NULL COMMENT '提交内容ID',
  `product_name` varchar(50) NOT NULL COMMENT '商品名称',
  `product_cnt` int(11) NOT NULL DEFAULT '1' COMMENT '购买商品数量',
  `product_price` decimal(8,2) NOT NULL COMMENT '购买商品单价',
  `average_cost` decimal(8,2) NOT NULL COMMENT '平均成本价格',
  `weight` float DEFAULT NULL COMMENT '商品重量',
  `fee_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '优惠分摊金额',
  `w_id` int(10) unsigned NOT NULL COMMENT '仓库ID',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_sn` varchar(100) DEFAULT NULL,
  `customer_id` int(10) unsigned NOT NULL COMMENT '下单人ID',
  `shipping_user` varchar(10) NOT NULL COMMENT '收货人姓名',
  `province` smallint(6) NOT NULL COMMENT '省',
  `city` smallint(6) NOT NULL COMMENT '市',
  `district` smallint(6) NOT NULL COMMENT '区',
  `address` varchar(100) NOT NULL COMMENT '地址',
  `payment_method` tinyint(4) NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  `order_money` decimal(8,2) NOT NULL COMMENT '订单金额',
  `district_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `shipping_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '运费金额',
  `payment_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
  `shipping_comp_name` varchar(10) DEFAULT NULL COMMENT '快递公司名称',
  `shipping_sn` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `shipping_time` datetime DEFAULT NULL COMMENT '发货时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `order_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `order_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单积分',
  `invoice_time` varchar(100) DEFAULT NULL COMMENT '发票抬头',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单主表';

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file` (
  `upload_file_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '上传文件的ID',
  `designer_id` int(10) unsigned NOT NULL COMMENT '设计师id',
  `file_title` text NOT NULL COMMENT '文件标题',
  `file_count` int(10) unsigned NOT NULL COMMENT '文件个数',
  `file_dest` varchar(1000) NOT NULL COMMENT '文件路径',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`upload_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件上传表';

SET FOREIGN_KEY_CHECKS = 1;
