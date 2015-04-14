package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException
  extends Exception
{
  private final Intent mIntent;
  
  public UserRecoverableException(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    return new Intent(this.mIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.UserRecoverableException
 * JD-Core Version:    0.7.0.1
 */