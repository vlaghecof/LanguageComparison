package com.Test;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AddLast {

    @State(Scope.Thread)
    public static class MyState
    {
        @Param({ "100",  "1000" })
        public int size;
        int[] randomArr =  new int[11];


        Integer[] arr = new Integer[size];
        ArrayList<Integer> arrayList =  new ArrayList<Integer>();
        LinkedList<Integer> list= new LinkedList<>();
        Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
        Map< Integer,Integer> hMap = new Hashtable<>();
        Set<Integer> hash_Set = new HashSet<Integer>();

        @Setup(Level.Iteration)
        public void setup()
        {

            for (int i = 0; i < size; i++) {
                arr[i]=i;
                arrayList.add(i);
                list.add(i);
                hash.put(i,i+3);
                hMap.put(i,i+55);
                hash_Set.add(i);
            }
            for (int i = 0; i < 10; i++)
                randomArr[i]= (new Random().nextInt(size));
        }


    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int addLastArray (FindTest.MyState state)
    {   int cnt=0;
        Integer[] arr= state.arr;
        int[] randomNumbers= state.randomArr;
        int size = state.size;

        for(int i=0;i<10;i++) {
            arr= Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length-1]=randomNumbers[i];
            cnt++;
        }
        return cnt;
    }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int addLastArrayList (FindTest.MyState state)
    {   int cnt=0;
        ArrayList <Integer >arr= state.arrayList;
        int[] randomNumbers= state.randomArr;
        int size = state.size;
        for(int i=0;i<10;i++) {
            arr.add(randomNumbers[i]);
            cnt ++;
        }
        cnt++;
        return cnt;
    }



    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int findLinkedList (FindTest.MyState state)
    {   int cnt=0;
        LinkedList<Integer> list = state.list;
        int[] randomNumbers= state.randomArr;
        int size = state.size;
        for(int i=0;i<10;i++) {
            cnt ++;
            list.addLast(randomNumbers[i]);
        }
        cnt++;

        return cnt;
    }


}
