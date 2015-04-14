class GU
  implements Runnable
{
  GU(GT paramGT) {}
  
  public void run()
  {
    if (GT.a(this.a) == 1) {
      this.a.a(GT.b(this.a), GT.c(this.a), GT.d(this.a));
    }
    GT.a(this.a, 0);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GU
 * JD-Core Version:    0.7.0.1
 */