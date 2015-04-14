import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class aO
  implements aJ
{
  private final File a;
  private final Map<String, String> b;
  
  public aO(File paramFile)
  {
    this(paramFile, Collections.emptyMap());
  }
  
  public aO(File paramFile, Map<String, String> paramMap)
  {
    this.a = paramFile;
    this.b = new HashMap(paramMap);
    if (this.a.length() == 0L) {
      this.b.putAll(aK.a);
    }
  }
  
  public boolean a()
  {
    IC.g();
    new StringBuilder().append("Removing report at ").append(this.a.getPath()).toString();
    return this.a.delete();
  }
  
  public String b()
  {
    return d().getName();
  }
  
  public String c()
  {
    String str = b();
    return str.substring(0, str.lastIndexOf('.'));
  }
  
  public File d()
  {
    return this.a;
  }
  
  public Map<String, String> e()
  {
    return Collections.unmodifiableMap(this.b);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aO
 * JD-Core Version:    0.7.0.1
 */