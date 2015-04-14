package com.facebook;

class Session$3
  implements AuthorizationClient.OnCompletedListener
{
  Session$3(Session paramSession) {}
  
  public void onCompleted(AuthorizationClient.Result paramResult)
  {
    if (paramResult.code == AuthorizationClient.Result.Code.CANCEL) {}
    for (int i = 0;; i = -1)
    {
      Session.access$1100(this.this$0, i, paramResult);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.3
 * JD-Core Version:    0.7.0.1
 */