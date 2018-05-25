package threading;


import java.util.*;
import java.io.*;

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

public class Threading implements Runnable
{    
    
    @Override
    public void run()
    {
        //I think this is thread 2
    }
    
    
    public static void main(String[] args)
    {
        Threading myThreading = new Threading();
        Thread t = new Thread(myThreading);
        t.setPriority(1);
        t.start();

        //This should be thread 1

    }
    
}
