package com.haotu.concurrent.basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

//forkJoin 并行计算
public class ForkJoinDemo {
    static final class SumTask extends RecursiveTask<Double> {
        private static final long serialVersionUID = 1L;

        final long start; //开始计算的数
        final long end; //最后计算的数

        SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute() {
            //如果计算量小于1000，那么分配一个线程执行if中的代码块，并返回执行结果
            if(end - start < 1000) {
                //System.out.println(Thread.currentThread().getName() + " 开始执行: " + start + "-" + end);
                double sum = 0;
                for(long i = start; i <= end; i++)
                    sum += i;
                return sum;
            }
            //如果计算量大于1000，那么拆分为两个任务
            SumTask task1 = new SumTask(start, (start + end) / 2);
            SumTask task2 = new SumTask((start + end) / 2 + 1, end);
            //执行任务
            task1.fork();
            task2.fork();
            //获取任务执行的结果
            return task1.join() + task2.join();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long N = 300_0000_0000L;
        ForkJoinPool pool = new ForkJoinPool();
        long s = System.currentTimeMillis();
        ForkJoinTask<Double> task = new SumTask(1, N);
        pool.submit(task);
        System.out.println(task.get());
        System.out.println("耗时：" + (System.currentTimeMillis() - s) + "ms");
        //
        double sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + ", time=" + (end - start) + "ms");

    }
}