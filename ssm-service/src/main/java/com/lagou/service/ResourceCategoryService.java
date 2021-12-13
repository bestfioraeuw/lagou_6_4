package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:38
 */
public interface ResourceCategoryService {
    public List<ResourceCategory> findAllResourceCategory();

    //添加&修改资源分类
    public void saveResourceCategory(ResourceCategory resourceCategory);

    public void updateResourceCategory(ResourceCategory resourceCategory);
}
