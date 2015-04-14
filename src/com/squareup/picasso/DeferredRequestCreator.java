package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator
  implements ViewTreeObserver.OnPreDrawListener
{
  Callback callback;
  final RequestCreator creator;
  final WeakReference<ImageView> target;
  
  DeferredRequestCreator(RequestCreator paramRequestCreator, ImageView paramImageView)
  {
    this(paramRequestCreator, paramImageView, null);
  }
  
  DeferredRequestCreator(RequestCreator paramRequestCreator, ImageView paramImageView, Callback paramCallback)
  {
    this.creator = paramRequestCreator;
    this.target = new WeakReference(paramImageView);
    this.callback = paramCallback;
    paramImageView.getViewTreeObserver().addOnPreDrawListener(this);
  }
  
  void cancel()
  {
    this.callback = null;
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null) {}
    for (;;)
    {
      return;
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnPreDrawListener(this);
      }
    }
  }
  
  public boolean onPreDraw()
  {
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null) {}
    for (;;)
    {
      return true;
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        int i = localImageView.getWidth();
        int j = localImageView.getHeight();
        if ((i > 0) && (j > 0))
        {
          localViewTreeObserver.removeOnPreDrawListener(this);
          this.creator.unfit().resize(i, j).into(localImageView, this.callback);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.DeferredRequestCreator
 * JD-Core Version:    0.7.0.1
 */