package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class Picasso$1
  extends Handler
{
  Picasso$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    List localList;
    int i;
    int j;
    switch (paramMessage.what)
    {
    default: 
      throw new AssertionError("Unknown handler message received: " + paramMessage.what);
    case 8: 
      localList = (List)paramMessage.obj;
      i = localList.size();
      j = 0;
    }
    while (j < i)
    {
      BitmapHunter localBitmapHunter = (BitmapHunter)localList.get(j);
      localBitmapHunter.picasso.complete(localBitmapHunter);
      j++;
      continue;
      Action localAction = (Action)paramMessage.obj;
      Picasso.access$000(localAction.picasso, localAction.getTarget());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.1
 * JD-Core Version:    0.7.0.1
 */