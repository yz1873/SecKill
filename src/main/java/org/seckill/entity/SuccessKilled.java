package org.seckill.entity;

import java.util.Date;

/**
 * Created by Zhang Yu on 2017/1/16.
 */
public class SuccessKilled {

    private long seckillId;  //秒杀商品id

    private long userPhone;  //用户手机号

    private short state;  //状态标识: -1:无效 0:成功 1:已付款 2:已发货

    private Date createTime;  //创建时间-秒杀成功时间

    private Seckill seckill;  //多对一的复合属性

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
