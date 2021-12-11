package com.lagou.dao;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-08 14:21
 */
public interface PromotionSpaceMapper {

    public List<PromotionSpace> findAllPromotionSpace();


//    添加广告位
    public void savePromotionSpace(PromotionSpace promotionSpace);

    //根据id查询广告位信息
    public PromotionSpace findPromotionSpaceById(int id);

    //更新广告位信息
    public void  updatePromotionSpace(PromotionSpace promotionSpace);
}
