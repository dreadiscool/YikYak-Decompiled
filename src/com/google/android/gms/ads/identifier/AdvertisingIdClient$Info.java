package com.google.android.gms.ads.identifier;

public final class AdvertisingIdClient$Info
{
  private final String lx;
  private final boolean ly;
  
  public AdvertisingIdClient$Info(String paramString, boolean paramBoolean)
  {
    this.lx = paramString;
    this.ly = paramBoolean;
  }
  
  public String getId()
  {
    return this.lx;
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    return this.ly;
  }
  
  public String toString()
  {
    return "{" + this.lx + "}" + this.ly;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.Info
 * JD-Core Version:    0.7.0.1
 */