package com.facebook.internal;

public enum SessionAuthorizationType
{
  static
  {
    PUBLISH = new SessionAuthorizationType("PUBLISH", 1);
    SessionAuthorizationType[] arrayOfSessionAuthorizationType = new SessionAuthorizationType[2];
    arrayOfSessionAuthorizationType[0] = READ;
    arrayOfSessionAuthorizationType[1] = PUBLISH;
    $VALUES = arrayOfSessionAuthorizationType;
  }
  
  private SessionAuthorizationType() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.SessionAuthorizationType
 * JD-Core Version:    0.7.0.1
 */