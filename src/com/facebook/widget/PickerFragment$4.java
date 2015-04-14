package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class PickerFragment$4
  implements Session.StatusCallback
{
  PickerFragment$4(PickerFragment paramPickerFragment) {}
  
  public void call(Session paramSession, SessionState paramSessionState, Exception paramException)
  {
    if (!paramSession.isOpened()) {
      PickerFragment.access$100(this.this$0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PickerFragment.4
 * JD-Core Version:    0.7.0.1
 */