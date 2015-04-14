package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

class ListViewCompat$GateKeeperDrawable
  extends DrawableWrapper
{
  private boolean mEnabled = true;
  
  public ListViewCompat$GateKeeperDrawable(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mEnabled) {
      super.draw(paramCanvas);
    }
  }
  
  void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.mEnabled) {
      super.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mEnabled) {
      super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.mEnabled) {}
    for (boolean bool = super.setState(paramArrayOfInt);; bool = false) {
      return bool;
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mEnabled) {}
    for (boolean bool = super.setVisible(paramBoolean1, paramBoolean2);; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ListViewCompat.GateKeeperDrawable
 * JD-Core Version:    0.7.0.1
 */