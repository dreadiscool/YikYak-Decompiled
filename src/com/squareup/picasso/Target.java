package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public abstract interface Target
{
  public abstract void onBitmapFailed(Drawable paramDrawable);
  
  public abstract void onBitmapLoaded(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);
  
  public abstract void onPrepareLoad(Drawable paramDrawable);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Target
 * JD-Core Version:    0.7.0.1
 */