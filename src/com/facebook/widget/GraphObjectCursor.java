package com.facebook.widget;

import com.facebook.model.GraphObject;

abstract interface GraphObjectCursor<T extends GraphObject>
{
  public abstract boolean areMoreObjectsAvailable();
  
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract T getGraphObject();
  
  public abstract int getPosition();
  
  public abstract boolean isAfterLast();
  
  public abstract boolean isBeforeFirst();
  
  public abstract boolean isClosed();
  
  public abstract boolean isFirst();
  
  public abstract boolean isFromCache();
  
  public abstract boolean isLast();
  
  public abstract boolean move(int paramInt);
  
  public abstract boolean moveToFirst();
  
  public abstract boolean moveToLast();
  
  public abstract boolean moveToNext();
  
  public abstract boolean moveToPosition(int paramInt);
  
  public abstract boolean moveToPrevious();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.GraphObjectCursor
 * JD-Core Version:    0.7.0.1
 */