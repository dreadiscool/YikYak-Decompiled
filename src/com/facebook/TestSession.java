package com.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestSession
  extends Session
{
  private static final String LOG_TAG = "FacebookSDK.TestSession";
  private static Map<String, TestSession.TestAccount> appTestAccounts;
  private static final long serialVersionUID = 1L;
  private static String testApplicationId;
  private static String testApplicationSecret;
  private final TestSession.Mode mode;
  private final List<String> requestedPermissions;
  private final String sessionUniqueUserTag;
  private String testAccountId;
  private String testAccountUserName;
  private boolean wasAskedToExtendAccessToken;
  
  static
  {
    if (!TestSession.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  TestSession(Activity paramActivity, List<String> paramList, TokenCachingStrategy paramTokenCachingStrategy, String paramString, TestSession.Mode paramMode)
  {
    super(paramActivity, testApplicationId, paramTokenCachingStrategy);
    Validate.notNull(paramList, "permissions");
    Validate.notNullOrEmpty(testApplicationId, "testApplicationId");
    Validate.notNullOrEmpty(testApplicationSecret, "testApplicationSecret");
    this.sessionUniqueUserTag = paramString;
    this.mode = paramMode;
    this.requestedPermissions = paramList;
  }
  
  public static TestSession createSessionWithPrivateUser(Activity paramActivity, List<String> paramList)
  {
    return createTestSession(paramActivity, paramList, TestSession.Mode.PRIVATE, null);
  }
  
  public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList)
  {
    return createSessionWithSharedUser(paramActivity, paramList, null);
  }
  
  public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList, String paramString)
  {
    return createTestSession(paramActivity, paramList, TestSession.Mode.SHARED, paramString);
  }
  
  private TestSession.TestAccount createTestAccountAndFinishAuth()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("installed", "true");
    localBundle.putString("permissions", getPermissionsString());
    localBundle.putString("access_token", getAppAccessToken());
    if (this.mode == TestSession.Mode.SHARED)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = getSharedTestAccountIdentifier();
      localBundle.putString("name", String.format("Shared %s Testuser", arrayOfObject2));
    }
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = testApplicationId;
    Response localResponse = new Request(null, String.format("%s/accounts/test-users", arrayOfObject1), localBundle, HttpMethod.POST).executeAndWait();
    FacebookRequestError localFacebookRequestError = localResponse.getError();
    TestSession.TestAccount localTestAccount = (TestSession.TestAccount)localResponse.getGraphObjectAs(TestSession.TestAccount.class);
    if (localFacebookRequestError != null)
    {
      finishAuthOrReauth(null, localFacebookRequestError.getException());
      localTestAccount = null;
    }
    for (;;)
    {
      return localTestAccount;
      assert (localTestAccount != null);
      if (this.mode == TestSession.Mode.SHARED)
      {
        localTestAccount.setName(localBundle.getString("name"));
        storeTestAccount(localTestAccount);
      }
      finishAuthWithTestAccount(localTestAccount);
    }
  }
  
  private static TestSession createTestSession(Activity paramActivity, List<String> paramList, TestSession.Mode paramMode, String paramString)
  {
    try
    {
      if ((Utility.isNullOrEmpty(testApplicationId)) || (Utility.isNullOrEmpty(testApplicationSecret))) {
        throw new FacebookException("Must provide app ID and secret");
      }
    }
    finally {}
    String[] arrayOfString;
    if (Utility.isNullOrEmpty(paramList))
    {
      arrayOfString = new String[2];
      arrayOfString[0] = "email";
      arrayOfString[1] = "publish_actions";
    }
    for (Object localObject2 = Arrays.asList(arrayOfString);; localObject2 = paramList)
    {
      TestSession localTestSession = new TestSession(paramActivity, (List)localObject2, new TestSession.TestTokenCachingStrategy(null), paramString, paramMode);
      return localTestSession;
    }
  }
  
  private void deleteTestAccount(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("access_token", paramString2);
    Response localResponse = new Request(null, paramString1, localBundle, HttpMethod.DELETE).executeAndWait();
    FacebookRequestError localFacebookRequestError = localResponse.getError();
    GraphObject localGraphObject = localResponse.getGraphObject();
    if (localFacebookRequestError != null)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString1;
      arrayOfObject2[1] = localFacebookRequestError.getException().toString();
      String.format("Could not delete test account %s: %s", arrayOfObject2);
    }
    for (;;)
    {
      return;
      if ((localGraphObject.getProperty("FACEBOOK_NON_JSON_RESULT") == Boolean.valueOf(false)) || (localGraphObject.getProperty("success") == Boolean.valueOf(false)))
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = paramString1;
        String.format("Could not delete test account %s: unknown reason", arrayOfObject1);
      }
    }
  }
  
  private void findOrCreateSharedTestAccount()
  {
    TestSession.TestAccount localTestAccount = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier());
    if (localTestAccount != null) {
      finishAuthWithTestAccount(localTestAccount);
    }
    for (;;)
    {
      return;
      createTestAccountAndFinishAuth();
    }
  }
  
  /* Error */
  private static TestSession.TestAccount findTestAccountMatchingIdentifier(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 253	com/facebook/TestSession:retrieveTestAccountsForAppIfNeeded	()V
    //   6: getstatic 255	com/facebook/TestSession:appTestAccounts	Ljava/util/Map;
    //   9: invokeinterface 261 1 0
    //   14: invokeinterface 267 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 272 1 0
    //   26: ifeq +35 -> 61
    //   29: aload_2
    //   30: invokeinterface 276 1 0
    //   35: checkcast 148	com/facebook/TestSession$TestAccount
    //   38: astore_3
    //   39: aload_3
    //   40: invokeinterface 279 1 0
    //   45: aload_0
    //   46: invokevirtual 283	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   49: istore 4
    //   51: iload 4
    //   53: ifeq -33 -> 20
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_3
    //   60: areturn
    //   61: aconst_null
    //   62: astore_3
    //   63: goto -7 -> 56
    //   66: astore_1
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString	String
    //   66	5	1	localObject	Object
    //   19	11	2	localIterator	Iterator
    //   38	25	3	localTestAccount	TestSession.TestAccount
    //   49	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	51	66	finally
  }
  
  private void finishAuthWithTestAccount(TestSession.TestAccount paramTestAccount)
  {
    this.testAccountId = paramTestAccount.getId();
    this.testAccountUserName = paramTestAccount.getName();
    finishAuthOrReauth(AccessToken.createFromString(paramTestAccount.getAccessToken(), this.requestedPermissions, AccessTokenSource.TEST_USER), null);
  }
  
  static final String getAppAccessToken()
  {
    return testApplicationId + "|" + testApplicationSecret;
  }
  
  private String getPermissionsString()
  {
    return TextUtils.join(",", this.requestedPermissions);
  }
  
  private String getSharedTestAccountIdentifier()
  {
    long l1 = 0xFFFFFFFF & getPermissionsString().hashCode();
    if (this.sessionUniqueUserTag != null) {}
    for (long l2 = 0xFFFFFFFF & this.sessionUniqueUserTag.hashCode();; l2 = 0L) {
      return validNameStringFromInteger(l2 ^ l1);
    }
  }
  
  public static String getTestApplicationId()
  {
    try
    {
      String str = testApplicationId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTestApplicationSecret()
  {
    try
    {
      String str = testApplicationSecret;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void populateTestAccounts(Collection<TestSession.TestAccount> paramCollection, GraphObject paramGraphObject)
  {
    try
    {
      Iterator localIterator = paramCollection.iterator();
      if (localIterator.hasNext())
      {
        TestSession.TestAccount localTestAccount = (TestSession.TestAccount)localIterator.next();
        localTestAccount.setName(((GraphUser)paramGraphObject.getPropertyAs(localTestAccount.getId(), GraphUser.class)).getName());
        storeTestAccount(localTestAccount);
      }
      return;
    }
    finally {}
  }
  
  private static void retrieveTestAccountsForAppIfNeeded()
  {
    for (;;)
    {
      List localList;
      try
      {
        Map localMap = appTestAccounts;
        if (localMap != null) {
          return;
        }
        appTestAccounts = new HashMap();
        Request.setDefaultBatchApplicationId(testApplicationId);
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("access_token", getAppAccessToken());
        Request localRequest1 = new Request(null, "app/accounts/test-users", localBundle1, null);
        localRequest1.setBatchEntryName("testUsers");
        localRequest1.setBatchEntryOmitResultOnSuccess(false);
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("access_token", getAppAccessToken());
        localBundle2.putString("ids", "{result=testUsers:$.data.*.id}");
        localBundle2.putString("fields", "name");
        Request localRequest2 = new Request(null, "", localBundle2, null);
        localRequest2.setBatchEntryDependsOn("testUsers");
        Request[] arrayOfRequest = new Request[2];
        arrayOfRequest[0] = localRequest1;
        arrayOfRequest[1] = localRequest2;
        localList = Request.executeBatchAndWait(arrayOfRequest);
        if ((localList == null) || (localList.size() != 2)) {
          throw new FacebookException("Unexpected number of results from TestUsers batch query");
        }
      }
      finally {}
      populateTestAccounts(((TestSession.TestAccountsResponse)((Response)localList.get(0)).getGraphObjectAs(TestSession.TestAccountsResponse.class)).getData(), ((Response)localList.get(1)).getGraphObject());
    }
  }
  
  public static void setTestApplicationId(String paramString)
  {
    try
    {
      if ((testApplicationId != null) && (!testApplicationId.equals(paramString))) {
        throw new FacebookException("Can't have more than one test application ID");
      }
    }
    finally {}
    testApplicationId = paramString;
  }
  
  public static void setTestApplicationSecret(String paramString)
  {
    try
    {
      if ((testApplicationSecret != null) && (!testApplicationSecret.equals(paramString))) {
        throw new FacebookException("Can't have more than one test application secret");
      }
    }
    finally {}
    testApplicationSecret = paramString;
  }
  
  private static void storeTestAccount(TestSession.TestAccount paramTestAccount)
  {
    try
    {
      appTestAccounts.put(paramTestAccount.getId(), paramTestAccount);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String validNameStringFromInteger(long paramLong)
  {
    String str = Long.toString(paramLong);
    StringBuilder localStringBuilder = new StringBuilder("Perm");
    char[] arrayOfChar = str.toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      m = arrayOfChar[j];
      if (m == k) {
        m = (char)(m + 10);
      }
      localStringBuilder.append((char)(-48 + (m + 97)));
      j++;
    }
    return localStringBuilder.toString();
  }
  
  void authorize(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    if (this.mode == TestSession.Mode.PRIVATE) {
      createTestAccountAndFinishAuth();
    }
    for (;;)
    {
      return;
      findOrCreateSharedTestAccount();
    }
  }
  
  void extendAccessToken()
  {
    this.wasAskedToExtendAccessToken = true;
    super.extendAccessToken();
  }
  
  void fakeTokenRefreshAttempt()
  {
    setCurrentTokenRefreshRequest(new Session.TokenRefreshRequest(this));
  }
  
  void forceExtendAccessToken(boolean paramBoolean)
  {
    AccessToken localAccessToken = getTokenInfo();
    setTokenInfo(new AccessToken(localAccessToken.getToken(), new Date(), localAccessToken.getPermissions(), localAccessToken.getDeclinedPermissions(), AccessTokenSource.TEST_USER, new Date(0L)));
    setLastAttemptedTokenExtendDate(new Date(0L));
  }
  
  public final String getTestUserId()
  {
    return this.testAccountId;
  }
  
  public final String getTestUserName()
  {
    return this.testAccountUserName;
  }
  
  boolean getWasAskedToExtendAccessToken()
  {
    return this.wasAskedToExtendAccessToken;
  }
  
  void postStateChange(SessionState paramSessionState1, SessionState paramSessionState2, Exception paramException)
  {
    String str = this.testAccountId;
    super.postStateChange(paramSessionState1, paramSessionState2, paramException);
    if ((paramSessionState2.isClosed()) && (str != null) && (this.mode == TestSession.Mode.PRIVATE)) {
      deleteTestAccount(str, getAppAccessToken());
    }
  }
  
  boolean shouldExtendAccessToken()
  {
    boolean bool = super.shouldExtendAccessToken();
    this.wasAskedToExtendAccessToken = false;
    return bool;
  }
  
  public final String toString()
  {
    String str = super.toString();
    return "{TestSession" + " testUserId:" + this.testAccountId + " " + str + "}";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.TestSession
 * JD-Core Version:    0.7.0.1
 */