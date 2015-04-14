package com.facebook.model;

import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Utility;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class GraphObject$Factory
{
  private static final SimpleDateFormat[] dateFormats;
  private static final HashSet<Class<?>> verifiedGraphObjectClasses = new HashSet();
  
  static
  {
    SimpleDateFormat[] arrayOfSimpleDateFormat = new SimpleDateFormat[3];
    arrayOfSimpleDateFormat[0] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
    arrayOfSimpleDateFormat[1] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    arrayOfSimpleDateFormat[2] = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    dateFormats = arrayOfSimpleDateFormat;
  }
  
  static <U> U coerceValueToExpectedType(Object paramObject, Class<U> paramClass, ParameterizedType paramParameterizedType)
  {
    if (paramObject == null) {
      if (Boolean.TYPE.equals(paramClass)) {
        paramObject = Boolean.valueOf(false);
      }
    }
    Class localClass1;
    for (;;)
    {
      return paramObject;
      if (Character.TYPE.equals(paramClass))
      {
        paramObject = Character.valueOf('\000');
      }
      else if (paramClass.isPrimitive())
      {
        paramObject = Integer.valueOf(0);
      }
      else
      {
        paramObject = null;
        continue;
        localClass1 = paramObject.getClass();
        if ((!paramClass.isAssignableFrom(localClass1)) && (!paramClass.isPrimitive())) {
          if (GraphObject.class.isAssignableFrom(paramClass))
          {
            if (JSONObject.class.isAssignableFrom(localClass1)) {
              paramObject = createGraphObjectProxy(paramClass, (JSONObject)paramObject);
            } else if (GraphObject.class.isAssignableFrom(localClass1)) {
              paramObject = ((GraphObject)paramObject).cast(paramClass);
            } else {
              throw new FacebookGraphObjectException("Can't create GraphObject from " + localClass1.getName());
            }
          }
          else if ((Iterable.class.equals(paramClass)) || (Collection.class.equals(paramClass)) || (List.class.equals(paramClass)) || (GraphObjectList.class.equals(paramClass)))
          {
            if (paramParameterizedType == null) {
              throw new FacebookGraphObjectException("can't infer generic type of: " + paramClass.toString());
            }
            Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
            if ((arrayOfType == null) || (arrayOfType.length != 1) || (!(arrayOfType[0] instanceof Class))) {
              throw new FacebookGraphObjectException("Expect collection properties to be of a type with exactly one generic parameter.");
            }
            Class localClass2 = (Class)arrayOfType[0];
            if (JSONArray.class.isAssignableFrom(localClass1)) {
              paramObject = createList((JSONArray)paramObject, localClass2);
            } else {
              throw new FacebookGraphObjectException("Can't create Collection from " + localClass1.getName());
            }
          }
          else
          {
            if (!String.class.equals(paramClass)) {
              break;
            }
            if ((Double.class.isAssignableFrom(localClass1)) || (Float.class.isAssignableFrom(localClass1)))
            {
              Object[] arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = paramObject;
              paramObject = String.format("%f", arrayOfObject1);
            }
            else
            {
              if (!Number.class.isAssignableFrom(localClass1)) {
                break label488;
              }
              Object[] arrayOfObject2 = new Object[1];
              arrayOfObject2[0] = paramObject;
              paramObject = String.format("%d", arrayOfObject2);
            }
          }
        }
      }
    }
    if ((Date.class.equals(paramClass)) && (String.class.isAssignableFrom(localClass1)))
    {
      SimpleDateFormat[] arrayOfSimpleDateFormat = dateFormats;
      int i = arrayOfSimpleDateFormat.length;
      int j = 0;
      for (;;)
      {
        for (;;)
        {
          if (j >= i) {
            break label488;
          }
          SimpleDateFormat localSimpleDateFormat = arrayOfSimpleDateFormat[j];
          try
          {
            Date localDate = localSimpleDateFormat.parse((String)paramObject);
            if (localDate != null) {
              paramObject = localDate;
            }
          }
          catch (ParseException localParseException)
          {
            j++;
          }
        }
      }
    }
    label488:
    throw new FacebookGraphObjectException("Can't convert type" + localClass1.getName() + " to " + paramClass.getName());
  }
  
  static String convertCamelCaseToLowercaseWithUnderscores(String paramString)
  {
    return paramString.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(Locale.US);
  }
  
  public static GraphObject create()
  {
    return create(GraphObject.class);
  }
  
  public static <T extends GraphObject> T create(Class<T> paramClass)
  {
    return createGraphObjectProxy(paramClass, new JSONObject());
  }
  
  public static GraphObject create(JSONObject paramJSONObject)
  {
    return create(paramJSONObject, GraphObject.class);
  }
  
  public static <T extends GraphObject> T create(JSONObject paramJSONObject, Class<T> paramClass)
  {
    return createGraphObjectProxy(paramClass, paramJSONObject);
  }
  
  private static <T extends GraphObject> T createGraphObjectProxy(Class<T> paramClass, JSONObject paramJSONObject)
  {
    verifyCanProxyClass(paramClass);
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = paramClass;
    GraphObject.Factory.GraphObjectProxy localGraphObjectProxy = new GraphObject.Factory.GraphObjectProxy(paramJSONObject, paramClass);
    return (GraphObject)Proxy.newProxyInstance(GraphObject.class.getClassLoader(), arrayOfClass, localGraphObjectProxy);
  }
  
  private static Map<String, Object> createGraphObjectProxyForMap(JSONObject paramJSONObject)
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Map.class;
    GraphObject.Factory.GraphObjectProxy localGraphObjectProxy = new GraphObject.Factory.GraphObjectProxy(paramJSONObject, Map.class);
    return (Map)Proxy.newProxyInstance(GraphObject.class.getClassLoader(), arrayOfClass, localGraphObjectProxy);
  }
  
  public static <T> GraphObjectList<T> createList(Class<T> paramClass)
  {
    return createList(new JSONArray(), paramClass);
  }
  
  public static <T> GraphObjectList<T> createList(JSONArray paramJSONArray, Class<T> paramClass)
  {
    return new GraphObject.Factory.GraphObjectListImpl(paramJSONArray, paramClass);
  }
  
  private static Object getUnderlyingJSONObject(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      Class localClass = paramObject.getClass();
      if (GraphObject.class.isAssignableFrom(localClass))
      {
        paramObject = ((GraphObject)paramObject).getInnerJSONObject();
      }
      else if (GraphObjectList.class.isAssignableFrom(localClass))
      {
        paramObject = ((GraphObjectList)paramObject).getInnerJSONArray();
      }
      else if (Iterable.class.isAssignableFrom(localClass))
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = ((Iterable)paramObject).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (GraphObject.class.isAssignableFrom(localObject.getClass())) {
            localJSONArray.put(((GraphObject)localObject).getInnerJSONObject());
          } else {
            localJSONArray.put(localObject);
          }
        }
        paramObject = localJSONArray;
      }
    }
  }
  
  private static <T extends GraphObject> boolean hasClassBeenVerified(Class<T> paramClass)
  {
    try
    {
      boolean bool = verifiedGraphObjectClasses.contains(paramClass);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean hasSameId(GraphObject paramGraphObject1, GraphObject paramGraphObject2)
  {
    boolean bool = false;
    if ((paramGraphObject1 == null) || (paramGraphObject2 == null) || (!paramGraphObject1.asMap().containsKey("id")) || (!paramGraphObject2.asMap().containsKey("id"))) {}
    for (;;)
    {
      return bool;
      if (paramGraphObject1.equals(paramGraphObject2))
      {
        bool = true;
      }
      else
      {
        Object localObject1 = paramGraphObject1.getProperty("id");
        Object localObject2 = paramGraphObject2.getProperty("id");
        if ((localObject1 != null) && (localObject2 != null) && ((localObject1 instanceof String)) && ((localObject2 instanceof String))) {
          bool = localObject1.equals(localObject2);
        }
      }
    }
  }
  
  private static <T extends GraphObject> void recordClassHasBeenVerified(Class<T> paramClass)
  {
    try
    {
      verifiedGraphObjectClasses.add(paramClass);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static <T extends GraphObject> void verifyCanProxyClass(Class<T> paramClass)
  {
    if (hasClassBeenVerified(paramClass)) {}
    for (;;)
    {
      return;
      if (!paramClass.isInterface()) {
        throw new FacebookGraphObjectException("Factory can only wrap interfaces, not class: " + paramClass.getName());
      }
      Method[] arrayOfMethod = paramClass.getMethods();
      int i = arrayOfMethod.length;
      int j = 0;
      if (j < i)
      {
        Method localMethod = arrayOfMethod[j];
        String str = localMethod.getName();
        int k = localMethod.getParameterTypes().length;
        Class localClass = localMethod.getReturnType();
        boolean bool = localMethod.isAnnotationPresent(PropertyName.class);
        if (localMethod.getDeclaringClass().isAssignableFrom(GraphObject.class)) {}
        for (;;)
        {
          j++;
          break;
          if ((k == 1) && (localClass == Void.TYPE)) {
            if (bool) {
              if (!Utility.isNullOrEmpty(((PropertyName)localMethod.getAnnotation(PropertyName.class)).value())) {
                continue;
              }
            }
          }
          label256:
          do
          {
            do
            {
              do
              {
                do
                {
                  throw new FacebookGraphObjectException("Factory can't proxy method: " + localMethod.toString());
                } while ((!str.startsWith("set")) || (str.length() <= 3));
                break;
              } while ((k != 0) || (localClass == Void.TYPE));
              if (!bool) {
                break label256;
              }
            } while (Utility.isNullOrEmpty(((PropertyName)localMethod.getAnnotation(PropertyName.class)).value()));
            break;
          } while ((!str.startsWith("get")) || (str.length() <= 3));
        }
      }
      recordClassHasBeenVerified(paramClass);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject.Factory
 * JD-Core Version:    0.7.0.1
 */