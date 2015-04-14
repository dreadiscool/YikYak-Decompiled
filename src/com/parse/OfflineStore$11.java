package com.parse;

import android.database.Cursor;
import java.util.WeakHashMap;
import l;
import m;

class OfflineStore$11
  implements l<Cursor, String>
{
  OfflineStore$11(OfflineStore paramOfflineStore, ParseObject paramParseObject) {}
  
  public String then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    localCursor.moveToFirst();
    if (localCursor.isAfterLast()) {
      throw new ParseException(120, "This object is not available in the offline cache.");
    }
    String str1 = localCursor.getString(0);
    String str2 = localCursor.getString(1);
    synchronized (OfflineStore.access$300(this.this$0))
    {
      OfflineStore.access$500(this.this$0).put(this.val$object, m.a(str2));
      OfflineStore.access$400(this.this$0).put(str2, this.val$object);
      return str1;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.11
 * JD-Core Version:    0.7.0.1
 */