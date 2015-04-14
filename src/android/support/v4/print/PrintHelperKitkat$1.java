package android.support.v4.print;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;

class PrintHelperKitkat$1
  extends PrintDocumentAdapter
{
  private PrintAttributes mAttributes;
  
  PrintHelperKitkat$1(PrintHelperKitkat paramPrintHelperKitkat, String paramString, Bitmap paramBitmap, int paramInt, PrintHelperKitkat.OnPrintFinishCallback paramOnPrintFinishCallback) {}
  
  public void onFinish()
  {
    if (this.val$callback != null) {
      this.val$callback.onFinish();
    }
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    int i = 1;
    this.mAttributes = paramPrintAttributes2;
    PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(this.val$jobName).setContentType(i).setPageCount(i).build();
    if (!paramPrintAttributes2.equals(paramPrintAttributes1)) {}
    for (;;)
    {
      paramLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
      return;
      int j = 0;
    }
  }
  
  /* Error */
  public void onWrite(android.print.PageRange[] paramArrayOfPageRange, android.os.ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    // Byte code:
    //   0: new 74	android/print/pdf/PrintedPdfDocument
    //   3: dup
    //   4: aload_0
    //   5: getfield 20	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
    //   8: getfield 80	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   11: aload_0
    //   12: getfield 40	android/support/v4/print/PrintHelperKitkat$1:mAttributes	Landroid/print/PrintAttributes;
    //   15: invokespecial 83	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   18: astore 5
    //   20: aload 5
    //   22: iconst_1
    //   23: invokevirtual 87	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   26: astore 8
    //   28: new 89	android/graphics/RectF
    //   31: dup
    //   32: aload 8
    //   34: invokevirtual 95	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   37: invokevirtual 101	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   40: invokespecial 104	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   43: astore 9
    //   45: aload_0
    //   46: getfield 20	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
    //   49: aload_0
    //   50: getfield 24	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
    //   53: invokevirtual 110	android/graphics/Bitmap:getWidth	()I
    //   56: aload_0
    //   57: getfield 24	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
    //   60: invokevirtual 113	android/graphics/Bitmap:getHeight	()I
    //   63: aload 9
    //   65: aload_0
    //   66: getfield 26	android/support/v4/print/PrintHelperKitkat$1:val$fittingMode	I
    //   69: invokestatic 117	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    //   72: astore 10
    //   74: aload 8
    //   76: invokevirtual 121	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   79: aload_0
    //   80: getfield 24	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
    //   83: aload 10
    //   85: aconst_null
    //   86: invokevirtual 127	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   89: aload 5
    //   91: aload 8
    //   93: invokevirtual 131	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   96: aload 5
    //   98: new 133	java/io/FileOutputStream
    //   101: dup
    //   102: aload_2
    //   103: invokevirtual 139	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   106: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   109: invokevirtual 146	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   112: iconst_1
    //   113: anewarray 148	android/print/PageRange
    //   116: astore 13
    //   118: aload 13
    //   120: iconst_0
    //   121: getstatic 152	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
    //   124: aastore
    //   125: aload 4
    //   127: aload 13
    //   129: invokevirtual 158	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 161	android/print/pdf/PrintedPdfDocument:close	()V
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 162	android/os/ParcelFileDescriptor:close	()V
    //   150: return
    //   151: astore 11
    //   153: aload 4
    //   155: aconst_null
    //   156: invokevirtual 166	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
    //   159: goto -27 -> 132
    //   162: astore 6
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 161	android/print/pdf/PrintedPdfDocument:close	()V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 162	android/os/ParcelFileDescriptor:close	()V
    //   182: aload 6
    //   184: athrow
    //   185: astore 12
    //   187: goto -37 -> 150
    //   190: astore 7
    //   192: goto -10 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	1
    //   0	195	1	paramArrayOfPageRange	android.print.PageRange[]
    //   0	195	2	paramParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   0	195	3	paramCancellationSignal	CancellationSignal
    //   0	195	4	paramWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
    //   18	152	5	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
    //   162	21	6	localObject	java.lang.Object
    //   190	1	7	localIOException1	java.io.IOException
    //   26	66	8	localPage	android.graphics.pdf.PdfDocument.Page
    //   43	21	9	localRectF	android.graphics.RectF
    //   72	12	10	localMatrix	android.graphics.Matrix
    //   151	1	11	localIOException2	java.io.IOException
    //   185	1	12	localIOException3	java.io.IOException
    //   116	12	13	arrayOfPageRange	android.print.PageRange[]
    // Exception table:
    //   from	to	target	type
    //   96	132	151	java/io/IOException
    //   20	96	162	finally
    //   96	132	162	finally
    //   153	159	162	finally
    //   146	150	185	java/io/IOException
    //   178	182	190	java/io/IOException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat.1
 * JD-Core Version:    0.7.0.1
 */