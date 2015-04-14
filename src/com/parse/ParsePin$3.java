package com.parse;

import java.util.List;
import l;
import m;

final class ParsePin$3
  implements l<ParsePin, m<Void>>
{
  ParsePin$3(List paramList) {}
  
  public m<Void> then(m<ParsePin> paramm)
  {
    ParsePin localParsePin = (ParsePin)paramm.e();
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    List localList = localParsePin.getObjects();
    m localm;
    if (localList == null) {
      localm = m.a(null);
    }
    for (;;)
    {
      return localm;
      localList.removeAll(this.val$objects);
      if (localList.size() == 0)
      {
        localm = localOfflineStore.unpinAsync(localParsePin);
      }
      else
      {
        localParsePin.setObjects(localList);
        localm = localOfflineStore.saveLocallyAsync(localParsePin, true);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePin.3
 * JD-Core Version:    0.7.0.1
 */