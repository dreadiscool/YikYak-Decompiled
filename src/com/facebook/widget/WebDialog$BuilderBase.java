package com.facebook.widget;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.Session;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

public class WebDialog$BuilderBase<CONCRETE extends BuilderBase<?>>
{
  private String action;
  private String applicationId;
  private Context context;
  private WebDialog.OnCompleteListener listener;
  private Bundle parameters;
  private Session session;
  private int theme = 16973840;
  
  protected WebDialog$BuilderBase(Context paramContext, Session paramSession, String paramString, Bundle paramBundle)
  {
    Validate.notNull(paramSession, "session");
    if (!paramSession.isOpened()) {
      throw new FacebookException("Attempted to use a Session that was not open.");
    }
    this.session = paramSession;
    finishInit(paramContext, paramString, paramBundle);
  }
  
  protected WebDialog$BuilderBase(Context paramContext, String paramString)
  {
    Session localSession = Session.getActiveSession();
    if ((localSession != null) && (localSession.isOpened())) {
      this.session = localSession;
    }
    for (;;)
    {
      finishInit(paramContext, paramString, null);
      return;
      String str = Utility.getMetadataApplicationId(paramContext);
      if (str == null) {
        break;
      }
      this.applicationId = str;
    }
    throw new FacebookException("Attempted to create a builder without an open Active Session or a valid default Application ID.");
  }
  
  protected WebDialog$BuilderBase(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramString1 == null) {
      paramString1 = Utility.getMetadataApplicationId(paramContext);
    }
    Validate.notNullOrEmpty(paramString1, "applicationId");
    this.applicationId = paramString1;
    finishInit(paramContext, paramString2, paramBundle);
  }
  
  private void finishInit(Context paramContext, String paramString, Bundle paramBundle)
  {
    this.context = paramContext;
    this.action = paramString;
    if (paramBundle != null) {}
    for (this.parameters = paramBundle;; this.parameters = new Bundle()) {
      return;
    }
  }
  
  public WebDialog build()
  {
    if ((this.session != null) && (this.session.isOpened()))
    {
      this.parameters.putString("app_id", this.session.getApplicationId());
      this.parameters.putString("access_token", this.session.getAccessToken());
    }
    for (;;)
    {
      return new WebDialog(this.context, this.action, this.parameters, this.theme, this.listener);
      this.parameters.putString("app_id", this.applicationId);
    }
  }
  
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public WebDialog.OnCompleteListener getListener()
  {
    return this.listener;
  }
  
  public Bundle getParameters()
  {
    return this.parameters;
  }
  
  public int getTheme()
  {
    return this.theme;
  }
  
  public CONCRETE setOnCompleteListener(WebDialog.OnCompleteListener paramOnCompleteListener)
  {
    this.listener = paramOnCompleteListener;
    return this;
  }
  
  public CONCRETE setTheme(int paramInt)
  {
    this.theme = paramInt;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.WebDialog.BuilderBase
 * JD-Core Version:    0.7.0.1
 */