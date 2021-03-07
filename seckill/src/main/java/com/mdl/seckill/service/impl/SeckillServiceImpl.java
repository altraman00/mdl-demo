package com.mdl.seckill.service.impl;

import com.mdl.seckill.dao.SeckillDao;
import com.mdl.seckill.entity.SeckillEntity;
import com.mdl.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.seckill.service.impl
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2021年03月06日 17:53
 * ----------------- ----------------- -----------------
 */

@Service
public class SeckillServiceImpl implements SeckillService {

  @Autowired
  private SeckillDao seckillDao;

  @Override
  public SeckillEntity queryById(String id) {
    return seckillDao.queryById(id);
  }
}
