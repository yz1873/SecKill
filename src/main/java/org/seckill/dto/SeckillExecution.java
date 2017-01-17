package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
 * 封装秒杀执行后结果
 * Created by Zhang Yu on 2017/1/17.
 */
public class SeckillExecution {

    private long seckillId;

    //秒杀执行结果状态
    private int state;

    //结果表示
    private String state_info;

    //秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, int state, String state_info, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.state_info = state_info;
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, int state, String state_info) {
        this.seckillId = seckillId;
        this.state = state;
        this.state_info = state_info;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getState_info() {
        return state_info;
    }

    public void setState_info(String state_info) {
        this.state_info = state_info;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
