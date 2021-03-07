package com.mdl.seckill.dao;


import com.mdl.seckill.entity.SeckillEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.seckill.dao
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2021年03月06日 17:52
 * ----------------- ----------------- -----------------
 */

@Mapper
public interface SeckillMapper {

  SeckillEntity queryById(String id);

}
