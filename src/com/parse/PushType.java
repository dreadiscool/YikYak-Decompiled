package com.parse;

 enum PushType
{
  private final String pushType;
  
  static
  {
    GCM = new PushType("GCM", 2, "gcm");
    PushType[] arrayOfPushType = new PushType[3];
    arrayOfPushType[0] = NONE;
    arrayOfPushType[1] = PPNS;
    arrayOfPushType[2] = GCM;
    $VALUES = arrayOfPushType;
  }
  
  private PushType(String paramString)
  {
    this.pushType = paramString;
  }
  
  static PushType fromString(String paramString)
  {
    PushType localPushType;
    if ("none".equals(paramString)) {
      localPushType = NONE;
    }
    for (;;)
    {
      return localPushType;
      if ("ppns".equals(paramString)) {
        localPushType = PPNS;
      } else if ("gcm".equals(paramString)) {
        localPushType = GCM;
      } else {
        localPushType = null;
      }
    }
  }
  
  public String toString()
  {
    return this.pushType;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushType
 * JD-Core Version:    0.7.0.1
 */