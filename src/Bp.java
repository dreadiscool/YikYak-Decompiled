import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

final class Bp
  implements AQ
{
  private final LD a;
  private final boolean b;
  private final Bh c;
  
  Bp(LD paramLD, boolean paramBoolean)
  {
    this.a = paramLD;
    this.c = new Bh(this.a);
    this.b = paramBoolean;
  }
  
  private static IOException a(String paramString, Object... paramVarArgs)
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private void a(AR paramAR, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    int i = this.a.m();
    int j = this.a.m();
    int k = i & 0x7FFFFFFF;
    int m = j & 0x7FFFFFFF;
    this.a.l();
    List localList = this.c.a(paramInt2 - 10);
    boolean bool2;
    if ((paramInt1 & 0x1) != 0)
    {
      bool2 = bool1;
      if ((paramInt1 & 0x2) == 0) {
        break label104;
      }
    }
    for (;;)
    {
      paramAR.a(bool1, bool2, k, m, localList, AU.a);
      return;
      bool2 = false;
      break;
      label104:
      bool1 = false;
    }
  }
  
  private void b(AR paramAR, int paramInt1, int paramInt2)
  {
    int i = 0x7FFFFFFF & this.a.m();
    List localList = this.c.a(paramInt2 - 4);
    if ((paramInt1 & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAR.a(false, bool, i, -1, localList, AU.b);
      return;
    }
  }
  
  private void c(AR paramAR, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 8)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt2);
      throw a("TYPE_RST_STREAM length: %d != 8", arrayOfObject2);
    }
    int i = 0x7FFFFFFF & this.a.m();
    int j = this.a.m();
    AP localAP = AP.a(j);
    if (localAP == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(j);
      throw a("TYPE_RST_STREAM unexpected error code: %d", arrayOfObject1);
    }
    paramAR.a(i, localAP);
  }
  
  private void d(AR paramAR, int paramInt1, int paramInt2)
  {
    paramAR.a(false, false, 0x7FFFFFFF & this.a.m(), -1, this.c.a(paramInt2 - 4), AU.c);
  }
  
  private void e(AR paramAR, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 8)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt2);
      throw a("TYPE_WINDOW_UPDATE length: %d != 8", arrayOfObject2);
    }
    int i = this.a.m();
    int j = this.a.m();
    int k = i & 0x7FFFFFFF;
    long l = j & 0x7FFFFFFF;
    if (l == 0L)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Long.valueOf(l);
      throw a("windowSizeIncrement was 0", arrayOfObject1);
    }
    paramAR.a(k, l);
  }
  
  private void f(AR paramAR, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if (paramInt2 != 4)
    {
      Object[] arrayOfObject = new Object[bool1];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      throw a("TYPE_PING length: %d != 4", arrayOfObject);
    }
    int i = this.a.m();
    boolean bool2 = this.b;
    boolean bool3;
    if ((i & 0x1) == bool1)
    {
      bool3 = bool1;
      if (bool2 != bool3) {
        break label86;
      }
    }
    for (;;)
    {
      paramAR.a(bool1, i, 0);
      return;
      bool3 = false;
      break;
      label86:
      bool1 = false;
    }
  }
  
  private void g(AR paramAR, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 8)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt2);
      throw a("TYPE_GOAWAY length: %d != 8", arrayOfObject2);
    }
    int i = 0x7FFFFFFF & this.a.m();
    int j = this.a.m();
    AP localAP = AP.c(j);
    if (localAP == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(j);
      throw a("TYPE_GOAWAY unexpected error code: %d", arrayOfObject1);
    }
    paramAR.a(i, localAP, LE.a);
  }
  
  private void h(AR paramAR, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i = this.a.m();
    if (paramInt2 != 4 + i * 8)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      arrayOfObject[bool] = Integer.valueOf(i);
      throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", arrayOfObject);
    }
    Bn localBn = new Bn();
    for (int j = 0; j < i; j++)
    {
      int k = this.a.m();
      int m = this.a.m();
      int n = (0xFF000000 & k) >>> 24;
      localBn.a(k & 0xFFFFFF, n, m);
    }
    if ((paramInt1 & 0x1) != 0) {}
    for (;;)
    {
      paramAR.a(bool, localBn);
      return;
      bool = false;
    }
  }
  
  public void a() {}
  
  public boolean a(AR paramAR)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    int i;
    boolean bool3;
    int k;
    int m;
    int i2;
    try
    {
      i = this.a.m();
      int j = this.a.m();
      if ((0x80000000 & i) != 0)
      {
        bool3 = bool2;
        k = (0xFF000000 & j) >>> 24;
        m = j & 0xFFFFFF;
        if (!bool3) {
          break label287;
        }
        int i1 = (0x7FFF0000 & i) >>> 16;
        i2 = 0xFFFF & i;
        if (i1 == 3) {
          break label122;
        }
        throw new ProtocolException("version != 3: " + i1);
      }
    }
    catch (IOException localIOException)
    {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      bool3 = false;
      break;
      switch (i2)
      {
      case 5: 
      default: 
        this.a.g(m);
        break;
      case 1: 
        a(paramAR, k, m);
        break;
      case 2: 
        b(paramAR, k, m);
        break;
      case 3: 
        c(paramAR, k, m);
        break;
      case 4: 
        h(paramAR, k, m);
        break;
      case 6: 
        f(paramAR, k, m);
        break;
      case 7: 
        g(paramAR, k, m);
        break;
      case 8: 
        d(paramAR, k, m);
        break;
      case 9: 
        label122:
        e(paramAR, k, m);
        continue;
        label287:
        int n = 0x7FFFFFFF & i;
        if ((k & 0x1) != 0) {
          bool1 = bool2;
        }
        paramAR.a(bool1, n, this.a, m);
      }
    }
  }
  
  public void close()
  {
    this.c.a();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bp
 * JD-Core Version:    0.7.0.1
 */