import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class vV
  implements wN
{
  private static String e = "MixpanelAPI.DynamicEventTracker";
  private final MixpanelAPI a;
  private final Handler b;
  private final Runnable c;
  private final Map<vY, vZ> d;
  
  public vV(MixpanelAPI paramMixpanelAPI, Handler paramHandler)
  {
    this.a = paramMixpanelAPI;
    this.d = new HashMap();
    this.c = new vX(this, null);
    this.b = paramHandler;
  }
  
  private static String a(View paramView)
  {
    String str1 = null;
    if ((paramView instanceof TextView))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      if (localCharSequence != null) {
        str1 = localCharSequence.toString();
      }
    }
    for (;;)
    {
      return str1;
      if ((paramView instanceof ViewGroup))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i = localViewGroup.getChildCount();
        int j = 0;
        int k = 0;
        while ((j < i) && (localStringBuilder.length() < 128))
        {
          String str2 = a(localViewGroup.getChildAt(j));
          if ((str2 != null) && (str2.length() > 0))
          {
            if (k != 0) {
              localStringBuilder.append(", ");
            }
            localStringBuilder.append(str2);
            k = 1;
          }
          j++;
        }
        if (localStringBuilder.length() > 128) {
          str1 = localStringBuilder.substring(0, 128);
        } else if (k != 0) {
          str1 = localStringBuilder.toString();
        }
      }
    }
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("$text", a(paramView));
      localJSONObject.put("$from_binding", true);
      localJSONObject.put("time", l / 1000L);
      label49:
      if (paramBoolean)
      {
        vY localvY = new vY(paramView, paramString);
        vZ localvZ = new vZ(paramString, localJSONObject, l);
        synchronized (this.d)
        {
          boolean bool = this.d.isEmpty();
          this.d.put(localvY, localvZ);
          if (bool) {
            this.b.postDelayed(this.c, 1000L);
          }
        }
      }
      this.a.track(paramString, localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      break label49;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vV
 * JD-Core Version:    0.7.0.1
 */