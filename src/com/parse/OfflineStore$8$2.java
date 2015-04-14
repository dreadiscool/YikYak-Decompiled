package com.parse;

import k;
import l;
import m;

class OfflineStore$8$2
  implements l<T, m<Boolean>>
{
  OfflineStore$8$2(OfflineStore.8 param8, k paramk, OfflineQueryLogic.ConstraintMatcher paramConstraintMatcher) {}
  
  public m<Boolean> then(m<T> paramm)
  {
    if (!((ParseObject)this.val$object.a()).isDataAvailable()) {}
    for (m localm = m.a(Boolean.valueOf(false));; localm = this.val$matcher.matchesAsync((ParseObject)this.val$object.a(), this.this$1.val$db)) {
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.8.2
 * JD-Core Version:    0.7.0.1
 */