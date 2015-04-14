package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ConnectivityNotifier
  extends BroadcastReceiver
{
  static final String TAG = "com.parse.ConnectivityNotifier";
  private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
  private boolean hasRegisteredReceiver = false;
  private Set<ConnectivityNotifier.ConnectivityListener> listeners = new HashSet();
  private final Object lock = new Object();
  
  static ConnectivityNotifier getNotifier()
  {
    return singleton;
  }
  
  public void addListener(ConnectivityNotifier.ConnectivityListener paramConnectivityListener, Context paramContext)
  {
    synchronized (this.lock)
    {
      this.listeners.add(paramConnectivityListener);
      tryToRegisterForNetworkStatusNotifications();
      return;
    }
  }
  
  public boolean isConnected()
  {
    boolean bool1 = true;
    if (Parse.applicationContext == null) {
      Parse.logW("com.parse.ConnectivityNotifier", "Trying to check network connectivity without a known context. Has Parse.initialize been called from Application.onCreate? (Not Activity.onCreate)");
    }
    ConnectivityManager localConnectivityManager;
    do
    {
      return bool1;
      localConnectivityManager = (ConnectivityManager)Parse.applicationContext.getSystemService("connectivity");
    } while (localConnectivityManager == null);
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (localNetworkInfo.isConnected())) {}
    for (boolean bool2 = bool1;; bool2 = false)
    {
      bool1 = bool2;
      break;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    synchronized (this.lock)
    {
      ArrayList localArrayList = new ArrayList(this.listeners);
      Iterator localIterator = localArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ConnectivityNotifier.ConnectivityListener)localIterator.next()).networkConnectivityStatusChanged(paramIntent);
      }
    }
  }
  
  public void removeListener(ConnectivityNotifier.ConnectivityListener paramConnectivityListener)
  {
    synchronized (this.lock)
    {
      this.listeners.remove(paramConnectivityListener);
      tryToRegisterForNetworkStatusNotifications();
      return;
    }
  }
  
  public boolean tryToRegisterForNetworkStatusNotifications()
  {
    boolean bool = true;
    for (;;)
    {
      Context localContext;
      synchronized (this.lock)
      {
        if (this.hasRegisteredReceiver) {
          return bool;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ConnectivityNotifier
 * JD-Core Version:    0.7.0.1
 */