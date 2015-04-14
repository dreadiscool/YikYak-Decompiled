package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class ImageViewAction
  extends Action<ImageView>
{
  Callback callback;
  
  ImageViewAction(Picasso paramPicasso, ImageView paramImageView, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Drawable paramDrawable, String paramString, Callback paramCallback)
  {
    super(paramPicasso, paramImageView, paramRequest, paramBoolean1, paramBoolean2, paramInt, paramDrawable, paramString);
    this.callback = paramCallback;
  }
  
  void cancel()
  {
    super.cancel();
    if (this.callback != null) {
      this.callback = null;
    }
  }
  
  public void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    if (paramBitmap == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this;
      throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", arrayOfObject));
    }
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null) {}
    for (;;)
    {
      return;
      Context localContext = this.picasso.context;
      boolean bool = this.picasso.indicatorsEnabled;
      PicassoDrawable.setBitmap(localImageView, localContext, paramBitmap, paramLoadedFrom, this.noFade, bool);
      if (this.callback != null) {
        this.callback.onSuccess();
      }
    }
  }
  
  public void error()
  {
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null) {}
    label66:
    for (;;)
    {
      return;
      if (this.errorResId != 0) {
        localImageView.setImageResource(this.errorResId);
      }
      for (;;)
      {
        if (this.callback == null) {
          break label66;
        }
        this.callback.onError();
        break;
        if (this.errorDrawable != null) {
          localImageView.setImageDrawable(this.errorDrawable);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ImageViewAction
 * JD-Core Version:    0.7.0.1
 */