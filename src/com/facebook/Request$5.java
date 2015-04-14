package com.facebook;

import java.net.URLEncoder;
import java.util.ArrayList;

class Request$5
  implements Request.KeyValueSerializer
{
  Request$5(Request paramRequest, ArrayList paramArrayList) {}
  
  public void writeString(String paramString1, String paramString2)
  {
    ArrayList localArrayList = this.val$keysAndValues;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = URLEncoder.encode(paramString2, "UTF-8");
    localArrayList.add(String.format("%s=%s", arrayOfObject));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.5
 * JD-Core Version:    0.7.0.1
 */