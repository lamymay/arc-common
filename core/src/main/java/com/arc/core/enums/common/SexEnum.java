package com.arc.core.enums.common;

/**
 * @author 叶超
 * @since 2020/4/17 0:10
 */
public enum SexEnum implements IEnum {

    UNKNOWN(0, "保密"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private int key;
    private String message;

    SexEnum(int key, String message) {
        this.key = key;
        this.message = message;
    }

    public static SexEnum getSexByKey(int key) {

        for (SexEnum sex : SexEnum.values()) {
            if (sex.getKey() == key) {
                return sex;
            }
        }
        return null;
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
        return message;
    }

    @Override
    public void setValue(String message) {
        this.message = message;
    }
}
