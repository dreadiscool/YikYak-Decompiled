class Kn
  implements Runnable
{
  Kn(Kk paramKk) {}
  
  public void run()
  {
    try
    {
      this.a.c.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.a.a, "Failed to send events files.", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kn
 * JD-Core Version:    0.7.0.1
 */