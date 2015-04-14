import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

final class xa
  implements Runnable
{
  private final WeakReference b;
  
  public xa(wW paramwW, Context paramContext)
  {
    this.b = new WeakReference(paramContext);
  }
  
  public final void run()
  {
    try
    {
      WebView localWebView = new WebView((Context)this.b.get());
      String str = localWebView.getSettings().getUserAgentString();
      localWebView.destroy();
      wW.a(this.a, str);
      label38:
      return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xa
 * JD-Core Version:    0.7.0.1
 */