import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class zc
{
  private final Map<String, List<LE>> a = new LinkedHashMap();
  
  public za a()
  {
    return new za(this, null);
  }
  
  public zc a(String paramString, String... paramVarArgs)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("hostname == null");
    }
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.a.put(paramString, Collections.unmodifiableList(localArrayList));
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramVarArgs[j];
      if (!str.startsWith("sha1/")) {
        throw new IllegalArgumentException("pins must start with 'sha1/': " + str);
      }
      LE localLE = LE.b(str.substring("sha1/".length()));
      if (localLE == null) {
        throw new IllegalArgumentException("pins must be base64: " + str);
      }
      localArrayList.add(localLE);
    }
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zc
 * JD-Core Version:    0.7.0.1
 */