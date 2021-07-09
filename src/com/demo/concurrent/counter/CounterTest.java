package com.demo.concurrent.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterTest {
    public static void main(String[] args) throws Exception {
        // 150
        //test(new StupidCounter());

        // 同步性能 2700
        //test(new SyncCounter());

        // 锁性能 2100
        //test(new LockCounter());

        // 原子性能 1800
        test(new AtomicCounter());

        // CAS性能
        //test(new CASCounter());
    }


    public static void test(Counter counter) throws InterruptedException {
        int NUM_OF_THREADS = 1000;
        int NUM_OF_INCREMENTS = 100000;
        ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);
        long before = System.currentTimeMillis();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            service.submit(new CounterClient(counter, NUM_OF_INCREMENTS));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        long after = System.currentTimeMillis();
        System.out.println("Counter result: " + counter.getCounter());
        System.out.println("Time passed in ms:" + (after - before));
        System.out.println("-------------------");
    }

}
