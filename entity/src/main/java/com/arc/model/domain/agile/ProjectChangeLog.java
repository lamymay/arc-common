package com.arc.model.domain.agile;


import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 项目数据修改日志表
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Getter
@Setter
public class ProjectChangeLog extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 项目数据修改日志表ID
    private Long projectId;// 项目表ID
    private String name;// 名称-128
    private String note;// 注释
    private String version;// 版本
    private String url;// 地址
    private Date issueChangeDate;// 变化时间
    private Date createDate;// 创建时间
}
