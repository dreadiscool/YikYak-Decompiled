package com.adjust.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class ActivityState
  implements Serializable
{
  private static final long serialVersionUID = 9039439291143138148L;
  protected long createdAt = -1L;
  protected Boolean enabled = Boolean.valueOf(true);
  protected int eventCount = 0;
  protected long lastActivity = -1L;
  protected long lastInterval = -1L;
  protected int sessionCount = 0;
  protected long sessionLength = -1L;
  protected int subsessionCount = -1;
  protected long timeSpent = -1L;
  protected String uuid = Util.createUuid();
  
  private void injectGeneralAttributes(PackageBuilder paramPackageBuilder)
  {
    paramPackageBuilder.setSessionCount(this.sessionCount);
    paramPackageBuilder.setSubsessionCount(this.subsessionCount);
    paramPackageBuilder.setSessionLength(this.sessionLength);
    paramPackageBuilder.setTimeSpent(this.timeSpent);
    paramPackageBuilder.setCreatedAt(this.createdAt);
    paramPackageBuilder.setUuid(this.uuid);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    ObjectInputStream.GetField localGetField = paramObjectInputStream.readFields();
    this.eventCount = localGetField.get("eventCount", 0);
    this.sessionCount = localGetField.get("sessionCount", 0);
    this.subsessionCount = localGetField.get("subsessionCount", -1);
    this.sessionLength = localGetField.get("sessionLength", -1L);
    this.timeSpent = localGetField.get("timeSpent", -1L);
    this.lastActivity = localGetField.get("lastActivity", -1L);
    this.createdAt = localGetField.get("createdAt", -1L);
    this.lastInterval = localGetField.get("lastInterval", -1L);
    this.uuid = null;
    this.enabled = Boolean.valueOf(true);
    try
    {
      this.uuid = ((String)localGetField.get("uuid", null));
      this.enabled = Boolean.valueOf(localGetField.get("enabled", true));
      if (this.uuid == null)
      {
        this.uuid = Util.createUuid();
        new StringBuilder().append("migrate ").append(this.uuid).toString();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger localLogger = AdjustFactory.getLogger();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localException.getMessage();
        localLogger.debug("Unable to read new field in migration device with error (%s)", arrayOfObject);
      }
    }
  }
  
  private static String stamp(long paramLong)
  {
    Date localDate = new Date(paramLong);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(localDate.getHours());
    arrayOfObject[1] = Integer.valueOf(localDate.getMinutes());
    arrayOfObject[2] = Integer.valueOf(localDate.getSeconds());
    return String.format(localLocale, "%02d:%02d:%02d", arrayOfObject);
  }
  
  protected void injectEventAttributes(PackageBuilder paramPackageBuilder)
  {
    injectGeneralAttributes(paramPackageBuilder);
    paramPackageBuilder.setEventCount(this.eventCount);
  }
  
  protected void injectSessionAttributes(PackageBuilder paramPackageBuilder)
  {
    injectGeneralAttributes(paramPackageBuilder);
    paramPackageBuilder.setLastInterval(this.lastInterval);
  }
  
  protected void resetSessionAttributes(long paramLong)
  {
    this.subsessionCount = 1;
    this.sessionLength = 0L;
    this.timeSpent = 0L;
    this.lastActivity = paramLong;
    this.createdAt = -1L;
    this.lastInterval = -1L;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.eventCount);
    arrayOfObject[1] = Integer.valueOf(this.sessionCount);
    arrayOfObject[2] = Integer.valueOf(this.subsessionCount);
    arrayOfObject[3] = Double.valueOf(this.sessionLength / 1000.0D);
    arrayOfObject[4] = Double.valueOf(this.timeSpent / 1000.0D);
    arrayOfObject[5] = stamp(this.lastActivity);
    return String.format(localLocale, "ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityState
 * JD-Core Version:    0.7.0.1
 */