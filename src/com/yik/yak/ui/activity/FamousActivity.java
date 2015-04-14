package com.yik.yak.ui.activity;

import CK;
import CM;
import Ct;
import Dh;
import EN;
import EP;
import EV;
import If;
import Ik;
import Iw;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.adapter.ShareCardRecyclerViewAdapter;
import jF;
import jG;
import jZ;
import java.util.ArrayList;

public class FamousActivity
  extends BaseYikYakActivity
  implements EP, View.OnClickListener
{
  protected LinearLayoutManager a;
  private Context b;
  private ShareCardRecyclerViewAdapter c;
  private CK d;
  private ArrayList<Ct> e;
  private int f = 0;
  private boolean g = true;
  private boolean h = false;
  @InjectView(2131558484)
  protected ImageView imgShareCardPreview;
  @InjectView(2131558492)
  protected RecyclerView mRecyclerView;
  @InjectView(2131558493)
  protected TextView txtShareFamous;
  
  private void a(CK paramCK, int paramInt, boolean paramBoolean)
  {
    try
    {
      int i = a(paramInt);
      localBitmap1 = Bitmap.createBitmap(1024, 596, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      Paint localPaint = new Paint(2);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setAntiAlias(true);
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localCanvas.drawRect(0.0F, 0.0F, 1024, 596, localPaint);
      localCanvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.b.getResources(), 2130837723), 1024, 596, true), 0.0F, 0.0F, null);
      Bitmap localBitmap2 = b(paramInt);
      int j = localBitmap2.getWidth();
      int k = localBitmap2.getHeight();
      localCanvas.drawBitmap(Bitmap.createScaledBitmap(localBitmap2, j, k, true), 30 + (315 - j) / 2, 130 + (315 - k) / 2, null);
      TextView localTextView1 = new TextView(this.b);
      localTextView1.setText(c(paramInt));
      localTextView1.setTextSize(0, 40.0F);
      localTextView1.setGravity(1);
      localTextView1.setTextColor(-1);
      localTextView1.setDrawingCacheEnabled(true);
      localTextView1.layout(0, 0, 315, 120);
      localCanvas.drawBitmap(localTextView1.getDrawingCache(), 30, 445, localPaint);
      localTextView1.setDrawingCacheEnabled(false);
      localCanvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.b.getResources(), 2130837727), 600, 165, true), 375, 25, null);
      if (!this.d.k.isEmpty())
      {
        m = 50;
        TextView localTextView4 = new TextView(this.b);
        localTextView4.setText(this.d.k);
        localTextView4.setTextSize(0, 35.0F);
        localTextView4.setTypeface(Typeface.DEFAULT_BOLD);
        localTextView4.setGravity(1);
        localTextView4.setTextColor(-1);
        localTextView4.setDrawingCacheEnabled(true);
        localTextView4.layout(0, 0, 600, 300);
        localCanvas.drawBitmap(localTextView4.getDrawingCache(), 375, 'È', localPaint);
        localTextView4.setDrawingCacheEnabled(false);
        TextView localTextView2 = new TextView(this.b);
        localTextView2.setText(paramCK.l);
        if (this.d.l.length() > 150) {
          localTextView2.setTextSize(0, 30.0F);
        }
        for (;;)
        {
          localTextView2.setGravity(17);
          localTextView2.setTextColor(-1);
          localTextView2.setDrawingCacheEnabled(true);
          localTextView2.layout(0, 0, 600, 300);
          localCanvas.drawBitmap(localTextView2.getDrawingCache(), 375, m + 200, localPaint);
          localTextView2.setDrawingCacheEnabled(false);
          TextView localTextView3 = new TextView(this.b);
          localTextView3.setText(paramCK.d + " VOTES");
          localTextView3.setTextSize(0, 40.0F);
          localTextView3.setGravity(1);
          localTextView3.setTextColor(-1);
          localTextView3.setDrawingCacheEnabled(true);
          localTextView3.layout(0, 0, 150, 100);
          localCanvas.drawBitmap(localTextView3.getDrawingCache(), 870, 490, localPaint);
          localTextView3.setDrawingCacheEnabled(false);
          if (!paramBoolean) {
            break;
          }
          this.imgShareCardPreview.setImageBitmap(localBitmap1);
          this.h = false;
          return;
          localTextView2.setTextSize(0, 35.0F);
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap1;
        Toast.makeText(this.b, "Unable to generate image.", 0).show();
        System.gc();
        continue;
        If.a().a(null, Long.valueOf(this.d.d), CK.a(paramCK.h), d(paramInt));
        Iw.a(this.b, Uri.fromFile(b(localBitmap1)));
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Toast.makeText(this.b, "Unable to generate image.", 0).show();
        continue;
        int m = 0;
      }
    }
  }
  
  /* Error */
  private java.io.File b(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 292	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 293	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: getstatic 299	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   12: bipush 100
    //   14: aload_2
    //   15: invokevirtual 303	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual 307	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   23: astore 4
    //   25: aconst_null
    //   26: astore 5
    //   28: aload 4
    //   30: invokestatic 312	Ik:a	([B)Ljava/io/File;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +36 -> 73
    //   40: new 314	java/io/FileOutputStream
    //   43: dup
    //   44: aload 6
    //   46: invokespecial 317	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore 7
    //   51: aload 7
    //   53: aload 4
    //   55: invokevirtual 321	java/io/FileOutputStream:write	([B)V
    //   58: aload 7
    //   60: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   63: aload 7
    //   65: ifnull +8 -> 73
    //   68: aload 7
    //   70: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   73: aload_0
    //   74: getfield 108	com/yik/yak/ui/activity/FamousActivity:b	Landroid/content/Context;
    //   77: new 326	android/content/Intent
    //   80: dup
    //   81: ldc_w 328
    //   84: aload 6
    //   86: invokestatic 274	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   89: invokespecial 331	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   92: invokevirtual 335	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   95: aload 6
    //   97: areturn
    //   98: astore 15
    //   100: getstatic 339	java/lang/System:err	Ljava/io/PrintStream;
    //   103: ldc_w 341
    //   106: invokevirtual 347	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   109: goto -36 -> 73
    //   112: astore 17
    //   114: aconst_null
    //   115: astore 7
    //   117: aload 7
    //   119: ifnull -46 -> 73
    //   122: aload 7
    //   124: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   127: goto -54 -> 73
    //   130: astore 9
    //   132: getstatic 339	java/lang/System:err	Ljava/io/PrintStream;
    //   135: ldc_w 341
    //   138: invokevirtual 347	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   141: goto -68 -> 73
    //   144: astore 16
    //   146: aconst_null
    //   147: astore 7
    //   149: aload 7
    //   151: ifnull -78 -> 73
    //   154: aload 7
    //   156: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   159: goto -86 -> 73
    //   162: astore 11
    //   164: getstatic 339	java/lang/System:err	Ljava/io/PrintStream;
    //   167: ldc_w 341
    //   170: invokevirtual 347	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   173: goto -100 -> 73
    //   176: astore 13
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   188: aload 13
    //   190: athrow
    //   191: astore 14
    //   193: getstatic 339	java/lang/System:err	Ljava/io/PrintStream;
    //   196: ldc_w 341
    //   199: invokevirtual 347	java/io/PrintStream:println	(Ljava/lang/String;)V
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
    //   0	228	0	this	FamousActivity
    //   0	228	1	paramBitmap	Bitmap
    //   7	13	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
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
  
  protected int a(int paramInt)
  {
    try
    {
      i = getResources().getIntArray(2131296262)[paramInt];
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 2131427529;
      }
    }
  }
  
  public void a()
  {
    YakkerLocation localYakkerLocation = CM.a(this).f();
    try
    {
      jG localjG = ((MapFragment)getFragmentManager().findFragmentById(2131558485)).b();
      localjG.d().a(false);
      localjG.d().b(false);
      localjG.a(jF.a(new LatLng(localYakkerLocation.getLatitude(), localYakkerLocation.getLongitude()), 12.0F));
      label66:
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public void a(EV<?> paramEV, EN paramEN, int paramInt)
  {
    this.f = paramInt;
    this.g = true;
    if (!this.h)
    {
      this.h = true;
      a(this.d, paramInt, true);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.imgShareCardPreview.setImageBitmap(paramBitmap);
  }
  
  protected float b()
  {
    Display localDisplay = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    return localPoint.x / 1024.0F;
  }
  
  protected Bitmap b(int paramInt)
  {
    try
    {
      Bitmap localBitmap2 = ((BitmapDrawable)getResources().obtainTypedArray(2131296264).getDrawable(paramInt)).getBitmap();
      localBitmap1 = localBitmap2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bitmap localBitmap1 = ((BitmapDrawable)getResources().getDrawable(2130837728)).getBitmap();
      }
    }
    return localBitmap1;
  }
  
  protected String c(int paramInt)
  {
    try
    {
      str = getResources().getStringArray(2131296261)[paramInt];
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "HARRY YAKKER";
      }
    }
  }
  
  protected String d(int paramInt)
  {
    try
    {
      str = getResources().getStringArray(2131296260)[paramInt];
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "famous-harry";
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
  }
  
  public void onClick(View paramView)
  {
    a(this.d, this.f, false);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903064);
    this.b = this;
    ButterKnife.inject(this);
    a();
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("yak"))) {
      this.d = new CK(this, localBundle.getString("yak"));
    }
    for (;;)
    {
      if (Ik.a(this.d.l)) {
        finish();
      }
      this.e = new ArrayList();
      TypedArray localTypedArray = getResources().obtainTypedArray(2131296263);
      String[] arrayOfString = getResources().getStringArray(2131296261);
      int[] arrayOfInt = getResources().getIntArray(2131296262);
      int i = 0;
      try
      {
        while (i < arrayOfString.length)
        {
          this.e.add(new Ct(localTypedArray.getDrawable(i), arrayOfString[i], arrayOfInt[i]));
          i++;
          continue;
          finish();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.imgShareCardPreview.getLayoutParams().height = ((int)(596.0F * b()));
        this.txtShareFamous.setOnClickListener(new Dh(this));
        this.a = new LinearLayoutManager(this);
        this.a.setOrientation(0);
        this.c = new ShareCardRecyclerViewAdapter(this.b, this.e);
        this.mRecyclerView.setAdapter(this.c);
        this.c.setOnItemClickListener(this);
        this.mRecyclerView.setLayoutManager(this.a);
        a(this.d, 0, true);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.FamousActivity
 * JD-Core Version:    0.7.0.1
 */