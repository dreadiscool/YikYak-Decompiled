import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.DisplayMetrics;
import com.yik.yak.YikYak;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ik
{
  protected static final char[] a = "0123456789ABCDEF".toCharArray();
  static Bitmap b;
  
  public static int a(int paramInt)
  {
    return (int)(paramInt * Resources.getSystem().getDisplayMetrics().density);
  }
  
  public static File a(byte[] paramArrayOfByte)
  {
    b = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    File localFile1 = new File(Environment.getExternalStorageDirectory(), "YikYak");
    if ((!localFile1.exists()) && (!localFile1.mkdirs())) {}
    String str;
    for (File localFile2 = null;; localFile2 = new File(localFile1.getPath() + File.separator + "IMG_" + str + ".png"))
    {
      return localFile2;
      str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
  }
  
  public static String a()
  {
    try
    {
      File localFile = new File(Environment.getExternalStorageDirectory(), "YikYak");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      String str2 = localFile.getAbsolutePath();
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = null;
      }
    }
    return str1;
  }
  
  // public static String a(double)
  public static String locationDoubleToString(double paramDouble)
  {
    String str3;
    if (paramDouble == 0.0D) {
      str3 = String.valueOf(paramDouble);
    }
    for (;;)
    {
      return str3;
      String str1 = String.valueOf(paramDouble);
      String[] arrayOfString = str1.split("\\.");
      if (arrayOfString.length == 1)
      {
        str3 = String.valueOf(paramDouble);
      }
      else
      {
        if (arrayOfString[1].length() < 5) {
          str1 = str1 + arrayOfString[1] + "000131".substring(arrayOfString[1].length());
        }
        int i = 0;
        int j = 0;
        while (i < -1 + str1.length())
        {
          char c = str1.charAt(i);
          if (Character.isDigit(c)) {
            j += Integer.parseInt(String.valueOf(c));
          }
          i++;
        }
        String str2 = String.valueOf(j);
        str3 = str1.substring(0, -1 + str1.length()) + str2.substring(-1 + str2.length(), str2.length());
      }
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramContext.getFilesDir(), paramString));
      str = a(localFileInputStream);
      localFileInputStream.close();
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        new StringBuilder().append("File not found. ").append(paramContext.getFilesDir()).append("/").append(paramString).toString();
        str = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new StringBuilder().append(localException.getMessage()).append("").toString();
        String str = null;
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str).append("\n");
    }
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Hashtable localHashtable = b(paramInt);
    for (String str = "";; str = localStringBuilder.toString() + "Y")
    {
      return str;
      for (int i = 0; i < localHashtable.size(); i++) {
        if (localHashtable.get("yak" + paramString + i) != null) {
          localStringBuilder.append((String)localHashtable.get("yak" + paramString + i));
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (a(paramString2)) {}
    Date localDate1;
    String str2;
    for (TimeZone localTimeZone = TimeZone.getTimeZone("GMT-4:00");; localTimeZone = TimeZone.getTimeZone(paramString2))
    {
      Calendar localCalendar1 = Calendar.getInstance(localTimeZone);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Calendar localCalendar2 = Calendar.getInstance(localTimeZone);
      localDate1 = new Date();
      localSimpleDateFormat.setTimeZone(localTimeZone);
      try
      {
        Date localDate3 = localSimpleDateFormat.parse(paramString1);
        localDate2 = localDate3;
      }
      catch (ParseException localParseException)
      {
        double d;
        for (;;)
        {
          long l1;
          long l2;
          StringBuilder localStringBuilder5;
          localParseException.printStackTrace();
          Date localDate2 = localDate1;
          continue;
          String str6 = " secs";
        }
        if (d >= 3600.0D) {
          break label270;
        }
        int m = (int)Math.round(d / 60.0D);
        StringBuilder localStringBuilder4 = new StringBuilder().append(m);
        if (m != 1) {
          break label262;
        }
        for (String str5 = " mins";; str5 = " mins")
        {
          str2 = str5;
          break;
        }
        if (d >= 86400.0D) {
          break label343;
        }
        int k = (int)(Math.round(d) / 60L / 60L);
        StringBuilder localStringBuilder3 = new StringBuilder().append(k);
        if (k != 1) {
          break label335;
        }
        for (String str4 = " hour";; str4 = " hours")
        {
          str2 = str4;
          break;
        }
        if (d >= 604800.0D) {
          break label420;
        }
        int j = (int)Math.round(d / 60.0D / 60.0D / 24.0D);
        StringBuilder localStringBuilder2 = new StringBuilder().append(j);
        if (j != 1) {
          break label412;
        }
        for (String str3 = " day";; str3 = " days")
        {
          str2 = str3;
          break;
        }
        int i = (int)Math.round(d / 60.0D / 60.0D / 24.0D / 7.0D);
        localStringBuilder1 = new StringBuilder().append(i);
        if (i != 1) {
          break label484;
        }
      }
      localCalendar2.setTime(localDate2);
      l1 = (localCalendar2.getTimeInMillis() / 1000.0D);
      d = (localCalendar1.getTimeInMillis() / 1000.0D) - l1;
      if (d < 0.0D) {
        d = 0.0D;
      }
      if (d >= 60.0D) {
        break label201;
      }
      l2 = 3L + Math.round(d / 1.0D);
      localStringBuilder5 = new StringBuilder().append(l2);
      if (l2 != 1L) {
        break;
      }
      str6 = " sec";
      str2 = str6;
      return str2;
    }
    label201:
    label335:
    label343:
    StringBuilder localStringBuilder1;
    label262:
    label270:
    label412:
    label420:
    label484:
    for (String str1 = " week";; str1 = " weeks")
    {
      str2 = str1;
      break;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString2, 0);
      localFileOutputStream.write(paramString1.getBytes());
      localFileOutputStream.close();
      bool = true;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = a[(j >>> 4)];
      arrayOfChar[(1 + i * 2)] = a[(j & 0xF)];
    }
    return new String(arrayOfChar);
  }
  
  private static Hashtable<String, String> b(int paramInt)
  {
    Context localContext = YikYak.getContext();
    Hashtable localHashtable1 = new Hashtable();
    switch (paramInt)
    {
    }
    for (;;)
    {
      label198:
      for (Hashtable localHashtable2 = localHashtable1;; localHashtable2 = localHashtable1)
      {
        return localHashtable2;
        BT.class.getDeclaredFields();
        break;
        BS.class.getDeclaredFields();
        break;
        Field[] arrayOfField = BR.class.getDeclaredFields();
        if (arrayOfField != null) {
          for (int i = 0;; i++)
          {
            if (i >= arrayOfField.length) {
              break label198;
            }
            Object localObject = "";
            try
            {
              String str = localContext.getResources().getString(arrayOfField[i].getInt(arrayOfField[i]));
              localObject = str;
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              for (;;)
              {
                localNotFoundException.printStackTrace();
              }
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              for (;;)
              {
                localIllegalAccessException.printStackTrace();
              }
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              for (;;)
              {
                localIllegalArgumentException.printStackTrace();
              }
            }
            if (arrayOfField[i].getName().startsWith("yak")) {
              localHashtable1.put(arrayOfField[i].getName(), d(((String)localObject).substring(3)));
            }
          }
        }
      }
      BQ.class.getDeclaredFields();
    }
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      Iterator localIterator = CR.e().iterator();
      boolean bool2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        bool2 = ((Pattern)localIterator.next()).matcher(paramString).find();
      } while (!bool2);
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = false;
      }
    }
    return bool1;
  }
  
  public static String c(String paramString)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      localMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
      String str = b(localMessageDigest.digest());
      localObject = str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return localObject;
  }
  
  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < -1 + paramString.length(); i += 2) {
      localStringBuilder.append((char)Integer.parseInt(paramString.substring(i, i + 2), 16));
    }
    return localStringBuilder.toString();
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Ik

 * JD-Core Version:    0.7.0.1

 */