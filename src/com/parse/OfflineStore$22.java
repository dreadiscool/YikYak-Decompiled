package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l;
import m;

class OfflineStore$22
  implements l<String, m<Void>>
{
  OfflineStore$22(OfflineStore paramOfflineStore, ArrayList paramArrayList, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<String> paramm)
  {
    String str = (String)paramm.e();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.val$objectsInTree.iterator();
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = (ParseObject)localIterator.next();
      localArrayList.add(OfflineStore.access$800(this.this$0, str, localParseObject, this.val$db));
    }
    return m.a(localArrayList);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.22
 * JD-Core Version:    0.7.0.1
 */