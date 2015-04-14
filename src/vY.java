import android.view.View;

class vY
{
  private final int a;
  
  public vY(View paramView, String paramString)
  {
    this.a = (paramView.hashCode() ^ paramString.hashCode());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (((paramObject instanceof vY)) && (this.a == paramObject.hashCode())) {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vY
 * JD-Core Version:    0.7.0.1
 */