package com.parse;

import l;
import m;

class OfflineStore$34
  implements l<ParseObject, m<Void>>
{
  OfflineStore$34(OfflineStore paramOfflineStore, ParseObject paramParseObject) {}
  
  public m<Void> then(m<ParseObject> paramm)
  {
    m localm;
    if (paramm.d()) {
      if (((paramm.f() instanceof ParseException)) && (((ParseException)paramm.f()).getCode() == 120)) {
        localm = m.a(null);
      }
    }
    for (;;)
    {
      return localm;
      localm = paramm.j();
      continue;
      localm = OfflineStore.access$1300(this.this$0).getWritableDatabaseAsync().b(new OfflineStore.34.1(this));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.34
 * JD-Core Version:    0.7.0.1
 */