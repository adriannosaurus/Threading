package threading;


import java.util.*;
import java.io.*;

public class Threading //implements Runnable
{    

	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();
	
    public static void main(String[] args)
    {
        //Threading myThreading = new Threading();
        //Thread t1 = new Thread(myThreading);
        harrythread t1 = new harrythread();
        t1.setName("Harry Potter");
        t1.setPriority(1);
        t1.start();
        
        ronthread t2 = new ronthread();
        t2.setName("Ron Weasley");
        t2.setPriority(2);
        t2.start();
    }
    
    private static class Inventory
    {
        private int stock;
        private int soldStock;
        public Inventory(int i)
        {
            this.stock = i;
            this.soldStock= 1000-stock;
        }
        
        public int getStock()
        {
            return stock;
        }
        public int getSoldStock()
        {
        	return (1000-stock);
        }
        public void makeSale(int sell) 
        {
        	
        	if(stock<sell) {
            	System.out.println("insufficient stock");
            }
        	else{
        		stock = stock - sell;
        		soldStock = 1000-stock;
        		System.out.println("sale complete");
        	}
        	
        }
        public void orderStock(int order)
        {
        	if(soldStock !=stock)
        	{

        		System.out.println("must sell all stock before ordering more stock");
        	}
        	else
        	{
        		stock = stock + order;
            	soldStock=1000-stock;
        	}
        }
    }
    
    private static class harrythread extends Thread {
    	public void run() {
    		synchronized (Lock1) {
    			int inventory = Thread.currentThread().getPriority() * 100;
    			Inventory inv = new Inventory(inventory);

    			int stock = inv.getStock();
    			int soldStock = inv.getSoldStock();
    			
    			System.out.println(Thread.currentThread().getName() + "'s inventory is " + stock);
    			//System.out.println("harry: Holding lock 1...");
    			
    			try {
    				Thread.sleep(10);
    			}catch(InterruptedException e) {}
    			System.out.println(Thread.currentThread().getName() + "'s sold inventory is " + soldStock);
    			//System.out.println("Harry: Holding lock 2");
    			int order = 1000;
                System.out.println("Harry: recieving order for "+order+" units");
                inv.makeSale(order);
    			
    			synchronized(Lock2) {
                    System.out.println("Harry: Holding to order stock...");
                    inv.orderStock(order);
    			}
    		}
    	}
    }
    private static class ronthread extends Thread {
    	public void run() {
    		synchronized (Lock2) {
    			Inventory inv = new Inventory((Thread.currentThread().getPriority() * 100));

    			int stock = inv.getStock();
    			int soldStock = inv.getSoldStock();
    			
    			System.out.println(Thread.currentThread().getName() + "'s inventory is " + stock);
                //System.out.println("Ron: Holding lock 1...");
               
                try {
                   Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getName() + "'s sold inventory is " + soldStock);
                //System.out.println("Ron: Waiting for lock 2...");
                int order = 1000;
                System.out.println("Ron: recieving order for "+order+" units");
                inv.makeSale(order);
                
                
                synchronized (Lock1) {
                   System.out.println("Ron: Holding to order stock...");
                   inv.orderStock(order);
                }
    		}
    	}
    }
    
    /*@Override
    public synchronized void run()
    {
        Inventory inv = new Inventory((Thread.currentThread().getPriority() * 100));
        System.out.println(Thread.currentThread().getName() + "'s inventory is " + inv.getStock());
    }*/
    
    
    
    /*int num = 0;
    /*public synchronized void addNum(int x)
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
