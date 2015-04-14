package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONObject;

final class BundleJSONConverter$2
  implements BundleJSONConverter.Setter
{
  public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
  }
  
  public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    paramJSONObject.put(paramString, paramObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.2
 * JD-Core Version:    0.7.0.1
 */