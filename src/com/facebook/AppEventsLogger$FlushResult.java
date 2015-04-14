package com.facebook;

 enum AppEventsLogger$FlushResult
{
  static
  {
    SERVER_ERROR = new FlushResult("SERVER_ERROR", 1);
    NO_CONNECTIVITY = new FlushResult("NO_CONNECTIVITY", 2);
    UNKNOWN_ERROR = new FlushResult("UNKNOWN_ERROR", 3);
    FlushResult[] arrayOfFlushResult = new FlushResult[4];
    arrayOfFlushResult[0] = SUCCESS;
    arrayOfFlushResult[1] = SERVER_ERROR;
    arrayOfFlushResult[2] = NO_CONNECTIVITY;
    arrayOfFlushResult[3] = UNKNOWN_ERROR;
    $VALUES = arrayOfFlushResult;
  }
  
  private AppEventsLogger$FlushResult() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.FlushResult
 * JD-Core Version:    0.7.0.1
 */