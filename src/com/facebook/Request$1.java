package com.facebook;

import com.facebook.model.GraphUser;

final class Request$1
  implements Request.Callback
{
  Request$1(Request.GraphUserCallback paramGraphUserCallback) {}
  
  public void onCompleted(Response paramResponse)
  {
    if (this.val$callback != null) {
      this.val$callback.onCompleted((GraphUser)paramResponse.getGraphObjectAs(GraphUser.class), paramResponse);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.1
 * JD-Core Version:    0.7.0.1
 */