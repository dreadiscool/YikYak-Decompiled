import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.yik.yak.ui.activity.SendAYak;

public class DS
  implements TextWatcher
{
  public DS(SendAYak paramSendAYak) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SendAYak.u(this.a).setText(String.valueOf(200 - paramCharSequence.length()));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DS
 * JD-Core Version:    0.7.0.1
 */