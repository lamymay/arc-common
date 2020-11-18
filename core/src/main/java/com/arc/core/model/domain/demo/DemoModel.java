package com.arc.core.model.domain.demo;

import com.arc.core.enums.common.EnableEnum;
import com.arc.core.enums.common.GenderEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 枚举属性测试
 *
 * @author yechao
 * @date 2020/9/8 9:40 上午
 */
@Setter
@Getter
@ToString
public class DemoModel {

    private Long id;//主键id
    private String name;//名称
    private Integer age;//年龄

    /**
     * 简单枚举测试,db中列是varchar 映射到 简单枚举
     */
    private EnableEnum enable;//是否可用

    /**
     * 复杂枚举测试,db中是数字 映射到 复杂枚举 EMUN1(1,"message")
     */
    private GenderEnum gender;//性别

    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}
/*
CREATE TABLE `test_enum_domain` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键PK',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `age` int NOT NULL COMMENT '名称',
  `enable` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否可用',
  `gender` int DEFAULT NULL COMMENT '性别',
  `create_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


* */
