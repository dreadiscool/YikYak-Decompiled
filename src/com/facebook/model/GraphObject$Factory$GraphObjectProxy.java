package com.facebook.model;

import com.facebook.internal.Utility;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class GraphObject$Factory$GraphObjectProxy
  extends GraphObject.Factory.ProxyBase<JSONObject>
{
  private static final String CASTTOMAP_METHOD = "asMap";
  private static final String CAST_METHOD = "cast";
  private static final String CLEAR_METHOD = "clear";
  private static final String CONTAINSKEY_METHOD = "containsKey";
  private static final String CONTAINSVALUE_METHOD = "containsValue";
  private static final String ENTRYSET_METHOD = "entrySet";
  private static final String GETINNERJSONOBJECT_METHOD = "getInnerJSONObject";
  private static final String GETPROPERTYASLIST_METHOD = "getPropertyAsList";
  private static final String GETPROPERTYAS_METHOD = "getPropertyAs";
  private static final String GETPROPERTY_METHOD = "getProperty";
  private static final String GET_METHOD = "get";
  private static final String ISEMPTY_METHOD = "isEmpty";
  private static final String KEYSET_METHOD = "keySet";
  private static final String PUTALL_METHOD = "putAll";
  private static final String PUT_METHOD = "put";
  private static final String REMOVEPROPERTY_METHOD = "removeProperty";
  private static final String REMOVE_METHOD = "remove";
  private static final String SETPROPERTY_METHOD = "setProperty";
  private static final String SIZE_METHOD = "size";
  private static final String VALUES_METHOD = "values";
  private final Class<?> graphObjectClass;
  
  public GraphObject$Factory$GraphObjectProxy(JSONObject paramJSONObject, Class<?> paramClass)
  {
    super(paramJSONObject);
    this.graphObjectClass = paramClass;
  }
  
  private Object createGraphObjectsFromParameters(CreateGraphObject paramCreateGraphObject, Object paramObject)
  {
    String str;
    GraphObjectList localGraphObjectList;
    if ((paramCreateGraphObject != null) && (!Utility.isNullOrEmpty(paramCreateGraphObject.value())))
    {
      str = paramCreateGraphObject.value();
      if (!List.class.isAssignableFrom(paramObject.getClass())) {
        break label105;
      }
      localGraphObjectList = GraphObject.Factory.createList(GraphObject.class);
      Iterator localIterator = ((List)paramObject).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        GraphObject localGraphObject2 = GraphObject.Factory.create();
        localGraphObject2.setProperty(str, localObject);
        localGraphObjectList.add(localGraphObject2);
      }
    }
    label105:
    GraphObject localGraphObject1;
    for (paramObject = localGraphObjectList;; paramObject = localGraphObject1)
    {
      return paramObject;
      localGraphObject1 = GraphObject.Factory.create();
      localGraphObject1.setProperty(str, paramObject);
    }
  }
  
  private final Object proxyGraphObjectGettersAndSetters(Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    String str1 = paramMethod.getName();
    int i = paramMethod.getParameterTypes().length;
    PropertyName localPropertyName = (PropertyName)paramMethod.getAnnotation(PropertyName.class);
    String str2;
    Object localObject3;
    Class localClass;
    Type localType;
    if (localPropertyName != null)
    {
      str2 = localPropertyName.value();
      if (i != 0) {
        break label112;
      }
      localObject3 = ((JSONObject)this.state).opt(str2);
      localClass = paramMethod.getReturnType();
      localType = paramMethod.getGenericReturnType();
      if (!(localType instanceof ParameterizedType)) {
        break label166;
      }
    }
    label166:
    for (ParameterizedType localParameterizedType = (ParameterizedType)localType;; localParameterizedType = null)
    {
      localObject1 = GraphObject.Factory.coerceValueToExpectedType(localObject3, localClass, localParameterizedType);
      for (;;)
      {
        return localObject1;
        str2 = GraphObject.Factory.convertCamelCaseToLowercaseWithUnderscores(str1.substring(3));
        break;
        label112:
        if (i == 1)
        {
          Object localObject2 = GraphObject.Factory.access$200(createGraphObjectsFromParameters((CreateGraphObject)paramMethod.getAnnotation(CreateGraphObject.class), paramArrayOfObject[0]));
          ((JSONObject)this.state).putOpt(str2, localObject2);
        }
        else
        {
          localObject1 = throwUnexpectedMethodSignature(paramMethod);
        }
      }
    }
  }
  
  private final Object proxyGraphObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Class localClass;
    if (str.equals("cast"))
    {
      localClass = (Class)paramArrayOfObject[0];
      if ((localClass == null) || (!localClass.isAssignableFrom(this.graphObjectClass))) {}
    }
    for (;;)
    {
      return paramObject;
      paramObject = GraphObject.Factory.access$000(localClass, (JSONObject)this.state);
      continue;
      if (str.equals("getInnerJSONObject"))
      {
        paramObject = ((GraphObjectProxy)Proxy.getInvocationHandler(paramObject)).state;
      }
      else if (str.equals("asMap"))
      {
        paramObject = GraphObject.Factory.access$100((JSONObject)this.state);
      }
      else if (str.equals("getProperty"))
      {
        paramObject = ((JSONObject)this.state).opt((String)paramArrayOfObject[0]);
      }
      else if (str.equals("getPropertyAs"))
      {
        paramObject = GraphObject.Factory.coerceValueToExpectedType(((JSONObject)this.state).opt((String)paramArrayOfObject[0]), (Class)paramArrayOfObject[1], null);
      }
      else if (str.equals("getPropertyAsList"))
      {
        paramObject = GraphObject.Factory.coerceValueToExpectedType(((JSONObject)this.state).opt((String)paramArrayOfObject[0]), GraphObjectList.class, new GraphObject.Factory.GraphObjectProxy.1(this, (Class)paramArrayOfObject[1]));
      }
      else if (str.equals("setProperty"))
      {
        paramObject = setJSONProperty(paramArrayOfObject);
      }
      else if (str.equals("removeProperty"))
      {
        ((JSONObject)this.state).remove((String)paramArrayOfObject[0]);
        paramObject = null;
      }
      else
      {
        paramObject = throwUnexpectedMethodSignature(paramMethod);
      }
    }
  }
  
  private final Object proxyMapMethods(Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Object localObject;
    if (str.equals("clear"))
    {
      JsonUtil.jsonObjectClear((JSONObject)this.state);
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      if (str.equals("containsKey"))
      {
        localObject = Boolean.valueOf(((JSONObject)this.state).has((String)paramArrayOfObject[0]));
      }
      else if (str.equals("containsValue"))
      {
        localObject = Boolean.valueOf(JsonUtil.jsonObjectContainsValue((JSONObject)this.state, paramArrayOfObject[0]));
      }
      else if (str.equals("entrySet"))
      {
        localObject = JsonUtil.jsonObjectEntrySet((JSONObject)this.state);
      }
      else if (str.equals("get"))
      {
        localObject = ((JSONObject)this.state).opt((String)paramArrayOfObject[0]);
      }
      else
      {
        if (str.equals("isEmpty"))
        {
          if (((JSONObject)this.state).length() == 0) {}
          for (boolean bool = true;; bool = false)
          {
            localObject = Boolean.valueOf(bool);
            break;
          }
        }
        if (str.equals("keySet"))
        {
          localObject = JsonUtil.jsonObjectKeySet((JSONObject)this.state);
        }
        else if (str.equals("put"))
        {
          localObject = setJSONProperty(paramArrayOfObject);
        }
        else if (str.equals("putAll"))
        {
          if ((paramArrayOfObject[0] instanceof Map)) {}
          for (Map localMap = (Map)paramArrayOfObject[0];; localMap = ((GraphObject)paramArrayOfObject[0]).asMap())
          {
            JsonUtil.jsonObjectPutAll((JSONObject)this.state, localMap);
            localObject = null;
            break;
            if (!(paramArrayOfObject[0] instanceof GraphObject)) {
              break label300;
            }
          }
          label300:
          localObject = null;
        }
        else if (str.equals("remove"))
        {
          ((JSONObject)this.state).remove((String)paramArrayOfObject[0]);
          localObject = null;
        }
        else if (str.equals("size"))
        {
          localObject = Integer.valueOf(((JSONObject)this.state).length());
        }
        else if (str.equals("values"))
        {
          localObject = JsonUtil.jsonObjectValues((JSONObject)this.state);
        }
        else
        {
          localObject = throwUnexpectedMethodSignature(paramMethod);
        }
      }
    }
  }
  
  private Object setJSONProperty(Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    Object localObject = GraphObject.Factory.access$200(paramArrayOfObject[1]);
    try
    {
      ((JSONObject)this.state).putOpt(str, localObject);
      return null;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalArgumentException(localJSONException);
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Class localClass = paramMethod.getDeclaringClass();
    Object localObject;
    if (localClass == Object.class) {
      localObject = proxyObjectMethods(paramObject, paramMethod, paramArrayOfObject);
    }
    for (;;)
    {
      return localObject;
      if (localClass == Map.class) {
        localObject = proxyMapMethods(paramMethod, paramArrayOfObject);
      } else if (localClass == GraphObject.class) {
        localObject = proxyGraphObjectMethods(paramObject, paramMethod, paramArrayOfObject);
      } else if (GraphObject.class.isAssignableFrom(localClass)) {
        localObject = proxyGraphObjectGettersAndSetters(paramMethod, paramArrayOfObject);
      } else {
        localObject = throwUnexpectedMethodSignature(paramMethod);
      }
    }
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.graphObjectClass.getSimpleName();
    arrayOfObject[1] = this.state;
    return String.format("GraphObject{graphObjectClass=%s, state=%s}", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject.Factory.GraphObjectProxy
 * JD-Core Version:    0.7.0.1
 */