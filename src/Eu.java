import android.webkit.WebView;
import com.yik.yak.ui.activity.WebActivity;

public class Eu
  implements Runnable
{
  public Eu(WebActivity paramWebActivity) {}
  
  public void run()
  {
    WebActivity.c(this.a).destroy();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Eu
 * JD-Core Version:    0.7.0.1
 */