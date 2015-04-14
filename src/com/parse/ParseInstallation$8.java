package com.parse;

import l;
import m;

final class ParseInstallation$8
  implements l<Void, m<Void>>
{
  ParseInstallation$8(ParseInstallation paramParseInstallation) {}
  
  public m<Void> then(m<Void> paramm)
  {
    this.val$installation.saveToDisk(Parse.applicationContext, "currentInstallation");
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseInstallation.8
 * JD-Core Version:    0.7.0.1
 */