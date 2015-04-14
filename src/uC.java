import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;

class uC
  implements GestureDetector.OnGestureListener
{
  uC(uy paramuy) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.0F) {
      uy.a(this.a);
    }
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    InAppNotification localInAppNotification = uy.c(this.a).c();
    String str = localInAppNotification.j();
    if ((str != null) && (str.length() > 0)) {}
    for (;;)
    {
      try
      {
        localUri = Uri.parse(str);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Uri localUri;
        Intent localIntent;
        continue;
      }
      try
      {
        localIntent = new Intent("android.intent.action.VIEW", localUri);
        uy.e(this.a).startActivity(localIntent);
        uy.f(this.a).getPeople().a("$campaign_open", localInAppNotification);
        uy.a(this.a);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        new StringBuilder().append("User doesn't have an activity for notification URI ").append(localUri).toString();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uC
 * JD-Core Version:    0.7.0.1
 */