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

    /**
     * 查询当前角色拥有的资源分类信息的Id
     */
    public List<Integer> findResourceCategoryByRoleId(Integer roleId) {
        return roleMapper.findResourceCategoryByRoleId(roleId);
    }



    /**
     * 查询当前角色拥有的资源分类下的所有资源信息
     */
    public List<Resource> findResourceByResourceCategoryId(ResourceCategoryVO resourceCategoryVO) {
        return roleMapper.findResourceByResourceCategoryId(resourceCategoryVO.getId());
    }

    /**
     * 根据资源分类id查找资源分类的信息
     */
    public ResourceCategory findResourceCategoryById(int id) {
        return roleMapper.findResourceCategoryById(id);
    }

    /**
     * 根据角色ID查询对应的资源信息
     */
    @Override
    public List<Integer> findResourceByRoleId(Integer roleId) {
        return roleMapper.findResourceByRoleId(roleId);
    }


    /**
     * 根据roleid 清空 角色与资源 的关联关系
     */
    @Override
    public void deleteRoleContextResource(Integer roleId) {
        roleMapper.deleteRoleContextResource(roleId);
    }

    /**
     * 为角色分配资源信息
     */
    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
        //删除之前角色所关联的资源信息
        roleMapper.deleteRoleContextResource(roleResourceVo.getRoleId());
        //根据资源ID为角色添加资源权限
        List<Integer> resourceIdList = roleResourceVo.getResourceIdList();
        for(Integer id : resourceIdList) {
            RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
            roleResourceRelation.setRoleId(roleResourceVo.getRoleId());
            roleResourceRelation.setResourceId(id);
            Date date = new Date();
            roleResourceRelation.setUpdatedTime(date);
            roleResourceRelation.setCreatedTime(date);

            roleResourceRelation.setCreatedBy("system");
            roleResourceRelation.setUpdatedBy("system");
            roleMapper.roleContextResource(roleResourceRelation);

        }
    }
}
