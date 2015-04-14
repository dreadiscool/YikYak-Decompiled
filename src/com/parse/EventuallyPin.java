package com.parse;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import m;
import org.json.JSONObject;

@ParseClassName("_EventuallyPin")
class EventuallyPin
  extends ParseObject
{
  public static final String PIN_NAME = "_eventuallyPin";
  public static final int TYPE_COMMAND = 3;
  public static final int TYPE_DELETE = 2;
  public static final int TYPE_SAVE = 1;
  
  public EventuallyPin()
  {
    super("_EventuallyPin");
  }
  
  public static m<List<EventuallyPin>> findAllPinned()
  {
    return findAllPinned(null);
  }
  
  public static m<List<EventuallyPin>> findAllPinned(Collection<String> paramCollection)
  {
    ParseQuery localParseQuery = new ParseQuery(EventuallyPin.class).fromPin("_eventuallyPin", true).orderByAscending("time");
    if (paramCollection != null) {
      localParseQuery.whereNotContainedIn("uuid", paramCollection);
    }
    return localParseQuery.findInBackground((ParseUser)null).b(new EventuallyPin.2());
  }
  
  private static m<EventuallyPin> pinEventuallyCommand(int paramInt, ParseObject paramParseObject, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    EventuallyPin localEventuallyPin = new EventuallyPin();
    localEventuallyPin.put("uuid", UUID.randomUUID().toString());
    localEventuallyPin.put("time", new Date());
    localEventuallyPin.put("type", Integer.valueOf(paramInt));
    if (paramParseObject != null) {
      localEventuallyPin.put("object", paramParseObject);
    }
    if (paramString1 != null) {
      localEventuallyPin.put("operationSetUUID", paramString1);
    }
    if (paramString2 != null) {
      localEventuallyPin.put("sessionToken", paramString2);
    }
    if (paramJSONObject != null) {
      localEventuallyPin.put("command", paramJSONObject);
    }
    return localEventuallyPin.pinInBackground("_eventuallyPin").a(new EventuallyPin.1(localEventuallyPin));
  }
  
  public static m<EventuallyPin> pinEventuallyCommand(ParseObject paramParseObject, ParseCommand paramParseCommand)
  {
    String str = paramParseCommand.getOp();
    JSONObject localJSONObject = null;
    int i;
    if ((str.equals("create")) || (str.equals("update"))) {
      i = 1;
    }
    for (;;)
    {
      return pinEventuallyCommand(i, paramParseObject, paramParseCommand.getOperationSetUUID(), paramParseCommand.getSessionToken(), localJSONObject);
      if (str.equals("delete"))
      {
        i = 2;
      }
      else
      {
        i = 3;
        localJSONObject = paramParseCommand.toJSONObject();
      }
    }
  }
  
  public ParseCommand getCommand()
  {
    return new ParseCommand(getJSONObject("command"));
  }
  
  public ParseObject getObject()
  {
    return getParseObject("object");
  }
  
  public String getOperationSetUUID()
  {
    return getString("operationSetUUID");
  }
  
  public String getSessionToken()
  {
    return getString("sessionToken");
  }
  
  public int getType()
  {
    return getInt("type");
  }
  
  public String getUUID()
  {
    return getString("uuid");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.EventuallyPin
 * JD-Core Version:    0.7.0.1
 */