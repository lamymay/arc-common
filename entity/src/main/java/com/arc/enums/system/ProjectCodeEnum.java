package com.arc.enums.system;


/**
 * 内部错误码
 * 规定一定范围是一类错误，如：
 * 0001-0999 服务中的一些系统级别的异常【重大错误】
 * 1000-1999 业务中的非特定错误【运行中的普通错误】
 * 2000-2999 数据库操作级别的异常【db错误】
 * 3000-3999
 * 4000-4999 流程相关异常
 * ...
 * 9000-9998
 * <p>
 * <p>
 * ：）
 * 1）注意：在这里错误码约束有效， 下面的已有code定义看着删吧！！！
 * 2）注意： ####  看标题 ！！！
 *
 * @author 叶超
 * @since 2018/04/10
 */
public enum ProjectCodeEnum {
    //=====================================================
    //  3个特殊状态
    //=====================================================

    FAILURE(-1, "失败"),
    SUCCESS(1, "成功"),
    UNKNOWN(0, "未知"),
    NULL(2, "NULL"),


    //=====================================================
    // 0001-0999 服务中的一些系统级别的异常   重大的错误
    //=====================================================
    /**
     * API微服务异常
     */
    MS_API_EXCEPTION(2, "API微服务异常"),


    /**
     * SMS微服务异常
     */
    MS_SMS_EXCEPTION(3, "SMS微服务异常"),


    //=====================================================
    // 1000-1999    业务中的非特定错误
    //=====================================================

    LOGIN_ERROR(1000, "账号或者密码错误请重新登录!"),
    LOGIN_ERROR_JWT(1000, "请重新登录,HTTP请求头参数缺少Authorization信息。Missing or invalid Authorization header!"),
    LOGIN_ERROR_TOKEN_FALSIFY(1000, "请重新登录,伪造签名。Authorization token is falsified  !"),
    JWT_TOKEN_ERROR(5, "签名不可用，原因：token失效请重新登录！"),


