package com.parse.signpost.http;

import java.io.InputStream;

public abstract interface HttpResponse
{
  public abstract InputStream getContent();
  
  public abstract String getReasonPhrase();
  
  public abstract int getStatusCode();
  
  public abstract Object unwrap();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.http.HttpResponse
 * JD-Core Version:    0.7.0.1
 */