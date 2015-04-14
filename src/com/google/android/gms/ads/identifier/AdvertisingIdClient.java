package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import hZ;
import java.io.IOException;
import jp;
import jq;

public class AdvertisingIdClient
{
  a ln;
  jp lo;
  boolean lp;
  Object lq = new Object();
  AdvertisingIdClient.a lr;
  final long ls;
  private final Context mContext;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong)
  {
    hZ.a(paramContext);
    this.mContext = paramContext;
    this.lp = false;
    this.ls = paramLong;
  }
  
  private void Z()
  {
    synchronized (this.lq)
    {
      if (this.lr != null) {
        this.lr.cancel();
      }
    }
    try
    {
      this.lr.join();
      label28:
      if (this.ls > 0L) {
        this.lr = new AdvertisingIdClient.a(this, this.ls);
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label28;
    }
  }
  
  static jp a(Context paramContext, a parama)
  {
    try
    {
      jp localjp = jq.a(parama.gs());
      return localjp;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException("Interrupted exception");
    }
  }
  
  public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context paramContext)
  {
    AdvertisingIdClient localAdvertisingIdClient = new AdvertisingIdClient(paramContext, -1L);
    try
    {
      localAdvertisingIdClient.b(false);
      AdvertisingIdClient.Info localInfo = localAdvertisingIdClient.getInfo();
      return localInfo;
    }
    finally
    {
      localAdvertisingIdClient.finish();
    }
  }
  
  static a h(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      a locala;
      Intent localIntent;
      throw new IOException("Connection failure");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        GooglePlayServicesUtil.C(paramContext);
        locala = new a();
        localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
        localIntent.setPackage("com.google.android.gms");
        if (!paramContext.bindService(localIntent, locala, 1)) {
          break label79;
        }
        return locala;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        throw new IOException(localGooglePlayServicesNotAvailableException);
      }
      localNameNotFoundException = localNameNotFoundException;
      throw new GooglePlayServicesNotAvailableException(9);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    hZ.c("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.lp) {
        finish();
      }
      this.ln = h(this.mContext);
      this.lo = a(this.mContext, this.ln);
      this.lp = true;
      if (paramBoolean) {
        Z();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void finalize()
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc 142
    //   2: invokestatic 145	hZ:c	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 38	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 149	com/google/android/gms/ads/identifier/AdvertisingIdClient:ln	Lcom/google/android/gms/common/a;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 40	com/google/android/gms/ads/identifier/AdvertisingIdClient:lp	Z
    //   28: ifeq +14 -> 42
    //   31: aload_0
    //   32: getfield 38	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   35: aload_0
    //   36: getfield 149	com/google/android/gms/ads/identifier/AdvertisingIdClient:ln	Lcom/google/android/gms/common/a;
    //   39: invokevirtual 164	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 40	com/google/android/gms/ads/identifier/AdvertisingIdClient:lp	Z
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 153	com/google/android/gms/ads/identifier/AdvertisingIdClient:lo	Ljp;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 149	com/google/android/gms/ads/identifier/AdvertisingIdClient:ln	Lcom/google/android/gms/common/a;
    //   57: aload_0
    //   58: monitorexit
    //   59: goto -36 -> 23
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_2
    //   68: goto -26 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	AdvertisingIdClient
    //   62	4	1	localObject	Object
    //   67	1	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   7	23	62	finally
    //   24	42	62	finally
    //   42	65	62	finally
    //   24	42	67	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public AdvertisingIdClient.Info getInfo()
  {
    // Byte code:
    //   0: ldc 142
    //   2: invokestatic 145	hZ:c	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/google/android/gms/ads/identifier/AdvertisingIdClient:lp	Z
    //   11: ifne +91 -> 102
    //   14: aload_0
    //   15: getfield 30	com/google/android/gms/ads/identifier/AdvertisingIdClient:lq	Ljava/lang/Object;
    //   18: astore 6
    //   20: aload 6
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 46	com/google/android/gms/ads/identifier/AdvertisingIdClient:lr	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$a;
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: getfield 46	com/google/android/gms/ads/identifier/AdvertisingIdClient:lr	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$a;
    //   34: invokevirtual 172	com/google/android/gms/ads/identifier/AdvertisingIdClient$a:aa	()Z
    //   37: ifne +26 -> 63
    //   40: new 71	java/io/IOException
    //   43: dup
    //   44: ldc 174
    //   46: invokespecial 76	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore 7
    //   52: aload 6
    //   54: monitorexit
    //   55: aload 7
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: aload 6
    //   65: monitorexit
    //   66: aload_0
    //   67: iconst_0
    //   68: invokevirtual 84	com/google/android/gms/ads/identifier/AdvertisingIdClient:b	(Z)V
    //   71: aload_0
    //   72: getfield 40	com/google/android/gms/ads/identifier/AdvertisingIdClient:lp	Z
    //   75: ifne +27 -> 102
    //   78: new 71	java/io/IOException
    //   81: dup
    //   82: ldc 176
    //   84: invokespecial 76	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   87: athrow
    //   88: astore 8
    //   90: new 71	java/io/IOException
    //   93: dup
    //   94: ldc 176
    //   96: aload 8
    //   98: invokespecial 179	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: athrow
    //   102: aload_0
    //   103: getfield 149	com/google/android/gms/ads/identifier/AdvertisingIdClient:ln	Lcom/google/android/gms/common/a;
    //   106: invokestatic 36	hZ:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_0
    //   111: getfield 153	com/google/android/gms/ads/identifier/AdvertisingIdClient:lo	Ljp;
    //   114: invokestatic 36	hZ:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: new 181	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   121: dup
    //   122: aload_0
    //   123: getfield 153	com/google/android/gms/ads/identifier/AdvertisingIdClient:lo	Ljp;
    //   126: invokeinterface 186 1 0
    //   131: aload_0
    //   132: getfield 153	com/google/android/gms/ads/identifier/AdvertisingIdClient:lo	Ljp;
    //   135: iconst_1
    //   136: invokeinterface 189 2 0
    //   141: invokespecial 192	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   144: astore 4
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_0
    //   149: invokespecial 155	com/google/android/gms/ads/identifier/AdvertisingIdClient:Z	()V
    //   152: aload 4
    //   154: areturn
    //   155: astore 5
    //   157: new 71	java/io/IOException
    //   160: dup
    //   161: ldc 194
    //   163: invokespecial 76	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	AdvertisingIdClient
    //   58	4	1	localObject1	Object
    //   144	9	4	localInfo	AdvertisingIdClient.Info
    //   155	1	5	localRemoteException	android.os.RemoteException
    //   18	46	6	localObject2	Object
    //   50	6	7	localObject3	Object
    //   88	9	8	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   23	55	50	finally
    //   63	66	50	finally
    //   7	23	58	finally
    //   55	61	58	finally
    //   66	71	58	finally
    //   71	118	58	finally
    //   118	146	58	finally
    //   146	148	58	finally
    //   157	167	58	finally
    //   66	71	88	java/lang/Exception
    //   118	146	155	android/os/RemoteException
  }
  
  public void start()
  {
    b(true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * JD-Core Version:    0.7.0.1
 */