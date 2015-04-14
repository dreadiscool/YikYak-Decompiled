package com.parse;

import java.util.List;

public abstract interface ParseQueryAdapter$OnQueryLoadListener<T extends ParseObject>
{
  public abstract void onLoaded(List<T> paramList, Exception paramException);
  
  public abstract void onLoading();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQueryAdapter.OnQueryLoadListener
 * JD-Core Version:    0.7.0.1
 */