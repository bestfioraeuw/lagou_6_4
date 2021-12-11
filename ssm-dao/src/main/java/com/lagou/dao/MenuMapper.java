package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 03:59
 */
public interface MenuMapper {
    public List<Menu> findSubMenuListByPid(int pid);

    //查询所有菜单列表
    public List<Menu> findAllMenu();

    public  Menu findMenuById(int id );
}
