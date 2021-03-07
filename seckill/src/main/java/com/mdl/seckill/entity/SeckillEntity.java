package com.mdl.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 秒杀库存表
 * </p>
 *
 * @author xiekun
 * @since 2021-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("seckill")
@ApiModel(value="SeckillEntity对象", description="秒杀库存表")
public class SeckillEntity extends Model<SeckillEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品库存表")
    @TableId(value = "seckill_id", type = IdType.AUTO)
    private Long seckillId;

    @ApiModelProperty(value = "商品名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "库存数量")
    private Integer number;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "秒杀开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "秒杀结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;


    @Override
    protected Serializable pkVal() {
        return this.seckillId;
    }

}
