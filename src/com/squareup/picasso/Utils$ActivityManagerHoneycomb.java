package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;

@TargetApi(11)
class Utils$ActivityManagerHoneycomb
{
  static int getLargeMemoryClass(ActivityManager paramActivityManager)
  {
    return paramActivityManager.getLargeMemoryClass();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Utils.ActivityManagerHoneycomb
 * JD-Core Version:    0.7.0.1
 */