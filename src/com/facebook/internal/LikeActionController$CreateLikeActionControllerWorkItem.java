package com.facebook.internal;

class LikeActionController$CreateLikeActionControllerWorkItem
  implements Runnable
{
  private LikeActionController.CreationCallback callback;
  private String objectId;
  
  LikeActionController$CreateLikeActionControllerWorkItem(String paramString, LikeActionController.CreationCallback paramCreationCallback)
  {
    this.objectId = paramString;
    this.callback = paramCreationCallback;
  }
  
  public void run()
  {
    LikeActionController.access$3000(this.objectId, this.callback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.CreateLikeActionControllerWorkItem
 * JD-Core Version:    0.7.0.1
 */