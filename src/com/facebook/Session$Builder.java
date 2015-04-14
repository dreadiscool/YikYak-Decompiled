package com.facebook;

import android.content.Context;

public final class Session$Builder
{
  private String applicationId;
  private final Context context;
  private TokenCachingStrategy tokenCachingStrategy;
  
  public Session$Builder(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public Session build()
  {
    return new Session(this.context, this.applicationId, this.tokenCachingStrategy);
  }
  
  public Builder setApplicationId(String paramString)
  {
    this.applicationId = paramString;
    return this;
  }
  
  public Builder setTokenCachingStrategy(TokenCachingStrategy paramTokenCachingStrategy)
  {
    this.tokenCachingStrategy = paramTokenCachingStrategy;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.Builder
 * JD-Core Version:    0.7.0.1
 */