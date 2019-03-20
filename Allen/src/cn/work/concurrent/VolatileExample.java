package org.springframework.security.web.authentication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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
public class VolatileExample {
	private final static Logger log = LoggerFactory.getLogger(VolatileExample.class);
	// 请求总数
    public static int clientTotal = 5000;
 
    // 同时并发执行的线程数
    public static int threadTotal = 200;
 
    //当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取共享变量时，它会去内存中读取新值。
    public static volatile int count = 0;
 
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal); //定义信号量   限流
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);//计数器
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }
 
    private static void add() {
        count++;
    }

}
