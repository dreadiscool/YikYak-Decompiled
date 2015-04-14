package com.parse;

import android.content.Intent;

class ParseCommandCache$1
  implements ConnectivityNotifier.ConnectivityListener
{
  ParseCommandCache$1(ParseCommandCache paramParseCommandCache) {}
  
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
 * Qualified Name:     com.parse.ParseCommandCache.1
 * JD-Core Version:    0.7.0.1
 */