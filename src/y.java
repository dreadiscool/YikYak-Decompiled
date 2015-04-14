public class y
{
  private y(m paramm) {}
  
  public m<TResult> a()
  {
    return this.a;
  }
  
  public boolean a(Exception paramException)
  {
    boolean bool = true;
    synchronized (m.a(this.a))
    {
      if (m.b(this.a))
      {
        bool = false;
      }
      else
      {
        m.a(this.a, true);
        m.a(this.a, paramException);
        m.a(this.a).notifyAll();
        m.c(this.a);
      }
    }
    return bool;
  }
  
  public boolean a(TResult paramTResult)
  {
    boolean bool = true;
    synchronized (m.a(this.a))
    {
      if (m.b(this.a))
      {
        bool = false;
      }
      else
      {
        m.a(this.a, true);
        m.a(this.a, paramTResult);
        m.a(this.a).notifyAll();
        m.c(this.a);
      }
    }
    return bool;
  }
  
  public void b(Exception paramException)
  {
    if (!a(paramException)) {
      throw new IllegalStateException("Cannot set the error on a completed task.");
    }
  }
  
  public void b(TResult paramTResult)
  {
    if (!a(paramTResult)) {
      throw new IllegalStateException("Cannot set the result of a completed task.");
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    synchronized (m.a(this.a))
    {
      if (m.b(this.a))
      {
        bool = false;
      }
      else
      {
        m.a(this.a, true);
        m.b(this.a, true);
        m.a(this.a).notifyAll();
        m.c(this.a);
      }
    }
    return bool;
  }
  
  public void c()
  {
    if (!b()) {
      throw new IllegalStateException("Cannot cancel a completed task.");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     y
 * JD-Core Version:    0.7.0.1
 */