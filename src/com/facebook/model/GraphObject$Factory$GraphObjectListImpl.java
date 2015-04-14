package com.facebook.model;

import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Validate;
import java.util.AbstractList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;

final class GraphObject$Factory$GraphObjectListImpl<T>
  extends AbstractList<T>
  implements GraphObjectList<T>
{
  private final Class<?> itemType;
  private final JSONArray state;
  
  public GraphObject$Factory$GraphObjectListImpl(JSONArray paramJSONArray, Class<?> paramClass)
  {
    Validate.notNull(paramJSONArray, "state");
    Validate.notNull(paramClass, "itemType");
    this.state = paramJSONArray;
    this.itemType = paramClass;
  }
  
  private void checkIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.state.length())) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  private void put(int paramInt, T paramT)
  {
    Object localObject = GraphObject.Factory.access$200(paramT);
    try
    {
      this.state.put(paramInt, localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalArgumentException(localJSONException);
    }
  }
  
  public void add(int paramInt, T paramT)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt < size()) {
      throw new UnsupportedOperationException("Only adding items at the end of the list is supported.");
    }
    put(paramInt, paramT);
  }
  
  public final <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> paramClass)
  {
    if (GraphObject.class.isAssignableFrom(this.itemType))
    {
      if (paramClass.isAssignableFrom(this.itemType)) {}
      for (;;)
      {
        return this;
        this = GraphObject.Factory.createList(this.state, paramClass);
      }
    }
    throw new FacebookGraphObjectException("Can't cast GraphObjectCollection of non-GraphObject type " + this.itemType);
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {}
    for (;;)
    {
      return bool;
      if (this == paramObject)
      {
        bool = true;
      }
      else if (getClass() == paramObject.getClass())
      {
        GraphObjectListImpl localGraphObjectListImpl = (GraphObjectListImpl)paramObject;
        bool = this.state.equals(localGraphObjectListImpl.state);
      }
    }
  }
  
  public T get(int paramInt)
  {
    checkIndex(paramInt);
    return GraphObject.Factory.coerceValueToExpectedType(this.state.opt(paramInt), this.itemType, null);
  }
  
  public final JSONArray getInnerJSONArray()
  {
    return this.state;
  }
  
  public int hashCode()
  {
    return this.state.hashCode();
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public T set(int paramInt, T paramT)
  {
    checkIndex(paramInt);
    Object localObject = get(paramInt);
    put(paramInt, paramT);
    return localObject;
  }
  
  public int size()
  {
    return this.state.length();
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.itemType.getSimpleName();
    arrayOfObject[1] = this.state;
    return String.format("GraphObjectList{itemType=%s, state=%s}", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject.Factory.GraphObjectListImpl
 * JD-Core Version:    0.7.0.1
 */