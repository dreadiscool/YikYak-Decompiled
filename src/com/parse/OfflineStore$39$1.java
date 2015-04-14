package com.parse;

import java.util.List;
import l;
import m;

class OfflineStore$39$1
  implements l<ParsePin, m<Void>>
{
  OfflineStore$39$1(OfflineStore.39 param39, String paramString) {}
  
  public m<Void> then(m<ParsePin> paramm)
  {
    ParsePin localParsePin = (ParsePin)paramm.e();
    List localList = localParsePin.getObjects();
    m localm;
    if (localList != null) {
      if (!localList.contains(this.this$1.val$object)) {
        localm = paramm.j();
      }
    }
    for (;;)
    {
      return localm;
      localList.remove(this.this$1.val$object);
      if (localList.size() == 0)
      {
        localm = OfflineStore.access$900(this.this$1.this$0, this.val$uuid, this.this$1.val$db);
      }
      else
      {
        localParsePin.setObjects(localList);
        localm = this.this$1.this$0.saveLocallyAsync(localParsePin, true, this.this$1.val$db);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.39.1
 * JD-Core Version:    0.7.0.1
 */