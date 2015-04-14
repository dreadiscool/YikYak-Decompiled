import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

public class xQ
  extends xg
{
  private static ThreadLocal<xW> h = new ThreadLocal();
  private static final ThreadLocal<ArrayList<xQ>> i = new xR();
  private static final ThreadLocal<ArrayList<xQ>> j = new xS();
  private static final ThreadLocal<ArrayList<xQ>> k = new xT();
  private static final ThreadLocal<ArrayList<xQ>> l = new xU();
  private static final ThreadLocal<ArrayList<xQ>> m = new xV();
  private static final Interpolator n = new AccelerateDecelerateInterpolator();
  private static final xP o = new xs();
  private static final xP p = new xq();
  private static long z = 10L;
  private int A = 0;
  private int B = 1;
  private Interpolator C = n;
  private ArrayList<Object> D = null;
  long b;
  long c = -1L;
  int d = 0;
  boolean e = false;
  xM[] f;
  HashMap<String, xM> g;
  private boolean q = false;
  private int r = 0;
  private float s = 0.0F;
  private boolean t = false;
  private long u;
  private boolean v = false;
  private boolean w = false;
  private long x = 300L;
  private long y = 0L;
  
  private void a(boolean paramBoolean)
  {
    if (Looper.myLooper() == null) {
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }
    this.q = paramBoolean;
    this.r = 0;
    this.d = 0;
    this.w = true;
    this.t = false;
    ((ArrayList)j.get()).add(this);
    if (this.y == 0L)
    {
      d(g());
      this.d = 0;
      this.v = true;
      if (this.a != null)
      {
        ArrayList localArrayList = (ArrayList)this.a.clone();
        int i1 = localArrayList.size();
        for (int i2 = 0; i2 < i1; i2++) {
          ((xh)localArrayList.get(i2)).a(this);
        }
      }
    }
    xW localxW = (xW)h.get();
    if (localxW == null)
    {
      localxW = new xW(null);
      h.set(localxW);
    }
    localxW.sendEmptyMessage(0);
  }
  
  public static xQ b(float... paramVarArgs)
  {
    xQ localxQ = new xQ();
    localxQ.a(paramVarArgs);
    return localxQ;
  }
  
  private boolean b(long paramLong)
  {
    int i1 = 1;
    if (!this.t)
    {
      this.t = i1;
      this.u = paramLong;
      i1 = 0;
    }
    for (;;)
    {
      return i1;
      long l1 = paramLong - this.u;
      if (l1 <= this.y) {
        break;
      }
      this.b = (paramLong - (l1 - this.y));
      this.d = i1;
    }
  }
  
  private void e()
  {
    ((ArrayList)i.get()).remove(this);
    ((ArrayList)j.get()).remove(this);
    ((ArrayList)k.get()).remove(this);
    this.d = 0;
    if ((this.v) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i1 = localArrayList.size();
      for (int i2 = 0; i2 < i1; i2++) {
        ((xh)localArrayList.get(i2)).b(this);
      }
    }
    this.v = false;
    this.w = false;
  }
  
  private void n()
  {
    d();
    ((ArrayList)i.get()).add(this);
    if ((this.y > 0L) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i1 = localArrayList.size();
      for (int i2 = 0; i2 < i1; i2++) {
        ((xh)localArrayList.get(i2)).a(this);
      }
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  void a(float paramFloat)
  {
    int i1 = 0;
    float f1 = this.C.getInterpolation(paramFloat);
    this.s = f1;
    int i2 = this.f.length;
    for (int i3 = 0; i3 < i2; i3++) {
      this.f[i3].a(f1);
    }
    if (this.D != null)
    {
      int i4 = this.D.size();
      while (i1 < i4)
      {
        this.D.get(i1);
        i1++;
      }
    }
  }
  
  public void a(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (this.C = paramInterpolator;; this.C = new LinearInterpolator()) {
      return;
    }
  }
  
  public void a(xP paramxP)
  {
    if ((paramxP != null) && (this.f != null) && (this.f.length > 0)) {
      this.f[0].a(paramxP);
    }
  }
  
  public void a(float... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0))
    {
      xM[] arrayOfxM = new xM[1];
      arrayOfxM[0] = xM.a("", paramVarArgs);
      a(arrayOfxM);
    }
    for (;;)
    {
      this.e = false;
      break;
      this.f[0].a(paramVarArgs);
    }
  }
  
  public void a(xM... paramVarArgs)
  {
    int i1 = paramVarArgs.length;
    this.f = paramVarArgs;
    this.g = new HashMap(i1);
    for (int i2 = 0; i2 < i1; i2++)
    {
      xM localxM = paramVarArgs[i2];
      this.g.put(localxM.c(), localxM);
    }
    this.e = false;
  }
  
  public xQ c(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.x = paramLong;
    return this;
  }
  
  void d()
  {
    if (!this.e)
    {
      int i1 = this.f.length;
      for (int i2 = 0; i2 < i1; i2++) {
        this.f[i2].b();
      }
      this.e = true;
    }
  }
  
  public void d(long paramLong)
  {
    d();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.d != 1)
    {
      this.c = paramLong;
      this.d = 2;
    }
    this.b = (l1 - paramLong);
    e(l1);
  }
  
  boolean e(long paramLong)
  {
    int i1 = 1;
    boolean bool = false;
    if (this.d == 0)
    {
      this.d = i1;
      if (this.c >= 0L) {
        break label59;
      }
      this.b = paramLong;
    }
    for (;;)
    {
      switch (this.d)
      {
      default: 
        return bool;
        label59:
        this.b = (paramLong - this.c);
        this.c = -1L;
      }
    }
    float f1;
    if (this.x > 0L) {
      f1 = (float)(paramLong - this.b) / (float)this.x;
    }
    float f2;
    for (;;)
    {
      if (f1 >= 1.0F) {
        if ((this.r < this.A) || (this.A == -1))
        {
          if (this.a != null)
          {
            int i2 = this.a.size();
            int i3 = 0;
            for (;;)
            {
              if (i3 < i2)
              {
                this.a.get(i3);
                i3++;
                continue;
                f1 = 1.0F;
                break;
              }
            }
          }
          if (this.B == 2)
          {
            if (this.q) {
              i1 = 0;
            }
            this.q = i1;
          }
          this.r += (int)f1;
          f2 = f1 % 1.0F;
          this.b += this.x;
        }
      }
    }
    for (;;)
    {
      if (this.q) {
        f2 = 1.0F - f2;
      }
      a(f2);
      break;
      float f3 = Math.min(f1, 1.0F);
      bool = i1;
      f2 = f3;
      continue;
      f2 = f1;
    }
  }
  
  public xQ f()
  {
    int i1 = 0;
    xQ localxQ = (xQ)super.c();
    if (this.D != null)
    {
      ArrayList localArrayList = this.D;
      localxQ.D = new ArrayList();
      int i3 = localArrayList.size();
      for (int i4 = 0; i4 < i3; i4++) {
        localxQ.D.add(localArrayList.get(i4));
      }
    }
    localxQ.c = -1L;
    localxQ.q = false;
    localxQ.r = 0;
    localxQ.e = false;
    localxQ.d = 0;
    localxQ.t = false;
    xM[] arrayOfxM = this.f;
    if (arrayOfxM != null)
    {
      int i2 = arrayOfxM.length;
      localxQ.f = new xM[i2];
      localxQ.g = new HashMap(i2);
      while (i1 < i2)
      {
        xM localxM = arrayOfxM[i1].a();
        localxQ.f[i1] = localxM;
        localxQ.g.put(localxM.c(), localxM);
        i1++;
      }
    }
    return localxQ;
  }
  
  public long g()
  {
    if ((!this.e) || (this.d == 0)) {}
    for (long l1 = 0L;; l1 = AnimationUtils.currentAnimationTimeMillis() - this.b) {
      return l1;
    }
  }
  
  public String toString()
  {
    String str = "ValueAnimator@" + Integer.toHexString(hashCode());
    if (this.f != null) {
      for (int i1 = 0; i1 < this.f.length; i1++) {
        str = str + "\n    " + this.f[i1].toString();
      }
    }
    return str;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xQ
 * JD-Core Version:    0.7.0.1
 */