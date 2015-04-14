package com.google.android.gms.common.api;

public class BaseImplementation
{
  static void a(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        new StringBuilder().append("Unable to release ").append(paramResult).toString();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BaseImplementation
 * JD-Core Version:    0.7.0.1
 */