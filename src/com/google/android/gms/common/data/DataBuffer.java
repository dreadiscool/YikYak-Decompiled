package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Releasable, Iterable<T>
{
  protected final DataHolder JG;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.JG = paramDataHolder;
    if (this.JG != null) {
      this.JG.e(this);
    }
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle gV()
  {
    return this.JG.gV();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.JG == null) {}
    for (int i = 0;; i = this.JG.getCount()) {
      return i;
    }
  }
  
  @Deprecated
  public boolean isClosed()
  {
    if (this.JG == null) {}
    for (boolean bool = true;; bool = this.JG.isClosed()) {
      return bool;
    }
  }
  
  public Iterator<T> iterator()
  {
    return new c(this);
  }
  
  public void release()
  {
    if (this.JG != null) {
      this.JG.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new h(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBuffer
 * JD-Core Version:    0.7.0.1
 */