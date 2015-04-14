package com.parse;

import com.parse.gdata.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePush
{
  private static final String TAG = "com.parse.ParsePush";
  static final String V2_PUSH_NOT_CONFIGURED = "In order to use the ParsePush.subscribe or ParsePush.unsubscribe methods you must add the following to your AndroidManifest.xml: \n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"\n  android:exported=\"false\">\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>\n(Replace \"com.parse.ParsePushBroadcastReceiver\" with your own implementation if you choose to extend ParsePushBroadcastReceiver)";
  private Set<String> channelSet = null;
  private JSONObject data;
  private Long expirationTime = null;
  private Long expirationTimeInterval = null;
  private Boolean pushToAndroid = null;
  private Boolean pushToIOS = null;
  private ParseQuery<ParseInstallation> query = null;
  
  private static void checkForManifestAndThrowExceptionIfNeeded()
  {
    if (!ManifestInfo.getPushUsesBroadcastReceivers()) {
      throw new IllegalStateException("In order to use the ParsePush.subscribe or ParsePush.unsubscribe methods you must add the following to your AndroidManifest.xml: \n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"\n  android:exported=\"false\">\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>\n(Replace \"com.parse.ParsePushBroadcastReceiver\" with your own implementation if you choose to extend ParsePushBroadcastReceiver)");
    }
  }
  
  public static m<Void> sendDataInBackground(JSONObject paramJSONObject, ParseQuery<ParseInstallation> paramParseQuery)
  {
    ParsePush localParsePush = new ParsePush();
    localParsePush.setQuery(paramParseQuery);
    localParsePush.setData(paramJSONObject);
    return localParsePush.sendInBackground();
  }
  
  public static void sendDataInBackground(JSONObject paramJSONObject, ParseQuery<ParseInstallation> paramParseQuery, SendCallback paramSendCallback)
  {
    Parse.callbackOnMainThreadAsync(sendDataInBackground(paramJSONObject, paramParseQuery), paramSendCallback);
  }
  
  public static m<Void> sendMessageInBackground(String paramString, ParseQuery<ParseInstallation> paramParseQuery)
  {
    ParsePush localParsePush = new ParsePush();
    localParsePush.setQuery(paramParseQuery);
    localParsePush.setMessage(paramString);
    return localParsePush.sendInBackground();
  }
  
  public static void sendMessageInBackground(String paramString, ParseQuery<ParseInstallation> paramParseQuery, SendCallback paramSendCallback)
  {
    Parse.callbackOnMainThreadAsync(sendMessageInBackground(paramString, paramParseQuery), paramSendCallback);
  }
  
  static void setEnabled(boolean paramBoolean)
  {
    checkForManifestAndThrowExceptionIfNeeded();
    PushRouter.setForceEnabledAsync(Boolean.valueOf(paramBoolean)).c(new ParsePush.1(paramBoolean));
  }
  
  public static m<Void> subscribeInBackground(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Can't subscribe to null channel.");
    }
    checkForManifestAndThrowExceptionIfNeeded();
    ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
    List localList = localParseInstallation.getList("channels");
    if ((localList == null) || (!localList.contains(paramString))) {
      localParseInstallation.addUnique("channels", paramString);
    }
    for (m localm = localParseInstallation.saveInBackground();; localm = m.a(null)) {
      return localm;
    }
  }
  
  public static void subscribeInBackground(String paramString, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(subscribeInBackground(paramString), paramSaveCallback);
  }
  
  public static m<Void> unsubscribeInBackground(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Can't unsubscribe from null channel.");
    }
    checkForManifestAndThrowExceptionIfNeeded();
    ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
    List localList = localParseInstallation.getList("channels");
    if ((localList != null) && (localList.contains(paramString)))
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString;
      localParseInstallation.removeAll("channels", Arrays.asList(arrayOfString));
    }
    for (m localm = localParseInstallation.saveInBackground();; localm = m.a(null)) {
      return localm;
    }
  }
  
  public static void unsubscribeInBackground(String paramString, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(unsubscribeInBackground(paramString), paramSaveCallback);
  }
  
  ParseCommand buildCommand(String paramString)
  {
    int i = 1;
    ParseCommand localParseCommand = new ParseCommand("client_push", paramString);
    if (this.data == null) {
      throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
    }
    localParseCommand.put("data", this.data);
    label89:
    int j;
    if (this.query != null)
    {
      localParseCommand.put("where", (JSONObject)Parse.encode(this.query.getConstraints(), PointerEncodingStrategy.get()));
      if (this.expirationTime == null) {
        break label196;
      }
      localParseCommand.put("expiration_time", this.expirationTime.longValue());
      if ((this.query == null) && ((this.pushToAndroid != null) || (this.pushToIOS != null)))
      {
        if ((this.pushToAndroid != null) && (!this.pushToAndroid.booleanValue())) {
          break label219;
        }
        j = i;
        label130:
        if ((this.pushToIOS == null) || (!this.pushToIOS.booleanValue())) {
          break label225;
        }
        label147:
        if ((i == 0) || (j == 0)) {
          break label230;
        }
      }
    }
    for (;;)
    {
      return localParseCommand;
      if (this.channelSet == null)
      {
        localParseCommand.put("channel", "");
        break;
      }
      localParseCommand.put("channels", new JSONArray(this.channelSet));
      break;
      label196:
      if (this.expirationTimeInterval == null) {
        break label89;
      }
      localParseCommand.put("expiration_time_interval", this.expirationTimeInterval.longValue());
      break label89;
      label219:
      j = 0;
      break label130;
      label225:
      i = 0;
      break label147;
      label230:
      if (i != 0)
      {
        localParseCommand.put("type", "ios");
      }
      else
      {
        if (j == 0) {
          break label261;
        }
        localParseCommand.put("type", "android");
      }
    }
    label261:
    throw new IllegalArgumentException("Cannot push if both pushToIOS and pushToAndroid are false");
  }
  
  public void clearExpiration()
  {
    this.expirationTime = null;
    this.expirationTimeInterval = null;
  }
  
  public void send()
  {
    Parse.waitForTask(sendInBackground());
  }
  
  public m<Void> sendInBackground()
  {
    return buildCommand(ParseUser.getCurrentSessionToken()).executeAsync().a(new ParsePush.2(this));
  }
  
  public void sendInBackground(SendCallback paramSendCallback)
  {
    Parse.callbackOnMainThreadAsync(sendInBackground(), paramSendCallback);
  }
  
  public void setChannel(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "channel cannot be null");
      this.channelSet = new HashSet();
      this.channelSet.add(paramString);
      this.query = null;
      return;
    }
  }
  
  public void setChannels(Collection<String> paramCollection)
  {
    boolean bool1;
    if (paramCollection != null)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "channels collection cannot be null");
      Iterator localIterator = paramCollection.iterator();
      label20:
      if (!localIterator.hasNext()) {
        break label66;
      }
      if ((String)localIterator.next() == null) {
        break label60;
      }
    }
    label60:
    for (boolean bool2 = true;; bool2 = false)
    {
      Preconditions.checkArgument(bool2, "channel cannot be null");
      break label20;
      bool1 = false;
      break;
    }
    label66:
    this.channelSet = new HashSet();
    this.channelSet.addAll(paramCollection);
    this.query = null;
  }
  
  public void setData(JSONObject paramJSONObject)
  {
    this.data = paramJSONObject;
  }
  
  public void setExpirationTime(long paramLong)
  {
    this.expirationTime = Long.valueOf(paramLong);
    this.expirationTimeInterval = null;
  }
  
  public void setExpirationTimeInterval(long paramLong)
  {
    this.expirationTime = null;
    this.expirationTimeInterval = Long.valueOf(paramLong);
  }
  
  public void setMessage(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("alert", paramString);
      setData(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParsePush", "JSONException in setMessage", localJSONException);
      }
    }
  }
  
  @Deprecated
  public void setPushToAndroid(boolean paramBoolean)
  {
    if (this.query == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
      this.pushToAndroid = Boolean.valueOf(paramBoolean);
      return;
    }
  }
  
  @Deprecated
  public void setPushToIOS(boolean paramBoolean)
  {
    if (this.query == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
      this.pushToIOS = Boolean.valueOf(paramBoolean);
      return;
    }
  }
  
  public void setQuery(ParseQuery<ParseInstallation> paramParseQuery)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramParseQuery != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "Cannot target a null query");
      if ((this.pushToIOS != null) || (this.pushToAndroid != null)) {
        break label70;
      }
    }
    for (;;)
    {
      Preconditions.checkArgument(bool1, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
      Preconditions.checkArgument(paramParseQuery.getClassName().equals(ParseObject.getClassName(ParseInstallation.class)), "Can only push to a query for Installations");
      this.channelSet = null;
      this.query = paramParseQuery;
      return;
      bool2 = false;
      break;
      label70:
      bool1 = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePush
 * JD-Core Version:    0.7.0.1
 */