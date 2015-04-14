package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import l;
import m;

class OfflineStore$OfflineEncodingStrategy$1
  implements l<Void, m<Void>>
{
  OfflineStore$OfflineEncodingStrategy$1(OfflineStore.OfflineEncodingStrategy paramOfflineEncodingStrategy) {}
  
  public m<Void> then(m<Void> paramm)
  {
    m localm;
    synchronized (OfflineStore.OfflineEncodingStrategy.access$000(this.this$1))
    {
      Iterator localIterator = OfflineStore.OfflineEncodingStrategy.access$100(this.this$1).iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if ((localm.d()) || (localm.c())) {
          break label94;
        }
      }
      OfflineStore.OfflineEncodingStrategy.access$100(this.this$1).clear();
      localm = m.a((Void)null);
    }
    label94:
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.OfflineEncodingStrategy.1
 * JD-Core Version:    0.7.0.1
 */