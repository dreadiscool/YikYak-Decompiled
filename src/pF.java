import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class pF
  implements pW<T>
{
  pF(px parampx, Type paramType) {}
  
  public T a()
  {
    if ((this.a instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)this.a).getActualTypeArguments()[0];
      if ((localType instanceof Class)) {
        return EnumSet.noneOf((Class)localType);
      }
      throw new pc("Invalid EnumSet type: " + this.a.toString());
    }
    throw new pc("Invalid EnumSet type: " + this.a.toString());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pF
 * JD-Core Version:    0.7.0.1
 */