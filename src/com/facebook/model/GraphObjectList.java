package com.facebook.model;

import java.util.List;
import org.json.JSONArray;

public abstract interface GraphObjectList<T>
  extends List<T>
{
  public abstract <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> paramClass);
  
  public abstract JSONArray getInnerJSONArray();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObjectList
 * JD-Core Version:    0.7.0.1
 */