    //0001到0010 预留10个微服务的code
//
//    /**
//     * 微服务返回NULL
//     */
//    NULL_RESPONSE("0011", "微服务返回NULL"),
//
//    /**
//     * 微服务返回FALLBACK
//     */
//    FALLBACK_RESPONSE("0012", "微服务返回FALLBACK"),
//
//    /**
//     * 空结果异常
//     */
//    RESULT_NULL_EXCEPTION("0013", "空结果异常"),
//
//    /**
//     * 分页对象null异常
//     */
//    PAGE_NULL_RESPONSE("0014", "分页对象null异常"),
//
//
//    /**
//     * 请求参数错误
//     */
//    ILLEGAL_ARGUMENT("0015", "请求参数错误"),
//
//    /**
//     * 微服务参数异常
//     */
//    MS_ILLEGAL_ARGUMENT("0016", "微服务参数异常"),
//
//    /**
//     * 非法调用
//     */
//    CALL_ILLEGAL("0016", "非法调用"),
//


//
//    /**
//     * BEAN拷贝异常
//     */
//    BEANCOPIER_EXCEPTION("1001", "BEAN拷贝异常"),
//
//    /**
//     * 重复绑定
//     */
//    BINDING_DUPLICATE_EXCEPTION("1002", "重复绑定"),
//
//
//    /**
//     * 修改状态异常
//     */
//    MODIFY_STATUS_EXCEPTION("1003", "修改状态异常"),
//
//    /**
//     * 发送验证失败
//     */
//    VERIFYCODE_EXCEPTION("1003", "发送验证码失败"),
//
//    /**
//     * 发送验证码超过最大次数
//     */
//    SEND_VERIFYCODE_OVER_MAXTIMES("1004", "发送验证码超过最大次数"),
//
//    /**
//     * 发送验证码过于频繁
//     */
//    SEND_VERIFYCODE_LESS_60S("1005", "发送验证码过于频繁"),
//
//    /**
//     * 验证码错误
//     */
//    INVALID_VERIFYCODE_ERROR("1006", "验证码错误"),
//
//    /**
//     * 密码修改错误
//     */
//    CHANGE_PASSWORD_ERROR("1007", "密码修改错误"),
//
//    /**
//     * 账号或者密码错误
//     */
//    LOGIN_ERROR("1008", "账号或者密码错误"),
//
//
//    PASSWORD_ERROR("1010", "密码错误"),
//
//    USER_UPDATE_EXCEPTION("1011", "不可用的手机号或工号或邮箱，原因：重复"),
//
//    /**
//     * jwt解析错误
//     * 可能是视图获取无效的数据造成
//     */
//    JWT_TOKEN_ANALYSIS_ERROR("0012", "jwt解析错误！"),
//
//    /**
//     * 验证验证码，验证码错误
//     */
//    VERIFY_EXCEPTION("1013", "验证失败,可能原因：您输入错了"),
//
//    NO_USER_EXCEPTION("1014", "查无此人，操作失败"),
//
//    QUERY_FAILED("1015", "没有查询到出差申请单详情"),
//
//    GENERATE_NEW_ORDER_NO_ERROR("1016", "生成新的订单号异常"),
//
//    /**
//     * 未知机票舱等类型
//     */
//    UNKNOWN_FLIGHT_CLASS_TYPE("1017", "未知机票舱等类型"),
//    /**
//     * 未知火车票坐席类型
//     */
//    UNKNOWN_TRAIN_CLASS_TYPE("1018", "未知机票舱等类型"),
//
//    GET_IDENTIFYING_CODE_ERROR("0017", "获取验证码失败，可能原因：手机号格式错误，不给发短信"),
//
//    DELETE_TRAVEL_APPLY_FAILED("0018", "删除出差申请单失败"),
//
//    GENERATE_TRAVEL_BUDGET_FLIGHT_FAILED("0019", "生成机票预算失败"),
//    GENERATE_TRAVEL_BUDGET_TRAIN_FAILED("0020", "生成火车票预算失败"),
//    GENERATE_TRAVEL_BUDGET_HOTEL_FAILED("0021", "生成酒店预算失败"),
//    VERIFY_INVALID("0022", "验证码错误超过5次"),
//
//    /**
//     * 获取单号失败
//     */
//    CREATE_ORDER_ERROR("1020", "获取单号失败，可能原因：公司编码为空"),
//    NO_COMPANY_OR_DEPARTMENT("1021", "获取单号失败，可能原因：公司编码为空"),
//
//    /**
//     * 文件保存异常
//     */
//    FILE_SAVE_EXCEPTION("1022", "文件保存异常"),
//
//    /**
//     * 同步出差申请单
//     **/
//    SYNC_TRAVEL_TRIP_ERROR("1023", "查询出差申请单出错"),
//
//    /**
//     * 保存出差申请单失败
//     **/
//    SAVE_TRAVEL_TRIP_ERROR("1024", "保存出差申请单失败"),
//
//    /**
//     * 预定方式错误
//     **/
//    BOOKING_STATUS_ERROR("1025", "预定方式错误"),
//
//    /**
//     * 菜单更新出错
//     */
//    MENU_UPDATE_ERROR("1026", "菜单维护出错"),
//
//

    FILE_OPERATE_ERROR(1100, "文件操作错误"),

    UPLOAD_FAILURE(1101, "文件上传失败"),

//    OVER_LENGTH("1027", "注释字数，限制100字符以内！"),

    //=====================================================
    // 2000-2999 数据库操作级别的异常
    //=====================================================

    /**
     * 关联表关联失败
     */
    BINDING_EXCEPTION(2001, "关联表操作是不超过"),

    /**
     * 插入数据失败
     */
    INSERT_EXCEPTION(2002, "插入数据到数据库出错"),

    /**
     * 0199
     * 检索数据库时候出错
     */
    SELECT_EXCEPTION(2003, "检索数据库时候出错"),

    /**
     * 数据库操作异常
     */
    DATA_JPA_EXCEPTION(2004, "数据库操作异常"),

    /**
     * 修改数据异常
     */
    MODIFY_EXCEPTION(2005, "修改数据异常"),

    /**
     * 修改数据异常
     */
    STATUS_NULL_EXCEPTION(2006, "数据库status数据null异常"),

    //=====================================================
    // 3000-3999 网络请求操作级别的异常
    //=====================================================

    /**
     * 获取火车票价失败
     */
    REQUEST_TRAIN_TICKET_PRICE_FAILED(3000, "获取火车票价失败"),
    ;


    //=====================================================
    // 4000-4999 相关异常
    //=====================================================

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    ProjectCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
