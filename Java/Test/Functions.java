package com.Test;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@State(Scope.Thread)
public class Functions {


    public int increment()
    {
        int x = 0;
        return x + 3;
    }

    public String concat()
    {
        String s = "";
        return s + "A";
    }


    int x = 7 ;
    Integer x2 = 7;





    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int Stack1Call()
    {
        int cnt = 0;
            cnt = increment();
        return cnt;
    }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void StackNoCall() {
        x+=1;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public Integer HeapNoCall() {
        Integer x3=x2+1;
        return x3;
    }



    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int Heap1call()
    {
        int cnt = 0;
        String str = "";

            cnt++;
            str = concat();

        return cnt;
    }



    public static double noRecFactorial(int number)
    {
        if (number == 0)
            return 1;

        double factorial = 1;
        for (int i = number; i >= 1; i--)
        {
            factorial = factorial * i;
        }
        return factorial;
    }


    public static int recusiveFactorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * recusiveFactorial(n-1));
    }



    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static double nonRecursiveFactorial_100()
    {
        return noRecFactorial(100);
    }
    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static double nonRecursiveFactorial_10000()
    {
        return noRecFactorial(10000);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static double nonRecursiveFactorial_1000()
    {
        return noRecFactorial(1000);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static int recusiveFactorial_100(){
        return  recusiveFactorial(100);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static int recusiveFactorial_1000(){
        return  recusiveFactorial(1000);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static int recusiveFactorial_10000(){
        return  recusiveFactorial(10000);
    }


//    @Benchmark
//    @Fork(value = 1)
//    @Measurement(iterations = 2, time = 1)
//    @Warmup(iterations = 1, time = 1)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @BenchmarkMode(Mode.AverageTime)
//    public String stringConcat() {
//        String result = "";
//        for (int i = 0; i < 1000; i++) {
//            result += String.valueOf(i);
//        }
//        return result;
//    }
//
//    @Benchmark
//    @Fork(value = 1)
//    @Measurement(iterations = 2, time = 1)
//    @Warmup(iterations = 1, time = 1)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @BenchmarkMode(Mode.AverageTime)
//    public String stringConcatWithChars() {
//        String result = "";
//        for (int i = 0; i < 1000; i++) {
//            result += i;
//        }
//        return result;
//    }
//
//    @Benchmark
//    @Fork(value = 1)
//    @Measurement(iterations = 2, time = 1)
//    @Warmup(iterations = 1, time = 1)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @BenchmarkMode(Mode.AverageTime)
//    public String concatUsingStringBuilder() {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < 1000; i++) {
//            result.append(i);
//        }
//        return result.toString();
//    }






}
