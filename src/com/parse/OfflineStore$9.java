package com.parse;

import android.database.Cursor;
import k;
import l;
import m;

class OfflineStore$9
  implements l<Cursor, String>
{
  OfflineStore$9(OfflineStore paramOfflineStore, k paramk) {}
  
  public String then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    localCursor.moveToFirst();
    if (localCursor.isAfterLast()) {
      throw new IllegalStateException("Attempted to find non-existent uuid " + (String)this.val$uuid.a());
    }
    return localCursor.getString(0);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.9
 * JD-Core Version:    0.7.0.1
 */