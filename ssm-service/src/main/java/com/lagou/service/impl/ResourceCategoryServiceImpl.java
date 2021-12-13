package com.lagou.service.impl;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.domain.ResourceCategory;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:39
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }


    /*
        新增资源列表方法
     */
    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        //封装数据
        Date date = new Date();
        String author = "System";
        resourceCategory.setCreatedBy(author);
        resourceCategory.setUpdatedBy(author);
        resourceCategory.setCreatedTime(date);
        resourceCategory.setUpdatedTime(date);
        //调用dao层
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    /*
    修改资源列表方法
     */
    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {
            //封装数据
        Date date=new Date();
        String author="System2";
        resourceCategory.setUpdatedTime(date);
        resourceCategory.setUpdatedBy(author);
        //dao
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    @Override
    public void deleteResourceCategory(int id) {
        resourceCategoryMapper.deleteResourceCategory(id);
    }
}
