import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class FM
  implements TextWatcher
{
  FM(FH paramFH) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    FH.e(this.a).setText(String.valueOf(200 - paramCharSequence.length()));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FM
 * JD-Core Version:    0.7.0.1
 */