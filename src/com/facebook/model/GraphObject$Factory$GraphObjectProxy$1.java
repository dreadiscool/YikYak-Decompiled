package com.facebook.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class GraphObject$Factory$GraphObjectProxy$1
  implements ParameterizedType
{
  GraphObject$Factory$GraphObjectProxy$1(GraphObject.Factory.GraphObjectProxy paramGraphObjectProxy, Class paramClass) {}
  
  public Type[] getActualTypeArguments()
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = this.val$expectedType;
    return arrayOfType;
  }
  
  public Type getOwnerType()
  {
    return null;
  }
  
  public Type getRawType()
  {
    return GraphObjectList.class;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject.Factory.GraphObjectProxy.1
 * JD-Core Version:    0.7.0.1
 */