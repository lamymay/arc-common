package com.arc.model.domain.system;


import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单表实体
 *
 * @author X
 */
@Getter
@Setter
public class SysMenu extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键id
    private String name;// 名中文称
    private String nameEnglish;// 英文名称
    private Object sort;// 排序用权重（数字小的在前面）
    private Long parentId;// 父级id
    private Object level;// 级别，1=第一级，2=第二级，，，
    private Object state;// 状态，暂时规划true=非0/false=0
    private String url;// 菜单URL地址
    private String icon;// icon地址
    private String note;// 备注
    private String code;// 编码（备用）
    private Long systemId;// 适用系统的id（备用）
}
