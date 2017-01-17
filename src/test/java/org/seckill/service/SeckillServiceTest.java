package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


//配置spring和junit整合
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        long skId = 1000L;
        Seckill seckill = seckillService.getById(skId);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
        //Exposer{exposed=true, md5='b2ce8fa7ac2a58b4685a24249da296d7',
        //seckillId=1000, now=0, start=0, end=0}
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1000L;
        long phone = 13001020102L;
        String md5 = "b2ce8fa7ac2a58b4685a24249da296d7";
        try{
            SeckillExecution seckillExecution = seckillService.executeSeckill(id,phone,md5);
            logger.info("SeckillExecution={}",seckillExecution);
        } catch (RepeatKillException e){
            logger.error(e.getMessage());
        }catch (SeckillCloseException e){
            logger.error(e.getMessage());
        }
        //SeckillExecution=SeckillExecution{seckillId=1000, state=1, state_info='秒杀成功',
        // successKilled=SuccessKilled{seckillId=1000, userPhone=13001020102, state=0,
        // createTime=Tue Jan 17 21:33:59 GMT+08:00 2017}}
    }

    //测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 13001020102L;
            String md5 = exposer.getMd5();
            try{
                SeckillExecution seckillExecution = seckillService.executeSeckill(id,phone,md5);
                logger.info("SeckillExecution={}",seckillExecution);
            } catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }
        else {
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }
}