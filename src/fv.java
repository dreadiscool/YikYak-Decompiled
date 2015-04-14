import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class fv
  implements gm
{
  private static Object a = new Object();
  private static fv b;
  private AdvertisingIdClient.Info c;
  private long d;
  private Context e;
  private String f;
  private boolean g = false;
  private Object h = new Object();
  
  fv(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }
  
  public static gm a(Context paramContext)
  {
    if (b == null) {}
    synchronized (a)
    {
      if (b == null) {
        b = new fv(paramContext);
      }
      return b;
    }
  }
  
  /* Error */
  private boolean a(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull +20 -> 23
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +18 -> 32
    //   17: iconst_1
    //   18: istore 11
    //   20: iload 11
    //   22: ireturn
    //   23: aload_2
    //   24: invokevirtual 59	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:getId	()Ljava/lang/String;
    //   27: astore 4
    //   29: goto -20 -> 9
    //   32: aload_0
    //   33: getfield 41	fv:e	Landroid/content/Context;
    //   36: invokestatic 63	ge:a	(Landroid/content/Context;)V
    //   39: invokestatic 66	ge:a	()Lge;
    //   42: astore 5
    //   44: aload 5
    //   46: ldc 68
    //   48: invokevirtual 71	ge:a	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 6
    //   53: aload_0
    //   54: getfield 33	fv:h	Ljava/lang/Object;
    //   57: astore 7
    //   59: aload 7
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 31	fv:g	Z
    //   66: ifne +69 -> 135
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 41	fv:e	Landroid/content/Context;
    //   74: invokestatic 74	fv:b	(Landroid/content/Context;)Ljava/lang/String;
    //   77: putfield 76	fv:f	Ljava/lang/String;
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 31	fv:g	Z
    //   85: new 78	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   92: aload 4
    //   94: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 6
    //   99: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 88	fv:b	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 9
    //   110: aload 9
    //   112: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifeq +107 -> 222
    //   118: iconst_0
    //   119: istore 11
    //   121: aload 7
    //   123: monitorexit
    //   124: goto -104 -> 20
    //   127: astore 8
    //   129: aload 7
    //   131: monitorexit
    //   132: aload 8
    //   134: athrow
    //   135: aload_0
    //   136: getfield 76	fv:f	Ljava/lang/String;
    //   139: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifeq -57 -> 85
    //   145: aload_1
    //   146: ifnonnull +39 -> 185
    //   149: aload_3
    //   150: ifnonnull +43 -> 193
    //   153: aload_0
    //   154: new 78	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   161: aload 4
    //   163: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 6
    //   168: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 91	fv:c	(Ljava/lang/String;)Z
    //   177: istore 11
    //   179: aload 7
    //   181: monitorexit
    //   182: goto -162 -> 20
    //   185: aload_1
    //   186: invokevirtual 59	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:getId	()Ljava/lang/String;
    //   189: astore_3
    //   190: goto -41 -> 149
    //   193: aload_0
    //   194: new 78	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   201: aload_3
    //   202: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 6
    //   207: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 88	fv:b	(Ljava/lang/String;)Ljava/lang/String;
    //   216: putfield 76	fv:f	Ljava/lang/String;
    //   219: goto -134 -> 85
    //   222: aload 9
    //   224: aload_0
    //   225: getfield 76	fv:f	Ljava/lang/String;
    //   228: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +12 -> 243
    //   234: aload 7
    //   236: monitorexit
    //   237: iconst_1
    //   238: istore 11
    //   240: goto -220 -> 20
    //   243: aload_0
    //   244: getfield 76	fv:f	Ljava/lang/String;
    //   247: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifne +70 -> 320
    //   253: ldc 99
    //   255: invokestatic 104	fA:c	(Ljava/lang/String;)V
    //   258: aload 5
    //   260: invokevirtual 106	ge:b	()Ljava/lang/String;
    //   263: astore 10
    //   265: new 78	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   272: ldc 108
    //   274: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 10
    //   279: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 104	fA:c	(Ljava/lang/String;)V
    //   288: aload_0
    //   289: new 78	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   296: aload 4
    //   298: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 10
    //   303: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokespecial 91	fv:c	(Ljava/lang/String;)Z
    //   312: istore 11
    //   314: aload 7
    //   316: monitorexit
    //   317: goto -297 -> 20
    //   320: aload 6
    //   322: astore 10
    //   324: goto -36 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	fv
    //   0	327	1	paramInfo1	AdvertisingIdClient.Info
    //   0	327	2	paramInfo2	AdvertisingIdClient.Info
    //   1	201	3	str1	String
    //   7	290	4	localObject1	Object
    //   42	217	5	localge	ge
    //   51	270	6	str2	String
    //   57	258	7	localObject2	Object
    //   127	6	8	localObject3	Object
    //   108	115	9	str3	String
    //   263	60	10	str4	String
    //   18	295	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   62	132	127	finally
    //   135	317	127	finally
  }
  
  /* Error */
  static String b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ldc 114
    //   5: invokevirtual 118	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   8: astore 5
    //   10: sipush 128
    //   13: newarray byte
    //   15: astore 6
    //   17: aload 5
    //   19: aload 6
    //   21: iconst_0
    //   22: sipush 128
    //   25: invokevirtual 124	java/io/FileInputStream:read	([BII)I
    //   28: istore 7
    //   30: aload 5
    //   32: invokevirtual 128	java/io/FileInputStream:available	()I
    //   35: ifle +23 -> 58
    //   38: ldc 130
    //   40: invokestatic 132	fA:d	(Ljava/lang/String;)V
    //   43: aload 5
    //   45: invokevirtual 135	java/io/FileInputStream:close	()V
    //   48: aload_0
    //   49: ldc 114
    //   51: invokevirtual 138	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   54: pop
    //   55: goto +75 -> 130
    //   58: iload 7
    //   60: ifgt +16 -> 76
    //   63: ldc 140
    //   65: invokestatic 142	fA:b	(Ljava/lang/String;)V
    //   68: aload 5
    //   70: invokevirtual 135	java/io/FileInputStream:close	()V
    //   73: goto +57 -> 130
    //   76: new 93	java/lang/String
    //   79: dup
    //   80: aload 6
    //   82: iconst_0
    //   83: iload 7
    //   85: invokespecial 145	java/lang/String:<init>	([BII)V
    //   88: astore 8
    //   90: aload 5
    //   92: invokevirtual 135	java/io/FileInputStream:close	()V
    //   95: aload 8
    //   97: astore_1
    //   98: goto +32 -> 130
    //   101: astore_2
    //   102: ldc 147
    //   104: invokestatic 132	fA:d	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: ldc 114
    //   110: invokevirtual 138	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   113: pop
    //   114: goto +16 -> 130
    //   117: astore 10
    //   119: aload 8
    //   121: astore_1
    //   122: goto -20 -> 102
    //   125: astore 9
    //   127: aload 8
    //   129: astore_1
    //   130: aload_1
    //   131: areturn
    //   132: astore 4
    //   134: goto -4 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramContext	Context
    //   1	130	1	localObject	Object
    //   101	1	2	localIOException1	IOException
    //   132	1	4	localFileNotFoundException1	FileNotFoundException
    //   8	83	5	localFileInputStream	java.io.FileInputStream
    //   15	66	6	arrayOfByte	byte[]
    //   28	56	7	i	int
    //   88	40	8	str	String
    //   125	1	9	localFileNotFoundException2	FileNotFoundException
    //   117	1	10	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   2	90	101	java/io/IOException
    //   90	95	117	java/io/IOException
    //   90	95	125	java/io/FileNotFoundException
    //   2	90	132	java/io/FileNotFoundException
  }
  
  static String b(String paramString)
  {
    MessageDigest localMessageDigest = fJ.c("MD5");
    if (localMessageDigest == null) {}
    Locale localLocale;
    Object[] arrayOfObject;
    for (String str = null;; str = String.format(localLocale, "%032X", arrayOfObject))
    {
      return str;
      localLocale = Locale.US;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest(paramString.getBytes()));
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool = false;
    try
    {
      String str = b(paramString);
      fA.c("Storing hashed adid.");
      FileOutputStream localFileOutputStream = this.e.openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.close();
      this.f = str;
      bool = true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        fA.a("Error creating hash file.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        fA.a("Error writing to hash file.");
      }
    }
    return bool;
  }
  
  AdvertisingIdClient.Info a()
  {
    Object localObject = null;
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.e);
      localObject = localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        fA.d("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;)
      {
        fA.d("GooglePlayServicesRepairableException getting Ad Id Info");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        fA.d("IOException getting Ad Id Info");
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        fA.d("GooglePlayServicesNotAvailableException getting Ad Id Info");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fA.d("Unknown exception. Could not get the ad Id.");
      }
    }
    return localObject;
  }
  
  public String a(String paramString)
  {
    long l = System.currentTimeMillis();
    String str;
    if (l - this.d > 1000L)
    {
      AdvertisingIdClient.Info localInfo = a();
      if (a(this.c, localInfo))
      {
        this.c = localInfo;
        this.d = l;
      }
    }
    else
    {
      if (this.c == null) {
        break label127;
      }
      if (!"&adid".equals(paramString)) {
        break label92;
      }
      str = this.c.getId();
    }
    for (;;)
    {
      return str;
      this.c = new AdvertisingIdClient.Info("", false);
      break;
      label92:
      if ("&ate".equals(paramString))
      {
        if (this.c.isLimitAdTrackingEnabled()) {
          str = "0";
        } else {
          str = "1";
        }
      }
      else {
        label127:
        str = null;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fv
 * JD-Core Version:    0.7.0.1
 */