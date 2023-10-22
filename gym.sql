
use gym;
SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE
IF
	EXISTS `admin`;
CREATE TABLE `admin` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT '唯一标识符，主键',
	`username` VARCHAR ( 50 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的用户名',
	`password` VARCHAR ( 255 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的密码，加密存储',
	`name` VARCHAR ( 100 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的真实姓名',
	`email` VARCHAR ( 100 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的电子邮件地址',
	`phone` VARCHAR ( 15 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员的手机号码',
	`managed_gym` INT NULL DEFAULT NULL COMMENT '所管理的健身会所的外键，关联到健身会所信息表的id字段',
	PRIMARY KEY ( `id` ) USING BTREE,
	UNIQUE INDEX `username` ( `username` ASC ) USING BTREE,
	UNIQUE INDEX `email` ( `email` ASC ) USING BTREE 
) ENGINE = INNODB AUTO_INCREMENT = 5 CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin`
VALUES
	( 1, 'admin', 'admin123', 'admin', '123', '123', 1 );
INSERT INTO `admin`
VALUES
	( 2, 'admin2', '123456', 'admin2', '123456', '123', 2 );
INSERT INTO `admin`
VALUES
	( 4, 'admin3', '123', 'admin3', 'xxxxx', '123', 0 );-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE
IF
	EXISTS `coach`;
CREATE TABLE `coach` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT '唯一标识符，主键',
	`name` VARCHAR ( 100 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教练的姓名',
	`contact_info` VARCHAR ( 255 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系信息',
	`qualifications` TEXT CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '资质',
	`gym_id` INT NOT NULL,
	PRIMARY KEY ( `id` ) USING BTREE 
) ENGINE = INNODB AUTO_INCREMENT = 3 CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach`
VALUES
	( 1, '张三', '1', '1', 1 );-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE
IF
	EXISTS `equipment`;
CREATE TABLE `equipment` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT '唯一标识符，主键',
	`name` VARCHAR ( 255 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '健身器材的名称',
	`description` TEXT CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '健身器材的描述',
	`quantity` INT NULL DEFAULT NULL COMMENT '数量',
	`gym_id` INT NOT NULL,
	PRIMARY KEY ( `id` ) USING BTREE 
) ENGINE = INNODB AUTO_INCREMENT = 3 CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment`
VALUES
	( 1, '哑铃', '1', 5, 1 );-- ----------------------------
-- Table structure for gym_club
-- ----------------------------
DROP TABLE
IF
	EXISTS `gym_club`;
CREATE TABLE `gym_club` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT '唯一标识符，主键',
	`name` VARCHAR ( 255 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '健身会所或俱乐部的名称',
	`description` TEXT CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '健身会所或俱乐部的简介',
	`country` VARCHAR ( 50 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '国家',
	`city` VARCHAR ( 50 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
	`street_address` VARCHAR ( 255 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '街道地址',
	`phone` VARCHAR ( 15 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
	`business_hours` VARCHAR ( 50 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '营业时间',
	`average_rating` DECIMAL ( 3, 2 ) NULL DEFAULT NULL COMMENT '用户对健身会所的平均评分',
	PRIMARY KEY ( `id` ) USING BTREE,
	UNIQUE INDEX `name` ( `name` ASC ) USING BTREE 
) ENGINE = INNODB AUTO_INCREMENT = 14 CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Records of gym_club
-- ----------------------------
INSERT INTO `gym_club`
VALUES
	( 1, 'Gym Club 0', 'Description 0', 'Country 0', 'City 0', 'Street Address 0', 'Phone 0', 'Business Hours 0', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 2, 'Gym Club 1', 'Description 1', 'Country 1', 'City 1', 'Street Address 1', 'Phone 1', 'Business Hours 1', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 3, 'Gym Club 2', 'Description 2', 'Country 2', 'City 2', 'Street Address 2', 'Phone 2', 'Business Hours 2', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 4, 'Gym Club 3', 'Description 3', 'Country 3', 'City 3', 'Street Address 3', 'Phone 3', 'Business Hours 3', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 5, 'Gym Club 4', 'Description 4', 'Country 4', 'City 4', 'Street Address 4', 'Phone 4', 'Business Hours 4', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 6, 'Gym Club 5', 'Description 5', 'Country 5', 'City 5', 'Street Address 5', 'Phone 5', 'Business Hours 5', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 7, 'Gym Club 6', 'Description 6', 'Country 6', 'City 6', 'Street Address 6', 'Phone 6', 'Business Hours 6', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 8, 'Gym Club 7', 'Description 7', 'Country 7', 'City 7', 'Street Address 7', 'Phone 7', 'Business Hours 7', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 9, 'Gym Club 8', 'Description 8', 'Country 8', 'City 8', 'Street Address 8', 'Phone 8', 'Business Hours 8', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 10, 'Gym Club 9', 'Description 9', 'Country 9', 'City 9', 'Street Address 9', 'Phone 9', 'Business Hours 9', 4.50 );
INSERT INTO `gym_club`
VALUES
	( 12, 'gym_test', '1', '1', '1', '1', '1', '', NULL );
INSERT INTO `gym_club`
VALUES
	( 13, 'hahaha', '1', '1', '1', '1', '1', '1', NULL );-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE
IF
	EXISTS `user`;
CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR ( 50 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`password` VARCHAR ( 22 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`tele` VARCHAR ( 20 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	`address` VARCHAR ( 100 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	`age` INT NULL DEFAULT NULL,
	`sex` ENUM ( '男', '女' ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	PRIMARY KEY ( `id` ) USING BTREE,
	UNIQUE INDEX `tele` ( `tele` ASC ) USING BTREE,
	CONSTRAINT `user_chk_1` CHECK ( `age` >= 0 ) 
) ENGINE = INNODB AUTO_INCREMENT = 50 CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES
	( 22, '小张', '123456', '12345678910', '湖南省', 18, '女' );
INSERT INTO `user`
VALUES
	( 31, '小刘', '', '12345678919', '湖南省', 33, '女' );
INSERT INTO `user`
VALUES
	( 32, '小明', '', '123456789110', '湖南省', 32, '男' );
INSERT INTO `user`
VALUES
	( 33, '小明', '', '123456789111', '湖南省', 33, '男' );
INSERT INTO `user`
VALUES
	( 34, '小明', '', '123456789112', '湖南省', 34, '男' );
INSERT INTO `user`
VALUES
	( 35, '小明', '', '123456789113', '湖南省', 35, '男' );
INSERT INTO `user`
VALUES
	( 36, '小明', '', '123456789114', '湖南省', 36, '男' );
INSERT INTO `user`
VALUES
	( 37, '小明', '', '123456789115', '湖南省', 37, '男' );
INSERT INTO `user`
VALUES
	( 38, '小明', '', '123456789116', '湖南省', 38, '男' );
INSERT INTO `user`
VALUES
	( 39, '小明', '', '123456789117', '湖南省', 39, '男' );
INSERT INTO `user`
VALUES
	( 40, '小明', '', '123456789118', '湖南省', 40, '男' );
INSERT INTO `user`
VALUES
	( 41, '小明', '', '123456789119', '湖南省', 41, '男' );
INSERT INTO `user`
VALUES
	( 42, '测试', 'admin123456', '1023456789', '重庆市', 11, '男' );
INSERT INTO `user`
VALUES
	( 43, 'ceshi', 'admin123456', '11023456789', '重庆市', 12, '男' );
INSERT INTO `user`
VALUES
	( 44, '123', 'admin123456', '123', '重庆市', 23, '男' );
INSERT INTO `user`
VALUES
	( 45, '123', 'admin123456', '123456', '重庆市', 44, '男' );
INSERT INTO `user`
VALUES
	( 46, 'ceshi007', 'admin123456', '12345677890', '重庆市', 12, '女' );
INSERT INTO `user`
VALUES
	( 48, 'ceshi008', 'admin123456', '1233456789', '重庆市', 18, '男' );
INSERT INTO `user`
VALUES
	( 49, 'ceshi009', 'admin123456', '213344567', '重庆市', 18, '男' );-- ----------------------------
-- Table structure for user_review
-- ----------------------------
DROP TABLE
IF
	EXISTS `user_review`;
CREATE TABLE `user_review` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT '唯一标识符，主键',
	`gym_club_id` INT NULL DEFAULT NULL COMMENT '健身会所的外键，关联到健身会所信息表的id字段',
	`user_id` INT NULL DEFAULT NULL COMMENT '用户的外键，关联到管理员信息表的id字段',
	`review_text` TEXT CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户对健身会所的评论',
	`rating` DECIMAL ( 3, 2 ) NULL DEFAULT NULL COMMENT '评分',
	`review_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
	PRIMARY KEY ( `id` ) USING BTREE 
) ENGINE = INNODB CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Records of user_review
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;