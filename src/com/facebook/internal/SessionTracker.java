package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;

public class SessionTracker
{
  private final LocalBroadcastManager broadcastManager;
  private final Session.StatusCallback callback;
  private boolean isTracking = false;
  private final BroadcastReceiver receiver;
  private Session session;
  
  public SessionTracker(Context paramContext, Session.StatusCallback paramStatusCallback)
  {
    this(paramContext, paramStatusCallback, null);
  }
  
  SessionTracker(Context paramContext, Session.StatusCallback paramStatusCallback, Session paramSession)
  {
    this(paramContext, paramStatusCallback, paramSession, true);
  }
  
  public SessionTracker(Context paramContext, Session.StatusCallback paramStatusCallback, Session paramSession, boolean paramBoolean)
  {
    this.callback = new SessionTracker.CallbackWrapper(this, paramStatusCallback);
    this.session = paramSession;
    this.receiver = new SessionTracker.ActiveSessionBroadcastReceiver(this, null);
    this.broadcastManager = LocalBroadcastManager.getInstance(paramContext);
    if (paramBoolean) {
      startTracking();
    }
  }
  
  private void addBroadcastReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
    this.broadcastManager.registerReceiver(this.receiver, localIntentFilter);
  }
  
  public Session getOpenSession()
  {
    Session localSession = getSession();
    if ((localSession != null) && (localSession.isOpened())) {}
    for (;;)
    {
      return localSession;
      localSession = null;
    }
  }
  
  public Session getSession()
  {
    if (this.session == null) {}
    for (Session localSession = Session.getActiveSession();; localSession = this.session) {
      return localSession;
    }
  }
  
  public boolean isTracking()
  {
    return this.isTracking;
  }
  
  public boolean isTrackingActiveSession()
  {
    if (this.session == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setSession(Session paramSession)
  {
    if (paramSession == null)
    {
      if (this.session != null)
      {
        this.session.removeCallback(this.callback);
        this.session = null;
        addBroadcastReceiver();
        if (getSession() != null) {
          getSession().addCallback(this.callback);
        }
      }
      return;
    }
    if (this.session == null)
    {
      Session localSession = Session.getActiveSession();
      if (localSession != null) {
        localSession.removeCallback(this.callback);
      }
      this.broadcastManager.unregisterReceiver(this.receiver);
    }
    for (;;)
    {
      this.session = paramSession;
      this.session.addCallback(this.callback);
      break;
      this.session.removeCallback(this.callback);
    }
  }
  
  public void startTracking()
  {
    if (this.isTracking) {}
    for (;;)
    {
      return;
      if (this.session == null) {
        addBroadcastReceiver();
      }
      if (getSession() != null) {
        getSession().addCallback(this.callback);
      }
      this.isTracking = true;
    }
  }
  
  public void stopTracking()
  {
    if (!this.isTracking) {}
    for (;;)
    {
      return;
      Session localSession = getSession();
      if (localSession != null) {
        localSession.removeCallback(this.callback);
      }
      this.broadcastManager.unregisterReceiver(this.receiver);
      this.isTracking = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.SessionTracker
 * JD-Core Version:    0.7.0.1
 */