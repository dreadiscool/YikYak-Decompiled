package com.facebook.internal;

import android.os.Bundle;

class LikeActionController$9
  implements PlatformServiceClient.CompletedListener
{
  LikeActionController$9(LikeActionController paramLikeActionController) {}
  
  public void completed(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED"))) {
      return;
    }
    boolean bool = paramBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
    String str1;
    label37:
    String str2;
    label54:
    String str3;
    label71:
    String str4;
    if (paramBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE"))
    {
      str1 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
        break label136;
      }
      str2 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
        break label148;
      }
      str3 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
        break label160;
      }
      str4 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
      label88:
      if (!paramBundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
        break label172;
      }
    }
    label136:
    label148:
    label160:
    label172:
    for (String str5 = paramBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");; str5 = LikeActionController.access$1300(this.this$0))
    {
      LikeActionController.access$1500(this.this$0, bool, str1, str2, str3, str4, str5);
      break;
      str1 = LikeActionController.access$900(this.this$0);
      break label37;
      str2 = LikeActionController.access$1000(this.this$0);
      break label54;
      str3 = LikeActionController.access$1100(this.this$0);
      break label71;
      str4 = LikeActionController.access$1200(this.this$0);
      break label88;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.9
 * JD-Core Version:    0.7.0.1
 */