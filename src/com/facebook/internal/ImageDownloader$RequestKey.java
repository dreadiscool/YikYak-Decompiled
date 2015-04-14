package com.facebook.internal;

import java.net.URI;

class ImageDownloader$RequestKey
{
  private static final int HASH_MULTIPLIER = 37;
  private static final int HASH_SEED = 29;
  Object tag;
  URI uri;
  
  ImageDownloader$RequestKey(URI paramURI, Object paramObject)
  {
    this.uri = paramURI;
    this.tag = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject != null) && ((paramObject instanceof RequestKey)))
    {
      RequestKey localRequestKey = (RequestKey)paramObject;
      if ((localRequestKey.uri == this.uri) && (localRequestKey.tag == this.tag)) {
        bool = true;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    return 37 * (1073 + this.uri.hashCode()) + this.tag.hashCode();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader.RequestKey
 * JD-Core Version:    0.7.0.1
 */