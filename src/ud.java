import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ud
  extends FilterOutputStream
{
  private boolean a;
  private int b;
  private byte[] c;
  private int d;
  private int e;
  private boolean f;
  private byte[] g;
  private boolean h;
  private int i;
  private byte[] j;
  
  public ud(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    boolean bool2;
    if ((paramInt & 0x8) != 0)
    {
      bool2 = bool1;
      this.f = bool2;
      if ((paramInt & 0x1) == 0) {
        break label102;
      }
      label29:
      this.a = bool1;
      if (!this.a) {
        break label107;
      }
    }
    label102:
    label107:
    for (int k = 3;; k = 4)
    {
      this.d = k;
      this.c = new byte[this.d];
      this.b = 0;
      this.e = 0;
      this.h = false;
      this.g = new byte[4];
      this.i = paramInt;
      this.j = uc.a(paramInt);
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label29;
    }
  }
  
  public void a()
  {
    if (this.b > 0)
    {
      if (this.a)
      {
        this.out.write(uc.a(this.g, this.c, this.b, this.i));
        this.b = 0;
      }
    }
    else {
      return;
    }
    throw new IOException("Base64 input not properly padded.");
  }
  
  public void close()
  {
    a();
    super.close();
    this.c = null;
    this.out = null;
  }
  
  public void write(int paramInt)
  {
    if (this.h) {
      this.out.write(paramInt);
    }
    do
    {
      for (;;)
      {
        return;
        if (this.a)
        {
          byte[] arrayOfByte2 = this.c;
          int n = this.b;
          this.b = (n + 1);
          arrayOfByte2[n] = ((byte)paramInt);
          if (this.b >= this.d)
          {
            this.out.write(uc.a(this.g, this.c, this.d, this.i));
            this.e = (4 + this.e);
            if ((this.f) && (this.e >= 76))
            {
              this.out.write(10);
              this.e = 0;
            }
            this.b = 0;
          }
        }
        else
        {
          if (this.j[(paramInt & 0x7F)] <= -5) {
            break;
          }
          byte[] arrayOfByte1 = this.c;
          int k = this.b;
          this.b = (k + 1);
          arrayOfByte1[k] = ((byte)paramInt);
          if (this.b >= this.d)
          {
            int m = uc.a(this.c, 0, this.g, 0, this.i);
            this.out.write(this.g, 0, m);
            this.b = 0;
          }
        }
      }
    } while (this.j[(paramInt & 0x7F)] == -5);
    throw new IOException("Invalid character in Base64 data.");
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.h) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      for (int k = 0; k < paramInt2; k++) {
        write(paramArrayOfByte[(paramInt1 + k)]);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ud
 * JD-Core Version:    0.7.0.1
 */