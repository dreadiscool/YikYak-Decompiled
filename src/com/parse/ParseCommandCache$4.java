package com.parse;

import l;
import m;
import org.json.JSONObject;
import y;

class ParseCommandCache$4
  implements l<Object, m<Object>>
{
  ParseCommandCache$4(ParseCommandCache paramParseCommandCache, y paramy, String paramString) {}
  
  public m<Object> then(m<Object> paramm)
  {
    Exception localException = paramm.f();
    if (localException != null) {
      if ((!(localException instanceof ParseException)) || (((ParseException)localException).getCode() != 100)) {}
    }
    for (;;)
    {
      return paramm;
      if (this.val$tcs != null)
      {
        this.val$tcs.b(localException);
        continue;
        Object localObject = paramm.e();
        if (this.val$tcs != null)
        {
          this.val$tcs.b(localObject);
        }
        else if ((this.val$localId != null) && ((localObject instanceof JSONObject)) && (((JSONObject)localObject).has("data")) && (((JSONObject)localObject).getJSONObject("data").has("objectId")))
        {
          String str = ((JSONObject)localObject).getJSONObject("data").getString("objectId");
          LocalIdManager.getDefaultInstance().setObjectId(this.val$localId, str);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseCommandCache.4
 * JD-Core Version:    0.7.0.1
 */