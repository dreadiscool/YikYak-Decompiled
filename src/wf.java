import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

class wf
  implements ViewTreeObserver.OnGlobalLayoutListener, Runnable
{
  private volatile boolean a;
  private boolean b;
  private final WeakReference<View> c;
  private final wH d;
  private final Handler e;
  
  public wf(View paramView, wH paramwH, Handler paramHandler)
  {
    this.d = paramwH;
    this.c = new WeakReference(paramView);
    this.e = paramHandler;
    this.b = true;
    this.a = false;
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    if (localViewTreeObserver.isAlive()) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    run();
  }
  
  private void b()
  {
    if (this.b)
    {
      View localView = (View)this.c.get();
      if (localView != null)
      {
        ViewTreeObserver localViewTreeObserver = localView.getViewTreeObserver();
        if (localViewTreeObserver.isAlive()) {
          localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
      }
      this.d.a();
    }
    this.b = false;
  }
  
  public void a()
  {
    this.a = true;
    this.e.post(this);
  }
  
  public void onGlobalLayout()
  {
    run();
  }
  
  public void run()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      View localView = (View)this.c.get();
      if ((localView == null) || (this.a))
      {
        b();
      }
      else
      {
        this.d.b(localView);
        this.e.removeCallbacks(this);
        this.e.postDelayed(this, 1000L);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wf
 * JD-Core Version:    0.7.0.1
 */