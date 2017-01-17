package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhang Yu on 2017/1/16.
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    //java没有保存形参的记录：queryAll(int offset,int limit) -> queryAll(arg0,arg1);
    //多参数解决方式1：只传一个参数，把这两个变量整合成一个变量，如变成map类型
    //多参数解决方式2：告诉mybatis，哪个位置的参数应该叫哪个名字。mybatis在#{offset}时才知道其具体值
    //采取方式是用mybatis提供的@Param()注解，标注其参数
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
