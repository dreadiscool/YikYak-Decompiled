class Kl
  implements Runnable
{
  Kl(Kk paramKk, Object paramObject, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this.c.c.a(this.a);
      if (this.b) {
        this.c.c.e();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.c.a, "Failed to record event.", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kl
 * JD-Core Version:    0.7.0.1
 */