package com.facebook;

import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;

abstract interface TestSession$TestAccountsResponse
  extends GraphObject
{
  public abstract GraphObjectList<TestSession.TestAccount> getData();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.TestSession.TestAccountsResponse
 * JD-Core Version:    0.7.0.1
 */