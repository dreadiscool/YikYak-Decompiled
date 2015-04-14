import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class qE<T>
  extends pm<T>
{
  private final oR a;
  private final pm<T> b;
  private final Type c;
  
  qE(oR paramoR, pm<T> parampm, Type paramType)
  {
    this.a = paramoR;
    this.b = parampm;
    this.c = paramType;
  }
  
  private Type a(Type paramType, Object paramObject)
  {
    if ((paramObject != null) && ((paramType == Object.class) || ((paramType instanceof TypeVariable)) || ((paramType instanceof Class)))) {
      paramType = paramObject.getClass();
    }
    return paramType;
  }
  
  public void a(rr paramrr, T paramT)
  {
    pm localpm = this.b;
    Type localType = a(this.c, paramT);
    if (localType != this.c)
    {
      localpm = this.a.a(rn.a(localType));
      if ((localpm instanceof qy)) {
        break label52;
      }
    }
    for (;;)
    {
      localpm.a(paramrr, paramT);
      return;
      label52:
      if (!(this.b instanceof qy)) {
        localpm = this.b;
      }
    }
  }
  
  public T b(ro paramro)
  {
    return this.b.b(paramro);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qE
 * JD-Core Version:    0.7.0.1
 */