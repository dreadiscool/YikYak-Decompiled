import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class pw
  implements Serializable, WildcardType
{
  private final Type a;
  private final Type b;
  
  public pw(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    if (paramArrayOfType2.length <= i)
    {
      int k = i;
      ps.a(k);
      if (paramArrayOfType1.length != i) {
        break label88;
      }
      int n = i;
      label29:
      ps.a(n);
      if (paramArrayOfType2.length != i) {
        break label99;
      }
      ps.a(paramArrayOfType2[0]);
      pt.h(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] != Object.class) {
        break label94;
      }
      label61:
      ps.a(i);
      this.b = pt.d(paramArrayOfType2[0]);
    }
    for (this.a = Object.class;; this.a = pt.d(paramArrayOfType1[0]))
    {
      return;
      int m = 0;
      break;
      label88:
      int i1 = 0;
      break label29;
      label94:
      int j = 0;
      break label61;
      label99:
      ps.a(paramArrayOfType1[0]);
      pt.h(paramArrayOfType1[0]);
      this.b = null;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof WildcardType)) && (pt.a(this, (WildcardType)paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Type[] getLowerBounds()
  {
    Type[] arrayOfType;
    if (this.b != null)
    {
      arrayOfType = new Type[1];
      arrayOfType[0] = this.b;
    }
    for (;;)
    {
      return arrayOfType;
      arrayOfType = pt.a;
    }
  }
  
  public Type[] getUpperBounds()
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = this.a;
    return arrayOfType;
  }
  
  public int hashCode()
  {
    if (this.b != null) {}
    for (int i = 31 + this.b.hashCode();; i = 1) {
      return i ^ 31 + this.a.hashCode();
    }
  }
  
  public String toString()
  {
    String str;
    if (this.b != null) {
      str = "? super " + pt.f(this.b);
    }
    for (;;)
    {
      return str;
      if (this.a == Object.class) {
        str = "?";
      } else {
        str = "? extends " + pt.f(this.a);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pw
 * JD-Core Version:    0.7.0.1
 */