class yO
  extends LG
{
  yO(yN paramyN, LU paramLU, yL paramyL, zO paramzO)
  {
    super(paramLU);
  }
  
  public void close()
  {
    synchronized (this.c.a)
    {
      if (!yN.a(this.c))
      {
        yN.a(this.c, true);
        yL.b(this.c.a);
        super.close();
        this.b.a();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yO
 * JD-Core Version:    0.7.0.1
 */