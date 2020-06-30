package com.arc.core.model.domain.system;

import com.arc.core.enums.common.EnableEnum;
import com.arc.core.enums.common.SexEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * key-value表，偷懒用
 *
 * @author may
 */
@Getter
@Setter
@ToString
public class KeyValue implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键
    private String key;
    private String value;

    private String type;
    private String note;

    /**
     * 枚举属性测试1
     */
    private EnableEnum enable;


    /**
     * 枚举属性测试2
     */
    private SexEnum sex;

    /**
     * 二进制属性测试
     */
    private byte[] valueBinary;//列值 blob类型

    public KeyValue(String key, String value, String type, String note) {
        this.key = key;
        this.value = value;
        this.type = type;
        this.note = note;

    }
}
