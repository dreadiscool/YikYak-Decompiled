package com.parse;

import java.util.List;
import l;
import m;

class OfflineStore$5
  implements l<ParseSQLiteDatabase, m<List<T>>>
{
  OfflineStore$5(OfflineStore paramOfflineStore, ParseQuery paramParseQuery, ParseUser paramParseUser, ParsePin paramParsePin, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public m<List<T>> then(m<ParseSQLiteDatabase> paramm)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = (ParseSQLiteDatabase)paramm.e();
    return this.this$0.findAsync(this.val$query, this.val$user, this.val$pin, this.val$isCount, this.val$includeIsDeletingEventually, this.val$ignoreACLs, localParseSQLiteDatabase).b(new OfflineStore.5.1(this, localParseSQLiteDatabase));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.5
 * JD-Core Version:    0.7.0.1
 */