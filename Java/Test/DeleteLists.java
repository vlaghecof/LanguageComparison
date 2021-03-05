package com.Test;



import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DeleteLists {

    @State(Scope.Benchmark)
    public static class States {

        @Param({ "100", "1000"})
        public int size;

        public int n;

        public int[] arr;
        int[] randomArr;
        public ArrayList<Integer> arrList;
        public LinkedList<Integer> linkedList;
        public HashSet<Integer> hashSet;
        public TreeSet<Integer> treeSet;

       public  Map< Integer,Integer> hMap = new Hashtable<>();
       public    Set<Integer> hash_Set = new HashSet<Integer>();



        @Setup(Level.Invocation)
        public void setup() {
            arr = new int[1100];
            randomArr= new int[1100];
            arrList = new ArrayList<>();
            linkedList = new LinkedList<>();
            hashSet = new HashSet<>();
            treeSet = new TreeSet<>();
            for(int i = 0; i < 1100; i++){
                arr[i] = i;
                arrList.add(i);
                linkedList.add(i);
                hashSet.add(i);
                treeSet.add(i);
            }
            
            for (int i = 0; i < 10; i++)
            {  randomArr[i]= (new Random().nextInt(size));
        }
        
        
        }
    }

    
    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int deleteArray (States state)
    {   int cnt=0;
        int[] arr= state.arr;
        int[] randomNumbers= state.randomArr ;
        int size = state.size;

        for(int i=0;i<10;i++) {
            for (int j = 0; j < size-1; j++) {
                if (arr[j]==randomNumbers[i])
                {
                    for(int q=j;q<size;q++)
                    {
                        arr[q]=arr[q+1];
                    }
                    cnt += randomNumbers[i];
                    break;
                }
            }
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
    public int findLinkedList (States state)
    {   int cnt=0;
        LinkedList<Integer> list = state.linkedList;
        int[] randomNumbers= state.randomArr;
        int size = state.size;
        for(int i=0;i<10;i++) {
            list.remove(randomNumbers[i]);
            cnt += i;
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
    public int deleteArrayList (States state)
    {   int cnt=0;
        ArrayList <Integer >arr= state.arrList;
        int[] randomNumbers= state.randomArr;
        int size = state.size;

        for(int i=0;i<10;i++) {

            arr.remove(randomNumbers[i]);
            cnt += i;
        }
        cnt++;
        return cnt;
    }

//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 1)
//    @Fork(value = 1, warmups = 1)
//    public void arrayLastDeletion(States state, Blackhole blackhole){
//        state.arr2[state.size - 2] = state.arr2[state.size - 1];
//        blackhole.consume(state.arr2);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 1)
//    @Fork(value = 1, warmups = 1)
//    public void arrayListDeletion(States state, Blackhole blackhole){
//        state.arrList.remove(state.arrList.size() / 2);
//        blackhole.consume(state.arrList);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 1)
//    @Fork(value = 1, warmups = 1)
//    public void linkedListDeletion(States state, Blackhole blackhole){
//        state.linkedList.remove(state.linkedList.size() / 2);
//        blackhole.consume(state.linkedList);
//    }
//
//



}
