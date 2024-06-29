package com.nageoffer.shortlink.project.test;

public class ShortLinkTableShardingTest {

    public static String SQL = "CREATE TABLE `t_link_%d` (\n" +
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

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n",i);
        }
    }
}
