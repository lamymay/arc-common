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
public class Mall {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键ID
    private String taskName;// 任务名称                 c
    private String mallName;// 任务所属商场         aa
    private String mallArea;// 门店地址，具体地址 ab


    //地址是一对一的关系 可以在从表进行关联    系统有一个统一地址库， 注意地址库与地址表是两张表
    //建议新建地址表， 关联关系放在地址表重维护， 后期可以一个东西关联多个地址使用！ ，现在2019、01、15先在mall表重保存地址信息，
    private String provinceName;// 省                    x
    private String cityName;// 市                            y
    private String districtName;// 区                      z

    private String townName;// 镇                         备用
    private String road;// 街道                                 任务编码 暂时使用

    //    private String code;// 任务编码
    private String note;// 备注                                 备用


}
