package com.parse;

import android.app.Service;
import android.os.Looper;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

class PushConnection
{
  private static final int CONNECT_TIMEOUT_MS = 40000;
  static boolean ENABLE_QUICK_ACK_CHECK = true;
  static boolean ENABLE_RETRY_DELAY = true;
  static long KEEP_ALIVE_ACK_INTERVAL = 0L;
  static long KEEP_ALIVE_INTERVAL = 900000L;
  private static final long MAX_RETRY_DELAY_MS = 300000L;
  private static final long MIN_RETRY_DELAY_MS = 15000L;
  private static final double RETRY_MULT_FACTOR_MAX = 2.0D;
  private static final double RETRY_MULT_FACTOR_MIN = 1.5D;
  private static final String TAG = "com.parse.PushConnection";
  private static PushConnection.StateTransitionListener stateTransitionListener;
  private final PushConnection.EventSet eventSet;
  private final ExecutorService executor;
  private final String host;
  private final AtomicLong lastReadTime;
  private final int port;
  private final Service service;
  
  static
  {
    KEEP_ALIVE_ACK_INTERVAL = 60000L;
  }
  
  public PushConnection(Service paramService, String paramString, int paramInt)
  {
    this.service = paramService;
    this.host = paramString;
    this.port = paramInt;
    this.executor = Executors.newSingleThreadExecutor();
    this.eventSet = new PushConnection.EventSet(null);
    this.lastReadTime = new AtomicLong();
    this.executor.execute(new PushConnection.WaitStartState(this));
  }
  
  private static void closeSocket(Socket paramSocket)
  {
    try
    {
      paramSocket.shutdownInput();
      paramSocket.close();
      label8:
      return;
    }
    catch (IOException localIOException)
    {
      break label8;
    }
  }
  
  public static void setStateTransitionListener(PushConnection.StateTransitionListener paramStateTransitionListener)
  {
    try
    {
      stateTransitionListener = paramStateTransitionListener;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean writeLine(Socket paramSocket, String paramString)
  {
    boolean bool = false;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new Error("Wrote to push socket on main thread.");
    }
    try
    {
      OutputStream localOutputStream = paramSocket.getOutputStream();
      localOutputStream.write((paramString + "\n").getBytes("UTF-8"));
      localOutputStream.flush();
      bool = true;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Parse.logV("com.parse.PushConnection", "PushConnection write failed: " + paramString + " due to exception: " + localIOException);
      }
    }
    return bool;
  }
  
  public void start()
  {
    try
    {
      this.eventSet.signalEvent(PushConnection.Event.START);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stop()
  {
    try
    {
      this.eventSet.signalEvent(PushConnection.Event.STOP);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection
 * JD-Core Version:    0.7.0.1
 */