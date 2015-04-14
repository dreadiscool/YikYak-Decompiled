import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

class Dc
  extends AsyncTask<Void, Void, Void>
{
  private String a;
  private String b;
  private boolean c = false;
  private Db d = Db.a;
  
  private void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        a(arrayOfFile[j]);
      }
    }
    paramFile.delete();
  }
  
  private void a(String paramString)
  {
    try
    {
      for (File localFile : new File(paramString).listFiles()) {
        if ((localFile.isDirectory()) && (new File(paramString + "/" + localFile.getName() + ".ani").exists())) {
          a(localFile);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected Void a(Void... paramVarArgs)
  {
    boolean bool = CR.c();
    this.b = CZ.a("_id");
    if (bool)
    {
      this.a = CZ.a("android_content_url");
      this.d = Db.a;
    }
    for (;;)
    {
      CZ.b = new HashMap();
      CZ.a = new HashMap();
      System.gc();
      try
      {
        String str1 = Environment.getExternalStorageDirectory() + "/YikYak/Animations";
        str2 = str1 + "/" + this.b + ".ani";
        a(str1);
        if (!new File(str2).exists())
        {
          DataInputStream localDataInputStream = new DataInputStream(new URL(this.a).openStream());
          byte[] arrayOfByte1 = new byte[1024];
          new File(str1).mkdirs();
          localFile = new File(str1 + "/" + this.b + ".zip");
          localFileOutputStream = new FileOutputStream(localFile);
          for (;;)
          {
            int i = localDataInputStream.read(arrayOfByte1);
            if (i <= 0) {
              break;
            }
            localFileOutputStream.write(arrayOfByte1, 0, i);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        String str2;
        File localFile;
        FileOutputStream localFileOutputStream;
        CZ.b = new HashMap();
        CZ.a = new HashMap();
        System.gc();
        this.c = true;
        return null;
        this.a = CZ.a("content_url");
        this.d = Db.b;
        continue;
        localFileOutputStream.close();
        localFile.renameTo(new File(str2));
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
        if (bool) {
          localOptions.inSampleSize = 2;
        }
        ZipInputStream localZipInputStream = new ZipInputStream(new FileInputStream(str2));
        ZipEntry localZipEntry;
        do
        {
          localZipEntry = localZipInputStream.getNextEntry();
          if (localZipEntry == null) {
            break;
          }
          str3 = localZipEntry.getName();
          j = CZ.b(str3);
        } while ((localZipEntry.isDirectory()) || (str3.contains("__MACOSX")));
        localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte2 = new byte[1024];
        for (;;)
        {
          int k = localZipInputStream.read(arrayOfByte2);
          if (k == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte2, 0, k);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          BitmapFactory.Options localOptions;
          String str3;
          int j;
          ByteArrayOutputStream localByteArrayOutputStream;
          CZ.b = new HashMap();
          CZ.a = new HashMap();
          System.gc();
          this.c = true;
          continue;
          byte[] arrayOfByte3 = localByteArrayOutputStream.toByteArray();
          if (str3.contains("drawing")) {
            CZ.b.put(String.valueOf(j), BitmapFactory.decodeByteArray(arrayOfByte3, 0, arrayOfByte3.length, localOptions));
          }
          if (str3.contains("loading")) {
            CZ.a.put(String.valueOf(j), BitmapFactory.decodeByteArray(arrayOfByte3, 0, arrayOfByte3.length, localOptions));
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          CZ.b = new HashMap();
          CZ.a = new HashMap();
          System.gc();
          this.c = true;
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          CZ.b = new HashMap();
          CZ.a = new HashMap();
          System.gc();
          this.c = true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CZ.b = new HashMap();
          CZ.a = new HashMap();
          System.gc();
          this.c = true;
        }
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    boolean bool = CR.c();
    if (this.c) {
      CZ.a(false);
    }
    for (;;)
    {
      return;
      if ((bool) && (this.d == Db.a) && (CZ.c == null)) {
        CZ.a(false);
      } else if ((!bool) && (this.d == Db.b) && ((CZ.b.size() == 0) || (CZ.a.size() == 0))) {
        CZ.a(false);
      } else {
        CZ.a(true);
      }
    }
  }
  
  protected void onPreExecute() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dc
 * JD-Core Version:    0.7.0.1
 */