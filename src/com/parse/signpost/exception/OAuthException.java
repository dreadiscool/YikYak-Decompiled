package com.parse.signpost.exception;

public abstract class OAuthException
  extends Exception
{
  public OAuthException(String paramString)
  {
    super(paramString);
  }
  
  public OAuthException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public OAuthException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.exception.OAuthException
 * JD-Core Version:    0.7.0.1
 */