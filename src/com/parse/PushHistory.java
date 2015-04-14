package com.parse;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import org.json.JSONObject;

class PushHistory
{
  private static final String TAG = "com.parse.PushHistory";
  private String cutoff;
  private final PriorityQueue<PushHistory.Entry> entries;
  private String lastTime;
  private final int maxHistoryLength;
  private final HashSet<String> pushIds;
  
  public PushHistory(int paramInt, JSONObject paramJSONObject)
  {
    this.maxHistoryLength = paramInt;
    this.entries = new PriorityQueue(paramInt + 1);
    this.pushIds = new HashSet(paramInt + 1);
    this.cutoff = null;
    this.lastTime = null;
    if (paramJSONObject != null)
    {
      setCutoffTimestamp(paramJSONObject.optString("ignoreAfter", null));
      setLastReceivedTimestamp(paramJSONObject.optString("lastTime", null));
      JSONObject localJSONObject = paramJSONObject.optJSONObject("history");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.optString(str1, null);
          if ((str1 != null) && (str2 != null)) {
            tryInsertPush(str1, str2);
          }
        }
      }
    }
  }
  
  private void setCutoffTimestamp(String paramString)
  {
    this.cutoff = paramString;
  }
  
  private void setLastReceivedTimestamp(String paramString)
  {
    this.lastTime = paramString;
  }
  
  public String getCutoffTimestamp()
  {
    return this.cutoff;
  }
  
  public String getLastReceivedTimestamp()
  {
    return this.lastTime;
  }
  
  public Set<String> getPushIds()
  {
    return Collections.unmodifiableSet(this.pushIds);
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (this.entries.size() > 0)
    {
      JSONObject localJSONObject2 = new JSONObject();
      Iterator localIterator = this.entries.iterator();
      while (localIterator.hasNext())
      {
        PushHistory.Entry localEntry = (PushHistory.Entry)localIterator.next();
        localJSONObject2.put(localEntry.pushId, localEntry.timestamp);
      }
      localJSONObject1.put("history", localJSONObject2);
    }
    localJSONObject1.putOpt("ignoreAfter", this.cutoff);
    localJSONObject1.putOpt("lastTime", this.lastTime);
    return localJSONObject1;
  }
  
  public boolean tryInsertPush(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramString2 == null) {
      throw new IllegalArgumentException("Can't insert null pushId or timestamp into history");
    }
    if ((this.lastTime == null) || (paramString2.compareTo(this.lastTime) > 0)) {
      this.lastTime = paramString2;
    }
    if ((this.cutoff != null) && (paramString2.compareTo(this.cutoff) <= 0)) {
      Parse.logE("com.parse.PushHistory", "Ignored old push " + paramString1 + " at " + paramString2 + " before cutoff " + this.cutoff);
    }
    for (;;)
    {
      return bool;
      if (paramString1 != null)
      {
        if (this.pushIds.contains(paramString1))
        {
          Parse.logE("com.parse.PushHistory", "Ignored duplicate push " + paramString1);
        }
        else
        {
          this.entries.add(new PushHistory.Entry(paramString1, paramString2));
          this.pushIds.add(paramString1);
          while (this.entries.size() > this.maxHistoryLength)
          {
            PushHistory.Entry localEntry = (PushHistory.Entry)this.entries.remove();
            this.pushIds.remove(localEntry.pushId);
            this.cutoff = localEntry.timestamp;
          }
        }
      }
      else {
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushHistory
 * JD-Core Version:    0.7.0.1
 */