import java.io.InputStream;

class sO
  extends InputStream
{
  private sM b;
  private sB c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public sO(sJ paramsJ)
  {
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int j = paramInt1;
    if (i > 0)
    {
      b();
      if (this.c == null) {
        if (i != paramInt2) {
          break label99;
        }
      }
    }
    label99:
    for (int k = -1;; k = paramInt2 - i)
    {
      return k;
      int m = Math.min(this.d - this.e, i);
      if (paramArrayOfByte != null)
      {
        this.c.b(paramArrayOfByte, this.e, j, m);
        j += m;
      }
      this.e = (m + this.e);
      i -= m;
      break;
    }
  }
  
  private void a()
  {
    this.b = new sM(this.a, null);
    this.c = this.b.a();
    this.d = this.c.a();
    this.e = 0;
    this.f = 0;
  }
  
  private void b()
  {
    if ((this.c != null) && (this.e == this.d))
    {
      this.f += this.d;
      this.e = 0;
      if (!this.b.hasNext()) {
        break label69;
      }
      this.c = this.b.a();
    }
    for (this.d = this.c.a();; this.d = 0)
    {
      return;
      label69:
      this.c = null;
    }
  }
  
  public int available()
  {
    int i = this.f + this.e;
    return this.a.a() - i;
  }
  
  public void mark(int paramInt)
  {
    this.g = (this.f + this.e);
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    b();
    if (this.c == null) {}
    sB localsB;
    int i;
    for (int j = -1;; j = 0xFF & localsB.a(i))
    {
      return j;
      localsB = this.c;
      i = this.e;
      this.e = (i + 1);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
      throw new IndexOutOfBoundsException();
    }
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    try
    {
      a();
      a(null, 0, this.g);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IndexOutOfBoundsException();
    }
    if (paramLong > 2147483647L) {
      paramLong = 2147483647L;
    }
    return a(null, 0, (int)paramLong);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sO
 * JD-Core Version:    0.7.0.1
 */