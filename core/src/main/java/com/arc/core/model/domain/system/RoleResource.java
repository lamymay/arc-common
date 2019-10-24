package com.arc.core.model.domain.system;

import com.arc.core.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 叶超
 * @since 2019/9/29 23:13
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleResource extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long resourceId;

    public RoleResource(Long id, Long resourceId) {
        super();
        this.roleId = id;
        this.resourceId = resourceId;
    }
}
