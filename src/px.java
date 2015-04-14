import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class px
{
  private final Map<Type, oY<?>> a;
  
  public px(Map<Type, oY<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  private <T> pW<T> a(Class<? super T> paramClass)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (!localConstructor.isAccessible()) {
        localConstructor.setAccessible(true);
      }
      localpD = new pD(this, localConstructor);
      return localpD;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        pD localpD = null;
      }
    }
  }
  
  private <T> pW<T> a(Type paramType, Class<? super T> paramClass)
  {
    Object localObject;
    if (Collection.class.isAssignableFrom(paramClass)) {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        localObject = new pE(this);
      }
    }
    for (;;)
    {
      return localObject;
      if (EnumSet.class.isAssignableFrom(paramClass))
      {
        localObject = new pF(this, paramType);
      }
      else if (Set.class.isAssignableFrom(paramClass))
      {
        localObject = new pG(this);
      }
      else if (Queue.class.isAssignableFrom(paramClass))
      {
        localObject = new pH(this);
      }
      else
      {
        localObject = new pI(this);
        continue;
        if (Map.class.isAssignableFrom(paramClass))
        {
          if (SortedMap.class.isAssignableFrom(paramClass)) {
            localObject = new pJ(this);
          } else if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(rn.a(((ParameterizedType)paramType).getActualTypeArguments()[0]).a()))) {
            localObject = new pz(this);
          } else {
            localObject = new pA(this);
          }
        }
        else {
          localObject = null;
        }
      }
    }
  }
  
  private <T> pW<T> b(Type paramType, Class<? super T> paramClass)
  {
    return new pB(this, paramClass, paramType);
  }
  
  public <T> pW<T> a(rn<T> paramrn)
  {
    Type localType = paramrn.b();
    Class localClass = paramrn.a();
    oY localoY1 = (oY)this.a.get(localType);
    Object localObject;
    if (localoY1 != null) {
      localObject = new py(this, localoY1, localType);
    }
    for (;;)
    {
      return localObject;
      oY localoY2 = (oY)this.a.get(localClass);
      if (localoY2 != null)
      {
        localObject = new pC(this, localoY2, localType);
      }
      else
      {
        localObject = a(localClass);
        if (localObject == null)
        {
          localObject = a(localType, localClass);
          if (localObject == null) {
            localObject = b(localType, localClass);
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     px
 * JD-Core Version:    0.7.0.1
 */