import android.app.Activity;
import android.os.Build.VERSION;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uS
  implements uR
{
  private uS(MixpanelAPI paramMixpanelAPI) {}
  
  private void a(InAppNotification paramInAppNotification, Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return;
      paramActivity.runOnUiThread(new uV(this, paramInAppNotification, paramActivity));
    }
  }
  
  private void a(Survey paramSurvey, Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return;
      if (!up.b(paramActivity.getApplicationContext())) {
        continue;
      }
      ReentrantLock localReentrantLock = UpdateDisplayState.a();
      localReentrantLock.lock();
      try
      {
        boolean bool = UpdateDisplayState.b();
        if (bool)
        {
          localReentrantLock.unlock();
          continue;
        }
        if (paramSurvey == null)
        {
          Survey localSurvey = c();
          paramSurvey = localSurvey;
        }
        if (paramSurvey == null)
        {
          localReentrantLock.unlock();
          continue;
        }
        UpdateDisplayState.DisplayState.SurveyState localSurveyState = new UpdateDisplayState.DisplayState.SurveyState(paramSurvey);
        int i = UpdateDisplayState.a(localSurveyState, d(), MixpanelAPI.access$1200(this.a));
        if (i <= 0)
        {
          localReentrantLock.unlock();
          continue;
        }
        uU localuU = new uU(this, localSurveyState, paramActivity, i);
        localReentrantLock.unlock();
        uk.a(paramActivity, localuU);
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  private JSONObject c(String paramString, Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = d();
    localJSONObject.put(paramString, paramObject);
    localJSONObject.put("$token", MixpanelAPI.access$1200(this.a));
    localJSONObject.put("$time", System.currentTimeMillis());
    if (str != null) {
      localJSONObject.put("$distinct_id", d());
    }
    return localJSONObject;
  }
  
  public void a()
  {
    MixpanelAPI.access$400(this.a).g();
    b("$android_devices", new JSONArray());
  }
  
  public void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return;
      a(null, paramActivity);
    }
  }
  
  public void a(InAppNotification paramInAppNotification)
  {
    if (paramInAppNotification == null) {}
    for (;;)
    {
      return;
      a("$campaign_delivery", paramInAppNotification);
      uR localuR = this.a.getPeople().b(d());
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
      JSONObject localJSONObject = paramInAppNotification.a();
      try
      {
        localJSONObject.put("$time", localSimpleDateFormat.format(new Date()));
        label67:
        localuR.a("$campaigns", Integer.valueOf(paramInAppNotification.b()));
        localuR.a("$notifications", localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        break label67;
      }
    }
  }
  
  public void a(String paramString)
  {
    synchronized (MixpanelAPI.access$400(this.a))
    {
      if (MixpanelAPI.access$400(this.a).d() == null) {
        return;
      }
      MixpanelAPI.access$400(this.a).b(paramString);
    }
    try
    {
      a("$android_devices", new JSONArray("[" + paramString + "]"));
      label76:
      return;
      localObject = finally;
      throw localObject;
    }
    catch (JSONException localJSONException)
    {
      break label76;
    }
  }
  
  public void a(String paramString, InAppNotification paramInAppNotification)
  {
    this.a.track(paramString, paramInAppNotification.a());
  }
  
  public void a(String paramString, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put(paramString, paramObject);
      JSONObject localJSONObject2 = c("$append", localJSONObject1);
      MixpanelAPI.access$800(this.a, localJSONObject2);
      label33:
      return;
    }
    catch (JSONException localJSONException)
    {
      break label33;
    }
  }
  
  public void a(String paramString, JSONArray paramJSONArray)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put(paramString, paramJSONArray);
      JSONObject localJSONObject2 = c("$union", localJSONObject1);
      MixpanelAPI.access$800(this.a, localJSONObject2);
      label33:
      return;
    }
    catch (JSONException localJSONException)
    {
      break label33;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(MixpanelAPI.access$700(this.a));
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject1.put(str, paramJSONObject.get(str));
      }
      JSONObject localJSONObject2 = c("$set", localJSONObject1);
      MixpanelAPI.access$800(this.a, localJSONObject2);
    }
    catch (JSONException localJSONException) {}
  }
  
  public InAppNotification b()
  {
    return MixpanelAPI.access$500(this.a).b(MixpanelAPI.access$900(this.a).h());
  }
  
  public uR b(String paramString)
  {
    if (paramString == null) {}
    for (Object localObject = null;; localObject = new uT(this, paramString)) {
      return localObject;
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return;
      a(null, paramActivity);
    }
  }
  
  public void b(String paramString, Object paramObject)
  {
    try
    {
      a(new JSONObject().put(paramString, paramObject));
      label16:
      return;
    }
    catch (JSONException localJSONException)
    {
      break label16;
    }
  }
  
  public Survey c()
  {
    return MixpanelAPI.access$500(this.a).a(MixpanelAPI.access$900(this.a).h());
  }
  
  public String d()
  {
    return MixpanelAPI.access$400(this.a).d();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uS
 * JD-Core Version:    0.7.0.1
 */