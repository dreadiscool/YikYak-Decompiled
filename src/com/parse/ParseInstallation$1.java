package com.parse;

import java.util.List;
import l;
import m;

final class ParseInstallation$1
  implements l<List<ParseInstallation>, m<ParseInstallation>>
{
  public m<ParseInstallation> then(m<List<ParseInstallation>> paramm)
  {
    List localList = (List)paramm.e();
    m localm;
    if (localList != null) {
      if (localList.size() == 1) {
        localm = m.a(localList.get(0));
      }
    }
    for (;;)
    {
      return localm;
      localm = ParseObject.unpinAllInBackground("_currentInstallation").i();
      continue;
      localm = m.a(null);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseInstallation.1
 * JD-Core Version:    0.7.0.1
 */