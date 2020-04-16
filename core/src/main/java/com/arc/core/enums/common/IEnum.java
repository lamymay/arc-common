package com.arc.core.enums.common;

/**
 * 本系统所有枚举实现的接口 规范key value 用于MyBatis枚举映射
 * http://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers
 *
 * @author 叶超
 * @since 2020/4/17 0:08
 */
public interface IEnum {
    int getKey();

    void setKey(int key);

    String getValue();

    void setValue(String value);
}
