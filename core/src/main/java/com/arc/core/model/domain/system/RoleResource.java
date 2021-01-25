package com.arc.core.model.domain.system;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 叶超
 * @since 2019/9/29 23:13
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long resourceId;

    public RoleResource(Long id, Long resourceId) {
        super();
        this.roleId = id;
        this.resourceId = resourceId;
    }
}
