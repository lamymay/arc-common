package com.arc.model.domain.system;

import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户组表
 *
 */
@Getter
@Setter
public class SysUserGroup extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 自增ID号
    private String name;// 用户组名
    private String power;// 用户权限

    private Integer active;// 状态
    private String description;// 说明
    private String groupType;// 类型

    private Date updateDate;// 更新时间
    private Date createDate;// 创建时间
}
