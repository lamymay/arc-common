package com.arc.core.model.request;

import lombok.ToString;

/**
 * @author may
 */
@ToString
public class PageQuery extends Query {


    interface DefaultPageParameter {
        /**
         * 默认第一页
         */
        int DEFAULT_CURRENT_PAGE = 1;

        /**
         * 默认分页大小20
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
        return getStart() + this.getPageSize();
    }

    public int getPageSize() {
        return pageSize < 1 ? PageQuery.DefaultPageParameter.DEFAULT_PAGE_SIZE : pageSize;
    }

    public Integer getCurrentPage() {
        return (currentPage < 1) ? DefaultPageParameter.DEFAULT_CURRENT_PAGE : currentPage;
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

    public PageQuery() {
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


    public PageQuery(Integer currentPage, Integer pageSize) {
        if (currentPage == null || currentPage < 1) {
            this.currentPage = DefaultPageParameter.DEFAULT_CURRENT_PAGE;
        } else {
            this.currentPage = currentPage;
        }
        if (pageSize == null || pageSize < 1) {
            this.pageSize = PageQuery.DefaultPageParameter.DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"12024379", "12024380", "12024381", "12024382", "12024383", "12024384", "12024385", "12024386", "12024387", "12024388", "12024389",
                "12024390", "12024391", "12024392", "12024393", "12024394", "12024395", "12024396", "12024397", "12024398", "12024399",
                "12024400", "12024401", "12024402", "12024403", "12024404", "12024405", "12024406", "12024407", "12024408", "12024409",
                "12024410", "12024411", "12024412", "12024413", "12024414", "12024415", "12024416", "12024417", "12024418", "12024419",
                "12024420", "12024421", "12024422", "12024423", "12024424", "12024425", "12024426", "12024427", "12024428", "12024429",
                "12024430", "12024431", "12024432", "12024433", "12024434", "12024435", "12024436", "12024437", "12024438", "12024439",
                "12024440", "12024441", "12024442", "12024443", "12024444", "12024445", "12024446", "12024447", "12024448", "12024449",
                "12024450", "12024451", "12024452", "12024453", "12024454", "12024455", "12024456", "12024457", "12024458", "12024459",
                "12024460", "12024461", "12024462", "12024463", "12024464", "12024465", "12024466", "12024467", "12024468", "12024469",
                "12024470", "12024471", "12024472", "12024473", "12024474", "12024475", "12024476", "12024477", "12024478", "12024479",
                "12024480", "12024481", "12024482", "12024483", "12024484", "12024485", "12024486", "12024487", "12024488", "12024489",
                "12024490", "12024491", "12024492", "12024493", "12024494", "12024495", "12024496", "12024497", "12024498", "12024499",
                "12024500", "12024501", "12024502", "12024503", "12024504", "12024505", "12024506", "12024507", "12024508", "12024509",
                "12024510", "12024511", "12024512", "12024513", "12024514", "12024515", "12024516", "12024517", "12024518", "12024519",
                "12024520", "12024521", "12024522", "12024523", "12024524", "12024525", "12024526", "12024527", "12024528", "12024529",
                "12024530", "12024531", "12024532", "12024533", "12024534", "12024535", "12024536", "12024537", "12024538", "12024539",
                "12024540", "12024541", "12024542", "12024543", "12024544", "12024545", "12024546", "12024547", "12024548", "12024549",
                "12024550", "12024551", "12024552", "12024553", "12024554", "12024555", "12024556", "12024557", "12024558", "12024559",
                "12024560", "12024561", "12024562", "12024563", "12024564", "12024565", "12024566", "12024567", "12024568", "12024569",
                "12024570", "12024571", "12024572", "12024573", "12024574", "12024575", "12024576", "12024577", "12024578", "12024579",
                "12024580", "12024581", "12024582", "12024583", "12024584", "12024585", "12024586", "12024587", "12024588", "12024589",
                "12024590", "12024591", "12024592", "12024593", "12024594", "12024595", "12024596", "12024597", "12024598", "12024599",
                "12024600", "12024601", "12024602", "12024603", "12024604", "12024605", "12024606", "12024607", "12024608", "12024609",
                "12024610", "12024611", "12024612", "12024613", "12024614", "12024615", "12024616", "12024617", "12024618", "12024619",
                "12024620", "12024621", "12024622", "12024623", "12024624", "12024625"};

        System.out.println(arr.length);

        //获取参数userId=gQrmTSkv1-9HrqV8P1PrZg,instanceCode=F6803E21AD964F5A,


/*

[
  "gQrmTSkv1-9HrqV8P1PrZg",
  "F6803E21AD964F5A"
]

活动id 54  code=03D38A6E911E4D8E



* */
    }

}
