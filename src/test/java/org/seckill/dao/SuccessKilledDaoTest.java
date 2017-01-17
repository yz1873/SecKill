package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
//配置spring和junit整合
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SuccessKilledDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        //相同的手机号，第二次秒杀时，由于PRIMARY KEY(seckill_id,user_phone)
        //为联合主键，从而防止用户重复得秒杀.
        //且在insert语句中采用了insert ignore，ignore使得insert相同数据时不报错
        long skId = 1001L;
        long phoneNum = 13041010203L;
        int insertNum = successKilledDao.insertSuccessKilled(skId,phoneNum);
        System.out.println(insertNum);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        long skId = 1001L;
        long phoneNum = 13041010203L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(skId, phoneNum);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}