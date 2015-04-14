package android.support.v4.app;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.Window;

class ActionBarDrawerToggle$SlideDrawable
  extends InsetDrawable
  implements Drawable.Callback
{
  private final boolean mHasMirroring;
  private float mOffset;
  private float mPosition;
  private final Rect mTmpRect;
  
  private ActionBarDrawerToggle$SlideDrawable(ActionBarDrawerToggle paramActionBarDrawerToggle, Drawable paramDrawable)
  {
    super(paramDrawable, 0);
    if (Build.VERSION.SDK_INT > 18) {
      bool = true;
    }
    this.mHasMirroring = bool;
    this.mTmpRect = new Rect();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    copyBounds(this.mTmpRect);
    paramCanvas.save();
    if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.access$400(this.this$0).getWindow().getDecorView()) == i) {}
    for (int j = i;; j = 0)
    {
      if (j != 0) {
        i = -1;
      }
      int k = this.mTmpRect.width();
      paramCanvas.translate(-this.mOffset * k * this.mPosition * i, 0.0F);
      if ((j != 0) && (!this.mHasMirroring))
      {
        paramCanvas.translate(k, 0.0F);
        paramCanvas.scale(-1.0F, 1.0F);
      }
      super.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }
  
  public float getPosition()
  {
    return this.mPosition;
  }
  
  public void setOffset(float paramFloat)
  {
    this.mOffset = paramFloat;
    invalidateSelf();
  }
  
  public void setPosition(float paramFloat)
  {
    this.mPosition = paramFloat;
    invalidateSelf();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle.SlideDrawable
 * JD-Core Version:    0.7.0.1
 */