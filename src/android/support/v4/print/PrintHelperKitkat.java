package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintManager;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  private final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramRectF.width() / paramInt1;
    if (paramInt3 == 2) {}
    for (float f2 = Math.max(f1, paramRectF.height() / paramInt2);; f2 = Math.min(f1, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f2, f2);
      localMatrix.postTranslate((paramRectF.width() - f2 * paramInt1) / 2.0F, (paramRectF.height() - f2 * paramInt2) / 2.0F);
      return localMatrix;
    }
  }
  
  /* Error */
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_0
    //   7: getfield 45	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   10: ifnonnull +13 -> 23
    //   13: new 93	java/lang/IllegalArgumentException
    //   16: dup
    //   17: ldc 95
    //   19: invokespecial 98	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: aload_0
    //   24: getfield 45	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   27: invokevirtual 104	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: aload_1
    //   31: invokevirtual 110	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   34: astore_3
    //   35: aload_3
    //   36: aconst_null
    //   37: aload_2
    //   38: invokestatic 116	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   41: astore 6
    //   43: aload_3
    //   44: ifnull +7 -> 51
    //   47: aload_3
    //   48: invokevirtual 121	java/io/InputStream:close	()V
    //   51: aload 6
    //   53: areturn
    //   54: astore 4
    //   56: aload_3
    //   57: ifnull +7 -> 64
    //   60: aload_3
    //   61: invokevirtual 121	java/io/InputStream:close	()V
    //   64: aload 4
    //   66: athrow
    //   67: astore 7
    //   69: goto -18 -> 51
    //   72: astore 5
    //   74: goto -10 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	PrintHelperKitkat
    //   0	77	1	paramUri	Uri
    //   0	77	2	paramOptions	BitmapFactory.Options
    //   1	60	3	localInputStream	java.io.InputStream
    //   54	11	4	localObject	Object
    //   72	1	5	localIOException1	java.io.IOException
    //   41	11	6	localBitmap	Bitmap
    //   67	1	7	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   23	43	54	finally
    //   47	51	67	java/io/IOException
    //   60	64	72	java/io/IOException
  }
  
  /* Error */
  private Bitmap loadConstrainedBitmap(Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: iload_2
    //   6: ifle +14 -> 20
    //   9: aload_1
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: getfield 45	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   17: ifnonnull +13 -> 30
    //   20: new 93	java/lang/IllegalArgumentException
    //   23: dup
    //   24: ldc 123
    //   26: invokespecial 98	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   29: athrow
    //   30: new 125	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 126	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 5
    //   39: aload 5
    //   41: iload_3
    //   42: putfield 130	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload_0
    //   46: aload_1
    //   47: aload 5
    //   49: invokespecial 132	android/support/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   52: pop
    //   53: aload 5
    //   55: getfield 135	android/graphics/BitmapFactory$Options:outWidth	I
    //   58: istore 7
    //   60: aload 5
    //   62: getfield 138	android/graphics/BitmapFactory$Options:outHeight	I
    //   65: istore 8
    //   67: iload 7
    //   69: ifle +8 -> 77
    //   72: iload 8
    //   74: ifgt +6 -> 80
    //   77: aload 4
    //   79: areturn
    //   80: iload 7
    //   82: iload 8
    //   84: invokestatic 141	java/lang/Math:max	(II)I
    //   87: istore 9
    //   89: iload 9
    //   91: iload_2
    //   92: if_icmple +16 -> 108
    //   95: iload 9
    //   97: iconst_1
    //   98: iushr
    //   99: istore 9
    //   101: iload_3
    //   102: iconst_1
    //   103: ishl
    //   104: istore_3
    //   105: goto -16 -> 89
    //   108: iload_3
    //   109: ifle -32 -> 77
    //   112: iload 7
    //   114: iload 8
    //   116: invokestatic 143	java/lang/Math:min	(II)I
    //   119: iload_3
    //   120: idiv
    //   121: ifle -44 -> 77
    //   124: aload_0
    //   125: getfield 37	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   128: astore 10
    //   130: aload 10
    //   132: monitorenter
    //   133: aload_0
    //   134: new 125	android/graphics/BitmapFactory$Options
    //   137: dup
    //   138: invokespecial 126	android/graphics/BitmapFactory$Options:<init>	()V
    //   141: putfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   144: aload_0
    //   145: getfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   148: iconst_1
    //   149: putfield 146	android/graphics/BitmapFactory$Options:inMutable	Z
    //   152: aload_0
    //   153: getfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   156: iload_3
    //   157: putfield 149	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   160: aload_0
    //   161: getfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   164: astore 12
    //   166: aload 10
    //   168: monitorexit
    //   169: aload_0
    //   170: aload_1
    //   171: aload 12
    //   173: invokespecial 132	android/support/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   176: astore 16
    //   178: aload 16
    //   180: astore 4
    //   182: aload_0
    //   183: getfield 37	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   186: astore 17
    //   188: aload 17
    //   190: monitorenter
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   196: aload 17
    //   198: monitorexit
    //   199: goto -122 -> 77
    //   202: astore 18
    //   204: aload 17
    //   206: monitorexit
    //   207: aload 18
    //   209: athrow
    //   210: astore 11
    //   212: aload 10
    //   214: monitorexit
    //   215: aload 11
    //   217: athrow
    //   218: astore 13
    //   220: aload_0
    //   221: getfield 37	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   224: astore 14
    //   226: aload 14
    //   228: monitorenter
    //   229: aload_0
    //   230: aconst_null
    //   231: putfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   234: aload 14
    //   236: monitorexit
    //   237: aload 13
    //   239: athrow
    //   240: astore 15
    //   242: aload 14
    //   244: monitorexit
    //   245: aload 15
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	PrintHelperKitkat
    //   0	248	1	paramUri	Uri
    //   0	248	2	paramInt	int
    //   1	156	3	i	int
    //   3	178	4	localObject1	Object
    //   37	24	5	localOptions1	BitmapFactory.Options
    //   58	55	7	j	int
    //   65	50	8	k	int
    //   87	13	9	m	int
    //   128	85	10	localObject2	Object
    //   210	6	11	localObject3	Object
    //   164	8	12	localOptions2	BitmapFactory.Options
    //   218	20	13	localObject4	Object
    //   224	19	14	localObject5	Object
    //   240	6	15	localObject6	Object
    //   176	3	16	localBitmap	Bitmap
    //   186	19	17	localObject7	Object
    //   202	6	18	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   191	207	202	finally
    //   133	169	210	finally
    //   212	215	210	finally
    //   169	178	218	finally
    //   229	237	240	finally
    //   242	245	240	finally
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelperKitkat.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      int i = this.mScaleMode;
      PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
      PrintAttributes.MediaSize localMediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
        localMediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      }
      PrintAttributes localPrintAttributes = new PrintAttributes.Builder().setMediaSize(localMediaSize).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintHelperKitkat.1(this, paramString, paramBitmap, i, paramOnPrintFinishCallback), localPrintAttributes);
    }
  }
  
  public void printBitmap(String paramString, Uri paramUri, PrintHelperKitkat.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    PrintHelperKitkat.2 local2 = new PrintHelperKitkat.2(this, paramString, paramUri, paramOnPrintFinishCallback, this.mScaleMode);
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if (this.mOrientation == 1) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      localPrintManager.print(paramString, local2, localBuilder.build());
      return;
      if (this.mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat
 * JD-Core Version:    0.7.0.1
 */