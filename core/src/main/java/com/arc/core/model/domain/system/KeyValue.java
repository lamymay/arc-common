package com.arc.core.model.domain.system;

import com.arc.core.enums.common.EnableEnum;
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

    /**
     * 主键id
     */
    private Long id;

    /**
     * key
     */
    private String key;

    /**
     * 值-字符串格式
     */
    private String value;

//    /**
//     * 值-二进制属性测试
//     */
//    private byte[] valueBinary;//列值 blob类型

    /**
     * 适用范围,即类型
     */
    private Integer range;

    /**
     * 注释
     */
    private String note;

//    /**
//     * 枚举属性测试,非零=true=可用的/零=false=不可用(默认)
//     */
//    private EnableEnum enable;


    public KeyValue(String key, String value, Integer range, String note) {
        this.key = key;
        this.value = value;
        this.range = range;
        this.note = note;

    }
}
