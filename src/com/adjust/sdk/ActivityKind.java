package com.adjust.sdk;

public enum ActivityKind
{
  static
  {
    SESSION = new ActivityKind("SESSION", 1);
    EVENT = new ActivityKind("EVENT", 2);
    REVENUE = new ActivityKind("REVENUE", 3);
    REATTRIBUTION = new ActivityKind("REATTRIBUTION", 4);
    ActivityKind[] arrayOfActivityKind = new ActivityKind[5];
    arrayOfActivityKind[0] = UNKNOWN;
    arrayOfActivityKind[1] = SESSION;
    arrayOfActivityKind[2] = EVENT;
    arrayOfActivityKind[3] = REVENUE;
    arrayOfActivityKind[4] = REATTRIBUTION;
    $VALUES = arrayOfActivityKind;
  }
  
  private ActivityKind() {}
  
  public static ActivityKind fromString(String paramString)
  {
    ActivityKind localActivityKind;
    if ("session".equals(paramString)) {
      localActivityKind = SESSION;
    }
    for (;;)
    {
      return localActivityKind;
      if ("event".equals(paramString)) {
        localActivityKind = EVENT;
      } else if ("revenue".equals(paramString)) {
        localActivityKind = REVENUE;
      } else if ("reattribution".equals(paramString)) {
        localActivityKind = REATTRIBUTION;
      } else {
        localActivityKind = UNKNOWN;
      }
    }
  }
  
  public String toString()
  {
    String str;
    switch (ActivityKind.1.$SwitchMap$com$adjust$sdk$ActivityKind[ordinal()])
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      return str;
      str = "session";
      continue;
      str = "event";
      continue;
      str = "revenue";
      continue;
      str = "reattribution";
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityKind
 * JD-Core Version:    0.7.0.1
 */