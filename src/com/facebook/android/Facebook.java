package com.facebook.android;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.TokenCachingStrategy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Facebook
{
  @Deprecated
  public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  @Deprecated
  public static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  @Deprecated
  public static final String CANCEL_URI = "fbconnect://cancel";
  private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
  @Deprecated
  protected static String DIALOG_BASE_URL = "https://m.facebook.com/dialog/";
  @Deprecated
  public static final String EXPIRES = "expires_in";
  @Deprecated
  public static final String FB_APP_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
  @Deprecated
  public static final int FORCE_DIALOG_AUTH = -1;
  @Deprecated
  protected static String GRAPH_BASE_URL = "https://graph.facebook.com/";
  private static final String LOGIN = "oauth";
  @Deprecated
  public static final String REDIRECT_URI = "fbconnect://success";
  private static final long REFRESH_TOKEN_BARRIER = 86400000L;
  @Deprecated
  protected static String RESTSERVER_URL = "https://api.facebook.com/restserver.php";
  @Deprecated
  public static final String SINGLE_SIGN_ON_DISABLED = "service_disabled";
  @Deprecated
  public static final String TOKEN = "access_token";
  private long accessExpiresMillisecondsAfterEpoch = 0L;
  private String accessToken = null;
  private long lastAccessUpdateMillisecondsAfterEpoch = 0L;
  private final Object lock = new Object();
  private String mAppId;
  private Activity pendingAuthorizationActivity;
  private String[] pendingAuthorizationPermissions;
  private Session pendingOpeningSession;
  private volatile Session session;
  private boolean sessionInvalidated;
  private Facebook.SetterTokenCachingStrategy tokenCache;
  private volatile Session userSetSession;
  
  @Deprecated
  public Facebook(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
    }
    this.mAppId = paramString;
  }
  
  private void authorize(Activity paramActivity, String[] paramArrayOfString, int paramInt, SessionLoginBehavior paramSessionLoginBehavior, Facebook.DialogListener paramDialogListener)
  {
    boolean bool = false;
    checkUserSession("authorize");
    this.pendingOpeningSession = new Session.Builder(paramActivity).setApplicationId(this.mAppId).setTokenCachingStrategy(getTokenCache()).build();
    this.pendingAuthorizationActivity = paramActivity;
    if (paramArrayOfString != null) {}
    for (;;)
    {
      this.pendingAuthorizationPermissions = paramArrayOfString;
      Facebook.1 local1 = new Facebook.1(this, paramDialogListener);
      Session.OpenRequest localOpenRequest = new Session.OpenRequest(paramActivity).setCallback(local1).setLoginBehavior(paramSessionLoginBehavior).setRequestCode(paramInt).setPermissions(Arrays.asList(this.pendingAuthorizationPermissions));
      Session localSession = this.pendingOpeningSession;
      if (this.pendingAuthorizationPermissions.length > 0) {
        bool = true;
      }
      openSession(localSession, localOpenRequest, bool);
      return;
      paramArrayOfString = new String[0];
    }
  }
  
  private void checkUserSession(String paramString)
  {
    if (this.userSetSession != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString;
      throw new UnsupportedOperationException(String.format("Cannot call %s after setSession has been called.", arrayOfObject));
    }
  }
  
  @Deprecated
  public static String getAttributionId(ContentResolver paramContentResolver)
  {
    return Settings.getAttributionId(paramContentResolver);
  }
  
  private TokenCachingStrategy getTokenCache()
  {
    if (this.tokenCache == null) {
      this.tokenCache = new Facebook.SetterTokenCachingStrategy(this, null);
    }
    return this.tokenCache;
  }
  
  private void onSessionCallback(Session paramSession, SessionState paramSessionState, Exception paramException, Facebook.DialogListener paramDialogListener)
  {
    Bundle localBundle = paramSession.getAuthorizationBundle();
    Session localSession;
    if (paramSessionState == SessionState.OPENED) {
      localSession = null;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (paramSession != this.session)
        {
          localSession = this.session;
          this.session = paramSession;
          this.sessionInvalidated = false;
        }
        if (localSession != null) {
          localSession.close();
        }
        paramDialogListener.onComplete(localBundle);
        return;
      }
      if (paramException != null) {
        if ((paramException instanceof FacebookOperationCanceledException)) {
          paramDialogListener.onCancel();
        } else if (((paramException instanceof FacebookAuthorizationException)) && (localBundle != null) && (localBundle.containsKey("com.facebook.sdk.WebViewErrorCode")) && (localBundle.containsKey("com.facebook.sdk.FailingUrl"))) {
          paramDialogListener.onError(new DialogError(paramException.getMessage(), localBundle.getInt("com.facebook.sdk.WebViewErrorCode"), localBundle.getString("com.facebook.sdk.FailingUrl")));
        } else {
          paramDialogListener.onFacebookError(new FacebookError(paramException.getMessage()));
        }
      }
    }
  }
  
  private void openSession(Session paramSession, Session.OpenRequest paramOpenRequest, boolean paramBoolean)
  {
    paramOpenRequest.setIsLegacy(true);
    if (paramBoolean) {
      paramSession.openForPublish(paramOpenRequest);
    }
    for (;;)
    {
      return;
      paramSession.openForRead(paramOpenRequest);
    }
  }
  
  private static String[] stringArray(List<String> paramList)
  {
    int i = 0;
    if (paramList != null) {}
    String[] arrayOfString;
    for (int j = paramList.size();; j = 0)
    {
      arrayOfString = new String[j];
      if (paramList == null) {
        break;
      }
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramList.get(i));
        i++;
      }
    }
    return arrayOfString;
  }
  
  private static List<String> stringList(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (List localList = Arrays.asList(paramArrayOfString);; localList = Collections.emptyList()) {
      return localList;
    }
  }
  
  private boolean validateAppSignatureForPackage(Context paramContext, String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        Signature[] arrayOfSignature = localPackageInfo.signatures;
        int i = arrayOfSignature.length;
        j = 0;
        if (j < i)
        {
          if (!arrayOfSignature[j].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
            continue;
          }
          bool = true;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        int j;
        continue;
      }
      return bool;
      j++;
    }
  }
  
  private boolean validateServiceIntent(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if (localResolveInfo == null) {}
    for (;;)
    {
      return bool;
      bool = validateAppSignatureForPackage(paramContext, localResolveInfo.serviceInfo.packageName);
    }
  }
  
  @Deprecated
  public void authorize(Activity paramActivity, Facebook.DialogListener paramDialogListener)
  {
    authorize(paramActivity, new String[0], 32665, SessionLoginBehavior.SSO_WITH_FALLBACK, paramDialogListener);
  }
  
  @Deprecated
  public void authorize(Activity paramActivity, String[] paramArrayOfString, int paramInt, Facebook.DialogListener paramDialogListener)
  {
    if (paramInt >= 0) {}
    for (SessionLoginBehavior localSessionLoginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;; localSessionLoginBehavior = SessionLoginBehavior.SUPPRESS_SSO)
    {
      authorize(paramActivity, paramArrayOfString, paramInt, localSessionLoginBehavior, paramDialogListener);
      return;
    }
  }
  
  @Deprecated
  public void authorize(Activity paramActivity, String[] paramArrayOfString, Facebook.DialogListener paramDialogListener)
  {
    authorize(paramActivity, paramArrayOfString, 32665, SessionLoginBehavior.SSO_WITH_FALLBACK, paramDialogListener);
  }
  
  @Deprecated
  public void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    checkUserSession("authorizeCallback");
    Session localSession = this.pendingOpeningSession;
    if ((localSession != null) && (localSession.onActivityResult(this.pendingAuthorizationActivity, paramInt1, paramInt2, paramIntent)))
    {
      this.pendingOpeningSession = null;
      this.pendingAuthorizationActivity = null;
      this.pendingAuthorizationPermissions = null;
    }
  }
  
  @Deprecated
  public void dialog(Context paramContext, String paramString, Bundle paramBundle, Facebook.DialogListener paramDialogListener)
  {
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break label101;
      }
      Util.showAlert(paramContext, "Error", "Application requires permission to access the Internet");
    }
    for (;;)
    {
      return;
      paramBundle.putString("app_id", this.mAppId);
      if (!isSessionValid()) {
        break;
      }
      paramBundle.putString("access_token", getAccessToken());
      break;
      label101:
      new FbDialog(paramContext, paramString, paramBundle, paramDialogListener).show();
    }
  }
  
  @Deprecated
  public void dialog(Context paramContext, String paramString, Facebook.DialogListener paramDialogListener)
  {
    dialog(paramContext, paramString, new Bundle(), paramDialogListener);
  }
  
  @Deprecated
  public boolean extendAccessToken(Context paramContext, Facebook.ServiceListener paramServiceListener)
  {
    checkUserSession("extendAccessToken");
    Intent localIntent = new Intent();
    localIntent.setClassName("com.facebook.katana", "com.facebook.katana.platform.TokenRefreshService");
    if (!validateServiceIntent(paramContext, localIntent)) {}
    for (boolean bool = false;; bool = paramContext.bindService(localIntent, new Facebook.TokenRefreshServiceConnection(this, paramContext, paramServiceListener), 1)) {
      return bool;
    }
  }
  
  @Deprecated
  public boolean extendAccessTokenIfNeeded(Context paramContext, Facebook.ServiceListener paramServiceListener)
  {
    checkUserSession("extendAccessTokenIfNeeded");
    if (shouldExtendAccessToken()) {}
    for (boolean bool = extendAccessToken(paramContext, paramServiceListener);; bool = true) {
      return bool;
    }
  }
  
  @Deprecated
  public long getAccessExpires()
  {
    Session localSession = getSession();
    if (localSession != null) {}
    for (long l = localSession.getExpirationDate().getTime();; l = this.accessExpiresMillisecondsAfterEpoch) {
      return l;
    }
  }
  
  @Deprecated
  public String getAccessToken()
  {
    Session localSession = getSession();
    if (localSession != null) {}
    for (String str = localSession.getAccessToken();; str = null) {
      return str;
    }
  }
  
  @Deprecated
  public String getAppId()
  {
    return this.mAppId;
  }
  
  @Deprecated
  public long getLastAccessUpdate()
  {
    return this.lastAccessUpdateMillisecondsAfterEpoch;
  }
  
  /* Error */
  @Deprecated
  public final Session getSession()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/facebook/android/Facebook:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 213	com/facebook/android/Facebook:userSetSession	Lcom/facebook/Session;
    //   11: ifnull +13 -> 24
    //   14: aload_0
    //   15: getfield 213	com/facebook/android/Facebook:userSetSession	Lcom/facebook/Session;
    //   18: astore_3
    //   19: aload_1
    //   20: monitorexit
    //   21: goto +271 -> 292
    //   24: aload_0
    //   25: getfield 120	com/facebook/android/Facebook:session	Lcom/facebook/Session;
    //   28: ifnonnull +10 -> 38
    //   31: aload_0
    //   32: getfield 249	com/facebook/android/Facebook:sessionInvalidated	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: getfield 120	com/facebook/android/Facebook:session	Lcom/facebook/Session;
    //   42: astore_3
    //   43: aload_1
    //   44: monitorexit
    //   45: goto +247 -> 292
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    //   53: aload_0
    //   54: getfield 94	com/facebook/android/Facebook:accessToken	Ljava/lang/String;
    //   57: astore 4
    //   59: aload_0
    //   60: getfield 120	com/facebook/android/Facebook:session	Lcom/facebook/Session;
    //   63: astore 5
    //   65: aload_1
    //   66: monitorexit
    //   67: aload 4
    //   69: ifnonnull +8 -> 77
    //   72: aconst_null
    //   73: astore_3
    //   74: goto +218 -> 292
    //   77: aload 5
    //   79: ifnull +56 -> 135
    //   82: aload 5
    //   84: invokevirtual 508	com/facebook/Session:getPermissions	()Ljava/util/List;
    //   87: astore 6
    //   89: new 150	com/facebook/Session$Builder
    //   92: dup
    //   93: aload_0
    //   94: getfield 173	com/facebook/android/Facebook:pendingAuthorizationActivity	Landroid/app/Activity;
    //   97: invokespecial 153	com/facebook/Session$Builder:<init>	(Landroid/content/Context;)V
    //   100: aload_0
    //   101: getfield 106	com/facebook/android/Facebook:mAppId	Ljava/lang/String;
    //   104: invokevirtual 157	com/facebook/Session$Builder:setApplicationId	(Ljava/lang/String;)Lcom/facebook/Session$Builder;
    //   107: aload_0
    //   108: invokespecial 161	com/facebook/android/Facebook:getTokenCache	()Lcom/facebook/TokenCachingStrategy;
    //   111: invokevirtual 165	com/facebook/Session$Builder:setTokenCachingStrategy	(Lcom/facebook/TokenCachingStrategy;)Lcom/facebook/Session$Builder;
    //   114: invokevirtual 169	com/facebook/Session$Builder:build	()Lcom/facebook/Session;
    //   117: astore 7
    //   119: aload 7
    //   121: invokevirtual 512	com/facebook/Session:getState	()Lcom/facebook/SessionState;
    //   124: getstatic 515	com/facebook/SessionState:CREATED_TOKEN_LOADED	Lcom/facebook/SessionState;
    //   127: if_acmpeq +35 -> 162
    //   130: aconst_null
    //   131: astore_3
    //   132: goto +160 -> 292
    //   135: aload_0
    //   136: getfield 128	com/facebook/android/Facebook:pendingAuthorizationPermissions	[Ljava/lang/String;
    //   139: ifnull +15 -> 154
    //   142: aload_0
    //   143: getfield 128	com/facebook/android/Facebook:pendingAuthorizationPermissions	[Ljava/lang/String;
    //   146: invokestatic 201	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   149: astore 6
    //   151: goto -62 -> 89
    //   154: invokestatic 332	java/util/Collections:emptyList	()Ljava/util/List;
    //   157: astore 6
    //   159: goto -70 -> 89
    //   162: new 180	com/facebook/Session$OpenRequest
    //   165: dup
    //   166: aload_0
    //   167: getfield 173	com/facebook/android/Facebook:pendingAuthorizationActivity	Landroid/app/Activity;
    //   170: invokespecial 183	com/facebook/Session$OpenRequest:<init>	(Landroid/app/Activity;)V
    //   173: aload 6
    //   175: invokevirtual 205	com/facebook/Session$OpenRequest:setPermissions	(Ljava/util/List;)Lcom/facebook/Session$OpenRequest;
    //   178: astore 8
    //   180: aload 6
    //   182: invokeinterface 518 1 0
    //   187: ifne +83 -> 270
    //   190: iconst_1
    //   191: istore 9
    //   193: aload_0
    //   194: aload 7
    //   196: aload 8
    //   198: iload 9
    //   200: invokespecial 209	com/facebook/android/Facebook:openSession	(Lcom/facebook/Session;Lcom/facebook/Session$OpenRequest;Z)V
    //   203: aload_0
    //   204: getfield 92	com/facebook/android/Facebook:lock	Ljava/lang/Object;
    //   207: astore 10
    //   209: aload 10
    //   211: monitorenter
    //   212: aload_0
    //   213: getfield 249	com/facebook/android/Facebook:sessionInvalidated	Z
    //   216: ifne +10 -> 226
    //   219: aload_0
    //   220: getfield 120	com/facebook/android/Facebook:session	Lcom/facebook/Session;
    //   223: ifnonnull +61 -> 284
    //   226: aload_0
    //   227: getfield 120	com/facebook/android/Facebook:session	Lcom/facebook/Session;
    //   230: astore 12
    //   232: aload_0
    //   233: aload 7
    //   235: putfield 120	com/facebook/android/Facebook:session	Lcom/facebook/Session;
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 249	com/facebook/android/Facebook:sessionInvalidated	Z
    //   243: aload 12
    //   245: astore 13
    //   247: aload 7
    //   249: astore_3
    //   250: aload 10
    //   252: monitorexit
    //   253: aload 13
    //   255: ifnull +8 -> 263
    //   258: aload 13
    //   260: invokevirtual 252	com/facebook/Session:close	()V
    //   263: aload_3
    //   264: ifnull -264 -> 0
    //   267: goto +25 -> 292
    //   270: iconst_0
    //   271: istore 9
    //   273: goto -80 -> 193
    //   276: astore 11
    //   278: aload 10
    //   280: monitorexit
    //   281: aload 11
    //   283: athrow
    //   284: aconst_null
    //   285: astore_3
    //   286: aconst_null
    //   287: astore 13
    //   289: goto -39 -> 250
    //   292: aload_3
    //   293: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	Facebook
    //   4	62	1	localObject1	Object
    //   48	4	2	localObject2	Object
    //   18	275	3	localObject3	Object
    //   57	11	4	str	String
    //   63	20	5	localSession1	Session
    //   87	94	6	localList	List
    //   117	131	7	localSession2	Session
    //   178	19	8	localOpenRequest	Session.OpenRequest
    //   191	81	9	bool	boolean
    //   207	72	10	localObject4	Object
    //   276	6	11	localObject5	Object
    //   230	14	12	localSession3	Session
    //   245	43	13	localSession4	Session
    // Exception table:
    //   from	to	target	type
    //   7	51	48	finally
    //   53	67	48	finally
    //   212	253	276	finally
    //   278	281	276	finally
  }
  
  @Deprecated
  public boolean isSessionValid()
  {
    if ((getAccessToken() != null) && ((getAccessExpires() == 0L) || (System.currentTimeMillis() < getAccessExpires()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @Deprecated
  public String logout(Context paramContext)
  {
    return logoutImpl(paramContext);
  }
  
  String logoutImpl(Context paramContext)
  {
    checkUserSession("logout");
    Bundle localBundle = new Bundle();
    localBundle.putString("method", "auth.expireSession");
    String str = request(localBundle);
    long l = System.currentTimeMillis();
    synchronized (this.lock)
    {
      Session localSession = this.session;
      this.session = null;
      this.accessToken = null;
      this.accessExpiresMillisecondsAfterEpoch = 0L;
      this.lastAccessUpdateMillisecondsAfterEpoch = l;
      this.sessionInvalidated = false;
      if (localSession != null) {
        localSession.closeAndClearTokenInformation();
      }
      return str;
    }
  }
  
  @Deprecated
  public String request(Bundle paramBundle)
  {
    if (!paramBundle.containsKey("method")) {
      throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
    }
    return requestImpl(null, paramBundle, "GET");
  }
  
  @Deprecated
  public String request(String paramString)
  {
    return requestImpl(paramString, new Bundle(), "GET");
  }
  
  @Deprecated
  public String request(String paramString, Bundle paramBundle)
  {
    return requestImpl(paramString, paramBundle, "GET");
  }
  
  @Deprecated
  public String request(String paramString1, Bundle paramBundle, String paramString2)
  {
    return requestImpl(paramString1, paramBundle, paramString2);
  }
  
  String requestImpl(String paramString1, Bundle paramBundle, String paramString2)
  {
    paramBundle.putString("format", "json");
    if (isSessionValid()) {
      paramBundle.putString("access_token", getAccessToken());
    }
    if (paramString1 != null) {}
    for (String str = GRAPH_BASE_URL + paramString1;; str = RESTSERVER_URL) {
      return Util.openUrl(str, paramString2, paramBundle);
    }
  }
  
  @Deprecated
  public void setAccessExpires(long paramLong)
  {
    checkUserSession("setAccessExpires");
    synchronized (this.lock)
    {
      this.accessExpiresMillisecondsAfterEpoch = paramLong;
      this.lastAccessUpdateMillisecondsAfterEpoch = System.currentTimeMillis();
      this.sessionInvalidated = true;
      return;
    }
  }
  
  @Deprecated
  public void setAccessExpiresIn(String paramString)
  {
    checkUserSession("setAccessExpiresIn");
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label29;
      }
    }
    label29:
    for (long l = 0L;; l = System.currentTimeMillis() + 1000L * Long.parseLong(paramString))
    {
      setAccessExpires(l);
      return;
    }
  }
  
  @Deprecated
  public void setAccessToken(String paramString)
  {
    checkUserSession("setAccessToken");
    synchronized (this.lock)
    {
      this.accessToken = paramString;
      this.lastAccessUpdateMillisecondsAfterEpoch = System.currentTimeMillis();
      this.sessionInvalidated = true;
      return;
    }
  }
  
  @Deprecated
  public void setAppId(String paramString)
  {
    checkUserSession("setAppId");
    synchronized (this.lock)
    {
      this.mAppId = paramString;
      this.sessionInvalidated = true;
      return;
    }
  }
  
  @Deprecated
  public void setSession(Session paramSession)
  {
    if (paramSession == null) {
      throw new IllegalArgumentException("session cannot be null");
    }
    synchronized (this.lock)
    {
      this.userSetSession = paramSession;
      return;
    }
  }
  
  @Deprecated
  public void setTokenFromCache(String paramString, long paramLong1, long paramLong2)
  {
    checkUserSession("setTokenFromCache");
    synchronized (this.lock)
    {
      this.accessToken = paramString;
      this.accessExpiresMillisecondsAfterEpoch = paramLong1;
      this.lastAccessUpdateMillisecondsAfterEpoch = paramLong2;
      return;
    }
  }
  
  @Deprecated
  public boolean shouldExtendAccessToken()
  {
    checkUserSession("shouldExtendAccessToken");
    if ((isSessionValid()) && (System.currentTimeMillis() - this.lastAccessUpdateMillisecondsAfterEpoch >= 86400000L)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.facebook.android.Facebook

 * JD-Core Version:    0.7.0.1

 */