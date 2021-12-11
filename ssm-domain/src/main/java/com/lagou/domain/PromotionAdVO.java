package com.lagou.domain;

/**
 * @author Huw_Lin
 * time: 2021-12-09 02:48
 */
public class PromotionAdVO {
    //当前页
    private int currentPage;
    //
    private int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PromotionAdVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
