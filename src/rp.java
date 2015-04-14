final class rp
  extends pM
{
  public void a(ro paramro)
  {
    if ((paramro instanceof qn)) {
      ((qn)paramro).o();
    }
    for (;;)
    {
      return;
      int i = ro.a(paramro);
      if (i == 0) {
        i = ro.b(paramro);
      }
      if (i == 13)
      {
        ro.a(paramro, 9);
      }
      else if (i == 12)
      {
        ro.a(paramro, 8);
      }
      else
      {
        if (i != 14) {
          break;
        }
        ro.a(paramro, 10);
      }
    }
    throw new IllegalStateException("Expected a name but was " + paramro.f() + " " + " at line " + ro.c(paramro) + " column " + ro.d(paramro));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rp
 * JD-Core Version:    0.7.0.1
 */