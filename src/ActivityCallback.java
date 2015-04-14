import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.yik.yak.YikYak;
import com.yik.yak.ui.activity.SplashScreen;

public class ActivityCallback
    implements Application.ActivityLifecycleCallbacks
{
    // int a
    private static int activityResumeCount;
    // int b
    private static int activityPauseCount;
    // int c
    private static int activityStartCount;
    // int d
    private static int activityStopCount;
    
    public static boolean a()
    {
        if (c > d) {}
        for (boolean bool = true;; bool = false) {
            return bool;
        }
    }
    
    public static boolean b()
    {
        if (a > b) {}
        for (boolean bool = true;; bool = false) {
            return bool;
        }
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
        if ((!paramActivity.getClass().getName().contains("Splash")) && (!CR.b()))
        {
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = "Configuration File Not Ready! Sending application back to SplashScreen!";
            Iq.a(this, arrayOfObject);
            Context localContext = YikYak.getContext();
            PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, 123456, new Intent(localContext, SplashScreen.class), 268435456);
            ((AlarmManager)localContext.getSystemService("alarm")).set(1, 50L + System.currentTimeMillis(), localPendingIntent);
            System.exit(0);
        }
    }
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity)
    {
        activityPauseCount++;
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
        activityResumeCount++;
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
        activityStartCount++;
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
        activityStopCount++;
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CU

 * JD-Core Version:    0.7.0.1

 */