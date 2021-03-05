package com.Test;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class ThreadNewtest {
    public static int sharedVariable;
    public static final Object lock = new Object();
    public ThreadClass[] tarr = new ThreadClass[100];



    @Param({"10", "50", "100"})
    public int size;

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public ThreadClass[] create() {
        ThreadClass[] tarrs = new ThreadClass[100];
        for (int i = 0; i < size; i++) {
            tarrs[i] = new ThreadClass();
//            tarrs[i].start();
        }
        return tarrs;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void UseSinc() throws InterruptedException {
        ThreadClass[] tarrs = new ThreadClass[100];
        for (int i = 0; i < size; i++) {
            tarrs[i] = new ThreadClass();
            tarrs[i].start();
        }

        synchronized(ThreadNewtest.lock)
        {
            //sample operation
            if(sharedVariable==0) {
                ThreadNewtest.sharedVariable = 1;

            }
        }

        for(int i =0;i<10;i++)
        {
            tarrs[i].join();
        }


    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void UseASinc()
    {
        ThreadClassAsinc[] tarrs = new ThreadClassAsinc[100];
        for (int i = 0; i < size; i++) {
            tarrs[i] = new ThreadClassAsinc();
            tarrs[i].start();
        }



    }



    public static void main(String[] args) throws InterruptedException {
        ThreadClass[] tarr = new ThreadClass[100];

        for(int i =0;i<10;i++)
        {   tarr[i] = new ThreadClass();
            tarr[i].start();
          //  tarr[i].join();
        }

        synchronized(lock)
        {
            //sample operation
            if(sharedVariable==0) {
                ThreadNewtest.sharedVariable = 1;

            }
        }

        for(int i =0;i<10;i++)
        {
            tarr[i].join();
        }

        System.out.println(ThreadNewtest.sharedVariable);

    }
}


class ThreadClass extends Thread {
    @Override
    public void run() {
        synchronized(ThreadNewtest.lock) {
            //sample operation
            if(ThreadNewtest.sharedVariable>0) {

                ThreadNewtest.sharedVariable++;
            }
        }
    }
}

class ThreadClassAsinc extends Thread {
    @Override
    public void run() {

            //sample operation
            if(ThreadNewtest.sharedVariable>0) {

                ThreadNewtest.sharedVariable++;
            }

    }
}

