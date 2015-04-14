package android.support.v7.internal.widget;

import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;

abstract interface SpinnerCompat$SpinnerPopup
{
  public abstract void dismiss();
  
  public abstract Drawable getBackground();
  
  public abstract CharSequence getHintText();
  
  public abstract int getHorizontalOffset();
  
  public abstract int getVerticalOffset();
  
  public abstract boolean isShowing();
  
  public abstract void setAdapter(ListAdapter paramListAdapter);
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setHorizontalOffset(int paramInt);
  
  public abstract void setPromptText(CharSequence paramCharSequence);
  
  public abstract void setVerticalOffset(int paramInt);
  
  public abstract void show();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
 * JD-Core Version:    0.7.0.1
 */