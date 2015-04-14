import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;
import com.mixpanel.android.surveys.SurveyActivity;

class uU
  implements un
{
  uU(uS paramuS, UpdateDisplayState.DisplayState.SurveyState paramSurveyState, Activity paramActivity, int paramInt) {}
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    this.a.a(paramBitmap);
    this.a.a(paramInt);
    Intent localIntent = new Intent(this.b.getApplicationContext(), SurveyActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    localIntent.putExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", this.c);
    this.b.startActivity(localIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uU
 * JD-Core Version:    0.7.0.1
 */