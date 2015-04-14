import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

class ui
  extends Handler
{
  private uK b = null;
  private final uq c;
  private final long d;
  private final boolean e;
  
  public ui(uh paramuh, Looper paramLooper)
  {
    super(paramLooper);
    this.c = new uq(uf.a(paramuh.a), uf.b(paramuh.a));
    this.e = uf.b(paramuh.a).d();
    this.d = uf.b(paramuh.a).b();
    uh.a(paramuh, new vr(uf.a(paramuh.a)));
  }
  
  private JSONObject a()
  {
    localJSONObject = new JSONObject();
    localJSONObject.put("mp_lib", "android");
    localJSONObject.put("$lib_version", "4.5.3");
    localJSONObject.put("$os", "Android");
    String str1;
    String str2;
    label64:
    String str3;
    label83:
    String str4;
    if (Build.VERSION.RELEASE == null)
    {
      str1 = "UNKNOWN";
      localJSONObject.put("$os_version", str1);
      if (Build.MANUFACTURER != null) {
        break label439;
      }
      str2 = "UNKNOWN";
      localJSONObject.put("$manufacturer", str2);
      if (Build.BRAND != null) {
        break label447;
      }
      str3 = "UNKNOWN";
      localJSONObject.put("$brand", str3);
      if (Build.MODEL != null) {
        break label455;
      }
      str4 = "UNKNOWN";
      label102:
      localJSONObject.put("$model", str4);
    }
    for (;;)
    {
      try
      {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(uf.a(this.a.a));
        switch (i)
        {
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        DisplayMetrics localDisplayMetrics;
        String str5;
        Boolean localBoolean1;
        Boolean localBoolean2;
        String str6;
        Boolean localBoolean3;
        Boolean localBoolean4;
        String str7;
        localJSONObject.put("$google_play_services", "not configured");
        continue;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        label439:
        label447:
        label455:
        localJSONObject.put("$google_play_services", "not included");
        continue;
        localJSONObject.put("$google_play_services", "missing");
        continue;
        localJSONObject.put("$google_play_services", "out of date");
        continue;
        localJSONObject.put("$google_play_services", "disabled");
        continue;
        localJSONObject.put("$google_play_services", "invalid");
        continue;
      }
      localDisplayMetrics = uh.c(this.a).d();
      localJSONObject.put("$screen_dpi", localDisplayMetrics.densityDpi);
      localJSONObject.put("$screen_height", localDisplayMetrics.heightPixels);
      localJSONObject.put("$screen_width", localDisplayMetrics.widthPixels);
      str5 = uh.c(this.a).a();
      if (str5 != null) {
        localJSONObject.put("$app_version", str5);
      }
      localBoolean1 = Boolean.valueOf(uh.c(this.a).b());
      if (localBoolean1 != null) {
        localJSONObject.put("$has_nfc", localBoolean1.booleanValue());
      }
      localBoolean2 = Boolean.valueOf(uh.c(this.a).c());
      if (localBoolean2 != null) {
        localJSONObject.put("$has_telephone", localBoolean2.booleanValue());
      }
      str6 = uh.c(this.a).e();
      if (str6 != null) {
        localJSONObject.put("$carrier", str6);
      }
      localBoolean3 = uh.c(this.a).f();
      if (localBoolean3 != null) {
        localJSONObject.put("$wifi", localBoolean3.booleanValue());
      }
      localBoolean4 = uh.c(this.a).g();
      if (localBoolean4 != null) {
        localJSONObject.put("$bluetooth_enabled", localBoolean4);
      }
      str7 = uh.c(this.a).h();
      if (str7 != null) {
        localJSONObject.put("$bluetooth_version", str7);
      }
      return localJSONObject;
      str1 = Build.VERSION.RELEASE;
      break;
      str2 = Build.MANUFACTURER;
      break label64;
      str3 = Build.BRAND;
      break label83;
      str4 = Build.MODEL;
      break label102;
      localJSONObject.put("$google_play_services", "available");
    }
  }
  
  private JSONObject a(ug paramug)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = paramug.b();
    JSONObject localJSONObject3 = a();
    localJSONObject3.put("token", paramug.c());
    if (localJSONObject2 != null)
    {
      Iterator localIterator = localJSONObject2.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject3.put(str, localJSONObject2.get(str));
      }
    }
    localJSONObject1.put("event", paramug.a());
    localJSONObject1.put("properties", localJSONObject3);
    return localJSONObject1;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(uf.a(this.a.a));
        if (i != 0) {
          return;
        }
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        hb localhb;
        String[] arrayOfString;
        String str;
        continue;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      localhb = hb.a(uf.a(this.a.a));
      arrayOfString = new String[1];
      arrayOfString[0] = paramString;
      str = localhb.a(arrayOfString);
      MixpanelAPI.allInstances(new uj(this, str));
    }
  }
  
  private void a(uK paramuK)
  {
    if (!this.a.a.b().a(uf.a(this.a.a))) {
      uf.a(this.a.a, "Not flushing data to Mixpanel because the device is not connected to the internet.");
    }
    for (;;)
    {
      return;
      uf.a(this.a.a, "Sending records to Mixpanel");
      if (this.e)
      {
        uM localuM3 = uM.a;
        String[] arrayOfString3 = new String[1];
        arrayOfString3[0] = uf.b(this.a.a).i();
        a(paramuK, localuM3, arrayOfString3);
        uM localuM4 = uM.b;
        String[] arrayOfString4 = new String[1];
        arrayOfString4[0] = uf.b(this.a.a).j();
        a(paramuK, localuM4, arrayOfString4);
      }
      else
      {
        uM localuM1 = uM.a;
        String[] arrayOfString1 = new String[2];
        arrayOfString1[0] = uf.b(this.a.a).i();
        arrayOfString1[1] = uf.b(this.a.a).l();
        a(paramuK, localuM1, arrayOfString1);
        uM localuM2 = uM.b;
        String[] arrayOfString2 = new String[2];
        arrayOfString2[0] = uf.b(this.a.a).j();
        arrayOfString2[1] = uf.b(this.a.a).m();
        a(paramuK, localuM2, arrayOfString2);
      }
    }
  }
  
  private void a(uK paramuK, uM paramuM, String[] paramArrayOfString)
  {
    vh localvh = this.a.a.b();
    String[] arrayOfString = paramuK.a(paramuM);
    String str1;
    String str2;
    ArrayList localArrayList;
    int j;
    int k;
    String str4;
    if (arrayOfString != null)
    {
      str1 = arrayOfString[0];
      str2 = arrayOfString[1];
      String str3 = vR.a(str2);
      localArrayList = new ArrayList(1);
      localArrayList.add(new BasicNameValuePair("data", str3));
      if (uJ.a) {
        localArrayList.add(new BasicNameValuePair("verbose", "1"));
      }
      int i = paramArrayOfString.length;
      j = 0;
      k = 1;
      if (j >= i) {
        break label486;
      }
      str4 = paramArrayOfString[j];
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = localvh.a(str4, localArrayList);
        m = 1;
        if (arrayOfByte == null) {}
        try
        {
          uf.a(this.a.a, "Response was null, unexpected failure posting to " + str4 + ".");
          if (m != 0)
          {
            uf.a(this.a.a, "Not retrying this batch of events, deleting them from DB.");
            paramuK.a(str1, paramuM);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          try
          {
            String str5 = new String(arrayOfByte, "UTF-8");
            uf.a(this.a.a, "Successfully posted to " + str4 + ": \n" + str2);
            uf.a(this.a.a, "Response was " + str5);
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            throw new RuntimeException("UTF not supported on this platform?", localUnsupportedEncodingException);
          }
          localOutOfMemoryError2 = localOutOfMemoryError2;
          k = m;
          new StringBuilder().append("Out of memory when posting to ").append(str4).append(".").toString();
          m = k;
          continue;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          new StringBuilder().append("Cannot interpret ").append(str4).append(" as a URL.").toString();
          continue;
        }
      }
      catch (IOException localIOException)
      {
        uf.a(this.a.a, "Cannot post message to " + str4 + ".", localIOException);
        j++;
        k = 0;
        break;
        uf.a(this.a.a, "Retrying this batch of events.");
        if (hasMessages(uf.e())) {
          continue;
        }
        sendEmptyMessageDelayed(uf.e(), this.d);
        continue;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        m = k;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        continue;
      }
      label486:
      int m = k;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.b == null)
    {
      this.b = this.a.a.b(uf.a(this.a.a));
      this.b.a(System.currentTimeMillis() - uf.b(this.a.a).c(), uM.a);
      this.b.a(System.currentTimeMillis() - uf.b(this.a.a).c(), uM.b);
    }
    int i = -1;
    try
    {
      if (paramMessage.what == uf.c())
      {
        JSONObject localJSONObject2 = (JSONObject)paramMessage.obj;
        uf.a(this.a.a, "Queuing people record for sending later");
        uf.a(this.a.a, "    " + localJSONObject2.toString());
        i = this.b.a(localJSONObject2, uM.b);
      }
      for (;;)
      {
        if (i < uf.b(this.a.a).a()) {
          break label658;
        }
        uf.a(this.a.a, "Flushing queue due to bulk upload limit");
        uh.a(this.a);
        a(this.b);
        this.c.a(this.a.a.b());
        return;
        ug localug;
        if (paramMessage.what == uf.d())
        {
          localug = (ug)paramMessage.obj;
          try
          {
            JSONObject localJSONObject1 = a(localug);
            uf.a(this.a.a, "Queuing event for sending later");
            uf.a(this.a.a, "    " + localJSONObject1.toString());
            int k = this.b.a(localJSONObject1, uM.a);
            j = k;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              new StringBuilder().append("Exception tracking event ").append(localug.a()).toString();
              int j = i;
            }
          }
          i = j;
          continue;
        }
        if (paramMessage.what != uf.e()) {
          break;
        }
        uf.a(this.a.a, "Flushing queue due to scheduled or forced flush");
        uh.a(this.a);
        a(this.b);
        this.c.a(this.a.a.b());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        synchronized (uh.b(this.a))
        {
          uh.a(this.a, null);
        }
        try
        {
          Looper.myLooper().quit();
          label451:
          return;
          localObject2 = finally;
          throw localObject2;
          if (paramMessage.what == uf.f())
          {
            uf.a(this.a.a, "Installing a check for surveys and in app notifications");
            ut localut = (ut)paramMessage.obj;
            this.c.a(localut);
            this.c.a(this.a.a.b());
          }
          else if (paramMessage.what == uf.g())
          {
            a((String)paramMessage.obj);
          }
          else
          {
            if (paramMessage.what == uf.h())
            {
              new StringBuilder().append("Worker received a hard kill. Dumping all events and force-killing. Thread id ").append(Thread.currentThread().getId()).toString();
              synchronized (uh.b(this.a))
              {
                this.b.a();
                uh.a(this.a, null);
                Looper.myLooper().quit();
              }
            }
            new StringBuilder().append("Unexpected message received by Mixpanel worker: ").append(paramMessage).toString();
            continue;
            label658:
            if ((i > 0) && (!hasMessages(uf.e())))
            {
              uf.a(this.a.a, "Queue depth " + i + " - Adding flush in " + this.d);
              if (this.d >= 0L) {
                sendEmptyMessageDelayed(uf.e(), this.d);
              }
            }
          }
        }
        catch (Exception localException)
        {
          break label451;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ui
 * JD-Core Version:    0.7.0.1
 */