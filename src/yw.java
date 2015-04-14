import com.nispok.snackbar.Snackbar;

class yw
  implements Runnable
{
  yw(yv paramyv) {}
  
  public void run()
  {
    Snackbar.d(this.a.a, System.currentTimeMillis());
    if (Snackbar.h(this.a.a) == -1L) {
      Snackbar.b(this.a.a, this.a.a.e());
    }
    if (Snackbar.m(this.a.a)) {
      Snackbar.n(this.a.a);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yw
 * JD-Core Version:    0.7.0.1
 */