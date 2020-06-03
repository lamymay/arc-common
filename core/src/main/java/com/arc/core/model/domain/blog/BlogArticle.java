package com.arc.core.model.domain.blog;

import com.arc.core.model.domain.BaseModel;
import com.arc.core.model.domain.system.SysResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 文章表
 *
 * @author 叶超
 * @since 2019/1/30 15:09
 */
@Getter
@Setter
@ToString
public class BlogArticle extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 日志自增ID号
    private Long authorId;// 作者，所属用户ID[多作者请在描述中填充第二作者信息]
    private Long tagId;// 栏目ID
    private Long category;// 所属分类
    private Integer version;    //版本控制 version control
    private Integer sortWeight; //排序权重
    private Integer status;//文章的模式:0逻辑删除1为私有，2为公开，3为仅好友查看
    private String title;// 文章名称-64
    private String description;// 文章描述-128
    private String content;// 文章内容[text]
    private Date publishDate;// 发布时间
    private Date createDate;// 创建时间(创建未发表)
    private Date updateDate;// 更新时间

    private List<SysResource> resources;//资源
    //notebook_id: "33000680",
    //title: "XXX",
    //在底部 at_bottom: false}
    //autosave_control 自动保存控制
}
