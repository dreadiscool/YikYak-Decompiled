package com.squareup.picasso;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Dispatcher$DispatcherHandler
  extends Handler
{
  private final Dispatcher dispatcher;
  
  public Dispatcher$DispatcherHandler(Looper paramLooper, Dispatcher paramDispatcher)
  {
    super(paramLooper);
    this.dispatcher = paramDispatcher;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    case 3: 
    case 8: 
    default: 
      Picasso.HANDLER.post(new Dispatcher.DispatcherHandler.1(this, paramMessage));
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 9: 
      for (;;)
      {
        return;
        Action localAction2 = (Action)paramMessage.obj;
        this.dispatcher.performSubmit(localAction2);
        continue;
        Action localAction1 = (Action)paramMessage.obj;
        this.dispatcher.performCancel(localAction1);
        continue;
        BitmapHunter localBitmapHunter3 = (BitmapHunter)paramMessage.obj;
        this.dispatcher.performComplete(localBitmapHunter3);
        continue;
        BitmapHunter localBitmapHunter2 = (BitmapHunter)paramMessage.obj;
        this.dispatcher.performRetry(localBitmapHunter2);
        continue;
        BitmapHunter localBitmapHunter1 = (BitmapHunter)paramMessage.obj;
        this.dispatcher.performError(localBitmapHunter1, false);
        continue;
        this.dispatcher.performBatchComplete();
        continue;
        NetworkInfo localNetworkInfo = (NetworkInfo)paramMessage.obj;
        this.dispatcher.performNetworkStateChange(localNetworkInfo);
      }
    }
    Dispatcher localDispatcher = this.dispatcher;
    if (paramMessage.arg1 == i) {}
    for (;;)
    {
      localDispatcher.performAirplaneModeChange(i);
      break;
      int j = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Dispatcher.DispatcherHandler
 * JD-Core Version:    0.7.0.1
 */