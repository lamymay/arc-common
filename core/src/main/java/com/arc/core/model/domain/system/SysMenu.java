package com.arc.core.model.domain.system;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表实体
 *
 * @author X
 */
@Getter
@Setter
public class SysMenu implements Serializable, Comparable<SysMenu> {

    private static final long serialVersionUID = 1L;

    //mybatisplus 自增id很大,改进：使用数据库自带的增长策略
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 主键id
    private Integer systemId;// 适用系统的id
    private int level;// 级别，1=第一级，2=第二级，，，
    private Long parentId;// 父级id


    private String code;// 编码（备用）

    private String name;// 名中文称
    private String nameEnglish;// 英文名称 （备用）
    private int sort;// 排序用权重（数字小的在前面）
    private int state;// 状态，暂时规划true=非0/false=0
    private String url;// 菜单URL地址
    private String icon;// icon地址
    private String note;// 备注
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间


    private List<SysMenu> children; //非db字段

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }


    @Override
    public int compareTo(SysMenu sysMenu) {
        return this.sort - sysMenu.getSort();
    }
}
