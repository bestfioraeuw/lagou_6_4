package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

/**
 * @author Huw_Lin
 * time: 2021-12-10 18:17
 */
public interface ResourceService {
    //资源分页以及多条件查询
    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo );
}
