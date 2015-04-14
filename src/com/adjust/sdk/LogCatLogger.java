package com.adjust.sdk;

import android.util.Log;
import java.util.Locale;

public class LogCatLogger
  implements Logger
{
  private Logger.LogLevel logLevel;
  
  public LogCatLogger()
  {
    setLogLevel(Logger.LogLevel.INFO);
  }
  
  public void Assert(String paramString, Object... paramVarArgs)
  {
    Log.println(7, "Adjust", String.format(paramString, paramVarArgs));
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    if (this.logLevel.androidLogLevel <= 3) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    if (this.logLevel.androidLogLevel <= 6) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    if (this.logLevel.androidLogLevel <= 4) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public void setLogLevel(Logger.LogLevel paramLogLevel)
  {
    this.logLevel = paramLogLevel;
  }
  
  public void setLogLevelString(String paramString)
  {
    if (paramString != null) {}
    try
    {
      setLogLevel(Logger.LogLevel.valueOf(paramString.toUpperCase(Locale.US)));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        error("Malformed logLevel '%s', falling back to 'info'", arrayOfObject);
      }
    }
  }
  
  public void verbose(String paramString, Object... paramVarArgs)
  {
    if (this.logLevel.androidLogLevel <= 2) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    if (this.logLevel.androidLogLevel <= 5) {
      String.format(paramString, paramVarArgs);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.LogCatLogger
 * JD-Core Version:    0.7.0.1
 */