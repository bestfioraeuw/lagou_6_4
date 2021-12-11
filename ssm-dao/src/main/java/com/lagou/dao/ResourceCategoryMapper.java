package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:36
 */
public interface ResourceCategoryMapper {
    public List<ResourceCategory> findAllResourceCategory();
}
