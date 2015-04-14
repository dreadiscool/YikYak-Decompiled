import android.view.animation.Interpolator;
import java.util.ArrayList;

class xr
  extends xv
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;
  
  public xr(xu... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public Object a(float paramFloat)
  {
    return Float.valueOf(b(paramFloat));
  }
  
  public xr a()
  {
    ArrayList localArrayList = this.e;
    int k = this.e.size();
    xu[] arrayOfxu = new xu[k];
    for (int m = 0; m < k; m++) {
      arrayOfxu[m] = ((xu)((xt)localArrayList.get(m)).e());
    }
    return new xr(arrayOfxu);
  }
  
  public float b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((xu)this.e.get(0)).f();
        this.h = ((xu)this.e.get(k)).f();
        this.i = (this.h - this.g);
      }
      if (this.d != null) {
        paramFloat = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null) {
        f1 = this.g + paramFloat * this.i;
      }
    }
    for (;;)
    {
      return f1;
      f1 = ((Number)this.f.a(paramFloat, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
      continue;
      if (paramFloat <= 0.0F)
      {
        xu localxu4 = (xu)this.e.get(0);
        xu localxu5 = (xu)this.e.get(k);
        float f10 = localxu4.f();
        float f11 = localxu5.f();
        float f12 = localxu4.c();
        float f13 = localxu5.c();
        Interpolator localInterpolator3 = localxu5.d();
        if (localInterpolator3 != null) {
          paramFloat = localInterpolator3.getInterpolation(paramFloat);
        }
        float f14 = (paramFloat - f12) / (f13 - f12);
        if (this.f == null) {
          f1 = f10 + f14 * (f11 - f10);
        } else {
          f1 = ((Number)this.f.a(f14, Float.valueOf(f10), Float.valueOf(f11))).floatValue();
        }
      }
      else if (paramFloat >= 1.0F)
      {
        xu localxu2 = (xu)this.e.get(-2 + this.a);
        xu localxu3 = (xu)this.e.get(-1 + this.a);
        float f5 = localxu2.f();
        float f6 = localxu3.f();
        float f7 = localxu2.c();
        float f8 = localxu3.c();
        Interpolator localInterpolator2 = localxu3.d();
        if (localInterpolator2 != null) {
          paramFloat = localInterpolator2.getInterpolation(paramFloat);
        }
        float f9 = (paramFloat - f7) / (f8 - f7);
        if (this.f == null) {
          f1 = f5 + f9 * (f6 - f5);
        } else {
          f1 = ((Number)this.f.a(f9, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
        }
      }
      else
      {
        xu localxu1;
        for (Object localObject = (xu)this.e.get(0);; localObject = localxu1)
        {
          if (k >= this.a) {
            break label615;
          }
          localxu1 = (xu)this.e.get(k);
          if (paramFloat < localxu1.c())
          {
            Interpolator localInterpolator1 = localxu1.d();
            if (localInterpolator1 != null) {
              paramFloat = localInterpolator1.getInterpolation(paramFloat);
            }
            float f2 = (paramFloat - ((xu)localObject).c()) / (localxu1.c() - ((xu)localObject).c());
            float f3 = ((xu)localObject).f();
            float f4 = localxu1.f();
            if (this.f == null)
            {
              f1 = f3 + f2 * (f4 - f3);
              break;
            }
            f1 = ((Number)this.f.a(f2, Float.valueOf(f3), Float.valueOf(f4))).floatValue();
            break;
          }
          k++;
        }
        label615:
        f1 = ((Number)((xt)this.e.get(-1 + this.a)).b()).floatValue();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xr
 * JD-Core Version:    0.7.0.1
 */