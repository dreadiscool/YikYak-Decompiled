import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.yik.yak.ui.activity.PeekSearchActivity;
import java.util.ArrayList;

public class Dw
  extends ArrayAdapter<String>
  implements Filterable
{
  public boolean a = false;
  private ArrayList<String> c;
  private boolean d = false;
  
  public Dw(PeekSearchActivity paramPeekSearchActivity, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.d = paramBoolean;
    setDropDownViewResource(17367049);
  }
  
  public String a(int paramInt)
  {
    if (this.c == null) {}
    for (String str = "";; str = (String)this.c.get(paramInt)) {
      return str;
    }
  }
  
  public int getCount()
  {
    if (this.c == null) {}
    for (int i = 0;; i = this.c.size()) {
      return i;
    }
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)super.getDropDownView(paramInt, paramView, paramViewGroup);
    localTextView.setSingleLine(false);
    localTextView.setTextSize(0, PeekSearchActivity.f(this.b).getResources().getDimension(2131492993));
    localTextView.post(new Dx(this, localTextView));
    return localTextView;
  }
  
  public Filter getFilter()
  {
    return new Dy(this);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)super.getView(paramInt, paramView, paramViewGroup);
    localTextView.setTextSize(0, PeekSearchActivity.f(this.b).getResources().getDimension(2131492993));
    localTextView.setMinHeight((int)PeekSearchActivity.f(this.b).getResources().getDimension(2131492967));
    localTextView.setSingleLine(false);
    return localTextView;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dw
 * JD-Core Version:    0.7.0.1
 */