package com.google.android.gms.common.data;

public abstract interface Freezable<T>
{
  public abstract T freeze();
  
  public abstract boolean isDataValid();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.Freezable
 * JD-Core Version:    0.7.0.1
 */