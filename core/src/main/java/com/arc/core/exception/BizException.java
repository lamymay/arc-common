package com.arc.core.exception;


import com.arc.core.enums.system.ProjectCodeEnum;

/**
 * 业务运行时异常
 *
 * @author may
 * @since 2018/04/10
 */
public class BizException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = 1L;

    private int code = ProjectCodeEnum.UNKNOWN.getCode();

    private String msg = ProjectCodeEnum.UNKNOWN.getMsg();

    public BizException() {
        super();
    }

    public BizException(ProjectCodeEnum projectCode) {
        super();
        this.code = projectCode.getCode();
        this.msg = projectCode.getMsg();
    }

    public BizException(String msg) {
        super();
        this.msg = msg;
    }

    public BizException(Exception e, ProjectCodeEnum projectCode) {
        super(e);
        this.code = projectCode.getCode();
        this.msg = projectCode.getMsg();
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
