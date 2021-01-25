package com.arc.core.model.domain.system;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统角色表
 */
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;// 自增id

    @NotNull(message="名称不能为null")
    private String name;// 角色名称
    private Integer root;// 是否系统管理员
    private Integer state;// 状态
    private String note;// 备注 描述
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
}
