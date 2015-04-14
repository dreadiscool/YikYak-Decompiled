import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;

public abstract class gZ<T>
{
  private final String a;
  private T b;
  
  protected gZ(String paramString)
  {
    this.a = paramString;
  }
  
  protected final T a(Context paramContext)
  {
    ClassLoader localClassLoader;
    if (this.b == null)
    {
      hZ.a(paramContext);
      Context localContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (localContext == null) {
        throw new ha("Could not get remote context.");
      }
      localClassLoader = localContext.getClassLoader();
    }
    try
    {
      this.b = a((IBinder)localClassLoader.loadClass(this.a).newInstance());
      return this.b;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ha("Could not load creator class.", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new ha("Could not instantiate creator.", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ha("Could not access creator.", localIllegalAccessException);
    }
  }
  
  protected abstract T a(IBinder paramIBinder);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gZ
 * JD-Core Version:    0.7.0.1
 */