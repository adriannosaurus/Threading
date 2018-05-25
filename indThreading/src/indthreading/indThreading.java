package indthreading;

public class indThreading implements Runnable
{
    public static void main(String[] args)
    {
        indThreading thisClass = new indThreading();
        
        Thread t1 = new Thread(thisClass);
        t1.start();
    }

    @Override
    public void run()
    {
        System.out.println("hello there");
    }

}
