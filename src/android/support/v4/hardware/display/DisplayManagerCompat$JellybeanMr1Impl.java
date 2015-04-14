package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;

class DisplayManagerCompat$JellybeanMr1Impl
  extends DisplayManagerCompat
{
  private final Object mDisplayManagerObj;
  
  public DisplayManagerCompat$JellybeanMr1Impl(Context paramContext)
  {
    this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(paramContext);
  }
  
  public Display getDisplay(int paramInt)
  {
    return DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, paramInt);
  }
  
  public Display[] getDisplays()
  {
    return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
  }
  
  public Display[] getDisplays(String paramString)
  {
    return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat.JellybeanMr1Impl
 * JD-Core Version:    0.7.0.1
 */