final class wX
  implements Runnable
{
  wX(wV paramwV, String paramString, int paramInt) {}
  
  public final void run()
  {
    this.a.i.B(this.b);
    this.a.i.C(Integer.toString(this.c));
    this.a.d = true;
    if ((this.a.e) && (!this.a.g)) {}
    synchronized (this.a.k)
    {
      this.a.k.notifyAll();
      this.a.g = true;
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wX
 * JD-Core Version:    0.7.0.1
 */