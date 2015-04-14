package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import java.util.Set;

class MediaMetadataCompatApi21
{
  public static Bitmap getBitmap(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getBitmap(paramString);
  }
  
  public static long getLong(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getLong(paramString);
  }
  
  public static Object getRating(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getRating(paramString);
  }
  
  public static CharSequence getText(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getText(paramString);
  }
  
  public static Set<String> keySet(Object paramObject)
  {
    return ((MediaMetadata)paramObject).keySet();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaMetadataCompatApi21
 * JD-Core Version:    0.7.0.1
 */