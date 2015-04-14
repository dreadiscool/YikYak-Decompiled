package com.parse;

import java.util.concurrent.Callable;

final class GcmRegistrar$1
  implements Callable<Void>
{
  public Void call()
  {
    GcmRegistrar.getInstance().update();
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GcmRegistrar.1
 * JD-Core Version:    0.7.0.1
 */