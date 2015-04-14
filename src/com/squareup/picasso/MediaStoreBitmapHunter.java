package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;

class MediaStoreBitmapHunter
  extends ContentStreamBitmapHunter
{
  private static final String[] CONTENT_ORIENTATION;
  
  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "orientation";
    CONTENT_ORIENTATION = arrayOfString;
  }
  
  MediaStoreBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
  }
  
  /* Error */
  static int getExifOrientation(ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getstatic 14	com/squareup/picasso/MediaStoreBitmapHunter:CONTENT_ORIENTATION	[Ljava/lang/String;
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: invokevirtual 28	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   11: astore 7
    //   13: aload 7
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +16 -> 33
    //   20: aload_3
    //   21: invokeinterface 34 1 0
    //   26: istore 9
    //   28: iload 9
    //   30: ifne +19 -> 49
    //   33: aload_3
    //   34: ifnull +9 -> 43
    //   37: aload_3
    //   38: invokeinterface 37 1 0
    //   43: iconst_0
    //   44: istore 6
    //   46: iload 6
    //   48: ireturn
    //   49: aload_3
    //   50: iconst_0
    //   51: invokeinterface 41 2 0
    //   56: istore 10
    //   58: iload 10
    //   60: istore 6
    //   62: aload_3
    //   63: ifnull -17 -> 46
    //   66: aload_3
    //   67: invokeinterface 37 1 0
    //   72: goto -26 -> 46
    //   75: astore 4
    //   77: aconst_null
    //   78: astore 5
    //   80: aload 5
    //   82: ifnull +10 -> 92
    //   85: aload 5
    //   87: invokeinterface 37 1 0
    //   92: iconst_0
    //   93: istore 6
    //   95: goto -49 -> 46
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +9 -> 111
    //   105: aload_3
    //   106: invokeinterface 37 1 0
    //   111: aload_2
    //   112: athrow
    //   113: astore_2
    //   114: goto -13 -> 101
    //   117: astore 8
    //   119: aload_3
    //   120: astore 5
    //   122: goto -42 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramContentResolver	ContentResolver
    //   0	125	1	paramUri	android.net.Uri
    //   98	14	2	localObject1	java.lang.Object
    //   113	1	2	localObject2	java.lang.Object
    //   15	105	3	localCursor1	android.database.Cursor
    //   75	1	4	localRuntimeException1	java.lang.RuntimeException
    //   78	43	5	localCursor2	android.database.Cursor
    //   44	50	6	i	int
    //   11	3	7	localCursor3	android.database.Cursor
    //   117	1	8	localRuntimeException2	java.lang.RuntimeException
    //   26	3	9	bool	boolean
    //   56	3	10	j	int
    // Exception table:
    //   from	to	target	type
    //   0	13	75	java/lang/RuntimeException
    //   0	13	98	finally
    //   20	28	113	finally
    //   49	58	113	finally
    //   20	28	117	java/lang/RuntimeException
    //   49	58	117	java/lang/RuntimeException
  }
  
  static MediaStoreBitmapHunter.PicassoKind getPicassoKind(int paramInt1, int paramInt2)
  {
    MediaStoreBitmapHunter.PicassoKind localPicassoKind;
    if ((paramInt1 <= MediaStoreBitmapHunter.PicassoKind.MICRO.width) && (paramInt2 <= MediaStoreBitmapHunter.PicassoKind.MICRO.height)) {
      localPicassoKind = MediaStoreBitmapHunter.PicassoKind.MICRO;
    }
    for (;;)
    {
      return localPicassoKind;
      if ((paramInt1 <= MediaStoreBitmapHunter.PicassoKind.MINI.width) && (paramInt2 <= MediaStoreBitmapHunter.PicassoKind.MINI.height)) {
        localPicassoKind = MediaStoreBitmapHunter.PicassoKind.MINI;
      } else {
        localPicassoKind = MediaStoreBitmapHunter.PicassoKind.FULL;
      }
    }
  }
  
  Bitmap decode(Request paramRequest)
  {
    int i = 1;
    ContentResolver localContentResolver = this.context.getContentResolver();
    setExifRotation(getExifOrientation(localContentResolver, paramRequest.uri));
    String str = localContentResolver.getType(paramRequest.uri);
    int j;
    MediaStoreBitmapHunter.PicassoKind localPicassoKind;
    Bitmap localBitmap;
    if ((str != null) && (str.startsWith("video/")))
    {
      j = i;
      if (!paramRequest.hasSize()) {
        break label172;
      }
      localPicassoKind = getPicassoKind(paramRequest.targetWidth, paramRequest.targetHeight);
      if ((j != 0) || (localPicassoKind != MediaStoreBitmapHunter.PicassoKind.FULL)) {
        break label99;
      }
      localBitmap = super.decode(paramRequest);
    }
    label156:
    label172:
    label207:
    for (;;)
    {
      return localBitmap;
      j = 0;
      break;
      label99:
      long l = ContentUris.parseId(paramRequest.uri);
      BitmapFactory.Options localOptions = createBitmapOptions(paramRequest);
      localOptions.inJustDecodeBounds = i;
      calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, localPicassoKind.width, localPicassoKind.height, localOptions);
      if (j != 0) {
        if (localPicassoKind != MediaStoreBitmapHunter.PicassoKind.FULL) {}
      }
      for (localBitmap = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, l, i, localOptions);; localBitmap = MediaStore.Images.Thumbnails.getThumbnail(localContentResolver, l, localPicassoKind.androidKind, localOptions))
      {
        if (localBitmap != null) {
          break label207;
        }
        localBitmap = super.decode(paramRequest);
        break;
        i = localPicassoKind.androidKind;
        break label156;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MediaStoreBitmapHunter
 * JD-Core Version:    0.7.0.1
 */