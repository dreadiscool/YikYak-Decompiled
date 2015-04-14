import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mixpanel.android.surveys.SurveyActivity;

public class vJ
  implements View.OnTouchListener
{
  public vJ(SurveyActivity paramSurveyActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      paramView.setBackgroundResource(tm.com_mixpanel_android_cta_button_highlight);
    }
    for (;;)
    {
      return false;
      paramView.setBackgroundResource(tm.com_mixpanel_android_cta_button);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vJ
 * JD-Core Version:    0.7.0.1
 */