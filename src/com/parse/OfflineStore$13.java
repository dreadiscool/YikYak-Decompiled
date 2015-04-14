package com.parse;

import java.util.HashMap;
import java.util.Map;
import l;
import m;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineStore$13
  implements l<String, m<Void>>
{
  OfflineStore$13(OfflineStore paramOfflineStore, ParseSQLiteDatabase paramParseSQLiteDatabase, ParseObject paramParseObject) {}
  
  public m<Void> then(m<String> paramm)
  {
    String str = (String)paramm.e();
    m localm;
    if (str == null) {
      localm = m.a(new ParseException(120, "Attempted to fetch an object offline which was never saved to the offline cache."));
    }
    for (;;)
    {
      return localm;
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        HashMap localHashMap = new HashMap();
        new OfflineStore.13.1(this, localHashMap).setTraverseParseObjects(false).setYieldRoot(false).traverse(localJSONObject);
        localm = m.a(localHashMap.values()).c(new OfflineStore.13.2(this, localJSONObject, localHashMap));
      }
      catch (JSONException localJSONException)
      {
        localm = m.a(localJSONException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.13
 * JD-Core Version:    0.7.0.1
 */