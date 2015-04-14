import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class lX
{
  private static Context a;
  private static kO b;
  
  private static <T> T a(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
    }
  }
  
  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      Object localObject = a(((ClassLoader)hZ.a(paramClassLoader)).loadClass(paramString));
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
  }
  
  public static kO a(Context paramContext)
  {
    hZ.a(paramContext);
    kO localkO;
    if (b != null) {
      localkO = b;
    }
    for (;;)
    {
      return localkO;
      b(paramContext);
      b = c(paramContext);
      try
      {
        b.a(gX.a(d(paramContext).getResources()), 6587000);
        localkO = b;
      }
      catch (RemoteException localRemoteException)
      {
        throw new md(localRemoteException);
      }
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static Class<?> b()
  {
    Object localObject;
    try
    {
      if (Build.VERSION.SDK_INT < 15)
      {
        localObject = Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
      }
      else
      {
        Class localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        localObject = localClass;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
    return localObject;
  }
  
  private static void b(Context paramContext)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static kO c(Context paramContext)
  {
    if (a()) {
      lX.class.getSimpleName();
    }
    for (kO localkO = (kO)a(b());; localkO = kP.a((IBinder)a(d(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl")))
    {
      return localkO;
      lX.class.getSimpleName();
    }
  }
  
  private static Context d(Context paramContext)
  {
    if (a == null) {
      if (!a()) {
        break label23;
      }
    }
    label23:
    for (a = paramContext.getApplicationContext();; a = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
      return a;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lX
 * JD-Core Version:    0.7.0.1
 */