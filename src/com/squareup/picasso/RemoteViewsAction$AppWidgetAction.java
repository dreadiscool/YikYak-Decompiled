package com.squareup.picasso;

import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;

class RemoteViewsAction$AppWidgetAction
  extends RemoteViewsAction
{
  private final int[] appWidgetIds;
  
  RemoteViewsAction$AppWidgetAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int[] paramArrayOfInt, boolean paramBoolean, int paramInt2, String paramString)
  {
    super(paramPicasso, paramRequest, paramRemoteViews, paramInt1, paramInt2, paramBoolean, paramString);
    this.appWidgetIds = paramArrayOfInt;
  }
  
  void update()
  {
    AppWidgetManager.getInstance(this.picasso.context).updateAppWidget(this.appWidgetIds, this.remoteViews);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction.AppWidgetAction
 * JD-Core Version:    0.7.0.1
 */