package com.parse;

import l;
import m;

class OfflineStore$34$1$1$1
  implements l<Void, m<Void>>
{
  OfflineStore$34$1$1$1(OfflineStore.34.1.1 param1) {}
  
  public m<Void> then(m<Void> paramm)
  {
    this.this$3.val$db.endTransactionAsync();
    this.this$3.val$db.close();
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.34.1.1.1
 * JD-Core Version:    0.7.0.1
 */