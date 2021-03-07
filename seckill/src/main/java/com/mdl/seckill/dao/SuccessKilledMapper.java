package com.mdl.seckill.dao;

import com.mdl.seckill.entity.SuccessKilledEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 秒杀成功明细 Mapper 接口
 * </p>
 *
 * @author xiekun
 * @since 2021-03-07
 */
public interface SuccessKilledMapper extends BaseMapper<SuccessKilledEntity> {

  /**
   * 插入购买明细,可过滤重复
   * @param seckillId
   * @param userPhone
   * @return插入的行数
   */
  int insertSuccessKilled(long seckillId,long userPhone);


  /**
   * 根据秒杀商品的id查询明细SuccessKilled对象(该对象携带了Seckill秒杀产品对象)
   * @param seckillId
   * @return
   */
  SuccessKilledEntity queryByIdWithSeckill(long seckillId,long userPhone);

}
