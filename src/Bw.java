import java.io.IOException;
import java.util.List;
import java.util.Set;

class Bw
  extends zU
{
  Bw(Br paramBr, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    boolean bool = Br.h(this.e).a(this.a, this.c, this.d);
    if (bool) {}
    try
    {
      this.e.i.a(this.a, AP.l);
      if ((bool) || (this.d)) {
        synchronized (this.e)
        {
          Br.i(this.e).remove(Integer.valueOf(this.a));
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bw
 * JD-Core Version:    0.7.0.1
 */