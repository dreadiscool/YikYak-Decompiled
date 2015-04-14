package com.parse;

import android.content.Context;
import android.content.Intent;
import m;

class GcmRegistrar
{
  private static final String ERROR_EXTRA = "error";
  public static final String REGISTER_ACTION = "com.google.android.c2dm.intent.REGISTER";
  public static final String REGISTER_RESPONSE_ACTION = "com.google.android.c2dm.intent.REGISTRATION";
  private static final String REGISTRATION_ID_EXTRA = "registration_id";
  private static final String SENDER_ID = "1076345567071";
  private static final String TAG = "com.parse.GcmRegistrar";
  private Context context = null;
  private Object lock = new Object();
  private GcmRegistrar.Request request = null;
  
  GcmRegistrar(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static GcmRegistrar getInstance()
  {
    return GcmRegistrar.Singleton.INSTANCE;
  }
  
  private void sendRegistrationRequest()
  {
    synchronized (this.lock)
    {
      if (this.request == null)
      {
        this.request = GcmRegistrar.Request.createAndSend(this.context, "1076345567071");
        this.request.getTask().a(new GcmRegistrar.2(this));
      }
      return;
    }
  }
  
  public static void updateAsync()
  {
    m.a(new GcmRegistrar.1());
  }
  
  int getRequestIdentifier()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.request != null)
        {
          i = GcmRegistrar.Request.access$200(this.request);
          return i;
        }
      }
      int i = 0;
    }
  }
  
  public void handleRegistrationIntent(Intent paramIntent)
  {
    if (isRegistrationIntent(paramIntent))
    {
      String str = paramIntent.getStringExtra("registration_id");
      if ((str != null) && (str.length() > 0))
      {
        ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
        localParseInstallation.setPushType(PushType.GCM);
        localParseInstallation.setDeviceToken(str);
        localParseInstallation.saveEventually();
      }
      synchronized (this.lock)
      {
        if (this.request != null) {
          this.request.onReceiveResponseIntent(paramIntent);
        }
      }
    }
  }
  
  public boolean isRegistrationIntent(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.c2dm.intent.REGISTRATION".equals(paramIntent.getAction()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void register()
  {
    if (ManifestInfo.getPushType() == PushType.GCM) {
      synchronized (this.lock)
      {
        ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
        if ((localParseInstallation.getDeviceToken() == null) || (localParseInstallation.isDeviceTokenStale()))
        {
          if (localParseInstallation.getPushType() != PushType.GCM)
          {
            localParseInstallation.setPushType(PushType.GCM);
            localParseInstallation.saveEventually();
          }
          sendRegistrationRequest();
        }
      }
    }
  }
  
  public void update()
  {
    if ((ParseInstallation.hasCurrentInstallation()) && (ManifestInfo.getPushType() == PushType.GCM)) {
      synchronized (this.lock)
      {
        ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
        if ((localParseInstallation.getPushType() == PushType.GCM) && ((localParseInstallation.getDeviceToken() == null) || (localParseInstallation.isDeviceTokenStale()))) {
          sendRegistrationRequest();
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GcmRegistrar
 * JD-Core Version:    0.7.0.1
 */