package com.facebook;

final class AppEventsLogger$7
  implements Request.Callback
{
  AppEventsLogger$7(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, Request paramRequest, AppEventsLogger.SessionEventsState paramSessionEventsState, AppEventsLogger.FlushStatistics paramFlushStatistics) {}
  
  public void onCompleted(Response paramResponse)
  {
    AppEventsLogger.access$900(this.val$accessTokenAppId, this.val$postRequest, paramResponse, this.val$sessionEventsState, this.val$flushState);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.7
 * JD-Core Version:    0.7.0.1
 */