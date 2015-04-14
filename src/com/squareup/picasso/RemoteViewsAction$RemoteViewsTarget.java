package com.squareup.picasso;

import android.widget.RemoteViews;

class RemoteViewsAction$RemoteViewsTarget
{
  final RemoteViews remoteViews;
  final int viewId;
  
  RemoteViewsAction$RemoteViewsTarget(RemoteViews paramRemoteViews, int paramInt)
  {
    this.remoteViews = paramRemoteViews;
    this.viewId = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool = false;
      }
      else
      {
        RemoteViewsTarget localRemoteViewsTarget = (RemoteViewsTarget)paramObject;
        if ((this.viewId != localRemoteViewsTarget.viewId) || (!this.remoteViews.equals(localRemoteViewsTarget.remoteViews))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return 31 * this.remoteViews.hashCode() + this.viewId;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction.RemoteViewsTarget
 * JD-Core Version:    0.7.0.1
 */