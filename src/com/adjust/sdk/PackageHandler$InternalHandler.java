package com.adjust.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class PackageHandler$InternalHandler
  extends Handler
{
  private static final int ADD = 2;
  private static final int INIT = 1;
  private static final int SEND_FIRST = 4;
  private static final int SEND_NEXT = 3;
  private final WeakReference<PackageHandler> packageHandlerReference;
  
  protected PackageHandler$InternalHandler(Looper paramLooper, PackageHandler paramPackageHandler)
  {
    super(paramLooper);
    this.packageHandlerReference = new WeakReference(paramPackageHandler);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    PackageHandler localPackageHandler = (PackageHandler)this.packageHandlerReference.get();
    if (localPackageHandler == null) {}
    for (;;)
    {
      return;
      switch (paramMessage.arg1)
      {
      default: 
        break;
      case 1: 
        PackageHandler.access$000(localPackageHandler);
        break;
      case 2: 
        PackageHandler.access$100(localPackageHandler, (ActivityPackage)paramMessage.obj);
        break;
      case 4: 
        PackageHandler.access$200(localPackageHandler);
        break;
      case 3: 
        PackageHandler.access$300(localPackageHandler);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.PackageHandler.InternalHandler
 * JD-Core Version:    0.7.0.1
 */