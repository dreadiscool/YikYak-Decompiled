package com.parse;

import java.util.Set;
import m;
import org.json.JSONException;

public final class ParseAnonymousUtils
{
  static final String ANONYMOUS_AUTH_TYPE = "anonymous";
  private static AnonymousAuthenticationProvider provider;
  
  static void initialize()
  {
    if (provider == null)
    {
      provider = new AnonymousAuthenticationProvider();
      ParseUser.registerAuthenticationProvider(provider);
    }
  }
  
  public static boolean isLinked(ParseUser paramParseUser)
  {
    return paramParseUser.getLinkedServiceNames().contains("anonymous");
  }
  
  static void lazyLogIn()
  {
    try
    {
      ParseUser.logInLazyUser(provider.getAuthType(), provider.getAuthData());
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public static void logIn(LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(), paramLogInCallback);
  }
  
  public static m<ParseUser> logInInBackground()
  {
    return ParseUser.logInWithAsync(provider.getAuthType());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAnonymousUtils
 * JD-Core Version:    0.7.0.1
 */