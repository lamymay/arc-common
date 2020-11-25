package com.arc.core.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author may
 */
@Getter
@Setter
public class PageQuery extends Query {


    interface DefaultPageParameter {
        /**
         * 默认第一页是1
         */
        int DEFAULT_CURRENT_PAGE = 1;

        /**
         * 默认分页大小查20个
         */
        int DEFAULT_PAGE_SIZE = 20;
    }


    private int currentPage = PageQuery.DefaultPageParameter.DEFAULT_CURRENT_PAGE;
    private int pageSize = PageQuery.DefaultPageParameter.DEFAULT_PAGE_SIZE;

    /**
     * @return db分页查询开始行
     */
    public int getStart() {
        return (getCurrentPage() - 1) * getPageSize();
    }

    /**
     * @return db分页查询结束行
     */
    public int getEnd() {
        return getCurrentPage() * getPageSize();
    }

    /**
     * pageSize set时候保证有合法值
     *
     * @param pageSize 页面大小
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            this.pageSize = PageQuery.DefaultPageParameter.DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize < 1 ? PageQuery.DefaultPageParameter.DEFAULT_PAGE_SIZE : pageSize;
    }

    /**
     * currentPage set当前页保证有合法值, 当前页从前端显示第一页开始
     *
     * @param currentPage 当前页
     */
    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null || currentPage < 1) {
            this.currentPage = PageQuery.DefaultPageParameter.DEFAULT_CURRENT_PAGE;
        }
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage < 1 ? DefaultPageParameter.DEFAULT_CURRENT_PAGE : currentPage;
    }

}
