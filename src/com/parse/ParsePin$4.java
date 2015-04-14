package com.parse;

import l;
import m;

final class ParsePin$4
  implements l<ParsePin, m<Void>>
{
  public m<Void> then(m<ParsePin> paramm)
  {
    if (paramm.d()) {}
    ParsePin localParsePin;
    for (m localm = paramm.j();; localm = OfflineStore.getCurrent().unpinAsync(localParsePin))
    {
      return localm;
      localParsePin = (ParsePin)paramm.e();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePin.4
 * JD-Core Version:    0.7.0.1
 */