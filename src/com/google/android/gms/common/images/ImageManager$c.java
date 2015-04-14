package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

final class ImageManager$c
  implements Runnable
{
  private final ParcelFileDescriptor LG;
  private final Uri mUri;
  
  public ImageManager$c(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mUri = paramUri;
    this.LG = paramParcelFileDescriptor;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 32
    //   2: invokestatic 38	hu:b	(Ljava/lang/String;)V
    //   5: iconst_0
    //   6: istore_1
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: getfield 23	com/google/android/gms/common/images/ImageManager$c:LG	Landroid/os/ParcelFileDescriptor;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 23	com/google/android/gms/common/images/ImageManager$c:LG	Landroid/os/ParcelFileDescriptor;
    //   20: invokevirtual 44	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   23: invokestatic 50	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
    //   26: astore 10
    //   28: aload 10
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 23	com/google/android/gms/common/images/ImageManager$c:LG	Landroid/os/ParcelFileDescriptor;
    //   35: invokevirtual 53	android/os/ParcelFileDescriptor:close	()V
    //   38: new 55	java/util/concurrent/CountDownLatch
    //   41: dup
    //   42: iconst_1
    //   43: invokespecial 58	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 16	com/google/android/gms/common/images/ImageManager$c:LF	Lcom/google/android/gms/common/images/ImageManager;
    //   51: invokestatic 64	com/google/android/gms/common/images/ImageManager:g	(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
    //   54: new 66	com/google/android/gms/common/images/ImageManager$f
    //   57: dup
    //   58: aload_0
    //   59: getfield 16	com/google/android/gms/common/images/ImageManager$c:LF	Lcom/google/android/gms/common/images/ImageManager;
    //   62: aload_0
    //   63: getfield 21	com/google/android/gms/common/images/ImageManager$c:mUri	Landroid/net/Uri;
    //   66: aload_2
    //   67: iload_1
    //   68: aload_3
    //   69: invokespecial 69	com/google/android/gms/common/images/ImageManager$f:<init>	(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
    //   72: invokevirtual 75	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   75: pop
    //   76: aload_3
    //   77: invokevirtual 78	java/util/concurrent/CountDownLatch:await	()V
    //   80: return
    //   81: astore 7
    //   83: new 80	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   90: ldc 83
    //   92: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 21	com/google/android/gms/common/images/ImageManager$c:mUri	Landroid/net/Uri;
    //   99: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: pop
    //   106: iconst_1
    //   107: istore_1
    //   108: goto -77 -> 31
    //   111: astore 5
    //   113: new 80	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   120: ldc 96
    //   122: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 21	com/google/android/gms/common/images/ImageManager$c:mUri	Landroid/net/Uri;
    //   129: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: pop
    //   136: goto -56 -> 80
    //   139: astore 9
    //   141: goto -103 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	c
    //   6	102	1	bool	boolean
    //   8	59	2	localObject	Object
    //   46	31	3	localCountDownLatch	java.util.concurrent.CountDownLatch
    //   111	1	5	localInterruptedException	java.lang.InterruptedException
    //   81	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   139	1	9	localIOException	java.io.IOException
    //   26	3	10	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   16	28	81	java/lang/OutOfMemoryError
    //   76	80	111	java/lang/InterruptedException
    //   31	38	139	java/io/IOException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.c
 * JD-Core Version:    0.7.0.1
 */