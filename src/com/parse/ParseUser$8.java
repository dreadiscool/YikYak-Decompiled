package com.parse;

import l;
import m;
import org.json.JSONObject;

final class ParseUser$8
  implements l<Object, m<ParseUser>>
{
  public m<ParseUser> then(m<Object> paramm)
  {
    if (paramm.e() == JSONObject.NULL) {
      throw new ParseException(101, "invalid login credentials");
    }
    ParseUser localParseUser = (ParseUser)ParseObject.fromJSON((JSONObject)paramm.e(), "_User", true);
    return ParseUser.access$000(localParseUser).b(new ParseUser.8.1(this, localParseUser));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.8
 * JD-Core Version:    0.7.0.1
 */