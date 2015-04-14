package com.adjust.sdk;

import android.os.HandlerThread;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

public class RequestHandler
  extends HandlerThread
  implements IRequestHandler
{
  private static final int CONNECTION_TIMEOUT = 60000;
  private static final int SOCKET_TIMEOUT = 60000;
  private HttpClient httpClient;
  private RequestHandler.InternalHandler internalHandler;
  private Logger logger;
  private IPackageHandler packageHandler;
  
  public RequestHandler(IPackageHandler paramIPackageHandler)
  {
    super("Adjust", 1);
    setDaemon(true);
    start();
    this.logger = AdjustFactory.getLogger();
    this.internalHandler = new RequestHandler.InternalHandler(getLooper(), this);
    this.packageHandler = paramIPackageHandler;
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72401;
    this.internalHandler.sendMessage(localMessage);
  }
  
  private void closePackage(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    boolean bool = true;
    String str1 = paramActivityPackage.getFailureMessage();
    String str2 = this.packageHandler.getFailureMessage();
    String str3 = getReasonString(paramString, paramThrowable);
    Logger localLogger = this.logger;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str1;
    arrayOfObject[bool] = str3;
    arrayOfObject[2] = str2;
    localLogger.error("%s. (%s) %s", arrayOfObject);
    ResponseData localResponseData = ResponseData.fromError(str3);
    if (!this.packageHandler.dropsOfflineActivities()) {}
    for (;;)
    {
      localResponseData.setWillRetry(bool);
      this.packageHandler.finishedTrackingActivity(paramActivityPackage, localResponseData, null);
      this.packageHandler.closeFirstPackage();
      return;
      bool = false;
    }
  }
  
  private String getReasonString(String paramString, Throwable paramThrowable)
  {
    Object[] arrayOfObject2;
    if (paramThrowable != null)
    {
      arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = paramThrowable;
    }
    Object[] arrayOfObject1;
    for (String str = String.format("%s: %s", arrayOfObject2);; str = String.format("%s", arrayOfObject1))
    {
      return str;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramString;
    }
  }
  
  private HttpUriRequest getRequest(ActivityPackage paramActivityPackage)
  {
    HttpPost localHttpPost = new HttpPost("https://app.adjust.io" + paramActivityPackage.getPath());
    String str = Locale.getDefault().getLanguage();
    localHttpPost.addHeader("User-Agent", paramActivityPackage.getUserAgent());
    localHttpPost.addHeader("Client-SDK", paramActivityPackage.getClientSdk());
    localHttpPost.addHeader("Accept-Language", str);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramActivityPackage.getParameters().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localArrayList.add(new BasicNameValuePair("sent_at", Util.dateFormat(System.currentTimeMillis())));
    UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList);
    localUrlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
    localHttpPost.setEntity(localUrlEncodedFormEntity);
    return localHttpPost;
  }
  
  private void initInternal()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    this.httpClient = AdjustFactory.getHttpClient(localBasicHttpParams);
  }
  
  private String parseResponse(HttpResponse paramHttpResponse)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramHttpResponse.getEntity().writeTo(localByteArrayOutputStream);
      localByteArrayOutputStream.close();
      String str2 = localByteArrayOutputStream.toString().trim();
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger localLogger = this.logger;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localException;
        localLogger.error("Failed to parse response (%s)", arrayOfObject);
        String str1 = "Failed to parse response";
      }
    }
    return str1;
  }
  
  private void requestFinished(HttpResponse paramHttpResponse, ActivityPackage paramActivityPackage)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    String str = parseResponse(paramHttpResponse);
    JSONObject localJSONObject = Util.buildJsonObject(str);
    ResponseData localResponseData = ResponseData.fromJson(localJSONObject, str);
    if (200 == i)
    {
      localResponseData.setWasSuccess(true);
      this.logger.info(paramActivityPackage.getSuccessMessage(), new Object[0]);
    }
    for (;;)
    {
      this.packageHandler.finishedTrackingActivity(paramActivityPackage, localResponseData, localJSONObject);
      this.packageHandler.sendNextPackage();
      return;
      Logger localLogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramActivityPackage.getFailureMessage();
      arrayOfObject[1] = localResponseData.getError();
      localLogger.error("%s. (%s)", arrayOfObject);
    }
  }
  
  private void sendInternal(ActivityPackage paramActivityPackage)
  {
    try
    {
      HttpUriRequest localHttpUriRequest = getRequest(paramActivityPackage);
      requestFinished(this.httpClient.execute(localHttpUriRequest), paramActivityPackage);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        sendNextPackage(paramActivityPackage, "Failed to encode parameters", localUnsupportedEncodingException);
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      for (;;)
      {
        closePackage(paramActivityPackage, "Client protocol error", localClientProtocolException);
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      for (;;)
      {
        closePackage(paramActivityPackage, "Request timed out", localSocketTimeoutException);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        closePackage(paramActivityPackage, "Request failed", localIOException);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        sendNextPackage(paramActivityPackage, "Runtime exception", localThrowable);
      }
    }
  }
  
  private void sendNextPackage(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    String str1 = paramActivityPackage.getFailureMessage();
    String str2 = getReasonString(paramString, paramThrowable);
    Logger localLogger = this.logger;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str1;
    arrayOfObject[1] = str2;
    localLogger.error("%s. (%s)", arrayOfObject);
    ResponseData localResponseData = ResponseData.fromError(str2);
    this.packageHandler.finishedTrackingActivity(paramActivityPackage, localResponseData, null);
    this.packageHandler.sendNextPackage();
  }
  
  public void sendPackage(ActivityPackage paramActivityPackage)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72400;
    localMessage.obj = paramActivityPackage;
    this.internalHandler.sendMessage(localMessage);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.RequestHandler
 * JD-Core Version:    0.7.0.1
 */