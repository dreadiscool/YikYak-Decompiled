package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.locks.ReentrantLock;
import vt;

@TargetApi(16)
public class UpdateDisplayState
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new vt();
  private static final ReentrantLock d = new ReentrantLock();
  private static long e = -1L;
  private static UpdateDisplayState f = null;
  private static int g = 0;
  private static int h = -1;
  private final String a;
  private final String b;
  private final UpdateDisplayState.DisplayState c;
  
  private UpdateDisplayState(Bundle paramBundle)
  {
    this.a = paramBundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
    this.b = paramBundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
    this.c = ((UpdateDisplayState.DisplayState)paramBundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY"));
  }
  
  UpdateDisplayState(UpdateDisplayState.DisplayState paramDisplayState, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDisplayState;
  }
  
  public static int a(UpdateDisplayState.DisplayState paramDisplayState, String paramString1, String paramString2)
  {
    int i = -1;
    if (!d.isHeldByCurrentThread()) {
      throw new AssertionError();
    }
    if (!b())
    {
      e = System.currentTimeMillis();
      f = new UpdateDisplayState(paramDisplayState, paramString1, paramString2);
      g = 1 + g;
      i = g;
    }
    for (;;)
    {
      return i;
    }
  }
  
  public static ReentrantLock a()
  {
    return d;
  }
  
  public static void a(int paramInt)
  {
    d.lock();
    try
    {
      if (paramInt == h)
      {
        h = -1;
        f = null;
      }
      return;
    }
    finally
    {
      d.unlock();
    }
  }
  
  /* Error */
  public static UpdateDisplayState b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 40	com/mixpanel/android/mpmetrics/UpdateDisplayState:d	Ljava/util/concurrent/locks/ReentrantLock;
    //   5: invokevirtual 108	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   8: getstatic 50	com/mixpanel/android/mpmetrics/UpdateDisplayState:h	I
    //   11: ifle +22 -> 33
    //   14: getstatic 50	com/mixpanel/android/mpmetrics/UpdateDisplayState:h	I
    //   17: istore 4
    //   19: iload 4
    //   21: iload_0
    //   22: if_icmpeq +11 -> 33
    //   25: getstatic 40	com/mixpanel/android/mpmetrics/UpdateDisplayState:d	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   31: aload_1
    //   32: areturn
    //   33: getstatic 46	com/mixpanel/android/mpmetrics/UpdateDisplayState:f	Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnonnull +12 -> 50
    //   41: getstatic 40	com/mixpanel/android/mpmetrics/UpdateDisplayState:d	Ljava/util/concurrent/locks/ReentrantLock;
    //   44: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   47: goto -16 -> 31
    //   50: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   53: putstatic 44	com/mixpanel/android/mpmetrics/UpdateDisplayState:e	J
    //   56: iload_0
    //   57: putstatic 50	com/mixpanel/android/mpmetrics/UpdateDisplayState:h	I
    //   60: getstatic 46	com/mixpanel/android/mpmetrics/UpdateDisplayState:f	Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;
    //   63: astore_1
    //   64: getstatic 40	com/mixpanel/android/mpmetrics/UpdateDisplayState:d	Ljava/util/concurrent/locks/ReentrantLock;
    //   67: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   70: goto -39 -> 31
    //   73: astore_2
    //   74: getstatic 40	com/mixpanel/android/mpmetrics/UpdateDisplayState:d	Ljava/util/concurrent/locks/ReentrantLock;
    //   77: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramInt	int
    //   1	63	1	localUpdateDisplayState1	UpdateDisplayState
    //   73	8	2	localObject	Object
    //   36	2	3	localUpdateDisplayState2	UpdateDisplayState
    //   17	6	4	i	int
    // Exception table:
    //   from	to	target	type
    //   8	19	73	finally
    //   33	37	73	finally
    //   50	64	73	finally
  }
  
  public static boolean b()
  {
    if (!d.isHeldByCurrentThread()) {
      throw new AssertionError();
    }
    long l = System.currentTimeMillis() - e;
    if ((g > 0) && (l > 43200000L)) {
      f = null;
    }
    if (f != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public UpdateDisplayState.DisplayState c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.a);
    localBundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.b);
    localBundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.c);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.UpdateDisplayState
 * JD-Core Version:    0.7.0.1
 */