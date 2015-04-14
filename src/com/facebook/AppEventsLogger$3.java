package com.facebook;

final class AppEventsLogger$3
  implements Runnable
{
  public void run()
  {
    if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
      AppEventsLogger.access$300(AppEventsLogger.FlushReason.TIMER);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.3
 * JD-Core Version:    0.7.0.1
 */