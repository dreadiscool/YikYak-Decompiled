package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

final class GetTokenClient
  extends PlatformServiceClient
{
  GetTokenClient(Context paramContext, String paramString)
  {
    super(paramContext, 65536, 65537, 20121101, paramString);
  }
  
  protected void populateRequestBundle(Bundle paramBundle) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.GetTokenClient
 * JD-Core Version:    0.7.0.1
 */