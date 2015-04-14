package com.facebook;

import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class NativeAppCallAttachmentStore$2
  implements NativeAppCallAttachmentStore.ProcessAttachment<File>
{
  NativeAppCallAttachmentStore$2(NativeAppCallAttachmentStore paramNativeAppCallAttachmentStore) {}
  
  public void processAttachment(File paramFile1, File paramFile2)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(paramFile1);
      }
      finally
      {
        byte[] arrayOfByte;
        int i;
        FileInputStream localFileInputStream = null;
        continue;
      }
      try
      {
        arrayOfByte = new byte[1024];
        i = localFileInputStream.read(arrayOfByte);
        if (i > 0) {}
        return;
      }
      finally
      {
        Utility.closeQuietly(localFileOutputStream);
        Utility.closeQuietly(localFileInputStream);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.NativeAppCallAttachmentStore.2
 * JD-Core Version:    0.7.0.1
 */