package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jg;
import hE;
import hG;
import hZ;
import ic;
import ie;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
  implements GoogleApiClient
{
  private final Looper JF;
  private final Condition JR = this.zO.newCondition();
  private final hE JS;
  private final int JT;
  final Queue<c.d<?>> JU = new LinkedList();
  private ConnectionResult JV;
  private int JW;
  private volatile int JX = 4;
  private volatile boolean JY;
  private boolean JZ = false;
  private final c.b Jy = new c.1(this);
  private int Ka;
  private long Kb = 120000L;
  private long Kc = 5000L;
  final Handler Kd;
  BroadcastReceiver Ke;
  private final Bundle Kf = new Bundle();
  private final Map<Api.c<?>, Api.a> Kg = new HashMap();
  private final List<String> Kh;
  private boolean Ki;
  private final Set<d<?>> Kj = Collections.newSetFromMap(new WeakHashMap());
  final Set<c.d<?>> Kk = Collections.newSetFromMap(new ConcurrentHashMap());
  private final GoogleApiClient.ConnectionCallbacks Kl = new c.2(this);
  private final hG Km = new c.3(this);
  private final Context mContext;
  private final Lock zO = new ReentrantLock();
  
  public c(Context paramContext, Looper paramLooper, jg paramjg, Map<Api<?>, Api.ApiOptions> paramMap, Set<GoogleApiClient.ConnectionCallbacks> paramSet, Set<GoogleApiClient.OnConnectionFailedListener> paramSet1, int paramInt)
  {
    this.mContext = paramContext;
    this.JS = new hE(paramContext, paramLooper, this.Km);
    this.JF = paramLooper;
    this.Kd = new c.c(this, paramLooper);
    this.JT = paramInt;
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator1.next();
      this.JS.a(localConnectionCallbacks);
    }
    Iterator localIterator2 = paramSet1.iterator();
    while (localIterator2.hasNext())
    {
      GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)localIterator2.next();
      this.JS.a(localOnConnectionFailedListener);
    }
    Iterator localIterator3 = paramMap.keySet().iterator();
    while (localIterator3.hasNext())
    {
      Api localApi = (Api)localIterator3.next();
      Api.b localb = localApi.gx();
      Object localObject = paramMap.get(localApi);
      this.Kg.put(localApi.gz(), a(localb, localObject, paramContext, paramLooper, paramjg, this.Kl, new c.4(this, localb)));
    }
    this.Kh = Collections.unmodifiableList(paramjg.b());
  }
  
  private static <C extends Api.a, O> C a(Api.b<C, O> paramb, Object paramObject, Context paramContext, Looper paramLooper, jg paramjg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramb.a(paramContext, paramLooper, paramjg, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private void a(GoogleApiClient paramGoogleApiClient, f paramf, boolean paramBoolean)
  {
    ic.c.a(paramGoogleApiClient).setResultCallback(new c.7(this, paramf, paramBoolean, paramGoogleApiClient));
  }
  
  /* Error */
  private <A extends Api.a> void a(c.d<A> paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 261 1 0
    //   9: aload_1
    //   10: invokeinterface 264 1 0
    //   15: ifnull +65 -> 80
    //   18: iconst_1
    //   19: istore_3
    //   20: iload_3
    //   21: ldc_w 266
    //   24: invokestatic 271	hZ:b	(ZLjava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 117	com/google/android/gms/common/api/c:Kk	Ljava/util/Set;
    //   31: aload_1
    //   32: invokeinterface 275 2 0
    //   37: pop
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 124	com/google/android/gms/common/api/c:Jy	Lcom/google/android/gms/common/api/c$b;
    //   43: invokeinterface 278 2 0
    //   48: aload_0
    //   49: invokevirtual 281	com/google/android/gms/common/api/c:gL	()Z
    //   52: ifeq +33 -> 85
    //   55: aload_1
    //   56: new 283	com/google/android/gms/common/api/Status
    //   59: dup
    //   60: bipush 8
    //   62: invokespecial 286	com/google/android/gms/common/api/Status:<init>	(I)V
    //   65: invokeinterface 290 2 0
    //   70: aload_0
    //   71: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   74: invokeinterface 293 1 0
    //   79: return
    //   80: iconst_0
    //   81: istore_3
    //   82: goto -62 -> 20
    //   85: aload_1
    //   86: aload_0
    //   87: aload_1
    //   88: invokeinterface 264 1 0
    //   93: invokevirtual 296	com/google/android/gms/common/api/c:a	(Lcom/google/android/gms/common/api/Api$c;)Lcom/google/android/gms/common/api/Api$a;
    //   96: invokeinterface 299 2 0
    //   101: aload_0
    //   102: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   105: invokeinterface 293 1 0
    //   110: goto -31 -> 79
    //   113: astore_2
    //   114: aload_0
    //   115: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   118: invokeinterface 293 1 0
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	c
    //   0	125	1	paramd	c.d<A>
    //   113	11	2	localObject	Object
    //   19	63	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	70	113	finally
    //   85	101	113	finally
  }
  
  private void al(int paramInt)
  {
    this.zO.lock();
    try
    {
      if (this.JX == 3) {
        break label377;
      }
      if (paramInt != -1) {
        break label240;
      }
      if (isConnecting())
      {
        Iterator localIterator4 = this.JU.iterator();
        while (localIterator4.hasNext())
        {
          c.d locald = (c.d)localIterator4.next();
          if (locald.gF() != 1)
          {
            locald.cancel();
            localIterator4.remove();
          }
        }
      }
      this.JU.clear();
    }
    finally
    {
      this.zO.unlock();
    }
    Iterator localIterator2 = this.Kk.iterator();
    while (localIterator2.hasNext()) {
      ((c.d)localIterator2.next()).cancel();
    }
    this.Kk.clear();
    Iterator localIterator3 = this.Kj.iterator();
    while (localIterator3.hasNext()) {
      ((d)localIterator3.next()).clear();
    }
    this.Kj.clear();
    if ((this.JV == null) && (!this.JU.isEmpty()))
    {
      this.JZ = true;
      this.zO.unlock();
    }
    for (;;)
    {
      return;
      label240:
      boolean bool1 = isConnecting();
      boolean bool2 = isConnected();
      this.JX = 3;
      if (bool1)
      {
        if (paramInt == -1) {
          this.JV = null;
        }
        this.JR.signalAll();
      }
      this.Ki = false;
      Iterator localIterator1 = this.Kg.values().iterator();
      while (localIterator1.hasNext())
      {
        Api.a locala = (Api.a)localIterator1.next();
        if (locala.isConnected()) {
          locala.disconnect();
        }
      }
      this.Ki = true;
      this.JX = 4;
      if (bool2)
      {
        if (paramInt != -1) {
          this.JS.a(paramInt);
        }
        this.Ki = false;
      }
      label377:
      this.zO.unlock();
    }
  }
  
  private void gJ()
  {
    this.Ka = (-1 + this.Ka);
    if (this.Ka == 0)
    {
      if (this.JV == null) {
        break label80;
      }
      this.JZ = false;
      al(3);
      if ((!gL()) || (!GooglePlayServicesUtil.e(this.mContext, this.JV.getErrorCode())))
      {
        gM();
        this.JS.a(this.JV);
      }
      this.Ki = false;
    }
    for (;;)
    {
      return;
      label80:
      this.JX = 2;
      gM();
      this.JR.signalAll();
      gK();
      if (!this.JZ) {
        break;
      }
      this.JZ = false;
      al(-1);
    }
    if (this.Kf.isEmpty()) {}
    for (Bundle localBundle = null;; localBundle = this.Kf)
    {
      this.JS.a(localBundle);
      break;
    }
  }
  
  private void gK()
  {
    this.zO.lock();
    for (;;)
    {
      try
      {
        if (!isConnected())
        {
          if (gL())
          {
            break label98;
            hZ.a(bool1, "GoogleApiClient is not connected yet.");
            boolean bool2 = this.JU.isEmpty();
            if (!bool2)
            {
              try
              {
                a((c.d)this.JU.remove());
              }
              catch (DeadObjectException localDeadObjectException) {}
              continue;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          return;
        }
      }
      finally
      {
        this.zO.unlock();
      }
      label98:
      boolean bool1 = true;
    }
  }
  
  /* Error */
  private void gM()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 261 1 0
    //   9: aload_0
    //   10: getfield 309	com/google/android/gms/common/api/c:JY	Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +13 -> 28
    //   18: aload_0
    //   19: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   22: invokeinterface 293 1 0
    //   27: return
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 309	com/google/android/gms/common/api/c:JY	Z
    //   33: aload_0
    //   34: getfield 152	com/google/android/gms/common/api/c:Kd	Landroid/os/Handler;
    //   37: iconst_2
    //   38: invokevirtual 414	android/os/Handler:removeMessages	(I)V
    //   41: aload_0
    //   42: getfield 152	com/google/android/gms/common/api/c:Kd	Landroid/os/Handler;
    //   45: iconst_1
    //   46: invokevirtual 414	android/os/Handler:removeMessages	(I)V
    //   49: aload_0
    //   50: getfield 136	com/google/android/gms/common/api/c:mContext	Landroid/content/Context;
    //   53: aload_0
    //   54: getfield 416	com/google/android/gms/common/api/c:Ke	Landroid/content/BroadcastReceiver;
    //   57: invokevirtual 422	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   60: aload_0
    //   61: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 293 1 0
    //   69: goto -42 -> 27
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   77: invokeinterface 293 1 0
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	c
    //   72	11	1	localObject	Object
    //   13	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	14	72	finally
    //   28	60	72	finally
  }
  
  private void resume()
  {
    this.zO.lock();
    try
    {
      if (gL()) {
        connect();
      }
      return;
    }
    finally
    {
      this.zO.unlock();
    }
  }
  
  public <C extends Api.a> C a(Api.c<C> paramc)
  {
    Api.a locala = (Api.a)this.Kg.get(paramc);
    hZ.a(locala, "Appropriate Api was not requested.");
    return locala;
  }
  
  /* Error */
  public <A extends Api.a, R extends Result, T extends BaseImplementation.a<R, A>> T a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 261 1 0
    //   9: aload_0
    //   10: invokevirtual 338	com/google/android/gms/common/api/c:isConnected	()Z
    //   13: ifeq +20 -> 33
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 441	com/google/android/gms/common/api/c:b	(Lcom/google/android/gms/common/api/BaseImplementation$a;)Lcom/google/android/gms/common/api/BaseImplementation$a;
    //   21: pop
    //   22: aload_0
    //   23: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 293 1 0
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: getfield 79	com/google/android/gms/common/api/c:JU	Ljava/util/Queue;
    //   37: aload_1
    //   38: invokeinterface 442 2 0
    //   43: pop
    //   44: goto -22 -> 22
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 293 1 0
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	c
    //   0	59	1	paramT	T
    //   47	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	47	finally
    //   33	44	47	finally
  }
  
  public boolean a(Scope paramScope)
  {
    return this.Kh.contains(paramScope.gO());
  }
  
  public <A extends Api.a, T extends BaseImplementation.a<? extends Result, A>> T b(T paramT)
  {
    boolean bool;
    if ((isConnected()) || (gL())) {
      bool = true;
    }
    for (;;)
    {
      hZ.a(bool, "GoogleApiClient is not connected yet.");
      gK();
      try
      {
        a(paramT);
        return paramT;
        bool = false;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;)
        {
          al(1);
        }
      }
    }
  }
  
  /* Error */
  public ConnectionResult blockingConnect()
  {
    // Byte code:
    //   0: invokestatic 464	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 467	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +78 -> 84
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: ldc_w 469
    //   15: invokestatic 405	hZ:a	(ZLjava/lang/Object;)V
    //   18: aload_0
    //   19: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   22: invokeinterface 261 1 0
    //   27: aload_0
    //   28: invokevirtual 434	com/google/android/gms/common/api/c:connect	()V
    //   31: aload_0
    //   32: invokevirtual 312	com/google/android/gms/common/api/c:isConnecting	()Z
    //   35: istore_3
    //   36: iload_3
    //   37: ifeq +52 -> 89
    //   40: aload_0
    //   41: getfield 74	com/google/android/gms/common/api/c:JR	Ljava/util/concurrent/locks/Condition;
    //   44: invokeinterface 472 1 0
    //   49: goto -18 -> 31
    //   52: astore 5
    //   54: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   57: invokevirtual 481	java/lang/Thread:interrupt	()V
    //   60: new 378	com/google/android/gms/common/ConnectionResult
    //   63: dup
    //   64: bipush 15
    //   66: aconst_null
    //   67: invokespecial 484	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 293 1 0
    //   81: aload 4
    //   83: areturn
    //   84: iconst_0
    //   85: istore_1
    //   86: goto -75 -> 11
    //   89: aload_0
    //   90: invokevirtual 338	com/google/android/gms/common/api/c:isConnected	()Z
    //   93: ifeq +20 -> 113
    //   96: getstatic 487	com/google/android/gms/common/ConnectionResult:Iu	Lcom/google/android/gms/common/ConnectionResult;
    //   99: astore 4
    //   101: aload_0
    //   102: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   105: invokeinterface 293 1 0
    //   110: goto -29 -> 81
    //   113: aload_0
    //   114: getfield 228	com/google/android/gms/common/api/c:JV	Lcom/google/android/gms/common/ConnectionResult;
    //   117: ifnull +21 -> 138
    //   120: aload_0
    //   121: getfield 228	com/google/android/gms/common/api/c:JV	Lcom/google/android/gms/common/ConnectionResult;
    //   124: astore 4
    //   126: aload_0
    //   127: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   130: invokeinterface 293 1 0
    //   135: goto -54 -> 81
    //   138: new 378	com/google/android/gms/common/ConnectionResult
    //   141: dup
    //   142: bipush 13
    //   144: aconst_null
    //   145: invokespecial 484	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   154: invokeinterface 293 1 0
    //   159: goto -78 -> 81
    //   162: astore_2
    //   163: aload_0
    //   164: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   167: invokeinterface 293 1 0
    //   172: aload_2
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	c
    //   10	76	1	bool1	boolean
    //   162	11	2	localObject	Object
    //   35	2	3	bool2	boolean
    //   70	79	4	localConnectionResult	ConnectionResult
    //   52	1	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   40	49	52	java/lang/InterruptedException
    //   27	36	162	finally
    //   40	49	162	finally
    //   54	72	162	finally
    //   89	101	162	finally
    //   113	126	162	finally
    //   138	150	162	finally
  }
  
  /* Error */
  public ConnectionResult blockingConnect(long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: invokestatic 464	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 467	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +89 -> 95
    //   9: iconst_1
    //   10: istore 4
    //   12: iload 4
    //   14: ldc_w 469
    //   17: invokestatic 405	hZ:a	(ZLjava/lang/Object;)V
    //   20: aload_0
    //   21: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 261 1 0
    //   29: aload_0
    //   30: invokevirtual 434	com/google/android/gms/common/api/c:connect	()V
    //   33: aload_3
    //   34: lload_1
    //   35: invokevirtual 494	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   38: lstore 6
    //   40: aload_0
    //   41: invokevirtual 312	com/google/android/gms/common/api/c:isConnecting	()Z
    //   44: istore 8
    //   46: iload 8
    //   48: ifeq +85 -> 133
    //   51: aload_0
    //   52: getfield 74	com/google/android/gms/common/api/c:JR	Ljava/util/concurrent/locks/Condition;
    //   55: lload 6
    //   57: invokeinterface 497 3 0
    //   62: lstore 6
    //   64: lload 6
    //   66: lconst_0
    //   67: lcmp
    //   68: ifgt -28 -> 40
    //   71: new 378	com/google/android/gms/common/ConnectionResult
    //   74: dup
    //   75: bipush 14
    //   77: aconst_null
    //   78: invokespecial 484	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   81: astore 9
    //   83: aload_0
    //   84: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   87: invokeinterface 293 1 0
    //   92: aload 9
    //   94: areturn
    //   95: iconst_0
    //   96: istore 4
    //   98: goto -86 -> 12
    //   101: astore 10
    //   103: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   106: invokevirtual 481	java/lang/Thread:interrupt	()V
    //   109: new 378	com/google/android/gms/common/ConnectionResult
    //   112: dup
    //   113: bipush 15
    //   115: aconst_null
    //   116: invokespecial 484	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   119: astore 9
    //   121: aload_0
    //   122: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   125: invokeinterface 293 1 0
    //   130: goto -38 -> 92
    //   133: aload_0
    //   134: invokevirtual 338	com/google/android/gms/common/api/c:isConnected	()Z
    //   137: ifeq +20 -> 157
    //   140: getstatic 487	com/google/android/gms/common/ConnectionResult:Iu	Lcom/google/android/gms/common/ConnectionResult;
    //   143: astore 9
    //   145: aload_0
    //   146: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   149: invokeinterface 293 1 0
    //   154: goto -62 -> 92
    //   157: aload_0
    //   158: getfield 228	com/google/android/gms/common/api/c:JV	Lcom/google/android/gms/common/ConnectionResult;
    //   161: ifnull +21 -> 182
    //   164: aload_0
    //   165: getfield 228	com/google/android/gms/common/api/c:JV	Lcom/google/android/gms/common/ConnectionResult;
    //   168: astore 9
    //   170: aload_0
    //   171: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   174: invokeinterface 293 1 0
    //   179: goto -87 -> 92
    //   182: new 378	com/google/android/gms/common/ConnectionResult
    //   185: dup
    //   186: bipush 13
    //   188: aconst_null
    //   189: invokespecial 484	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   192: astore 9
    //   194: aload_0
    //   195: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   198: invokeinterface 293 1 0
    //   203: goto -111 -> 92
    //   206: astore 5
    //   208: aload_0
    //   209: getfield 66	com/google/android/gms/common/api/c:zO	Ljava/util/concurrent/locks/Lock;
    //   212: invokeinterface 293 1 0
    //   217: aload 5
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	c
    //   0	220	1	paramLong	long
    //   0	220	3	paramTimeUnit	java.util.concurrent.TimeUnit
    //   10	87	4	bool1	boolean
    //   206	12	5	localObject	Object
    //   38	27	6	l	long
    //   44	3	8	bool2	boolean
    //   81	112	9	localConnectionResult	ConnectionResult
    //   101	1	10	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   51	83	101	java/lang/InterruptedException
    //   29	46	206	finally
    //   51	83	206	finally
    //   103	121	206	finally
    //   133	145	206	finally
    //   157	170	206	finally
    //   182	194	206	finally
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    hZ.a(isConnected(), "GoogleApiClient is not connected yet.");
    f localf = new f(this.JF);
    if (this.Kg.containsKey(ic.a)) {
      a(this, localf, false);
    }
    for (;;)
    {
      return localf;
      AtomicReference localAtomicReference = new AtomicReference();
      c.5 local5 = new c.5(this, localAtomicReference, localf);
      c.6 local6 = new c.6(this, localf);
      GoogleApiClient localGoogleApiClient = new GoogleApiClient.Builder(this.mContext).addApi(ic.b).addConnectionCallbacks(local5).addOnConnectionFailedListener(local6).setHandler(this.Kd).build();
      localAtomicReference.set(localGoogleApiClient);
      localGoogleApiClient.connect();
    }
  }
  
  public void connect()
  {
    this.zO.lock();
    for (;;)
    {
      try
      {
        this.JZ = false;
        if (!isConnected())
        {
          boolean bool = isConnecting();
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.Ki = true;
        this.JV = null;
        this.JX = 1;
        this.Kf.clear();
        this.Ka = this.Kg.size();
        Iterator localIterator = this.Kg.values().iterator();
        if (localIterator.hasNext()) {
          ((Api.a)localIterator.next()).connect();
        }
      }
      finally
      {
        this.zO.unlock();
      }
    }
  }
  
  public <L> d<L> d(L paramL)
  {
    hZ.a(paramL, "Listener must not be null");
    this.zO.lock();
    try
    {
      d locald = new d(this.JF, paramL);
      this.Kj.add(locald);
      return locald;
    }
    finally
    {
      this.zO.unlock();
    }
  }
  
  public void disconnect()
  {
    gM();
    al(-1);
  }
  
  boolean gL()
  {
    return this.JY;
  }
  
  public Looper getLooper()
  {
    return this.JF;
  }
  
  public boolean isConnected()
  {
    if (this.JX == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isConnecting()
  {
    int i = 1;
    if (this.JX == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.JS.b(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.JS.b(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.JS.a(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.JS.a(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    if (this.JT >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.a(bool, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      g.a(paramFragmentActivity).ao(this.JT);
      return;
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.JS.c(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.JS.c(paramOnConnectionFailedListener);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c
 * JD-Core Version:    0.7.0.1
 */