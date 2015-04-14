package com.facebook;

import android.content.Context;

final class AppEventsLogger$5
  implements Runnable
{
  AppEventsLogger$5(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger.AppEvent paramAppEvent) {}
  
  public void run()
  {
    AppEventsLogger.access$600(this.val$context, this.val$accessTokenAppId).addEvent(this.val$event);
    AppEventsLogger.access$700();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.5
 * JD-Core Version:    0.7.0.1
 */