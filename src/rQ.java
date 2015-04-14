class rQ
  extends Number
  implements Comparable<rQ>
{
  private double a;
  private long b;
  private boolean c;
  
  private rQ(long paramLong)
  {
    this.b = paramLong;
    this.c = true;
  }
  
  public static rQ a(long paramLong)
  {
    return new rQ(paramLong);
  }
  
  public int a(rQ paramrQ)
  {
    if ((b()) && (paramrQ.b())) {}
    for (int i = new Long(this.b).compareTo(Long.valueOf(paramrQ.b));; i = Double.compare(doubleValue(), paramrQ.doubleValue())) {
      return i;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public long c()
  {
    if (b()) {}
    for (long l = this.b;; l = this.a) {
      return l;
    }
  }
  
  public int d()
  {
    return (int)longValue();
  }
  
  public double doubleValue()
  {
    if (b()) {}
    for (double d = this.b;; d = this.a) {
      return d;
    }
  }
  
  public short e()
  {
    return (short)(int)longValue();
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof rQ)) && (a((rQ)paramObject) == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return d();
  }
  
  public long longValue()
  {
    return c();
  }
  
  public short shortValue()
  {
    return e();
  }
  
  public String toString()
  {
    if (b()) {}
    for (String str = Long.toString(this.b);; str = Double.toString(this.a)) {
      return str;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rQ
 * JD-Core Version:    0.7.0.1
 */