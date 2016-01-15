package test;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ohme implements Runnable
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread main = new Thread(new Ohme());
        main.setDaemon(false);
        main.start();

        Executor executor = Executors.newFixedThreadPool(5);
        executor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    System.out.print('x');
                    byte buf[] = new byte[1024];
                    Arrays.fill(buf,(byte)'a');
                    while (true)
                    {
                        System.out.print('z');
                        byte newbuf[] = new byte[buf.length * 2];
                        Arrays.fill(newbuf,(byte)'x');
                        System.arraycopy(buf,0,newbuf,0,buf.length);
                        buf = newbuf;
                    }
                }
                catch (Error e)
                {
                    System.out.print("!");
                    e.printStackTrace(System.err);
                }
            }
        });

        main.join(); // wait on this thread to finish
    }

    public void run()
    {
        while (true)
        {
            try
            {
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch (InterruptedException ignore)
            {
            }
            System.out.print(".");
        }
    }
}
