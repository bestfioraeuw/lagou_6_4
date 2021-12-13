package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 03:23
 */
public interface RoleMapper {
//    查询所有角色&条件查询
    public List<Role> findAllRole(Role role);

    //根据角色id查询该角色关联的菜单信息id
    public List<Integer> findMenuRoleId(Integer roleid);

    //根绝roleid 清空中间表的关联关系
    public void deleteRoleContextMenu(Integer rid);

    //为角色分配菜单信息
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    //删除角色
    public void deleteRole (int roleid);


    //查询当前角色拥有的资源分类信息Id
    public List<Integer> findResourceCategoryByRoleId(Integer roleId);

    //* 查询当前角色拥有的资源分类下的资源信息
    public List<Resource> findResourceByResourceCategoryId(int resourceCategoryId);

    //根据资源分类id查找资源分类的信息
    public ResourceCategory findResourceCategoryById(int id);

    //根据角色ID查询对应的资源信息
    public List<Integer> findResourceByRoleId(Integer roleId);

    //根据roleid 清空 角色与资源 的关联关系
    public void deleteRoleContextResource(Integer roleId);

    //为角色分配资源信息
    public void roleContextResource(RoleResourceRelation resourceRelation);
}
