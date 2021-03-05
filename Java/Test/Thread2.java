package com.Test;


import java.util.concurrent.Semaphore;

public class Thread2 extends Thread{

    Semaphore sem1;
    Semaphore sem2;

    public Thread2(Semaphore sem1, Semaphore sem2){
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run() {
        try {
            sem1.acquire();
           // System.out.println("Thread " + this.getName() + " got the semaphore");
            sem2.release();
            //System.out.println("Thread " + this.getName() + " will soon stop ");
            sem1.acquire();
            //System.out.println("Thread " + this.getName() + " is  is done");
            sem2.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}