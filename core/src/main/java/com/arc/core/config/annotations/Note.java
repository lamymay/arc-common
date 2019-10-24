package com.arc.core.config.annotations;

import org.springframework.core.annotation.AliasFor;

/**
 * @author 叶超
 * @since 2019/8/12 15:21
 */
public @interface Note {

    @AliasFor("name")
    String value() default "";


    @AliasFor("value")
    String name() default "";

    /**
     * 优先级
     *
     * @return int
     */
    int priority() default 0;

}
