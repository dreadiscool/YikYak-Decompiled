package com.facebook;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Request$4
  implements Runnable
{
  Request$4(ArrayList paramArrayList, RequestBatch paramRequestBatch) {}
  
  public void run()
  {
    Iterator localIterator1 = this.val$callbacks.iterator();
    while (localIterator1.hasNext())
    {
      Pair localPair = (Pair)localIterator1.next();
      ((Request.Callback)localPair.first).onCompleted((Response)localPair.second);
    }
    Iterator localIterator2 = this.val$requests.getCallbacks().iterator();
    while (localIterator2.hasNext()) {
      ((RequestBatch.Callback)localIterator2.next()).onBatchCompleted(this.val$requests);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.4
 * JD-Core Version:    0.7.0.1
 */