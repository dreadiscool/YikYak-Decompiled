package com.facebook;

public enum LoggingBehavior
{
  @Deprecated
  public static final LoggingBehavior INSIGHTS = APP_EVENTS;
  
  static
  {
    INCLUDE_ACCESS_TOKENS = new LoggingBehavior("INCLUDE_ACCESS_TOKENS", 1);
    INCLUDE_RAW_RESPONSES = new LoggingBehavior("INCLUDE_RAW_RESPONSES", 2);
    CACHE = new LoggingBehavior("CACHE", 3);
    APP_EVENTS = new LoggingBehavior("APP_EVENTS", 4);
    DEVELOPER_ERRORS = new LoggingBehavior("DEVELOPER_ERRORS", 5);
    LoggingBehavior[] arrayOfLoggingBehavior = new LoggingBehavior[6];
    arrayOfLoggingBehavior[0] = REQUESTS;
    arrayOfLoggingBehavior[1] = INCLUDE_ACCESS_TOKENS;
    arrayOfLoggingBehavior[2] = INCLUDE_RAW_RESPONSES;
    arrayOfLoggingBehavior[3] = CACHE;
    arrayOfLoggingBehavior[4] = APP_EVENTS;
    arrayOfLoggingBehavior[5] = DEVELOPER_ERRORS;
    $VALUES = arrayOfLoggingBehavior;
  }
  
  private LoggingBehavior() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.LoggingBehavior
 * JD-Core Version:    0.7.0.1
 */