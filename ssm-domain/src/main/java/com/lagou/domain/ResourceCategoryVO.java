package com.lagou.domain;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-14 02:00
 */
public class ResourceCategoryVO {
    private Integer id;
    private List<Integer> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
