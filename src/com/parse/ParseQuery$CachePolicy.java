package com.parse;

public enum ParseQuery$CachePolicy
{
  static
  {
    CACHE_ONLY = new CachePolicy("CACHE_ONLY", 1);
    NETWORK_ONLY = new CachePolicy("NETWORK_ONLY", 2);
    CACHE_ELSE_NETWORK = new CachePolicy("CACHE_ELSE_NETWORK", 3);
    NETWORK_ELSE_CACHE = new CachePolicy("NETWORK_ELSE_CACHE", 4);
    CACHE_THEN_NETWORK = new CachePolicy("CACHE_THEN_NETWORK", 5);
    CachePolicy[] arrayOfCachePolicy = new CachePolicy[6];
    arrayOfCachePolicy[0] = IGNORE_CACHE;
    arrayOfCachePolicy[1] = CACHE_ONLY;
    arrayOfCachePolicy[2] = NETWORK_ONLY;
    arrayOfCachePolicy[3] = CACHE_ELSE_NETWORK;
    arrayOfCachePolicy[4] = NETWORK_ELSE_CACHE;
    arrayOfCachePolicy[5] = CACHE_THEN_NETWORK;
    $VALUES = arrayOfCachePolicy;
  }
  
  private ParseQuery$CachePolicy() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.CachePolicy
 * JD-Core Version:    0.7.0.1
 */