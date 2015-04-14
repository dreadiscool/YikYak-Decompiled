package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthNotAuthorizedException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractOAuthProvider
  implements OAuthProvider
{
  private static final long serialVersionUID = 1L;
  private String accessTokenEndpointUrl;
  private String authorizationWebsiteUrl;
  private Map<String, String> defaultHeaders;
  private boolean isOAuth10a;
  private transient OAuthProviderListener listener;
  private String requestTokenEndpointUrl;
  private HttpParameters responseParameters;
  
  public AbstractOAuthProvider(String paramString1, String paramString2, String paramString3)
  {
    this.requestTokenEndpointUrl = paramString1;
    this.accessTokenEndpointUrl = paramString2;
    this.authorizationWebsiteUrl = paramString3;
    this.responseParameters = new HttpParameters();
    this.defaultHeaders = new HashMap();
  }
  
  public void closeConnection(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse) {}
  
  public abstract HttpRequest createRequest(String paramString);
  
  public String getAccessTokenEndpointUrl()
  {
    return this.accessTokenEndpointUrl;
  }
  
  public String getAuthorizationWebsiteUrl()
  {
    return this.authorizationWebsiteUrl;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.defaultHeaders;
  }
  
  public String getRequestTokenEndpointUrl()
  {
    return this.requestTokenEndpointUrl;
  }
  
  protected String getResponseParameter(String paramString)
  {
    return this.responseParameters.getFirst(paramString);
  }
  
  public HttpParameters getResponseParameters()
  {
    return this.responseParameters;
  }
  
  protected void handleUnexpectedResponse(int paramInt, HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return;
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramHttpResponse.getContent()), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    switch (paramInt)
    {
    default: 
      throw new OAuthCommunicationException("Service provider responded in error: " + paramInt + " (" + paramHttpResponse.getReasonPhrase() + ")", localStringBuilder.toString());
    }
    throw new OAuthNotAuthorizedException(localStringBuilder.toString());
  }
  
  public boolean isOAuth10a()
  {
    return this.isOAuth10a;
  }
  
  public void removeListener(OAuthProviderListener paramOAuthProviderListener)
  {
    this.listener = null;
  }
  
  public void retrieveAccessToken(OAuthConsumer paramOAuthConsumer, String paramString)
  {
    if ((paramOAuthConsumer.getToken() == null) || (paramOAuthConsumer.getTokenSecret() == null)) {
      throw new OAuthExpectationFailedException("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
    }
    if ((this.isOAuth10a) && (paramString != null))
    {
      String str = this.accessTokenEndpointUrl;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "oauth_verifier";
      arrayOfString[1] = paramString;
      retrieveToken(paramOAuthConsumer, str, arrayOfString);
    }
    for (;;)
    {
      return;
      retrieveToken(paramOAuthConsumer, this.accessTokenEndpointUrl, new String[0]);
    }
  }
  
  public String retrieveRequestToken(OAuthConsumer paramOAuthConsumer, String paramString)
  {
    paramOAuthConsumer.setTokenWithSecret(null, null);
    String str1 = this.requestTokenEndpointUrl;
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "oauth_callback";
    arrayOfString1[1] = paramString;
    retrieveToken(paramOAuthConsumer, str1, arrayOfString1);
    String str2 = this.responseParameters.getFirst("oauth_callback_confirmed");
    this.responseParameters.remove("oauth_callback_confirmed");
    this.isOAuth10a = Boolean.TRUE.toString().equals(str2);
    String str5;
    String[] arrayOfString3;
    if (this.isOAuth10a)
    {
      str5 = this.authorizationWebsiteUrl;
      arrayOfString3 = new String[2];
      arrayOfString3[0] = "oauth_token";
      arrayOfString3[1] = paramOAuthConsumer.getToken();
    }
    String str3;
    String[] arrayOfString2;
    for (String str4 = OAuth.addQueryParameters(str5, arrayOfString3);; str4 = OAuth.addQueryParameters(str3, arrayOfString2))
    {
      return str4;
      str3 = this.authorizationWebsiteUrl;
      arrayOfString2 = new String[4];
      arrayOfString2[0] = "oauth_token";
      arrayOfString2[1] = paramOAuthConsumer.getToken();
      arrayOfString2[2] = "oauth_callback";
      arrayOfString2[3] = paramString;
    }
  }
  
  /* Error */
  protected void retrieveToken(OAuthConsumer paramOAuthConsumer, String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 181	com/parse/signpost/AbstractOAuthProvider:getRequestHeaders	()Ljava/util/Map;
    //   7: astore 5
    //   9: aload_1
    //   10: invokeinterface 184 1 0
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokeinterface 187 1 0
    //   24: ifnonnull +13 -> 37
    //   27: new 134	com/parse/signpost/exception/OAuthExpectationFailedException
    //   30: dup
    //   31: ldc 189
    //   33: invokespecial 137	com/parse/signpost/exception/OAuthExpectationFailedException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: aload_0
    //   38: aload_2
    //   39: invokevirtual 191	com/parse/signpost/AbstractOAuthProvider:createRequest	(Ljava/lang/String;)Lcom/parse/signpost/http/HttpRequest;
    //   42: astore 13
    //   44: aload 13
    //   46: astore 9
    //   48: aload 5
    //   50: invokeinterface 197 1 0
    //   55: invokeinterface 203 1 0
    //   60: astore 14
    //   62: aload 14
    //   64: invokeinterface 208 1 0
    //   69: ifeq +72 -> 141
    //   72: aload 14
    //   74: invokeinterface 212 1 0
    //   79: checkcast 139	java/lang/String
    //   82: astore 28
    //   84: aload 9
    //   86: aload 28
    //   88: aload 5
    //   90: aload 28
    //   92: invokeinterface 216 2 0
    //   97: checkcast 139	java/lang/String
    //   100: invokeinterface 221 3 0
    //   105: goto -43 -> 62
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 7
    //   113: aload 9
    //   115: astore 4
    //   117: aload 6
    //   119: athrow
    //   120: astore 8
    //   122: aload 4
    //   124: astore 9
    //   126: aload 7
    //   128: astore 4
    //   130: aload_0
    //   131: aload 9
    //   133: aload 4
    //   135: invokevirtual 223	com/parse/signpost/AbstractOAuthProvider:closeConnection	(Lcom/parse/signpost/http/HttpRequest;Lcom/parse/signpost/http/HttpResponse;)V
    //   138: aload 8
    //   140: athrow
    //   141: aload_3
    //   142: ifnull +27 -> 169
    //   145: new 36	com/parse/signpost/http/HttpParameters
    //   148: dup
    //   149: invokespecial 37	com/parse/signpost/http/HttpParameters:<init>	()V
    //   152: astore 27
    //   154: aload 27
    //   156: aload_3
    //   157: iconst_1
    //   158: invokevirtual 227	com/parse/signpost/http/HttpParameters:putAll	([Ljava/lang/String;Z)V
    //   161: aload_1
    //   162: aload 27
    //   164: invokeinterface 231 2 0
    //   169: aload_0
    //   170: getfield 122	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   173: ifnull +14 -> 187
    //   176: aload_0
    //   177: getfield 122	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   180: aload 9
    //   182: invokeinterface 237 2 0
    //   187: aload_1
    //   188: aload 9
    //   190: invokeinterface 241 2 0
    //   195: pop
    //   196: aload_0
    //   197: getfield 122	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   200: ifnull +14 -> 214
    //   203: aload_0
    //   204: getfield 122	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   207: aload 9
    //   209: invokeinterface 244 2 0
    //   214: aload_0
    //   215: aload 9
    //   217: invokevirtual 248	com/parse/signpost/AbstractOAuthProvider:sendRequest	(Lcom/parse/signpost/http/HttpRequest;)Lcom/parse/signpost/http/HttpResponse;
    //   220: astore 16
    //   222: aload 16
    //   224: astore 7
    //   226: aload 7
    //   228: invokeinterface 252 1 0
    //   233: istore 17
    //   235: iconst_0
    //   236: istore 18
    //   238: aload_0
    //   239: getfield 122	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   242: ifnull +22 -> 264
    //   245: aload_0
    //   246: getfield 122	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   249: aload 9
    //   251: aload 7
    //   253: invokeinterface 256 3 0
    //   258: istore 26
    //   260: iload 26
    //   262: istore 18
    //   264: iload 18
    //   266: ifeq +24 -> 290
    //   269: aload_0
    //   270: aload 9
    //   272: aload 7
    //   274: invokevirtual 223	com/parse/signpost/AbstractOAuthProvider:closeConnection	(Lcom/parse/signpost/http/HttpRequest;Lcom/parse/signpost/http/HttpResponse;)V
    //   277: return
    //   278: astore 25
    //   280: new 92	com/parse/signpost/exception/OAuthCommunicationException
    //   283: dup
    //   284: aload 25
    //   286: invokespecial 259	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   289: athrow
    //   290: iload 17
    //   292: sipush 300
    //   295: if_icmplt +11 -> 306
    //   298: aload_0
    //   299: iload 17
    //   301: aload 7
    //   303: invokevirtual 261	com/parse/signpost/AbstractOAuthProvider:handleUnexpectedResponse	(ILcom/parse/signpost/http/HttpResponse;)V
    //   306: aload 7
    //   308: invokeinterface 74 1 0
    //   313: invokestatic 265	com/parse/signpost/OAuth:decodeForm	(Ljava/io/InputStream;)Lcom/parse/signpost/http/HttpParameters;
    //   316: astore 19
    //   318: aload 19
    //   320: ldc 171
    //   322: invokevirtual 60	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
    //   325: astore 20
    //   327: aload 19
    //   329: ldc_w 267
    //   332: invokevirtual 60	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
    //   335: astore 21
    //   337: aload 19
    //   339: ldc 171
    //   341: invokevirtual 158	com/parse/signpost/http/HttpParameters:remove	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   344: pop
    //   345: aload 19
    //   347: ldc_w 267
    //   350: invokevirtual 158	com/parse/signpost/http/HttpParameters:remove	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   353: pop
    //   354: aload_0
    //   355: aload 19
    //   357: invokevirtual 270	com/parse/signpost/AbstractOAuthProvider:setResponseParameters	(Lcom/parse/signpost/http/HttpParameters;)V
    //   360: aload 20
    //   362: ifnull +8 -> 370
    //   365: aload 21
    //   367: ifnonnull +14 -> 381
    //   370: new 134	com/parse/signpost/exception/OAuthExpectationFailedException
    //   373: dup
    //   374: ldc_w 272
    //   377: invokespecial 137	com/parse/signpost/exception/OAuthExpectationFailedException:<init>	(Ljava/lang/String;)V
    //   380: athrow
    //   381: aload_1
    //   382: aload 20
    //   384: aload 21
    //   386: invokeinterface 150 3 0
    //   391: aload_0
    //   392: aload 9
    //   394: aload 7
    //   396: invokevirtual 223	com/parse/signpost/AbstractOAuthProvider:closeConnection	(Lcom/parse/signpost/http/HttpRequest;Lcom/parse/signpost/http/HttpResponse;)V
    //   399: goto -122 -> 277
    //   402: astore 24
    //   404: new 92	com/parse/signpost/exception/OAuthCommunicationException
    //   407: dup
    //   408: aload 24
    //   410: invokespecial 259	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   413: athrow
    //   414: astore 12
    //   416: aconst_null
    //   417: astore 9
    //   419: aload 12
    //   421: athrow
    //   422: new 92	com/parse/signpost/exception/OAuthCommunicationException
    //   425: dup
    //   426: aload 11
    //   428: invokespecial 259	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   431: athrow
    //   432: astore 10
    //   434: new 92	com/parse/signpost/exception/OAuthCommunicationException
    //   437: dup
    //   438: aload 10
    //   440: invokespecial 259	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   443: athrow
    //   444: astore 8
    //   446: aconst_null
    //   447: astore 9
    //   449: goto -319 -> 130
    //   452: astore 8
    //   454: aload 7
    //   456: astore 4
    //   458: goto -328 -> 130
    //   461: astore 11
    //   463: goto -41 -> 422
    //   466: astore 11
    //   468: aload 7
    //   470: astore 4
    //   472: goto -50 -> 422
    //   475: astore 12
    //   477: goto -58 -> 419
    //   480: astore 12
    //   482: aload 7
    //   484: astore 4
    //   486: goto -67 -> 419
    //   489: astore 6
    //   491: aconst_null
    //   492: astore 7
    //   494: goto -377 -> 117
    //   497: astore 6
    //   499: aload 9
    //   501: astore 4
    //   503: goto -386 -> 117
    //   506: astore 8
    //   508: goto -378 -> 130
    //   511: astore 11
    //   513: aconst_null
    //   514: astore 9
    //   516: goto -94 -> 422
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	AbstractOAuthProvider
    //   0	519	1	paramOAuthConsumer	OAuthConsumer
    //   0	519	2	paramString	String
    //   0	519	3	paramVarArgs	String[]
    //   1	501	4	localObject1	Object
    //   7	82	5	localMap	Map
    //   108	10	6	localOAuthNotAuthorizedException1	OAuthNotAuthorizedException
    //   489	1	6	localOAuthNotAuthorizedException2	OAuthNotAuthorizedException
    //   497	1	6	localOAuthNotAuthorizedException3	OAuthNotAuthorizedException
    //   111	382	7	localObject2	Object
    //   120	19	8	localObject3	Object
    //   444	1	8	localObject4	Object
    //   452	1	8	localObject5	Object
    //   506	1	8	localObject6	Object
    //   46	469	9	localObject7	Object
    //   432	7	10	localException1	java.lang.Exception
    //   426	1	11	localException2	java.lang.Exception
    //   461	1	11	localException3	java.lang.Exception
    //   466	1	11	localException4	java.lang.Exception
    //   511	1	11	localException5	java.lang.Exception
    //   414	6	12	localOAuthExpectationFailedException1	OAuthExpectationFailedException
    //   475	1	12	localOAuthExpectationFailedException2	OAuthExpectationFailedException
    //   480	1	12	localOAuthExpectationFailedException3	OAuthExpectationFailedException
    //   42	3	13	localHttpRequest	HttpRequest
    //   60	13	14	localIterator	java.util.Iterator
    //   220	3	16	localHttpResponse	HttpResponse
    //   233	67	17	i	int
    //   236	29	18	j	int
    //   316	40	19	localHttpParameters1	HttpParameters
    //   325	58	20	str1	String
    //   335	50	21	str2	String
    //   402	7	24	localException6	java.lang.Exception
    //   278	7	25	localException7	java.lang.Exception
    //   258	3	26	bool	boolean
    //   152	11	27	localHttpParameters2	HttpParameters
    //   82	9	28	str3	String
    // Exception table:
    //   from	to	target	type
    //   48	105	108	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   145	222	108	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   117	120	120	finally
    //   269	277	278	java/lang/Exception
    //   391	399	402	java/lang/Exception
    //   37	44	414	com/parse/signpost/exception/OAuthExpectationFailedException
    //   130	138	432	java/lang/Exception
    //   37	44	444	finally
    //   226	260	452	finally
    //   298	391	452	finally
    //   48	105	461	java/lang/Exception
    //   145	222	461	java/lang/Exception
    //   226	260	466	java/lang/Exception
    //   298	391	466	java/lang/Exception
    //   48	105	475	com/parse/signpost/exception/OAuthExpectationFailedException
    //   145	222	475	com/parse/signpost/exception/OAuthExpectationFailedException
    //   226	260	480	com/parse/signpost/exception/OAuthExpectationFailedException
    //   298	391	480	com/parse/signpost/exception/OAuthExpectationFailedException
    //   37	44	489	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   226	260	497	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   298	391	497	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   48	105	506	finally
    //   145	222	506	finally
    //   419	432	506	finally
    //   37	44	511	java/lang/Exception
  }
  
  public abstract HttpResponse sendRequest(HttpRequest paramHttpRequest);
  
  public void setListener(OAuthProviderListener paramOAuthProviderListener)
  {
    this.listener = paramOAuthProviderListener;
  }
  
  public void setOAuth10a(boolean paramBoolean)
  {
    this.isOAuth10a = paramBoolean;
  }
  
  public void setRequestHeader(String paramString1, String paramString2)
  {
    this.defaultHeaders.put(paramString1, paramString2);
  }
  
  public void setResponseParameters(HttpParameters paramHttpParameters)
  {
    this.responseParameters = paramHttpParameters;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.AbstractOAuthProvider
 * JD-Core Version:    0.7.0.1
 */