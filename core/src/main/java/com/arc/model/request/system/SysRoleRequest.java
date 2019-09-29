package com.arc.model.request.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author 叶超
 * @since 2019/9/1 21:43
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class SysRoleRequest {

    private Long id;//主键
    private String name;//名称

    /**
     * 资源的ids
     */
    private List<Long> resourceIds;

}
