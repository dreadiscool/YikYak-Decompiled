package com.parse;

import java.util.List;

public abstract class FindCallback<T extends ParseObject>
  extends ParseCallback<List<T>>
{
  public abstract void done(List<T> paramList, ParseException paramParseException);
  
  final void internalDone(List<T> paramList, ParseException paramParseException)
  {
    done(paramList, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.FindCallback
 * JD-Core Version:    0.7.0.1
 */