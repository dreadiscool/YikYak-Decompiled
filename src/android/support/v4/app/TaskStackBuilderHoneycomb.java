package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

class TaskStackBuilderHoneycomb
{
  public static PendingIntent getActivitiesPendingIntent(Context paramContext, int paramInt1, Intent[] paramArrayOfIntent, int paramInt2)
  {
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.TaskStackBuilderHoneycomb
 * JD-Core Version:    0.7.0.1
 */