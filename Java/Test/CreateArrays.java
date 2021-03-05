package com.Test;
import org.openjdk.jmh.annotations.*;

import java.awt.*;
import java.awt.List;
import java.util.*;
import java.util.concurrent.TimeUnit;


@State(Scope.Thread)
public class CreateArrays {
    @Param({ "100",  "1000" })
    public int size;

//    @State(Scope.Thread)
//    public static class MyState
//    {
//        @Param({ "100",  "1000" })
//        public int size;
//
//        int[] arr;
//
//        @Setup(Level.Iteration)
//        public void setup()
//        {
//
//        }
//    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createArray ()
    {   int cnt=0;
        Integer[] arr= new Integer[size];
        for(int i=0;i<size;i++) {
            arr[i]=i;
            cnt++;
        }
        return cnt;
    }



    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createLinkedList ()
    {   int cnt=0;
        LinkedList<Integer> List= new LinkedList<>();
        for(int i=0;i<size;i++) {
            List.add(i);
            cnt++;
        }
        return cnt;
    }




    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createStack ()
    {   int cnt=0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<size;i++) {
            stack.push(i);
            cnt++;
        }
        return cnt;
    }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createQueue ()
    {   int cnt=0;
        Queue<Integer> queue =new PriorityQueue<>() ;
        for(int i=0;i<size;i++) {
            queue.add(i);
            cnt++;
        }
        return cnt;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createArrList ()
    {   int cnt=0;
        ArrayList<Integer> List= new ArrayList<Integer>();
        for(int i=0;i<size;i++) {
            List.add(i);
            cnt++;
        }
        return cnt;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createHashTable ()
    {   int cnt=0;
        Hashtable<Integer, String> h =
                new Hashtable<Integer, String>();

        for(int i=0;i<size;i++) {
            h.put(i, "Test");
            cnt++;
        }
        return cnt;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createHashMap ()
    {   int cnt=0;
        Map< Integer,String> h = new Hashtable<>();

        for(int i=0;i<size;i++) {
            h.put(i, "Test");
            cnt++;
        }
        return cnt;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int createHashSet ()
    {   int cnt=0;
        Set<Integer> hash_Set = new HashSet<Integer>();

        for(int i=0;i<size;i++) {
            hash_Set.add(i);
            cnt++;
        }
        return cnt;
    }

//    public boolean check (List<Integer> list, int number)
//    {
//        boolean test = false;
//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext())
//        {
//            Integer nr = it.next();
//            if(nr == number)
//                test = true;
//        }
//        return test;
//    }
//
//
//    public boolean checkWithContains(List<Integer> list, int number)
//    {
//        return list.contains(number);
//    }
//
//	/*@Benchmark
//    @Fork(value = 2)
//    @Measurement(iterations = 10, time = 1)
//    @Warmup(iterations = 5, time = 1)
//    public boolean testCheck(MyState state) {
//       return check(state.numbers, new Random().nextInt(100));
//    }*/
//
//    public void remove(List<Integer> list, int index)
//    {
//        list.remove(index);
//    }
//
//    /*@Benchmark
//    @Fork(value = 2)
//    @Measurement(iterations = 10, time = 1)
//    @Warmup(iterations = 5, time = 1)
//    public boolean testCheck2(MyState state) {
//       return checkWithContains(state.numbers, new Random().nextInt(100));
//    }
//
//    @Benchmark
//    @Fork(value = 2)
//    @Measurement(iterations = 10, time = 1)
//    @Warmup(iterations = 5, time = 1)
//    public void testAdd(MyState state) {
//       state.numbers.add(new Random().nextInt(100));
//    }
//    */
//    @Benchmark
//    @Fork(value = 2)
//    @Measurement(iterations = 10, time = 1)
//    @Warmup(iterations = 5, time = 1)
//    public void testRemove(MyState state) {
//        state.numbers.remove(1);
//    }



}
