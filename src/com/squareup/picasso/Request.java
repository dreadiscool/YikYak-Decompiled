package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Request
{
  private static final long TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5L);
  public final boolean centerCrop;
  public final boolean centerInside;
  public final Bitmap.Config config;
  public final boolean hasRotationPivot;
  int id;
  public final int resourceId;
  public final float rotationDegrees;
  public final float rotationPivotX;
  public final float rotationPivotY;
  long started;
  public final int targetHeight;
  public final int targetWidth;
  public final List<Transformation> transformations;
  public final Uri uri;
  
  private Request(Uri paramUri, int paramInt1, List<Transformation> paramList, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean3, Bitmap.Config paramConfig)
  {
    this.uri = paramUri;
    this.resourceId = paramInt1;
    if (paramList == null) {}
    for (this.transformations = null;; this.transformations = Collections.unmodifiableList(paramList))
    {
      this.targetWidth = paramInt2;
      this.targetHeight = paramInt3;
      this.centerCrop = paramBoolean1;
      this.centerInside = paramBoolean2;
      this.rotationDegrees = paramFloat1;
      this.rotationPivotX = paramFloat2;
      this.rotationPivotY = paramFloat3;
      this.hasRotationPivot = paramBoolean3;
      this.config = paramConfig;
      return;
    }
  }
  
  public Request.Builder buildUpon()
  {
    return new Request.Builder(this, null);
  }
  
  String getName()
  {
    if (this.uri != null) {}
    for (String str = String.valueOf(this.uri.getPath());; str = Integer.toHexString(this.resourceId)) {
      return str;
    }
  }
  
  boolean hasCustomTransformations()
  {
    if (this.transformations != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasSize()
  {
    if (this.targetWidth != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  String logId()
  {
    long l = System.nanoTime() - this.started;
    if (l > TOO_LONG_LOG) {}
    for (String str = plainId() + '+' + TimeUnit.NANOSECONDS.toSeconds(l) + 's';; str = plainId() + '+' + TimeUnit.NANOSECONDS.toMillis(l) + "ms") {
      return str;
    }
  }
  
  boolean needsMatrixTransform()
  {
    if ((this.targetWidth != 0) || (this.rotationDegrees != 0.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean needsTransformation()
  {
    if ((needsMatrixTransform()) || (hasCustomTransformations())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  String plainId()
  {
    return "[R" + this.id + ']';
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{");
    if (this.resourceId > 0) {
      localStringBuilder.append(this.resourceId);
    }
    while ((this.transformations != null) && (!this.transformations.isEmpty()))
    {
      Iterator localIterator = this.transformations.iterator();
      while (localIterator.hasNext())
      {
        Transformation localTransformation = (Transformation)localIterator.next();
        localStringBuilder.append(' ').append(localTransformation.key());
      }
      localStringBuilder.append(this.uri);
    }
    if (this.targetWidth > 0) {
      localStringBuilder.append(" resize(").append(this.targetWidth).append(',').append(this.targetHeight).append(')');
    }
    if (this.centerCrop) {
      localStringBuilder.append(" centerCrop");
    }
    if (this.centerInside) {
      localStringBuilder.append(" centerInside");
    }
    if (this.rotationDegrees != 0.0F)
    {
      localStringBuilder.append(" rotation(").append(this.rotationDegrees);
      if (this.hasRotationPivot) {
        localStringBuilder.append(" @ ").append(this.rotationPivotX).append(',').append(this.rotationPivotY);
      }
      localStringBuilder.append(')');
    }
    if (this.config != null) {
      localStringBuilder.append(' ').append(this.config);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Request
 * JD-Core Version:    0.7.0.1
 */