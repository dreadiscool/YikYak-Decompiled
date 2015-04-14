package android.support.v7.internal.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.util.LruCache;

class TintManager$ColorFilterLruCache
  extends LruCache<Integer, PorterDuffColorFilter>
{
  public TintManager$ColorFilterLruCache(int paramInt)
  {
    super(paramInt);
  }
  
  private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
  {
    return 31 * (paramInt + 31) + paramMode.hashCode();
  }
  
  PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
  {
    return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
  }
  
  PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
  {
    return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintManager.ColorFilterLruCache
 * JD-Core Version:    0.7.0.1
 */