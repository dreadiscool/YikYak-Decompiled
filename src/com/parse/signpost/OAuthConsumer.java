package com.parse.signpost;

import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.signature.OAuthMessageSigner;
import com.parse.signpost.signature.SigningStrategy;
import java.io.Serializable;

public abstract interface OAuthConsumer
  extends Serializable
{
  public abstract String getConsumerKey();
  
  public abstract String getConsumerSecret();
  
  public abstract HttpParameters getRequestParameters();
  
  public abstract String getToken();
  
  public abstract String getTokenSecret();
  
  public abstract void setAdditionalParameters(HttpParameters paramHttpParameters);
  
  public abstract void setMessageSigner(OAuthMessageSigner paramOAuthMessageSigner);
  
  public abstract void setSendEmptyTokens(boolean paramBoolean);
  
  public abstract void setSigningStrategy(SigningStrategy paramSigningStrategy);
  
  public abstract void setTokenWithSecret(String paramString1, String paramString2);
  
  public abstract HttpRequest sign(HttpRequest paramHttpRequest);
  
  public abstract HttpRequest sign(Object paramObject);
  
  public abstract String sign(String paramString);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.OAuthConsumer
 * JD-Core Version:    0.7.0.1
 */