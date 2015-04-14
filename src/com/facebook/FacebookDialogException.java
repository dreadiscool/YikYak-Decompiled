package com.facebook;

public class FacebookDialogException
  extends FacebookException
{
  static final long serialVersionUID = 1L;
  private int errorCode;
  private String failingUrl;
  
  public FacebookDialogException(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    this.errorCode = paramInt;
    this.failingUrl = paramString2;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getFailingUrl()
  {
    return this.failingUrl;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookDialogException
 * JD-Core Version:    0.7.0.1
 */