package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-09 03:46
 */
public interface UserService {
    public PageInfo findAllUserByPage(UserVO userVO);

    public void updateUserStatus(int id,String status);

    //用户登录
    public User login(User user) throws Exception;
//分配角色（回显）
    public List<Role> findUserRelationRoleById(int id);

    /*用户关联角色 */
    void userContextRole(UserVO userVo);

    //获取用户权限，进行菜单动态展示
    public ResponseResult getUserPermissions(Integer userid);
}
