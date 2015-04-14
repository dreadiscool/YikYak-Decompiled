package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public final class Request$Builder
{
  private boolean centerCrop;
  private boolean centerInside;
  private Bitmap.Config config;
  private boolean hasRotationPivot;
  private int resourceId;
  private float rotationDegrees;
  private float rotationPivotX;
  private float rotationPivotY;
  private int targetHeight;
  private int targetWidth;
  private List<Transformation> transformations;
  private Uri uri;
  
  public Request$Builder(int paramInt)
  {
    setResourceId(paramInt);
  }
  
  public Request$Builder(Uri paramUri)
  {
    setUri(paramUri);
  }
  
  Request$Builder(Uri paramUri, int paramInt)
  {
    this.uri = paramUri;
    this.resourceId = paramInt;
  }
  
  private Request$Builder(Request paramRequest)
  {
    this.uri = paramRequest.uri;
    this.resourceId = paramRequest.resourceId;
    this.targetWidth = paramRequest.targetWidth;
    this.targetHeight = paramRequest.targetHeight;
    this.centerCrop = paramRequest.centerCrop;
    this.centerInside = paramRequest.centerInside;
    this.rotationDegrees = paramRequest.rotationDegrees;
    this.rotationPivotX = paramRequest.rotationPivotX;
    this.rotationPivotY = paramRequest.rotationPivotY;
    this.hasRotationPivot = paramRequest.hasRotationPivot;
    if (paramRequest.transformations != null) {
      this.transformations = new ArrayList(paramRequest.transformations);
    }
    this.config = paramRequest.config;
  }
  
  public Request build()
  {
    if ((this.centerInside) && (this.centerCrop)) {
      throw new IllegalStateException("Center crop and center inside can not be used together.");
    }
    if ((this.centerCrop) && (this.targetWidth == 0)) {
      throw new IllegalStateException("Center crop requires calling resize.");
    }
    if ((this.centerInside) && (this.targetWidth == 0)) {
      throw new IllegalStateException("Center inside requires calling resize.");
    }
    return new Request(this.uri, this.resourceId, this.transformations, this.targetWidth, this.targetHeight, this.centerCrop, this.centerInside, this.rotationDegrees, this.rotationPivotX, this.rotationPivotY, this.hasRotationPivot, this.config, null);
  }
  
  public Builder centerCrop()
  {
    if (this.centerInside) {
      throw new IllegalStateException("Center crop can not be used after calling centerInside");
    }
    this.centerCrop = true;
    return this;
  }
  
  public Builder centerInside()
  {
    if (this.centerCrop) {
      throw new IllegalStateException("Center inside can not be used after calling centerCrop");
    }
    this.centerInside = true;
    return this;
  }
  
  public Builder clearCenterCrop()
  {
    this.centerCrop = false;
    return this;
  }
  
  public Builder clearCenterInside()
  {
    this.centerInside = false;
    return this;
  }
  
  public Builder clearResize()
  {
    this.targetWidth = 0;
    this.targetHeight = 0;
    this.centerCrop = false;
    this.centerInside = false;
    return this;
  }
  
  public Builder clearRotation()
  {
    this.rotationDegrees = 0.0F;
    this.rotationPivotX = 0.0F;
    this.rotationPivotY = 0.0F;
    this.hasRotationPivot = false;
    return this;
  }
  
  public Builder config(Bitmap.Config paramConfig)
  {
    this.config = paramConfig;
    return this;
  }
  
  boolean hasImage()
  {
    if ((this.uri != null) || (this.resourceId != 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean hasSize()
  {
    if (this.targetWidth != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Builder resize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Width must be positive number.");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Height must be positive number.");
    }
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    return this;
  }
  
  public Builder rotate(float paramFloat)
  {
    this.rotationDegrees = paramFloat;
    return this;
  }
  
  public Builder rotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.rotationDegrees = paramFloat1;
    this.rotationPivotX = paramFloat2;
    this.rotationPivotY = paramFloat3;
    this.hasRotationPivot = true;
    return this;
  }
  
  public Builder setResourceId(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Image resource ID may not be 0.");
    }
    this.resourceId = paramInt;
    this.uri = null;
    return this;
  }
  
  public Builder setUri(Uri paramUri)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Image URI may not be null.");
    }
    this.uri = paramUri;
    this.resourceId = 0;
    return this;
  }
  
  public Builder transform(Transformation paramTransformation)
  {
    if (paramTransformation == null) {
      throw new IllegalArgumentException("Transformation must not be null.");
    }
    if (this.transformations == null) {
      this.transformations = new ArrayList(2);
    }
    this.transformations.add(paramTransformation);
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Request.Builder
 * JD-Core Version:    0.7.0.1
 */