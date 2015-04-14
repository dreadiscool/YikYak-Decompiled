import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.mixpanel.android.surveys.CardCarouselLayout;

class vF
  implements AdapterView.OnItemClickListener
{
  vF(vD paramvD, CardCarouselLayout paramCardCarouselLayout) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (CardCarouselLayout.a(this.b.a) != null)
    {
      String str = paramAdapterView.getItemAtPosition(paramInt).toString();
      this.b.a.postDelayed(new vG(this, str), 165L);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vF
 * JD-Core Version:    0.7.0.1
 */