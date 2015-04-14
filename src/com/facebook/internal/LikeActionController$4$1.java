package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.ConcurrentHashMap;

class LikeActionController$4$1
  implements Runnable
{
  LikeActionController$4$1(LikeActionController.4 param4, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$shouldClearDisk)
    {
      LikeActionController.access$302((1 + LikeActionController.access$300()) % 1000);
      LikeActionController.access$400().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.access$300()).apply();
      LikeActionController.access$500().clear();
      LikeActionController.access$600().clearCache();
    }
    LikeActionController.access$700(null, "com.facebook.sdk.LikeActionController.DID_RESET");
    LikeActionController.access$202(false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.4.1
 * JD-Core Version:    0.7.0.1
 */