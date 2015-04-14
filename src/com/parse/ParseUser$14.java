package com.parse;

import java.util.Set;
import l;
import m;
import org.json.JSONException;
import org.json.JSONObject;

final class ParseUser$14
  implements l<Void, m<ParseUser>>
{
  ParseUser$14(String paramString, JSONObject paramJSONObject) {}
  
  public m<ParseUser> then(m<Void> paramm)
  {
    ParseUser localParseUser = (ParseUser)ParseObject.create(ParseUser.class);
    try
    {
      ParseUser.access$700(localParseUser).put(this.val$authType, this.val$authData);
      ParseUser.access$800(localParseUser).add(this.val$authType);
      ParseOperationSet localParseOperationSet = localParseUser.startSave();
      return ParseUser.access$900(localParseUser, localParseOperationSet).executeAsync().b(new ParseUser.14.3(this, localParseUser, localParseOperationSet)).b(new ParseUser.14.2(this, localParseUser)).a(new ParseUser.14.1(this, localParseUser));
    }
    catch (JSONException localJSONException)
    {
      throw new ParseException(localJSONException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.14
 * JD-Core Version:    0.7.0.1
 */