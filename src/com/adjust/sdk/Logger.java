package com.adjust.sdk;

public abstract interface Logger
{
  public abstract void Assert(String paramString, Object... paramVarArgs);
  
  public abstract void debug(String paramString, Object... paramVarArgs);
  
  public abstract void error(String paramString, Object... paramVarArgs);
  
  public abstract void info(String paramString, Object... paramVarArgs);
  
  public abstract void setLogLevel(Logger.LogLevel paramLogLevel);
  
  public abstract void setLogLevelString(String paramString);
  
  public abstract void verbose(String paramString, Object... paramVarArgs);
  
  public abstract void warn(String paramString, Object... paramVarArgs);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Logger
 * JD-Core Version:    0.7.0.1
 */