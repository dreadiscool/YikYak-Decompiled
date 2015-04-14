package com.adjust.sdk;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ActivityPackage
  implements Serializable
{
  private static final long serialVersionUID = -35935556512024097L;
  private ActivityKind activityKind;
  private String clientSdk;
  private Map<String, String> parameters;
  private String path;
  private String suffix;
  private String userAgent;
  
  public ActivityKind getActivityKind()
  {
    return this.activityKind;
  }
  
  public String getClientSdk()
  {
    return this.clientSdk;
  }
  
  public String getExtendedString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.path;
    localStringBuilder.append(String.format("Path:      %s\n", arrayOfObject1));
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = this.userAgent;
    localStringBuilder.append(String.format("UserAgent: %s\n", arrayOfObject2));
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = this.clientSdk;
    localStringBuilder.append(String.format("ClientSdk: %s\n", arrayOfObject3));
    if (this.parameters != null)
    {
      localStringBuilder.append("Parameters:");
      Iterator localIterator = this.parameters.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object[] arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = localEntry.getKey();
        arrayOfObject4[1] = localEntry.getValue();
        localStringBuilder.append(String.format("\n\t%-16s %s", arrayOfObject4));
      }
    }
    return localStringBuilder.toString();
  }
  
  protected String getFailureMessage()
  {
    try
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.activityKind.toString();
      arrayOfObject[1] = this.suffix;
      String str2 = String.format("Failed to track %s%s", arrayOfObject);
      str1 = str2;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        String str1 = "Failed to track ???";
      }
    }
    return str1;
  }
  
  public Map<String, String> getParameters()
  {
    return this.parameters;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  protected String getSuccessMessage()
  {
    try
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.activityKind.toString();
      arrayOfObject[1] = this.suffix;
      String str2 = String.format("Tracked %s%s", arrayOfObject);
      str1 = str2;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        String str1 = "Tracked ???";
      }
    }
    return str1;
  }
  
  public String getSuffix()
  {
    return this.suffix;
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public void setActivityKind(ActivityKind paramActivityKind)
  {
    this.activityKind = paramActivityKind;
  }
  
  public void setClientSdk(String paramString)
  {
    this.clientSdk = paramString;
  }
  
  public void setParameters(Map<String, String> paramMap)
  {
    this.parameters = paramMap;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSuffix(String paramString)
  {
    this.suffix = paramString;
  }
  
  public void setUserAgent(String paramString)
  {
    this.userAgent = paramString;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.activityKind.toString();
    arrayOfObject[1] = this.suffix;
    return String.format("%s%s", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityPackage
 * JD-Core Version:    0.7.0.1
 */