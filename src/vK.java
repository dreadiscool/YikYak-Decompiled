import android.view.View;
import android.view.View.OnClickListener;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.surveys.SurveyActivity;

public class vK
  implements View.OnClickListener
{
  public vK(SurveyActivity paramSurveyActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    UpdateDisplayState.a(SurveyActivity.b(this.a));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vK
 * JD-Core Version:    0.7.0.1
 */