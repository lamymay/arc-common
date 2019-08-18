package com.arc.model.domain.system;

import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *
 *
 */
@Getter
@Setter
public class SysResource extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Long  id;// 主键
    private String parentId;// 上级节点ID
    private String resourceName;// 资源名
    private String method;// 请求方法（GET/POST/PUT/DELETE...）
    private String path;// 资源路径
    private String note;// 备注
    private Integer priority;// 优先级
    private String type;// 资源类型

    private Date createDate;// 创建时间
    private Date updateDate;// 修改时间
}
