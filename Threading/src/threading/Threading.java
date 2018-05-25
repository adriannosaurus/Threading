package threading;


import java.util.*;
import java.io.*;

public class Threading implements Runnable
{    
    int i = 1;
    @Override
    public void run()
    {
        System.out.println("Test. Hello from thread " + i++ + "!");
    }
    
    
    public static void main(String[] args)
    {
        Threading myThreading = new Threading();
        Thread t = new Thread(myThreading);
        t.setPriority(1);
        t.start();
        
        Thread t2 = new Thread(myThreading);
        t2.setPriority(2);
        t2.start();
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
