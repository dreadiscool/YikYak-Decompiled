package com.adjust.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class RequestHandler$InternalHandler
  extends Handler
{
  private static final int INIT = 72401;
  private static final int SEND = 72400;
  private final WeakReference<RequestHandler> requestHandlerReference;
  
  protected RequestHandler$InternalHandler(Looper paramLooper, RequestHandler paramRequestHandler)
  {
    super(paramLooper);
    this.requestHandlerReference = new WeakReference(paramRequestHandler);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    RequestHandler localRequestHandler = (RequestHandler)this.requestHandlerReference.get();
    if (localRequestHandler == null) {}
    for (;;)
    {
      return;
      switch (paramMessage.arg1)
      {
      default: 
        break;
      case 72400: 
        RequestHandler.access$100(localRequestHandler, (ActivityPackage)paramMessage.obj);
        break;
      case 72401: 
        RequestHandler.access$000(localRequestHandler);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.RequestHandler.InternalHandler
 * JD-Core Version:    0.7.0.1
 */