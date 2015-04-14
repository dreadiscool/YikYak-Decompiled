package com.adjust.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class ResponseData
{
  private ActivityKind activityKind = ActivityKind.UNKNOWN;
  private String adgroup;
  private String campaign;
  private String creative;
  private String error;
  private String network;
  private boolean success;
  private String trackerName;
  private String trackerToken;
  private boolean willRetry;
  
  public static ResponseData fromError(String paramString)
  {
    ResponseData localResponseData = new ResponseData();
    localResponseData.error = paramString;
    return localResponseData;
  }
  
  public static ResponseData fromJson(JSONObject paramJSONObject, String paramString)
  {
    ResponseData localResponseData;
    if (paramJSONObject == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString.trim();
      localResponseData = fromError(String.format("Failed to parse json response: %s", arrayOfObject));
    }
    for (;;)
    {
      return localResponseData;
      localResponseData = new ResponseData();
      localResponseData.error = paramJSONObject.optString("error", null);
      localResponseData.trackerToken = paramJSONObject.optString("tracker_token", null);
      localResponseData.trackerName = paramJSONObject.optString("tracker_name", null);
      localResponseData.network = paramJSONObject.optString("network", null);
      localResponseData.campaign = paramJSONObject.optString("campaign", null);
      localResponseData.adgroup = paramJSONObject.optString("adgroup", null);
      localResponseData.creative = paramJSONObject.optString("creative", null);
    }
  }
  
  public ActivityKind getActivityKind()
  {
    return this.activityKind;
  }
  
  public String getActivityKindString()
  {
    return this.activityKind.toString();
  }
  
  public String getAdgroup()
  {
    return this.adgroup;
  }
  
  public String getCampaign()
  {
    return this.campaign;
  }
  
  public String getCreative()
  {
    return this.creative;
  }
  
  public String getError()
  {
    return this.error;
  }
  
  public String getNetwork()
  {
    return this.network;
  }
  
  public String getTrackerName()
  {
    return this.trackerName;
  }
  
  public String getTrackerToken()
  {
    return this.trackerToken;
  }
  
  public void setActivityKind(ActivityKind paramActivityKind)
  {
    this.activityKind = paramActivityKind;
  }
  
  public void setWasSuccess(boolean paramBoolean)
  {
    this.success = paramBoolean;
  }
  
  public void setWillRetry(boolean paramBoolean)
  {
    this.willRetry = paramBoolean;
  }
  
  public Map<String, String> toDic()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("activityKind", this.activityKind.toString());
    String str1;
    if (this.success)
    {
      str1 = "true";
      localHashMap.put("success", str1);
      if (!this.willRetry) {
        break label235;
      }
    }
    label235:
    for (String str2 = "true";; str2 = "false")
    {
      localHashMap.put("willRetry", str2);
      if (!TextUtils.isEmpty(this.error)) {
        localHashMap.put("error", this.error);
      }
      if (!TextUtils.isEmpty(this.trackerToken)) {
        localHashMap.put("trackerToken", this.trackerToken);
      }
      if (!TextUtils.isEmpty(this.trackerName)) {
        localHashMap.put("trackerName", this.trackerName);
      }
      if (!TextUtils.isEmpty(this.network)) {
        localHashMap.put("network", this.network);
      }
      if (!TextUtils.isEmpty(this.campaign)) {
        localHashMap.put("campaign", this.campaign);
      }
      if (!TextUtils.isEmpty(this.adgroup)) {
        localHashMap.put("adgroup", this.adgroup);
      }
      if (!TextUtils.isEmpty(this.creative)) {
        localHashMap.put("creative", this.creative);
      }
      return localHashMap;
      str1 = "false";
      break;
    }
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = getActivityKindString();
    arrayOfObject[1] = Boolean.valueOf(this.success);
    arrayOfObject[2] = Boolean.valueOf(this.willRetry);
    arrayOfObject[3] = Util.quote(this.error);
    arrayOfObject[4] = this.trackerToken;
    arrayOfObject[5] = Util.quote(this.trackerName);
    arrayOfObject[6] = Util.quote(this.network);
    arrayOfObject[7] = Util.quote(this.campaign);
    arrayOfObject[8] = Util.quote(this.adgroup);
    arrayOfObject[9] = Util.quote(this.creative);
    return String.format(localLocale, "[kind:%s success:%b willRetry:%b error:%s trackerToken:%s trackerName:%s network:%s campaign:%s adgroup:%s creative:%s]", arrayOfObject);
  }
  
  public boolean wasSuccess()
  {
    return this.success;
  }
  
  public boolean willRetry()
  {
    return this.willRetry;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ResponseData
 * JD-Core Version:    0.7.0.1
 */