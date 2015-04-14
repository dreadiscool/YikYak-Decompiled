package com.facebook.model;

import com.facebook.FacebookGraphObjectException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

abstract class GraphObject$Factory$ProxyBase<STATE>
  implements InvocationHandler
{
  private static final String EQUALS_METHOD = "equals";
  private static final String TOSTRING_METHOD = "toString";
  protected final STATE state;
  
  protected GraphObject$Factory$ProxyBase(STATE paramSTATE)
  {
    this.state = paramSTATE;
  }
  
  protected final Object proxyObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Object localObject2;
    Object localObject1;
    if (str.equals("equals"))
    {
      localObject2 = paramArrayOfObject[0];
      if (localObject2 == null) {
        localObject1 = Boolean.valueOf(false);
      }
    }
    for (;;)
    {
      return localObject1;
      InvocationHandler localInvocationHandler = Proxy.getInvocationHandler(localObject2);
      if (!(localInvocationHandler instanceof GraphObject.Factory.GraphObjectProxy))
      {
        localObject1 = Boolean.valueOf(false);
      }
      else
      {
        GraphObject.Factory.GraphObjectProxy localGraphObjectProxy = (GraphObject.Factory.GraphObjectProxy)localInvocationHandler;
        localObject1 = Boolean.valueOf(this.state.equals(localGraphObjectProxy.state));
        continue;
        if (str.equals("toString")) {
          localObject1 = toString();
        } else {
          localObject1 = paramMethod.invoke(this.state, paramArrayOfObject);
        }
      }
    }
  }
  
  protected final Object throwUnexpectedMethodSignature(Method paramMethod)
  {
    throw new FacebookGraphObjectException(getClass().getName() + " got an unexpected method signature: " + paramMethod.toString());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject.Factory.ProxyBase
 * JD-Core Version:    0.7.0.1
 */