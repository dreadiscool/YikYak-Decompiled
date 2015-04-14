package com.parse;

import java.util.List;
import l;
import m;

final class ParseUser$9
  implements l<List<ParseUser>, m<ParseUser>>
{
  public m<ParseUser> then(m<List<ParseUser>> paramm)
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
      localm = ParseObject.unpinAllInBackground("_currentUser").i();
      continue;
      localm = m.a(null);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.9
 * JD-Core Version:    0.7.0.1
 */