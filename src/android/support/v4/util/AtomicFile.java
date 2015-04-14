package android.support.v4.util;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File mBackupName;
  private final File mBaseName;
  
  public AtomicFile(File paramFile)
  {
    this.mBaseName = paramFile;
    this.mBackupName = new File(paramFile.getPath() + ".bak");
  }
  
  static boolean sync(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.getFD().sync();
      bool = true;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public void delete()
  {
    this.mBaseName.delete();
    this.mBackupName.delete();
  }
  
  public void failWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
      label33:
      return;
    }
    catch (IOException localIOException)
    {
      break label33;
    }
  }
  
  public void finishWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBackupName.delete();
      label21:
      return;
    }
    catch (IOException localIOException)
    {
      break label21;
    }
  }
  
  public File getBaseFile()
  {
    return this.mBaseName;
  }
  
  public FileInputStream openRead()
  {
    if (this.mBackupName.exists())
    {
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
    }
    return new FileInputStream(this.mBaseName);
  }
  
  public byte[] readFully()
  {
    int i = 0;
    FileInputStream localFileInputStream = openRead();
    for (;;)
    {
      try
      {
        Object localObject2 = new byte[localFileInputStream.available()];
        int j = localFileInputStream.read((byte[])localObject2, i, localObject2.length - i);
        if (j <= 0) {
          return localObject2;
        }
        int k = j + i;
        int m = localFileInputStream.available();
        Object localObject3;
        if (m > localObject2.length - k)
        {
          localObject3 = new byte[m + k];
          System.arraycopy(localObject2, 0, localObject3, 0, k);
          localObject2 = localObject3;
          i = k;
        }
        else
        {
          localObject3 = localObject2;
        }
      }
      finally
      {
        localFileInputStream.close();
      }
    }
  }
  
  public FileOutputStream startWrite()
  {
    if (this.mBaseName.exists())
    {
      if (this.mBackupName.exists()) {
        break label83;
      }
      if (!this.mBaseName.renameTo(this.mBackupName)) {
        new StringBuilder().append("Couldn't rename file ").append(this.mBaseName).append(" to backup file ").append(this.mBackupName).toString();
      }
    }
    try
    {
      for (;;)
      {
        localFileOutputStream = new FileOutputStream(this.mBaseName);
        return localFileOutputStream;
        label83:
        this.mBaseName.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        FileOutputStream localFileOutputStream;
        if (!this.mBaseName.getParentFile().mkdir()) {
          throw new IOException("Couldn't create directory " + this.mBaseName);
        }
        try
        {
          localFileOutputStream = new FileOutputStream(this.mBaseName);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          throw new IOException("Couldn't create " + this.mBaseName);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.AtomicFile
 * JD-Core Version:    0.7.0.1
 */