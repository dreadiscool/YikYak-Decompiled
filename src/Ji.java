import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

 enum Ji
{
  private static final Map<String, Ji> k;
  
  static
  {
    Ji[] arrayOfJi = new Ji[10];
    arrayOfJi[0] = a;
    arrayOfJi[1] = b;
    arrayOfJi[2] = c;
    arrayOfJi[3] = d;
    arrayOfJi[4] = e;
    arrayOfJi[5] = f;
    arrayOfJi[6] = g;
    arrayOfJi[7] = h;
    arrayOfJi[8] = i;
    arrayOfJi[9] = j;
    l = arrayOfJi;
    k = new HashMap(4);
    k.put("armeabi-v7a", g);
    k.put("armeabi", f);
    k.put("x86", a);
  }
  
  private Ji() {}
  
  static Ji a()
  {
    String str1 = Build.CPU_ABI;
    Ji localJi;
    if (TextUtils.isEmpty(str1))
    {
      IC.g();
      localJi = h;
    }
    for (;;)
    {
      return localJi;
      String str2 = str1.toLowerCase(Locale.US);
      localJi = (Ji)k.get(str2);
      if (localJi == null) {
        localJi = h;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ji
 * JD-Core Version:    0.7.0.1
 */