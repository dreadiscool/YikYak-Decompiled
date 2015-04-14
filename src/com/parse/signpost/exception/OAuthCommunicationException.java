package com.parse.signpost.exception;

public class OAuthCommunicationException
  extends OAuthException
{
  private String responseBody;
  
  public OAuthCommunicationException(Exception paramException)
  {
    super("Communication with the service provider failed: " + paramException.getLocalizedMessage(), paramException);
  }
  
  public OAuthCommunicationException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.responseBody = paramString2;
  }
  
  public String getResponseBody()
  {
    return this.responseBody;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.exception.OAuthCommunicationException
 * JD-Core Version:    0.7.0.1
 */