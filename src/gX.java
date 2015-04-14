import android.os.IBinder;
import java.lang.reflect.Field;

public final class gX<T>
  extends gV
{
  private final T a;
  
  private gX(T paramT)
  {
    this.a = paramT;
  }
  
  public static <T> gU a(T paramT)
  {
    return new gX(paramT);
  }
  
  public static <T> T a(gU paramgU)
  {
    Object localObject2;
    if ((paramgU instanceof gX)) {
      localObject2 = ((gX)paramgU).a;
    }
    for (;;)
    {
      return localObject2;
      IBinder localIBinder = paramgU.asBinder();
      Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
      if (arrayOfField.length != 1) {
        break label122;
      }
      Field localField = arrayOfField[0];
      if (!localField.isAccessible())
      {
        localField.setAccessible(true);
        try
        {
          Object localObject1 = localField.get(localIBinder);
          localObject2 = localObject1;
        }
        catch (NullPointerException localNullPointerException)
        {
          throw new IllegalArgumentException("Binder object is null.", localNullPointerException);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", localIllegalArgumentException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", localIllegalAccessException);
        }
      }
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    label122:
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gX
 * JD-Core Version:    0.7.0.1
 */