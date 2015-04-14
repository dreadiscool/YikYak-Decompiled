package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TokenCachingStrategy
{
  public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
  public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
  private static final long INVALID_BUNDLE_MILLISECONDS = -9223372036854775808L;
  private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
  public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
  public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
  public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
  public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
  public static final String USER_FBID_KEY = "com.facebook.TokenCachingStrategy.UserFBID";
  
  static Date getDate(Bundle paramBundle, String paramString)
  {
    Date localDate = null;
    if (paramBundle == null) {}
    for (;;)
    {
      return localDate;
      long l = paramBundle.getLong(paramString, -9223372036854775808L);
      if (l != -9223372036854775808L) {
        localDate = new Date(l);
      }
    }
  }
  
  public static Date getExpirationDate(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    return getDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
  }
  
  public static long getExpirationMilliseconds(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    return paramBundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
  }
  
  public static Date getLastRefreshDate(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    return getDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
  }
  
  public static long getLastRefreshMilliseconds(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    return paramBundle.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
  }
  
  public static List<String> getPermissions(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    return paramBundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
  }
  
  public static AccessTokenSource getSource(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    AccessTokenSource localAccessTokenSource;
    if (paramBundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
      localAccessTokenSource = (AccessTokenSource)paramBundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
    }
    for (;;)
    {
      return localAccessTokenSource;
      if (paramBundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO")) {
        localAccessTokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
      } else {
        localAccessTokenSource = AccessTokenSource.WEB_VIEW;
      }
    }
  }
  
  public static String getToken(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    return paramBundle.getString("com.facebook.TokenCachingStrategy.Token");
  }
  
  public static boolean hasTokenInformation(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle == null) {}
    for (;;)
    {
      return bool;
      String str = paramBundle.getString("com.facebook.TokenCachingStrategy.Token");
      if ((str != null) && (str.length() != 0) && (paramBundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) != 0L)) {
        bool = true;
      }
    }
  }
  
  static void putDate(Bundle paramBundle, String paramString, Date paramDate)
  {
    paramBundle.putLong(paramString, paramDate.getTime());
  }
  
  public static void putDeclinedPermissions(Bundle paramBundle, List<String> paramList)
  {
    Validate.notNull(paramBundle, "bundle");
    Validate.notNull(paramList, "value");
    if ((paramList instanceof ArrayList)) {}
    for (ArrayList localArrayList = (ArrayList)paramList;; localArrayList = new ArrayList(paramList))
    {
      paramBundle.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", localArrayList);
      return;
    }
  }
  
  public static void putExpirationDate(Bundle paramBundle, Date paramDate)
  {
    Validate.notNull(paramBundle, "bundle");
    Validate.notNull(paramDate, "value");
    putDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate", paramDate);
  }
  
  public static void putExpirationMilliseconds(Bundle paramBundle, long paramLong)
  {
    Validate.notNull(paramBundle, "bundle");
    paramBundle.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", paramLong);
  }
  
  public static void putLastRefreshDate(Bundle paramBundle, Date paramDate)
  {
    Validate.notNull(paramBundle, "bundle");
    Validate.notNull(paramDate, "value");
    putDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", paramDate);
  }
  
  public static void putLastRefreshMilliseconds(Bundle paramBundle, long paramLong)
  {
    Validate.notNull(paramBundle, "bundle");
    paramBundle.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", paramLong);
  }
  
  public static void putPermissions(Bundle paramBundle, List<String> paramList)
  {
    Validate.notNull(paramBundle, "bundle");
    Validate.notNull(paramList, "value");
    if ((paramList instanceof ArrayList)) {}
    for (ArrayList localArrayList = (ArrayList)paramList;; localArrayList = new ArrayList(paramList))
    {
      paramBundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", localArrayList);
      return;
    }
  }
  
  public static void putSource(Bundle paramBundle, AccessTokenSource paramAccessTokenSource)
  {
    Validate.notNull(paramBundle, "bundle");
    paramBundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", paramAccessTokenSource);
  }
  
  public static void putToken(Bundle paramBundle, String paramString)
  {
    Validate.notNull(paramBundle, "bundle");
    Validate.notNull(paramString, "value");
    paramBundle.putString("com.facebook.TokenCachingStrategy.Token", paramString);
  }
  
  public abstract void clear();
  
  public abstract Bundle load();
  
  public abstract void save(Bundle paramBundle);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.TokenCachingStrategy
 * JD-Core Version:    0.7.0.1
 */