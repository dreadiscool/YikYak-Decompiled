import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class EF
  extends ArrayAdapter<CH>
{
  private int a;
  private Context b;
  
  public EF(Context paramContext, int paramInt, List<CH> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.b = paramContext;
    this.a = paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CH localCH = (CH)getItem(paramInt);
    if (paramView == null) {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.a, paramViewGroup, false);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131558773);
    localTextView.setBackgroundResource(2130837822);
    localTextView.setTextColor(this.b.getResources().getColor(2131427562));
    localTextView.setText(localCH.b);
    return paramView;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EF
 * JD-Core Version:    0.7.0.1
 */