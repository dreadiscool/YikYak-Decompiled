package com.parse;

import android.content.Context;
import com.parse.twitter.Twitter;
import java.util.Set;
import m;
import org.json.JSONException;

public final class ParseTwitterUtils
{
  private static boolean isInitialized;
  private static TwitterAuthenticationProvider provider;
  private static Twitter twitter;
  
  private static void checkInitialization()
  {
    if (!isInitialized) {
      throw new IllegalStateException("You must call ParseTwitterUtils.initialize() before using ParseTwitterUtils");
    }
  }
  
  private static TwitterAuthenticationProvider getAuthenticationProvider()
  {
    if (provider == null) {
      provider = new TwitterAuthenticationProvider(getTwitter());
    }
    return provider;
  }
  
  public static Twitter getTwitter()
  {
    if (twitter == null) {
      twitter = new Twitter("", "");
    }
    return twitter;
  }
  
  public static void initialize(String paramString1, String paramString2)
  {
    getTwitter().setConsumerKey(paramString1);
    getTwitter().setConsumerSecret(paramString2);
    ParseUser.registerAuthenticationProvider(getAuthenticationProvider());
    isInitialized = true;
  }
  
  public static boolean isLinked(ParseUser paramParseUser)
  {
    return paramParseUser.getLinkedServiceNames().contains(getAuthenticationProvider().getAuthType());
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, Context paramContext)
  {
    link(paramParseUser, paramContext, null);
  }
  
  public static void link(ParseUser paramParseUser, Context paramContext, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(linkInBackground(paramContext, paramParseUser), paramSaveCallback, true);
  }
  
  @Deprecated
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    link(paramParseUser, paramString1, paramString2, paramString3, paramString4, null);
  }
  
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, String paramString3, String paramString4, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(linkInBackground(paramParseUser, paramString1, paramString2, paramString3, paramString4), paramSaveCallback);
  }
  
  public static m<Void> linkInBackground(Context paramContext, ParseUser paramParseUser)
  {
    checkInitialization();
    getAuthenticationProvider().setContext(paramContext);
    return paramParseUser.linkWithAsync(getAuthenticationProvider().getAuthType());
  }
  
  public static m<Void> linkInBackground(ParseUser paramParseUser, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    
    try
    {
      m localm2 = paramParseUser.linkWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(paramString1, paramString2, paramString3, paramString4));
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
  
  public static void logIn(Context paramContext, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(paramContext), paramLogInCallback, true);
  }
  
  public static void logIn(String paramString1, String paramString2, String paramString3, String paramString4, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(paramString1, paramString2, paramString3, paramString4), paramLogInCallback);
  }
  
  public static m<ParseUser> logInInBackground(Context paramContext)
  {
    checkInitialization();
    getAuthenticationProvider().setContext(paramContext);
    return ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType());
  }
  
  public static m<ParseUser> logInInBackground(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    
    try
    {
      m localm2 = ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(paramString1, paramString2, paramString3, paramString4));
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
  
  public static void unlink(ParseUser paramParseUser)
  {
    Parse.waitForTask(unlinkInBackground(paramParseUser));
  }
  
  public static m<Void> unlinkInBackground(ParseUser paramParseUser)
  {
    checkInitialization();
    return paramParseUser.unlinkFromAsync(getAuthenticationProvider().getAuthType());
  }
  
  public static void unlinkInBackground(ParseUser paramParseUser, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(unlinkInBackground(paramParseUser), paramSaveCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTwitterUtils
 * JD-Core Version:    0.7.0.1
 */