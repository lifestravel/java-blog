# java-blog
个人博客项目

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-08-23 22:24:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------

-- 博客表
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` longtext NOT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `flag` varchar(20) DEFAULT NULL,
  `views` int(11) DEFAULT '10',
  `appreciation` tinyint(1) DEFAULT '1',
  `shareStatement` tinyint(1) DEFAULT '1',
  `commentable` tinyint(1) DEFAULT '1',
  `publish` tinyint(1) DEFAULT '1',
  `recommended` tinyint(1) DEFAULT '1',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(300) DEFAULT NULL,
  `commentCount` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for blogtype
-- ----------------------------
-- 博客与博客类型关联表
DROP TABLE IF EXISTS `blogtype`;
CREATE TABLE `blogtype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blogId` bigint(20) NOT NULL,
  `typeId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for comment
-- ----------------------------

-- 博客下边的评论表
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) DEFAULT NULL,
  `content` text,
  `email` varchar(50) DEFAULT NULL,
  `headImg` varchar(100) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `targetUser` varchar(100) DEFAULT NULL,
  `level` tinyint(1) DEFAULT NULL,
  `parCommentId` bigint(20) DEFAULT NULL,
  `blogId` bigint(20) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for friendlink
-- ----------------------------

-- 朋友链接表
DROP TABLE IF EXISTS `friendlink`;
CREATE TABLE `friendlink` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blogName` varchar(100) NOT NULL,
  `blogAddress` varchar(100) NOT NULL,
  `pictureAddress` varchar(200) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for leavemessage
-- ----------------------------

-- 留言表(在留言表，不是评论)
DROP TABLE IF EXISTS `leavemessage`;
CREATE TABLE `leavemessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) DEFAULT NULL,
  `content` text,
  `email` varchar(50) DEFAULT NULL,
  `headImg` varchar(100) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `targetUser` varchar(100) DEFAULT NULL,
  `level` tinyint(1) DEFAULT NULL,
  `parLeaveMessageId` bigint(20) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for photo
-- ----------------------------

-- 照片墙的照片表
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `photoName` varchar(100) NOT NULL,
  `photoAddress` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for type
-- ----------------------------
-- 博客类型表
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `blogCount` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickName` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `headImg` varchar(200) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for userblog
-- ----------------------------

-- 用户与博客的关联表
DROP TABLE IF EXISTS `userblog`;
CREATE TABLE `userblog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `blogId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
