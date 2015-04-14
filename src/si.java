import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class si<FieldDescriptorType extends sk<FieldDescriptorType>>
{
  private static final si d = new si(true);
  private final sP<FieldDescriptorType, Object> a;
  private boolean b;
  private boolean c = false;
  
  private si()
  {
    this.a = sP.a(16);
  }
  
  private si(boolean paramBoolean)
  {
    this.a = sP.a(0);
    c();
  }
  
  static int a(te paramte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = paramte.c()) {
      return i;
    }
  }
  
  public static Object a(sc paramsc, te paramte, boolean paramBoolean)
  {
    Object localObject;
    switch (sj.b[paramte.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      localObject = Double.valueOf(paramsc.b());
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      for (;;)
      {
        return localObject;
        localObject = Float.valueOf(paramsc.c());
        continue;
        localObject = Long.valueOf(paramsc.e());
        continue;
        localObject = Long.valueOf(paramsc.d());
        continue;
        localObject = Integer.valueOf(paramsc.f());
        continue;
        localObject = Long.valueOf(paramsc.g());
        continue;
        localObject = Integer.valueOf(paramsc.h());
        continue;
        localObject = Boolean.valueOf(paramsc.i());
        continue;
        if (paramBoolean)
        {
          localObject = paramsc.k();
        }
        else
        {
          localObject = paramsc.j();
          continue;
          localObject = paramsc.l();
          continue;
          localObject = Integer.valueOf(paramsc.m());
          continue;
          localObject = Integer.valueOf(paramsc.o());
          continue;
          localObject = Long.valueOf(paramsc.p());
          continue;
          localObject = Integer.valueOf(paramsc.q());
          continue;
          localObject = Long.valueOf(paramsc.r());
        }
      }
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  public static <T extends sk<T>> si<T> a()
  {
    return new si();
  }
  
  private static void a(te paramte, Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      throw new NullPointerException();
    }
    switch (sj.a[paramte.b().ordinal()])
    {
    }
    while (!bool)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof rZ)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof sv)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof sE)) || ((paramObject instanceof sy))) {
            bool = true;
          }
        }
      }
    }
  }
  
  private boolean a(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    sk localsk = (sk)paramEntry.getKey();
    boolean bool;
    if (localsk.b() == tj.i) {
      if (localsk.c())
      {
        Iterator localIterator = ((List)paramEntry.getValue()).iterator();
        while (localIterator.hasNext()) {
          if (!((sE)localIterator.next()).j()) {
            bool = false;
          }
        }
      }
    }
    for (;;)
    {
      return bool;
      Object localObject = paramEntry.getValue();
      if ((localObject instanceof sE))
      {
        if (!((sE)localObject).j()) {
          bool = false;
        }
      }
      else
      {
        if ((localObject instanceof sy))
        {
          bool = true;
          continue;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      bool = true;
    }
  }
  
  public static <T extends sk<T>> si<T> b()
  {
    return d;
  }
  
  private void b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    sk localsk = (sk)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    if ((localObject1 instanceof sy)) {
      localObject1 = ((sy)localObject1).a();
    }
    Object localObject4;
    if (localsk.c())
    {
      localObject4 = a(localsk);
      if (localObject4 == null) {
        this.a.a(localsk, new ArrayList((List)localObject1));
      }
    }
    for (;;)
    {
      return;
      ((List)localObject4).addAll((List)localObject1);
      continue;
      if (localsk.b() == tj.i)
      {
        Object localObject2 = a(localsk);
        if (localObject2 == null)
        {
          this.a.a(localsk, localObject1);
        }
        else
        {
          if ((localObject2 instanceof sH)) {}
          for (Object localObject3 = localsk.a((sH)localObject2, (sH)localObject1);; localObject3 = localsk.a(((sE)localObject2).n(), (sE)localObject1).h())
          {
            this.a.a(localsk, localObject3);
            break;
          }
        }
      }
      else
      {
        this.a.a(localsk, localObject1);
      }
    }
  }
  
  public Object a(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.a.get(paramFieldDescriptorType);
    if ((localObject instanceof sy)) {
      localObject = ((sy)localObject).a();
    }
    return localObject;
  }
  
  public void a(si<FieldDescriptorType> paramsi)
  {
    for (int i = 0; i < paramsi.a.c(); i++) {
      b(paramsi.a.b(i));
    }
    Iterator localIterator = paramsi.a.d().iterator();
    while (localIterator.hasNext()) {
      b((Map.Entry)localIterator.next());
    }
  }
  
  public void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.c())
    {
      if (!(paramObject instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        a(paramFieldDescriptorType.a(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof sy)) {
        this.c = true;
      }
      this.a.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.a(), paramObject);
    }
  }
  
  public void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.c()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    a(paramFieldDescriptorType.a(), paramObject);
    Object localObject1 = a(paramFieldDescriptorType);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new ArrayList();
      this.a.a(paramFieldDescriptorType, localObject2);
    }
    for (;;)
    {
      ((List)localObject2).add(paramObject);
      return;
      localObject2 = (List)localObject1;
    }
  }
  
  public void c()
  {
    if (this.b) {}
    for (;;)
    {
      return;
      this.a.a();
      this.b = true;
    }
  }
  
  public si<FieldDescriptorType> d()
  {
    si localsi = a();
    for (int i = 0; i < this.a.c(); i++)
    {
      Map.Entry localEntry2 = this.a.b(i);
      localsi.a((sk)localEntry2.getKey(), localEntry2.getValue());
    }
    Iterator localIterator = this.a.d().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      localsi.a((sk)localEntry1.getKey(), localEntry1.getValue());
    }
    localsi.c = this.c;
    return localsi;
  }
  
  public boolean e()
  {
    boolean bool = false;
    int i = 0;
    if (i < this.a.c()) {
      if (a(this.a.b(i))) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      Iterator localIterator = this.a.d().iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (!a((Map.Entry)localIterator.next())) {
            break;
          }
        }
      }
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     si
 * JD-Core Version:    0.7.0.1
 */