package com.parse;

import android.content.ContentValues;
import k;
import l;
import m;
import org.json.JSONObject;

class OfflineStore$35
  implements l<Void, m<Void>>
{
  OfflineStore$35(OfflineStore paramOfflineStore, ParseObject paramParseObject, k paramk1, k paramk2, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Void> paramm)
  {
    String str1 = this.val$object.getClassName();
    String str2 = this.val$object.getObjectId();
    String str3 = ((JSONObject)this.val$jsonObject.a()).toString();
    int i = ((JSONObject)this.val$jsonObject.a()).getInt("isDeletingEventually");
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("className", str1);
    localContentValues.put("json", str3);
    if (str2 != null) {
      localContentValues.put("objectId", str2);
    }
    localContentValues.put("isDeletingEventually", Integer.valueOf(i));
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ((String)this.val$uuid.a());
    return this.val$db.updateAsync("ParseObjects", localContentValues, "uuid = ?", arrayOfString).j();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.35
 * JD-Core Version:    0.7.0.1
 */