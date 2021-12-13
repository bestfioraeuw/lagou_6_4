package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:40
 */

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;
    /*
    资源分类信息查询
     */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){

        return new ResponseResult(true,200,"响应成功",resourceCategoryService.findAllResourceCategory());
    }

    /*
    saveOrUpdateResourceCategory 添加&修改资源分类 POST 方法
     */
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory){
        //判断传入的数据是否有id
        if (resourceCategory.getId()==null){
            //save
           resourceCategoryService.saveResourceCategory(resourceCategory);
        }else {
            //update
            resourceCategoryService.updateResourceCategory(resourceCategory);
        }

        return new ResponseResult(true,200,"响应成功",null);
    }

    /*
    public void deleteResourceCategory(int id);
    http://10.1.194.181:8080/ssm_web/ResourceCategory/deleteResourceCategory?id=10
     */
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id){
        resourceCategoryService.deleteResourceCategory(id);
        return new ResponseResult(true,200,"响应成功",null);
    }
}
