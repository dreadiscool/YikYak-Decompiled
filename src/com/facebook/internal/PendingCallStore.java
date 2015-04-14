package com.facebook.internal;

import android.os.Bundle;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class PendingCallStore
{
  private static final String CALL_ID_ARRAY_KEY = "com.facebook.internal.PendingCallStore.callIdArrayKey";
  private static final String CALL_KEY_PREFIX = "com.facebook.internal.PendingCallStore.";
  private static PendingCallStore mInstance;
  private Map<String, FacebookDialog.PendingCall> pendingCallMap = new HashMap();
  
  private static void createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new PendingCallStore();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static PendingCallStore getInstance()
  {
    if (mInstance == null) {
      createInstance();
    }
    return mInstance;
  }
  
  private String getSavedStateKeyForPendingCallId(String paramString)
  {
    return "com.facebook.internal.PendingCallStore." + paramString;
  }
  
  public FacebookDialog.PendingCall getPendingCallById(UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (FacebookDialog.PendingCall localPendingCall = null;; localPendingCall = (FacebookDialog.PendingCall)this.pendingCallMap.get(paramUUID.toString())) {
      return localPendingCall;
    }
  }
  
  public void restoreFromSavedInstanceState(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getStringArrayList("com.facebook.internal.PendingCallStore.callIdArrayKey");
    if (localArrayList != null)
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        FacebookDialog.PendingCall localPendingCall = (FacebookDialog.PendingCall)paramBundle.getParcelable(getSavedStateKeyForPendingCallId((String)localIterator.next()));
        if (localPendingCall != null) {
          this.pendingCallMap.put(localPendingCall.getCallId().toString(), localPendingCall);
        }
      }
    }
  }
  
  public void saveInstanceState(Bundle paramBundle)
  {
    paramBundle.putStringArrayList("com.facebook.internal.PendingCallStore.callIdArrayKey", new ArrayList(this.pendingCallMap.keySet()));
    Iterator localIterator = this.pendingCallMap.values().iterator();
    while (localIterator.hasNext())
    {
      FacebookDialog.PendingCall localPendingCall = (FacebookDialog.PendingCall)localIterator.next();
      paramBundle.putParcelable(getSavedStateKeyForPendingCallId(localPendingCall.getCallId().toString()), localPendingCall);
    }
  }
  
  public void stopTrackingPendingCall(UUID paramUUID)
  {
    if (paramUUID != null) {
      this.pendingCallMap.remove(paramUUID.toString());
    }
  }
  
  public void trackPendingCall(FacebookDialog.PendingCall paramPendingCall)
  {
    if (paramPendingCall != null) {
      this.pendingCallMap.put(paramPendingCall.getCallId().toString(), paramPendingCall);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.PendingCallStore
 * JD-Core Version:    0.7.0.1
 */