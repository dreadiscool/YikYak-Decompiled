package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import eJ;
import eK;
import eO;
import eX;
import eg;
import eh;
import fc;
import fd;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker
{
  static final long MAX_TOKENS = 120000L;
  static final long NUM_TOKENS_PER_HIT = 2000L;
  private final eg mAppFieldsDefaultProvider;
  private final eh mClientIdDefaultProvider;
  private final fc mHandler;
  private long mLastTrackTime;
  private final String mName;
  private final Map<String, String> mParams = new HashMap();
  private final eX mScreenResolutionDefaultProvider;
  private long mTokens = 120000L;
  
  public Tracker(String paramString1, String paramString2, fc paramfc)
  {
    this(paramString1, paramString2, paramfc, eh.a(), eX.a(), eg.a());
  }
  
  @VisibleForTesting
  Tracker(String paramString1, String paramString2, fc paramfc, eh parameh, eX parameX, eg parameg)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Tracker name cannot be empty.");
    }
    this.mName = paramString1;
    this.mHandler = paramfc;
    this.mParams.put("&tid", paramString2);
    this.mParams.put("useSecure", "1");
    this.mClientIdDefaultProvider = parameh;
    this.mScreenResolutionDefaultProvider = parameX;
    this.mAppFieldsDefaultProvider = parameg;
  }
  
  public String get(String paramString)
  {
    String str = null;
    eJ.a().a(eK.j);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return str;
      if (this.mParams.containsKey(paramString)) {
        str = (String)this.mParams.get(paramString);
      } else if (paramString.equals("&ul")) {
        str = fd.a(Locale.getDefault());
      } else if ((this.mClientIdDefaultProvider != null) && (this.mClientIdDefaultProvider.a(paramString))) {
        str = this.mClientIdDefaultProvider.b(paramString);
      } else if ((this.mScreenResolutionDefaultProvider != null) && (this.mScreenResolutionDefaultProvider.a(paramString))) {
        str = this.mScreenResolutionDefaultProvider.b(paramString);
      } else if ((this.mAppFieldsDefaultProvider != null) && (this.mAppFieldsDefaultProvider.a(paramString))) {
        str = this.mAppFieldsDefaultProvider.b(paramString);
      }
    }
  }
  
  public String getName()
  {
    eJ.a().a(eK.ag);
    return this.mName;
  }
  
  public void send(Map<String, String> paramMap)
  {
    eJ.a().a(eK.l);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.mParams);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid")))
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = "&tid";
      eO.d(String.format("Missing tracking id (%s) parameter.", arrayOfObject2));
    }
    String str = (String)localHashMap.get("&t");
    if (TextUtils.isEmpty(str))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = "&t";
      eO.d(String.format("Missing hit type (%s) parameter.", arrayOfObject1));
      str = "";
    }
    if ((!str.equals("transaction")) && (!str.equals("item")) && (!tokensAvailable())) {
      eO.d("Too many hits sent too quickly, rate limiting invoked.");
    }
    for (;;)
    {
      return;
      this.mHandler.a(localHashMap);
    }
  }
  
  public void set(String paramString1, String paramString2)
  {
    eJ.a().a(eK.k);
    if (paramString2 == null) {
      this.mParams.remove(paramString1);
    }
    for (;;)
    {
      return;
      this.mParams.put(paramString1, paramString2);
    }
  }
  
  @VisibleForTesting
  void setLastTrackTime(long paramLong)
  {
    this.mLastTrackTime = paramLong;
  }
  
  @VisibleForTesting
  void setTokens(long paramLong)
  {
    this.mTokens = paramLong;
  }
  
  /* Error */
  @VisibleForTesting
  boolean tokensAvailable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   5: lstore_2
    //   6: aload_0
    //   7: getfield 58	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   10: ldc2_w 7
    //   13: lcmp
    //   14: ifge +35 -> 49
    //   17: lload_2
    //   18: aload_0
    //   19: getfield 202	com/google/analytics/tracking/android/Tracker:mLastTrackTime	J
    //   22: lsub
    //   23: lstore 5
    //   25: lload 5
    //   27: lconst_0
    //   28: lcmp
    //   29: ifle +20 -> 49
    //   32: aload_0
    //   33: ldc2_w 7
    //   36: lload 5
    //   38: aload_0
    //   39: getfield 58	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   42: ladd
    //   43: invokestatic 215	java/lang/Math:min	(JJ)J
    //   46: putfield 58	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   49: aload_0
    //   50: lload_2
    //   51: putfield 202	com/google/analytics/tracking/android/Tracker:mLastTrackTime	J
    //   54: aload_0
    //   55: getfield 58	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   58: ldc2_w 10
    //   61: lcmp
    //   62: iflt +23 -> 85
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 58	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   70: ldc2_w 10
    //   73: lsub
    //   74: putfield 58	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   77: iconst_1
    //   78: istore 4
    //   80: aload_0
    //   81: monitorexit
    //   82: iload 4
    //   84: ireturn
    //   85: ldc 217
    //   87: invokestatic 170	eO:d	(Ljava/lang/String;)V
    //   90: iconst_0
    //   91: istore 4
    //   93: goto -13 -> 80
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	Tracker
    //   96	4	1	localObject	Object
    //   5	46	2	l1	long
    //   78	14	4	bool	boolean
    //   23	14	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	77	96	finally
    //   85	90	96	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Tracker
 * JD-Core Version:    0.7.0.1
 */