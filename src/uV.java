import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;
import com.mixpanel.android.surveys.SurveyActivity;
import java.util.concurrent.locks.ReentrantLock;

class uV
  implements Runnable
{
  uV(uS paramuS, InAppNotification paramInAppNotification, Activity paramActivity) {}
  
  @TargetApi(16)
  public void run()
  {
    ReentrantLock localReentrantLock = UpdateDisplayState.a();
    localReentrantLock.lock();
    for (;;)
    {
      InAppNotification localInAppNotification1;
      int i;
      try
      {
        if (UpdateDisplayState.b()) {
          return;
        }
        localInAppNotification1 = this.a;
        if (localInAppNotification1 != null) {
          break label406;
        }
        localInAppNotification2 = this.c.b();
        if (localInAppNotification2 == null)
        {
          localReentrantLock.unlock();
          continue;
        }
        uF localuF = localInAppNotification2.d();
        if ((localuF == uF.c) && (!up.b(this.b.getApplicationContext())))
        {
          localReentrantLock.unlock();
          continue;
        }
        i = UpdateDisplayState.a(new UpdateDisplayState.DisplayState.InAppNotificationState(localInAppNotification2, vQ.a(this.b)), this.c.d(), MixpanelAPI.access$1200(this.c.a));
        if (i <= 0)
        {
          localReentrantLock.unlock();
          continue;
        }
        switch (uP.a[localuF.ordinal()])
        {
        default: 
          new StringBuilder().append("Unrecognized notification type ").append(localuF).append(" can't be shown").toString();
          if (!MixpanelAPI.access$900(this.c.a).h()) {
            this.c.a(localInAppNotification2);
          }
          localReentrantLock.unlock();
          break;
        case 1: 
          UpdateDisplayState localUpdateDisplayState = UpdateDisplayState.b(i);
          if (localUpdateDisplayState == null)
          {
            localReentrantLock.unlock();
            continue;
          }
          uy localuy = new uy();
          localuy.a(this.c.a, i, (UpdateDisplayState.DisplayState.InAppNotificationState)localUpdateDisplayState.c());
          localuy.setRetainInstance(true);
          FragmentTransaction localFragmentTransaction = this.b.getFragmentManager().beginTransaction();
          localFragmentTransaction.setCustomAnimations(0, tl.com_mixpanel_android_slide_down);
          localFragmentTransaction.add(16908290, localuy);
          localFragmentTransaction.commit();
          break;
        case 2: 
          localIntent = new Intent(this.b.getApplicationContext(), SurveyActivity.class);
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      Intent localIntent;
      localIntent.addFlags(268435456);
      localIntent.addFlags(131072);
      localIntent.putExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", i);
      this.b.startActivity(localIntent);
      continue;
      label406:
      InAppNotification localInAppNotification2 = localInAppNotification1;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uV
 * JD-Core Version:    0.7.0.1
 */