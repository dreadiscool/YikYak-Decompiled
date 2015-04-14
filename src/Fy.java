import com.yik.yak.ui.fragment.CommentFragment;

class Fy
  implements Runnable
{
  Fy(Fx paramFx) {}
  
  public void run()
  {
    try
    {
      if (this.a.c)
      {
        If.a().a(this.a.f.k);
        if (this.a.d == null) {
          CommentFragment.a(this.a.f);
        }
        for (;;)
        {
          this.a.f.a();
          return;
          this.a.f.a();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (this.a.d != null)
        {
          CM.a(this.a.f.getActivity()).c("YakBak", this.a.d.c);
          if (this.a.e) {
            Ca.a(this.a.d.a());
          }
        }
        else
        {
          CM.a(this.a.f.getActivity()).c("Yak", this.a.f.k.b);
          if (this.a.e) {
            Ca.a(this.a.f.k.a());
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fy
 * JD-Core Version:    0.7.0.1
 */