import java.util.Calendar;
import java.util.GregorianCalendar;

final class qW
  extends pm<Calendar>
{
  public Calendar a(ro paramro)
  {
    int i = 0;
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    int j;
    int k;
    int m;
    int n;
    int i1;
    for (Object localObject = null;; localObject = new GregorianCalendar(i1, n, m, k, j, i))
    {
      return localObject;
      paramro.c();
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      while (paramro.f() != rq.d)
      {
        String str = paramro.g();
        int i2 = paramro.m();
        if ("year".equals(str)) {
          i1 = i2;
        } else if ("month".equals(str)) {
          n = i2;
        } else if ("dayOfMonth".equals(str)) {
          m = i2;
        } else if ("hourOfDay".equals(str)) {
          k = i2;
        } else if ("minute".equals(str)) {
          j = i2;
        } else if ("second".equals(str)) {
          i = i2;
        }
      }
      paramro.d();
    }
  }
  
  public void a(rr paramrr, Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      paramrr.d();
      paramrr.a("year");
      paramrr.a(paramCalendar.get(1));
      paramrr.a("month");
      paramrr.a(paramCalendar.get(2));
      paramrr.a("dayOfMonth");
      paramrr.a(paramCalendar.get(5));
      paramrr.a("hourOfDay");
      paramrr.a(paramCalendar.get(11));
      paramrr.a("minute");
      paramrr.a(paramCalendar.get(12));
      paramrr.a("second");
      paramrr.a(paramCalendar.get(13));
      paramrr.e();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qW
 * JD-Core Version:    0.7.0.1
 */