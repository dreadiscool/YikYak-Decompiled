import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class sz
  extends AbstractList<String>
  implements RandomAccess, sA
{
  public static final sA a = new sY(new sz());
  private final List<Object> b;
  
  public sz()
  {
    this.b = new ArrayList();
  }
  
  public sz(sA paramsA)
  {
    this.b = new ArrayList(paramsA.size());
    addAll(paramsA);
  }
  
  private static String a(Object paramObject)
  {
    String str;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    }
    for (;;)
    {
      return str;
      if ((paramObject instanceof rZ)) {
        str = ((rZ)paramObject).f();
      } else {
        str = su.b((byte[])paramObject);
      }
    }
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = this.b.get(paramInt);
    Object localObject2;
    if ((localObject1 instanceof String)) {
      localObject2 = (String)localObject1;
    }
    for (;;)
    {
      return localObject2;
      if ((localObject1 instanceof rZ))
      {
        rZ localrZ = (rZ)localObject1;
        String str2 = localrZ.f();
        if (localrZ.g()) {
          this.b.set(paramInt, str2);
        }
        localObject2 = str2;
      }
      else
      {
        byte[] arrayOfByte = (byte[])localObject1;
        String str1 = su.b(arrayOfByte);
        if (su.a(arrayOfByte)) {
          this.b.set(paramInt, str1);
        }
        localObject2 = str1;
      }
    }
  }
  
  public String a(int paramInt, String paramString)
  {
    return a(this.b.set(paramInt, paramString));
  }
  
  public List<?> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void a(rZ paramrZ)
  {
    this.b.add(paramrZ);
    this.modCount = (1 + this.modCount);
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    if ((paramCollection instanceof sA)) {
      paramCollection = ((sA)paramCollection).a();
    }
    boolean bool = this.b.addAll(paramInt, paramCollection);
    this.modCount = (1 + this.modCount);
    return bool;
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public String b(int paramInt)
  {
    Object localObject = this.b.remove(paramInt);
    this.modCount = (1 + this.modCount);
    return a(localObject);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.b.add(paramInt, paramString);
    this.modCount = (1 + this.modCount);
  }
  
  public void clear()
  {
    this.b.clear();
    this.modCount = (1 + this.modCount);
  }
  
  public int size()
  {
    return this.b.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sz
 * JD-Core Version:    0.7.0.1
 */