package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException
  extends Exception
{
  public final int errorCode;
  
  public GooglePlayServicesNotAvailableException(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesNotAvailableException
 * JD-Core Version:    0.7.0.1
 */