package com.facebook.internal;

import java.util.Collection;
import java.util.Iterator;

public final class Validate
{
  public static void containsNoNullOrEmpty(Collection<String> paramCollection, String paramString)
  {
    notNull(paramCollection, paramString);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str == null) {
        throw new NullPointerException("Container '" + paramString + "' cannot contain null values");
      }
      if (str.length() == 0) {
        throw new IllegalArgumentException("Container '" + paramString + "' cannot contain empty values");
      }
    }
  }
  
  public static <T> void containsNoNulls(Collection<T> paramCollection, String paramString)
  {
    notNull(paramCollection, paramString);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        throw new NullPointerException("Container '" + paramString + "' cannot contain null values");
      }
    }
  }
  
  public static <T> void notEmpty(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection.isEmpty()) {
      throw new IllegalArgumentException("Container '" + paramString + "' cannot be empty");
    }
  }
  
  public static <T> void notEmptyAndContainsNoNulls(Collection<T> paramCollection, String paramString)
  {
    containsNoNulls(paramCollection, paramString);
    notEmpty(paramCollection, paramString);
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("Argument '" + paramString + "' cannot be null");
    }
  }
  
  public static void notNullOrEmpty(String paramString1, String paramString2)
  {
    if (Utility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("Argument '" + paramString2 + "' cannot be null or empty");
    }
  }
  
  public static void oneOf(Object paramObject, String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      if (localObject != null)
      {
        if (!localObject.equals(paramObject)) {}
      }
      else {
        while (paramObject == null) {
          return;
        }
      }
    }
    throw new IllegalArgumentException("Argument '" + paramString + "' was not one of the allowed values");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.Validate
 * JD-Core Version:    0.7.0.1
 */