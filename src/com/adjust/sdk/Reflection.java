package com.adjust.sdk;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection
{
  public static Object createDefaultInstance(Class paramClass)
  {
    try
    {
      Object localObject2 = paramClass.newInstance();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    return localObject1;
  }
  
  public static Object createDefaultInstance(String paramString)
  {
    return createDefaultInstance(forName(paramString));
  }
  
  public static Object createInstance(String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      Object localObject2 = Class.forName(paramString).getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    return localObject1;
  }
  
  public static Class forName(String paramString)
  {
    try
    {
      Class localClass2 = Class.forName(paramString);
      localClass1 = localClass2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Class localClass1 = null;
      }
    }
    return localClass1;
  }
  
  private static Object getAdvertisingInfoObject(Context paramContext)
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext;
    return invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", arrayOfClass, arrayOfObject);
  }
  
  public static String getAndroidId(Context paramContext)
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Context.class;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      str = (String)invokeStaticMethod("com.adjust.sdk.plugin.AndroidIdUtil", "getAndroidId", arrayOfClass, arrayOfObject);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
      }
    }
  }
  
  public static String getMacAddress(Context paramContext)
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Context.class;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      str = (String)invokeStaticMethod("com.adjust.sdk.plugin.MacAddressUtil", "getMacAddress", arrayOfClass, arrayOfObject);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
      }
    }
  }
  
  public static String getPlayAdId(Context paramContext)
  {
    try
    {
      str = (String)invokeInstanceMethod(getAdvertisingInfoObject(paramContext), "getId", null, new Object[0]);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
      }
    }
  }
  
  public static String getSha1EmailAddress(Context paramContext, String paramString)
  {
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = String.class;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramContext;
      arrayOfObject[1] = paramString;
      str = (String)invokeStaticMethod("com.adjust.sdk.plugin.EmailUtil", "getSha1EmailAddress", arrayOfClass, arrayOfObject);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
      }
    }
  }
  
  public static Object invokeInstanceMethod(Object paramObject, String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    return invokeMethod(paramObject.getClass(), paramString, paramObject, paramArrayOfClass, paramVarArgs);
  }
  
  public static Object invokeMethod(Class paramClass, String paramString, Object paramObject, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    return paramClass.getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramVarArgs);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    return invokeMethod(Class.forName(paramString1), paramString2, null, paramArrayOfClass, paramVarArgs);
  }
  
  private static boolean isConnectionResultSuccess(Integer paramInteger)
  {
    boolean bool = false;
    if (paramInteger == null) {}
    for (;;)
    {
      return bool;
      try
      {
        int i = Class.forName("com.google.android.gms.common.ConnectionResult").getField("SUCCESS").getInt(null);
        int j = paramInteger.intValue();
        if (i == j) {
          bool = true;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static boolean isGooglePlayServicesAvailable(Context paramContext)
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Context.class;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      boolean bool2 = Boolean.valueOf(isConnectionResultSuccess((Integer)invokeStaticMethod("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", arrayOfClass, arrayOfObject))).booleanValue();
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool1 = false;
      }
    }
    return bool1;
  }
  
  public static Boolean isPlayTrackingEnabled(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (((Boolean)invokeInstanceMethod(getAdvertisingInfoObject(paramContext), "isLimitAdTrackingEnabled", null, new Object[0])).booleanValue()) {
          continue;
        }
        bool = true;
        Boolean localBoolean2 = Boolean.valueOf(bool);
        localBoolean1 = localBoolean2;
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        Boolean localBoolean1 = null;
        continue;
      }
      return localBoolean1;
      bool = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Reflection
 * JD-Core Version:    0.7.0.1
 */