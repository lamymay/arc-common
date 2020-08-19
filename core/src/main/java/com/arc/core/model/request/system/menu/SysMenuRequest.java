package com.arc.core.model.request.system.menu;

import com.arc.core.model.request.PageQuery;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;

@Getter
@Setter
@ToString
public class SysMenuRequest  extends PageQuery implements Pageable {

    private static final long serialVersionUID = 1L;

    //mybatisplus 自增id很大,改进：使用数据库自带的增长策略
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 主键id
    private Long parentId;// 父级id
    private String code;// 编码（备用）

    private String name;// 名中文称
    private String nameEnglish;// 英文名称 （备用）
    //private int sort;// 排序用权重（数字小的在前面）
    private int level;// 级别，1=第一级，2=第二级，，，
    private int state;// 状态，暂时规划true=非0/false=0
    private String url;// 菜单URL地址
    private String icon;// icon地址
    private String note;// 备注
    private Long systemId;// 适用系统的id
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间



    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    @Override
    public int getPageNumber() {
        return 0;
    }

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    @Override
    public int getPageSize() {
        return 0;
    }

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken
     */
    @Override
    public long getOffset() {
        return 0;
    }

    /**
     * Returns the sorting parameters.
     *
     * @return
     */
    @Override
    public Sort getSort() {
        return null;
    }

    /**
     * Returns the {@link Pageable} requesting the next {@link Page}.
     *
     * @return
     */
    @Override
    public Pageable next() {
        return null;
    }

    /**
     * Returns the previous {@link Pageable} or the first {@link Pageable} if the current one already is the first one.
     *
     * @return
     */
    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    /**
     * Returns the {@link Pageable} requesting the first page.
     *
     * @return
     */
    @Override
    public Pageable first() {
        return null;
    }

    /**
     * Returns whether there's a previous {@link Pageable} we can access from the current one. Will return
     * {@literal false} in case the current {@link Pageable} already refers to the first page.
     *
     * @return
     */
    @Override
    public boolean hasPrevious() {
        return false;
    }
}
