package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

final class BundleJSONConverter$6
  implements BundleJSONConverter.Setter
{
  public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    throw new IllegalArgumentException("Unexpected type from JSON");
  }
  
  public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = (String[])paramObject;
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++) {
      localJSONArray.put(arrayOfString[j]);
    }
    paramJSONObject.put(paramString, localJSONArray);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.6
 * JD-Core Version:    0.7.0.1
 */