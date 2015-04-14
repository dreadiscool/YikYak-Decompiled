package com.facebook.widget;

public enum FacebookDialog$MessageDialogFeature
  implements FacebookDialog.DialogFeature
{
  private int minVersion;
  
  static
  {
    MessageDialogFeature[] arrayOfMessageDialogFeature = new MessageDialogFeature[3];
    arrayOfMessageDialogFeature[0] = MESSAGE_DIALOG;
    arrayOfMessageDialogFeature[1] = PHOTOS;
    arrayOfMessageDialogFeature[2] = VIDEO;
    $VALUES = arrayOfMessageDialogFeature;
  }
  
  private FacebookDialog$MessageDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.MESSAGE_DIALOG";
  }
  
  public int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.MessageDialogFeature
 * JD-Core Version:    0.7.0.1
 */