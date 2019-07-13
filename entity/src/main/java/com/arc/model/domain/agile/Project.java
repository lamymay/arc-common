package com.arc.model.domain.agile;

import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 项目表
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Getter
@Setter
@ToString
public class Project extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 项目表ID
    private String code;// project code
    private String name;// 项目名称名称-128
    private String description;// 说明[text]
    private Long authorId;// 作者ID
    private String authorName;// 作者名称
    private String url;// 地址
    private String projectType;// 项目类型-128
    private String assigneeType;// 受让人类型（就是接收”东西“那一方 ）
    private Long avatarId;// 标识信息的id(主题)
    private Integer state;// 状态
    private String keyword;// 关键字
    private String version;// 版本
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
}
