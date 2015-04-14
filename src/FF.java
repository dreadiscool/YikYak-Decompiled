import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

class FF
  extends ArrayAdapter<String>
{
  private Context a;
  
  private FF(Context paramContext, int paramInt, List<String> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.a = paramContext;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)super.getDropDownView(paramInt, paramView, paramViewGroup);
    localTextView.setTextSize(0, this.a.getResources().getDimension(2131492993));
    localTextView.post(new FG(this, localTextView));
    return localTextView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)super.getView(paramInt, paramView, paramViewGroup);
    localTextView.setSingleLine(true);
    localTextView.setTextSize(0, this.a.getResources().getDimension(2131492993));
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    return localTextView;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FF
 * JD-Core Version:    0.7.0.1
 */