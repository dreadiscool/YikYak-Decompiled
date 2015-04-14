import android.graphics.Bitmap;
import android.view.View;
import java.util.List;

public class wO
  extends wH
{
  private final vU a;
  private final vU b;
  
  public wO(List<wr> paramList, vU paramvU1, vU paramvU2)
  {
    super(paramList);
    this.a = paramvU1;
    this.b = paramvU2;
  }
  
  public void a() {}
  
  public void a(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (this.b != null)
    {
      Object[] arrayOfObject = this.a.a();
      if (1 == arrayOfObject.length)
      {
        localObject1 = arrayOfObject[0];
        localObject2 = this.b.a(paramView);
        if (localObject1 != localObject2) {}
      }
    }
    for (;;)
    {
      return;
      if (localObject1 != null)
      {
        if ((!(localObject1 instanceof Bitmap)) || (!(localObject2 instanceof Bitmap))) {
          break label93;
        }
        if (((Bitmap)localObject1).sameAs((Bitmap)localObject2)) {
          continue;
        }
      }
      label93:
      while (!localObject1.equals(localObject2))
      {
        this.a.a(paramView);
        break;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wO
 * JD-Core Version:    0.7.0.1
 */