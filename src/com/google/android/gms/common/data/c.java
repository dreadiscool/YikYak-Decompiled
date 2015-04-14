package com.google.android.gms.common.data;

import hZ;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> KW;
  protected int KX;
  
  public c(DataBuffer<T> paramDataBuffer)
  {
    this.KW = ((DataBuffer)hZ.a(paramDataBuffer));
    this.KX = -1;
  }
  
  public boolean hasNext()
  {
    if (this.KX < -1 + this.KW.getCount()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
    }
    DataBuffer localDataBuffer = this.KW;
    int i = 1 + this.KX;
    this.KX = i;
    return localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.c
 * JD-Core Version:    0.7.0.1
 */