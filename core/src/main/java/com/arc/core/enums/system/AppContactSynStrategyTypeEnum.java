package com.arc.core.enums.system;

/**
 * 通讯路同步策略类型
 *
 * @author 叶超
 * @since 2020/2/29 11:09
 */
@Deprecated
public enum AppContactSynStrategyTypeEnum {

    /**
     * 合并重复数据
     */
    UNION_SET(1, "取并集"),
    ONLY_ACCEPT_SERVER(2, "仅取服务器的数据"),
    ONLY_ACCEPT_CLIENT(3, "仅取客户端数据"),
    ;

    /**
     * 字段私有化
     */
    private int number;
    private String message;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    AppContactSynStrategyTypeEnum(int number, String message) {
        this.number = number;
        this.message = message;
    }

}
