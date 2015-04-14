package com.facebook.internal;

final class LikeActionController$3
  implements Runnable
{
  LikeActionController$3(LikeActionController.CreationCallback paramCreationCallback, LikeActionController paramLikeActionController) {}
  
  public void run()
  {
    this.val$callback.onComplete(this.val$controller);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.3
 * JD-Core Version:    0.7.0.1
 */