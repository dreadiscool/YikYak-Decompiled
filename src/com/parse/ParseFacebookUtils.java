package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.Session;
import com.facebook.android.Facebook;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import m;
import org.json.JSONException;

public final class ParseFacebookUtils
{
  private static boolean isInitialized;
  protected static FacebookAuthenticationProvider provider;
  
  private static void checkInitialization()
  {
    if (!isInitialized) {
      initialize();
    }
  }
  
  @Deprecated
  public static void extendAccessToken(ParseUser paramParseUser, Context paramContext, SaveCallback paramSaveCallback)
  {
    checkInitialization();
    provider.extendAccessToken(paramContext, new ParseFacebookUtils.1(paramParseUser, paramSaveCallback));
  }
  
  @Deprecated
  public static boolean extendAccessTokenIfNeeded(ParseUser paramParseUser, Context paramContext, SaveCallback paramSaveCallback)
  {
    if (shouldExtendAccessToken(paramParseUser)) {
      extendAccessToken(paramParseUser, paramContext, paramSaveCallback);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void finishAuthentication(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (provider != null) {
      provider.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  @Deprecated
  public static Facebook getFacebook()
  {
    if (provider == null) {
      throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getFacebook()");
    }
    return provider.getFacebook();
  }
  
  public static Session getSession()
  {
    if (provider == null) {
      throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getSession()");
    }
    return provider.getSession();
  }
  
  protected static void initialize()
  {
    String str = null;
    Bundle localBundle = ManifestInfo.getApplicationMetadata();
    if (localBundle != null) {
      str = localBundle.getString("com.facebook.sdk.ApplicationId");
    }
    initialize(str);
  }
  
  public static void initialize(String paramString)
  {
    if (Parse.applicationContext == null) {
      throw new IllegalStateException("You must call Parse.initialize() before using ParseFacebookUtils");
    }
    provider = new FacebookAuthenticationProvider(Parse.applicationContext, paramString);
    ParseUser.registerAuthenticationProvider(provider);
    isInitialized = true;
  }
  
  public static boolean isLinked(ParseUser paramParseUser)
  {
    return paramParseUser.getLinkedServiceNames().contains("facebook");
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, Activity paramActivity)
  {
    linkInBackground(paramParseUser, paramActivity);
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, Activity paramActivity, int paramInt)
  {
    linkInBackground(paramParseUser, paramActivity, paramInt);
  }
  
  public static void link(ParseUser paramParseUser, Activity paramActivity, int paramInt, SaveCallback paramSaveCallback)
  {
    link(paramParseUser, Collections.emptyList(), paramActivity, paramInt, paramSaveCallback);
  }
  
  public static void link(ParseUser paramParseUser, Activity paramActivity, SaveCallback paramSaveCallback)
  {
    link(paramParseUser, Collections.emptyList(), paramActivity, 32665, paramSaveCallback);
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, Date paramDate)
  {
    linkInBackground(paramParseUser, paramString1, paramString2, paramDate);
  }
  
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, Date paramDate, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(linkInBackground(paramParseUser, paramString1, paramString2, paramDate), paramSaveCallback);
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity)
  {
    linkInBackground(paramParseUser, paramCollection, paramActivity);
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, int paramInt)
  {
    linkInBackground(paramParseUser, paramCollection, paramActivity, paramInt);
  }
  
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, int paramInt, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(linkInBackground(paramParseUser, paramCollection, paramActivity, paramInt), paramSaveCallback, true);
  }
  
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, SaveCallback paramSaveCallback)
  {
    link(paramParseUser, paramCollection, paramActivity, 32665, paramSaveCallback);
  }
  
  public static m<Void> linkInBackground(ParseUser paramParseUser, Activity paramActivity)
  {
    return linkInBackground(paramParseUser, Collections.emptyList(), paramActivity, 32665);
  }
  
  public static m<Void> linkInBackground(ParseUser paramParseUser, Activity paramActivity, int paramInt)
  {
    return linkInBackground(paramParseUser, Collections.emptyList(), paramActivity, paramInt);
  }
  
  public static m<Void> linkInBackground(ParseUser paramParseUser, String paramString1, String paramString2, Date paramDate)
  {
    
    try
    {
      m localm2 = paramParseUser.linkWithAsync(provider.getAuthType(), provider.getAuthData(paramString1, paramString2, paramDate));
      localm1 = localm2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        m localm1 = m.a(new ParseException(localJSONException));
      }
    }
    return localm1;
  }
  
