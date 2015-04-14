import android.text.Editable;
import android.text.TextWatcher;
import android.text.util.Linkify;
import com.yik.yak.ui.view.LinkDetectingEditText;

public class Hj
  implements TextWatcher
{
  public Hj(LinkDetectingEditText paramLinkDetectingEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (LinkDetectingEditText.a(this.a))
    {
      Linkify.addLinks(paramEditable, 1);
      LinkDetectingEditText.b(this.a);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hj
 * JD-Core Version:    0.7.0.1
 */