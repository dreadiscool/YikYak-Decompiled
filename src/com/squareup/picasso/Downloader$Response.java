package com.squareup.picasso;

import android.graphics.Bitmap;
import java.io.InputStream;

public class Downloader$Response
{
  final Bitmap bitmap;
  final boolean cached;
  final long contentLength;
  final InputStream stream;
  
  @Deprecated
  public Downloader$Response(Bitmap paramBitmap, boolean paramBoolean)
  {
    this(paramBitmap, paramBoolean, -1L);
  }
  
  public Downloader$Response(Bitmap paramBitmap, boolean paramBoolean, long paramLong)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("Bitmap may not be null.");
    }
    this.stream = null;
    this.bitmap = paramBitmap;
    this.cached = paramBoolean;
    this.contentLength = paramLong;
  }
  
  @Deprecated
  public Downloader$Response(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, paramBoolean, -1L);
  }
  
  public Downloader$Response(InputStream paramInputStream, boolean paramBoolean, long paramLong)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Stream may not be null.");
    }
    this.stream = paramInputStream;
    this.bitmap = null;
    this.cached = paramBoolean;
    this.contentLength = paramLong;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public InputStream getInputStream()
  {
    return this.stream;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Downloader.Response
 * JD-Core Version:    0.7.0.1
 */