package com.arc.core.model.domain.system;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 叶超
 * @since 2019/9/29 23:22
 */
@Setter
@Getter
public class SysDataDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long  id;// 主键
    private String parentId;// 上级节点ID
    private String type;// 资源类型
    private String key;
    private String  value;
    private String note;// 备注
    private int status;

    private String createBy ;
    private String updateBy ;
    private Date createDate;// 创建时间
    private Date updateDate;// 修改时间
}
