package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskStackBuilder
  implements Iterable<Intent>
{
  private static final TaskStackBuilder.TaskStackBuilderImpl IMPL;
  private static final String TAG = "TaskStackBuilder";
  private final ArrayList<Intent> mIntents = new ArrayList();
  private final Context mSourceContext;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (IMPL = new TaskStackBuilder.TaskStackBuilderImplHoneycomb();; IMPL = new TaskStackBuilder.TaskStackBuilderImplBase()) {
      return;
    }
  }
  
  private TaskStackBuilder(Context paramContext)
  {
    this.mSourceContext = paramContext;
  }
  
  public static TaskStackBuilder create(Context paramContext)
  {
    return new TaskStackBuilder(paramContext);
  }
  
  public static TaskStackBuilder from(Context paramContext)
  {
    return create(paramContext);
  }
  
  public TaskStackBuilder addNextIntent(Intent paramIntent)
  {
    this.mIntents.add(paramIntent);
    return this;
  }
  
  public TaskStackBuilder addNextIntentWithParentStack(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName == null) {
      localComponentName = paramIntent.resolveActivity(this.mSourceContext.getPackageManager());
    }
    if (localComponentName != null) {
      addParentStack(localComponentName);
    }
    addNextIntent(paramIntent);
    return this;
  }
  
  public TaskStackBuilder addParentStack(Activity paramActivity)
  {
    Intent localIntent1 = null;
    if ((paramActivity instanceof TaskStackBuilder.SupportParentable)) {
      localIntent1 = ((TaskStackBuilder.SupportParentable)paramActivity).getSupportParentActivityIntent();
    }
    if (localIntent1 == null) {}
    for (Intent localIntent2 = NavUtils.getParentActivityIntent(paramActivity);; localIntent2 = localIntent1)
    {
      if (localIntent2 != null)
      {
        ComponentName localComponentName = localIntent2.getComponent();
        if (localComponentName == null) {
          localComponentName = localIntent2.resolveActivity(this.mSourceContext.getPackageManager());
        }
        addParentStack(localComponentName);
        addNextIntent(localIntent2);
      }
      return this;
    }
  }
  
  public TaskStackBuilder addParentStack(ComponentName paramComponentName)
  {
    int i = this.mIntents.size();
    try
    {
      Intent localIntent;
      for (Object localObject = NavUtils.getParentActivityIntent(this.mSourceContext, paramComponentName); localObject != null; localObject = localIntent)
      {
        this.mIntents.add(i, localObject);
        localIntent = NavUtils.getParentActivityIntent(this.mSourceContext, ((Intent)localObject).getComponent());
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new IllegalArgumentException(localNameNotFoundException);
    }
  }
  
  public TaskStackBuilder addParentStack(Class<?> paramClass)
  {
    return addParentStack(new ComponentName(this.mSourceContext, paramClass));
  }
  
  public Intent editIntentAt(int paramInt)
  {
    return (Intent)this.mIntents.get(paramInt);
  }
  
  public Intent getIntent(int paramInt)
  {
    return editIntentAt(paramInt);
  }
  
  public int getIntentCount()
  {
    return this.mIntents.size();
  }
  
  public Intent[] getIntents()
  {
    Intent[] arrayOfIntent1 = new Intent[this.mIntents.size()];
    if (arrayOfIntent1.length == 0) {}
    for (Intent[] arrayOfIntent2 = arrayOfIntent1;; arrayOfIntent2 = arrayOfIntent1)
    {
      return arrayOfIntent2;
      arrayOfIntent1[0] = new Intent((Intent)this.mIntents.get(0)).addFlags(268484608);
      for (int i = 1; i < arrayOfIntent1.length; i++) {
        arrayOfIntent1[i] = new Intent((Intent)this.mIntents.get(i));
      }
    }
  }
  
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2)
  {
    return getPendingIntent(paramInt1, paramInt2, null);
  }
  
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.mIntents.isEmpty()) {
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }
    Intent[] arrayOfIntent = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
    arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
    return IMPL.getPendingIntent(this.mSourceContext, arrayOfIntent, paramInt1, paramInt2, paramBundle);
  }
  
  public Iterator<Intent> iterator()
  {
    return this.mIntents.iterator();
  }
  
  public void startActivities()
  {
    startActivities(null);
  }
  
  public void startActivities(Bundle paramBundle)
  {
    if (this.mIntents.isEmpty()) {
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
    Intent[] arrayOfIntent = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
    arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
    if (!ContextCompat.startActivities(this.mSourceContext, arrayOfIntent, paramBundle))
    {
      Intent localIntent = new Intent(arrayOfIntent[(-1 + arrayOfIntent.length)]);
      localIntent.addFlags(268435456);
      this.mSourceContext.startActivity(localIntent);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.TaskStackBuilder
 * JD-Core Version:    0.7.0.1
 */