package com.parse;

import java.util.List;
import l;
import m;
import org.json.JSONArray;

class ParseObject$37$2$3$1$1
  implements l<Void, m<Void>>
{
  ParseObject$37$2$3$1$1(ParseObject.37.2.3.1 param1) {}
  
  public m<Void> then(m<Void> paramm)
  {
    JSONArray localJSONArray = new JSONArray();
    for (int i = 0; i < this.this$3.this$2.val$current.size(); i++) {
      localJSONArray.put(((ParseObject)this.this$3.this$2.val$current.get(i)).constructSaveCommand((ParseOperationSet)this.this$3.this$2.val$operations.get(i), PointerEncodingStrategy.get(), this.this$3.this$2.this$1.this$0.val$sessionToken).toJSONObject());
    }
    ParseCommand localParseCommand = new ParseCommand("multi", this.this$3.this$2.this$1.this$0.val$sessionToken);
    localParseCommand.put("commands", localJSONArray);
    return localParseCommand.executeAsync().i().d(new ParseObject.37.2.3.1.1.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.37.2.3.1.1
 * JD-Core Version:    0.7.0.1
 */