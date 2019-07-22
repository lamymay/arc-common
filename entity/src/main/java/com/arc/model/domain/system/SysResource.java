package com.arc.model.domain.system;

import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

/**
 *
 *
 */
@Getter
@Setter
public class SysResource extends BaseModel {

	private static final long serialVersionUID = 1L;

    private Long id;// 主键

    private String parentId;// 上级节点ID

    private String resourceName;// 资源名

    private String path;// 资源路径

    private String method;// 请求方法（GET，POST，ALL）

    private String note;// 备注
    private Integer priority;// 优先级
    private String type;// 资源类型（PART，LINK，ACTION）
    private int state;
    private Date createDate;// 创建时间
    private Date updateDate;// 修改时间


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysResource resource = (SysResource) o;
        return state == resource.state &&
                Objects.equals(id, resource.id) &&
                Objects.equals(parentId, resource.parentId) &&
                Objects.equals(resourceName, resource.resourceName) &&
                Objects.equals(path, resource.path) &&
                Objects.equals(method, resource.method) &&
                Objects.equals(note, resource.note) &&
                Objects.equals(priority, resource.priority) &&
                Objects.equals(type, resource.type) &&
                Objects.equals(createDate, resource.createDate) &&
                Objects.equals(updateDate, resource.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, resourceName, path, method, note, priority, type, state, createDate, updateDate);
    }
}
