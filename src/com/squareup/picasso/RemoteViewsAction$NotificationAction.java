package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.widget.RemoteViews;

class RemoteViewsAction$NotificationAction
  extends RemoteViewsAction
{
  private final Notification notification;
  private final int notificationId;
  
  RemoteViewsAction$NotificationAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int paramInt2, Notification paramNotification, boolean paramBoolean, int paramInt3, String paramString)
  {
    super(paramPicasso, paramRequest, paramRemoteViews, paramInt1, paramInt3, paramBoolean, paramString);
    this.notificationId = paramInt2;
    this.notification = paramNotification;
  }
  
  void update()
  {
    ((NotificationManager)Utils.getService(this.picasso.context, "notification")).notify(this.notificationId, this.notification);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction.NotificationAction
 * JD-Core Version:    0.7.0.1
 */