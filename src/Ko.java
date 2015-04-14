class Ko
  implements Runnable
{
  Ko(Kk paramKk) {}
  
  public void run()
  {
    try
    {
      Ks localKs = this.a.c;
      this.a.c = this.a.a();
      localKs.c();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.a.a, "Failed to disable events.", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ko
 * JD-Core Version:    0.7.0.1
 */