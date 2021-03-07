package com.mdl.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mdl.seckill.dao.SeckillMapper;
import com.mdl.seckill.dao.SuccessKilledMapper;
import com.mdl.seckill.dto.ExposerDTO;
import com.mdl.seckill.dto.SeckillExecutionDTO;
import com.mdl.seckill.entity.SeckillEntity;
import com.mdl.seckill.entity.SuccessKilledEntity;
import com.mdl.seckill.enums.SeckillStatEnum;
import com.mdl.seckill.exception.SeckillCloseException;
import com.mdl.seckill.exception.SeckillException;
import com.mdl.seckill.exception.SeckillRepeatException;
import com.mdl.seckill.service.SeckillService;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 秒杀库存表 服务实现类
 * </p>
 *
 * @author xiekun
 * @since 2021-03-07
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, SeckillEntity> implements
    SeckillService {

  private static final Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

  /**
   * 用于md5加密混淆用的盐
   */
  private final String slat = "fuygihuojnjkbgwehvjoispk#$%^&*()mlknbqihupeok@#$%^wfmlk";


  @Autowired
  private SeckillMapper seckillMapper;

  @Autowired
  private SuccessKilledMapper successKilledMapper;


  /**
   * demo
   */
  @Override
  public SeckillEntity queryBySeckillId(long seckillId) {
    QueryWrapper<SeckillEntity> wrapper = new QueryWrapper<>();
    wrapper.eq("seckill_id", seckillId);
    SeckillEntity seckillEntity = seckillMapper.selectOne(wrapper);
    if (logger.isDebugEnabled()) {
      logger.debug("seckillEntity", seckillEntity);
    }
    return seckillMapper.queryBySeckillId(seckillId);
  }

  /**
   * 根据偏移量查询秒杀商品列表
   */
  @Override
  public List<SeckillEntity> getSeckillList() {
    return seckillMapper.queryAll(0, 4);
  }

  /**
   * 根据id查询秒杀的商品信息
   */
  @Override
  public SeckillEntity getById(long seckillId) {
    return seckillMapper.queryBySeckillId(seckillId);
  }

  @Override
  public ExposerDTO exportSeckillUrl(long seckillId) {

    SeckillEntity seckillEntity = seckillMapper.queryBySeckillId(seckillId);
    if (seckillEntity == null) {
      return new ExposerDTO(false, seckillId);
    }
    LocalDateTime startTime = seckillEntity.getStartTime();
    LocalDateTime endTime = seckillEntity.getEndTime();
    LocalDateTime now = LocalDateTime.now();

    //还未开始或者已经结束
    if (now.isBefore(startTime) || now.isAfter(endTime)) {
      return new ExposerDTO(false, seckillId, now, startTime, endTime);
    }
    //转化成特定加密的md5返回，不可逆
    String md5 = getMd5(seckillId);
    return new ExposerDTO(true, md5, seckillId);
  }


  /**
   * 执行秒杀
   */
  @Override
  public SeckillExecutionDTO executeSeckill(long seckillId, long userPhone, String md5)
      throws SeckillRepeatException, SeckillCloseException {
    if (md5 == null || !md5.equals(getMd5(seckillId))) {
      throw new SeckillException("seckill data rewrite");
    }

    //执行秒杀逻辑：减库存 + 记录购买行为
    LocalDateTime now = LocalDateTime.now();

    try {
      //减库存
      int updateCount = seckillMapper.reduceNumber(seckillId, now);
      if (updateCount < 0) {
        throw new SeckillCloseException("seckill is closed");
      } else {
        //记录购买记录
        int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);

        //唯一:seckillId,userPhone
        if (insertCount <= 0) {
          //重复秒杀
          throw new SeckillRepeatException("seckill repeated");
        } else {
          //秒杀成功
          SuccessKilledEntity successKilledEntity = successKilledMapper
              .queryByIdWithSeckill(seckillId, userPhone);
          return new SeckillExecutionDTO(seckillId, SeckillStatEnum.SUCCESS, successKilledEntity);
        }
      }
    } catch (SeckillRepeatException re) {
      throw re;
    } catch (SeckillCloseException ce) {
      throw ce;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      //所有编译期异常，转化为运行期异常
      throw new SeckillException("seckill inner error:" + e.getMessage());
    }
  }

  /**
   * 生成md5
   */
  private String getMd5(long seckillId) {
    String base = seckillId + "/" + slat;
    return DigestUtils.md5DigestAsHex(base.getBytes());
  }


}
