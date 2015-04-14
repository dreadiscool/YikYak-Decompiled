import java.net.Socket;

abstract class Ap
  implements LV
{
  protected boolean a;
  
  private Ap(An paramAn) {}
  
  protected final void a()
  {
    Ae.a(An.f(this.b).d());
    An.a(this.b, 6);
  }
  
  protected final void a(boolean paramBoolean)
  {
    if (An.c(this.b) != 5) {
      throw new IllegalStateException("state: " + An.c(this.b));
    }
    An.a(this.b, 0);
    if ((paramBoolean) && (An.d(this.b) == 1))
    {
      An.b(this.b, 0);
      zS.b.a(An.e(this.b), An.f(this.b));
    }
    for (;;)
    {
      return;
      if (An.d(this.b) == 2)
      {
        An.a(this.b, 6);
        An.f(this.b).d().close();
      }
    }
  }
  
  public LW b()
  {
    return An.b(this.b).b();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ap
 * JD-Core Version:    0.7.0.1
 */