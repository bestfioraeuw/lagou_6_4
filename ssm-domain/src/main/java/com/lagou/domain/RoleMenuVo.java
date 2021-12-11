package com.lagou.domain;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 17:10
 */
public class RoleMenuVo {
    public int roleid;
    public List<Integer> menuIdList;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }

    @Override
    public String toString() {
        return "RoleMenuVo{" +
                "roleid=" + roleid +
                ", menuIdList=" + menuIdList +
                '}';
    }
}
