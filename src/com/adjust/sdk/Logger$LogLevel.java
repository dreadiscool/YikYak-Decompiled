package com.adjust.sdk;

public enum Logger$LogLevel
{
  final int androidLogLevel;
  
  static
  {
    DEBUG = new LogLevel("DEBUG", 1, 3);
    INFO = new LogLevel("INFO", 2, 4);
    WARN = new LogLevel("WARN", 3, 5);
    ERROR = new LogLevel("ERROR", 4, 6);
    ASSERT = new LogLevel("ASSERT", 5, 7);
    LogLevel[] arrayOfLogLevel = new LogLevel[6];
    arrayOfLogLevel[0] = VERBOSE;
    arrayOfLogLevel[1] = DEBUG;
    arrayOfLogLevel[2] = INFO;
    arrayOfLogLevel[3] = WARN;
    arrayOfLogLevel[4] = ERROR;
    arrayOfLogLevel[5] = ASSERT;
    $VALUES = arrayOfLogLevel;
  }
  
  private Logger$LogLevel(int paramInt)
  {
    this.androidLogLevel = paramInt;
  }
  
  public int getAndroidLogLevel()
  {
    return this.androidLogLevel;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Logger.LogLevel
 * JD-Core Version:    0.7.0.1
 */