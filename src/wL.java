import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class wL
  implements TextWatcher
{
  private final View b;
  
  public wL(wK paramwK, View paramView)
  {
    this.b = paramView;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.c(this.b);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wL
 * JD-Core Version:    0.7.0.1
 */