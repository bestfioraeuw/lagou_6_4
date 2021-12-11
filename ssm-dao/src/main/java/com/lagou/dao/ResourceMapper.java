package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:08
 */
public interface ResourceMapper {

    //资源分页以及多条件查询
    public List<Resource> findAllResourceByPage(ResourceVo resourceVo);
}
