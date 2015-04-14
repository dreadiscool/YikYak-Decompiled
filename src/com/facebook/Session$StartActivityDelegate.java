package com.facebook;

import android.app.Activity;
import android.content.Intent;

abstract interface Session$StartActivityDelegate
{
  public abstract Activity getActivityContext();
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.StartActivityDelegate
 * JD-Core Version:    0.7.0.1
 */