package com.mdl.seckill.dao;

import com.mdl.seckill.entity.SeckillEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 秒杀库存表 Mapper 接口
 * </p>
 *
 * @author xiekun
 * @since 2021-03-07
 */

@Repository
public interface SeckillMapper extends BaseMapper<SeckillEntity> {

}
