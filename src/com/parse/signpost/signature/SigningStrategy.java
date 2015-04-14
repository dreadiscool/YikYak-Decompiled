package com.parse.signpost.signature;

import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.io.Serializable;

public abstract interface SigningStrategy
  extends Serializable
{
  public abstract String writeSignature(String paramString, HttpRequest paramHttpRequest, HttpParameters paramHttpParameters);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.signature.SigningStrategy
 * JD-Core Version:    0.7.0.1
 */