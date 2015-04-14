import android.view.View;
import java.util.HashMap;
import java.util.Map;

public final class xw
  extends xQ
{
  private static final Map<String, xZ> h = new HashMap();
  private Object i;
  private String j;
  private xZ k;
  
  static
  {
    h.put("alpha", xx.a);
    h.put("pivotX", xx.b);
    h.put("pivotY", xx.c);
    h.put("translationX", xx.d);
    h.put("translationY", xx.e);
    h.put("rotation", xx.f);
    h.put("rotationX", xx.g);
    h.put("rotationY", xx.h);
    h.put("scaleX", xx.i);
    h.put("scaleY", xx.j);
    h.put("scrollX", xx.k);
    h.put("scrollY", xx.l);
    h.put("x", xx.m);
    h.put("y", xx.n);
  }
  
  public xw() {}
  
  private xw(Object paramObject, String paramString)
  {
    this.i = paramObject;
    a(paramString);
  }
  
  public static xw a(Object paramObject, String paramString, float... paramVarArgs)
  {
    xw localxw = new xw(paramObject, paramString);
    localxw.a(paramVarArgs);
    return localxw;
  }
  
  public void a()
  {
    super.a();
  }
  
  void a(float paramFloat)
  {
    super.a(paramFloat);
    int m = this.f.length;
    for (int n = 0; n < m; n++) {
      this.f[n].b(this.i);
    }
  }
  
  public void a(String paramString)
  {
    if (this.f != null)
    {
      xM localxM = this.f[0];
      String str = localxM.c();
      localxM.a(paramString);
      this.g.remove(str);
      this.g.put(paramString, localxM);
    }
    this.j = paramString;
    this.e = false;
  }
  
  public void a(xZ paramxZ)
  {
    if (this.f != null)
    {
      xM localxM = this.f[0];
      String str = localxM.c();
      localxM.a(paramxZ);
      this.g.remove(str);
      this.g.put(this.j, localxM);
    }
    if (this.k != null) {
      this.j = paramxZ.a();
    }
    this.k = paramxZ;
    this.e = false;
  }
  
  public void a(float... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0)) {
      if (this.k != null)
      {
        xM[] arrayOfxM2 = new xM[1];
        arrayOfxM2[0] = xM.a(this.k, paramVarArgs);
        a(arrayOfxM2);
      }
    }
    for (;;)
    {
      return;
      xM[] arrayOfxM1 = new xM[1];
      arrayOfxM1[0] = xM.a(this.j, paramVarArgs);
      a(arrayOfxM1);
      continue;
      super.a(paramVarArgs);
    }
  }
  
  public xw b(long paramLong)
  {
    super.c(paramLong);
    return this;
  }
  
  void d()
  {
    if (!this.e)
    {
      if ((this.k == null) && (yc.a) && ((this.i instanceof View)) && (h.containsKey(this.j))) {
        a((xZ)h.get(this.j));
      }
      int m = this.f.length;
      for (int n = 0; n < m; n++) {
        this.f[n].a(this.i);
      }
      super.d();
    }
  }
  
  public xw e()
  {
    return (xw)super.f();
  }
  
  public String toString()
  {
    String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
    if (this.f != null) {
      for (int m = 0; m < this.f.length; m++) {
        str = str + "\n    " + this.f[m].toString();
      }
    }
    return str;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xw
 * JD-Core Version:    0.7.0.1
 */