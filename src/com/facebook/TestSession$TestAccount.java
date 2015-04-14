package com.facebook;

import com.facebook.model.GraphObject;

abstract interface TestSession$TestAccount
  extends GraphObject
{
  public abstract String getAccessToken();
  
  public abstract String getId();
  
  public abstract String getName();
  
  public abstract void setName(String paramString);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.TestSession.TestAccount
 * JD-Core Version:    0.7.0.1
 */