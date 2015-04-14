import android.content.Context;
import java.lang.reflect.Method;

class IY
  implements Jd
{
  private final Context a;
  
  public IY(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private String b()
  {
    try
    {
      str = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(d(), new Object[0]);
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
        String str = null;
      }
    }
  }
  
  private boolean c()
  {
    try
    {
      boolean bool2 = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(d(), new Object[0])).booleanValue();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
        boolean bool1 = false;
      }
    }
    return bool1;
  }
  
  private Object d()
  {
    Object localObject1 = null;
    try
    {
      Class localClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Context.class;
      Method localMethod = localClass.getMethod("getAdvertisingIdInfo", arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.a;
      Object localObject2 = localMethod.invoke(null, arrayOfObject);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
    return localObject1;
  }
  
  public IV a()
  {
    if (a(this.a)) {}
    for (IV localIV = new IV(b(), c());; localIV = null) {
      return localIV;
    }
  }
  
  boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Context.class;
        Method localMethod = localClass.getMethod("isGooglePlayServicesAvailable", arrayOfClass);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramContext;
        int i = ((Integer)localMethod.invoke(null, arrayOfObject)).intValue();
        if (i != 0) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        boolean bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IY
 * JD-Core Version:    0.7.0.1
 */