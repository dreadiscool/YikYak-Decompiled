package com.facebook.widget;

import android.content.Context;
import android.os.Bundle;
import com.facebook.Session;

public class WebDialog$RequestsDialogBuilder
  extends WebDialog.BuilderBase<RequestsDialogBuilder>
{
  private static final String APPREQUESTS_DIALOG = "apprequests";
  private static final String DATA_PARAM = "data";
  private static final String MESSAGE_PARAM = "message";
  private static final String TITLE_PARAM = "title";
  private static final String TO_PARAM = "to";
  
  public WebDialog$RequestsDialogBuilder(Context paramContext)
  {
    super(paramContext, "apprequests");
  }
  
  public WebDialog$RequestsDialogBuilder(Context paramContext, Session paramSession)
  {
    super(paramContext, paramSession, "apprequests", null);
  }
  
  public WebDialog$RequestsDialogBuilder(Context paramContext, Session paramSession, Bundle paramBundle)
  {
    super(paramContext, paramSession, "apprequests", paramBundle);
  }
  
  public WebDialog$RequestsDialogBuilder(Context paramContext, String paramString, Bundle paramBundle)
  {
    super(paramContext, paramString, "apprequests", paramBundle);
  }
  
  public RequestsDialogBuilder setData(String paramString)
  {
    getParameters().putString("data", paramString);
    return this;
  }
  
  public RequestsDialogBuilder setMessage(String paramString)
  {
    getParameters().putString("message", paramString);
    return this;
  }
  
  public RequestsDialogBuilder setTitle(String paramString)
  {
    getParameters().putString("title", paramString);
    return this;
  }
  
  public RequestsDialogBuilder setTo(String paramString)
  {
    getParameters().putString("to", paramString);
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.WebDialog.RequestsDialogBuilder
 * JD-Core Version:    0.7.0.1
 */