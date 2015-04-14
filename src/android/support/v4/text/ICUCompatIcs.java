package android.support.v4.text;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ICUCompatIcs
{
  private static final String TAG = "ICUCompatIcs";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;
  
  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = String.class;
        sGetScriptMethod = localClass.getMethod("getScript", arrayOfClass1);
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = String.class;
        sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", arrayOfClass2);
      }
      label50:
      return;
    }
    catch (Exception localException)
    {
      break label50;
    }
  }
  
  public static String addLikelySubtags(String paramString)
  {
    try
    {
      if (sAddLikelySubtagsMethod != null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        str = (String)sAddLikelySubtagsMethod.invoke(null, arrayOfObject);
        return str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label33:
      break label33;
    }
  }
  
  public static String getScript(String paramString)
  {
    try
    {
      if (sGetScriptMethod != null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        str = (String)sGetScriptMethod.invoke(null, arrayOfObject);
        return str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        String str = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label33:
      break label33;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompatIcs
 * JD-Core Version:    0.7.0.1
 */