package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import com.facebook.model.OpenGraphObject.Factory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request
{
  private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
  private static final String ACCESS_TOKEN_PARAM = "access_token";
  private static final String ATTACHED_FILES_PARAM = "attached_files";
  private static final String ATTACHMENT_FILENAME_PREFIX = "file";
  private static final String BATCH_APP_ID_PARAM = "batch_app_id";
  private static final String BATCH_BODY_PARAM = "body";
  private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
  private static final String BATCH_ENTRY_NAME_PARAM = "name";
  private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
  private static final String BATCH_METHOD_PARAM = "method";
  private static final String BATCH_PARAM = "batch";
  private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
  private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String FORMAT_JSON = "json";
  private static final String FORMAT_PARAM = "format";
  private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
  public static final int MAXIMUM_BATCH_SIZE = 50;
  private static final String ME = "me";
  private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
  private static final String MY_ACTION_FORMAT = "me/%s";
  private static final String MY_FEED = "me/feed";
  private static final String MY_FRIENDS = "me/friends";
  private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
  private static final String MY_PHOTOS = "me/photos";
  private static final String MY_STAGING_RESOURCES = "me/staging_resources";
  private static final String MY_VIDEOS = "me/videos";
  private static final String OBJECT_PARAM = "object";
  private static final String PICTURE_PARAM = "picture";
  private static final String SDK_ANDROID = "android";
  private static final String SDK_PARAM = "sdk";
  private static final String SEARCH = "search";
  private static final String STAGING_PARAM = "file";
  public static final String TAG = Request.class.getSimpleName();
  private static final String USER_AGENT_BASE = "FBAndroidSDK";
  private static final String USER_AGENT_HEADER = "User-Agent";
  private static final String VIDEOS_SUFFIX = "/videos";
  private static String defaultBatchApplicationId;
  private static volatile String userAgent;
  private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
  private String batchEntryDependsOn;
  private String batchEntryName;
  private boolean batchEntryOmitResultOnSuccess = true;
  private Request.Callback callback;
  private GraphObject graphObject;
  private String graphPath;
  private HttpMethod httpMethod;
  private String overriddenURL;
  private Bundle parameters;
  private Session session;
  private boolean skipClientToken = false;
  private Object tag;
  private String version;
  
  public Request()
  {
    this(null, null, null, null, null);
  }
  
  public Request(Session paramSession, String paramString)
  {
    this(paramSession, paramString, null, null, null);
  }
  
  public Request(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod)
  {
    this(paramSession, paramString, paramBundle, paramHttpMethod, null);
  }
  
  public Request(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, Request.Callback paramCallback)
  {
    this(paramSession, paramString, paramBundle, paramHttpMethod, paramCallback, null);
  }
  
  public Request(Session paramSession, String paramString1, Bundle paramBundle, HttpMethod paramHttpMethod, Request.Callback paramCallback, String paramString2)
  {
    this.session = paramSession;
    this.graphPath = paramString1;
    this.callback = paramCallback;
    this.version = paramString2;
    setHttpMethod(paramHttpMethod);
    if (paramBundle != null) {}
    for (this.parameters = new Bundle(paramBundle);; this.parameters = new Bundle())
    {
      if (this.version == null) {
        this.version = ServerProtocol.getAPIVersion();
      }
      return;
    }
  }
  
  Request(Session paramSession, URL paramURL)
  {
    this.session = paramSession;
    this.overriddenURL = paramURL.toString();
    setHttpMethod(HttpMethod.GET);
    this.parameters = new Bundle();
  }
  
  private void addCommonParameters()
  {
    if (this.session != null)
    {
      if (!this.session.isOpened()) {
        throw new FacebookException("Session provided to a Request in un-opened state.");
      }
      if (!this.parameters.containsKey("access_token"))
      {
        String str4 = this.session.getAccessToken();
        Logger.registerAccessToken(str4);
        this.parameters.putString("access_token", str4);
      }
    }
    for (;;)
    {
      this.parameters.putString("sdk", "android");
      this.parameters.putString("format", "json");
      return;
      if ((!this.skipClientToken) && (!this.parameters.containsKey("access_token")))
      {
        String str1 = Settings.getApplicationId();
        String str2 = Settings.getClientToken();
        if ((!Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2)))
        {
          String str3 = str1 + "|" + str2;
          this.parameters.putString("access_token", str3);
        }
      }
    }
  }
  
  private String appendParametersToBaseUrl(String paramString)
  {
    Uri.Builder localBuilder = new Uri.Builder().encodedPath(paramString);
    Iterator localIterator = this.parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = this.parameters.get(str);
      if (localObject == null) {
        localObject = "";
      }
      if (isSupportedParameterType(localObject))
      {
        localBuilder.appendQueryParameter(str, parameterToString(localObject).toString());
      }
      else if (this.httpMethod == HttpMethod.GET)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localObject.getClass().getSimpleName();
        throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", arrayOfObject));
      }
    }
    return localBuilder.toString();
  }
  
  private static HttpURLConnection createConnection(URL paramURL)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setRequestProperty("User-Agent", getUserAgent());
    localHttpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
    localHttpURLConnection.setChunkedStreamingMode(0);
    return localHttpURLConnection;
  }
  
  public static Response executeAndWait(Request paramRequest)
  {
    Request[] arrayOfRequest = new Request[1];
    arrayOfRequest[0] = paramRequest;
    List localList = executeBatchAndWait(arrayOfRequest);
    if ((localList == null) || (localList.size() != 1)) {
      throw new FacebookException("invalid state: expected a single response");
    }
    return (Response)localList.get(0);
  }
  
  public static List<Response> executeBatchAndWait(RequestBatch paramRequestBatch)
  {
    Validate.notEmptyAndContainsNoNulls(paramRequestBatch, "requests");
    try
    {
      HttpURLConnection localHttpURLConnection = toHttpConnection(paramRequestBatch);
      localList = executeConnectionAndWait(localHttpURLConnection, paramRequestBatch);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        List localList = Response.constructErrorResponses(paramRequestBatch.getRequests(), null, new FacebookException(localException));
        runCallbacks(paramRequestBatch, localList);
      }
    }
    return localList;
  }
  
  public static List<Response> executeBatchAndWait(Collection<Request> paramCollection)
  {
    return executeBatchAndWait(new RequestBatch(paramCollection));
  }
  
  public static List<Response> executeBatchAndWait(Request... paramVarArgs)
  {
    Validate.notNull(paramVarArgs, "requests");
    return executeBatchAndWait(Arrays.asList(paramVarArgs));
  }
  
  public static RequestAsyncTask executeBatchAsync(RequestBatch paramRequestBatch)
  {
    Validate.notEmptyAndContainsNoNulls(paramRequestBatch, "requests");
    RequestAsyncTask localRequestAsyncTask = new RequestAsyncTask(paramRequestBatch);
    localRequestAsyncTask.executeOnSettingsExecutor();
    return localRequestAsyncTask;
  }
  
  public static RequestAsyncTask executeBatchAsync(Collection<Request> paramCollection)
  {
    return executeBatchAsync(new RequestBatch(paramCollection));
  }
  
  public static RequestAsyncTask executeBatchAsync(Request... paramVarArgs)
  {
    Validate.notNull(paramVarArgs, "requests");
    return executeBatchAsync(Arrays.asList(paramVarArgs));
  }
  
  public static List<Response> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    List localList = Response.fromHttpConnection(paramHttpURLConnection, paramRequestBatch);
    Utility.disconnectQuietly(paramHttpURLConnection);
    int i = paramRequestBatch.size();
    if (i != localList.size())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(localList.size());
      arrayOfObject[1] = Integer.valueOf(i);
      throw new FacebookException(String.format("Received %d responses while expecting %d", arrayOfObject));
    }
    runCallbacks(paramRequestBatch, localList);
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramRequestBatch.iterator();
    while (localIterator1.hasNext())
    {
      Request localRequest = (Request)localIterator1.next();
      if (localRequest.session != null) {
        localHashSet.add(localRequest.session);
      }
    }
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext()) {
      ((Session)localIterator2.next()).extendAccessTokenIfNeeded();
    }
    return localList;
  }
  
  public static List<Response> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection<Request> paramCollection)
  {
    return executeConnectionAndWait(paramHttpURLConnection, new RequestBatch(paramCollection));
  }
  
  public static RequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    Validate.notNull(paramHttpURLConnection, "connection");
    RequestAsyncTask localRequestAsyncTask = new RequestAsyncTask(paramHttpURLConnection, paramRequestBatch);
    paramRequestBatch.setCallbackHandler(paramHandler);
    localRequestAsyncTask.executeOnSettingsExecutor();
    return localRequestAsyncTask;
  }
  
  public static RequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    return executeConnectionAsync(null, paramHttpURLConnection, paramRequestBatch);
  }
  
  @Deprecated
  public static RequestAsyncTask executeGraphPathRequestAsync(Session paramSession, String paramString, Request.Callback paramCallback)
  {
    return newGraphPathRequest(paramSession, paramString, paramCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executeMeRequestAsync(Session paramSession, Request.GraphUserCallback paramGraphUserCallback)
  {
    return newMeRequest(paramSession, paramGraphUserCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executeMyFriendsRequestAsync(Session paramSession, Request.GraphUserListCallback paramGraphUserListCallback)
  {
    return newMyFriendsRequest(paramSession, paramGraphUserListCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executePlacesSearchRequestAsync(Session paramSession, Location paramLocation, int paramInt1, int paramInt2, String paramString, Request.GraphPlaceListCallback paramGraphPlaceListCallback)
  {
    return newPlacesSearchRequest(paramSession, paramLocation, paramInt1, paramInt2, paramString, paramGraphPlaceListCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executePostRequestAsync(Session paramSession, String paramString, GraphObject paramGraphObject, Request.Callback paramCallback)
  {
    return newPostRequest(paramSession, paramString, paramGraphObject, paramCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executeStatusUpdateRequestAsync(Session paramSession, String paramString, Request.Callback paramCallback)
  {
    return newStatusUpdateRequest(paramSession, paramString, paramCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executeUploadPhotoRequestAsync(Session paramSession, Bitmap paramBitmap, Request.Callback paramCallback)
  {
    return newUploadPhotoRequest(paramSession, paramBitmap, paramCallback).executeAsync();
  }
  
  @Deprecated
  public static RequestAsyncTask executeUploadPhotoRequestAsync(Session paramSession, File paramFile, Request.Callback paramCallback)
  {
    return newUploadPhotoRequest(paramSession, paramFile, paramCallback).executeAsync();
  }
  
  private static String getBatchAppId(RequestBatch paramRequestBatch)
  {
    String str;
    if (!Utility.isNullOrEmpty(paramRequestBatch.getBatchApplicationId())) {
      str = paramRequestBatch.getBatchApplicationId();
    }
    for (;;)
    {
      return str;
      Iterator localIterator = paramRequestBatch.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Session localSession = ((Request)localIterator.next()).session;
          if (localSession != null)
          {
            str = localSession.getApplicationId();
            break;
          }
        }
      }
      str = defaultBatchApplicationId;
    }
  }
  
  public static final String getDefaultBatchApplicationId()
  {
    return defaultBatchApplicationId;
  }
  
  private String getGraphPathWithVersion()
  {
    if (versionPattern.matcher(this.graphPath).matches()) {}
    Object[] arrayOfObject;
    for (String str = this.graphPath;; str = String.format("%s/%s", arrayOfObject))
    {
      return str;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = this.version;
      arrayOfObject[1] = this.graphPath;
    }
  }
  
  private static String getMimeContentType()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    return String.format("multipart/form-data; boundary=%s", arrayOfObject);
  }
  
  private static String getUserAgent()
  {
    if (userAgent == null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "FBAndroidSDK";
      arrayOfObject[1] = "3.23.1";
      userAgent = String.format("%s.%s", arrayOfObject);
    }
    return userAgent;
  }
  
  private static boolean hasOnProgressCallbacks(RequestBatch paramRequestBatch)
  {
    Iterator localIterator1 = paramRequestBatch.getCallbacks().iterator();
    boolean bool;
    while (localIterator1.hasNext()) {
      if (((RequestBatch.Callback)localIterator1.next() instanceof RequestBatch.OnProgressCallback)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      Iterator localIterator2 = paramRequestBatch.iterator();
      for (;;)
      {
        if (localIterator2.hasNext()) {
          if ((((Request)localIterator2.next()).getCallback() instanceof Request.OnProgressCallback))
          {
            bool = true;
            break;
          }
        }
      }
      bool = false;
    }
  }
  
  private static boolean isGzipCompressible(RequestBatch paramRequestBatch)
  {
    Request localRequest;
    String str;
    do
    {
      Iterator localIterator1 = paramRequestBatch.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localRequest = (Request)localIterator1.next();
        localIterator2 = localRequest.parameters.keySet().iterator();
      }
      str = (String)localIterator2.next();
    } while (!isSupportedAttachmentType(localRequest.parameters.get(str)));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static boolean isMeRequest(String paramString)
  {
    int i = 1;
    Matcher localMatcher = versionPattern.matcher(paramString);
    if (localMatcher.matches()) {
      paramString = localMatcher.group(i);
    }
    if ((paramString.startsWith("me/")) || (paramString.startsWith("/me/"))) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  private static boolean isSupportedAttachmentType(Object paramObject)
  {
    if (((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof ParcelFileDescriptor)) || ((paramObject instanceof Request.ParcelFileDescriptorWithMimeType))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isSupportedParameterType(Object paramObject)
  {
    if (((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static Request newCustomAudienceThirdPartyIdRequest(Session paramSession, Context paramContext, Request.Callback paramCallback)
  {
    return newCustomAudienceThirdPartyIdRequest(paramSession, paramContext, null, paramCallback);
  }
  
  public static Request newCustomAudienceThirdPartyIdRequest(Session paramSession, Context paramContext, String paramString, Request.Callback paramCallback)
  {
    if (paramSession == null) {}
    for (Session localSession = Session.getActiveSession();; localSession = paramSession)
    {
      if ((localSession != null) && (!localSession.isOpened())) {
        localSession = null;
      }
      if (paramString == null) {
        if (localSession == null) {
          break label55;
        }
      }
      label55:
      for (paramString = localSession.getApplicationId(); paramString == null; paramString = Utility.getMetadataApplicationId(paramContext)) {
        throw new FacebookException("Facebook App ID cannot be determined");
      }
      String str1 = paramString + "/custom_audience_third_party_id";
      AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
      Bundle localBundle = new Bundle();
      if (localSession == null) {
        if (localAttributionIdentifiers.getAttributionId() == null) {
          break label182;
        }
      }
      label182:
      for (String str2 = localAttributionIdentifiers.getAttributionId();; str2 = localAttributionIdentifiers.getAndroidAdvertiserId())
      {
        if (localAttributionIdentifiers.getAttributionId() != null) {
          localBundle.putString("udid", str2);
        }
        if ((Settings.getLimitEventAndDataUsage(paramContext)) || (localAttributionIdentifiers.isTrackingLimited())) {
          localBundle.putString("limit_event_usage", "1");
        }
        return new Request(localSession, str1, localBundle, HttpMethod.GET, paramCallback);
      }
    }
  }
  
  public static Request newDeleteObjectRequest(Session paramSession, String paramString, Request.Callback paramCallback)
  {
    return new Request(paramSession, paramString, null, HttpMethod.DELETE, paramCallback);
  }
  
  public static Request newGraphPathRequest(Session paramSession, String paramString, Request.Callback paramCallback)
  {
    return new Request(paramSession, paramString, null, null, paramCallback);
  }
  
  public static Request newMeRequest(Session paramSession, Request.GraphUserCallback paramGraphUserCallback)
  {
    return new Request(paramSession, "me", null, null, new Request.1(paramGraphUserCallback));
  }
  
  public static Request newMyFriendsRequest(Session paramSession, Request.GraphUserListCallback paramGraphUserListCallback)
  {
    return new Request(paramSession, "me/friends", null, null, new Request.2(paramGraphUserListCallback));
  }
  
  public static Request newPlacesSearchRequest(Session paramSession, Location paramLocation, int paramInt1, int paramInt2, String paramString, Request.GraphPlaceListCallback paramGraphPlaceListCallback)
  {
    if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString))) {
      throw new FacebookException("Either location or searchText must be specified.");
    }
    Bundle localBundle = new Bundle(5);
    localBundle.putString("type", "place");
    localBundle.putInt("limit", paramInt2);
    if (paramLocation != null)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(paramLocation.getLatitude());
      arrayOfObject[1] = Double.valueOf(paramLocation.getLongitude());
      localBundle.putString("center", String.format(localLocale, "%f,%f", arrayOfObject));
      localBundle.putInt("distance", paramInt1);
    }
    if (!Utility.isNullOrEmpty(paramString)) {
      localBundle.putString("q", paramString);
    }
    Request.3 local3 = new Request.3(paramGraphPlaceListCallback);
    return new Request(paramSession, "search", localBundle, HttpMethod.GET, local3);
  }
  
  public static Request newPostOpenGraphActionRequest(Session paramSession, OpenGraphAction paramOpenGraphAction, Request.Callback paramCallback)
  {
    if (paramOpenGraphAction == null) {
      throw new FacebookException("openGraphAction cannot be null");
    }
    if (Utility.isNullOrEmpty(paramOpenGraphAction.getType())) {
      throw new FacebookException("openGraphAction must have non-null 'type' property");
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramOpenGraphAction.getType();
    return newPostRequest(paramSession, String.format("me/%s", arrayOfObject), paramOpenGraphAction, paramCallback);
  }
  
  public static Request newPostOpenGraphObjectRequest(Session paramSession, OpenGraphObject paramOpenGraphObject, Request.Callback paramCallback)
  {
    if (paramOpenGraphObject == null) {
      throw new FacebookException("openGraphObject cannot be null");
    }
    if (Utility.isNullOrEmpty(paramOpenGraphObject.getType())) {
      throw new FacebookException("openGraphObject must have non-null 'type' property");
    }
    if (Utility.isNullOrEmpty(paramOpenGraphObject.getTitle())) {
      throw new FacebookException("openGraphObject must have non-null 'title' property");
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramOpenGraphObject.getType();
    String str = String.format("me/objects/%s", arrayOfObject);
    Bundle localBundle = new Bundle();
    localBundle.putString("object", paramOpenGraphObject.getInnerJSONObject().toString());
    return new Request(paramSession, str, localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newPostOpenGraphObjectRequest(Session paramSession, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, GraphObject paramGraphObject, Request.Callback paramCallback)
  {
    OpenGraphObject localOpenGraphObject = OpenGraphObject.Factory.createForPost(OpenGraphObject.class, paramString1, paramString2, paramString3, paramString4, paramString5);
    if (paramGraphObject != null) {
      localOpenGraphObject.setData(paramGraphObject);
    }
    return newPostOpenGraphObjectRequest(paramSession, localOpenGraphObject, paramCallback);
  }
  
  public static Request newPostRequest(Session paramSession, String paramString, GraphObject paramGraphObject, Request.Callback paramCallback)
  {
    Request localRequest = new Request(paramSession, paramString, null, HttpMethod.POST, paramCallback);
    localRequest.setGraphObject(paramGraphObject);
    return localRequest;
  }
  
  public static Request newStatusUpdateRequest(Session paramSession, String paramString, Request.Callback paramCallback)
  {
    return newStatusUpdateRequest(paramSession, paramString, (String)null, null, paramCallback);
  }
  
  public static Request newStatusUpdateRequest(Session paramSession, String paramString, GraphPlace paramGraphPlace, List<GraphUser> paramList, Request.Callback paramCallback)
  {
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GraphUser)localIterator.next()).getId());
      }
    }
    ArrayList localArrayList = null;
    if (paramGraphPlace == null) {}
    for (String str = null;; str = paramGraphPlace.getId()) {
      return newStatusUpdateRequest(paramSession, paramString, str, localArrayList, paramCallback);
    }
  }
  
  private static Request newStatusUpdateRequest(Session paramSession, String paramString1, String paramString2, List<String> paramList, Request.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString1);
    if (paramString2 != null) {
      localBundle.putString("place", paramString2);
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      localBundle.putString("tags", TextUtils.join(",", paramList));
    }
    return new Request(paramSession, "me/feed", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newUpdateOpenGraphObjectRequest(Session paramSession, OpenGraphObject paramOpenGraphObject, Request.Callback paramCallback)
  {
    if (paramOpenGraphObject == null) {
      throw new FacebookException("openGraphObject cannot be null");
    }
    String str = paramOpenGraphObject.getId();
    if (str == null) {
      throw new FacebookException("openGraphObject must have an id");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("object", paramOpenGraphObject.getInnerJSONObject().toString());
    return new Request(paramSession, str, localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newUpdateOpenGraphObjectRequest(Session paramSession, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, GraphObject paramGraphObject, Request.Callback paramCallback)
  {
    OpenGraphObject localOpenGraphObject = OpenGraphObject.Factory.createForPost(OpenGraphObject.class, null, paramString2, paramString3, paramString4, paramString5);
    localOpenGraphObject.setId(paramString1);
    localOpenGraphObject.setData(paramGraphObject);
    return newUpdateOpenGraphObjectRequest(paramSession, localOpenGraphObject, paramCallback);
  }
  
  public static Request newUploadPhotoRequest(Session paramSession, Bitmap paramBitmap, Request.Callback paramCallback)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("picture", paramBitmap);
    return new Request(paramSession, "me/photos", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newUploadPhotoRequest(Session paramSession, File paramFile, Request.Callback paramCallback)
  {
    ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(paramFile, 268435456);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("picture", localParcelFileDescriptor);
    return new Request(paramSession, "me/photos", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newUploadStagingResourceWithImageRequest(Session paramSession, Bitmap paramBitmap, Request.Callback paramCallback)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramBitmap);
    return new Request(paramSession, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newUploadStagingResourceWithImageRequest(Session paramSession, File paramFile, Request.Callback paramCallback)
  {
    Request.ParcelFileDescriptorWithMimeType localParcelFileDescriptorWithMimeType = new Request.ParcelFileDescriptorWithMimeType(ParcelFileDescriptor.open(paramFile, 268435456), "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", localParcelFileDescriptorWithMimeType);
    return new Request(paramSession, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static Request newUploadVideoRequest(Session paramSession, File paramFile, Request.Callback paramCallback)
  {
    ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(paramFile, 268435456);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable(paramFile.getName(), localParcelFileDescriptor);
    return new Request(paramSession, "me/videos", localBundle, HttpMethod.POST, paramCallback);
  }
  
  private static String parameterToString(Object paramObject)
  {
    String str;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    }
    for (;;)
    {
      return str;
      if (((paramObject instanceof Boolean)) || ((paramObject instanceof Number)))
      {
        str = paramObject.toString();
      }
      else
      {
        if (!(paramObject instanceof Date)) {
          break;
        }
        str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
      }
    }
    throw new IllegalArgumentException("Unsupported parameter type.");
  }
  
  private static void processGraphObject(GraphObject paramGraphObject, String paramString, Request.KeyValueSerializer paramKeyValueSerializer)
  {
    int m;
    if (isMeRequest(paramString))
    {
      int j = paramString.indexOf(":");
      int k = paramString.indexOf("?");
      if ((j > 3) && ((k == -1) || (j < k))) {
        m = 1;
      }
    }
    for (int i = m;; i = 0)
    {
      Iterator localIterator = paramGraphObject.asMap().entrySet().iterator();
      label69:
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((i != 0) && (((String)localEntry.getKey()).equalsIgnoreCase("image"))) {}
        for (boolean bool = true;; bool = false)
        {
          processGraphObjectProperty((String)localEntry.getKey(), localEntry.getValue(), paramKeyValueSerializer, bool);
          break label69;
          m = 0;
          break;
        }
      }
      return;
    }
  }
  
  private static void processGraphObjectProperty(String paramString, Object paramObject, Request.KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
  {
    Class localClass1 = paramObject.getClass();
    Class localClass2;
    Object localObject;
    if (GraphObject.class.isAssignableFrom(localClass1))
    {
      JSONObject localJSONObject2 = ((GraphObject)paramObject).getInnerJSONObject();
      localClass2 = localJSONObject2.getClass();
      localObject = localJSONObject2;
    }
    for (;;)
    {
      JSONObject localJSONObject1;
      if (JSONObject.class.isAssignableFrom(localClass2))
      {
        localJSONObject1 = (JSONObject)localObject;
        if (paramBoolean)
        {
          Iterator localIterator = localJSONObject1.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = paramString;
            arrayOfObject2[1] = str;
            processGraphObjectProperty(String.format("%s[%s]", arrayOfObject2), localJSONObject1.opt(str), paramKeyValueSerializer, paramBoolean);
          }
          if (!GraphObjectList.class.isAssignableFrom(localClass1)) {
            break label419;
          }
          JSONArray localJSONArray2 = ((GraphObjectList)paramObject).getInnerJSONArray();
          localClass2 = localJSONArray2.getClass();
          localObject = localJSONArray2;
          continue;
        }
        if (localJSONObject1.has("id")) {
          processGraphObjectProperty(paramString, localJSONObject1.optString("id"), paramKeyValueSerializer, paramBoolean);
        }
      }
      for (;;)
      {
        return;
        if (localJSONObject1.has("url"))
        {
          processGraphObjectProperty(paramString, localJSONObject1.optString("url"), paramKeyValueSerializer, paramBoolean);
        }
        else if (localJSONObject1.has("fbsdk:create_object"))
        {
          processGraphObjectProperty(paramString, localJSONObject1.toString(), paramKeyValueSerializer, paramBoolean);
          continue;
          if (JSONArray.class.isAssignableFrom(localClass2))
          {
            JSONArray localJSONArray1 = (JSONArray)localObject;
            int i = localJSONArray1.length();
            for (int j = 0; j < i; j++)
            {
              Object[] arrayOfObject1 = new Object[2];
              arrayOfObject1[0] = paramString;
              arrayOfObject1[1] = Integer.valueOf(j);
              processGraphObjectProperty(String.format("%s[%d]", arrayOfObject1), localJSONArray1.opt(j), paramKeyValueSerializer, paramBoolean);
            }
          }
          else if ((String.class.isAssignableFrom(localClass2)) || (Number.class.isAssignableFrom(localClass2)) || (Boolean.class.isAssignableFrom(localClass2)))
          {
            paramKeyValueSerializer.writeString(paramString, localObject.toString());
          }
          else if (Date.class.isAssignableFrom(localClass2))
          {
            Date localDate = (Date)localObject;
            paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(localDate));
          }
        }
      }
      label419:
      localClass2 = localClass1;
      localObject = paramObject;
    }
  }
  
  private static void processRequest(RequestBatch paramRequestBatch, Logger paramLogger, int paramInt, URL paramURL, OutputStream paramOutputStream, boolean paramBoolean)
  {
    Request.Serializer localSerializer = new Request.Serializer(paramOutputStream, paramLogger, paramBoolean);
    if (paramInt == 1)
    {
      Request localRequest = paramRequestBatch.get(0);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator = localRequest.parameters.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject = localRequest.parameters.get(str2);
        if (isSupportedAttachmentType(localObject)) {
          localHashMap2.put(str2, new Request.Attachment(localRequest, localObject));
        }
      }
      if (paramLogger != null) {
        paramLogger.append("  Parameters:\n");
      }
      serializeParameters(localRequest.parameters, localSerializer, localRequest);
      if (paramLogger != null) {
        paramLogger.append("  Attachments:\n");
      }
      serializeAttachments(localHashMap2, localSerializer);
      if (localRequest.graphObject != null) {
        processGraphObject(localRequest.graphObject, paramURL.getPath(), localSerializer);
      }
    }
    for (;;)
    {
      return;
      String str1 = getBatchAppId(paramRequestBatch);
      if (Utility.isNullOrEmpty(str1)) {
        throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
      }
      localSerializer.writeString("batch_app_id", str1);
      HashMap localHashMap1 = new HashMap();
      serializeRequestsAsJSON(localSerializer, paramRequestBatch, localHashMap1);
      if (paramLogger != null) {
        paramLogger.append("  Attachments:\n");
      }
      serializeAttachments(localHashMap1, localSerializer);
    }
  }
  
  static void runCallbacks(RequestBatch paramRequestBatch, List<Response> paramList)
  {
    int i = paramRequestBatch.size();
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < i; j++)
    {
      Request localRequest = paramRequestBatch.get(j);
      if (localRequest.callback != null) {
        localArrayList.add(new Pair(localRequest.callback, paramList.get(j)));
      }
    }
    Request.4 local4;
    Handler localHandler;
    if (localArrayList.size() > 0)
    {
      local4 = new Request.4(localArrayList, paramRequestBatch);
      localHandler = paramRequestBatch.getCallbackHandler();
      if (localHandler != null) {
        break label106;
      }
      local4.run();
    }
    for (;;)
    {
      return;
      label106:
      localHandler.post(local4);
    }
  }
  
  private static void serializeAttachments(Map<String, Request.Attachment> paramMap, Request.Serializer paramSerializer)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Request.Attachment localAttachment = (Request.Attachment)paramMap.get(str);
      if (isSupportedAttachmentType(localAttachment.getValue())) {
        paramSerializer.writeObject(str, localAttachment.getValue(), localAttachment.getRequest());
      }
    }
  }
  
  private static void serializeParameters(Bundle paramBundle, Request.Serializer paramSerializer, Request paramRequest)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (isSupportedParameterType(localObject)) {
        paramSerializer.writeObject(str, localObject, paramRequest);
      }
    }
  }
  
  private static void serializeRequestsAsJSON(Request.Serializer paramSerializer, Collection<Request> paramCollection, Map<String, Request.Attachment> paramMap)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((Request)localIterator.next()).serializeToBatch(localJSONArray, paramMap);
    }
    paramSerializer.writeRequestsAsJson("batch", localJSONArray, paramCollection);
  }
  
  private void serializeToBatch(JSONArray paramJSONArray, Map<String, Request.Attachment> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (this.batchEntryName != null)
    {
      localJSONObject.put("name", this.batchEntryName);
      localJSONObject.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
    }
    if (this.batchEntryDependsOn != null) {
      localJSONObject.put("depends_on", this.batchEntryDependsOn);
    }
    String str1 = getUrlForBatchedRequest();
    localJSONObject.put("relative_url", str1);
    localJSONObject.put("method", this.httpMethod);
    if (this.session != null) {
      Logger.registerAccessToken(this.session.getAccessToken());
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Object localObject = this.parameters.get(str2);
      if (isSupportedAttachmentType(localObject))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "file";
        arrayOfObject[1] = Integer.valueOf(paramMap.size());
        String str3 = String.format("%s%d", arrayOfObject);
        localArrayList1.add(str3);
        paramMap.put(str3, new Request.Attachment(this, localObject));
      }
    }
    if (!localArrayList1.isEmpty()) {
      localJSONObject.put("attached_files", TextUtils.join(",", localArrayList1));
    }
    if (this.graphObject != null)
    {
      ArrayList localArrayList2 = new ArrayList();
      processGraphObject(this.graphObject, str1, new Request.5(this, localArrayList2));
      localJSONObject.put("body", TextUtils.join("&", localArrayList2));
    }
    paramJSONArray.put(localJSONObject);
  }
  
  /* Error */
  static final void serializeToUrlConnection(RequestBatch paramRequestBatch, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: new 247	com/facebook/internal/Logger
    //   3: dup
    //   4: getstatic 1067	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   7: ldc_w 1069
    //   10: invokespecial 1072	com/facebook/internal/Logger:<init>	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 456	com/facebook/RequestBatch:size	()I
    //   18: istore_3
    //   19: aload_0
    //   20: invokestatic 1074	com/facebook/Request:isGzipCompressible	(Lcom/facebook/RequestBatch;)Z
    //   23: istore 4
    //   25: iload_3
    //   26: iconst_1
    //   27: if_icmpne +133 -> 160
    //   30: aload_0
    //   31: iconst_0
    //   32: invokevirtual 934	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
    //   35: getfield 320	com/facebook/Request:httpMethod	Lcom/facebook/HttpMethod;
    //   38: astore 5
    //   40: aload_1
    //   41: aload 5
    //   43: invokevirtual 1076	com/facebook/HttpMethod:name	()Ljava/lang/String;
    //   46: invokevirtual 1079	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: iload 4
    //   52: invokestatic 1083	com/facebook/Request:setConnectionContentType	(Ljava/net/HttpURLConnection;Z)V
    //   55: aload_1
    //   56: invokevirtual 1087	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   59: astore 6
    //   61: aload_2
    //   62: ldc_w 1089
    //   65: invokevirtual 950	com/facebook/internal/Logger:append	(Ljava/lang/String;)V
    //   68: aload_2
    //   69: ldc_w 1091
    //   72: aload_0
    //   73: invokevirtual 1092	com/facebook/RequestBatch:getId	()Ljava/lang/String;
    //   76: invokevirtual 1096	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   79: aload_2
    //   80: ldc_w 1098
    //   83: aload 6
    //   85: invokevirtual 1096	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload_2
    //   89: ldc_w 1100
    //   92: aload_1
    //   93: invokevirtual 1103	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   96: invokevirtual 1096	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   99: aload_2
    //   100: ldc 109
    //   102: aload_1
    //   103: ldc 109
    //   105: invokevirtual 1106	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 1096	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   111: aload_2
    //   112: ldc 47
    //   114: aload_1
    //   115: ldc 47
    //   117: invokevirtual 1106	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 1096	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   123: aload_1
    //   124: aload_0
    //   125: invokevirtual 1109	com/facebook/RequestBatch:getTimeout	()I
    //   128: invokevirtual 1112	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   131: aload_1
    //   132: aload_0
    //   133: invokevirtual 1109	com/facebook/RequestBatch:getTimeout	()I
    //   136: invokevirtual 1115	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   139: aload 5
    //   141: getstatic 753	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   144: if_acmpne +24 -> 168
    //   147: iconst_1
    //   148: istore 7
    //   150: iload 7
    //   152: ifne +22 -> 174
    //   155: aload_2
    //   156: invokevirtual 1118	com/facebook/internal/Logger:log	()V
    //   159: return
    //   160: getstatic 753	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   163: astore 5
    //   165: goto -125 -> 40
    //   168: iconst_0
    //   169: istore 7
    //   171: goto -21 -> 150
    //   174: aload_1
    //   175: iconst_1
    //   176: invokevirtual 1122	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   179: new 1124	java/io/BufferedOutputStream
    //   182: dup
    //   183: aload_1
    //   184: invokevirtual 1128	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   187: invokespecial 1131	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   190: astore 8
    //   192: iload 4
    //   194: ifeq +14 -> 208
    //   197: new 1133	java/util/zip/GZIPOutputStream
    //   200: dup
    //   201: aload 8
    //   203: invokespecial 1134	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore 8
    //   208: aload_0
    //   209: invokestatic 1136	com/facebook/Request:hasOnProgressCallbacks	(Lcom/facebook/RequestBatch;)Z
    //   212: ifeq +120 -> 332
    //   215: new 1138	com/facebook/ProgressNoopOutputStream
    //   218: dup
    //   219: aload_0
    //   220: invokevirtual 993	com/facebook/RequestBatch:getCallbackHandler	()Landroid/os/Handler;
    //   223: invokespecial 1140	com/facebook/ProgressNoopOutputStream:<init>	(Landroid/os/Handler;)V
    //   226: astore 10
    //   228: aload_0
    //   229: aconst_null
    //   230: iload_3
    //   231: aload 6
    //   233: aload 10
    //   235: iload 4
    //   237: invokestatic 1142	com/facebook/Request:processRequest	(Lcom/facebook/RequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
    //   240: aload 10
    //   242: invokevirtual 1145	com/facebook/ProgressNoopOutputStream:getMaxProgress	()I
    //   245: istore 11
    //   247: new 1147	com/facebook/ProgressOutputStream
    //   250: dup
    //   251: aload 8
    //   253: aload_0
    //   254: aload 10
    //   256: invokevirtual 1150	com/facebook/ProgressNoopOutputStream:getProgressMap	()Ljava/util/Map;
    //   259: iload 11
    //   261: i2l
    //   262: invokespecial 1153	com/facebook/ProgressOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/RequestBatch;Ljava/util/Map;J)V
    //   265: astore 12
    //   267: aload 12
    //   269: astore 13
    //   271: aload_0
    //   272: aload_2
    //   273: iload_3
    //   274: aload 6
    //   276: aload 13
    //   278: iload 4
    //   280: invokestatic 1142	com/facebook/Request:processRequest	(Lcom/facebook/RequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
    //   283: aload 13
    //   285: ifnull +8 -> 293
    //   288: aload 13
    //   290: invokevirtual 1158	java/io/OutputStream:close	()V
    //   293: aload_2
    //   294: invokevirtual 1118	com/facebook/internal/Logger:log	()V
    //   297: goto -138 -> 159
    //   300: astore 9
    //   302: aconst_null
    //   303: astore 8
    //   305: aload 8
    //   307: ifnull +8 -> 315
    //   310: aload 8
    //   312: invokevirtual 1158	java/io/OutputStream:close	()V
    //   315: aload 9
    //   317: athrow
    //   318: astore 9
    //   320: goto -15 -> 305
    //   323: astore 9
    //   325: aload 13
    //   327: astore 8
    //   329: goto -24 -> 305
    //   332: aload 8
    //   334: astore 13
    //   336: goto -65 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramRequestBatch	RequestBatch
    //   0	339	1	paramHttpURLConnection	HttpURLConnection
    //   13	281	2	localLogger	Logger
    //   18	256	3	i	int
    //   23	256	4	bool	boolean
    //   38	126	5	localHttpMethod	HttpMethod
    //   59	216	6	localURL	URL
    //   148	22	7	j	int
    //   190	143	8	localObject1	Object
    //   300	16	9	localObject2	Object
    //   318	1	9	localObject3	Object
    //   323	1	9	localObject4	Object
    //   226	29	10	localProgressNoopOutputStream	ProgressNoopOutputStream
    //   245	15	11	k	int
    //   265	3	12	localProgressOutputStream	ProgressOutputStream
    //   269	66	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   179	192	300	finally
    //   197	267	318	finally
    //   271	283	323	finally
  }
  
  private static void setConnectionContentType(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      paramHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
    }
    for (;;)
    {
      return;
      paramHttpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
    }
  }
  
  public static final void setDefaultBatchApplicationId(String paramString)
  {
    defaultBatchApplicationId = paramString;
  }
  
  public static HttpURLConnection toHttpConnection(RequestBatch paramRequestBatch)
  {
    for (;;)
    {
      try
      {
        if (paramRequestBatch.size() == 1) {
          localURL = new URL(paramRequestBatch.get(0).getUrlForSingleRequest());
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        URL localURL;
        HttpURLConnection localHttpURLConnection;
        throw new FacebookException("could not construct URL for request", localMalformedURLException);
      }
      try
      {
        localHttpURLConnection = createConnection(localURL);
        serializeToUrlConnection(paramRequestBatch, localHttpURLConnection);
        return localHttpURLConnection;
      }
      catch (IOException localIOException)
      {
        throw new FacebookException("could not construct request body", localIOException);
      }
      catch (JSONException localJSONException)
      {
        throw new FacebookException("could not construct request body", localJSONException);
      }
      localURL = new URL(ServerProtocol.getGraphUrlBase());
    }
  }
  
  public static HttpURLConnection toHttpConnection(Collection<Request> paramCollection)
  {
    Validate.notEmptyAndContainsNoNulls(paramCollection, "requests");
    return toHttpConnection(new RequestBatch(paramCollection));
  }
  
  public static HttpURLConnection toHttpConnection(Request... paramVarArgs)
  {
    return toHttpConnection(Arrays.asList(paramVarArgs));
  }
  
  private static <T extends GraphObject> List<T> typedListFromResponse(Response paramResponse, Class<T> paramClass)
  {
    GraphMultiResult localGraphMultiResult = (GraphMultiResult)paramResponse.getGraphObjectAs(GraphMultiResult.class);
    Object localObject;
    if (localGraphMultiResult == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      GraphObjectList localGraphObjectList = localGraphMultiResult.getData();
      if (localGraphObjectList == null) {
        localObject = null;
      } else {
        localObject = localGraphObjectList.castToListOf(paramClass);
      }
    }
  }
  
  public final Response executeAndWait()
  {
    return executeAndWait(this);
  }
  
  public final RequestAsyncTask executeAsync()
  {
    Request[] arrayOfRequest = new Request[1];
    arrayOfRequest[0] = this;
    return executeBatchAsync(arrayOfRequest);
  }
  
  public final String getBatchEntryDependsOn()
  {
    return this.batchEntryDependsOn;
  }
  
  public final String getBatchEntryName()
  {
    return this.batchEntryName;
  }
  
  public final boolean getBatchEntryOmitResultOnSuccess()
  {
    return this.batchEntryOmitResultOnSuccess;
  }
  
  public final Request.Callback getCallback()
  {
    return this.callback;
  }
  
  public final GraphObject getGraphObject()
  {
    return this.graphObject;
  }
  
  public final String getGraphPath()
  {
    return this.graphPath;
  }
  
  public final HttpMethod getHttpMethod()
  {
    return this.httpMethod;
  }
  
  public final Bundle getParameters()
  {
    return this.parameters;
  }
  
  public final Session getSession()
  {
    return this.session;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  final String getUrlForBatchedRequest()
  {
    if (this.overriddenURL != null) {
      throw new FacebookException("Can't override URL for a batch request");
    }
    String str = getGraphPathWithVersion();
    addCommonParameters();
    return appendParametersToBaseUrl(str);
  }
  
  final String getUrlForSingleRequest()
  {
    String str3;
    if (this.overriddenURL != null)
    {
      str3 = this.overriddenURL.toString();
      return str3;
    }
    if ((getHttpMethod() == HttpMethod.POST) && (this.graphPath != null) && (this.graphPath.endsWith("/videos"))) {}
    for (String str1 = ServerProtocol.getGraphVideoUrlBase();; str1 = ServerProtocol.getGraphUrlBase())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = getGraphPathWithVersion();
      String str2 = String.format("%s/%s", arrayOfObject);
      addCommonParameters();
      str3 = appendParametersToBaseUrl(str2);
      break;
    }
  }
  
  public final String getVersion()
  {
    return this.version;
  }
  
  public final void setBatchEntryDependsOn(String paramString)
  {
    this.batchEntryDependsOn = paramString;
  }
  
  public final void setBatchEntryName(String paramString)
  {
    this.batchEntryName = paramString;
  }
  
  public final void setBatchEntryOmitResultOnSuccess(boolean paramBoolean)
  {
    this.batchEntryOmitResultOnSuccess = paramBoolean;
  }
  
  public final void setCallback(Request.Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  public final void setGraphObject(GraphObject paramGraphObject)
  {
    this.graphObject = paramGraphObject;
  }
  
  public final void setGraphPath(String paramString)
  {
    this.graphPath = paramString;
  }
  
  public final void setHttpMethod(HttpMethod paramHttpMethod)
  {
    if ((this.overriddenURL != null) && (paramHttpMethod != HttpMethod.GET)) {
      throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }
    if (paramHttpMethod != null) {}
    for (;;)
    {
      this.httpMethod = paramHttpMethod;
      return;
      paramHttpMethod = HttpMethod.GET;
    }
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    this.parameters = paramBundle;
  }
  
  public final void setSession(Session paramSession)
  {
    this.session = paramSession;
  }
  
  public final void setSkipClientToken(boolean paramBoolean)
  {
    this.skipClientToken = paramBoolean;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public final void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    return "{Request: " + " session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request
 * JD-Core Version:    0.7.0.1
 */