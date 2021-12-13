package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:36
 */
public interface ResourceCategoryMapper {
    //资源分类信息查询
    public List<ResourceCategory> findAllResourceCategory();

    //添加&修改资源分类
    public void saveResourceCategory(ResourceCategory resourceCategory);

    public void updateResourceCategory(ResourceCategory resourceCategory);

    //删除deleteResourceCategory
    public void deleteResourceCategory(int id);
}
