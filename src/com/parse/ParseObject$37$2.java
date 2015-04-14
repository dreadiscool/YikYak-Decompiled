package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k;
import l;
import m;

class ParseObject$37$2
  implements l<Void, m<Void>>
{
  ParseObject$37$2(ParseObject.37 param37, k paramk) {}
  
  public m<Void> then(m<Void> paramm)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((List)this.val$remaining.a()).iterator();
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = (ParseObject)localIterator.next();
      if (ParseObject.access$1400(localParseObject)) {
        localArrayList1.add(localParseObject);
      } else {
        localArrayList2.add(localParseObject);
      }
    }
    this.val$remaining.a(localArrayList2);
    if (localArrayList1.size() == 0) {
      throw new RuntimeException("Unable to save a PFObject with a relation to a cycle.");
    }
    m localm = m.a(null);
    if ((ParseUser.getCurrentUser() != null) && (ParseUser.getCurrentUser().isLazy()) && (localArrayList1.contains(ParseUser.getCurrentUser()))) {
      localm = localm.d(new ParseObject.37.2.2(this)).c(new ParseObject.37.2.1(this, localArrayList1));
    }
    return localm.d(new ParseObject.37.2.3(this, localArrayList1, new ArrayList()));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.37.2
 * JD-Core Version:    0.7.0.1
 */