package com.google.android.gms.common.data;

public abstract interface DataBufferObserver
{
  public abstract void onDataChanged();
  
  public abstract void onDataRangeChanged(int paramInt1, int paramInt2);
  
  public abstract void onDataRangeInserted(int paramInt1, int paramInt2);
  
  public abstract void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onDataRangeRemoved(int paramInt1, int paramInt2);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferObserver
 * JD-Core Version:    0.7.0.1
 */