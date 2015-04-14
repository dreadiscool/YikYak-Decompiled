package com.facebook.internal;

import android.content.Context;
import java.net.URI;

public class ImageRequest$Builder
{
  private boolean allowCachedRedirects;
  private ImageRequest.Callback callback;
  private Object callerTag;
  private Context context;
  private URI imageUrl;
  
  public ImageRequest$Builder(Context paramContext, URI paramURI)
  {
    Validate.notNull(paramURI, "imageUrl");
    this.context = paramContext;
    this.imageUrl = paramURI;
  }
  
  public ImageRequest build()
  {
    return new ImageRequest(this, null);
  }
  
  public Builder setAllowCachedRedirects(boolean paramBoolean)
  {
    this.allowCachedRedirects = paramBoolean;
    return this;
  }
  
  public Builder setCallback(ImageRequest.Callback paramCallback)
  {
    this.callback = paramCallback;
    return this;
  }
  
  public Builder setCallerTag(Object paramObject)
  {
    this.callerTag = paramObject;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageRequest.Builder
 * JD-Core Version:    0.7.0.1
 */