import java.io.InputStream;
import java.util.Properties;

class bi
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  
  bi(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static bi a(InputStream paramInputStream)
  {
    Properties localProperties = new Properties();
    localProperties.load(paramInputStream);
    return a(localProperties);
  }
  
  public static bi a(Properties paramProperties)
  {
    return new bi(paramProperties.getProperty("version_code"), paramProperties.getProperty("version_name"), paramProperties.getProperty("build_id"), paramProperties.getProperty("package_name"));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.7.0.1
 */