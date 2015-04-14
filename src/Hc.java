import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public abstract class Hc
  extends Drawable
  implements Animatable, Drawable.Callback
{
  private PullRefreshLayout a;
  
  public Hc(Context paramContext, PullRefreshLayout paramPullRefreshLayout)
  {
    this.a = paramPullRefreshLayout;
  }
  
  public Context a()
  {
    if (this.a != null) {}
    for (Context localContext = this.a.getContext();; localContext = null) {
      return localContext;
    }
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(Drawable paramDrawable);
  
  public PullRefreshLayout b()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hc
 * JD-Core Version:    0.7.0.1
 */