import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Jg
{
  public static final Comparator<File> a = new Jh();
  private static Boolean b = null;
  private static final char[] c;
  private static long d;
  private static Boolean e;
  
  static
  {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 49;
    arrayOfChar[2] = 50;
    arrayOfChar[3] = 51;
    arrayOfChar[4] = 52;
    arrayOfChar[5] = 53;
    arrayOfChar[6] = 54;
    arrayOfChar[7] = 55;
    arrayOfChar[8] = 56;
    arrayOfChar[9] = 57;
    arrayOfChar[10] = 97;
    arrayOfChar[11] = 98;
    arrayOfChar[12] = 99;
    arrayOfChar[13] = 100;
    arrayOfChar[14] = 101;
    arrayOfChar[15] = 102;
    c = arrayOfChar;
    d = -1L;
    e = null;
  }
  
  public static int a()
  {
    return Ji.a().ordinal();
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, j(paramContext));
  }
  
  public static int a(Context paramContext, boolean paramBoolean)
  {
    float f = c(paramContext);
    int i;
    if (!paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if ((paramBoolean) && (f >= 99.0D)) {
        i = 3;
      } else if ((paramBoolean) && (f < 99.0D)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  static long a(String paramString1, String paramString2, int paramInt)
  {
    return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt;
  }
  
  public static ActivityManager.RunningAppProcessInfo a(String paramString, Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      } while (!localRunningAppProcessInfo.processName.equals(paramString));
    }
    for (;;)
    {
      return localRunningAppProcessInfo;
      localRunningAppProcessInfo = null;
    }
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.crashlytics.prefs", 0);
  }
  
  public static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "?";
    }
    for (;;)
    {
      return str;
      str = "A";
      continue;
      str = "D";
      continue;
      str = "E";
      continue;
      str = "I";
      continue;
      str = "V";
      continue;
      str = "W";
    }
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 167	java/io/File:exists	()Z
    //   6: ifeq +75 -> 81
    //   9: new 169	java/io/BufferedReader
    //   12: dup
    //   13: new 171	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 174	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: sipush 1024
    //   24: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 8
    //   34: aload 8
    //   36: ifnull +39 -> 75
    //   39: ldc 182
    //   41: invokestatic 188	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   44: aload 8
    //   46: iconst_2
    //   47: invokevirtual 191	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   50: astore 9
    //   52: aload 9
    //   54: arraylength
    //   55: iconst_1
    //   56: if_icmple -28 -> 28
    //   59: aload 9
    //   61: iconst_0
    //   62: aaload
    //   63: aload_1
    //   64: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq -39 -> 28
    //   70: aload 9
    //   72: iconst_1
    //   73: aaload
    //   74: astore_2
    //   75: aload_3
    //   76: ldc 193
    //   78: invokestatic 196	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   81: aload_2
    //   82: areturn
    //   83: astore 11
    //   85: aconst_null
    //   86: astore_3
    //   87: invokestatic 202	IC:g	()LIO;
    //   90: pop
    //   91: new 204	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   98: ldc 207
    //   100: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: pop
    //   111: aload_3
    //   112: ldc 193
    //   114: invokestatic 196	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   117: goto -36 -> 81
    //   120: astore 10
    //   122: aconst_null
    //   123: astore_3
    //   124: aload 10
    //   126: astore 5
    //   128: aload_3
    //   129: ldc 193
    //   131: invokestatic 196	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   134: aload 5
    //   136: athrow
    //   137: astore 5
    //   139: goto -11 -> 128
    //   142: astore 4
    //   144: goto -57 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramFile	File
    //   0	147	1	paramString	String
    //   1	81	2	str1	String
    //   27	102	3	localBufferedReader	java.io.BufferedReader
    //   142	1	4	localException1	Exception
    //   126	9	5	localObject1	Object
    //   137	1	5	localObject2	Object
    //   32	13	8	str2	String
    //   50	21	9	arrayOfString	String[]
    //   120	5	10	localObject3	Object
    //   83	1	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	28	83	java/lang/Exception
    //   9	28	120	finally
    //   28	75	137	finally
    //   87	111	137	finally
    //   28	75	142	java/lang/Exception
  }
  
  public static String a(InputStream paramInputStream)
  {
    Scanner localScanner = new Scanner(paramInputStream).useDelimiter("\\A");
    if (localScanner.hasNext()) {}
    for (String str = localScanner.next();; str = "") {
      return str;
    }
  }
  
  private static String a(InputStream paramInputStream, String paramString)
  {
    MessageDigest localMessageDigest;
    Object localObject;
    try
    {
      localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      return localObject;
    }
    catch (Exception localException)
    {
      IC.g();
      localObject = "";
    }
    for (;;)
    {
      String str = a(localMessageDigest.digest());
      localObject = str;
    }
  }
  
  public static String a(String paramString)
  {
    return a(paramString, "SHA-1");
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return a(paramString1.getBytes(), paramString2);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = c[(j >>> 4)];
      arrayOfChar[(1 + i * 2)] = c[(j & 0xF)];
    }
    return new String(arrayOfChar);
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      localMessageDigest.update(paramArrayOfByte);
      str = a(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        IC.g();
        new StringBuilder().append("Could not create hashing algorithm: ").append(paramString).append(", returning empty string.").toString();
        String str = "";
      }
    }
    return str;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str1;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      str1 = null;
    }
    for (;;)
    {
      return str1;
      ArrayList localArrayList = new ArrayList();
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        String str3 = paramVarArgs[j];
        if (str3 != null) {
          localArrayList.add(str3.replace("-", "").toLowerCase(Locale.US));
        }
      }
      Collections.sort(localArrayList);
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next());
      }
      String str2 = localStringBuilder.toString();
      if (str2.length() > 0) {
        str1 = a(str2);
      } else {
        str1 = null;
      }
    }
  }
  
  @SuppressLint({"GetInstance"})
  public static Cipher a(int paramInt, String paramString)
  {
    if (paramString.length() < 32) {
      throw new InvalidKeyException("Key must be at least 32 bytes.");
    }
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), 0, 32, "AES/ECB/PKCS7Padding");
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
      localCipher.init(paramInt, localSecretKeySpec);
      return localCipher;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      IC.g();
      throw new RuntimeException(localGeneralSecurityException);
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (e(paramContext)) {
      IC.g().a(paramInt, "Fabric", paramString2);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (e(paramContext)) {
      IC.g();
    }
  }
  
  public static void a(Context paramContext, String paramString, Throwable paramThrowable)
  {
    if (e(paramContext)) {
      IC.g();
    }
  }
  
  public static void a(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  public static void a(Flushable paramFlushable, String paramString)
  {
    if (paramFlushable != null) {}
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      if (localResources != null)
      {
        int i = a(paramContext, paramString, "bool");
        if (i <= 0) {
          break label37;
        }
        paramBoolean = localResources.getBoolean(i);
      }
    }
    for (;;)
    {
      return paramBoolean;
      label37:
      int j = a(paramContext, paramString, "string");
      if (j > 0) {
        paramBoolean = Boolean.parseBoolean(paramContext.getString(j));
      }
    }
  }
  
  public static long b()
  {
    for (;;)
    {
      long l2;
      try
      {
        if (d == -1L)
        {
          l2 = 0L;
          String str1 = a(new File("/proc/meminfo"), "MemTotal");
          if (!TextUtils.isEmpty(str1)) {
            str2 = str1.toUpperCase(Locale.US);
          }
        }
        try
        {
          if (!str2.endsWith("KB")) {
            continue;
          }
          long l3 = a(str2, "KB", 1024);
          l2 = l3;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          long l1;
          IC.g();
          new StringBuilder().append("Unexpected meminfo format while computing RAM: ").append(str2).toString();
          continue;
        }
        d = l2;
        l1 = d;
        return l1;
      }
      finally {}
      if (str2.endsWith("MB"))
      {
        l2 = a(str2, "MB", 1048576);
      }
      else if (str2.endsWith("GB"))
      {
        l2 = a(str2, "GB", 1073741824);
      }
      else
      {
        IC.g();
        new StringBuilder().append("Unexpected meminfo format while computing RAM: ").append(str2).toString();
      }
    }
  }
  
  public static long b(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  public static long b(String paramString)
  {
    StatFs localStatFs = new StatFs(paramString);
    long l = localStatFs.getBlockSize();
    return l * localStatFs.getBlockCount() - l * localStatFs.getAvailableBlocks();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    int i = a(paramContext, paramString, "string");
    if (i > 0) {}
    for (String str = paramContext.getString(i);; str = "") {
      return str;
    }
  }
  
  public static String b(InputStream paramInputStream)
  {
    return a(paramInputStream, "SHA-1");
  }
  
  public static float c(Context paramContext)
  {
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    int i = localIntent.getIntExtra("level", -1);
    int j = localIntent.getIntExtra("scale", -1);
    return i / j;
  }
  
  public static boolean c()
  {
    if ((Debug.isDebuggerConnected()) || (Debug.waitingForDebugger())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool1 = false;
    if (f(paramContext)) {
      return bool1;
    }
    if (((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8) != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      break;
    }
  }
  
  public static boolean e(Context paramContext)
  {
    if (b == null) {
      b = Boolean.valueOf(a(paramContext, "com.crashlytics.Trace", false));
    }
    return b.booleanValue();
  }
  
  public static boolean f(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (("sdk".equals(Build.PRODUCT)) || ("google_sdk".equals(Build.PRODUCT)) || (str == null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean g(Context paramContext)
  {
    boolean bool1 = true;
    boolean bool2 = f(paramContext);
    String str = Build.TAGS;
    if ((!bool2) && (str != null) && (str.contains("test-keys"))) {}
    for (;;)
    {
      return bool1;
      if (!new File("/system/app/Superuser.apk").exists())
      {
        File localFile = new File("/system/xbin/su");
        if ((bool2) || (!localFile.exists())) {
          bool1 = false;
        }
      }
    }
  }
  
  public static int h(Context paramContext)
  {
    int i = 0;
    if (f(paramContext)) {
      i = 1;
    }
    if (g(paramContext)) {
      i |= 0x2;
    }
    if (c()) {
      i |= 0x4;
    }
    return i;
  }
  
  public static boolean i(Context paramContext)
  {
    if ((0x2 & paramContext.getApplicationInfo().flags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String j(Context paramContext)
  {
    int i = paramContext.getApplicationContext().getApplicationInfo().icon;
    if (i > 0) {}
    for (String str = paramContext.getResources().getResourcePackageName(i);; str = paramContext.getPackageName()) {
      return str;
    }
  }
  
  /* Error */
  public static String k(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: aload_0
    //   7: invokestatic 581	Jg:l	(Landroid/content/Context;)I
    //   10: invokevirtual 585	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore 8
    //   15: aload 8
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic 587	Jg:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 10
    //   26: invokestatic 589	Jg:c	(Ljava/lang/String;)Z
    //   29: istore 11
    //   31: iload 11
    //   33: ifeq +12 -> 45
    //   36: aload_3
    //   37: ldc_w 591
    //   40: invokestatic 196	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   43: aload_1
    //   44: areturn
    //   45: aload 10
    //   47: astore_1
    //   48: goto -12 -> 36
    //   51: astore 5
    //   53: aconst_null
    //   54: astore 6
    //   56: invokestatic 202	IC:g	()LIO;
    //   59: pop
    //   60: aload 6
    //   62: ldc_w 591
    //   65: invokestatic 196	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   68: goto -25 -> 43
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_3
    //   74: aload_2
    //   75: astore 4
    //   77: aload_3
    //   78: ldc_w 591
    //   81: invokestatic 196	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   84: aload 4
    //   86: athrow
    //   87: astore 4
    //   89: goto -12 -> 77
    //   92: astore 4
    //   94: aload 6
    //   96: astore_3
    //   97: goto -20 -> 77
    //   100: astore 9
    //   102: aload_3
    //   103: astore 6
    //   105: goto -49 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramContext	Context
    //   1	47	1	localObject1	Object
    //   71	4	2	localObject2	Object
    //   17	86	3	localObject3	Object
    //   75	10	4	localObject4	Object
    //   87	1	4	localObject5	Object
    //   92	1	4	localObject6	Object
    //   51	1	5	localException1	Exception
    //   54	50	6	localObject7	Object
    //   13	3	8	localInputStream	InputStream
    //   100	1	9	localException2	Exception
    //   22	24	10	str	String
    //   29	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	51	java/lang/Exception
    //   2	15	71	finally
    //   18	31	87	finally
    //   56	60	92	finally
    //   18	31	100	java/lang/Exception
  }
  
  public static int l(Context paramContext)
  {
    return paramContext.getApplicationContext().getApplicationInfo().icon;
  }
  
  public static String m(Context paramContext)
  {
    String str = null;
    int i = a(paramContext, "io.fabric.android.build_id", "string");
    if (i == 0) {
      i = a(paramContext, "com.crashlytics.android.build_id", "string");
    }
    if (i != 0)
    {
      str = paramContext.getResources().getString(i);
      IC.g();
      new StringBuilder().append("Build ID is: ").append(str).toString();
    }
    return str;
  }
  
  public static boolean n(Context paramContext)
  {
    boolean bool;
    if (c(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting())) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jg
 * JD-Core Version:    0.7.0.1
 */