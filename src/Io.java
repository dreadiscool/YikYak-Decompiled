import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Io
  extends Date
{
  private TimeZone a = TimeZone.getTimeZone("GMT-4:00");
  private Calendar b = Calendar.getInstance(this.a);
  private SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  private String a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      if (paramLong != 1L) {}
    }
    for (;;)
    {
      return paramString;
      paramString = paramString + "s";
      continue;
      paramString = String.valueOf(paramString.charAt(0));
    }
  }
  
  public static Calendar a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    Object localObject = new Date();
    this.c.setTimeZone(this.a);
    try
    {
      Date localDate = this.c.parse(paramString);
      localObject = localDate;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        long l1;
        double d;
        long l2;
        String str;
        localParseException.printStackTrace();
        continue;
        if (d < 3600.0D)
        {
          int m = (int)Math.round(d / 60.0D);
          str = m + a("minute", paramBoolean, m);
        }
        else if (d < 86400.0D)
        {
          int k = (int)(Math.round(d) / 60L / 60L);
          str = k + a("hour", paramBoolean, k);
        }
        else if (d < 604800.0D)
        {
          int j = (int)Math.round(d / 60.0D / 60.0D / 24.0D);
          str = j + a("day", paramBoolean, j);
        }
        else
        {
          int i = (int)Math.round(d / 60.0D / 60.0D / 24.0D / 7.0D);
          str = i + a("week", paramBoolean, i);
        }
      }
    }
    l1 = (a((Date)localObject).getTimeInMillis() / 1000.0D);
    d = (this.b.getTimeInMillis() / 1000.0D) - l1;
    if (d < 0.0D) {
      d = 0.0D;
    }
    if (d < 60.0D)
    {
      l2 = 3L + Math.round(d / 1.0D);
      str = l2 + a("second", paramBoolean, l2);
      return str;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Io
 * JD-Core Version:    0.7.0.1
 */