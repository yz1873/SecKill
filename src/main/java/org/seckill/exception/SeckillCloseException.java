package org.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by Zhang Yu on 2017/1/17.
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
