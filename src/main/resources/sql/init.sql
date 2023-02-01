drop database if exists db_springboot;
create database db_springboot;
use db_springboot;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `user_name_cn` varchar(50) NOT NULL COMMENT '中文名',
  `user_name_en` varchar(50) DEFAULT NULL COMMENT '英文名',
  `status` bigint(20) DEFAULT NULL COMMENT '用户状态',
  `age` bigint(20) DEFAULT NULL COMMENT '年龄',
  `sex` bigint(20) DEFAULT NULL COMMENT '性别，0女，1男',
  `birth` date DEFAULT NULL COMMENT '生日',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮编',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `address_now` varchar(100) DEFAULT NULL COMMENT '现住址',
  `identity_card` varchar(100) DEFAULT NULL COMMENT '身份证',
  `native_place` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `country` varchar(50) DEFAULT NULL COMMENT '国家',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `town` varchar(50) DEFAULT NULL COMMENT '县/区',
  `user_type` varchar(50) DEFAULT NULL COMMENT '用户类型',
  `introduction` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_ip` varchar(10) DEFAULT NULL COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` bigint(20) DEFAULT NULL COMMENT '是否删除，0正常，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '菜单名',
  `name_us` varchar(50) DEFAULT NULL COMMENT '菜单英文名',
  `url` varchar(50) NOT NULL COMMENT '菜单url',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父ids',
  `type` bigint(20) DEFAULT NULL COMMENT '菜单类型',
  `sort` bigint(20) DEFAULT NULL COMMENT '菜单顺序',
  `is_parent` varchar(10) DEFAULT NULL COMMENT '是否父菜单:false，true',
  `code` varchar(50) DEFAULT NULL COMMENT '菜单编号',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `language` varchar(100) DEFAULT NULL COMMENT '语言',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` bigint(20) DEFAULT NULL COMMENT '是否删除，0正常，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';


DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `name_us` varchar(50) DEFAULT NULL COMMENT '角色英文名',
  `type` bigint(20) DEFAULT NULL COMMENT '角色类型',
  `org_id` varchar(50) DEFAULT NULL COMMENT '归属机构id',
  `is_sys` bigint(20) DEFAULT NULL COMMENT '是否系统数据，0否，1是',
  `status` bigint(20) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` bigint(20) DEFAULT NULL COMMENT '是否删除，0正常，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` bigint(20) DEFAULT NULL COMMENT '是否删除，0正常，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';


DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` bigint(20) DEFAULT NULL COMMENT '是否删除，0正常，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';






