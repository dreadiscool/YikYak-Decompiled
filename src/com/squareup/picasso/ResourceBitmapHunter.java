package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

class ResourceBitmapHunter
  extends BitmapHunter
{
  private final Context context;
  
  ResourceBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.context = paramContext;
  }
  
  private Bitmap decodeResource(Resources paramResources, int paramInt, Request paramRequest)
  {
    BitmapFactory.Options localOptions = createBitmapOptions(paramRequest);
    if (requiresInSampleSize(localOptions))
    {
      BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
      calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, localOptions);
    }
    return BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
  }
  
  Bitmap decode(Request paramRequest)
  {
    Resources localResources = Utils.getResources(this.context, paramRequest);
    return decodeResource(localResources, Utils.getResourceId(localResources, paramRequest), paramRequest);
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ResourceBitmapHunter
 * JD-Core Version:    0.7.0.1
 */