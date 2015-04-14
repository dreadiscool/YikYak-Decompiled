import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.yik.yak.ui.activity.PeekSearchActivity;
import java.util.ArrayList;

class Dy
  extends Filter
{
  Dy(Dw paramDw) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if ((paramCharSequence != null) && ((Dw.a(this.a)) || (this.a.a)))
    {
      Dw.a(this.a, PeekSearchActivity.a(this.a.b, paramCharSequence.toString()));
      localFilterResults.values = Dw.b(this.a);
      localFilterResults.count = Dw.b(this.a).size();
    }
    this.a.a = false;
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if ((paramFilterResults != null) && (paramFilterResults.count > 0)) {
      this.a.notifyDataSetChanged();
    }
    for (;;)
    {
      return;
      this.a.notifyDataSetInvalidated();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dy
 * JD-Core Version:    0.7.0.1
 */