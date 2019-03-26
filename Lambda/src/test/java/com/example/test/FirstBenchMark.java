package com.example.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by SI-GZ-1113 on 2018/9/4.
 * Mode
 * (1).Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
 (2).AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
 (3).SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
 (4).SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
 */

@BenchmarkMode(Mode.AverageTime) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.MICROSECONDS)// 输出结果的时间粒度为微秒
@State(Scope.Thread)// 每个测试线程一个实例
public class FirstBenchMark {
    // public final List<Integer> testData = new ArrayList<>(500000);
   /* @Benchmark
    public int sleepAWhile() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // ignore
        }
        return 0;
    }*/
    @State(Scope.Benchmark)
    public static class BenchMarkState {
        @Setup(Level.Trial)
        public void doSetup() {
            for(int i = 0; i < 500000; i++){
                testData.add(Integer.valueOf(i));
            }
        }
        @TearDown(Level.Trial)
        public void doTearDown() {
            testData = new ArrayList<>(500000);
        }
        public List<Integer> testData = new ArrayList<>(500000);
    }
    @Benchmark
    public List<Integer> streamSingleThread(BenchMarkState state){
        List<Integer> result = new ArrayList<>(state.testData.size());
        state.testData.stream().forEach(item -> {
            result.add(item);
        });
        return result;
    }

    /**
     * 刚找了相关的测试文章看了下，遍历对象复杂的时候用stream流串行遍历的效跟在容器外部循环差不多，稍好一点，
     * 多核情况下并行性能最优，简单对象的遍历还是外部循环好些
     * @param state
     * @return
     */
    @Benchmark
    public List<Integer> streamMultiThread(BenchMarkState state){
        List<Integer> result = new ArrayList<>(state.testData.size());
        state.testData.stream().parallel().forEach(item -> {
            result.add(item);
        });
        return result;
    }
    @Benchmark
    public List<Integer> forEach(BenchMarkState state){
        List<Integer> result = new ArrayList<>(state.testData.size());
        for(Integer item : state.testData){
            result.add(item);
        }
        return result;
    }
    @Benchmark
    public List<Integer> forCStyle(BenchMarkState state){
        int size = state.testData.size();
        List<Integer> result = new ArrayList<>(size);
        for(int j = 0; j < size; j ++){
            result.add(state.testData.get(j));
        }
        return result;
    }
    public static void main(String[] args) throws RunnerException {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        /**
         * Interation
         Iteration是JMH进行测试的最小单位。大部分模式下，iteration代表的是一秒，JMH会在这一秒内不断调用需要benchmark的方法，
         然后根据模式对其采样，计算吞吐量，计算平均执行时间等。
         Warmup
         Warmup是指在实际进行Benchmark前先进行预热的行为。因为JVM的JIT机制的存在，如果某个函数被调用多次以后，
         JVM会尝试将其编译成为机器码从而提高执行速度。所以为了让benchmark的结果更加接近真实情况就需要进行预热。
         fork
         进行 fork 的次数。如果 fork 数是2的话，则 JMH 会 fork 出两个进程来进行测试。
         */
        Options opt = new OptionsBuilder().include(FirstBenchMark.class.getSimpleName()).forks(1).warmupIterations(5)
                .measurementIterations(5).build();
        new Runner(opt).run();
    }
}
