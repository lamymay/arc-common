package com.arc.core.model.domain.mall;

import com.arc.core.model.domain.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Z
 */
@Getter
@Setter
public class MallQuestion extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键ID
    private Long mallId;//mall的id，做关联

    private String question;// 名称
    private String answer;// 答案
    private String reason;// 依据
    private String note;// 备注
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
}
