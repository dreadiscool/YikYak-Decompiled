package com.facebook;

import android.net.Uri;
import e;
import java.util.Map;
import l;
import m;

class FacebookAppLinkResolver$1
  implements l<Map<Uri, e>, e>
{
  FacebookAppLinkResolver$1(FacebookAppLinkResolver paramFacebookAppLinkResolver, Uri paramUri) {}
  
  public e then(m<Map<Uri, e>> paramm)
  {
    return (e)((Map)paramm.e()).get(this.val$uri);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookAppLinkResolver.1
 * JD-Core Version:    0.7.0.1
 */