package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.Md5Utils.Md5;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Huw_Lin
 * time: 2021-12-09 03:47
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public PageInfo findAllUserByPage(UserVO userVO) {
        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        List<User> list = userMapper.findAllUserByPage(userVO);
        PageInfo<User>pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updateUserStatus(int id, String status) {
        userMapper.updateUserStatus(id,status);
    }

    @Override
    public User login(User user) throws  Exception{
        //包含了密文密码
       User  user2= userMapper.login(user);
       if(user2 !=null && Md5.verify(user.getPassword(),"lagou",user2.getPassword())){
            return user2;
       }else {
           return null;
       }
    }


//    分配角色回显
    @Override
    public List<Role> findUserRelationRoleById(int id) {
      return   userMapper.findUserRelationRoleById(id);

    }

    @Override
    public void userContextRole(UserVO userVo) {
        //根据用户id清除中间关系表
        userMapper.deleteUserContextRole(userVo.getUserId());

        for (Integer roleid :
                userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleid);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
            userMapper.userContextRole(user_role_relation); }
        }

    @Override
    public ResponseResult getUserPermissions(Integer userid) {
        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userid);
        //2.获取角色id保存到集合中
           ArrayList<Integer> roleIds = new ArrayList<>();
        //3.根据角色id查询副菜单
     List<Menu> parentMenu =   userMapper.findParentMenuByRoleId(roleIds);
     //4.查询封装父菜单和子菜单
        for (Menu menu:
             parentMenu) {
                List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
        }
        //5.获取该用户拥有的资源信息
       List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        //6.封装数据并返回
        Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu);
        map.put("resourceList",resourceList);

           return new ResponseResult(true,200,"获取用户权限信息成功",map);
    }
}

