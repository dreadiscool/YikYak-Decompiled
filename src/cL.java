import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class cL
  implements xP<Number>
{
  protected float a;
  private ArrayList<cM> b;
  
  public abstract Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public final Float a(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    float f = a(paramFloat * this.a, paramNumber1.floatValue(), paramNumber2.floatValue() - paramNumber1.floatValue(), this.a).floatValue();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    return Float.valueOf(f);
  }
  
  public void a(cM... paramVarArgs)
  {
    Collections.addAll(this.b, paramVarArgs);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cL
 * JD-Core Version:    0.7.0.1
 */