package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ParseMulticastDelegate<T>
{
  private final List<ParseCallback<T>> callbacks = new LinkedList();
  
  public void clear()
  {
    this.callbacks.clear();
  }
  
  public void invoke(T paramT, ParseException paramParseException)
  {
    Iterator localIterator = new ArrayList(this.callbacks).iterator();
    while (localIterator.hasNext()) {
      ((ParseCallback)localIterator.next()).internalDone(paramT, paramParseException);
    }
  }
  
  public void subscribe(ParseCallback<T> paramParseCallback)
  {
    this.callbacks.add(paramParseCallback);
  }
  
  public void unsubscribe(ParseCallback<T> paramParseCallback)
  {
    this.callbacks.remove(paramParseCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseMulticastDelegate
 * JD-Core Version:    0.7.0.1
 */