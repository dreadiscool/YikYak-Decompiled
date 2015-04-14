package com.facebook.widget;

import android.content.Context;
import android.webkit.WebView;

class WebDialog$3
  extends WebView
{
  WebDialog$3(WebDialog paramWebDialog, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    try
    {
      super.onWindowFocusChanged(paramBoolean);
      label5:
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label5;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.WebDialog.3
 * JD-Core Version:    0.7.0.1
 */