package com.lagou.dao;

import com.lagou.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-09 03:36
 */
public interface UserMapper {

    public List<User> findAllUserByPage(UserVO userVO);

    public void updateUserStatus(@Param("id") int id,@Param("status") String status);

    //用户登录
    public User login(User user);

    /**
     *  1.根据ID查询用户当前角色
     * */
    public List<Role> findUserRelationRoleById(int id);

    /*根据用户ID清空中间表 */
   public void deleteUserContextRole(Integer userId);
    /* 分配角色 */
  public   void userContextRole(User_Role_relation user_role_relation);

  //2.根据角色id，查询角色所拥有的顶级菜单（-1）
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);
    //3.根据PID，查询子菜单信息
    public List<Menu> findSubMenuByPid(Integer pid);
    //4.获取用户拥有的资源权限信息
    public List<Resource> findResourceByRoleId(List<Integer> ids);
}
