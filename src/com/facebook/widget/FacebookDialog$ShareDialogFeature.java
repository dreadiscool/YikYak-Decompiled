package com.facebook.widget;

public enum FacebookDialog$ShareDialogFeature
  implements FacebookDialog.DialogFeature
{
  private int minVersion;
  
  static
  {
    PHOTOS = new ShareDialogFeature("PHOTOS", 1, 20140204);
    VIDEO = new ShareDialogFeature("VIDEO", 2, 20141028);
    ShareDialogFeature[] arrayOfShareDialogFeature = new ShareDialogFeature[3];
    arrayOfShareDialogFeature[0] = SHARE_DIALOG;
    arrayOfShareDialogFeature[1] = PHOTOS;
    arrayOfShareDialogFeature[2] = VIDEO;
    $VALUES = arrayOfShareDialogFeature;
  }
  
  private FacebookDialog$ShareDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.FEED_DIALOG";
  }
  
  public int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.ShareDialogFeature
 * JD-Core Version:    0.7.0.1
 */