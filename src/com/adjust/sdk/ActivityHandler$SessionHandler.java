package com.adjust.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class ActivityHandler$SessionHandler
  extends Handler
{
  private static final int DEEP_LINK = 72680;
  private static final int END = 72650;
  private static final int EVENT = 72660;
  private static final int INIT_BUNDLE = 72630;
  private static final int INIT_PRESET = 72633;
  private static final int REVENUE = 72670;
  private static final int START = 72640;
  private final WeakReference<ActivityHandler> sessionHandlerReference;
  
  protected ActivityHandler$SessionHandler(Looper paramLooper, ActivityHandler paramActivityHandler)
  {
    super(paramLooper);
    this.sessionHandlerReference = new WeakReference(paramActivityHandler);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ActivityHandler localActivityHandler = (ActivityHandler)this.sessionHandlerReference.get();
    if (localActivityHandler == null) {}
    for (;;)
    {
      return;
      switch (paramMessage.arg1)
      {
      default: 
        break;
      case 72630: 
        ActivityHandler.access$200(localActivityHandler, true, null);
        break;
      case 72633: 
        ActivityHandler.access$200(localActivityHandler, false, (String)paramMessage.obj);
        break;
      case 72640: 
        ActivityHandler.access$300(localActivityHandler);
        break;
      case 72650: 
        ActivityHandler.access$400(localActivityHandler);
        break;
      case 72660: 
        ActivityHandler.access$500(localActivityHandler, (PackageBuilder)paramMessage.obj);
        break;
      case 72670: 
        ActivityHandler.access$600(localActivityHandler, (PackageBuilder)paramMessage.obj);
        break;
      case 72680: 
        ActivityHandler.access$700(localActivityHandler, (Uri)paramMessage.obj);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityHandler.SessionHandler
 * JD-Core Version:    0.7.0.1
 */