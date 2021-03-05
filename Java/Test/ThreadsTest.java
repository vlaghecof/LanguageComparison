package com.Test;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class ThreadsTest {

//    @Param({ "10", "50", "100" })
//    public int size;


//@Benchmark
//@Fork(value = 1)
//@Measurement(iterations = 2, time = 1)
//@Warmup(iterations = 1, time = 1)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@BenchmarkMode(Mode.AverageTime)
//public Thread[] ThreadCreation()
//{
//    Thread myThreads[] = new Thread[size];
//    for (int j = 0; j < size; j++) {
//        myThreads[j] = new Thread();
//    }
//    return myThreads;
//}

    @State(Scope.Thread)
    public static class MyState
    {

        private static Semaphore sem1;
        private static Semaphore sem2;
        @Setup(Level.Iteration)
        public void setup() {
            sem1= new Semaphore(1);
            sem2= new Semaphore(0);

        }


    }

    Semaphore sem1= new Semaphore(1);
    Semaphore sem2= new Semaphore(0);

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void ThreadS()
    {
        Thread t1 = new Thread1(sem1,sem2);
        Thread t2 = new Thread2(sem2,sem1);
    //    t1.setName("T1");
       // t2.setName("T2");
        t1.start();
        t2.start();
    }


}
