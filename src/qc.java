import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class qc
{
  public static qc a()
  {
    try
    {
      Class localClass = Class.forName("sun.misc.Unsafe");
      Field localField = localClass.getDeclaredField("theUnsafe");
      localField.setAccessible(true);
      Object localObject2 = localField.get(null);
      Class[] arrayOfClass4 = new Class[1];
      arrayOfClass4[0] = Class.class;
      localObject1 = new qd(localClass.getMethod("allocateInstance", arrayOfClass4), localObject2);
      return localObject1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Class[] arrayOfClass3 = new Class[2];
          arrayOfClass3[0] = Class.class;
          arrayOfClass3[1] = Class.class;
          Method localMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", arrayOfClass3);
          localMethod3.setAccessible(true);
          localObject1 = new qe(localMethod3);
        }
        catch (Exception localException2)
        {
          try
          {
            Class[] arrayOfClass1 = new Class[1];
            arrayOfClass1[0] = Class.class;
            Method localMethod1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", arrayOfClass1);
            localMethod1.setAccessible(true);
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Object.class;
            int i = ((Integer)localMethod1.invoke(null, arrayOfObject)).intValue();
            Class[] arrayOfClass2 = new Class[2];
            arrayOfClass2[0] = Class.class;
            arrayOfClass2[1] = Integer.TYPE;
            Method localMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrayOfClass2);
            localMethod2.setAccessible(true);
            localObject1 = new qf(localMethod2, i);
          }
          catch (Exception localException3)
          {
            Object localObject1 = new qg();
          }
        }
      }
    }
  }
  
  public abstract <T> T a(Class<T> paramClass);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qc
 * JD-Core Version:    0.7.0.1
 */