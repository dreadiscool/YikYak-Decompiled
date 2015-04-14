package com.facebook;

import com.facebook.model.GraphPlace;

final class Request$3
  implements Request.Callback
{
  Request$3(Request.GraphPlaceListCallback paramGraphPlaceListCallback) {}
  
  public void onCompleted(Response paramResponse)
  {
    if (this.val$callback != null) {
      this.val$callback.onCompleted(Request.access$000(paramResponse, GraphPlace.class), paramResponse);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.3
 * JD-Core Version:    0.7.0.1
 */