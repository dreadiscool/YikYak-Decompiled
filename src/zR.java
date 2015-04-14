import java.io.Closeable;

public final class zR
  implements Closeable
{
  private final String b;
  private final long c;
  private final LV[] d;
  private final long[] e;
  
  private zR(zL paramzL, String paramString, long paramLong, LV[] paramArrayOfLV, long[] paramArrayOfLong)
  {
    this.b = paramString;
    this.c = paramLong;
    this.d = paramArrayOfLV;
    this.e = paramArrayOfLong;
  }
  
  public LV a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public zO a()
  {
    return zL.a(this.a, this.b, this.c);
  }
  
  public void close()
  {
    LV[] arrayOfLV = this.d;
    int i = arrayOfLV.length;
    for (int j = 0; j < i; j++) {
      Ae.a(arrayOfLV[j]);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zR
 * JD-Core Version:    0.7.0.1
 */