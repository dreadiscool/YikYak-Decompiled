public abstract class jg<M extends jg<M>>
  extends jl
{
  protected ji m;
  
  public void a(je paramje)
  {
    if (this.m == null) {}
    for (;;)
    {
      return;
      for (int i = 0; i < this.m.a(); i++) {
        this.m.a(i).a(paramje);
      }
    }
  }
  
  protected final boolean a(M paramM)
  {
    boolean bool;
    if ((this.m == null) || (this.m.b())) {
      if ((paramM.m == null) || (paramM.m.b())) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = this.m.equals(paramM.m);
    }
  }
  
  protected int c()
  {
    int i = 0;
    if (this.m != null)
    {
      j = 0;
      while (i < this.m.a())
      {
        j += this.m.a(i).a();
        i++;
      }
    }
    int j = 0;
    return j;
  }
  
  protected final int d()
  {
    if ((this.m == null) || (this.m.b())) {}
    for (int i = 0;; i = this.m.hashCode()) {
      return i;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jg
 * JD-Core Version:    0.7.0.1
 */