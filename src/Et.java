import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.yik.yak.ui.activity.WebActivity;

public class Et
  extends WebViewClient
{
  public Et(WebActivity paramWebActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    WebActivity.b(this.a);
    paramWebView.setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    WebActivity.a(this.a);
    paramWebView.setVisibility(8);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Et
 * JD-Core Version:    0.7.0.1
 */