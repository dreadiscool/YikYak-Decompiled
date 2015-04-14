package com.facebook;

import com.facebook.model.GraphUser;

final class Request$2
  implements Request.Callback
{
  Request$2(Request.GraphUserListCallback paramGraphUserListCallback) {}
  
  public void onCompleted(Response paramResponse)
  {
    if (this.val$callback != null) {
      this.val$callback.onCompleted(Request.access$000(paramResponse, GraphUser.class), paramResponse);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.2
 * JD-Core Version:    0.7.0.1
 */