  public static m<Void> linkInBackground(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity)
  {
    return linkInBackground(paramParseUser, paramCollection, paramActivity, 32665);
  }
  
  public static m<Void> linkInBackground(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, int paramInt)
  {
    checkInitialization();
    provider.setActivity(paramActivity);
    provider.setActivityCode(paramInt);
    if (paramCollection == null) {
      paramCollection = Collections.emptyList();
    }
    provider.setPermissions(paramCollection);
    return paramParseUser.linkWithAsync(provider.getAuthType());
  }
  
  public static void logIn(Activity paramActivity, int paramInt, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(Collections.emptyList(), paramActivity, paramInt), paramLogInCallback, true);
  }
  
  public static void logIn(Activity paramActivity, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(Collections.emptyList(), paramActivity, 32665), paramLogInCallback, true);
  }
  
  public static void logIn(String paramString1, String paramString2, Date paramDate, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(paramString1, paramString2, paramDate), paramLogInCallback);
  }
  
  public static void logIn(Collection<String> paramCollection, Activity paramActivity, int paramInt, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(paramCollection, paramActivity, paramInt), paramLogInCallback, true);
  }
  
  public static void logIn(Collection<String> paramCollection, Activity paramActivity, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(paramCollection, paramActivity, 32665), paramLogInCallback, true);
  }
  
  public static m<ParseUser> logInInBackground(String paramString1, String paramString2, Date paramDate)
  {
    
    try
    {
      m localm2 = ParseUser.logInWithAsync(provider.getAuthType(), provider.getAuthData(paramString1, paramString2, paramDate));
      localm1 = localm2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        m localm1 = m.a(new ParseException(localJSONException));
      }
    }
    return localm1;
  }
  
  public static m<ParseUser> logInInBackground(Collection<String> paramCollection, Activity paramActivity, int paramInt)
  {
    checkInitialization();
    provider.setActivity(paramActivity);
    provider.setActivityCode(paramInt);
    if (paramCollection == null) {
      paramCollection = Collections.emptyList();
    }
    provider.setPermissions(paramCollection);
    return ParseUser.logInWithAsync(provider.getAuthType());
  }
  
  @Deprecated
  public static void saveLatestSessionData(ParseUser paramParseUser)
  {
    saveLatestSessionDataInBackground(paramParseUser);
  }
  
  public static void saveLatestSessionData(ParseUser paramParseUser, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveLatestSessionDataInBackground(paramParseUser), paramSaveCallback);
  }
  
  public static m<Void> saveLatestSessionDataInBackground(ParseUser paramParseUser)
  {
    
    if (!isLinked(paramParseUser)) {
      throw new IllegalStateException("The user must already be linked to Facebook.");
    }
    Session localSession = getSession();
    return linkInBackground(paramParseUser, provider.getUserId(), localSession.getAccessToken(), localSession.getExpirationDate());
  }
  
  @Deprecated
  public static boolean shouldExtendAccessToken(ParseUser paramParseUser)
  {
    if ((paramParseUser != null) && (isLinked(paramParseUser)) && (getFacebook().shouldExtendAccessToken())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void unlink(ParseUser paramParseUser)
  {
    Parse.waitForTask(unlinkInBackground(paramParseUser));
  }
  
  public static m<Void> unlinkInBackground(ParseUser paramParseUser)
  {
    checkInitialization();
    return paramParseUser.unlinkFromAsync("facebook");
  }
  
  public static void unlinkInBackground(ParseUser paramParseUser, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(unlinkInBackground(paramParseUser), paramSaveCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFacebookUtils
 * JD-Core Version:    0.7.0.1
 */