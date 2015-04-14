class T
  implements Runnable
{
  T(S paramS, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     T
 * JD-Core Version:    0.7.0.1
 */