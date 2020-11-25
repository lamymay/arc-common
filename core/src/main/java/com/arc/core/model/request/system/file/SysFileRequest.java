package com.arc.core.model.request.system.file;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 系统文件记录请求
 *
 * @author lamymay
 */
@Getter
@Setter
@ToString
//PageRequest
public class SysFileRequest  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;//自增主键
    private String name;// 显示名称
    private String suffix;// 后缀
    private Integer version;// 版本信息id
    private String key;// 文件标识
    private String url;// 文件存放url
    private String note;// 描述
    private String checkType;// 校验方式
    private String checkCode;// 校验码
    private Integer state;// 逻辑删除用的标识

    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间

    private String code;// 版本号
    private String type;// 类型

    private Long size;// 文件大小
    private String sizeUnit;// 文件大小单位
    private String remark;// 描述

    private LocalDateTime createAt;// 创建时间
    private LocalDateTime updateAt;// 更新时间

    public SysFileRequest() {
    }

    public SysFileRequest(Long id) {
        this.id = id;
    }

    public SysFileRequest(String code) {
        this.code = code;
    }



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


    private int currentPage = DefaultPageParameter.DEFAULT_CURRENT_PAGE;
    private int pageSize = DefaultPageParameter.DEFAULT_PAGE_SIZE;

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
            this.pageSize = DefaultPageParameter.DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize < 1 ? DefaultPageParameter.DEFAULT_PAGE_SIZE : pageSize;
    }

    /**
     * currentPage set当前页保证有合法值, 当前页从前端显示第一页开始
     *
     * @param currentPage 当前页
     */
    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null || currentPage < 1) {
            this.currentPage = DefaultPageParameter.DEFAULT_CURRENT_PAGE;
        }
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage < 1 ? DefaultPageParameter.DEFAULT_CURRENT_PAGE : currentPage;
    }
}
