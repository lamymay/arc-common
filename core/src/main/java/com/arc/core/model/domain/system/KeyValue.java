package com.arc.core.model.domain.system;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

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

    private Integer type;
    private String note;
    private byte[]  valueBinary;//列值 clob类型
}
