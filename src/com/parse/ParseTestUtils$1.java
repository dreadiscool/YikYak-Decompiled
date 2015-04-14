package com.parse;

import org.json.JSONObject;

final class ParseTestUtils$1
  implements PushRouter.PushListener
{
  public void onPushHandled(JSONObject paramJSONObject, PushRouter.HandlePushResult paramHandlePushResult)
  {
    if ((paramHandlePushResult == PushRouter.HandlePushResult.INVOKED_PARSE_PUSH_BROADCAST_RECEIVER) || (paramHandlePushResult == PushRouter.HandlePushResult.SHOW_NOTIFICATION) || (paramHandlePushResult == PushRouter.HandlePushResult.SHOW_NOTIFICATION_AND_BROADCAST_INTENT)) {
      ParseTestUtils.access$208();
    }
    try
    {
      ParseTestUtils.PushRoutedListener localPushRoutedListener = ParseTestUtils.access$300();
      if (localPushRoutedListener != null) {
        localPushRoutedListener.onPushRouted(paramJSONObject);
      }
      return;
    }
    finally {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTestUtils.1
 * JD-Core Version:    0.7.0.1
 */