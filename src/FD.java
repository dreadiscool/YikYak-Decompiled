import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;

class FD
  implements AdapterView.OnItemSelectedListener
{
  FD(FB paramFB) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((EditText)FB.b(this.a).findViewById(2131558640)).setHint(FB.a(this.a)[paramInt]);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FD
 * JD-Core Version:    0.7.0.1
 */