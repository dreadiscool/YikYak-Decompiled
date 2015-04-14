package com.parse;

import l;
import m;

final class ParseUser$11
  implements l<Void, m<Void>>
{
  ParseUser$11(ParseUser paramParseUser) {}
  
  public m<Void> then(m<Void> paramm)
  {
    this.val$user.saveToDisk(Parse.applicationContext, "currentUser");
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.11
 * JD-Core Version:    0.7.0.1
 */