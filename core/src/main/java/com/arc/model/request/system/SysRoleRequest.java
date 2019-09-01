package com.arc.model.request.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 叶超
 * @since 2019/9/1 21:43
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class SysRoleRequest {

    private Integer id;//主键
    private String name;//名称

}
