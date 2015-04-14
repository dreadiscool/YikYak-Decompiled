import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

class vr
{
  private final Context a;
  private final Boolean b;
  private final Boolean c;
  private final DisplayMetrics d;
  private final String e;
  private final Integer f;
  
  /* Error */
  public vr(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokespecial 28	java/lang/Object:<init>	()V
    //   6: aload_0
    //   7: aload_1
    //   8: putfield 30	vr:a	Landroid/content/Context;
    //   11: aload_0
    //   12: getfield 30	vr:a	Landroid/content/Context;
    //   15: invokevirtual 36	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: getfield 30	vr:a	Landroid/content/Context;
    //   24: invokevirtual 40	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: iconst_0
    //   28: invokevirtual 46	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   31: astore 21
    //   33: aload 21
    //   35: getfield 51	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   38: astore 6
    //   40: aload 21
    //   42: getfield 55	android/content/pm/PackageInfo:versionCode	I
    //   45: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: astore 23
    //   50: aload 23
    //   52: astore 7
    //   54: aload_0
    //   55: aload 6
    //   57: putfield 63	vr:e	Ljava/lang/String;
    //   60: aload_0
    //   61: aload 7
    //   63: putfield 65	vr:f	Ljava/lang/Integer;
    //   66: aload_3
    //   67: invokevirtual 69	java/lang/Object:getClass	()Ljava/lang/Class;
    //   70: astore 8
    //   72: iconst_1
    //   73: anewarray 71	java/lang/Class
    //   76: astore 19
    //   78: aload 19
    //   80: iconst_0
    //   81: ldc 73
    //   83: aastore
    //   84: aload 8
    //   86: ldc 75
    //   88: aload 19
    //   90: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   93: astore 20
    //   95: aload 20
    //   97: astore 10
    //   99: aload 10
    //   101: ifnull +161 -> 262
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: astore 14
    //   110: aload 14
    //   112: iconst_0
    //   113: ldc 81
    //   115: aastore
    //   116: aload 10
    //   118: aload_3
    //   119: aload 14
    //   121: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 89	java/lang/Boolean
    //   127: astore 11
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: astore 17
    //   135: aload 17
    //   137: iconst_0
    //   138: ldc 91
    //   140: aastore
    //   141: aload 10
    //   143: aload_3
    //   144: aload 17
    //   146: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 89	java/lang/Boolean
    //   152: astore 18
    //   154: aload 18
    //   156: astore_2
    //   157: aload_0
    //   158: aload 11
    //   160: putfield 93	vr:b	Ljava/lang/Boolean;
    //   163: aload_0
    //   164: aload_2
    //   165: putfield 95	vr:c	Ljava/lang/Boolean;
    //   168: aload_0
    //   169: new 97	android/util/DisplayMetrics
    //   172: dup
    //   173: invokespecial 98	android/util/DisplayMetrics:<init>	()V
    //   176: putfield 100	vr:d	Landroid/util/DisplayMetrics;
    //   179: aload_0
    //   180: getfield 30	vr:a	Landroid/content/Context;
    //   183: ldc 102
    //   185: invokevirtual 106	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   188: checkcast 108	android/view/WindowManager
    //   191: invokeinterface 112 1 0
    //   196: aload_0
    //   197: getfield 100	vr:d	Landroid/util/DisplayMetrics;
    //   200: invokevirtual 118	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   203: return
    //   204: astore 4
    //   206: aconst_null
    //   207: astore 5
    //   209: aload 5
    //   211: astore 6
    //   213: aconst_null
    //   214: astore 7
    //   216: goto -162 -> 54
    //   219: astore 9
    //   221: aconst_null
    //   222: astore 10
    //   224: goto -125 -> 99
    //   227: astore 13
    //   229: aconst_null
    //   230: astore 11
    //   232: goto -75 -> 157
    //   235: astore 16
    //   237: goto -80 -> 157
    //   240: astore 12
    //   242: aconst_null
    //   243: astore 11
    //   245: goto -88 -> 157
    //   248: astore 15
    //   250: goto -93 -> 157
    //   253: astore 22
    //   255: aload 6
    //   257: astore 5
    //   259: goto -50 -> 209
    //   262: aconst_null
    //   263: astore 11
    //   265: goto -108 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	vr
    //   0	268	1	paramContext	Context
    //   1	164	2	localObject1	Object
    //   18	126	3	localPackageManager	PackageManager
    //   204	1	4	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   207	51	5	localObject2	Object
    //   38	218	6	localObject3	Object
    //   52	163	7	localInteger1	Integer
    //   70	15	8	localClass	java.lang.Class
    //   219	1	9	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   97	126	10	localMethod1	java.lang.reflect.Method
    //   127	137	11	localBoolean1	Boolean
    //   240	1	12	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   227	1	13	localIllegalAccessException1	java.lang.IllegalAccessException
    //   108	12	14	arrayOfObject1	Object[]
    //   248	1	15	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   235	1	16	localIllegalAccessException2	java.lang.IllegalAccessException
    //   133	12	17	arrayOfObject2	Object[]
    //   152	3	18	localBoolean2	Boolean
    //   76	13	19	arrayOfClass	java.lang.Class[]
    //   93	3	20	localMethod2	java.lang.reflect.Method
    //   31	10	21	localPackageInfo	android.content.pm.PackageInfo
    //   253	1	22	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   48	3	23	localInteger2	Integer
    // Exception table:
    //   from	to	target	type
    //   19	40	204	android/content/pm/PackageManager$NameNotFoundException
    //   72	95	219	java/lang/NoSuchMethodException
    //   104	129	227	java/lang/IllegalAccessException
    //   129	154	235	java/lang/IllegalAccessException
    //   104	129	240	java/lang/reflect/InvocationTargetException
    //   129	154	248	java/lang/reflect/InvocationTargetException
    //   40	50	253	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public String a()
  {
    return this.e;
  }
  
  public boolean b()
  {
    return this.b.booleanValue();
  }
  
  public boolean c()
  {
    return this.c.booleanValue();
  }
  
  public DisplayMetrics d()
  {
    return this.d;
  }
  
  public String e()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    if (localTelephonyManager != null) {}
    for (String str = localTelephonyManager.getNetworkOperatorName();; str = null) {
      return str;
    }
  }
  
  public Boolean f()
  {
    Boolean localBoolean = null;
    if (this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
      localBoolean = Boolean.valueOf(((ConnectivityManager)this.a.getSystemService("connectivity")).getNetworkInfo(1).isConnected());
    }
    return localBoolean;
  }
  
  public Boolean g()
  {
    Object localObject = null;
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null)
      {
        Boolean localBoolean = Boolean.valueOf(localBluetoothAdapter.isEnabled());
        localObject = localBoolean;
      }
    }
    catch (SecurityException localSecurityException)
    {
      label22:
      break label22;
    }
    return localObject;
  }
  
  public String h()
  {
    String str = null;
    if (Build.VERSION.SDK_INT >= 8)
    {
      str = "none";
      if ((Build.VERSION.SDK_INT < 18) || (!this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {
        break label41;
      }
      str = "ble";
    }
    for (;;)
    {
      return str;
      label41:
      if (this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
        str = "classic";
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vr
 * JD-Core Version:    0.7.0.1
 */