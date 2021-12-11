package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huw_Lin
 * time: 2021-12-10 04:10
 */

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        return new ResponseResult(true,200,"查询所有菜单信息成功",menuService.findAllMenu());
    }


    @RequestMapping("/")
    public ResponseResult findMenuInfoById(int id){
        if (id == -1){
            List<Menu> list = menuService.findSubMenuListByPid(-1);

            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",list);
            return new ResponseResult(true,200,"这是一个添加回显成功",map);
        }else {
            // 不为-1 表示这是一个修改操作,回显所有menu信息
         Menu menu =    menuService.findMenuById(id);
         List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",subMenuListByPid);
            return new ResponseResult(true,200,"这是一个修改回显成功",map);

        }
    }
}
