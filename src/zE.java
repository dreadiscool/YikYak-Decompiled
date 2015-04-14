import java.io.File;

final class zE
  extends zC
{
  zE(zt paramzt, File paramFile) {}
  
  public zt a()
  {
    return this.a;
  }
  
  public void a(LC paramLC)
  {
    LV localLV = null;
    try
    {
      localLV = LK.a(this.b);
      paramLC.a(localLV);
      return;
    }
    finally
    {
      Ae.a(localLV);
    }
  }
  
  public long b()
  {
    return this.b.length();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zE
 * JD-Core Version:    0.7.0.1
 */