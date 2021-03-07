package com.mdl.seckill.service;

import com.mdl.seckill.entity.SeckillEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 秒杀库存表 服务类
 * </p>
 *
 * @author xiekun
 * @since 2021-03-07
 */
public interface SeckillService extends IService<SeckillEntity> {

  SeckillEntity queryById(long seckillId);

}
