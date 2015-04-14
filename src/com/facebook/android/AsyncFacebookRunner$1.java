package com.facebook.android;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

class AsyncFacebookRunner$1
  extends Thread
{
  AsyncFacebookRunner$1(AsyncFacebookRunner paramAsyncFacebookRunner, Context paramContext, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {}
  
  public void run()
  {
    try
    {
      String str = this.this$0.fb.logoutImpl(this.val$context);
      if ((str.length() == 0) || (str.equals("false"))) {
        this.val$listener.onFacebookError(new FacebookError("auth.expireSession failed"), this.val$state);
      } else {
        this.val$listener.onComplete(str, this.val$state);
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      this.val$listener.onFileNotFoundException(localFileNotFoundException, this.val$state);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.val$listener.onMalformedURLException(localMalformedURLException, this.val$state);
    }
    catch (IOException localIOException)
    {
      this.val$listener.onIOException(localIOException, this.val$state);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.android.AsyncFacebookRunner.1
 * JD-Core Version:    0.7.0.1
 */