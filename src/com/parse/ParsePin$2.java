package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l;
import m;

final class ParsePin$2
  implements l<ParsePin, m<Void>>
{
  ParsePin$2(List paramList) {}
  
  public m<Void> then(m<ParsePin> paramm)
  {
    ParsePin localParsePin = (ParsePin)paramm.e();
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    List localList = localParsePin.getObjects();
    if (localList == null) {}
    for (Object localObject = new ArrayList(this.val$objects);; localObject = localList)
    {
      localParsePin.setObjects((List)localObject);
      return localOfflineStore.saveLocallyAsync(localParsePin, true);
      Iterator localIterator = this.val$objects.iterator();
      while (localIterator.hasNext())
      {
        ParseObject localParseObject = (ParseObject)localIterator.next();
        if (!localList.contains(localParseObject)) {
          localList.add(localParseObject);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePin.2
 * JD-Core Version:    0.7.0.1
 */