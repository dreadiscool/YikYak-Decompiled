import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class ql
  extends pm<Date>
{
  public static final pn a = new qm();
  private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
  private final DateFormat d = a();
  
  private static DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }
  
  private Date a(String paramString)
  {
    try
    {
      Date localDate3 = this.c.parse(paramString);
      localObject2 = localDate3;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        Date localDate2 = this.b.parse(paramString);
        localObject2 = localDate2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Date localDate1 = this.d.parse(paramString);
          Object localObject2 = localDate1;
        }
        catch (ParseException localParseException3)
        {
          throw new pi(paramString, localParseException3);
        }
      }
    }
    finally {}
    return localObject2;
  }
  
  public Date a(ro paramro)
  {
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    for (Date localDate = null;; localDate = a(paramro.h())) {
      return localDate;
    }
  }
  
  public void a(rr paramrr, Date paramDate)
  {
    if (paramDate == null) {}
    for (;;)
    {
      try
      {
        paramrr.f();
        return;
      }
      finally {}
      paramrr.b(this.b.format(paramDate));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ql
 * JD-Core Version:    0.7.0.1
 */