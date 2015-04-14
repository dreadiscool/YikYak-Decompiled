import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.mixpanel.android.surveys.SurveyActivity;

public class vM
  implements DialogInterface.OnClickListener
{
  public vM(SurveyActivity paramSurveyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.findViewById(tn.com_mixpanel_android_activity_survey_id).setVisibility(0);
    SurveyActivity.a(this.a, true);
    SurveyActivity.a(this.a, SurveyActivity.d(this.a));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vM
 * JD-Core Version:    0.7.0.1
 */