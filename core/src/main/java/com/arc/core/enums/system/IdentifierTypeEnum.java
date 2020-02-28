package com.arc.core.enums.system;


/**
 * 枚举类 标识类型
 *
 * @author may
 */
public enum IdentifierTypeEnum implements IntegerStatusEnums {

    //   private String identifier;// 标识（手机号 邮箱 用户名或第三方应用的唯一标识） 1=username/password 2=cellphone 3= 4=wechat 5=weibo 6=qq

    USERNAME(1, "username/password"),
    CELLPHONE(2, "cellphone"),
    EMAIL(3, "email"),
    ;

    /**
     * 字段私有化
     */
    private int number;
    private String message;

    IdentifierTypeEnum(int number, String message) {
        this.number = number;
        this.message = message;
    }


//    public static EnableDisable by(int code) {
//        for (EnableDisable e : EnableDisable.values()) {
//            if (code == e.getCode()) return e;
//        }
//        return null;
//    }


    @Override
    public int getNumber() {
        return number;
    }

    public String getMsg() {
        return message;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMsg(String message) {
        this.message = message;
    }
}
