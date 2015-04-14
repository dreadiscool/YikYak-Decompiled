import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.mixpanel.android.surveys.CardCarouselLayout;

public class vD
{
  private vm b;
  private final View c;
  private final TextView d;
  private final TextView e;
  private final ListView f;
  
  public vD(CardCarouselLayout paramCardCarouselLayout, View paramView)
  {
    this.c = paramView;
    this.d = ((TextView)paramView.findViewWithTag("com_mixpanel_android_TAG_prompt_text"));
    this.e = ((EditText)paramView.findViewWithTag("com_mixpanel_android_TAG_text_answer"));
    this.f = ((ListView)paramView.findViewWithTag("com_mixpanel_android_TAG_choice_list"));
    this.e.setText("");
    this.e.setOnEditorActionListener(new vE(this, paramCardCarouselLayout));
    this.f.setOnItemClickListener(new vF(this, paramCardCarouselLayout));
  }
  
  public View a()
  {
    return this.c;
  }
  
  public void a(vm paramvm, String paramString)
  {
    this.b = paramvm;
    this.d.setText(this.b.b());
    InputMethodManager localInputMethodManager = (InputMethodManager)this.c.getContext().getSystemService("input_method");
    vn localvn = paramvm.d();
    if (vn.c == localvn)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      if (paramString != null) {
        this.e.setText(paramString);
      }
      if (this.a.getResources().getConfiguration().orientation == 1)
      {
        this.e.requestFocus();
        localInputMethodManager.showSoftInput(this.e, 0);
      }
    }
    for (;;)
    {
      this.c.invalidate();
      return;
      localInputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
      continue;
      if (vn.b != localvn) {
        break;
      }
      localInputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
      this.f.setVisibility(0);
      this.e.setVisibility(8);
      vA localvA = new vA(paramvm.c(), LayoutInflater.from(this.a.getContext()));
      this.f.setAdapter(localvA);
      this.f.clearChoices();
      if (paramString != null) {
        for (int i = 0; i < localvA.getCount(); i++) {
          if (localvA.a(i).equals(paramString)) {
            this.f.setItemChecked(i, true);
          }
        }
      }
    }
    throw new vH("No way to display question type " + localvn, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vD
 * JD-Core Version:    0.7.0.1
 */