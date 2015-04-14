import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;

public class vQ
{
  public static int a(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    arrayOfFloat[2] = 0.3F;
    return Color.HSVToColor(242, arrayOfFloat);
  }
  
  public static int a(Activity paramActivity)
  {
    int i = -16777216;
    Bitmap localBitmap = a(paramActivity, 1, 1, false);
    if (localBitmap != null) {
      i = localBitmap.getPixel(0, 0);
    }
    return a(i);
  }
  
  public static int a(Bitmap paramBitmap)
  {
    int i = -16777216;
    if (paramBitmap != null) {
      i = Bitmap.createScaledBitmap(paramBitmap, 1, 1, false).getPixel(0, 0);
    }
    return a(i);
  }
  
  public static Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    View localView = paramActivity.findViewById(16908290).getRootView();
    boolean bool = localView.isDrawingCacheEnabled();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache(true);
    Bitmap localBitmap1 = localView.getDrawingCache();
    Object localObject = null;
    if ((localBitmap1 != null) && (localBitmap1.getWidth() > 0) && (localBitmap1.getHeight() > 0))
    {
      if (paramBoolean)
      {
        paramInt1 = localBitmap1.getWidth() / paramInt1;
        paramInt2 = localBitmap1.getHeight() / paramInt2;
      }
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    }
    try
    {
      Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, paramInt1, paramInt2, false);
      localObject = localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label103:
      break label103;
    }
    if (!bool) {
      localView.setDrawingCacheEnabled(false);
    }
    return localObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vQ
 * JD-Core Version:    0.7.0.1
 */