package com.arc.core.model.domain.system;

import com.arc.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 系统文件记录
 */
@Getter
@Setter
@ToString
public class SysFile extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;//
    private String code;// 版本号
    private String name;// 显示名称
    private String suffix;// 后缀
    private String type;// 类型
    private Integer version;// 版本信息id

    private Long size;// 文件大小
    private String sizeUnit;// 文件大小单位
    private String remark;// 描述

    private String url;// 文件存放url
    private String path;// 文件存放url

    private Integer state;// 逻辑删除用的标识

    private String key;// 文件标识
    private String checkType;// 校验方式
    private String checkCode;// 校验码
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间


}
