package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONObject;

final class BundleJSONConverter$3
  implements BundleJSONConverter.Setter
{
  public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putLong(paramString, ((Long)paramObject).longValue());
  }
  
  public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    paramJSONObject.put(paramString, paramObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.3
 * JD-Core Version:    0.7.0.1
 */