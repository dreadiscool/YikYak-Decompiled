package com.parse.oauth;

public abstract interface OAuth1FlowDialog$FlowResultHandler
{
  public abstract void onCancel();
  
  public abstract void onComplete(String paramString);
  
  public abstract void onError(int paramInt, String paramString1, String paramString2);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.oauth.OAuth1FlowDialog.FlowResultHandler
 * JD-Core Version:    0.7.0.1
 */