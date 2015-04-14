import java.lang.reflect.Type;
import java.util.Collection;

public final class qj
  implements pn
{
  private final px a;
  
  public qj(px parampx)
  {
    this.a = parampx;
  }
  
  public <T> pm<T> a(oR paramoR, rn<T> paramrn)
  {
    Type localType1 = paramrn.b();
    Class localClass = paramrn.a();
    if (!Collection.class.isAssignableFrom(localClass)) {}
    Type localType2;
    for (Object localObject = null;; localObject = new qk(paramoR, localType2, paramoR.a(rn.a(localType2)), this.a.a(paramrn)))
    {
      return localObject;
      localType2 = pt.a(localType1, localClass);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qj
 * JD-Core Version:    0.7.0.1
 */