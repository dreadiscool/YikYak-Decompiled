package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionState;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.facebook.TokenCachingStrategy;
import com.facebook.android.Facebook;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookAuthenticationProvider
  implements ParseAuthenticationProvider
{
  private static final String AUTH_TYPE_NAME = "facebook";
  public static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
  private int activityCode;
  private Context applicationContext;
  protected String applicationId;
  private WeakReference<Activity> baseActivity;
  private ParseAuthenticationProvider.ParseAuthenticationCallback currentOperationCallback;
  private SessionDefaultAudience defaultAudience;
  private Facebook facebook;
  private Collection<String> permissions;
  private final DateFormat preciseDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
  private Session session;
  private String userId;
  
  public FacebookAuthenticationProvider(Context paramContext, String paramString)
  {
    this.preciseDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    this.activityCode = 32665;
    this.applicationId = paramString;
    if (paramContext != null) {
      this.applicationContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.facebook = new Facebook(paramString);
    }
  }
  
  private void handleCancel()
  {
    if (this.currentOperationCallback == null) {}
    for (;;)
    {
      return;
      try
      {
        this.currentOperationCallback.onCancel();
        this.currentOperationCallback = null;
      }
      finally
      {
        this.currentOperationCallback = null;
      }
    }
  }
  
  private void handleError(Throwable paramThrowable)
  {
    if (this.currentOperationCallback == null) {}
    for (;;)
    {
      return;
      try
      {
        this.currentOperationCallback.onError(paramThrowable);
        this.currentOperationCallback = null;
      }
      finally
      {
        this.currentOperationCallback = null;
      }
    }
  }
  
  private void handleSuccess(String paramString)
  {
    if (this.currentOperationCallback == null) {}
    for (;;)
    {
      return;
      this.userId = paramString;
      try
      {
        localJSONObject = getAuthData(paramString, this.session.getAccessToken(), this.session.getExpirationDate());
      }
      catch (JSONException localJSONException)
      {
        try
        {
          JSONObject localJSONObject;
          this.currentOperationCallback.onSuccess(localJSONObject);
          this.currentOperationCallback = null;
        }
        finally
        {
          this.currentOperationCallback = null;
        }
        localJSONException = localJSONException;
        handleError(localJSONException);
      }
    }
  }
  
  public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback)
  {
    Activity localActivity;
    for (;;)
    {
      try
      {
        if (this.currentOperationCallback != null) {
          cancel();
        }
        this.currentOperationCallback = paramParseAuthenticationCallback;
        if (this.baseActivity == null)
        {
          localActivity = null;
          if (localActivity != null) {
            break;
          }
          throw new IllegalStateException("Activity must be non-null for Facebook authentication to proceed.");
        }
      }
      finally {}
      localActivity = (Activity)this.baseActivity.get();
    }
    int i = this.activityCode;
    this.session = new Session.Builder(localActivity).setApplicationId(this.applicationId).setTokenCachingStrategy(new SharedPreferencesTokenCachingStrategy(localActivity)).build();
    Session.OpenRequest localOpenRequest = new Session.OpenRequest(localActivity);
    localOpenRequest.setRequestCode(i);
    if (this.defaultAudience != null) {
      localOpenRequest.setDefaultAudience(this.defaultAudience);
    }
    if (this.permissions != null) {
      localOpenRequest.setPermissions(new ArrayList(this.permissions));
    }
    localOpenRequest.setCallback(new FacebookAuthenticationProvider.2(this));
    this.session.openForRead(localOpenRequest);
  }
  
  public void cancel()
  {
    try
    {
      handleCancel();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void deauthenticate()
  {
    restoreAuthentication(null);
  }
  
  @Deprecated
  public void extendAccessToken(Context paramContext, ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback)
  {
    try
    {
      if (this.currentOperationCallback != null) {
        cancel();
      }
      this.currentOperationCallback = paramParseAuthenticationCallback;
      if (!this.facebook.extendAccessToken(paramContext, new FacebookAuthenticationProvider.1(this))) {
        handleCancel();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getActivityCode()
  {
    return this.activityCode;
  }
  
  public JSONObject getAuthData(String paramString1, String paramString2, Date paramDate)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", paramString1);
    localJSONObject.put("access_token", paramString2);
    localJSONObject.put("expiration_date", this.preciseDateFormat.format(paramDate));
    return localJSONObject;
  }
  
  public String getAuthType()
  {
    return "facebook";
  }
  
  public Facebook getFacebook()
  {
    return this.facebook;
  }
  
  public Session getSession()
  {
    return this.session;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Activity localActivity = (Activity)this.baseActivity.get();
    if (localActivity != null) {
      this.session.onActivityResult(localActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean restoreAuthentication(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null)
    {
      if (this.facebook != null)
      {
        this.facebook.setAccessExpires(0L);
        this.facebook.setAccessToken(null);
      }
      this.session = null;
    }
    for (;;)
    {
      return bool;
      try
      {
        String str = paramJSONObject.getString("access_token");
        Date localDate = this.preciseDateFormat.parse(paramJSONObject.getString("expiration_date"));
        if (this.facebook != null)
        {
          this.facebook.setAccessToken(str);
          this.facebook.setAccessExpires(localDate.getTime());
        }
        SharedPreferencesTokenCachingStrategy localSharedPreferencesTokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(this.applicationContext);
        Bundle localBundle = localSharedPreferencesTokenCachingStrategy.load();
        TokenCachingStrategy.putToken(localBundle, paramJSONObject.getString("access_token"));
        TokenCachingStrategy.putExpirationDate(localBundle, localDate);
        localSharedPreferencesTokenCachingStrategy.save(localBundle);
        Session localSession = new Session.Builder(this.applicationContext).setApplicationId(this.applicationId).setTokenCachingStrategy(localSharedPreferencesTokenCachingStrategy).build();
        if (localSession.getState() == SessionState.CREATED_TOKEN_LOADED)
        {
          localSession.openForRead(null);
          this.session = localSession;
          Session.setActiveSession(this.session);
        }
        else
        {
          this.session = null;
        }
      }
      catch (Exception localException)
      {
        bool = false;
      }
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    try
    {
      this.baseActivity = new WeakReference(paramActivity);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setActivityCode(int paramInt)
  {
    try
    {
      this.activityCode = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPermissions(Collection<String> paramCollection)
  {
    try
    {
      this.permissions = paramCollection;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.FacebookAuthenticationProvider
 * JD-Core Version:    0.7.0.1
 */