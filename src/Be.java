final class Be
{
  private final Be[] a;
  private final int b;
  private final int c;
  
  Be()
  {
    this.a = new Be[256];
    this.b = 0;
    this.c = 0;
  }
  
  Be(int paramInt1, int paramInt2)
  {
    this.a = null;
    this.b = paramInt1;
    int i = paramInt2 & 0x7;
    if (i == 0) {
      i = 8;
    }
    this.c = i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Be
 * JD-Core Version:    0.7.0.1
 */