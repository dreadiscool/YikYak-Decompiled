import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class tZ
  implements tV
{
  private byte[] a;
  private TreeMap<String, String> b = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  
  public void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public String b(String paramString)
  {
    String str = (String)this.b.get(paramString);
    if (str == null) {
      str = "";
    }
    return str;
  }
  
  public Iterator<String> b()
  {
    return Collections.unmodifiableSet(this.b.keySet()).iterator();
  }
  
  public boolean c(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public byte[] c()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tZ
 * JD-Core Version:    0.7.0.1
 */