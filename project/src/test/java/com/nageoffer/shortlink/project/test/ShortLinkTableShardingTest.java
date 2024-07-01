package com.nageoffer.shortlink.project.test;

public class ShortLinkTableShardingTest {

    // 短连接表
    public static String SQL1 = "CREATE TABLE `t_link_%d` (\n" +
            "  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `domain` VARCHAR(128) DEFAULT NULL COMMENT '域名',\n" +
            "  `short_uri` VARCHAR(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '短链接',\n" +
            "  `full_short_url` VARCHAR(128) DEFAULT NULL COMMENT '完整短链接',\n" +
            "  `origin_url` VARCHAR(1024) DEFAULT NULL COMMENT '原始链接',\n" +
            "  `click_num` INT DEFAULT '0' COMMENT '点击量',\n" +
            "  `gid` VARCHAR(32) DEFAULT NULL COMMENT '分组标识',\n" +
            "  `enable_status` TINYINT(1) DEFAULT NULL COMMENT '启用标识 0：未启用 1：已启用',\n" +
            "  `created_type` TINYINT(1) DEFAULT NULL COMMENT '创建类型 0：控制台 1：接口',\n" +
            "  `valid_date_type` TINYINT(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：用户自定义',\n" +
            "  `valid_date` DATETIME DEFAULT NULL COMMENT '有效期',\n" +
            "  `describe` VARCHAR(1024) DEFAULT NULL COMMENT '描述',\n" +
            "  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',\n" +
            "  `del_flag` TINYINT(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_full_short_url` (`full_short_url`) USING BTREE\n" +
            ") ENGINE=INNODB AUTO_INCREMENT=1762385842304753667 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

    // 短连接分组表
    public static String SQL2 = "create table `t_group_%d`\n" +
            "(\n" +
            "    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',\n" +
            "    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',\n" +
            "    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',\n" +
            "    `sort_order`  int(3)        DEFAULT NULL COMMENT '分组排序',\n" +
            "    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',\n" +
            "    `update_time` datetime    DEFAULT NULL COMMENT '修改时间',\n" +
            "    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',\n" +
            "    PRIMARY KEY (`id`),\n" +
            "    UNIQUE KEY `idx_unique_username_gid` (gid, username) USING BTREE\n" +
            ")ENGINE=InnoDB AUTO_INCREMENT=1716734146606301186 DEFAULT CHARSET=utf8mb4;";

    // 路由表，通过短连接的 shortUri 来获取到短连接的 gid
    // 原因是短连接是通过 gid 进行分片的，但我们的跳转需要通过 shortUri 来获取到 fullUri 的，所以需要一张路由表
    public static String SQL3 = "CREATE TABLE `t_link_goto_%d`(\n" +
            "      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "      `gid` varchar(32) DEFAULT 'default' COMMENT  '分组标识',\n" +
            "      `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',\n" +
            "      PRIMARY KEY (`id`))\n" +
            "      ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

    public static String SQL4 = "CREATE TABLE `t_link_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `domain` varchar(128) DEFAULT NULL COMMENT '域名',\n" +
            "  `short_uri` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '短链接',\n" +
            "  `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',\n" +
            "  `origin_url` varchar(1024) DEFAULT NULL COMMENT '原始链接',\n" +
            "  `click_num` int DEFAULT '0' COMMENT '点击量',\n" +
            "  `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',\n" +
            "  `favicon` varchar(256) DEFAULT NULL COMMENT '网站图标',\n" +
            "  `enable_status` tinyint(1) DEFAULT NULL COMMENT '启用标识 0：未启用 1：已启用',\n" +
            "  `created_type` tinyint(1) DEFAULT NULL COMMENT '创建类型 0：控制台 1：接口',\n" +
            "  `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：用户自定义',\n" +
            "  `valid_date` datetime DEFAULT NULL COMMENT '有效期',\n" +
            "  `describe` varchar(1024) DEFAULT NULL COMMENT '描述',\n" +
            "  `total_pv` int(11) DEFAULT NULL COMMENT '历史PV',\n" +
            "  `total_uv` int(11) DEFAULT NULL COMMENT '历史UV',\n" +
            "  `total_uip` int(11) DEFAULT NULL COMMENT '历史UIP',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '修改时间',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_full-short_url` (`full_short_url`) USING BTREE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;";

    public static String SQL5 = "CREATE TABLE `t_link_stats_today_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',\n" +
            "  `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',\n" +
            "  `date` date DEFAULT NULL COMMENT '日期',\n" +
            "  `today_pv` int(11) DEFAULT NULL COMMENT '今日PV',\n" +
            "  `today_uv` int(11) DEFAULT NULL COMMENT '今日UV',\n" +
            "  `today_ip_count` int(11) DEFAULT NULL COMMENT '今日IP数',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_gid_date` (`gid`, `date`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;";


    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL5) + "%n", i);
        }
    }
}
