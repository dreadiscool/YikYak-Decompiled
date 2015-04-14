class bg
  implements Runnable
{
  bg(bf parambf, KT paramKT, String paramString) {}
  
  public void run()
  {
    try
    {
      ((ba)bf.a(this.c)).a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(aR.b().C(), "Crashlytics failed to set analytics settings data.", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bg
 * JD-Core Version:    0.7.0.1
 */