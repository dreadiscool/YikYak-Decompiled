package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import hZ;

final class d$a
  extends Handler
{
  public d$a(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    if (paramMessage.what == i) {}
    for (;;)
    {
      hZ.b(i);
      this.Ku.b((d.b)paramMessage.obj);
      return;
      int j = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.d.a
 * JD-Core Version:    0.7.0.1
 */