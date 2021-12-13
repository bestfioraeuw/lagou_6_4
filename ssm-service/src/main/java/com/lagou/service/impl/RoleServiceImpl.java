package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 03:29
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public List<Integer> findMenuRoleId(Integer roleid) {
        return roleMapper.findMenuRoleId(roleid);
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {
        //清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleid());
        //为角色分配菜单
        for (int id:
             roleMenuVo.getMenuIdList()) {
           Role_menu_relation role_menu_relation =new Role_menu_relation();
           role_menu_relation.setMenuId(id);
           role_menu_relation.setRoleId(roleMenuVo.getRoleid());
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }
    }

    @Override
    public void deleteRole(int roleid) {
        //根据roleid清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleid);

        roleMapper.deleteRole(roleid);
    }




    /*
        获取当前角色拥有的资源信息
     */
    @Override
    public List<ResourceCategory> findResourceListByRoleId(Integer roleId) {

        //1.获取当前角色拥有的资源分类信息
        List<ResourceCategory> categoryList = roleMapper.findResourceCategoryByRoleId(roleId);

        //2.获取当前角色拥有的资源信息
        List<Resource> resourceList = roleMapper.findResourceByRoleId(roleId);

        //3.将资源信息封装到对应的资源分类下
        for (ResourceCategory resourceCategory : categoryList) {
            for (Resource resource : resourceList) {
                //判断
                if (resourceCategory.getId() == resource.getCategoryId()) {
                    resourceCategory.getResourceList().add(resource);
                }
            }
        }

        //4.返回资源分类集合
        return categoryList;
    }

    /*
        为角色分配资源
     */
    @Override
    public void roleContextResource(RoleResourceVO roleResourceVO) {
        //删除该角色关联的资源信息
        roleMapper.deleteRoleContextResource(roleResourceVO.getRoleId());

        List<Integer> resourceIdList = roleResourceVO.getResourceIdList();
        for (Integer resourceId : resourceIdList) {
            //为角色分配资源（向角色资源中间表插入数据）
            //封装数据
            Role_resource_relation role_resource_relation = new Role_resource_relation();
            role_resource_relation.setResourceId(resourceId);
            role_resource_relation.setRoleId(roleResourceVO.getRoleId());
            Date date = new Date();
            role_resource_relation.setCreatedTime(date);
            role_resource_relation.setUpdatedTime(date);
            role_resource_relation.setCreatedBy("system");
            role_resource_relation.setUpdatedBy("system");

            //调用mapper中的roleContextResource方法
            roleMapper.roleContextResource(role_resource_relation);
        }
    }

}
