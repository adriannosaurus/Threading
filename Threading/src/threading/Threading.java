package threading;


import java.util.*;
import java.io.*;

public class Threading implements Runnable
{    
    public static void main(String[] args)
    {
        Threading myThreading = new Threading();
        Thread t1 = new Thread(myThreading);
        t1.setName("Harry Potter");
        t1.setPriority(1);
        t1.start();
        
        Thread t2 = new Thread(myThreading);
        t2.setName("Ron Weasley");
        t2.setPriority(2);
        t2.start();
    }
    
    @Override
    public synchronized void run()
    {
        Inventory inv = new Inventory((Thread.currentThread().getPriority() * 100));
        System.out.println(Thread.currentThread().getName() + "'s inventory is " + inv.getStock());
    }
    
    private static class Inventory
    {
        private int stock;
        public Inventory(int i)
        {
            this.stock = i;
        }
        
        public int getStock()
        {
            return stock;
        }
    }
    
    int num = 0;
    public synchronized void addNum(int x)
    {
        num += x;
        System.out.println("   Number: " + num);
    }
    
/*
public class Threading extends Thread
{    
    
    @Override
    public void run()
    {
        //I think this is thread 1
    }
    
    
    public static void main(String[] args)
    {
        Threading myThreading = new Threading();
        myThreading.start();

        //This should be thread 2

    }
    
}
*/
    
}
