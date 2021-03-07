package com.mdl.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mdl.seckill.dao.SeckillMapper;
import com.mdl.seckill.entity.SeckillEntity;
import com.mdl.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀库存表 服务实现类
 * </p>
 *
 * @author xiekun
 * @since 2021-03-07
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, SeckillEntity> implements SeckillService {

  @Autowired
  private SeckillMapper seckillMapper;

  @Override
  public SeckillEntity queryById(long seckillId) {
    QueryWrapper<SeckillEntity> wrapper = new QueryWrapper<>();
    wrapper.eq("seckill_id", seckillId);
    SeckillEntity seckillEntity = seckillMapper.selectOne(wrapper);
    return seckillEntity;
  }
}
