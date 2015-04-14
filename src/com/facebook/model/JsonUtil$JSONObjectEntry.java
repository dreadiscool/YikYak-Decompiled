package com.facebook.model;

import android.annotation.SuppressLint;
import java.util.Map.Entry;

final class JsonUtil$JSONObjectEntry
  implements Map.Entry<String, Object>
{
  private final String key;
  private final Object value;
  
  JsonUtil$JSONObjectEntry(String paramString, Object paramObject)
  {
    this.key = paramString;
    this.value = paramObject;
  }
  
  @SuppressLint({"FieldGetter"})
  public String getKey()
  {
    return this.key;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("JSONObjectEntry is immutable");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.JsonUtil.JSONObjectEntry
 * JD-Core Version:    0.7.0.1
 */