package com.facebook.widget;

public enum FacebookDialog$OpenGraphMessageDialogFeature
  implements FacebookDialog.DialogFeature
{
  private int minVersion;
  
  static
  {
    OpenGraphMessageDialogFeature[] arrayOfOpenGraphMessageDialogFeature = new OpenGraphMessageDialogFeature[1];
    arrayOfOpenGraphMessageDialogFeature[0] = OG_MESSAGE_DIALOG;
    $VALUES = arrayOfOpenGraphMessageDialogFeature;
  }
  
  private FacebookDialog$OpenGraphMessageDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  }
  
  public int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.OpenGraphMessageDialogFeature
 * JD-Core Version:    0.7.0.1
 */