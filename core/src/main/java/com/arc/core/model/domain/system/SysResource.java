package com.arc.core.model.domain.system;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 资源
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键
    private String parentId;// 上级节点ID
    private String resourceName;// 资源名
    private String method;// 请求方法（GET/POST/PUT/DELETE...）
    private String path;// 资源路径
    private String note;// 备注
    private Integer priority;// 优先级
    private String type;// 资源类型



    private Integer status;// 状态

//    private Date createDate;// 创建时间
//    private Date updateDate;// 修改时间
//
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间


}
