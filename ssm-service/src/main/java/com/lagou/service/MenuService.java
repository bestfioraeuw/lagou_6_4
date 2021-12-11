package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 04:07
 */
public interface MenuService {
    public List<Menu> findSubMenuListByPid(int pid);

    public List<Menu> findAllMenu();

    public  Menu findMenuById(int id );
}
