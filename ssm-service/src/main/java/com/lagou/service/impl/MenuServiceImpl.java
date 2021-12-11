package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 04:08
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
       return menuMapper.findSubMenuListByPid(pid);

    }

    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    @Override
    public Menu findMenuById(int id) {
        return menuMapper.findMenuById(id);
    }
}
