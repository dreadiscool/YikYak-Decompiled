package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;

class ContentStreamBitmapHunter
  extends BitmapHunter
{
  final Context context;
  
  ContentStreamBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.context = paramContext;
  }
  
  Bitmap decode(Request paramRequest)
  {
    return decodeContentStream(paramRequest);
  }
  
  /* Error */
  protected Bitmap decodeContentStream(Request paramRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 13	com/squareup/picasso/ContentStreamBitmapHunter:context	Landroid/content/Context;
    //   6: invokevirtual 24	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore_3
    //   10: aload_1
    //   11: invokestatic 28	com/squareup/picasso/ContentStreamBitmapHunter:createBitmapOptions	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   14: astore 4
    //   16: aload 4
    //   18: invokestatic 32	com/squareup/picasso/ContentStreamBitmapHunter:requiresInSampleSize	(Landroid/graphics/BitmapFactory$Options;)Z
    //   21: ifeq +37 -> 58
    //   24: aload_3
    //   25: aload_1
    //   26: getfield 38	com/squareup/picasso/Request:uri	Landroid/net/Uri;
    //   29: invokevirtual 44	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: astore_2
    //   33: aload_2
    //   34: aconst_null
    //   35: aload 4
    //   37: invokestatic 50	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: pop
    //   41: aload_2
    //   42: invokestatic 56	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_1
    //   46: getfield 60	com/squareup/picasso/Request:targetWidth	I
    //   49: aload_1
    //   50: getfield 63	com/squareup/picasso/Request:targetHeight	I
    //   53: aload 4
    //   55: invokestatic 67	com/squareup/picasso/ContentStreamBitmapHunter:calculateInSampleSize	(IILandroid/graphics/BitmapFactory$Options;)V
    //   58: aload_3
    //   59: aload_1
    //   60: getfield 38	com/squareup/picasso/Request:uri	Landroid/net/Uri;
    //   63: invokevirtual 44	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   66: astore 5
    //   68: aload 5
    //   70: aconst_null
    //   71: aload 4
    //   73: invokestatic 50	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   76: astore 7
    //   78: aload 5
    //   80: invokestatic 56	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aload 7
    //   85: areturn
    //   86: astore 8
    //   88: aload_2
    //   89: invokestatic 56	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   92: aload 8
    //   94: athrow
    //   95: astore 6
    //   97: aload 5
    //   99: invokestatic 56	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   102: aload 6
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ContentStreamBitmapHunter
    //   0	105	1	paramRequest	Request
    //   1	88	2	localInputStream1	java.io.InputStream
    //   9	50	3	localContentResolver	android.content.ContentResolver
    //   14	58	4	localOptions	android.graphics.BitmapFactory.Options
    //   66	32	5	localInputStream2	java.io.InputStream
    //   95	8	6	localObject1	java.lang.Object
    //   76	8	7	localBitmap	Bitmap
    //   86	7	8	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	41	86	finally
    //   68	78	95	finally
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContentStreamBitmapHunter
 * JD-Core Version:    0.7.0.1
 */