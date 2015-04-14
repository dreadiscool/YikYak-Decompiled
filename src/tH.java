public class tH
  extends Exception
{
  private int a;
  
  public tH(int paramInt)
  {
    this.a = paramInt;
  }
  
  public tH(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public tH(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tH
 * JD-Core Version:    0.7.0.1
 */