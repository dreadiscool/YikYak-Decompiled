import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class rm<T extends Enum<T>>
  extends pm<T>
{
  private final Map<String, T> a = new HashMap();
  private final Map<T, String> b = new HashMap();
  
  public rm(Class<T> paramClass)
  {
    for (;;)
    {
      String str1;
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int i = arrayOfEnum.length;
        int j = 0;
        if (j < i)
        {
          Enum localEnum = arrayOfEnum[j];
          str1 = localEnum.name();
          pp localpp = (pp)paramClass.getField(str1).getAnnotation(pp.class);
          if (localpp != null)
          {
            str2 = localpp.a();
            this.a.put(str2, localEnum);
            this.b.put(localEnum, str2);
            j++;
          }
        }
        else
        {
          return;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new AssertionError();
      }
      String str2 = str1;
    }
  }
  
  public T a(ro paramro)
  {
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    for (Object localObject = null;; localObject = (Enum)this.a.get(paramro.h())) {
      return localObject;
    }
  }
  
  public void a(rr paramrr, T paramT)
  {
    if (paramT == null) {}
    for (String str = null;; str = (String)this.b.get(paramT))
    {
      paramrr.b(str);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rm
 * JD-Core Version:    0.7.0.1
 */