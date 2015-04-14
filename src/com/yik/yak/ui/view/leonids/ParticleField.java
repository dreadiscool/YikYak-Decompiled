package com.yik.yak.ui.view.leonids;

import Hx;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class ParticleField
  extends View
{
  private ArrayList<Hx> a;
  
  public ParticleField(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleField(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleField(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(ArrayList<Hx> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    for (int i = 0; i < this.a.size(); i++) {
      ((Hx)this.a.get(i)).a(paramCanvas);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.leonids.ParticleField
 * JD-Core Version:    0.7.0.1
 */