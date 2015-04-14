package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class AdvertisingIdClient$a
  extends Thread
{
  private WeakReference<AdvertisingIdClient> lt;
  private long lu;
  CountDownLatch lv;
  boolean lw;
  
  public AdvertisingIdClient$a(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
  {
    this.lt = new WeakReference(paramAdvertisingIdClient);
    this.lu = paramLong;
    this.lv = new CountDownLatch(1);
    this.lw = false;
    start();
  }
  
  private void disconnect()
  {
    AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.lt.get();
    if (localAdvertisingIdClient != null)
    {
      localAdvertisingIdClient.finish();
      this.lw = true;
    }
  }
  
  public boolean aa()
  {
    return this.lw;
  }
  
  public void cancel()
  {
    this.lv.countDown();
  }
  
  public void run()
  {
    try
    {
      if (!this.lv.await(this.lu, TimeUnit.MILLISECONDS)) {
        disconnect();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        disconnect();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.a
 * JD-Core Version:    0.7.0.1
 */