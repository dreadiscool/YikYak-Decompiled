class Km
  implements Runnable
{
  Km(Kk paramKk, Object paramObject) {}
  
  public void run()
  {
    try
    {
      this.b.c.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.b.a, "Crashlytics failed to record event", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Km
 * JD-Core Version:    0.7.0.1
 */