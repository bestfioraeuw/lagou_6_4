package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-08 14:23
 */
public interface PromotionSpaceService {

    public List<PromotionSpace> findAllPromotionSpace();

    public void savePromotionSpace(PromotionSpace promotionSpace);

    public PromotionSpace findPromotionSpaceById(int id);

    public void  updatePromotionSpace(PromotionSpace promotionSpace);
}
