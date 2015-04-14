package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.InputStream;

public class RoundedBitmapDrawableFactory
{
  private static final String TAG = "RoundedBitmapDrawableFactory";
  
  public static RoundedBitmapDrawable create(Resources paramResources, Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = new RoundedBitmapDrawable21(paramResources, paramBitmap);; localObject = new RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(paramResources, paramBitmap)) {
      return localObject;
    }
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, InputStream paramInputStream)
  {
    RoundedBitmapDrawable localRoundedBitmapDrawable = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (localRoundedBitmapDrawable.getBitmap() == null) {
      new StringBuilder().append("BitmapDrawable cannot decode ").append(paramInputStream).toString();
    }
    return localRoundedBitmapDrawable;
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, String paramString)
  {
    RoundedBitmapDrawable localRoundedBitmapDrawable = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (localRoundedBitmapDrawable.getBitmap() == null) {
      new StringBuilder().append("BitmapDrawable cannot decode ").append(paramString).toString();
    }
    return localRoundedBitmapDrawable;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
 * JD-Core Version:    0.7.0.1
 */