package com.parse;

import java.util.Map;
import l;
import m;
import org.json.JSONObject;

class OfflineQueryLogic$20
  implements l<Void, m<Object>>
{
  OfflineQueryLogic$20(OfflineQueryLogic paramOfflineQueryLogic, Object paramObject, ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString) {}
  
  public m<Object> then(m<Void> paramm)
  {
    m localm;
    if ((this.val$container instanceof ParseObject)) {
      localm = OfflineQueryLogic.access$600(this.this$0, this.val$container, null, this.val$db).c(new OfflineQueryLogic.20.1(this));
    }
    for (;;)
    {
      return localm;
      if ((this.val$container instanceof Map)) {
        localm = m.a(((Map)this.val$container).get(this.val$key));
      } else if ((this.val$container instanceof JSONObject)) {
        localm = m.a(((JSONObject)this.val$container).opt(this.val$key));
      } else {
        localm = m.a(new IllegalStateException("include is invalid"));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.20
 * JD-Core Version:    0.7.0.1
 */