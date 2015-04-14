package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

final class BundleJSONConverter$7
  implements BundleJSONConverter.Setter
{
  public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    JSONArray localJSONArray = (JSONArray)paramObject;
    ArrayList localArrayList = new ArrayList();
    if (localJSONArray.length() == 0) {
      paramBundle.putStringArrayList(paramString, localArrayList);
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < localJSONArray.length())
      {
        Object localObject = localJSONArray.get(i);
        if ((localObject instanceof String))
        {
          localArrayList.add((String)localObject);
          i++;
        }
        else
        {
          throw new IllegalArgumentException("Unexpected type in an array: " + localObject.getClass());
        }
      }
      paramBundle.putStringArrayList(paramString, localArrayList);
    }
  }
  
  public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.7
 * JD-Core Version:    0.7.0.1
 */