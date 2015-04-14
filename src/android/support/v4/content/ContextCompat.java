package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;

public class ContextCompat
{
  private static final String DIR_ANDROID = "Android";
  private static final String DIR_CACHE = "cache";
  private static final String DIR_DATA = "data";
  private static final String DIR_FILES = "files";
  private static final String DIR_OBB = "obb";
  private static final String TAG = "ContextCompat";
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    Object localObject1 = paramFile;
    String str;
    Object localObject2;
    if (j < i)
    {
      str = paramVarArgs[j];
      if (localObject1 == null) {
        localObject2 = new File(str);
      }
    }
    for (;;)
    {
      j++;
      localObject1 = localObject2;
      break;
      if (str != null)
      {
        localObject2 = new File((File)localObject1, str);
        continue;
        return localObject1;
      }
      else
      {
        localObject2 = localObject1;
      }
    }
  }
  
  /* Error */
  private static File createFilesDir(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 43	java/io/File:exists	()Z
    //   7: ifne +19 -> 26
    //   10: aload_0
    //   11: invokevirtual 46	java/io/File:mkdirs	()Z
    //   14: ifne +12 -> 26
    //   17: aload_0
    //   18: invokevirtual 43	java/io/File:exists	()Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq +8 -> 31
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: new 48	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   38: ldc 51
    //   40: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 59	java/io/File:getPath	()Ljava/lang/String;
    //   47: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: pop
    //   54: aconst_null
    //   55: astore_0
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramFile	File
    //   59	5	1	localObject	Object
    //   21	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	59	finally
    //   31	54	59	finally
  }
  
  public static final Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Drawable localDrawable = ContextCompatApi21.getDrawable(paramContext, paramInt);; localDrawable = paramContext.getResources().getDrawable(paramInt)) {
      return localDrawable;
    }
  }
  
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i >= 19)
    {
      localObject = ContextCompatKitKat.getExternalCacheDirs(paramContext);
      return localObject;
    }
    if (i >= 8) {}
    File localFile1;
    String[] arrayOfString;
    for (File localFile2 = ContextCompatFroyo.getExternalCacheDir(paramContext);; localFile2 = buildPath(localFile1, arrayOfString))
    {
      File[] arrayOfFile = new File[1];
      arrayOfFile[0] = localFile2;
      localObject = arrayOfFile;
      break;
      localFile1 = Environment.getExternalStorageDirectory();
      arrayOfString = new String[4];
      arrayOfString[0] = "Android";
      arrayOfString[1] = "data";
      arrayOfString[2] = paramContext.getPackageName();
      arrayOfString[3] = "cache";
    }
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i >= 19)
    {
      localObject = ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);
      return localObject;
    }
    if (i >= 8) {}
    File localFile1;
    String[] arrayOfString;
    for (File localFile2 = ContextCompatFroyo.getExternalFilesDir(paramContext, paramString);; localFile2 = buildPath(localFile1, arrayOfString))
    {
      File[] arrayOfFile = new File[1];
      arrayOfFile[0] = localFile2;
      localObject = arrayOfFile;
      break;
      localFile1 = Environment.getExternalStorageDirectory();
      arrayOfString = new String[5];
      arrayOfString[0] = "Android";
      arrayOfString[1] = "data";
      arrayOfString[2] = paramContext.getPackageName();
      arrayOfString[3] = "files";
      arrayOfString[4] = paramString;
    }
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i >= 19)
    {
      localObject = ContextCompatKitKat.getObbDirs(paramContext);
      return localObject;
    }
    if (i >= 11) {}
    File localFile1;
    String[] arrayOfString;
    for (File localFile2 = ContextCompatHoneycomb.getObbDir(paramContext);; localFile2 = buildPath(localFile1, arrayOfString))
    {
      File[] arrayOfFile = new File[1];
      arrayOfFile[0] = localFile2;
      localObject = arrayOfFile;
      break;
      localFile1 = Environment.getExternalStorageDirectory();
      arrayOfString = new String[3];
      arrayOfString[0] = "Android";
      arrayOfString[1] = "obb";
      arrayOfString[2] = paramContext.getPackageName();
    }
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    boolean bool = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 16) {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
    }
    for (;;)
    {
      return bool;
      if (i >= 11) {
        ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      } else {
        bool = false;
      }
    }
  }
  
  public final File getCodeCacheDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (File localFile = ContextCompatApi21.getCodeCacheDir(paramContext);; localFile = createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "code_cache"))) {
      return localFile;
    }
  }
  
  public final File getNoBackupFilesDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (File localFile = ContextCompatApi21.getNoBackupFilesDir(paramContext);; localFile = createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "no_backup"))) {
      return localFile;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompat
 * JD-Core Version:    0.7.0.1
 */