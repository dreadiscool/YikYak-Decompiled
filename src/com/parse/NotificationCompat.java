package com.parse;

import android.os.Build.VERSION;

class NotificationCompat
{
  public static final int FLAG_HIGH_PRIORITY = 128;
  private static final NotificationCompat.NotificationCompatImpl IMPL;
  public static final int PRIORITY_DEFAULT;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (IMPL = new NotificationCompat.NotificationCompatPostJellyBean();; IMPL = new NotificationCompat.NotificationCompatImplBase()) {
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NotificationCompat
 * JD-Core Version:    0.7.0.1
 */