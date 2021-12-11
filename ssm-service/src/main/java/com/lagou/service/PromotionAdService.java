package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

/**
 * @author Huw_Lin
 * time: 2021-12-09 02:46
 */
public interface PromotionAdService {
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    public void updatePromotionAdStatus(int id ,int status);

    public void savePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAd(PromotionAd promotionAd);

    public PromotionAd findPromotionById(int id);
}
