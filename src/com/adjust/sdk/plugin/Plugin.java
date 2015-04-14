package com.adjust.sdk.plugin;

import android.content.Context;
import java.util.Map.Entry;

public abstract interface Plugin
{
  public abstract Map.Entry<String, String> getParameter(Context paramContext);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.plugin.Plugin
 * JD-Core Version:    0.7.0.1
 */