//package com.arc.core.model.request;
//
//import lombok.ToString;
//
///**
// * 分页查询基类
// *
// * @author yechao
// * @since 20200609
// */
//@ToString
//@Deprecated
//public class PageQuery2 extends Query {
//
//
//    interface DefaultPageParameter {
//        int DEFAULT_CURRENT_PAGE = 1;
//        int DEFAULT_PAGE_SIZE = 20;
//    }
//
//
//    private int currentPage = DefaultPageParameter.DEFAULT_CURRENT_PAGE;
//
//    private int pageSize = DefaultPageParameter.DEFAULT_PAGE_SIZE;
//
//    //
////    private Integer currentPage;
////
////    private Integer pageSize;
////
////    private Integer offSet;
////
//    private Integer start;
//
//    private Integer end;
//
////    /**
////     * 排序字段 例如
////     */
////    private String sort;
//
//
//    //    /**
////     * 后端使用分页参数的时候 当前页需要减1，并需要校验
////     *
////     * @return
////     */
////    public int getCurrentPageForDb() {
////        int currentPageForDb = this.currentPage - 1;
////        return currentPageForDb < 1 ? 0 : currentPageForDb;
////    }
////
////    /**
////     * 页面大小需要校验
////     *
////     * @return
////     */
////    public int getPageSizeForDb() {
////        return this.pageSize < 1 ? DEFAULT_PAGE_SIZE : this.pageSize;
////    }
////}
//
//}