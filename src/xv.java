import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class xv
{
  int a;
  xt b;
  xt c;
  Interpolator d;
  ArrayList<xt> e;
  xP f;
  
  public xv(xt... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((xt)this.e.get(0));
    this.c = ((xt)this.e.get(-1 + this.a));
    this.d = this.c.d();
  }
  
  public static xv a(float... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    xu[] arrayOfxu = new xu[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfxu[0] = ((xu)xt.a(0.0F));
      arrayOfxu[i] = ((xu)xt.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new xr(arrayOfxu);
      arrayOfxu[0] = ((xu)xt.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfxu[i] = ((xu)xt.a(i / (j - 1), paramVarArgs[i]));
        i++;
      }
    }
  }
  
  public Object a(float paramFloat)
  {
    Object localObject2;
    if (this.a == 2)
    {
      if (this.d != null) {
        paramFloat = this.d.getInterpolation(paramFloat);
      }
      localObject2 = this.f.a(paramFloat, this.b.b(), this.c.b());
    }
    for (;;)
    {
      return localObject2;
      if (paramFloat <= 0.0F)
      {
        xt localxt3 = (xt)this.e.get(1);
        Interpolator localInterpolator3 = localxt3.d();
        if (localInterpolator3 != null) {
          paramFloat = localInterpolator3.getInterpolation(paramFloat);
        }
        float f5 = this.b.c();
        float f6 = (paramFloat - f5) / (localxt3.c() - f5);
        localObject2 = this.f.a(f6, this.b.b(), localxt3.b());
      }
      else if (paramFloat >= 1.0F)
      {
        xt localxt2 = (xt)this.e.get(-2 + this.a);
        Interpolator localInterpolator2 = this.c.d();
        if (localInterpolator2 != null) {
          paramFloat = localInterpolator2.getInterpolation(paramFloat);
        }
        float f3 = localxt2.c();
        float f4 = (paramFloat - f3) / (this.c.c() - f3);
        localObject2 = this.f.a(f4, localxt2.b(), this.c.b());
      }
      else
      {
        Object localObject1 = this.b;
        int i = 1;
        for (;;)
        {
          if (i >= this.a) {
            break label361;
          }
          xt localxt1 = (xt)this.e.get(i);
          if (paramFloat < localxt1.c())
          {
            Interpolator localInterpolator1 = localxt1.d();
            if (localInterpolator1 != null) {
              paramFloat = localInterpolator1.getInterpolation(paramFloat);
            }
            float f1 = ((xt)localObject1).c();
            float f2 = (paramFloat - f1) / (localxt1.c() - f1);
            localObject2 = this.f.a(f2, ((xt)localObject1).b(), localxt1.b());
            break;
          }
          i++;
          localObject1 = localxt1;
        }
        label361:
        localObject2 = this.c.b();
      }
    }
  }
  
  public void a(xP paramxP)
  {
    this.f = paramxP;
  }
  
  public xv b()
  {
    ArrayList localArrayList = this.e;
    int i = this.e.size();
    xt[] arrayOfxt = new xt[i];
    for (int j = 0; j < i; j++) {
      arrayOfxt[j] = ((xt)localArrayList.get(j)).e();
    }
    return new xv(arrayOfxt);
  }
  
  public String toString()
  {
    Object localObject = " ";
    int i = 0;
    while (i < this.a)
    {
      String str = (String)localObject + ((xt)this.e.get(i)).b() + "  ";
      i++;
      localObject = str;
    }
    return localObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xv
 * JD-Core Version:    0.7.0.1
 */