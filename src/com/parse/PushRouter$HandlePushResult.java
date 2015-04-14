package com.parse;

 enum PushRouter$HandlePushResult
{
  static
  {
    FAILED_HISTORY_TEST = new HandlePushResult("FAILED_HISTORY_TEST", 1);
    NO_ROUTE_FOUND = new HandlePushResult("NO_ROUTE_FOUND", 2);
    INVALID_ROUTE = new HandlePushResult("INVALID_ROUTE", 3);
    BROADCAST_INTENT = new HandlePushResult("BROADCAST_INTENT", 4);
    SHOW_NOTIFICATION = new HandlePushResult("SHOW_NOTIFICATION", 5);
    SHOW_NOTIFICATION_AND_BROADCAST_INTENT = new HandlePushResult("SHOW_NOTIFICATION_AND_BROADCAST_INTENT", 6);
    INVOKED_PARSE_PUSH_BROADCAST_RECEIVER = new HandlePushResult("INVOKED_PARSE_PUSH_BROADCAST_RECEIVER", 7);
    HandlePushResult[] arrayOfHandlePushResult = new HandlePushResult[8];
    arrayOfHandlePushResult[0] = INVALID_DATA;
    arrayOfHandlePushResult[1] = FAILED_HISTORY_TEST;
    arrayOfHandlePushResult[2] = NO_ROUTE_FOUND;
    arrayOfHandlePushResult[3] = INVALID_ROUTE;
    arrayOfHandlePushResult[4] = BROADCAST_INTENT;
    arrayOfHandlePushResult[5] = SHOW_NOTIFICATION;
    arrayOfHandlePushResult[6] = SHOW_NOTIFICATION_AND_BROADCAST_INTENT;
    arrayOfHandlePushResult[7] = INVOKED_PARSE_PUSH_BROADCAST_RECEIVER;
    $VALUES = arrayOfHandlePushResult;
  }
  
  private PushRouter$HandlePushResult() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.HandlePushResult
 * JD-Core Version:    0.7.0.1
 */