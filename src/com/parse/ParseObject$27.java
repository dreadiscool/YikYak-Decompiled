package com.parse;

import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class ParseObject$27
  implements Callable<ParseCommand>
{
  ParseObject$27(ParseObject paramParseObject, String paramString) {}
  
  public ParseCommand call()
  {
    synchronized (this.this$0.mutex)
    {
      ParseCommand localParseCommand = new ParseCommand("get", this.val$sessionToken);
      localParseCommand.enableRetrying();
      localParseCommand.put("classname", ParseObject.access$900(this.this$0));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("objectId", ParseObject.access$000(this.this$0));
        localParseCommand.put("data", localJSONObject);
        return localParseCommand;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException.getMessage());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.27
 * JD-Core Version:    0.7.0.1
 */