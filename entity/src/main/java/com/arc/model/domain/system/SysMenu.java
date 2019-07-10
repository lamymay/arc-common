package com.arc.model.domain.system;


import com.arc.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

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
    private Long parentId;// 父级id
    private String code;// 编码（备用）
    private String name;// 名中文称
    private String nameEnglish;// 英文名称
    private int sort;// 排序用权重（数字小的在前面）
    private int level;// 级别，1=第一级，2=第二级，，，
    private int state;// 状态，暂时规划true=非0/false=0
    private String url;// 菜单URL地址
    private String icon;// icon地址
    private String note;// 备注
    private Long systemId;// 适用系统的id（备用）
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
//    private LocalDateTime updateDate;// 更新时间

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        ArrayList<BigInteger> list3 = new ArrayList<>();

        list1.add(1000L);
        list1.add(1001L);
        list1.add(1002L);
        list1.add(1003L);
        list2.add(1002L);

        for (Long b : list2) {
            System.out.println(list1.contains(b));
            for (Long a : list1) {
                System.out.println(a==b);
                System.out.println(a.equals(b));
                System.out.println(a);
                System.out.println(b);
            }

        }


    }

}
