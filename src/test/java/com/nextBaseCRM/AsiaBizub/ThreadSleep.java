package com.nextBaseCRM.AsiaBizub;

public class ThreadSleep {

    public static void threadSleep(long seconds) {
        long milliseconds = seconds *1000;
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
