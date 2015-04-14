import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class pu
  implements Serializable, GenericArrayType
{
  private final Type a;
  
  public pu(Type paramType)
  {
    this.a = pt.d(paramType);
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof GenericArrayType)) && (pt.a(this, (GenericArrayType)paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Type getGenericComponentType()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return pt.f(this.a) + "[]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pu
 * JD-Core Version:    0.7.0.1
 */