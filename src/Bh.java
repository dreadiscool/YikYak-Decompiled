import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Bh
{
  private final LJ a = new LJ(new Bi(this, paramLD), new Bj(this));
  private int b;
  private final LD c = LK.a(this.a);
  
  public Bh(LD paramLD) {}
  
  private LE b()
  {
    int i = this.c.m();
    return this.c.c(i);
  }
  
  private void c()
  {
    if (this.b > 0)
    {
      this.a.a();
      if (this.b != 0) {
        throw new IOException("compressedLimit > 0: " + this.b);
      }
    }
  }
  
  public List<AT> a(int paramInt)
  {
    this.b = (paramInt + this.b);
    int i = this.c.m();
    if (i < 0) {
      throw new IOException("numberOfPairs < 0: " + i);
    }
    if (i > 1024) {
      throw new IOException("numberOfPairs > 1024: " + i);
    }
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      LE localLE1 = b().d();
      LE localLE2 = b();
      if (localLE1.e() == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new AT(localLE1, localLE2));
    }
    c();
    return localArrayList;
  }
  
  public void a()
  {
    this.c.close();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bh
 * JD-Core Version:    0.7.0.1
 */