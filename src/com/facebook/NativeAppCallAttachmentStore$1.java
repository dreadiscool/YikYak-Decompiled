package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileOutputStream;

class NativeAppCallAttachmentStore$1
  implements NativeAppCallAttachmentStore.ProcessAttachment<Bitmap>
{
  NativeAppCallAttachmentStore$1(NativeAppCallAttachmentStore paramNativeAppCallAttachmentStore) {}
  
  public void processAttachment(Bitmap paramBitmap, File paramFile)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      return;
    }
    finally
    {
      Utility.closeQuietly(localFileOutputStream);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.NativeAppCallAttachmentStore.1
 * JD-Core Version:    0.7.0.1
 */