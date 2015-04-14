package com.facebook.model;

import java.util.Map;
import org.json.JSONObject;

public abstract interface GraphObject
{
  public abstract Map<String, Object> asMap();
  
  public abstract <T extends GraphObject> T cast(Class<T> paramClass);
  
  public abstract JSONObject getInnerJSONObject();
  
  public abstract Object getProperty(String paramString);
  
  public abstract <T extends GraphObject> T getPropertyAs(String paramString, Class<T> paramClass);
  
  public abstract <T extends GraphObject> GraphObjectList<T> getPropertyAsList(String paramString, Class<T> paramClass);
  
  public abstract void removeProperty(String paramString);
  
  public abstract void setProperty(String paramString, Object paramObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject
 * JD-Core Version:    0.7.0.1
 */