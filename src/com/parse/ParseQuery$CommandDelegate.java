package com.parse;

import m;

abstract interface ParseQuery$CommandDelegate<T>
{
  public abstract m<T> runFromCacheAsync();
  
  public abstract m<T> runOnNetworkAsync(boolean paramBoolean);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.CommandDelegate
 * JD-Core Version:    0.7.0.1
 */