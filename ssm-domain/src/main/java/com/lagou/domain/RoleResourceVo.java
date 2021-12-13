package com.lagou.domain;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-14 02:07
 */
public class RoleResourceVo {
    private Integer roleId;
    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}
