package com.yik.yak.ui.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class YikYakWidget
  extends AppWidgetProvider
{
  private static Context a;
  private boolean b = false;
  
  public static void a(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    a = paramContext;
    YikYakWidgetConfigureActivity.a(paramContext, paramInt);
    paramAppWidgetManager.updateAppWidget(paramInt, new RemoteViews(paramContext.getPackageName(), 2130903143));
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    a = paramContext;
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      YikYakWidgetConfigureActivity.b(paramContext, paramArrayOfInt[j]);
    }
  }
  
  public void onDisabled(Context paramContext)
  {
    a = paramContext;
  }
  
  public void onEnabled(Context paramContext)
  {
    a = paramContext;
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    a = paramContext;
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      a(paramContext, paramAppWidgetManager, paramArrayOfInt[j]);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.widget.YikYakWidget
 * JD-Core Version:    0.7.0.1
 */