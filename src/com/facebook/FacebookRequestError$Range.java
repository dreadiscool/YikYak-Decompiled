package com.facebook;

class FacebookRequestError$Range
{
  private final int end;
  private final int start;
  
  private FacebookRequestError$Range(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  boolean contains(int paramInt)
  {
    if ((this.start <= paramInt) && (paramInt <= this.end)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookRequestError.Range
 * JD-Core Version:    0.7.0.1
 */