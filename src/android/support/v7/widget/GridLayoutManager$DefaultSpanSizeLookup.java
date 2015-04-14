package android.support.v7.widget;

public final class GridLayoutManager$DefaultSpanSizeLookup
  extends GridLayoutManager.SpanSizeLookup
{
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    return paramInt1 % paramInt2;
  }
  
  public int getSpanSize(int paramInt)
  {
    return 1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.DefaultSpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */