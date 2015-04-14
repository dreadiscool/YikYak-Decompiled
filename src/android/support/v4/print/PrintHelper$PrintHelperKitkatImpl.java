package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

final class PrintHelper$PrintHelperKitkatImpl
  implements PrintHelper.PrintHelperVersionImpl
{
  private final PrintHelperKitkat mPrintHelper;
  
  PrintHelper$PrintHelperKitkatImpl(Context paramContext)
  {
    this.mPrintHelper = new PrintHelperKitkat(paramContext);
  }
  
  public int getColorMode()
  {
    return this.mPrintHelper.getColorMode();
  }
  
  public int getOrientation()
  {
    return this.mPrintHelper.getOrientation();
  }
  
  public int getScaleMode()
  {
    return this.mPrintHelper.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    PrintHelper.PrintHelperKitkatImpl.1 local1 = null;
    if (paramOnPrintFinishCallback != null) {
      local1 = new PrintHelper.PrintHelperKitkatImpl.1(this, paramOnPrintFinishCallback);
    }
    this.mPrintHelper.printBitmap(paramString, paramBitmap, local1);
  }
  
  public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    PrintHelper.PrintHelperKitkatImpl.2 local2 = null;
    if (paramOnPrintFinishCallback != null) {
      local2 = new PrintHelper.PrintHelperKitkatImpl.2(this, paramOnPrintFinishCallback);
    }
    this.mPrintHelper.printBitmap(paramString, paramUri, local2);
  }
  
  public void setColorMode(int paramInt)
  {
    this.mPrintHelper.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    this.mPrintHelper.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mPrintHelper.setScaleMode(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperKitkatImpl
 * JD-Core Version:    0.7.0.1
 */