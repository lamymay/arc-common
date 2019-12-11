package com.arc.core.model.request.system;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author may
 * @since 2019/12/10 12:40
 */
@Data
public class FileRequest {

    private Long id;
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
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

}
