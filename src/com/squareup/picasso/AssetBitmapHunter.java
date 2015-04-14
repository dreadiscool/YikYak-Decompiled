package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;

class AssetBitmapHunter
  extends BitmapHunter
{
  protected static final String ANDROID_ASSET = "android_asset";
  private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
  private final AssetManager assetManager;
  
  public AssetBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.assetManager = paramContext.getAssets();
  }
  
  Bitmap decode(Request paramRequest)
  {
    return decodeAsset(paramRequest.uri.toString().substring(ASSET_PREFIX_LENGTH));
  }
  
  /* Error */
  Bitmap decodeAsset(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 63	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   6: invokestatic 67	com/squareup/picasso/AssetBitmapHunter:createBitmapOptions	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   9: astore_3
    //   10: aload_3
    //   11: invokestatic 71	com/squareup/picasso/AssetBitmapHunter:requiresInSampleSize	(Landroid/graphics/BitmapFactory$Options;)Z
    //   14: ifeq +41 -> 55
    //   17: aload_0
    //   18: getfield 37	com/squareup/picasso/AssetBitmapHunter:assetManager	Landroid/content/res/AssetManager;
    //   21: aload_1
    //   22: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_2
    //   26: aload_2
    //   27: aconst_null
    //   28: aload_3
    //   29: invokestatic 83	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload_2
    //   34: invokestatic 89	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   37: aload_0
    //   38: getfield 63	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   41: getfield 92	com/squareup/picasso/Request:targetWidth	I
    //   44: aload_0
    //   45: getfield 63	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   48: getfield 95	com/squareup/picasso/Request:targetHeight	I
    //   51: aload_3
    //   52: invokestatic 99	com/squareup/picasso/AssetBitmapHunter:calculateInSampleSize	(IILandroid/graphics/BitmapFactory$Options;)V
    //   55: aload_0
    //   56: getfield 37	com/squareup/picasso/AssetBitmapHunter:assetManager	Landroid/content/res/AssetManager;
    //   59: aload_1
    //   60: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   63: astore 4
    //   65: aload 4
    //   67: aconst_null
    //   68: aload_3
    //   69: invokestatic 83	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   72: astore 6
    //   74: aload 4
    //   76: invokestatic 89	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   79: aload 6
    //   81: areturn
    //   82: astore 7
    //   84: aload_2
    //   85: invokestatic 89	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   88: aload 7
    //   90: athrow
    //   91: astore 5
    //   93: aload 4
    //   95: invokestatic 89	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   98: aload 5
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	AssetBitmapHunter
    //   0	101	1	paramString	String
    //   1	84	2	localInputStream1	java.io.InputStream
    //   9	60	3	localOptions	android.graphics.BitmapFactory.Options
    //   63	31	4	localInputStream2	java.io.InputStream
    //   91	8	5	localObject1	java.lang.Object
    //   72	8	6	localBitmap	Bitmap
    //   82	7	7	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   17	33	82	finally
    //   65	74	91	finally
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.AssetBitmapHunter
 * JD-Core Version:    0.7.0.1
 */