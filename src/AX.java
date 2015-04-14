import java.util.List;
import java.util.Map;

final class AX
{
  private final Lz a;
  
  AX(Lz paramLz)
  {
    this.a = paramLz;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      this.a.a(paramInt3 | paramInt1);
    }
    for (;;)
    {
      return;
      this.a.a(paramInt3 | paramInt2);
      int i = paramInt1 - paramInt2;
      while (i >= 128)
      {
        int j = i & 0x7F;
        this.a.a(j | 0x80);
        i >>>= 7;
      }
      this.a.a(i);
    }
  }
  
  void a(LE paramLE)
  {
    a(paramLE.e(), 127, 0);
    this.a.a(paramLE);
  }
  
  void a(List<AT> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      LE localLE = ((AT)paramList.get(j)).h.d();
      Integer localInteger = (Integer)AV.b().get(localLE);
      if (localInteger != null)
      {
        a(1 + localInteger.intValue(), 15, 0);
        a(((AT)paramList.get(j)).i);
      }
      for (;;)
      {
        j++;
        break;
        this.a.a(0);
        a(localLE);
        a(((AT)paramList.get(j)).i);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AX
 * JD-Core Version:    0.7.0.1
 */