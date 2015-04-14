package com.parse;

import l;
import m;

class OfflineStore$28$1$1
  implements l<Void, m<Void>>
{
  OfflineStore$28$1$1(OfflineStore.28.1 param1) {}
  
  public m<Void> then(m<Void> paramm)
  {
    this.this$2.val$db.endTransactionAsync();
    this.this$2.val$db.close();
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.28.1.1
 * JD-Core Version:    0.7.0.1
 */