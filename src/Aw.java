import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class Aw
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setLenient(false);
    localSimpleDateFormat.setTimeZone(Av.a());
    return localSimpleDateFormat;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Aw
 * JD-Core Version:    0.7.0.1
 */