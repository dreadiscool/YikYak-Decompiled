package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

public class QueryStringSigningStrategy
  implements SigningStrategy
{
  private static final long serialVersionUID = 1L;
  
  public String writeSignature(String paramString, HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
  {
    String str1 = paramHttpRequest.getRequestUrl();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "oauth_signature";
    arrayOfString[1] = paramString;
    StringBuilder localStringBuilder = new StringBuilder(OAuth.addQueryParameters(str1, arrayOfString));
    if (paramHttpParameters.containsKey("oauth_token"))
    {
      localStringBuilder.append("&");
      localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_token"));
    }
    if (paramHttpParameters.containsKey("oauth_callback"))
    {
      localStringBuilder.append("&");
      localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_callback"));
    }
    if (paramHttpParameters.containsKey("oauth_verifier"))
    {
      localStringBuilder.append("&");
      localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_verifier"));
    }
    localStringBuilder.append("&");
    localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_consumer_key"));
    localStringBuilder.append("&");
    localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_version"));
    localStringBuilder.append("&");
    localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_signature_method"));
    localStringBuilder.append("&");
    localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_timestamp"));
    localStringBuilder.append("&");
    localStringBuilder.append(paramHttpParameters.getAsQueryString("oauth_nonce"));
    String str2 = localStringBuilder.toString();
    paramHttpRequest.setRequestUrl(str2);
    return str2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.signature.QueryStringSigningStrategy
 * JD-Core Version:    0.7.0.1
 */