package com.arc.model.domain.system;

import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统角色表
 */
@Getter
@Setter
public class SysRole extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 自增id
    private String name;// 角色名称
    private Integer root;// 是否系统管理员
    private Integer state;// 状态
    private String note;// 备注 描述
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
}
