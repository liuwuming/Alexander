package org.springframework.security.web.authentication;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 红包5个、7个人抢、 总额10元
 * @author lwm-t196
 *
 */
public class AtomicIntegerQHB {
	
	private final static Logger logger = LoggerFactory.getLogger(AtomicIntegerQHB.class);
	public static int totalUsers = 7;//7个人抢
	public static int hbCount = 5;//5个红包
    public static BigDecimal totalAmount = new BigDecimal(10);//10元红包
    public static AtomicInteger counter = new AtomicInteger(0);//红包计数器
	
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(7);//获取线程池
        for (int i = 0; i < totalUsers ; i++) {
            executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						BigDecimal getMoney = getRandomMoney();
	                    if(getMoney.doubleValue() == 0) {
	                    	System.out.println(Thread.currentThread().getName()+"，手慢了没抢到。");
	                    }else {
	                    	System.out.println(Thread.currentThread().getName()+"，抢到："+getMoney);
	                    }
	                } catch (Exception e) {
	                	logger.error("exception", e);
	                }
				}
            });
        }
        executorService.shutdown();
    }
 
    private synchronized static BigDecimal getRandomMoney() {
    	counter.incrementAndGet();
    	if(counter.get()==5) {
    		return totalAmount;
    	}
    	if(counter.get()>5) {
    		return new BigDecimal(0);
    	}
    	BigDecimal amount = totalAmount.multiply(new BigDecimal(100)); //总额*100 
    	int weight = 5 - counter.get();//计算权重
    	int randomNum = new Random().nextInt(amount.intValue()/weight);//// 随机生成当前金额的随机数 (amount/weight),尽量平均一点
    	BigDecimal randomMaoney = new BigDecimal(randomNum).divide(new BigDecimal(100));//获取到随机金额/100
    	totalAmount = totalAmount.subtract(randomMaoney);//计算剩余红包金额
    	return randomMaoney;
    }
}
