import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class Gc
  extends ArrayAdapter<CG>
{
  public HashMap<String, String> a = new HashMap();
  private int c;
  
  public Gc(Context paramContext, int paramInt, List<CG> paramList)
  {
    super(paramInt, paramList, localList);
    this.c = paramList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CG localCG = (CG)getItem(paramInt);
    String str = localCG.b;
    if (paramView == null) {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.c, paramViewGroup, false);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131558776);
    paramView.setBackgroundResource(2131427656);
    localTextView.setBackgroundResource(2130837822);
    localTextView.setTextColor(this.b.getResources().getColor(2131427596));
    localTextView.setTextSize(16.0F);
    if (localCG.k) {
      localTextView.setText("Add a peek using the search icon above.");
    }
    for (;;)
    {
      notifyDataSetChanged();
      return paramView;
      localTextView.setText(str);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gc
 * JD-Core Version:    0.7.0.1
 */