package com.squareup.picasso;

import android.graphics.Bitmap;
import android.widget.RemoteViews;

abstract class RemoteViewsAction
  extends Action<RemoteViewsAction.RemoteViewsTarget>
{
  final RemoteViews remoteViews;
  final int viewId;
  
  RemoteViewsAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    super(paramPicasso, new RemoteViewsAction.RemoteViewsTarget(paramRemoteViews, paramInt1), paramRequest, paramBoolean, false, paramInt2, null, paramString);
    this.remoteViews = paramRemoteViews;
    this.viewId = paramInt1;
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    this.remoteViews.setImageViewBitmap(this.viewId, paramBitmap);
    update();
  }
  
  public void error()
  {
    if (this.errorResId != 0) {
      setImageResource(this.errorResId);
    }
  }
  
  void setImageResource(int paramInt)
  {
    this.remoteViews.setImageViewResource(this.viewId, paramInt);
    update();
  }
  
  abstract void update();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction
 * JD-Core Version:    0.7.0.1
 */