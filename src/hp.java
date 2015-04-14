import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class hp
  extends Drawable.ConstantState
{
  int a;
  int b;
  
  hp(hp paramhp)
  {
    if (paramhp != null)
    {
      this.a = paramhp.a;
      this.b = paramhp.b;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.a;
  }
  
  public Drawable newDrawable()
  {
    return new hl(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hp
 * JD-Core Version:    0.7.0.1
 */