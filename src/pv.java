import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class pv
  implements Serializable, ParameterizedType
{
  private final Type a;
  private final Type b;
  private final Type[] c;
  
  public pv(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    boolean bool2;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
      {
        bool2 = bool1;
        ps.a(bool2);
        if ((paramType1 != null) && (localClass.getEnclosingClass() == null)) {
          break label153;
        }
        label56:
        ps.a(bool1);
      }
    }
    else
    {
      if (paramType1 != null) {
        break label159;
      }
    }
    label153:
    label159:
    for (Type localType = null;; localType = pt.d(paramType1))
    {
      this.a = localType;
      this.b = pt.d(paramType2);
      this.c = ((Type[])paramVarArgs.clone());
      while (i < this.c.length)
      {
        ps.a(this.c[i]);
        pt.h(this.c[i]);
        this.c[i] = pt.d(this.c[i]);
        i++;
      }
      bool2 = false;
      break;
      bool1 = false;
      break label56;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof ParameterizedType)) && (pt.a(this, (ParameterizedType)paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])this.c.clone();
  }
  
  public Type getOwnerType()
  {
    return this.a;
  }
  
  public Type getRawType()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ pt.a(this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(30 * (1 + this.c.length));
    localStringBuilder.append(pt.f(this.b));
    if (this.c.length == 0) {}
    for (String str = localStringBuilder.toString();; str = ">")
    {
      return str;
      localStringBuilder.append("<").append(pt.f(this.c[0]));
      for (int i = 1; i < this.c.length; i++) {
        localStringBuilder.append(", ").append(pt.f(this.c[i]));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pv
 * JD-Core Version:    0.7.0.1
 */