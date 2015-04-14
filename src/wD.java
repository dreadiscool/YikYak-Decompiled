import android.graphics.Bitmap;
import android.graphics.Paint;

class wD
{
  private Bitmap a = null;
  private final Paint b = new Paint(2);
  
  /* Error */
  public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   6: ifnull +29 -> 35
    //   9: aload_0
    //   10: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   13: invokevirtual 30	android/graphics/Bitmap:getWidth	()I
    //   16: iload_1
    //   17: if_icmpne +18 -> 35
    //   20: aload_0
    //   21: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   24: invokevirtual 33	android/graphics/Bitmap:getHeight	()I
    //   27: istore 7
    //   29: iload 7
    //   31: iload_2
    //   32: if_icmpeq +30 -> 62
    //   35: aload_0
    //   36: iload_1
    //   37: iload_2
    //   38: getstatic 39	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   41: invokestatic 43	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   44: putfield 21	wD:a	Landroid/graphics/Bitmap;
    //   47: aload_0
    //   48: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   51: ifnull +11 -> 62
    //   54: aload_0
    //   55: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   58: iload_3
    //   59: invokevirtual 46	android/graphics/Bitmap:setDensity	(I)V
    //   62: aload_0
    //   63: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   66: ifnull +25 -> 91
    //   69: new 48	android/graphics/Canvas
    //   72: dup
    //   73: aload_0
    //   74: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   77: invokespecial 51	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   80: aload 4
    //   82: fconst_0
    //   83: fconst_0
    //   84: aload_0
    //   85: getfield 19	wD:b	Landroid/graphics/Paint;
    //   88: invokevirtual 55	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore 6
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 21	wD:a	Landroid/graphics/Bitmap;
    //   101: goto -54 -> 47
    //   104: astore 5
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 5
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	wD
    //   0	111	1	paramInt1	int
    //   0	111	2	paramInt2	int
    //   0	111	3	paramInt3	int
    //   0	111	4	paramBitmap	Bitmap
    //   104	5	5	localObject	Object
    //   94	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   27	6	7	i	int
    // Exception table:
    //   from	to	target	type
    //   35	47	94	java/lang/OutOfMemoryError
    //   2	29	104	finally
    //   35	47	104	finally
    //   47	91	104	finally
    //   96	101	104	finally
  }
  
  /* Error */
  public void a(android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   6: ifnull +23 -> 29
    //   9: aload_0
    //   10: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   13: invokevirtual 30	android/graphics/Bitmap:getWidth	()I
    //   16: ifeq +13 -> 29
    //   19: aload_0
    //   20: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   23: invokevirtual 33	android/graphics/Bitmap:getHeight	()I
    //   26: ifne +15 -> 41
    //   29: aload_3
    //   30: ldc 58
    //   32: invokevirtual 64	java/lang/String:getBytes	()[B
    //   35: invokevirtual 70	java/io/OutputStream:write	([B)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_3
    //   42: bipush 34
    //   44: invokevirtual 72	java/io/OutputStream:write	(I)V
    //   47: new 74	android/util/Base64OutputStream
    //   50: dup
    //   51: aload_3
    //   52: iconst_2
    //   53: invokespecial 77	android/util/Base64OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   56: astore 5
    //   58: aload_0
    //   59: getfield 21	wD:a	Landroid/graphics/Bitmap;
    //   62: getstatic 83	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   65: bipush 100
    //   67: aload 5
    //   69: invokevirtual 87	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   72: pop
    //   73: aload 5
    //   75: invokevirtual 90	android/util/Base64OutputStream:flush	()V
    //   78: aload_3
    //   79: bipush 34
    //   81: invokevirtual 72	java/io/OutputStream:write	(I)V
    //   84: goto -46 -> 38
    //   87: astore 4
    //   89: aload_0
    //   90: monitorexit
    //   91: aload 4
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	wD
    //   0	94	1	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	94	2	paramInt	int
    //   0	94	3	paramOutputStream	java.io.OutputStream
    //   87	5	4	localObject	Object
    //   56	18	5	localBase64OutputStream	android.util.Base64OutputStream
    // Exception table:
    //   from	to	target	type
    //   2	38	87	finally
    //   41	84	87	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wD
 * JD-Core Version:    0.7.0.1
 */