package com.parse;

import l;
import m;

class ParseObject$32
  implements l<Void, m<Void>>
{
  ParseObject$32(ParseObject paramParseObject, OfflineStore paramOfflineStore) {}
  
  public m<Void> then(m<Void> paramm)
  {
    m localm;
    synchronized (this.this$0.mutex)
    {
      if (this.this$0.isDeleted) {
        localm = this.val$store.deleteDataForObjectAsync(this.this$0);
      } else {
        localm = this.val$store.updateDataForObjectAsync(this.this$0);
      }
    }
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.32
 * JD-Core Version:    0.7.0.1
 */