package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import e;
import f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m;
import org.json.JSONException;
import org.json.JSONObject;
import y;

public class FacebookAppLinkResolver
{
  private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
  private static final String APP_LINK_KEY = "app_links";
  private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
  private static final String APP_LINK_TARGET_CLASS_KEY = "class";
  private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
  private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
  private static final String APP_LINK_TARGET_URL_KEY = "url";
  private static final String APP_LINK_WEB_TARGET_KEY = "web";
  private final HashMap<Uri, e> cachedAppLinks = new HashMap();
  
  private static f getAndroidTargetFromJson(JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str1 = tryGetStringFromJson(paramJSONObject, "package", null);
    if (str1 == null) {}
    for (;;)
    {
      return localObject;
      String str2 = tryGetStringFromJson(paramJSONObject, "class", null);
      String str3 = tryGetStringFromJson(paramJSONObject, "app_name", null);
      String str4 = tryGetStringFromJson(paramJSONObject, "url", null);
      if (str4 != null) {
        localObject = Uri.parse(str4);
      }
      localObject = new f(str1, str2, (Uri)localObject, str3);
    }
  }
  
  private static Uri getWebFallbackUriFromJson(Uri paramUri, JSONObject paramJSONObject)
  {
    Object localObject = null;
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("web");
      if (!tryGetBooleanFromJson(localJSONObject, "should_fallback", true))
      {
        paramUri = null;
      }
      else
      {
        String str = tryGetStringFromJson(localJSONObject, "url", null);
        if (str != null)
        {
          Uri localUri = Uri.parse(str);
          localObject = localUri;
        }
        if (localObject != null) {
          paramUri = localObject;
        }
      }
    }
    catch (JSONException localJSONException) {}
    return paramUri;
  }
  
  private static boolean tryGetBooleanFromJson(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      paramBoolean = bool;
    }
    catch (JSONException localJSONException)
    {
      label10:
      break label10;
    }
    return paramBoolean;
  }
  
  private static String tryGetStringFromJson(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      String str = paramJSONObject.getString(paramString1);
      paramString2 = str;
    }
    catch (JSONException localJSONException)
    {
      label10:
      break label10;
    }
    return paramString2;
  }
  
  public m<e> getAppLinkFromUrlInBackground(Uri paramUri)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramUri);
    return getAppLinkFromUrlsInBackground(localArrayList).c(new FacebookAppLinkResolver.1(this, paramUri));
  }
  
  public m<Map<Uri, e>> getAppLinkFromUrlsInBackground(List<Uri> paramList)
  {
    HashMap localHashMap1 = new HashMap();
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      synchronized (this.cachedAppLinks)
      {
        e locale = (e)this.cachedAppLinks.get(localUri);
        if (locale != null) {
          localHashMap1.put(localUri, locale);
        }
      }
      if (!localHashSet.isEmpty()) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(localUri.toString());
      localHashSet.add(localUri);
    }
    if (localHashSet.isEmpty()) {}
    y localy;
    for (m localm = m.a(localHashMap1);; localm = localy.a())
    {
      return localm;
      localy = m.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("ids", localStringBuilder.toString());
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = "app_links";
      arrayOfObject[1] = "android";
      arrayOfObject[2] = "web";
      localBundle.putString("fields", String.format("%s.fields(%s,%s)", arrayOfObject));
      new Request(null, "", localBundle, null, new FacebookAppLinkResolver.2(this, localy, localHashMap1, localHashSet)).executeAsync();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookAppLinkResolver
 * JD-Core Version:    0.7.0.1
 */