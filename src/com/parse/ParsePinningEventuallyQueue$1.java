package com.parse;

import android.content.Intent;

class ParsePinningEventuallyQueue$1
  implements ConnectivityNotifier.ConnectivityListener
{
  ParsePinningEventuallyQueue$1(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue) {}
  
  public void networkConnectivityStatusChanged(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("noConnectivity", false)) {
      this.this$0.setConnected(false);
    }
    for (;;)
    {
      return;
      this.this$0.setConnected(ConnectivityNotifier.getNotifier().isConnected());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.1
 * JD-Core Version:    0.7.0.1
 */