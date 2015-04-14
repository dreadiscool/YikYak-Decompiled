package com.facebook;

 enum AppEventsLogger$FlushReason
{
  static
  {
    SESSION_CHANGE = new FlushReason("SESSION_CHANGE", 2);
    PERSISTED_EVENTS = new FlushReason("PERSISTED_EVENTS", 3);
    EVENT_THRESHOLD = new FlushReason("EVENT_THRESHOLD", 4);
    EAGER_FLUSHING_EVENT = new FlushReason("EAGER_FLUSHING_EVENT", 5);
    FlushReason[] arrayOfFlushReason = new FlushReason[6];
    arrayOfFlushReason[0] = EXPLICIT;
    arrayOfFlushReason[1] = TIMER;
    arrayOfFlushReason[2] = SESSION_CHANGE;
    arrayOfFlushReason[3] = PERSISTED_EVENTS;
    arrayOfFlushReason[4] = EVENT_THRESHOLD;
    arrayOfFlushReason[5] = EAGER_FLUSHING_EVENT;
    $VALUES = arrayOfFlushReason;
  }
  
  private AppEventsLogger$FlushReason() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.FlushReason
 * JD-Core Version:    0.7.0.1
 */