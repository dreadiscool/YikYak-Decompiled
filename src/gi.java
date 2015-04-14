import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class gi<T extends gh>
{
  Context a;
  gj<T> b;
  
  public gi(Context paramContext, gj<T> paramgj)
  {
    this.a = paramContext;
    this.b = paramgj;
  }
  
  private T a(XmlResourceParser paramXmlResourceParser)
  {
    try
    {
      paramXmlResourceParser.next();
      int i = paramXmlResourceParser.getEventType();
      if (i != 1)
      {
        if (paramXmlResourceParser.getEventType() == 2)
        {
          str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname")) {
            break label99;
          }
          String str8 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str9 = paramXmlResourceParser.nextText().trim();
          if (!TextUtils.isEmpty(str8)) {
            TextUtils.isEmpty(str9);
          }
        }
        for (;;)
        {
          i = paramXmlResourceParser.next();
          break;
          label99:
          if (!str1.equals("string")) {
            break label193;
          }
          String str6 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str7 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str6)) && (str7 != null)) {
            this.b.a(str6, str7);
          }
        }
      }
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      for (;;)
      {
        fA.a("Error parsing tracker configuration file: " + localXmlPullParserException);
        return this.b.a();
        if (!str1.equals("bool")) {
          break;
        }
        String str4 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str5 = paramXmlResourceParser.nextText().trim();
        if (!TextUtils.isEmpty(str4))
        {
          boolean bool2 = TextUtils.isEmpty(str5);
          if (!bool2) {
            try
            {
              boolean bool3 = Boolean.parseBoolean(str5);
              this.b.a(str4, bool3);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              fA.a("Error parsing bool configuration value: " + str5);
            }
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str1;
        label193:
        fA.a("Error parsing tracker configuration file: " + localIOException);
        continue;
        if (str1.equals("integer"))
        {
          String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str3 = paramXmlResourceParser.nextText().trim();
          if (!TextUtils.isEmpty(str2))
          {
            boolean bool1 = TextUtils.isEmpty(str3);
            if (!bool1) {
              try
              {
                int j = Integer.parseInt(str3);
                this.b.a(str2, j);
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                fA.a("Error parsing int configuration value: " + str3);
              }
            }
          }
        }
      }
    }
  }
  
  public T a(int paramInt)
  {
    try
    {
      gh localgh2 = a(this.a.getResources().getXml(paramInt));
      localgh1 = localgh2;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        fA.d("inflate() called with unknown resourceId: " + localNotFoundException);
        gh localgh1 = null;
      }
    }
    return localgh1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gi
 * JD-Core Version:    0.7.0.1
 */