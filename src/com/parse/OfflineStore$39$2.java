package com.parse;

import l;
import m;

class OfflineStore$39$2
  implements l<ParseObject, m<ParsePin>>
{
  OfflineStore$39$2(OfflineStore.39 param39) {}
  
  public m<ParsePin> then(m<ParseObject> paramm)
  {
    ParsePin localParsePin = (ParsePin)paramm.e();
    return this.this$1.this$0.fetchLocallyAsync(localParsePin, this.this$1.val$db);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.39.2
 * JD-Core Version:    0.7.0.1
 */