package com.Test ;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class BenchmarkTesting {


//    int x = 7 ;
//    Integer x2 = 7;
//    int x3 ;
//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @BenchmarkMode(Mode.AverageTime)
//    @Fork(value = 1, warmups = 1)
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 5)
//    public void local() {
//        x+=1;
//    }
//
//    @Benchmark
//    @OutputTimeUnit(TimeUnit.SECONDS)
//    @BenchmarkMode(Mode.AverageTime)
//    @Fork(value = 1, warmups = 1)
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 5)
//    public void Dynamic() {
//        x3=x2.intValue();
//    }
}