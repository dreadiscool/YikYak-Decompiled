package com.parse;

import java.util.ArrayList;
import java.util.List;
import l;
import m;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseObject$37$2$3$1$1$1
  implements l<JSONArray, m<Void>>
{
  ParseObject$37$2$3$1$1$1(ParseObject.37.2.3.1.1 param1) {}
  
  public m<Void> then(m<JSONArray> paramm)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < this.this$4.this$3.this$2.val$current.size(); i++)
    {
      JSONObject localJSONObject = ((JSONArray)paramm.e()).getJSONObject(i);
      localArrayList.add(((ParseObject)this.this$4.this$3.this$2.val$current.get(i)).handleSaveResultAsync(localJSONObject, (ParseOperationSet)this.this$4.this$3.this$2.val$operations.get(i)));
    }
    return m.a(localArrayList).b(new ParseObject.37.2.3.1.1.1.1(this, localArrayList));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.37.2.3.1.1.1
 * JD-Core Version:    0.7.0.1
 */