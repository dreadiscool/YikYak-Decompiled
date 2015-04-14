import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GS
  extends Fa
{
  private View b;
  private String c = "about:blank";
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2130903114, paramViewGroup, false);
    WebView localWebView = (WebView)this.b.findViewById(2131558738);
    localWebView.setWebViewClient(new WebViewClient());
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.loadUrl(this.c);
    return this.b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GS
 * JD-Core Version:    0.7.0.1
 */