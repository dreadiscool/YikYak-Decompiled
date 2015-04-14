package com.parse;

import android.database.Cursor;
import java.util.WeakHashMap;
import l;
import m;

class OfflineStore$3
  implements l<Cursor, T>
{
  OfflineStore$3(OfflineStore paramOfflineStore, String paramString) {}
  
  public T then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    localCursor.moveToFirst();
    if (localCursor.isAfterLast()) {
      throw new IllegalStateException("Attempted to find non-existent uuid " + this.val$uuid);
    }
    ParseObject localParseObject;
    synchronized (OfflineStore.access$300(this.this$0))
    {
      localParseObject = (ParseObject)OfflineStore.access$400(this.this$0).get(this.val$uuid);
      if (localParseObject == null)
      {
        String str1 = localCursor.getString(0);
        String str2 = localCursor.getString(1);
        localParseObject = ParseObject.createWithoutData(str1, str2);
        if (str2 == null)
        {
          OfflineStore.access$400(this.this$0).put(this.val$uuid, localParseObject);
          OfflineStore.access$500(this.this$0).put(localParseObject, m.a(this.val$uuid));
        }
      }
    }
    return localParseObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.3
 * JD-Core Version:    0.7.0.1
 */