import java.io.IOException;
import java.util.Set;

class Bx
  extends zU
{
  Bx(Br paramBr, String paramString, Object[] paramArrayOfObject, int paramInt1, Lz paramLz, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    try
    {
      boolean bool = Br.h(this.f).a(this.a, this.c, this.d, this.e);
      if (bool) {
        this.f.i.a(this.a, AP.l);
      }
      if ((bool) || (this.e)) {
        synchronized (this.f)
        {
          Br.i(this.f).remove(Integer.valueOf(this.a));
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bx
 * JD-Core Version:    0.7.0.1
 */