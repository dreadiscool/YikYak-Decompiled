package com.facebook;

public class FacebookException
  extends RuntimeException
{
  static final long serialVersionUID = 1L;
  
  public FacebookException() {}
  
  public FacebookException(String paramString)
  {
    super(paramString);
  }
  
  public FacebookException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FacebookException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookException
 * JD-Core Version:    0.7.0.1
 */