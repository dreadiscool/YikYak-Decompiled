import java.io.Writer;

final class qa
  extends Writer
{
  private final Appendable a;
  private final qb b = new qb();
  
  private qa(Appendable paramAppendable)
  {
    this.a = paramAppendable;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt)
  {
    this.a.append((char)paramInt);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.b.a = paramArrayOfChar;
    this.a.append(this.b, paramInt1, paramInt1 + paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qa
 * JD-Core Version:    0.7.0.1
 */