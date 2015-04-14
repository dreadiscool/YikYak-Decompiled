import com.parse.ParseException;
import com.parse.SaveCallback;

public final class BW
  extends SaveCallback
{
  public void done(ParseException paramParseException)
  {
    boolean bool1 = true;
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool2;
    if (paramParseException == null)
    {
      bool2 = bool1;
      Ip.a("setParseChannel", bool2 + "");
      if (paramParseException != null) {
        break label51;
      }
    }
    for (;;)
    {
      ApplicationConfig.setChannelStatus(bool1);
      return;
      bool2 = false;
      break;
      label51:
      bool1 = false;
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     BW

 * JD-Core Version:    0.7.0.1

 */