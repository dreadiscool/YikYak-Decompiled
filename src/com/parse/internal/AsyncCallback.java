package com.parse.internal;

public abstract interface AsyncCallback
{
  public abstract void onCancel();
  
  public abstract void onFailure(Throwable paramThrowable);
  
  public abstract void onSuccess(Object paramObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.internal.AsyncCallback
 * JD-Core Version:    0.7.0.1
 */