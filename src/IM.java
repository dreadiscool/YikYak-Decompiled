import android.content.Context;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class IM<Result>
  implements Comparable<IM>
{
  IC b;
  IL<Result> c = new IL(this);
  Context d;
  IH<Result> e;
  Js f;
  
  final void A()
  {
    IL localIL = this.c;
    ExecutorService localExecutorService = this.b.e();
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = ((Void)null);
    localIL.a(localExecutorService, arrayOfVoid);
  }
  
  protected Js B()
  {
    return this.f;
  }
  
  public Context C()
  {
    return this.d;
  }
  
  public IC D()
  {
    return this.b;
  }
  
  public String E()
  {
    return ".Fabric" + File.separator + c();
  }
  
  boolean F()
  {
    if ((JR)getClass().getAnnotation(JR.class) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected Collection<Kc> G()
  {
    return this.c.c();
  }
  
  public int a(IM paramIM)
  {
    int i = 1;
    if (b(paramIM)) {}
    for (;;)
    {
      return i;
      if (paramIM.b(this)) {
        i = -1;
      } else if ((!F()) || (paramIM.F())) {
        if ((!F()) && (paramIM.F())) {
          i = -1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  void a(Context paramContext, IC paramIC, IH<Result> paramIH, Js paramJs)
  {
    this.b = paramIC;
    this.d = new IG(paramContext, c(), E());
    this.e = paramIH;
    this.f = paramJs;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  boolean b(IM paramIM)
  {
    JR localJR = (JR)getClass().getAnnotation(JR.class);
    int j;
    if (localJR != null)
    {
      Class[] arrayOfClass = localJR.a();
      int i = arrayOfClass.length;
      j = 0;
      if (j < i) {
        if (!arrayOfClass[j].equals(paramIM.getClass())) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }
  
  public abstract String c();
  
  public abstract String d();
  
  protected abstract Result z();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IM
 * JD-Core Version:    0.7.0.1
 */