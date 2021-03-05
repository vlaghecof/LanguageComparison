package com.Test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Departmant extends Thread implements Runnable
{

    public ReentrantLock lock = new ReentrantLock();

    int salary;

    Random r = new Random();

    public Departmant() {
        this.salary = 10000;
    }

    int Withdraw(int amount)
    {

        {
            System.out.print("salary Before "+ salary);
            salary = salary - amount;
            System.out.println("salary adter "+ salary);
            return salary;
        }
    }


    int WithdrawSinc(int amount)
    {
        lock.lock();
        try
        {
            System.out.print("salary Before "+ salary);
            salary = salary - amount;
            System.out.println("salary adter "+ salary);
            lock.unlock();
            return salary;
        }  finally {

        }

    }

    public void DoTransactions()
    {
        Withdraw((new Random().nextInt(100)));
    }


    public void DoOrderedTransactions()
    {
        WithdrawSinc((new Random().nextInt(100)));
    }


    @Override
    public void run() {
        try {
              WithdrawSinc(100);
//            Withdraw(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}