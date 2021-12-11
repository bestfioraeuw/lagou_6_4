package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;
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
}
