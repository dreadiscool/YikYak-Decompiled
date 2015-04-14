package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T>
  extends c<T>
{
  private T Lt;
  
  public h(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
    }
    this.KX = (1 + this.KX);
    if (this.KX == 0)
    {
      this.Lt = this.KW.get(0);
      if (!(this.Lt instanceof d)) {
        throw new IllegalStateException("DataBuffer reference of type " + this.Lt.getClass() + " is not movable");
      }
    }
    else
    {
      ((d)this.Lt).as(this.KX);
    }
    return this.Lt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.h
 * JD-Core Version:    0.7.0.1
 */