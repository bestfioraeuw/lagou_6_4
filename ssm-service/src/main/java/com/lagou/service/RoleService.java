package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 03:28
 */
public interface RoleService {

//    查询所有角色&根据条件查询
    public List<Role> findAllRole(Role role);


    //根据角色id查询该角色关联的菜单信息id
    public List<Integer> findMenuRoleId(Integer roleid);

    //为角色分配菜单
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    //删除角色
    public void deleteRole(int roleid);
}
