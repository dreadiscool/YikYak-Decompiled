package com.squareup.picasso;

import android.graphics.Bitmap;

public abstract interface Transformation
{
  public abstract String key();
  
  public abstract Bitmap transform(Bitmap paramBitmap);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Transformation
 * JD-Core Version:    0.7.0.1
 */