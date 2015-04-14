package com.facebook;

import java.io.Serializable;

class AppEventsLogger$AppEvent$SerializationProxyV1
  implements Serializable
{
  private static final long serialVersionUID = -2488473066578201069L;
  private final boolean isImplicit;
  private final String jsonString;
  
  private AppEventsLogger$AppEvent$SerializationProxyV1(String paramString, boolean paramBoolean)
  {
    this.jsonString = paramString;
    this.isImplicit = paramBoolean;
  }
  
  private Object readResolve()
  {
    return new AppEventsLogger.AppEvent(this.jsonString, this.isImplicit, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.AppEvent.SerializationProxyV1
 * JD-Core Version:    0.7.0.1
 */