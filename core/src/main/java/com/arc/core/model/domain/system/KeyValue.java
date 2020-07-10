package com.arc.core.model.domain.system;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    private Long id;//主键id
    private String key;//key
    private String value;//值-字符串格式

    //    private byte[] valueBinary;//值-二进制属性测试,blob类型
    private Integer range;//适用范围,即类型
    private String note;//注释

    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
    //    private EnableEnum enable;//枚举属性测试,非零=true=可用的/零=false=不可用(默认)


    public KeyValue(String key, String value, Integer range, String note) {
        this.key = key;
        this.value = value;
        this.range = range;
        this.note = note;

    }
}
