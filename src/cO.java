import java.lang.reflect.Constructor;

public enum cO
{
  private Class B;
  
  static
  {
    A = new cO("Linear", 26, dg.class);
    cO[] arrayOfcO = new cO[27];
    arrayOfcO[0] = a;
    arrayOfcO[1] = b;
    arrayOfcO[2] = c;
    arrayOfcO[3] = d;
    arrayOfcO[4] = e;
    arrayOfcO[5] = f;
    arrayOfcO[6] = g;
    arrayOfcO[7] = h;
    arrayOfcO[8] = i;
    arrayOfcO[9] = j;
    arrayOfcO[10] = k;
    arrayOfcO[11] = l;
    arrayOfcO[12] = m;
    arrayOfcO[13] = n;
    arrayOfcO[14] = o;
    arrayOfcO[15] = p;
    arrayOfcO[16] = q;
    arrayOfcO[17] = r;
    arrayOfcO[18] = s;
    arrayOfcO[19] = t;
    arrayOfcO[20] = u;
    arrayOfcO[21] = v;
    arrayOfcO[22] = w;
    arrayOfcO[23] = x;
    arrayOfcO[24] = y;
    arrayOfcO[25] = z;
    arrayOfcO[26] = A;
    C = arrayOfcO;
  }
  
  private cO(Class paramClass)
  {
    this.B = paramClass;
  }
  
  public cL a(float paramFloat)
  {
    try
    {
      Class localClass = this.B;
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Float.TYPE;
      Constructor localConstructor = localClass.getConstructor(arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Float.valueOf(paramFloat);
      cL localcL = (cL)localConstructor.newInstance(arrayOfObject);
      return localcL;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new Error("Can not init easingMethod instance");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cO
 * JD-Core Version:    0.7.0.1
 */