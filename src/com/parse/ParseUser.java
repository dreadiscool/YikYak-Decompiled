package com.parse;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y;

@ParseClassName("_User")
public class ParseUser
  extends ParseObject
{
  private static final String CURRENT_USER_FILENAME = "currentUser";
  private static final String PIN_CURRENT_USER = "_currentUser";
  private static Map<String, ParseAuthenticationProvider> authenticationProviders = new HashMap();
  private static boolean autoUserEnabled;
  private static ParseUser currentUser;
  private static boolean currentUserMatchesDisk = false;
  private static final Object currentUserMutex = new Object();
  private final JSONObject authData = new JSONObject();
  private boolean dirty;
  private boolean isCurrentUser = false;
  private boolean isLazy = false;
  private boolean isNew;
  private final Set<String> linkedServiceNames = new HashSet();
  private String password;
  private final Set<String> readOnlyLinkedServiceNames = Collections.unmodifiableSet(this.linkedServiceNames);
  private String sessionToken;
  
  private static m<JSONObject> authenticateAsync(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    y localy = m.a();
    paramParseAuthenticationProvider.authenticate(new ParseUser.22(localy));
    return localy.a();
  }
  
  public static ParseUser become(String paramString)
  {
    return (ParseUser)Parse.waitForTask(becomeInBackground(paramString));
  }
  
  public static m<ParseUser> becomeInBackground(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Must specify a sessionToken for the user to log in with");
    }
    return constructBecomeCommand(paramString).executeAsync().d(new ParseUser.8());
  }
  
  public static void becomeInBackground(String paramString, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(becomeInBackground(paramString), paramLogInCallback);
  }
  
  private static void checkApplicationContext()
  {
    if (Parse.applicationContext == null) {
      throw new RuntimeException("You must call Parse.initialize(context, oauthKey, oauthSecret) before using the Parse library.");
    }
  }
  
  static void clearCurrentUserFromMemory()
  {
    synchronized (currentUserMutex)
    {
      currentUser = null;
      currentUserMatchesDisk = false;
      return;
    }
  }
  
  private static ParseCommand constructBecomeCommand(String paramString)
  {
    return new ParseCommand("client_me", paramString);
  }
  
  private static ParseCommand constructLogInCommand(String paramString1, String paramString2)
  {
    ParseCommand localParseCommand = new ParseCommand("user_login", null);
    localParseCommand.put("username", paramString1);
    localParseCommand.put("user_password", paramString2);
    return localParseCommand;
  }
  
  private static ParseCommand constructPasswordResetCommand(String paramString1, String paramString2)
  {
    ParseCommand localParseCommand = new ParseCommand("user_request_password_reset", paramString2);
    localParseCommand.put("email", paramString1);
    return localParseCommand;
  }
  
  private ParseCommand constructSignUpCommand(ParseOperationSet paramParseOperationSet, String paramString)
  {
    ParseCommand localParseCommand = constructSaveCommand(paramParseOperationSet, PointerEncodingStrategy.get(), paramString);
    localParseCommand.setOp("user_signup");
    return localParseCommand;
  }
  
  private ParseCommand constructSignUpOrLoginCommand(ParseOperationSet paramParseOperationSet)
  {
    for (;;)
    {
      ParseCommand localParseCommand;
      JSONObject localJSONObject;
      String str;
      synchronized (this.mutex)
      {
        localParseCommand = new ParseCommand("user_signup_or_login", null);
        localJSONObject = toJSONObjectForSaving(paramParseOperationSet, PointerEncodingStrategy.get());
        Iterator localIterator = localJSONObject.keys();
        if (localIterator.hasNext()) {
          str = (String)localIterator.next();
        }
      }
      try
      {
        Object localObject3 = localJSONObject.get(str);
        if ((localObject3 instanceof JSONObject))
        {
          localParseCommand.put(str, (JSONObject)localObject3);
          continue;
        }
        if ((localObject3 instanceof JSONArray))
        {
          localParseCommand.put(str, (JSONArray)localObject3);
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        if ((localObject3 instanceof String))
        {
          localParseCommand.put(str, (String)localObject3);
          continue;
        }
        localParseCommand.put(str, localJSONObject.getInt(str));
      }
      catch (JSONException localJSONException) {}
      if (this.password != null) {
        localParseCommand.put("user_password", this.password);
      }
      return localParseCommand;
    }
  }
  
  static void disableAutomaticUser()
  {
    autoUserEnabled = false;
  }
  
  public static void enableAutomaticUser()
  {
    autoUserEnabled = true;
  }
  
  static String getCurrentSessionToken()
  {
    String str;
    synchronized (currentUserMutex)
    {
      if (getCurrentUser() != null) {
        str = getCurrentUser().getSessionToken();
      } else {
        str = null;
      }
    }
    return str;
  }
  
  public static ParseUser getCurrentUser()
  {
    ParseUser localParseUser;
    boolean bool;
    synchronized (currentUserMutex)
    {
      checkApplicationContext();
      if (currentUser != null)
      {
        localParseUser = currentUser;
      }
      else if (currentUserMatchesDisk)
      {
        if (isAutomaticUserEnabled()) {
          ParseAnonymousUtils.lazyLogIn();
        }
        localParseUser = currentUser;
      }
    }
    try
    {
      for (localParseObject = (ParseObject)Parse.waitForTask(ParseQuery.getQuery(ParseUser.class).fromPin("_currentUser", true).findInBackground((ParseUser)null).d(new ParseUser.9())); localParseObject == null; localParseObject = getFromDisk(Parse.applicationContext, "currentUser"))
      {
        if (isAutomaticUserEnabled()) {
          ParseAnonymousUtils.lazyLogIn();
        }
        localParseUser = currentUser;
        break label158;
      }
      currentUser = (ParseUser)localParseObject;
      currentUser.isCurrentUser = true;
      localParseUser = currentUser;
      label158:
      return localParseUser;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        ParseObject localParseObject = null;
      }
    }
  }
  
  public static ParseQuery<ParseUser> getQuery()
  {
    return ParseQuery.getQuery(ParseUser.class);
  }
  
  static boolean isAutomaticUserEnabled()
  {
    return autoUserEnabled;
  }
  
  private m<Void> linkWithAsync(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    return authenticateAsync(paramParseAuthenticationProvider).d(new ParseUser.28(this, paramParseAuthenticationProvider));
  }
  
  private m<Void> linkWithAsync(String paramString, JSONObject paramJSONObject, m<Void> paramm)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("anonymous");
    synchronized (this.mutex)
    {
      m localm = m.b(new ParseUser.26(this, paramString, paramJSONObject)).d(new ParseUser.25(this, paramm)).b(new ParseUser.24(this, localJSONObject, paramString));
      return localm;
    }
  }
  
  public static ParseUser logIn(String paramString1, String paramString2)
  {
    return (ParseUser)Parse.waitForTask(logInInBackground(paramString1, paramString2));
  }
  
  public static m<ParseUser> logInInBackground(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Must specify a username for the user to log in with");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Must specify a password for the user to log in with");
    }
    return constructLogInCommand(paramString1, paramString2).executeAsync().d(new ParseUser.7());
  }
  
  public static void logInInBackground(String paramString1, String paramString2, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInInBackground(paramString1, paramString2), paramLogInCallback);
  }
  
  /* Error */
  static ParseUser logInLazyUser(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: getstatic 49	com/parse/ParseUser:currentUserMutex	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: ldc 2
    //   8: invokestatic 406	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   11: checkcast 2	com/parse/ParseUser
    //   14: astore 4
    //   16: aload 4
    //   18: iconst_1
    //   19: putfield 56	com/parse/ParseUser:isCurrentUser	Z
    //   22: aload 4
    //   24: iconst_1
    //   25: putfield 54	com/parse/ParseUser:isLazy	Z
    //   28: aload 4
    //   30: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 409	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   38: pop
    //   39: aload 4
    //   41: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   44: aload_0
    //   45: invokeinterface 415 2 0
    //   50: pop
    //   51: aload 4
    //   53: putstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   56: iconst_0
    //   57: putstatic 51	com/parse/ParseUser:currentUserMatchesDisk	Z
    //   60: invokestatic 329	com/parse/OfflineStore:isEnabled	()Z
    //   63: istore 8
    //   65: iload 8
    //   67: ifeq +13 -> 80
    //   70: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   73: invokestatic 79	com/parse/ParseUser:saveCurrentUserAsync	(Lcom/parse/ParseUser;)Lm;
    //   76: invokestatic 178	com/parse/Parse:waitForTask	(Lm;)Ljava/lang/Object;
    //   79: pop
    //   80: aload_2
    //   81: monitorexit
    //   82: aload 4
    //   84: areturn
    //   85: astore 5
    //   87: new 212	java/lang/RuntimeException
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 418	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: astore_3
    //   98: aload_2
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    //   102: astore 9
    //   104: goto -24 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   0	107	1	paramJSONObject	JSONObject
    //   3	96	2	localObject1	Object
    //   97	4	3	localObject2	Object
    //   14	69	4	localParseUser	ParseUser
    //   85	7	5	localJSONException	JSONException
    //   63	3	8	bool	boolean
    //   102	1	9	localParseException	ParseException
    // Exception table:
    //   from	to	target	type
    //   28	51	85	org/json/JSONException
    //   6	28	97	finally
    //   28	51	97	finally
    //   51	65	97	finally
    //   70	80	97	finally
    //   80	100	97	finally
    //   70	80	102	com/parse/ParseException
  }
  
  private static m<ParseUser> logInWithAsync(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    return authenticateAsync(paramParseAuthenticationProvider).d(new ParseUser.23(paramParseAuthenticationProvider));
  }
  
  static m<ParseUser> logInWithAsync(String paramString)
  {
    if (!authenticationProviders.containsKey(paramString)) {
      throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
    }
    return logInWithAsync((ParseAuthenticationProvider)authenticationProviders.get(paramString));
  }
  
  /* Error */
  static m<ParseUser> logInWithAsync(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 439	com/parse/ParseUser$14
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 441	com/parse/ParseUser$14:<init>	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   9: astore_2
    //   10: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +102 -> 117
    //   18: aload_3
    //   19: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   22: astore 5
    //   24: aload 5
    //   26: monitorenter
    //   27: aload_3
    //   28: invokestatic 445	com/parse/ParseAnonymousUtils:isLinked	(Lcom/parse/ParseUser;)Z
    //   31: ifeq +83 -> 114
    //   34: aload_3
    //   35: invokevirtual 447	com/parse/ParseUser:isLazy	()Z
    //   38: ifeq +42 -> 80
    //   41: aload_3
    //   42: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   45: ldc_w 359
    //   48: invokevirtual 363	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: astore 7
    //   53: aload_3
    //   54: getfield 451	com/parse/ParseUser:taskQueue	Lcom/parse/TaskQueue;
    //   57: new 453	com/parse/ParseUser$15
    //   60: dup
    //   61: aload_3
    //   62: aload_0
    //   63: aload_1
    //   64: aload 7
    //   66: invokespecial 456	com/parse/ParseUser$15:<init>	(Lcom/parse/ParseUser;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   69: invokevirtual 461	com/parse/TaskQueue:enqueue	(Ll;)Lm;
    //   72: astore 4
    //   74: aload 5
    //   76: monitorexit
    //   77: goto +50 -> 127
    //   80: aload_3
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 463	com/parse/ParseUser:linkWithAsync	(Ljava/lang/String;Lorg/json/JSONObject;)Lm;
    //   86: new 465	com/parse/ParseUser$16
    //   89: dup
    //   90: aload_2
    //   91: aload_3
    //   92: invokespecial 468	com/parse/ParseUser$16:<init>	(Ll;Lcom/parse/ParseUser;)V
    //   95: invokevirtual 384	m:b	(Ll;)Lm;
    //   98: astore 4
    //   100: aload 5
    //   102: monitorexit
    //   103: goto +24 -> 127
    //   106: astore 6
    //   108: aload 5
    //   110: monitorexit
    //   111: aload 6
    //   113: athrow
    //   114: aload 5
    //   116: monitorexit
    //   117: aconst_null
    //   118: invokestatic 471	m:a	(Ljava/lang/Object;)Lm;
    //   121: aload_2
    //   122: invokevirtual 384	m:b	(Ll;)Lm;
    //   125: astore 4
    //   127: aload 4
    //   129: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   0	130	1	paramJSONObject	JSONObject
    //   9	113	2	local14	ParseUser.14
    //   13	79	3	localParseUser	ParseUser
    //   72	56	4	localm	m
    //   22	93	5	localObject1	Object
    //   106	6	6	localObject2	Object
    //   51	14	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   27	111	106	finally
    //   114	117	106	finally
  }
  
  /* Error */
  public static void logOut()
  {
    // Byte code:
    //   0: getstatic 49	com/parse/ParseUser:currentUserMutex	Ljava/lang/Object;
    //   3: astore_0
    //   4: aload_0
    //   5: monitorenter
    //   6: invokestatic 316	com/parse/ParseUser:checkApplicationContext	()V
    //   9: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   12: ifnull +97 -> 109
    //   15: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   18: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   21: astore 6
    //   23: aload 6
    //   25: monitorenter
    //   26: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   29: invokevirtual 476	com/parse/ParseUser:getLinkedServiceNames	()Ljava/util/Set;
    //   32: invokeinterface 479 1 0
    //   37: astore 8
    //   39: aload 8
    //   41: invokeinterface 273 1 0
    //   46: ifeq +39 -> 85
    //   49: aload 8
    //   51: invokeinterface 277 1 0
    //   56: checkcast 279	java/lang/String
    //   59: astore 9
    //   61: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   64: aload 9
    //   66: invokevirtual 482	com/parse/ParseUser:logOutWith	(Ljava/lang/String;)V
    //   69: goto -30 -> 39
    //   72: astore 7
    //   74: aload 6
    //   76: monitorexit
    //   77: aload 7
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   88: iconst_0
    //   89: putfield 56	com/parse/ParseUser:isCurrentUser	Z
    //   92: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   95: iconst_0
    //   96: putfield 123	com/parse/ParseUser:isNew	Z
    //   99: getstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   102: aconst_null
    //   103: putfield 484	com/parse/ParseUser:sessionToken	Ljava/lang/String;
    //   106: aload 6
    //   108: monitorexit
    //   109: iconst_1
    //   110: putstatic 51	com/parse/ParseUser:currentUserMatchesDisk	Z
    //   113: aconst_null
    //   114: putstatic 132	com/parse/ParseUser:currentUser	Lcom/parse/ParseUser;
    //   117: invokestatic 329	com/parse/OfflineStore:isEnabled	()Z
    //   120: istore_2
    //   121: iload_2
    //   122: ifeq +12 -> 134
    //   125: ldc 14
    //   127: invokestatic 487	com/parse/ParseObject:unpinAllInBackground	(Ljava/lang/String;)Lm;
    //   130: invokestatic 178	com/parse/Parse:waitForTask	(Lm;)Ljava/lang/Object;
    //   133: pop
    //   134: new 489	java/io/File
    //   137: dup
    //   138: invokestatic 493	com/parse/Parse:getParseDir	()Ljava/io/File;
    //   141: ldc 11
    //   143: invokespecial 496	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: invokevirtual 499	java/io/File:delete	()Z
    //   149: pop
    //   150: aload_0
    //   151: monitorexit
    //   152: return
    //   153: astore 4
    //   155: goto -21 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	148	0	localObject1	Object
    //   80	4	1	localObject2	Object
    //   120	2	2	bool	boolean
    //   153	1	4	localParseException	ParseException
    //   21	86	6	localObject3	Object
    //   72	6	7	localObject4	Object
    //   37	13	8	localIterator	Iterator
    //   59	6	9	str	String
    // Exception table:
    //   from	to	target	type
    //   26	77	72	finally
    //   85	109	72	finally
    //   6	26	80	finally
    //   77	83	80	finally
    //   109	121	80	finally
    //   125	134	80	finally
    //   134	152	80	finally
    //   125	134	153	com/parse/ParseException
  }
  
  private void logOutWith(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    paramParseAuthenticationProvider.deauthenticate();
  }
  
  static void registerAuthenticationProvider(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    authenticationProviders.put(paramParseAuthenticationProvider.getAuthType(), paramParseAuthenticationProvider);
    if (getCurrentUser() != null) {
      getCurrentUser().synchronizeAuthData(paramParseAuthenticationProvider.getAuthType());
    }
  }
  
  public static void requestPasswordReset(String paramString)
  {
    Parse.waitForTask(requestPasswordResetInBackground(paramString));
  }
  
  public static m<Void> requestPasswordResetInBackground(String paramString)
  {
    return constructPasswordResetCommand(paramString, getCurrentSessionToken()).executeAsync().j();
  }
  
  public static void requestPasswordResetInBackground(String paramString, RequestPasswordResetCallback paramRequestPasswordResetCallback)
  {
    Parse.callbackOnMainThreadAsync(requestPasswordResetInBackground(paramString), paramRequestPasswordResetCallback);
  }
  
  /* Error */
  private m<Void> resolveLazinessAsync(m<Void> paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 447	com/parse/ParseUser:isLazy	()Z
    //   11: ifne +14 -> 25
    //   14: aconst_null
    //   15: invokestatic 471	m:a	(Ljava/lang/Object;)Lm;
    //   18: astore 5
    //   20: aload_2
    //   21: monitorexit
    //   22: goto +111 -> 133
    //   25: aload_0
    //   26: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   29: invokeinterface 525 1 0
    //   34: ifne +31 -> 65
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 85	com/parse/ParseUser:signUpAsync	(Lm;)Lm;
    //   42: new 527	com/parse/ParseUser$17
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 529	com/parse/ParseUser$17:<init>	(Lcom/parse/ParseUser;)V
    //   50: invokevirtual 532	m:c	(Ll;)Lm;
    //   53: astore 5
    //   55: aload_2
    //   56: monitorexit
    //   57: goto +76 -> 133
    //   60: astore_3
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    //   65: new 534	k
    //   68: dup
    //   69: invokespecial 535	k:<init>	()V
    //   72: astore 4
    //   74: new 537	com/parse/ParseUser$21
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 538	com/parse/ParseUser$21:<init>	(Lcom/parse/ParseUser;)V
    //   82: invokestatic 372	m:b	(Ljava/util/concurrent/Callable;)Lm;
    //   85: aload_1
    //   86: invokestatic 542	com/parse/TaskQueue:waitFor	(Lm;)Ll;
    //   89: invokevirtual 200	m:d	(Ll;)Lm;
    //   92: new 544	com/parse/ParseUser$20
    //   95: dup
    //   96: aload_0
    //   97: aload 4
    //   99: invokespecial 547	com/parse/ParseUser$20:<init>	(Lcom/parse/ParseUser;Lk;)V
    //   102: invokevirtual 200	m:d	(Ll;)Lm;
    //   105: new 549	com/parse/ParseUser$19
    //   108: dup
    //   109: aload_0
    //   110: aload 4
    //   112: invokespecial 550	com/parse/ParseUser$19:<init>	(Lcom/parse/ParseUser;Lk;)V
    //   115: invokevirtual 200	m:d	(Ll;)Lm;
    //   118: new 552	com/parse/ParseUser$18
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 553	com/parse/ParseUser$18:<init>	(Lcom/parse/ParseUser;)V
    //   126: invokevirtual 200	m:d	(Ll;)Lm;
    //   129: astore 5
    //   131: aload_2
    //   132: monitorexit
    //   133: aload 5
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	ParseUser
    //   0	136	1	paramm	m<Void>
    //   4	128	2	localObject1	Object
    //   60	4	3	localObject2	Object
    //   72	39	4	localk	k
    //   18	116	5	localm	m
    // Exception table:
    //   from	to	target	type
    //   7	63	60	finally
    //   65	133	60	finally
  }
  
  /* Error */
  private void restoreAnonymity(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +28 -> 36
    //   11: aload_0
    //   12: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   15: ldc_w 359
    //   18: invokeinterface 415 2 0
    //   23: pop
    //   24: aload_0
    //   25: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   28: ldc_w 359
    //   31: aload_1
    //   32: invokevirtual 409	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   35: pop
    //   36: aload_2
    //   37: monitorexit
    //   38: return
    //   39: astore 5
    //   41: new 212	java/lang/RuntimeException
    //   44: dup
    //   45: aload 5
    //   47: invokespecial 418	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   50: athrow
    //   51: astore_3
    //   52: aload_2
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ParseUser
    //   0	56	1	paramJSONObject	JSONObject
    //   4	49	2	localObject1	Object
    //   51	4	3	localObject2	Object
    //   39	7	5	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   24	36	39	org/json/JSONException
    //   11	24	51	finally
    //   24	36	51	finally
    //   36	54	51	finally
  }
  
  private static m<Void> saveCurrentUserAsync(ParseUser paramParseUser)
  {
    for (;;)
    {
      synchronized (currentUserMutex)
      {
        checkApplicationContext();
        if (currentUser != paramParseUser) {
          logOut();
        }
        synchronized (paramParseUser.mutex)
        {
          paramParseUser.isCurrentUser = true;
          paramParseUser.synchronizeAllAuthData();
          if (OfflineStore.isEnabled())
          {
            localObject5 = ParseObject.unpinAllInBackground("_currentUser").b(new ParseUser.10(paramParseUser));
            ((m)localObject5).b(new ParseUser.12(paramParseUser));
            return localObject5;
          }
        }
      }
      m localm = m.a(null).b(new ParseUser.11(paramParseUser));
      Object localObject5 = localm;
    }
  }
  
  /* Error */
  private m<Void> signUpAsync(m<Void> paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: invokestatic 515	com/parse/ParseUser:getCurrentSessionToken	()Ljava/lang/String;
    //   10: astore 4
    //   12: aload_0
    //   13: invokevirtual 570	com/parse/ParseUser:getUsername	()Ljava/lang/String;
    //   16: ifnull +13 -> 29
    //   19: aload_0
    //   20: invokevirtual 570	com/parse/ParseUser:getUsername	()Ljava/lang/String;
    //   23: invokevirtual 573	java/lang/String:length	()I
    //   26: ifne +19 -> 45
    //   29: new 180	java/lang/IllegalArgumentException
    //   32: dup
    //   33: ldc_w 575
    //   36: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: astore_3
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_3
    //   44: athrow
    //   45: aload_0
    //   46: getfield 299	com/parse/ParseUser:password	Ljava/lang/String;
    //   49: ifnonnull +14 -> 63
    //   52: new 180	java/lang/IllegalArgumentException
    //   55: dup
    //   56: ldc_w 577
    //   59: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: aload_0
    //   64: invokevirtual 580	com/parse/ParseUser:getObjectId	()Ljava/lang/String;
    //   67: astore 5
    //   69: aload 5
    //   71: ifnull +71 -> 142
    //   74: aload_0
    //   75: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   78: ldc_w 359
    //   81: invokevirtual 584	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   84: ifeq +47 -> 131
    //   87: aload_0
    //   88: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   91: ldc_w 359
    //   94: invokevirtual 282	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   97: getstatic 587	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   100: if_acmpne +31 -> 131
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual 590	com/parse/ParseUser:saveAsync	(Lm;)Lm;
    //   108: astore 8
    //   110: aload 8
    //   112: astore 6
    //   114: aload_2
    //   115: monitorexit
    //   116: goto +189 -> 305
    //   119: astore 7
    //   121: new 212	java/lang/RuntimeException
    //   124: dup
    //   125: aload 7
    //   127: invokespecial 418	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   130: athrow
    //   131: new 180	java/lang/IllegalArgumentException
    //   134: dup
    //   135: ldc_w 592
    //   138: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   141: athrow
    //   142: aload_0
    //   143: getfield 596	com/parse/ParseUser:operationSetQueue	Ljava/util/LinkedList;
    //   146: invokevirtual 599	java/util/LinkedList:size	()I
    //   149: iconst_1
    //   150: if_icmple +14 -> 164
    //   153: new 180	java/lang/IllegalArgumentException
    //   156: dup
    //   157: ldc_w 601
    //   160: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   163: athrow
    //   164: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   167: ifnull +103 -> 270
    //   170: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   173: invokestatic 445	com/parse/ParseAnonymousUtils:isLinked	(Lcom/parse/ParseUser;)Z
    //   176: ifeq +94 -> 270
    //   179: aload_0
    //   180: invokevirtual 603	com/parse/ParseUser:isCurrentUser	()Z
    //   183: ifeq +14 -> 197
    //   186: new 180	java/lang/IllegalArgumentException
    //   189: dup
    //   190: ldc_w 605
    //   193: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: aload_0
    //   198: invokevirtual 608	com/parse/ParseUser:checkForChangesToMutableContainers	()V
    //   201: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   204: invokevirtual 608	com/parse/ParseUser:checkForChangesToMutableContainers	()V
    //   207: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   210: aload_0
    //   211: invokevirtual 612	com/parse/ParseUser:copyChangesFrom	(Lcom/parse/ParseObject;)V
    //   214: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   217: iconst_1
    //   218: putfield 126	com/parse/ParseUser:dirty	Z
    //   221: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   224: aload_0
    //   225: getfield 299	com/parse/ParseUser:password	Ljava/lang/String;
    //   228: invokevirtual 615	com/parse/ParseUser:setPassword	(Ljava/lang/String;)V
    //   231: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   234: aload_0
    //   235: invokevirtual 570	com/parse/ParseUser:getUsername	()Ljava/lang/String;
    //   238: invokevirtual 618	com/parse/ParseUser:setUsername	(Ljava/lang/String;)V
    //   241: aload_0
    //   242: invokevirtual 621	com/parse/ParseUser:revert	()V
    //   245: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   248: aload_1
    //   249: invokevirtual 590	com/parse/ParseUser:saveAsync	(Lm;)Lm;
    //   252: new 623	com/parse/ParseUser$4
    //   255: dup
    //   256: aload_0
    //   257: invokespecial 624	com/parse/ParseUser$4:<init>	(Lcom/parse/ParseUser;)V
    //   260: invokevirtual 200	m:d	(Ll;)Lm;
    //   263: astore 6
    //   265: aload_2
    //   266: monitorexit
    //   267: goto +38 -> 305
    //   270: new 626	com/parse/ParseUser$6
    //   273: dup
    //   274: aload_0
    //   275: invokespecial 627	com/parse/ParseUser$6:<init>	(Lcom/parse/ParseUser;)V
    //   278: invokestatic 372	m:b	(Ljava/util/concurrent/Callable;)Lm;
    //   281: aload_1
    //   282: invokestatic 542	com/parse/TaskQueue:waitFor	(Lm;)Ll;
    //   285: invokevirtual 384	m:b	(Ll;)Lm;
    //   288: new 629	com/parse/ParseUser$5
    //   291: dup
    //   292: aload_0
    //   293: aload 4
    //   295: invokespecial 631	com/parse/ParseUser$5:<init>	(Lcom/parse/ParseUser;Ljava/lang/String;)V
    //   298: invokevirtual 200	m:d	(Ll;)Lm;
    //   301: astore 6
    //   303: aload_2
    //   304: monitorexit
    //   305: aload 6
    //   307: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ParseUser
    //   0	308	1	paramm	m<Void>
    //   4	300	2	localObject1	Object
    //   40	4	3	localObject2	Object
    //   10	284	4	str1	String
    //   67	3	5	str2	String
    //   112	194	6	localm1	m
    //   119	7	7	localJSONException	JSONException
    //   108	3	8	localm2	m
    // Exception table:
    //   from	to	target	type
    //   7	43	40	finally
    //   45	69	40	finally
    //   74	110	40	finally
    //   114	305	40	finally
    //   74	110	119	org/json/JSONException
  }
  
  private void stripAnonymity()
  {
    synchronized (this.mutex)
    {
      if (ParseAnonymousUtils.isLinked(this)) {
        this.linkedServiceNames.remove("anonymous");
      }
      try
      {
        this.authData.put("anonymous", JSONObject.NULL);
        this.dirty = true;
        return;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
    }
  }
  
  /* Error */
  private void synchronizeAllAuthData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   11: ifnull +41 -> 52
    //   14: aload_0
    //   15: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   18: invokevirtual 267	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface 273 1 0
    //   28: ifeq +24 -> 52
    //   31: aload_0
    //   32: aload_3
    //   33: invokeinterface 277 1 0
    //   38: checkcast 279	java/lang/String
    //   41: invokespecial 91	com/parse/ParseUser:synchronizeAuthData	(Ljava/lang/String;)V
    //   44: goto -22 -> 22
    //   47: astore_2
    //   48: aload_1
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    //   52: aload_1
    //   53: monitorexit
    //   54: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ParseUser
    //   4	49	1	localObject1	Object
    //   47	4	2	localObject2	Object
    //   21	12	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   7	50	47	finally
    //   52	54	47	finally
  }
  
  /* Error */
  private void synchronizeAuthData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 603	com/parse/ParseUser:isCurrentUser	()Z
    //   11: ifne +8 -> 19
    //   14: aload_2
    //   15: monitorexit
    //   16: goto +71 -> 87
    //   19: getstatic 44	com/parse/ParseUser:authenticationProviders	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 429 2 0
    //   28: ifne +13 -> 41
    //   31: aload_2
    //   32: monitorexit
    //   33: goto +54 -> 87
    //   36: astore_3
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_3
    //   40: athrow
    //   41: getstatic 44	com/parse/ParseUser:authenticationProviders	Ljava/util/Map;
    //   44: aload_1
    //   45: invokeinterface 434 2 0
    //   50: checkcast 157	com/parse/ParseAuthenticationProvider
    //   53: astore 4
    //   55: aload 4
    //   57: aload_0
    //   58: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   61: aload 4
    //   63: invokeinterface 506 1 0
    //   68: invokevirtual 363	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   71: invokeinterface 638 2 0
    //   76: ifne +9 -> 85
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 641	com/parse/ParseUser:unlinkFromAsync	(Ljava/lang/String;)Lm;
    //   84: pop
    //   85: aload_2
    //   86: monitorexit
    //   87: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ParseUser
    //   0	88	1	paramString	String
    //   4	82	2	localObject1	Object
    //   36	4	3	localObject2	Object
    //   53	9	4	localParseAuthenticationProvider	ParseAuthenticationProvider
    // Exception table:
    //   from	to	target	type
    //   7	39	36	finally
    //   41	87	36	finally
  }
  
  /* Error */
  void cleanUpAuthData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 603	com/parse/ParseUser:isCurrentUser	()Z
    //   11: ifne +8 -> 19
    //   14: aload_1
    //   15: monitorexit
    //   16: goto +104 -> 120
    //   19: aload_0
    //   20: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   23: invokevirtual 267	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   26: astore_3
    //   27: aload_3
    //   28: invokeinterface 273 1 0
    //   33: ifeq +85 -> 118
    //   36: aload_3
    //   37: invokeinterface 277 1 0
    //   42: checkcast 279	java/lang/String
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   51: aload 4
    //   53: invokevirtual 645	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   56: ifeq -29 -> 27
    //   59: aload_3
    //   60: invokeinterface 647 1 0
    //   65: aload_0
    //   66: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   69: aload 4
    //   71: invokeinterface 634 2 0
    //   76: pop
    //   77: getstatic 44	com/parse/ParseUser:authenticationProviders	Ljava/util/Map;
    //   80: aload 4
    //   82: invokeinterface 429 2 0
    //   87: ifeq -60 -> 27
    //   90: getstatic 44	com/parse/ParseUser:authenticationProviders	Ljava/util/Map;
    //   93: aload 4
    //   95: invokeinterface 434 2 0
    //   100: checkcast 157	com/parse/ParseAuthenticationProvider
    //   103: aconst_null
    //   104: invokeinterface 638 2 0
    //   109: pop
    //   110: goto -83 -> 27
    //   113: astore_2
    //   114: aload_1
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: aload_1
    //   119: monitorexit
    //   120: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	ParseUser
    //   4	115	1	localObject1	Object
    //   113	4	2	localObject2	Object
    //   26	34	3	localIterator	Iterator
    //   45	49	4	str	String
    // Exception table:
    //   from	to	target	type
    //   7	116	113	finally
    //   118	120	113	finally
  }
  
  ParseCommand constructSaveCommand(ParseOperationSet paramParseOperationSet, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy, String paramString)
  {
    ParseCommand localParseCommand;
    synchronized (this.mutex)
    {
      localParseCommand = super.constructSaveCommand(paramParseOperationSet, paramParseObjectEncodingStrategy, paramString);
      if (localParseCommand == null)
      {
        localParseCommand = null;
      }
      else
      {
        if (this.password != null) {
          localParseCommand.put("user_password", this.password);
        }
        if (this.authData.length() > 0) {
          localParseCommand.put("auth_data", this.authData);
        }
      }
    }
    return localParseCommand;
  }
  
  public ParseUser fetch()
  {
    return (ParseUser)super.fetch();
  }
  
  <T extends ParseObject> m<T> fetchAsync(m<Void> paramm)
  {
    m localm;
    synchronized (this.mutex)
    {
      if (isLazy()) {
        localm = m.a(this);
      } else {
        localm = super.fetchAsync(paramm).d(new ParseUser.2(this));
      }
    }
    return localm;
  }
  
  public ParseUser fetchIfNeeded()
  {
    return (ParseUser)super.fetchIfNeeded();
  }
  
  public String getEmail()
  {
    return getString("email");
  }
  
  Set<String> getLinkedServiceNames()
  {
    synchronized (this.mutex)
    {
      Set localSet = this.readOnlyLinkedServiceNames;
      return localSet;
    }
  }
  
  public String getSessionToken()
  {
    synchronized (this.mutex)
    {
      String str = this.sessionToken;
      return str;
    }
  }
  
  public String getUsername()
  {
    return getString("username");
  }
  
  public boolean isAuthenticated()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        ParseUser localParseUser = getCurrentUser();
        if (!isLazy())
        {
          if ((this.sessionToken == null) || (localParseUser == null) || (!getObjectId().equals(localParseUser.getObjectId()))) {
            break label62;
          }
          break label56;
          return bool;
        }
      }
      label56:
      boolean bool = true;
      continue;
      label62:
      bool = false;
    }
  }
  
  boolean isCurrentUser()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isCurrentUser;
      return bool;
    }
  }
  
  boolean isDirty(boolean paramBoolean)
  {
    if ((this.dirty) || (super.isDirty(paramBoolean))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isLazy()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isLazy;
      return bool;
    }
  }
  
  public boolean isNew()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isNew;
      return bool;
    }
  }
  
  m<Void> linkWithAsync(String paramString)
  {
    if (!authenticationProviders.containsKey(paramString)) {
      throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
    }
    return linkWithAsync((ParseAuthenticationProvider)authenticationProviders.get(paramString));
  }
  
  m<Void> linkWithAsync(String paramString, JSONObject paramJSONObject)
  {
    return this.taskQueue.enqueue(new ParseUser.27(this, paramString, paramJSONObject));
  }
  
  void logOutWith(String paramString)
  {
    synchronized (this.mutex)
    {
      if ((authenticationProviders.containsKey(paramString)) && (this.linkedServiceNames.contains(paramString))) {
        logOutWith((ParseAuthenticationProvider)authenticationProviders.get(paramString));
      }
      return;
    }
  }
  
  /* Error */
  void mergeFromObject(ParseObject paramParseObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 693	com/parse/ParseObject:mergeFromObject	(Lcom/parse/ParseObject;)V
    //   12: aload_1
    //   13: instanceof 2
    //   16: ifeq +169 -> 185
    //   19: aload_0
    //   20: aload_1
    //   21: checkcast 2	com/parse/ParseUser
    //   24: getfield 484	com/parse/ParseUser:sessionToken	Ljava/lang/String;
    //   27: putfield 484	com/parse/ParseUser:sessionToken	Ljava/lang/String;
    //   30: aload_0
    //   31: aload_1
    //   32: checkcast 2	com/parse/ParseUser
    //   35: invokevirtual 695	com/parse/ParseUser:isNew	()Z
    //   38: putfield 123	com/parse/ParseUser:isNew	Z
    //   41: aload_0
    //   42: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   45: invokevirtual 267	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   48: astore 4
    //   50: aload 4
    //   52: invokeinterface 273 1 0
    //   57: ifeq +26 -> 83
    //   60: aload 4
    //   62: invokeinterface 277 1 0
    //   67: pop
    //   68: aload 4
    //   70: invokeinterface 647 1 0
    //   75: goto -25 -> 50
    //   78: astore_3
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_3
    //   82: athrow
    //   83: aload_1
    //   84: checkcast 2	com/parse/ParseUser
    //   87: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   90: invokevirtual 267	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   93: astore 5
    //   95: aload 5
    //   97: invokeinterface 273 1 0
    //   102: ifeq +57 -> 159
    //   105: aload 5
    //   107: invokeinterface 277 1 0
    //   112: checkcast 279	java/lang/String
    //   115: astore 7
    //   117: aload_1
    //   118: checkcast 2	com/parse/ParseUser
    //   121: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   124: aload 7
    //   126: invokevirtual 282	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   129: astore 9
    //   131: aload_0
    //   132: getfield 61	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   135: aload 7
    //   137: aload 9
    //   139: invokevirtual 409	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   142: pop
    //   143: goto -48 -> 95
    //   146: astore 8
    //   148: new 212	java/lang/RuntimeException
    //   151: dup
    //   152: ldc_w 697
    //   155: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   158: athrow
    //   159: aload_0
    //   160: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   163: invokeinterface 700 1 0
    //   168: aload_0
    //   169: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   172: aload_1
    //   173: checkcast 2	com/parse/ParseUser
    //   176: getfield 66	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   179: invokeinterface 704 2 0
    //   184: pop
    //   185: aload_2
    //   186: monitorexit
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	ParseUser
    //   0	188	1	paramParseObject	ParseObject
    //   4	182	2	localObject1	Object
    //   78	4	3	localObject2	Object
    //   48	21	4	localIterator1	Iterator
    //   93	13	5	localIterator2	Iterator
    //   115	21	7	str	String
    //   146	1	8	localJSONException	JSONException
    //   129	9	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	81	78	finally
    //   83	117	78	finally
    //   117	143	78	finally
    //   148	187	78	finally
    //   117	143	146	org/json/JSONException
  }
  
  void mergeFromServer(JSONObject paramJSONObject, ParseDecoder paramParseDecoder, boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      super.mergeFromServer(paramJSONObject, paramParseDecoder, paramBoolean);
      boolean bool1 = paramJSONObject.has("session_token");
      if (!bool1) {}
    }
    try
    {
      this.sessionToken = paramJSONObject.getString("session_token");
      boolean bool2 = paramJSONObject.has("auth_data");
      if (bool2)
      {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject("auth_data");
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            this.authData.put(str, localJSONObject.get(str));
            if (!localJSONObject.isNull(str)) {
              this.linkedServiceNames.add(str);
            }
            synchronizeAuthData(str);
          }
          localObject2 = finally;
        }
        catch (JSONException localJSONException2)
        {
          throw new RuntimeException(localJSONException2);
        }
        throw localObject2;
      }
    }
    catch (JSONException localJSONException3)
    {
      throw new RuntimeException(localJSONException3.getMessage());
    }
    boolean bool3 = paramJSONObject.has("is_new");
    if (bool3) {}
    try
    {
      this.isNew = paramJSONObject.getBoolean("is_new");
      return;
    }
    catch (JSONException localJSONException1)
    {
      throw new RuntimeException(localJSONException1);
    }
  }
  
  void mergeREST(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    synchronized (this.mutex)
    {
      super.mergeREST(paramJSONObject, paramParseDecoder);
      boolean bool1 = paramJSONObject.has("sessionToken");
      if (!bool1) {}
    }
    try
    {
      this.sessionToken = paramJSONObject.getString("sessionToken");
      boolean bool2 = paramJSONObject.has("authData");
      if (bool2)
      {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject("authData");
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            this.authData.put(str, localJSONObject.get(str));
            if (!localJSONObject.isNull(str)) {
              this.linkedServiceNames.add(str);
            }
            synchronizeAuthData(str);
          }
          localObject2 = finally;
        }
        catch (JSONException localJSONException2)
        {
          throw new RuntimeException(localJSONException2);
        }
        throw localObject2;
      }
    }
    catch (JSONException localJSONException3)
    {
      throw new RuntimeException(localJSONException3.getMessage());
    }
    boolean bool3 = paramJSONObject.has("isNew");
    if (bool3) {}
    try
    {
      this.isNew = paramJSONObject.getBoolean("isNew");
      return;
    }
    catch (JSONException localJSONException1)
    {
      throw new RuntimeException(localJSONException1);
    }
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  public void put(String paramString, Object paramObject)
  {
    synchronized (this.mutex)
    {
      if ("username".equals(paramString)) {
        stripAnonymity();
      }
      super.put(paramString, paramObject);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    if ("username".equals(paramString)) {
      throw new IllegalArgumentException("Can't remove the username key.");
    }
    super.remove(paramString);
  }
  
  m<Void> saveAsync(m<Void> paramm)
  {
    synchronized (this.mutex)
    {
      if (isLazy())
      {
        localm1 = resolveLazinessAsync(paramm);
        m localm2 = localm1.d(new ParseUser.1(this));
        return localm2;
      }
      m localm1 = super.saveAsync(paramm);
    }
  }
  
  public void setEmail(String paramString)
  {
    put("email", paramString);
  }
  
  public void setPassword(String paramString)
  {
    synchronized (this.mutex)
    {
      this.password = paramString;
      this.dirty = true;
      return;
    }
  }
  
  public void setUsername(String paramString)
  {
    put("username", paramString);
  }
  
  public void signUp()
  {
    Parse.waitForTask(signUpInBackground());
  }
  
  public m<Void> signUpInBackground()
  {
    return this.taskQueue.enqueue(new ParseUser.3(this));
  }
  
  public void signUpInBackground(SignUpCallback paramSignUpCallback)
  {
    Parse.callbackOnMainThreadAsync(signUpInBackground(), paramSignUpCallback);
  }
  
  JSONObject toJSONObjectForDataFile(boolean paramBoolean, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    synchronized (this.mutex)
    {
      JSONObject localJSONObject = super.toJSONObjectForDataFile(paramBoolean, paramParseObjectEncodingStrategy);
      String str = this.sessionToken;
      if (str != null) {}
      try
      {
        localJSONObject.put("session_token", this.sessionToken);
        int i = this.authData.length();
        if (i > 0) {}
        localObject2 = finally;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          localJSONObject.put("auth_data", this.authData);
          return localJSONObject;
        }
        catch (JSONException localJSONException1)
        {
          throw new RuntimeException("could not attach key: auth_data");
        }
        localJSONException2 = localJSONException2;
        throw new RuntimeException("could not encode value for key: session_token");
      }
    }
  }
  
  JSONObject toJSONObjectForSaving(ParseOperationSet paramParseOperationSet, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    synchronized (this.mutex)
    {
      JSONObject localJSONObject = super.toJSONObjectForSaving(paramParseOperationSet, paramParseObjectEncodingStrategy);
      String str = this.sessionToken;
      if (str != null) {}
      try
      {
        localJSONObject.put("session_token", this.sessionToken);
        int i = this.authData.length();
        if (i > 0) {}
        localObject2 = finally;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          localJSONObject.put("auth_data", this.authData);
          return localJSONObject;
        }
        catch (JSONException localJSONException1)
        {
          throw new RuntimeException("could not attach key: auth_data");
        }
        localJSONException2 = localJSONException2;
        throw new RuntimeException("could not encode value for key: session_token");
      }
    }
  }
  
  JSONObject toRest(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    synchronized (this.mutex)
    {
      JSONObject localJSONObject = super.toRest(paramParseObjectEncodingStrategy);
      String str = this.sessionToken;
      if (str != null) {}
      try
      {
        localJSONObject.put("sessionToken", this.sessionToken);
        int i = this.authData.length();
        if (i > 0) {}
        localObject2 = finally;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          localJSONObject.put("authData", this.authData);
          return localJSONObject;
        }
        catch (JSONException localJSONException1)
        {
          throw new RuntimeException("could not attach key: authData");
        }
        localJSONException2 = localJSONException2;
        throw new RuntimeException("could not encode value for key: sessionToken");
      }
    }
  }
  
  m<Void> unlinkFromAsync(String paramString)
  {
    Object localObject1 = this.mutex;
    if (paramString == null) {}
    m localm;
    try
    {
      localm = m.a(null);
      break label50;
      localm = m.a(null).b(new ParseUser.13(this, paramString));
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
    label50:
    return localm;
  }
  
  /* Error */
  void validateDelete()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokespecial 774	com/parse/ParseObject:validateDelete	()V
    //   11: aload_0
    //   12: invokevirtual 776	com/parse/ParseUser:isAuthenticated	()Z
    //   15: ifne +26 -> 41
    //   18: aload_0
    //   19: invokevirtual 778	com/parse/ParseUser:isDirty	()Z
    //   22: ifeq +19 -> 41
    //   25: new 180	java/lang/IllegalArgumentException
    //   28: dup
    //   29: ldc_w 780
    //   32: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: astore_2
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    //   41: aload_1
    //   42: monitorexit
    //   43: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ParseUser
    //   4	38	1	localObject1	Object
    //   36	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	39	36	finally
    //   41	43	36	finally
  }
  
  /* Error */
  void validateSave()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 580	com/parse/ParseUser:getObjectId	()Ljava/lang/String;
    //   11: ifnonnull +19 -> 30
    //   14: new 180	java/lang/IllegalArgumentException
    //   17: dup
    //   18: ldc_w 783
    //   21: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: astore_2
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    //   30: aload_0
    //   31: invokevirtual 776	com/parse/ParseUser:isAuthenticated	()Z
    //   34: ifne +37 -> 71
    //   37: aload_0
    //   38: invokevirtual 778	com/parse/ParseUser:isDirty	()Z
    //   41: ifeq +30 -> 71
    //   44: aload_0
    //   45: invokevirtual 580	com/parse/ParseUser:getObjectId	()Ljava/lang/String;
    //   48: invokestatic 309	com/parse/ParseUser:getCurrentUser	()Lcom/parse/ParseUser;
    //   51: invokevirtual 580	com/parse/ParseUser:getObjectId	()Ljava/lang/String;
    //   54: invokevirtual 677	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifne +14 -> 71
    //   60: new 180	java/lang/IllegalArgumentException
    //   63: dup
    //   64: ldc_w 785
    //   67: invokespecial 184	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: aload_1
    //   72: monitorexit
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ParseUser
    //   4	68	1	localObject1	Object
    //   25	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	28	25	finally
    //   30	73	25	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser
 * JD-Core Version:    0.7.0.1
 */