package com.parse;

import l;
import m;

class ParseInstallation$3
  implements l<Boolean, Void>
{
  ParseInstallation$3(ParseInstallation paramParseInstallation) {}
  
  public Void then(m<Boolean> paramm)
  {
    Boolean localBoolean = (Boolean)paramm.e();
    if ((localBoolean == null) || (localBoolean.booleanValue())) {
      PushService.startServiceIfRequired(Parse.applicationContext);
    }
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseInstallation.3
 * JD-Core Version:    0.7.0.1
 */