package com.facebook.internal;

import com.facebook.Request.Callback;
import com.facebook.Response;

class LikeActionController$AbstractRequestWrapper$1
  implements Request.Callback
{
  LikeActionController$AbstractRequestWrapper$1(LikeActionController.AbstractRequestWrapper paramAbstractRequestWrapper) {}
  
  public void onCompleted(Response paramResponse)
  {
    this.this$1.error = paramResponse.getError();
    if (this.this$1.error != null) {
      this.this$1.processError(this.this$1.error);
    }
    for (;;)
    {
      return;
      this.this$1.processSuccess(paramResponse);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.AbstractRequestWrapper.1
 * JD-Core Version:    0.7.0.1
 */