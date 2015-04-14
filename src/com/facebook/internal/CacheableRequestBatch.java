package com.facebook.internal;

import com.facebook.Request;
import com.facebook.RequestBatch;

public class CacheableRequestBatch
  extends RequestBatch
{
  private String cacheKey;
  private boolean forceRoundTrip;
  
  public CacheableRequestBatch() {}
  
  public CacheableRequestBatch(Request... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public final String getCacheKeyOverride()
  {
    return this.cacheKey;
  }
  
  public final boolean getForceRoundTrip()
  {
    return this.forceRoundTrip;
  }
  
  public final void setCacheKeyOverride(String paramString)
  {
    this.cacheKey = paramString;
  }
  
  public final void setForceRoundTrip(boolean paramBoolean)
  {
    this.forceRoundTrip = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.CacheableRequestBatch
 * JD-Core Version:    0.7.0.1
 */