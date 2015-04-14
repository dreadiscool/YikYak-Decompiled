package com.facebook.android;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

@Deprecated
public abstract interface AsyncFacebookRunner$RequestListener
{
  public abstract void onComplete(String paramString, Object paramObject);
  
  public abstract void onFacebookError(FacebookError paramFacebookError, Object paramObject);
  
  public abstract void onFileNotFoundException(FileNotFoundException paramFileNotFoundException, Object paramObject);
  
  public abstract void onIOException(IOException paramIOException, Object paramObject);
  
  public abstract void onMalformedURLException(MalformedURLException paramMalformedURLException, Object paramObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.android.AsyncFacebookRunner.RequestListener
 * JD-Core Version:    0.7.0.1
 */