package com.parse;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

class TaskStackBuilderHelper
{
  public static void startActivities(Context paramContext, Class<? extends Activity> paramClass, Intent paramIntent)
  {
    TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(paramContext);
    localTaskStackBuilder.addParentStack(paramClass);
    localTaskStackBuilder.addNextIntent(paramIntent);
    localTaskStackBuilder.startActivities();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.TaskStackBuilderHelper
 * JD-Core Version:    0.7.0.1
 */