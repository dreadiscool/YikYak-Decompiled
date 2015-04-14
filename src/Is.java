import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import com.yik.yak.ui.activity.FamousActivity;
import java.io.ByteArrayOutputStream;

public class Is
  extends AsyncTask<Void, Void, Void>
{
  ProgressDialog a;
  private Context b;
  private CK c;
  private Bitmap d = null;
  private FamousActivity e = null;
  
  public Is(Context paramContext, CK paramCK)
  {
    this.b = paramContext;
    this.c = paramCK;
  }
  
  private Bitmap a(CK paramCK)
  {
    int i = (int)(4.0D * Math.random());
    int j = this.b.getResources().getColor(2131427638);
    int k;
    switch (i)
    {
    default: 
      k = 2130837569;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(1024, 596, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap2);
        Paint localPaint = new Paint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setStrokeWidth(1.0F);
        localPaint.setAntiAlias(true);
        localPaint.setColor(j);
        localPaint.setStyle(Paint.Style.FILL);
        localCanvas.drawRect(0.0F, 0.0F, 1024, 596, localPaint);
        Bitmap localBitmap3 = BitmapFactory.decodeResource(this.b.getResources(), 2130837878);
        localCanvas.drawBitmap(localBitmap3, new Rect(0, 0, 222, 64), new Rect(50, 50, 50 + localBitmap3.getWidth(), 50 + localBitmap3.getHeight()), null);
        String str = String.valueOf(paramCK.d);
        localPaint.setColor(-1);
        localPaint.setStyle(Paint.Style.FILL);
        localPaint.setTextSize(40.0F);
        Rect localRect1 = new Rect();
        localPaint.getTextBounds(str, 0, str.length(), localRect1);
        localCanvas.drawText(str, 974 - localRect1.right - localRect1.left, 75, localPaint);
        localPaint.setColor(-1);
        localPaint.setStyle(Paint.Style.FILL);
        localPaint.setTextSize(40.0F);
        Rect localRect2 = new Rect();
        localPaint.getTextBounds("UPVOTES", 0, "UPVOTES".length(), localRect2);
        localCanvas.drawText("UPVOTES", 974 - localRect2.right - localRect2.left, 110, localPaint);
        Bitmap localBitmap4 = BitmapFactory.decodeResource(this.b.getResources(), k);
        Bitmap localBitmap5 = Bitmap.createScaledBitmap(localBitmap4, localBitmap4.getWidth() / 2, localBitmap4.getHeight() / 2, true);
        int m = localBitmap5.getHeight();
        localBitmap4.recycle();
        localCanvas.drawBitmap(localBitmap5, 0.0F, 596 - localBitmap5.getHeight(), null);
        localBitmap5.recycle();
        Bitmap localBitmap6 = BitmapFactory.decodeResource(this.b.getResources(), 2130837874);
        Bitmap localBitmap7 = Bitmap.createScaledBitmap(localBitmap6, 120, 125, true);
        localBitmap6.recycle();
        localCanvas.drawBitmap(localBitmap7, 452, 20 + (471 - m), null);
        localCanvas.save();
        localBitmap7.recycle();
        TextView localTextView = new TextView(this.b);
        localTextView.setText(paramCK.l);
        localTextView.setTextSize(0, 36.0F);
        localTextView.setGravity(17);
        localTextView.setTextColor(-1);
        localTextView.setDrawingCacheEnabled(true);
        localTextView.layout(0, 0, 924, 400);
        localCanvas.drawBitmap(localTextView.getDrawingCache(), 50, '', localPaint);
        localTextView.setDrawingCacheEnabled(false);
        localBitmap1 = localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Toast.makeText(this.b, "Unable to generate image.", 0).show();
        System.gc();
        localBitmap1 = null;
        continue;
      }
      catch (Exception localException)
      {
        Toast.makeText(this.b, "Unable to generate image.", 0).show();
        Bitmap localBitmap1 = null;
        continue;
      }
      return localBitmap1;
      j = this.b.getResources().getColor(2131427638);
      k = 2130837569;
      continue;
      j = this.b.getResources().getColor(2131427639);
      k = 2130837812;
      continue;
      j = this.b.getResources().getColor(2131427640);
      k = 2130837816;
      continue;
      j = this.b.getResources().getColor(2131427641);
      k = 2130837735;
    }
  }
  
  /* Error */
  public java.io.File a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 238	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 239	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: getstatic 245	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   12: bipush 100
    //   14: aload_2
    //   15: invokevirtual 249	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual 253	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   23: astore 4
    //   25: aconst_null
    //   26: astore 5
    //   28: aload 4
    //   30: invokestatic 258	Ik:a	([B)Ljava/io/File;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +36 -> 73
    //   40: new 260	java/io/FileOutputStream
    //   43: dup
    //   44: aload 6
    //   46: invokespecial 263	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore 7
    //   51: aload 7
    //   53: aload 4
    //   55: invokevirtual 267	java/io/FileOutputStream:write	([B)V
    //   58: aload 7
    //   60: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   63: aload 7
    //   65: ifnull +8 -> 73
    //   68: aload 7
    //   70: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   73: aload_0
    //   74: getfield 26	Is:b	Landroid/content/Context;
    //   77: new 272	android/content/Intent
    //   80: dup
    //   81: ldc_w 274
    //   84: aload 6
    //   86: invokestatic 280	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   89: invokespecial 283	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   92: invokevirtual 287	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   95: aload 6
    //   97: areturn
    //   98: astore 15
    //   100: getstatic 291	java/lang/System:err	Ljava/io/PrintStream;
    //   103: ldc_w 293
    //   106: invokevirtual 299	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   109: goto -36 -> 73
    //   112: astore 17
    //   114: aconst_null
    //   115: astore 7
    //   117: aload 7
    //   119: ifnull -46 -> 73
    //   122: aload 7
    //   124: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   127: goto -54 -> 73
    //   130: astore 9
    //   132: getstatic 291	java/lang/System:err	Ljava/io/PrintStream;
    //   135: ldc_w 293
    //   138: invokevirtual 299	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   141: goto -68 -> 73
    //   144: astore 16
    //   146: aconst_null
    //   147: astore 7
    //   149: aload 7
    //   151: ifnull -78 -> 73
    //   154: aload 7
    //   156: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   159: goto -86 -> 73
    //   162: astore 11
    //   164: getstatic 291	java/lang/System:err	Ljava/io/PrintStream;
    //   167: ldc_w 293
    //   170: invokevirtual 299	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   173: goto -100 -> 73
    //   176: astore 13
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   188: aload 13
    //   190: athrow
    //   191: astore 14
    //   193: getstatic 291	java/lang/System:err	Ljava/io/PrintStream;
    //   196: ldc_w 293
    //   199: invokevirtual 299	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   202: goto -14 -> 188
    //   205: astore 12
    //   207: aload 7
    //   209: astore 5
    //   211: aload 12
    //   213: astore 13
    //   215: goto -37 -> 178
    //   218: astore 10
    //   220: goto -71 -> 149
    //   223: astore 8
    //   225: goto -108 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	Is
    //   0	228	1	paramBitmap	Bitmap
    //   7	13	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   23	31	4	arrayOfByte	byte[]
    //   26	184	5	localObject1	java.lang.Object
    //   33	63	6	localFile	java.io.File
    //   49	159	7	localFileOutputStream	java.io.FileOutputStream
    //   223	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   130	1	9	localIOException1	java.io.IOException
    //   218	1	10	localIOException2	java.io.IOException
    //   162	1	11	localIOException3	java.io.IOException
    //   205	7	12	localObject2	java.lang.Object
    //   176	13	13	localObject3	java.lang.Object
    //   213	1	13	localObject4	java.lang.Object
    //   191	1	14	localIOException4	java.io.IOException
    //   98	1	15	localIOException5	java.io.IOException
    //   144	1	16	localIOException6	java.io.IOException
    //   112	1	17	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   68	73	98	java/io/IOException
    //   40	51	112	java/io/FileNotFoundException
    //   122	127	130	java/io/IOException
    //   40	51	144	java/io/IOException
    //   154	159	162	java/io/IOException
    //   40	51	176	finally
    //   183	188	191	java/io/IOException
    //   51	63	205	finally
    //   51	63	218	java/io/IOException
    //   51	63	223	java/io/FileNotFoundException
  }
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      Bitmap localBitmap = a(this.c);
      if (localBitmap == null)
      {
        Toast.makeText(this.b, "Unable to generate image.", 0).show();
      }
      else
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        If.a().a(null, Long.valueOf(this.c.d), this.c.h);
        Iw.a(this.b, Uri.fromFile(a(localBitmap)));
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Toast.makeText(this.b, "Unable to generate image.", 0).show();
      System.gc();
    }
    catch (Exception localException)
    {
      Toast.makeText(this.b, "Unable to generate image.", 0).show();
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.dismiss();
    if (this.e != null) {
      this.e.a(this.d);
    }
  }
  
  protected void onPreExecute()
  {
    this.a = ProgressDialog.show(this.b, "Creating Image", "Image is currently being created", true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Is
 * JD-Core Version:    0.7.0.1
 */