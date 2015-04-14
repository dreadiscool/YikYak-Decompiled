package com.parse;

import java.util.Map;
import m;
import org.json.JSONObject;

public final class ParseCloud
{
  public static <T> T callFunction(String paramString, Map<String, ?> paramMap)
  {
    return Parse.waitForTask(callFunctionInBackground(paramString, paramMap));
  }
  
  public static <T> m<T> callFunctionInBackground(String paramString, Map<String, ?> paramMap)
  {
    return constructCallCommand(paramString, paramMap).executeAsync().c(new ParseCloud.1());
  }
  
  public static <T> void callFunctionInBackground(String paramString, Map<String, ?> paramMap, FunctionCallback<T> paramFunctionCallback)
  {
    Parse.callbackOnMainThreadAsync(callFunctionInBackground(paramString, paramMap), paramFunctionCallback);
  }
  
  private static ParseCommand constructCallCommand(String paramString, Map<String, ?> paramMap)
  {
    ParseCommand localParseCommand = new ParseCommand("client_function", ParseUser.getCurrentSessionToken());
    localParseCommand.put("data", (JSONObject)Parse.encode(paramMap, NoObjectsEncodingStrategy.get()));
    localParseCommand.put("function", paramString);
    return localParseCommand;
  }
  
  private static Object convertCloudResponse(Object paramObject)
  {
    Object localObject = new ParseDecoder().decode(paramObject);
    if (localObject == null) {}
    for (;;)
    {
      return paramObject;
      paramObject = localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseCloud
 * JD-Core Version:    0.7.0.1
 */