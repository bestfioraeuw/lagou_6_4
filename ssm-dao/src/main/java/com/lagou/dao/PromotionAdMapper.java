package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @author Huw_Lin
 * time: 2021-12-09 02:32
 */
public interface PromotionAdMapper {
    public List<PromotionAd> findAllPromotionAdByPage();


    public void updatePromotionAdStatus(PromotionAd promotionAd);

    public void savePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAd(PromotionAd promotionAd);

    public PromotionAd findPromotionAdById(int id);
}
