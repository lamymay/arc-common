package com.arc.core.model.request.system.file;

import com.arc.core.enums.common.EnableEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * kv 分页入口参数
 *
 * @author may
 */
@Getter
@Setter
@ToString
public class KeyValueRequest extends Page {

    private static final long serialVersionUID = 1L;

    private Long id;//自增主键
    private String key;//key
    private String value;//值-字符串格式

    private byte[] valueBinary;//列值 blob类型
    private Integer range;//适用范围,即类型

    private String note;//注释
    private EnableEnum enable;//枚举属性测试,非零=true=可用的/零=false=不可用(默认)


}
