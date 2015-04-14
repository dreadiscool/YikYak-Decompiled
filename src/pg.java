import java.math.BigInteger;

public final class pg
  extends pb
{
  private static final Class<?>[] a;
  private Object b;
  
  static
  {
    Class[] arrayOfClass = new Class[16];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Long.TYPE;
    arrayOfClass[2] = Short.TYPE;
    arrayOfClass[3] = Float.TYPE;
    arrayOfClass[4] = Double.TYPE;
    arrayOfClass[5] = Byte.TYPE;
    arrayOfClass[6] = Boolean.TYPE;
    arrayOfClass[7] = Character.TYPE;
    arrayOfClass[8] = Integer.class;
    arrayOfClass[9] = Long.class;
    arrayOfClass[10] = Short.class;
    arrayOfClass[11] = Float.class;
    arrayOfClass[12] = Double.class;
    arrayOfClass[13] = Byte.class;
    arrayOfClass[14] = Boolean.class;
    arrayOfClass[15] = Character.class;
    a = arrayOfClass;
  }
  
  public pg(Boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public pg(Number paramNumber)
  {
    a(paramNumber);
  }
  
  public pg(String paramString)
  {
    a(paramString);
  }
  
  private static boolean a(pg parampg)
  {
    boolean bool;
    if ((parampg.b instanceof Number))
    {
      Number localNumber = (Number)parampg.b;
      if (((localNumber instanceof BigInteger)) || ((localNumber instanceof Long)) || ((localNumber instanceof Integer)) || ((localNumber instanceof Short)) || ((localNumber instanceof Byte))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private static boolean b(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof String)) {}
    for (;;)
    {
      return bool;
      Class localClass = paramObject.getClass();
      Class[] arrayOfClass = a;
      int i = arrayOfClass.length;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          break label51;
        }
        if (arrayOfClass[j].isAssignableFrom(localClass)) {
          break;
        }
      }
      label51:
      bool = false;
    }
  }
  
  public Number a()
  {
    if ((this.b instanceof String)) {}
    for (Object localObject = new pN((String)this.b);; localObject = (Number)this.b) {
      return localObject;
    }
  }
  
  void a(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.b = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    if (((paramObject instanceof Number)) || (b(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      ps.a(bool);
      this.b = paramObject;
      break;
    }
  }
  
  public String b()
  {
    String str;
    if (p()) {
      str = a().toString();
    }
    for (;;)
    {
      return str;
      if (o()) {
        str = n().toString();
      } else {
        str = (String)this.b;
      }
    }
  }
  
  public double c()
  {
    if (p()) {}
    for (double d = a().doubleValue();; d = Double.parseDouble(b())) {
      return d;
    }
  }
  
  public long d()
  {
    if (p()) {}
    for (long l = a().longValue();; l = Long.parseLong(b())) {
      return l;
    }
  }
  
  public int e()
  {
    if (p()) {}
    for (int i = a().intValue();; i = Integer.parseInt(b())) {
      return i;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this == paramObject) {}
    for (;;)
    {
      return bool1;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool1 = false;
      }
      else
      {
        pg localpg = (pg)paramObject;
        if (this.b == null)
        {
          if (localpg.b != null) {
            bool1 = false;
          }
        }
        else if ((a(this)) && (a(localpg)))
        {
          if (a().longValue() != localpg.a().longValue()) {
            bool1 = false;
          }
        }
        else if (((this.b instanceof Number)) && ((localpg.b instanceof Number)))
        {
          double d1 = a().doubleValue();
          double d2 = localpg.a().doubleValue();
          if ((d1 == d2) || ((Double.isNaN(d1)) && (Double.isNaN(d2)))) {
            bool2 = bool1;
          }
          bool1 = bool2;
        }
        else
        {
          bool1 = this.b.equals(localpg.b);
        }
      }
    }
  }
  
  public boolean f()
  {
    if (o()) {}
    for (boolean bool = n().booleanValue();; bool = Boolean.parseBoolean(b())) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    int i;
    if (this.b == null) {
      i = 31;
    }
    for (;;)
    {
      return i;
      if (a(this))
      {
        long l2 = a().longValue();
        i = (int)(l2 ^ l2 >>> 32);
      }
      else if ((this.b instanceof Number))
      {
        long l1 = Double.doubleToLongBits(a().doubleValue());
        i = (int)(l1 ^ l1 >>> 32);
      }
      else
      {
        i = this.b.hashCode();
      }
    }
  }
  
  Boolean n()
  {
    return (Boolean)this.b;
  }
  
  public boolean o()
  {
    return this.b instanceof Boolean;
  }
  
  public boolean p()
  {
    return this.b instanceof Number;
  }
  
  public boolean q()
  {
    return this.b instanceof String;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pg
 * JD-Core Version:    0.7.0.1
 */