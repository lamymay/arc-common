package com.arc.core.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author may
 */
@Getter
@Setter
public class PageQuery implements Serializable {


    private int currentPage = DefaultPageParameter.DEFAULT_CURRENT_PAGE;
    private int pageSize = DefaultPageParameter.DEFAULT_PAGE_SIZE;

    /**
     * 排序字段 例如
     */
    private String sort;

    interface DefaultPageParameter {

        int DEFAULT_CURRENT_PAGE = 1;

        int DEFAULT_PAGE_SIZE = 20;
    }


//    /**
//     * 后端使用分页参数的时候 当前页需要减1，并需要校验
//     *
//     * @return
//     */
//    public int getCurrentPageForDb() {
//        int currentPageForDb = this.currentPage - 1;
//        return currentPageForDb < 1 ? 0 : currentPageForDb;
//    }
//
//    /**
//     * 页面大小需要校验
//     *
//     * @return
//     */
//    public int getPageSizeForDb() {
//        return this.pageSize < 1 ? DEFAULT_PAGE_SIZE : this.pageSize;
//    }
//}


//
//    private Integer currentPage;
//
//    private Integer pageSize;
//
//    private Integer offSet;
//
//    private Integer start;
//
//    private Integer end;

}
