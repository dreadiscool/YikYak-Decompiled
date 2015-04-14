package com.facebook;

import android.os.Bundle;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

class AppEventsLogger$SessionEventsState
{
  public static final String ENCODED_EVENTS_KEY = "encoded_events";
  public static final String EVENT_COUNT_KEY = "event_count";
  public static final String NUM_SKIPPED_KEY = "num_skipped";
  private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
  private List<AppEventsLogger.AppEvent> accumulatedEvents = new ArrayList();
  private String anonymousAppDeviceGUID;
  private AttributionIdentifiers attributionIdentifiers;
  private List<AppEventsLogger.AppEvent> inFlightEvents = new ArrayList();
  private int numSkippedEventsDueToFullBuffer;
  private String packageName;
  
  public AppEventsLogger$SessionEventsState(AttributionIdentifiers paramAttributionIdentifiers, String paramString1, String paramString2)
  {
    this.attributionIdentifiers = paramAttributionIdentifiers;
    this.packageName = paramString1;
    this.anonymousAppDeviceGUID = paramString2;
  }
  
  private byte[] getStringAsByteArray(String paramString)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      localObject = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Utility.logd("Encoding exception: ", localUnsupportedEncodingException);
      }
    }
    return localObject;
  }
  
  private void populateRequest(Request paramRequest, int paramInt, JSONArray paramJSONArray, boolean paramBoolean)
  {
    GraphObject localGraphObject = GraphObject.Factory.create();
    localGraphObject.setProperty("event", "CUSTOM_APP_EVENTS");
    if (this.numSkippedEventsDueToFullBuffer > 0) {
      localGraphObject.setProperty("num_skipped_events", Integer.valueOf(paramInt));
    }
    Utility.setAppEventAttributionParameters(localGraphObject, this.attributionIdentifiers, this.anonymousAppDeviceGUID, paramBoolean);
    try
    {
      Utility.setAppEventExtendedDeviceInfoParameters(localGraphObject, AppEventsLogger.access$1000());
      label59:
      localGraphObject.setProperty("application_package_name", this.packageName);
      paramRequest.setGraphObject(localGraphObject);
      Bundle localBundle = paramRequest.getParameters();
      if (localBundle == null) {
        localBundle = new Bundle();
      }
      String str = paramJSONArray.toString();
      if (str != null)
      {
        localBundle.putByteArray("custom_events_file", getStringAsByteArray(str));
        paramRequest.setTag(str);
      }
      paramRequest.setParameters(localBundle);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public void accumulatePersistedEvents(List<AppEventsLogger.AppEvent> paramList)
  {
    try
    {
      this.accumulatedEvents.addAll(paramList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void addEvent(AppEventsLogger.AppEvent paramAppEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/facebook/AppEventsLogger$SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   6: invokeinterface 159 1 0
    //   11: aload_0
    //   12: getfield 37	com/facebook/AppEventsLogger$SessionEventsState:inFlightEvents	Ljava/util/List;
    //   15: invokeinterface 159 1 0
    //   20: iadd
    //   21: sipush 1000
    //   24: if_icmplt +16 -> 40
    //   27: aload_0
    //   28: iconst_1
    //   29: aload_0
    //   30: getfield 86	com/facebook/AppEventsLogger$SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   33: iadd
    //   34: putfield 86	com/facebook/AppEventsLogger$SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: getfield 35	com/facebook/AppEventsLogger$SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   44: aload_1
    //   45: invokeinterface 163 2 0
    //   50: pop
    //   51: goto -14 -> 37
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	SessionEventsState
    //   0	59	1	paramAppEvent	AppEventsLogger.AppEvent
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	54	finally
    //   40	51	54	finally
  }
  
  public void clearInFlightAndStats(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.accumulatedEvents.addAll(this.inFlightEvents);
      this.inFlightEvents.clear();
      this.numSkippedEventsDueToFullBuffer = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getAccumulatedEventCount()
  {
    try
    {
      int i = this.accumulatedEvents.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<AppEventsLogger.AppEvent> getEventsToPersist()
  {
    try
    {
      List localList = this.accumulatedEvents;
      this.accumulatedEvents = new ArrayList();
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int populateRequest(Request paramRequest, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/facebook/AppEventsLogger$SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   6: istore 5
    //   8: aload_0
    //   9: getfield 37	com/facebook/AppEventsLogger$SessionEventsState:inFlightEvents	Ljava/util/List;
    //   12: aload_0
    //   13: getfield 35	com/facebook/AppEventsLogger$SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   16: invokeinterface 153 2 0
    //   21: pop
    //   22: aload_0
    //   23: getfield 35	com/facebook/AppEventsLogger$SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   26: invokeinterface 168 1 0
    //   31: new 125	org/json/JSONArray
    //   34: dup
    //   35: invokespecial 173	org/json/JSONArray:<init>	()V
    //   38: astore 7
    //   40: aload_0
    //   41: getfield 37	com/facebook/AppEventsLogger$SessionEventsState:inFlightEvents	Ljava/util/List;
    //   44: invokeinterface 177 1 0
    //   49: astore 8
    //   51: aload 8
    //   53: invokeinterface 183 1 0
    //   58: ifeq +48 -> 106
    //   61: aload 8
    //   63: invokeinterface 187 1 0
    //   68: checkcast 189	com/facebook/AppEventsLogger$AppEvent
    //   71: astore 10
    //   73: iload_2
    //   74: ifne +11 -> 85
    //   77: aload 10
    //   79: invokevirtual 192	com/facebook/AppEventsLogger$AppEvent:getIsImplicit	()Z
    //   82: ifne -31 -> 51
    //   85: aload 7
    //   87: aload 10
    //   89: invokevirtual 196	com/facebook/AppEventsLogger$AppEvent:getJSONObject	()Lorg/json/JSONObject;
    //   92: invokevirtual 200	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   95: pop
    //   96: goto -45 -> 51
    //   99: astore 4
    //   101: aload_0
    //   102: monitorexit
    //   103: aload 4
    //   105: athrow
    //   106: aload 7
    //   108: invokevirtual 203	org/json/JSONArray:length	()I
    //   111: ifne +11 -> 122
    //   114: iconst_0
    //   115: istore 9
    //   117: aload_0
    //   118: monitorexit
    //   119: goto +22 -> 141
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_0
    //   125: aload_1
    //   126: iload 5
    //   128: aload 7
    //   130: iload_3
    //   131: invokespecial 205	com/facebook/AppEventsLogger$SessionEventsState:populateRequest	(Lcom/facebook/Request;ILorg/json/JSONArray;Z)V
    //   134: aload 7
    //   136: invokevirtual 203	org/json/JSONArray:length	()I
    //   139: istore 9
    //   141: iload 9
    //   143: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	SessionEventsState
    //   0	144	1	paramRequest	Request
    //   0	144	2	paramBoolean1	boolean
    //   0	144	3	paramBoolean2	boolean
    //   99	5	4	localObject	Object
    //   6	121	5	i	int
    //   38	97	7	localJSONArray	JSONArray
    //   49	13	8	localIterator	java.util.Iterator
    //   115	27	9	j	int
    //   71	17	10	localAppEvent	AppEventsLogger.AppEvent
    // Exception table:
    //   from	to	target	type
    //   2	103	99	finally
    //   106	124	99	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.SessionEventsState
 * JD-Core Version:    0.7.0.1
 */