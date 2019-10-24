package com.arc.core.config.annotations;

import org.springframework.core.annotation.AliasFor;

/**
 * @author 叶超
 * @since 2019/09/21
 */
public @interface DemoNote {

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    //优先级
    int priority() default 0;

}
