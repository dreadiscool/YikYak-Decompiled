package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;

final class LikeStatusClient
  extends PlatformServiceClient
{
  private String objectId;
  
  LikeStatusClient(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 65542, 65543, 20141001, paramString1);
    this.objectId = paramString2;
  }
  
  protected void populateRequestBundle(Bundle paramBundle)
  {
    paramBundle.putString("com.facebook.platform.extra.OBJECT_ID", this.objectId);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeStatusClient
 * JD-Core Version:    0.7.0.1
 */