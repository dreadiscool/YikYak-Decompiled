import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class EG
  extends ArrayAdapter<CH>
{
  private int a;
  private Context b;
  
  public EG(Context paramContext, int paramInt, List<CH> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.b = paramContext;
    this.a = paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CH localCH = (CH)getItem(paramInt);
    String str = localCH.b;
    boolean bool = localCH.a();
    if (paramView == null) {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.a, paramViewGroup, false);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131558774);
    if (bool)
    {
      paramView.setBackgroundResource(2131427560);
      localTextView.setTextColor(this.b.getResources().getColor(2131427594));
    }
    for (;;)
    {
      localTextView.setText(str);
      return paramView;
      paramView.setBackgroundResource(2131427656);
      localTextView.setBackgroundResource(2130837822);
      localTextView.setTextColor(this.b.getResources().getColor(2131427596));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EG
 * JD-Core Version:    0.7.0.1
 */