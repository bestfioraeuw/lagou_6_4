package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huw_Lin
 * time: 2021-12-10 03:31
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

       List<Role>  list = roleService.findAllRole(role);

       return new ResponseResult(true,200,"查询所有角色成功",list);

    }

    @Autowired
    private MenuService menuService;

//    查询所有的父子菜单信息，分配菜单的第一个接口
    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){

       List<Menu> list= menuService.findSubMenuListByPid(-1);
        //-1 表示查询所有父子级菜单 ，父级菜单的parent_id都是-1
        Map<String ,Object> map = new HashMap<>();
        //响应数据，为数据开头加一个parentMenuList
        map.put("parentMenuList",list);

        return new ResponseResult(true,200,"查询所有的父子级菜单信息",map);
    }


    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){

      List<Integer> list = roleService.findMenuRoleId(roleId);

      return new ResponseResult(true,200,"查询角色关联的菜单信息",list);
    }

    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.roleContextMenu(roleMenuVo);

        return  new ResponseResult(true,200,"响应成功",null);
    }


    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(int id ){
        roleService.deleteRole(id);

        return  new ResponseResult(true,200,"响应成功",null);
    }

    //     - 名称: **findResourceListByRoleId**
//            - 描述: 添加& 修改资源分类接口
//- URL: http://localhost:8080/ssm_web/role/findResourceListByRoleId
//            - 请求方式: GET
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(int roleId) {
        ResourceCategoryVO resourceCategoryVO = new ResourceCategoryVO();
        //根据角色ID查询出来的所具有的资源分类的Id
        List<Integer> resourceCategoryByRoleId = roleService.findResourceCategoryByRoleId(roleId);
        List<ResourceCategory> list = new ArrayList<>();
        for(Integer id : resourceCategoryByRoleId) {
            ResourceCategory resourceCategory = roleService.findResourceCategoryById(id);
            resourceCategoryVO.setId(id);
            resourceCategoryVO.setList(roleService.findResourceByRoleId(roleId));
            List<Resource> resourceList = roleService.findResourceByResourceCategoryId(resourceCategoryVO);
            resourceCategory.setResourceList(resourceList);
            list.add(resourceCategory);
        }
        return new ResponseResult(true,200,"获取当前角色拥有的资源信息成功",list);
    }
    /**
     * 为角色分配资源
     * @return
     */

    @RequestMapping("/roleContextResource")
    public ResponseResult findResourceListByRoleId(@RequestBody RoleResourceVo roleResourceVo) {

        roleService.roleContextResource(roleResourceVo);
        return new ResponseResult(true,200,"为角色分配资源成功",null);

    }
}
