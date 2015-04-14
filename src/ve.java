import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ve
  implements vd
{
  private final Context a;
  private final Map<String, Integer> b;
  private final SparseArray<String> c;
  
  protected ve(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
    this.c = new SparseArray();
  }
  
  private static void a(Class<?> paramClass, String paramString, Map<String, Integer> paramMap)
  {
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = paramClass.getFields();
        i = 0;
        if (i < arrayOfField.length)
        {
          Field localField = arrayOfField[i];
          if ((Modifier.isStatic(localField.getModifiers())) && (localField.getType() == Integer.TYPE))
          {
            Object localObject = localField.getName();
            int j = localField.getInt(null);
            if (paramString == null)
            {
              paramMap.put(localObject, Integer.valueOf(j));
            }
            else
            {
              String str = paramString + ":" + (String)localObject;
              localObject = str;
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        new StringBuilder().append("Can't read built-in id names from ").append(paramClass.getName()).toString();
      }
      i++;
    }
  }
  
  protected abstract Class<?> a();
  
  public String a(int paramInt)
  {
    return (String)this.c.get(paramInt);
  }
  
  protected abstract String a(Context paramContext);
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public int b(String paramString)
  {
    return ((Integer)this.b.get(paramString)).intValue();
  }
  
  protected void b()
  {
    this.b.clear();
    this.c.clear();
    a(a(), "android", this.b);
    String str = a(this.a);
    try
    {
      a(Class.forName(str), null, this.b);
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.c.put(((Integer)localEntry.getValue()).intValue(), localEntry.getKey());
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        new StringBuilder().append("Can't load names for Android view ids from '").append(str).append("', ids by name will not be available in the events editor.").toString();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ve
 * JD-Core Version:    0.7.0.1
 */