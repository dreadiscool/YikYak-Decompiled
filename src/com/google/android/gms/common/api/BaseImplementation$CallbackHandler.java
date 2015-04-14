package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

public class BaseImplementation$CallbackHandler<R extends Result>
  extends Handler
{
  public static final int CALLBACK_ON_COMPLETE = 1;
  public static final int CALLBACK_ON_TIMEOUT = 2;
  
  public BaseImplementation$CallbackHandler()
  {
    this(Looper.getMainLooper());
  }
  
  public BaseImplementation$CallbackHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  protected void deliverResultCallback(ResultCallback<R> paramResultCallback, R paramR)
  {
    try
    {
      paramResultCallback.onResult(paramR);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      BaseImplementation.a(paramR);
      throw localRuntimeException;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.wtf("GoogleApi", "Don't know how to handle this message.");
    }
    for (;;)
    {
      return;
      Pair localPair = (Pair)paramMessage.obj;
      deliverResultCallback((ResultCallback)localPair.first, (Result)localPair.second);
      continue;
      BaseImplementation.AbstractPendingResult.a((BaseImplementation.AbstractPendingResult)paramMessage.obj);
    }
  }
  
  public void removeTimeoutMessages()
  {
    removeMessages(2);
  }
  
  public void sendResultCallback(ResultCallback<R> paramResultCallback, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
  }
  
  public void sendTimeoutResultCallback(BaseImplementation.AbstractPendingResult<R> paramAbstractPendingResult, long paramLong)
  {
    sendMessageDelayed(obtainMessage(2, paramAbstractPendingResult), paramLong);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BaseImplementation.CallbackHandler
 * JD-Core Version:    0.7.0.1
 */