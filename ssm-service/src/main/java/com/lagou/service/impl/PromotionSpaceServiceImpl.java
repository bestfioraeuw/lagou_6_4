package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Huw_Lin
 * time: 2021-12-08 14:24
 */

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;


    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        //1 封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);
        //2 调用Mapper方法
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
      return promotionSpaceMapper.findPromotionSpaceById(id);
    }


    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        //封装数据
        Date date = new Date();
        promotionSpace.setUpdateTime(date);

        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
