package com.parse;

import java.util.Iterator;
import java.util.List;
import l;
import m;
import org.json.JSONArray;

class ParseObject$34$1$1
  implements l<Void, m<Void>>
{
  ParseObject$34$1$1(ParseObject.34.1 param1) {}
  
  public m<Void> then(m<Void> paramm)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.this$1.this$0.val$uniqueObjects.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(ParseObject.access$1200((ParseObject)localIterator.next(), true, this.this$1.this$0.val$sessionToken).toJSONObject());
    }
    ParseCommand localParseCommand = new ParseCommand("multi", this.this$1.this$0.val$sessionToken);
    localParseCommand.put("commands", localJSONArray);
    return localParseCommand.executeAsync().j();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.34.1.1
 * JD-Core Version:    0.7.0.1
 */