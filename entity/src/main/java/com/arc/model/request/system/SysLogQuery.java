package com.arc.model.request.system;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author May
 * @date 2019/02/02 11:09
 */
@Setter
@Getter
@ToString
public class SysLogQuery implements Serializable {

    private Integer id;// 日志主键
    private Boolean success;// 状态码成功与否
    private String name;// 操作名称
    private String operator;// 操作者名称

    public SysLogQuery() {
    }

    public SysLogQuery(String name) {
        this.name = name;
    }
}
