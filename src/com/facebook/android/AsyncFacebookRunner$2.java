package com.facebook.android;

import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

class AsyncFacebookRunner$2
  extends Thread
{
  AsyncFacebookRunner$2(AsyncFacebookRunner paramAsyncFacebookRunner, String paramString1, Bundle paramBundle, String paramString2, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {}
  
  public void run()
  {
    try
    {
      String str = this.this$0.fb.requestImpl(this.val$graphPath, this.val$parameters, this.val$httpMethod);
      this.val$listener.onComplete(str, this.val$state);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.val$listener.onFileNotFoundException(localFileNotFoundException, this.val$state);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        this.val$listener.onMalformedURLException(localMalformedURLException, this.val$state);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.val$listener.onIOException(localIOException, this.val$state);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.android.AsyncFacebookRunner.2
 * JD-Core Version:    0.7.0.1
 */