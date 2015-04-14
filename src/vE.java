import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.mixpanel.android.surveys.CardCarouselLayout;

class vE
  implements TextView.OnEditorActionListener
{
  vE(vD paramvD, CardCarouselLayout paramCardCarouselLayout) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66) && (paramKeyEvent.getAction() == 0) && ((0x20 & paramKeyEvent.getFlags()) == 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (paramInt == 6))
      {
        paramTextView.clearComposingText();
        if (CardCarouselLayout.a(this.b.a) != null)
        {
          String str = paramTextView.getText().toString();
          CardCarouselLayout.a(this.b.a).a(vD.a(this.b), str);
        }
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vE
 * JD-Core Version:    0.7.0.1
 */