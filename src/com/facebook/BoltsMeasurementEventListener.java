package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import java.util.Iterator;
import java.util.Set;

public class BoltsMeasurementEventListener
  extends BroadcastReceiver
{
  private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
  private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
  private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
  private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
  private static BoltsMeasurementEventListener _instance;
  private Context applicationContext;
  
  private BoltsMeasurementEventListener(Context paramContext)
  {
    this.applicationContext = paramContext.getApplicationContext();
  }
  
  private void close()
  {
    LocalBroadcastManager.getInstance(this.applicationContext).unregisterReceiver(this);
  }
  
  static BoltsMeasurementEventListener getInstance(Context paramContext)
  {
    if (_instance != null) {}
    for (BoltsMeasurementEventListener localBoltsMeasurementEventListener = _instance;; localBoltsMeasurementEventListener = _instance)
    {
      return localBoltsMeasurementEventListener;
      _instance = new BoltsMeasurementEventListener(paramContext);
      _instance.open();
    }
  }
  
  private void open()
  {
    LocalBroadcastManager.getInstance(this.applicationContext).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
  }
  
  protected void finalize()
  {
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(paramContext);
    String str1 = "bf_" + paramIntent.getStringExtra("event_name");
    Bundle localBundle1 = paramIntent.getBundleExtra("event_args");
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = localBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      localBundle2.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)localBundle1.get(str2));
    }
    localAppEventsLogger.logEvent(str1, localBundle2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.BoltsMeasurementEventListener
 * JD-Core Version:    0.7.0.1
 */