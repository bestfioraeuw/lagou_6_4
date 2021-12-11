package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

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
}
