package org.springframework.security.web.authentication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 当多个线程要共享一个实例对象的值得时候，那么在考虑安全的多线程并发编程时就要保证下面3个要素：
	原子性（Synchronized, Lock）
	有序性(Volatile，Synchronized, Lock)
	可见性(Volatile，Synchronized,Lock)
 * @author lwm-t196
 *
 */
public class AtomicIntegerExample1 {
		private final static Logger logger = LoggerFactory.getLogger(AtomicIntegerExample1.class);
	    // 请求总数
	    public static int clientTotal = 5000;
	    // 同时并发执行的线程数
	    public static int threadTotal = 1;
		
	    public static AtomicInteger count = new AtomicInteger(0);
		
	    public static void main(String[] args) throws Exception {
	        ExecutorService executorService = Executors.newCachedThreadPool();//获取线程池
	        final Semaphore semaphore = new Semaphore(threadTotal);//定义信号量   限流
	        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);//计数器
	        for (int i = 0; i < clientTotal ; i++) {
	            executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
		                    semaphore.acquire();
		                    add();
		                    semaphore.release();
		                } catch (Exception e) {
		                	logger.error("exception", e);
		                }
		                countDownLatch.countDown();
					}
	            	
	            });
	        }
	        countDownLatch.await();
	        executorService.shutdown();
	        logger.info("count:{}", count.get());
	    }
	 
	    private static void add() {
	        count.incrementAndGet();
	    }
}
