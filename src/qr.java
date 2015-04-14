import java.lang.reflect.Type;
import java.util.Map;

public final class qr
  implements pn
{
  private final px a;
  private final boolean b;
  
  public qr(px parampx, boolean paramBoolean)
  {
    this.a = parampx;
    this.b = paramBoolean;
  }
  
  private pm<?> a(oR paramoR, Type paramType)
  {
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {}
    for (pm localpm = qF.f;; localpm = paramoR.a(rn.a(paramType))) {
      return localpm;
    }
  }
  
  public <T> pm<T> a(oR paramoR, rn<T> paramrn)
  {
    Type localType = paramrn.b();
    if (!Map.class.isAssignableFrom(paramrn.a())) {}
    Type[] arrayOfType;
    pm localpm1;
    pm localpm2;
    pW localpW;
    for (Object localObject = null;; localObject = new qs(this, paramoR, arrayOfType[0], localpm1, arrayOfType[1], localpm2, localpW))
    {
      return localObject;
      arrayOfType = pt.b(localType, pt.e(localType));
      localpm1 = a(paramoR, arrayOfType[0]);
      localpm2 = paramoR.a(rn.a(arrayOfType[1]));
      localpW = this.a.a(paramrn);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qr
 * JD-Core Version:    0.7.0.1
 */