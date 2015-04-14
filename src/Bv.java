import java.io.IOException;
import java.util.List;
import java.util.Set;

class Bv
  extends zU
{
  Bv(Br paramBr, String paramString, Object[] paramArrayOfObject, int paramInt, List paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    if (Br.h(this.d).a(this.a, this.c)) {
      try
      {
        this.d.i.a(this.a, AP.l);
        synchronized (this.d)
        {
          Br.i(this.d).remove(Integer.valueOf(this.a));
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bv
 * JD-Core Version:    0.7.0.1
 */