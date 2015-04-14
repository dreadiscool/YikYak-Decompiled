import org.json.JSONObject;

public class Iq
{
  public static String a(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = "null";
    }
    for (;;)
    {
      return (String)localObject;
      if ((paramObject instanceof String)) {
        localObject = paramObject;
      } else {
        localObject = paramObject.toString();
      }
    }
  }
  
  public static void a(Object paramObject, Object... paramVarArgs)
  {
    a(b(paramObject), paramVarArgs);
  }
  
  public static void a(Object paramObject, JSONObject... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = "<no data>";
      a(paramObject, arrayOfObject1);
      return;
    }
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      JSONObject localJSONObject = paramVarArgs[j];
      try
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localJSONObject.toString(2);
        a(paramObject, arrayOfObject3);
        j++;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = "<no data>";
          a(paramObject, arrayOfObject2);
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      G.a(3, paramString, a(paramVarArgs[j]));
    }
  }
  
  private static String b(Object paramObject)
  {
    if ((paramObject instanceof Class)) {}
    for (String str = ((Class)paramObject).getSimpleName();; str = paramObject.getClass().getSimpleName()) {
      return str;
    }
  }
  
  public static void b(Object paramObject, Object... paramVarArgs)
  {
    b(b(paramObject), paramVarArgs);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      G.a(6, paramString, a(paramVarArgs[j]));
    }
  }
  
  public static void c(Object paramObject, Object... paramVarArgs)
  {
    d(b(paramObject), paramVarArgs);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      G.a(4, paramString, a(paramVarArgs[j]));
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      G.a(5, paramString, a(paramVarArgs[j]));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Iq
 * JD-Core Version:    0.7.0.1
 */