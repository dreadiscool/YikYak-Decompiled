package com.facebook.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

public final class Util
{
  private static final String UTF8 = "UTF-8";
  
  @Deprecated
  public static Bundle decodeUrl(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    String[] arrayOfString1;
    int j;
    if (paramString != null)
    {
      arrayOfString1 = paramString.split("&");
      j = arrayOfString1.length;
    }
    for (;;)
    {
      if (i < j)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        try
        {
          if (arrayOfString2.length == 2) {
            localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
          } else if (arrayOfString2.length == 1) {
            localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      }
      else
      {
        return localBundle;
      }
      i++;
    }
  }
  
  @Deprecated
  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {}
    StringBuilder localStringBuilder;
    for (String str1 = "";; str1 = localStringBuilder.toString())
    {
      return str1;
      localStringBuilder = new StringBuilder();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject = paramBundle.get(str2);
        if ((localObject instanceof String))
        {
          localStringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + (String)localObject);
          localStringBuilder.append("\r\n--" + paramString + "\r\n");
        }
      }
    }
  }
  
  @Deprecated
  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    StringBuilder localStringBuilder;
    for (String str1 = "";; str1 = localStringBuilder.toString())
    {
      return str1;
      localStringBuilder = new StringBuilder();
      Iterator localIterator = paramBundle.keySet().iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if ((paramBundle.get(str2) instanceof String))
        {
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode(str2) + "=" + URLEncoder.encode(paramBundle.getString(str2)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
  }
  
  @Deprecated
  public static String openUrl(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramString2.equals("GET")) {
      paramString1 = paramString1 + "?" + encodeUrl(paramBundle);
    }
    Utility.logd("Facebook-Util", paramString2 + " URL: " + paramString1);
    localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
    localHttpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
    if (!paramString2.equals("GET"))
    {
      Bundle localBundle = new Bundle();
      Iterator localIterator1 = paramBundle.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str4 = (String)localIterator1.next();
        Object localObject2 = paramBundle.get(str4);
        if ((localObject2 instanceof byte[])) {
          localBundle.putByteArray(str4, (byte[])localObject2);
        }
      }
      if (!paramBundle.containsKey("method")) {
        paramBundle.putString("method", paramString2);
      }
      if (paramBundle.containsKey("access_token")) {
        paramBundle.putString("access_token", URLDecoder.decode(paramBundle.getString("access_token")));
      }
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
      localHttpURLConnection.connect();
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
      try
      {
        localBufferedOutputStream.write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
        localBufferedOutputStream.write(encodePostBody(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
        localBufferedOutputStream.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
        if (!localBundle.isEmpty())
        {
          Iterator localIterator2 = localBundle.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str3 = (String)localIterator2.next();
            localBufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str3 + "\"" + "\r\n").getBytes());
            localBufferedOutputStream.write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
            localBufferedOutputStream.write(localBundle.getByteArray(str3));
            localBufferedOutputStream.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
          }
        }
      }
      finally
      {
        localBufferedOutputStream.close();
      }
      localBufferedOutputStream.close();
    }
    try
    {
      String str2 = read(localHttpURLConnection.getInputStream());
      str1 = str2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        String str1 = read(localHttpURLConnection.getErrorStream());
      }
    }
    return str1;
  }
  
  @Deprecated
  public static JSONObject parseJson(String paramString)
  {
    if (paramString.equals("false")) {
      throw new FacebookError("request failed");
    }
    if (paramString.equals("true")) {
      paramString = "{value : true}";
    }
    JSONObject localJSONObject1 = new JSONObject(paramString);
    if (localJSONObject1.has("error"))
    {
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("error");
      throw new FacebookError(localJSONObject2.getString("message"), localJSONObject2.getString("type"), 0);
    }
    if ((localJSONObject1.has("error_code")) && (localJSONObject1.has("error_msg"))) {
      throw new FacebookError(localJSONObject1.getString("error_msg"), "", Integer.parseInt(localJSONObject1.getString("error_code")));
    }
    if (localJSONObject1.has("error_code")) {
      throw new FacebookError("request failed", "", Integer.parseInt(localJSONObject1.getString("error_code")));
    }
    if (localJSONObject1.has("error_msg")) {
      throw new FacebookError(localJSONObject1.getString("error_msg"));
    }
    if (localJSONObject1.has("error_reason")) {
      throw new FacebookError(localJSONObject1.getString("error_reason"));
    }
    return localJSONObject1;
  }
  
  @Deprecated
  public static Bundle parseUrl(String paramString)
  {
    String str = paramString.replace("fbconnect", "http");
    try
    {
      URL localURL = new URL(str);
      localBundle = decodeUrl(localURL.getQuery());
      localBundle.putAll(decodeUrl(localURL.getRef()));
      return localBundle;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Bundle localBundle = new Bundle();
      }
    }
  }
  
  @Deprecated
  private static String read(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  @Deprecated
  public static void showAlert(Context paramContext, String paramString1, String paramString2)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramString1);
    localBuilder.setMessage(paramString2);
    localBuilder.create().show();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.android.Util
 * JD-Core Version:    0.7.0.1
 */