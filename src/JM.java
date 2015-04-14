class JM
  implements Runnable
{
  JM(JL paramJL, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.b.a();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JM
 * JD-Core Version:    0.7.0.1
 */