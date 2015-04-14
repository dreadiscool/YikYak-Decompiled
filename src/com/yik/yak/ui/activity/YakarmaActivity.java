package com.yik.yak.ui.activity;

import ApplicationConfig;
import Ev;
import Ew;
import Ex;
import Ey;
import If;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class YakarmaActivity
  extends BaseYikYakFragmentActivity
{
  public final ViewTreeObserver.OnScrollChangedListener b = new Ev(this);
  private ScrollView c;
  private ScrollView d;
  private ScrollView e;
  private Context f;
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    boolean bool;
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      Drawable localDrawable = getResources().getDrawable(paramInt);
      if (localDrawable == null)
      {
        bool = false;
      }
      else
      {
        Bitmap localBitmap1 = ((BitmapDrawable)localDrawable).getBitmap();
        int j = localBitmap1.getWidth();
        int k = localBitmap1.getHeight();
        float f1 = i / j;
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f1, f1);
        Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, j, k, localMatrix, true);
        int m = localBitmap2.getWidth();
        int n = localBitmap2.getHeight();
        paramImageView.setImageDrawable(new BitmapDrawable(getResources(), localBitmap2));
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
        localLayoutParams.width = m;
        localLayoutParams.height = n;
        paramImageView.setLayoutParams(localLayoutParams);
        bool = true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      bool = false;
    }
    catch (Exception localException)
    {
      bool = false;
    }
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903073);
    this.f = this;
    a((ImageView)findViewById(2131558526), 2130837788);
    a((ImageView)findViewById(2131558528), 2130837583);
    this.c = ((ScrollView)findViewById(2131558525));
    this.d = ((ScrollView)findViewById(2131558527));
    this.e = ((ScrollView)findViewById(2131558529));
    this.e.setOnTouchListener(new Ew(this));
    ((TextView)findViewById(2131558530)).setText(BV.e());
    ((Button)findViewById(2131558533)).setOnClickListener(new Ex(this));
    If.a().k();
  }
  
  public void onResume()
  {
    super.onResume();
    this.e.post(new Ey(this));
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.activity.YakarmaActivity

 * JD-Core Version:    0.7.0.1

 */