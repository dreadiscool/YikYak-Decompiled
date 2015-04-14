package com.facebook.internal;

import android.content.Context;
import android.net.Uri.Builder;
import java.net.URI;

public class ImageRequest
{
  private static final String HEIGHT_PARAM = "height";
  private static final String MIGRATION_PARAM = "migration_overrides";
  private static final String MIGRATION_VALUE = "{october_2012:true}";
  private static final String PROFILEPIC_URL_FORMAT = "https://graph.facebook.com/%s/picture";
  public static final int UNSPECIFIED_DIMENSION = 0;
  private static final String WIDTH_PARAM = "width";
  private boolean allowCachedRedirects;
  private ImageRequest.Callback callback;
  private Object callerTag;
  private Context context;
  private URI imageUri;
  
  private ImageRequest(ImageRequest.Builder paramBuilder)
  {
    this.context = ImageRequest.Builder.access$000(paramBuilder);
    this.imageUri = ImageRequest.Builder.access$100(paramBuilder);
    this.callback = ImageRequest.Builder.access$200(paramBuilder);
    this.allowCachedRedirects = ImageRequest.Builder.access$300(paramBuilder);
    if (ImageRequest.Builder.access$400(paramBuilder) == null) {}
    for (Object localObject = new Object();; localObject = ImageRequest.Builder.access$400(paramBuilder))
    {
      this.callerTag = localObject;
      return;
    }
  }
  
  public static URI getProfilePictureUrl(String paramString, int paramInt1, int paramInt2)
  {
    Validate.notNullOrEmpty(paramString, "userId");
    int i = Math.max(paramInt1, 0);
    int j = Math.max(paramInt2, 0);
    if ((i == 0) && (j == 0)) {
      throw new IllegalArgumentException("Either width or height must be greater than 0");
    }
    Uri.Builder localBuilder1 = new Uri.Builder();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Uri.Builder localBuilder2 = localBuilder1.encodedPath(String.format("https://graph.facebook.com/%s/picture", arrayOfObject));
    if (j != 0) {
      localBuilder2.appendQueryParameter("height", String.valueOf(j));
    }
    if (i != 0) {
      localBuilder2.appendQueryParameter("width", String.valueOf(i));
    }
    localBuilder2.appendQueryParameter("migration_overrides", "{october_2012:true}");
    return new URI(localBuilder2.toString());
  }
  
  public ImageRequest.Callback getCallback()
  {
    return this.callback;
  }
  
  public Object getCallerTag()
  {
    return this.callerTag;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public URI getImageUri()
  {
    return this.imageUri;
  }
  
  public boolean isCachedRedirectAllowed()
  {
    return this.allowCachedRedirects;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageRequest
 * JD-Core Version:    0.7.0.1
 */