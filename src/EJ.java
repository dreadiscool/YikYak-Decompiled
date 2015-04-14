import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class EJ
  extends RecyclerView.ViewHolder
{
  private TextView b;
  
  public EJ(EI paramEI, View paramView)
  {
    super(paramView);
    this.b = ((TextView)paramView.findViewById(2131558750));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString.toUpperCase(Locale.US));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EJ
 * JD-Core Version:    0.7.0.1
 */