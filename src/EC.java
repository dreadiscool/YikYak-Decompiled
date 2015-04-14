import android.view.View;
import com.yik.yak.ui.adapter.DoubleClickRecyclerViewAdapter;

public class EC
  extends GT
{
  public EC(DoubleClickRecyclerViewAdapter paramDoubleClickRecyclerViewAdapter, EN paramEN, View paramView, int paramInt, EV paramEV)
  {
    super(paramEN, paramView, paramInt);
  }
  
  public void a(EN paramEN, View paramView, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "onSingleClick";
    Iq.a(this, arrayOfObject);
    this.b.broadcastClick(this.a, paramView, paramInt);
  }
  
  public void b(EN paramEN, View paramView, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "onDoubleClick";
    Iq.a(this, arrayOfObject);
    this.b.broadcastDoubleClick(this.a, paramView, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EC
 * JD-Core Version:    0.7.0.1
 */