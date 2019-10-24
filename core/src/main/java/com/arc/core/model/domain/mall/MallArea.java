package com.arc.core.model.domain.mall;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@ToString
public class MallArea {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键ID
    private Long mallId;//mall的id，做关联
    private Long areaCode;// 地区代码

    //@todo 修改表     数据库的重构，  mall为主对象，从属一对多 或者一对一关联多个子属性 ，
//    、、关联关系有，
//    mall_area 11
//    mall_question 1-*
//    mall_task 1-*

    private String shortCode;// 地区代码
    private String areaName;// 地区名称
    private String tag;// 地址标签
    private String note;// 备注
}
