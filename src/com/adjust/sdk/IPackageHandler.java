package com.adjust.sdk;

import org.json.JSONObject;

public abstract interface IPackageHandler
{
  public abstract void addPackage(ActivityPackage paramActivityPackage);
  
  public abstract void closeFirstPackage();
  
  public abstract boolean dropsOfflineActivities();
  
  public abstract void finishedTrackingActivity(ActivityPackage paramActivityPackage, ResponseData paramResponseData, JSONObject paramJSONObject);
  
  public abstract String getFailureMessage();
  
  public abstract void pauseSending();
  
  public abstract void resumeSending();
  
  public abstract void sendFirstPackage();
  
  public abstract void sendNextPackage();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.IPackageHandler
 * JD-Core Version:    0.7.0.1
 */