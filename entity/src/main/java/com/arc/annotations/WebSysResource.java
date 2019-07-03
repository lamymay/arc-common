package com.arc.annotations;

import com.arc.enums.system.ParentKey;
import com.arc.enums.system.SysResourceType;

import java.lang.annotation.*;

/**
 * @author may
 * @date 2019/1/25 11:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebSysResource {

    /**
     * 资源名
     *
     * @return
     */
    String resourceName();

    /**
     * 备注
     *
     * @return
     */
    String note();

    /**
     * 优先级
     *
     * @return
     */
    int priority();


    /**
     * 【资源类型 枚举】（PART，LINK，ACTION）
     *
     * @return
     */
    SysResourceType type();

    /**
     * 父级标记--可间接获取父级的id
     *
     * @return
     */
    ParentKey parentKey();

    /**
     * 缺省标记 为三级资源
     *
     * @return
     */
    ParentKey key() default ParentKey.ACTION_REALM;


}
