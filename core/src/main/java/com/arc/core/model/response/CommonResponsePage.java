package com.arc.core.model.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * 分页数据封装
 *
 * @author 叶超/lamy/lamymay/X/XL
 * @since 2019/11/23
 */
public class CommonResponsePage<T> implements Page<T> {


    @Override
    public int getTotalPages() {
        return 0;
    }

    @Override
    public long getTotalElements() {
        return 0;
    }

    @Override
    public Page map(Function converter) {
        return null;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }

    @Override
    public List getContent() {
        return null;
    }

    @Override
    public boolean hasContent() {
        return false;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     * 当前页
     */
    private int page = 1;

    /**
     * 数据总条数
     */
    private int total = 0;

    /**
     * 数据
     */
    List<T> content = new ArrayList<>();

    public CommonResponsePage() {
    }

    public CommonResponsePage(List<T> content) {
        this.content = content;
    }

    public CommonResponsePage(int page, int total) {
        this.page = page;
        this.total = total;
    }

    public CommonResponsePage(int page, int total, List<T> content) {
        this.page = page;
        this.total = total;
        this.content = content;
    }
}
