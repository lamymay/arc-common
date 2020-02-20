package com.arc.core.model.domain.system;

import com.arc.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

/**
 * 资源
 */
@Getter
@Setter
@ToString
public class SysResource extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键
    private String parentId;// 上级节点ID
    private String resourceName;// 资源名
    private String method;// 请求方法（GET/POST/PUT/DELETE...）
    private String path;// 资源路径
    private String note;// 备注
    private Integer priority;// 优先级
    private String type;// 资源类型

    private Date createDate;// 创建时间
    private Date updateDate;// 修改时间

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysResource that = (SysResource) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(resourceName, that.resourceName) &&
                Objects.equals(method, that.method) &&
                Objects.equals(path, that.path) &&
                Objects.equals(note, that.note) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, resourceName, method, path, note, priority, type, createDate, updateDate);
    }

}
