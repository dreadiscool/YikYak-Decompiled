package com.facebook.internal;

import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utility$DialogFeatureConfig
{
  private String dialogName;
  private Uri fallbackUrl;
  private String featureName;
  private int[] featureVersionSpec;
  
  private Utility$DialogFeatureConfig(String paramString1, String paramString2, Uri paramUri, int[] paramArrayOfInt)
  {
    this.dialogName = paramString1;
    this.featureName = paramString2;
    this.fallbackUrl = paramUri;
    this.featureVersionSpec = paramArrayOfInt;
  }
  
  private static DialogFeatureConfig parseDialogConfig(JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str1 = paramJSONObject.optString("name");
    if (Utility.isNullOrEmpty(str1)) {}
    for (;;)
    {
      return localObject;
      String[] arrayOfString = str1.split("\\|");
      if (arrayOfString.length == 2)
      {
        String str2 = arrayOfString[0];
        String str3 = arrayOfString[1];
        if ((!Utility.isNullOrEmpty(str2)) && (!Utility.isNullOrEmpty(str3)))
        {
          String str4 = paramJSONObject.optString("url");
          if (!Utility.isNullOrEmpty(str4)) {
            localObject = Uri.parse(str4);
          }
          localObject = new DialogFeatureConfig(str2, str3, (Uri)localObject, parseVersionSpec(paramJSONObject.optJSONArray("versions")));
        }
      }
    }
  }
  
  private static int[] parseVersionSpec(JSONArray paramJSONArray)
  {
    Object localObject = null;
    if (paramJSONArray != null)
    {
      int i = paramJSONArray.length();
      int[] arrayOfInt = new int[i];
      int k;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          break label96;
        }
        k = paramJSONArray.optInt(j, -1);
        String str;
        if (k == -1)
        {
          str = paramJSONArray.optString(j);
          if (Utility.isNullOrEmpty(str)) {}
        }
        try
        {
          int m = Integer.parseInt(str);
          k = m;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Utility.logd("FacebookSDK", localNumberFormatException);
            k = -1;
          }
        }
        arrayOfInt[j] = k;
      }
      label96:
      localObject = arrayOfInt;
    }
    return localObject;
  }
  
  public String getDialogName()
  {
    return this.dialogName;
  }
  
  public Uri getFallbackUrl()
  {
    return this.fallbackUrl;
  }
  
  public String getFeatureName()
  {
    return this.featureName;
  }
  
  public int[] getVersionSpec()
  {
    return this.featureVersionSpec;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.Utility.DialogFeatureConfig
 * JD-Core Version:    0.7.0.1
 */