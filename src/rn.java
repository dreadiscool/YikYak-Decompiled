import java.lang.reflect.Type;

public class rn<T>
{
  final Class<? super T> a;
  final Type b;
  final int c;
  
  protected rn()
  {
    this.b = a(getClass());
    this.a = pt.e(this.b);
    this.c = this.b.hashCode();
  }
  
  rn(Type paramType)
  {
    this.b = pt.d((Type)ps.a(paramType));
    this.a = pt.e(this.b);
    this.c = this.b.hashCode();
  }
  
  static Type a(Class<?> paramClass)
  {
    Type localType = paramClass.getGenericSuperclass();
    if ((localType instanceof Class)) {
      throw new RuntimeException("Missing type parameter.");
    }
    return pt.d(((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0]);
  }
  
  public static rn<?> a(Type paramType)
  {
    return new rn(paramType);
  }
  
  public static <T> rn<T> b(Class<T> paramClass)
  {
    return new rn(paramClass);
  }
  
  public final Class<? super T> a()
  {
    return this.a;
  }
  
  public final Type b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (((paramObject instanceof rn)) && (pt.a(this.b, ((rn)paramObject).b))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return pt.f(this.b);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rn
 * JD-Core Version:    0.7.0.1
 */