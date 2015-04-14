package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import com.facebook.FacebookException;
import java.lang.reflect.Method;

public class AttributionIdentifiers
{
  private static final String ANDROID_ID_COLUMN_NAME = "androidid";
  private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  private static final int CONNECTION_RESULT_SUCCESS = 0;
  private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
  private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
  private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
  private static AttributionIdentifiers recentlyFetchedIdentifiers;
  private String androidAdvertiserId;
  private String attributionId;
  private long fetchTime;
  private boolean limitTracking;
  
  private static AttributionIdentifiers getAndroidId(Context paramContext)
  {
    AttributionIdentifiers localAttributionIdentifiers1 = new AttributionIdentifiers();
    try
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label38;
      }
      throw new FacebookException("getAndroidId cannot be called on the main thread.");
    }
    catch (Exception localException)
    {
      Utility.logd("android_id", localException);
    }
    AttributionIdentifiers localAttributionIdentifiers2 = localAttributionIdentifiers1;
    for (;;)
    {
      return localAttributionIdentifiers2;
      label38:
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Context.class;
      Method localMethod1 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", arrayOfClass1);
      if (localMethod1 == null)
      {
        localAttributionIdentifiers2 = localAttributionIdentifiers1;
      }
      else
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = paramContext;
        Object localObject1 = Utility.invokeMethodQuietly(null, localMethod1, arrayOfObject1);
        if (((localObject1 instanceof Integer)) && (((Integer)localObject1).intValue() == 0))
        {
          Class[] arrayOfClass2 = new Class[1];
          arrayOfClass2[0] = Context.class;
          Method localMethod2 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", arrayOfClass2);
          if (localMethod2 == null)
          {
            localAttributionIdentifiers2 = localAttributionIdentifiers1;
            continue;
          }
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramContext;
          Object localObject2 = Utility.invokeMethodQuietly(null, localMethod2, arrayOfObject2);
          if (localObject2 == null)
          {
            localAttributionIdentifiers2 = localAttributionIdentifiers1;
            continue;
          }
          Method localMethod3 = Utility.getMethodQuietly(localObject2.getClass(), "getId", new Class[0]);
          Method localMethod4 = Utility.getMethodQuietly(localObject2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
          if ((localMethod3 == null) || (localMethod4 == null)) {
            break label270;
          }
          localAttributionIdentifiers1.androidAdvertiserId = ((String)Utility.invokeMethodQuietly(localObject2, localMethod3, new Object[0]));
          localAttributionIdentifiers1.limitTracking = ((Boolean)Utility.invokeMethodQuietly(localObject2, localMethod4, new Object[0])).booleanValue();
          break;
        }
        localAttributionIdentifiers2 = localAttributionIdentifiers1;
        continue;
        label270:
        localAttributionIdentifiers2 = localAttributionIdentifiers1;
      }
    }
  }
  
  /* Error */
  public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 133	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   3: ifnull +28 -> 31
    //   6: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   9: getstatic 133	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   12: getfield 141	com/facebook/internal/AttributionIdentifiers:fetchTime	J
    //   15: lsub
    //   16: ldc2_w 19
    //   19: lcmp
    //   20: ifge +11 -> 31
    //   23: getstatic 133	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   26: astore 6
    //   28: aload 6
    //   30: areturn
    //   31: aload_0
    //   32: invokestatic 143	com/facebook/internal/AttributionIdentifiers:getAndroidId	(Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
    //   35: astore_1
    //   36: iconst_3
    //   37: anewarray 120	java/lang/String
    //   40: astore 7
    //   42: aload 7
    //   44: iconst_0
    //   45: ldc 11
    //   47: aastore
    //   48: aload 7
    //   50: iconst_1
    //   51: ldc 8
    //   53: aastore
    //   54: aload 7
    //   56: iconst_2
    //   57: ldc 23
    //   59: aastore
    //   60: aload_0
    //   61: invokevirtual 147	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   64: getstatic 51	com/facebook/internal/AttributionIdentifiers:ATTRIBUTION_ID_CONTENT_URI	Landroid/net/Uri;
    //   67: aload 7
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 8
    //   77: aload 8
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +16 -> 97
    //   84: aload_3
    //   85: invokeinterface 158 1 0
    //   90: istore 9
    //   92: iload 9
    //   94: ifne +19 -> 113
    //   97: aload_3
    //   98: ifnull +9 -> 107
    //   101: aload_3
    //   102: invokeinterface 161 1 0
    //   107: aload_1
    //   108: astore 6
    //   110: goto -82 -> 28
    //   113: aload_3
    //   114: ldc 11
    //   116: invokeinterface 165 2 0
    //   121: istore 10
    //   123: aload_3
    //   124: ldc 8
    //   126: invokeinterface 165 2 0
    //   131: istore 11
    //   133: aload_3
    //   134: ldc 23
    //   136: invokeinterface 165 2 0
    //   141: istore 12
    //   143: aload_1
    //   144: aload_3
    //   145: iload 10
    //   147: invokeinterface 169 2 0
    //   152: putfield 171	com/facebook/internal/AttributionIdentifiers:attributionId	Ljava/lang/String;
    //   155: iload 11
    //   157: ifle +42 -> 199
    //   160: iload 12
    //   162: ifle +37 -> 199
    //   165: aload_1
    //   166: invokevirtual 174	com/facebook/internal/AttributionIdentifiers:getAndroidAdvertiserId	()Ljava/lang/String;
    //   169: ifnonnull +30 -> 199
    //   172: aload_1
    //   173: aload_3
    //   174: iload 11
    //   176: invokeinterface 169 2 0
    //   181: putfield 122	com/facebook/internal/AttributionIdentifiers:androidAdvertiserId	Ljava/lang/String;
    //   184: aload_1
    //   185: aload_3
    //   186: iload 12
    //   188: invokeinterface 169 2 0
    //   193: invokestatic 178	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   196: putfield 130	com/facebook/internal/AttributionIdentifiers:limitTracking	Z
    //   199: aload_3
    //   200: ifnull +9 -> 209
    //   203: aload_3
    //   204: invokeinterface 161 1 0
    //   209: aload_1
    //   210: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   213: putfield 141	com/facebook/internal/AttributionIdentifiers:fetchTime	J
    //   216: aload_1
    //   217: putstatic 133	com/facebook/internal/AttributionIdentifiers:recentlyFetchedIdentifiers	Lcom/facebook/internal/AttributionIdentifiers;
    //   220: aload_1
    //   221: astore 6
    //   223: goto -195 -> 28
    //   226: astore 4
    //   228: aconst_null
    //   229: astore_3
    //   230: new 180	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   237: ldc 183
    //   239: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 4
    //   244: invokevirtual 190	java/lang/Exception:toString	()Ljava/lang/String;
    //   247: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: pop
    //   254: aload_3
    //   255: ifnull +9 -> 264
    //   258: aload_3
    //   259: invokeinterface 161 1 0
    //   264: aconst_null
    //   265: astore 6
    //   267: goto -239 -> 28
    //   270: astore_2
    //   271: aconst_null
    //   272: astore_3
    //   273: aload_3
    //   274: ifnull +9 -> 283
    //   277: aload_3
    //   278: invokeinterface 161 1 0
    //   283: aload_2
    //   284: athrow
    //   285: astore_2
    //   286: goto -13 -> 273
    //   289: astore 4
    //   291: goto -61 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramContext	Context
    //   35	186	1	localAttributionIdentifiers	AttributionIdentifiers
    //   270	14	2	localObject1	Object
    //   285	1	2	localObject2	Object
    //   79	199	3	localCursor1	android.database.Cursor
    //   226	17	4	localException1	Exception
    //   289	1	4	localException2	Exception
    //   26	240	6	localObject3	Object
    //   40	28	7	arrayOfString	String[]
    //   75	3	8	localCursor2	android.database.Cursor
    //   90	3	9	bool	boolean
    //   121	25	10	i	int
    //   131	44	11	j	int
    //   141	46	12	k	int
    // Exception table:
    //   from	to	target	type
    //   36	77	226	java/lang/Exception
    //   36	77	270	finally
    //   84	92	285	finally
    //   113	199	285	finally
    //   230	254	285	finally
    //   84	92	289	java/lang/Exception
    //   113	199	289	java/lang/Exception
  }
  
  public String getAndroidAdvertiserId()
  {
    return this.androidAdvertiserId;
  }
  
  public String getAttributionId()
  {
    return this.attributionId;
  }
  
  public boolean isTrackingLimited()
  {
    return this.limitTracking;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers
 * JD-Core Version:    0.7.0.1
 */