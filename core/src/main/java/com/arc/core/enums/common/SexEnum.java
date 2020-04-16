package com.arc.core.enums.common;

/**
 * @author 叶超
 * @since 2020/4/17 0:10
 */
public enum SexEnum implements IEnum {

    MAN(1, "男"),

    WOMAN(2, "女");

    private int key;
    private String value;

    SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public int getKey() {
        return key;
    }

    @Override
    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
