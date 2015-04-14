package com.parse;

import android.database.Cursor;
import l;
import m;

class OfflineStore$6
  implements l<String, m<Cursor>>
{
  OfflineStore$6(OfflineStore paramOfflineStore, boolean paramBoolean, ParseQuery paramParseQuery, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Cursor> then(m<String> paramm)
  {
    String str1 = (String)paramm.e();
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = "A.uuid";
    String str2 = "className=? AND key=?";
    if (!this.val$includeIsDeletingEventually) {
      str2 = str2 + " AND isDeletingEventually=0";
    }
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = this.val$query.getClassName();
    arrayOfString2[1] = str1;
    return this.val$db.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", arrayOfString1, str2, arrayOfString2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.6
 * JD-Core Version:    0.7.0.1
 */