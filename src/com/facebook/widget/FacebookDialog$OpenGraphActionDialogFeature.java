package com.facebook.widget;

public enum FacebookDialog$OpenGraphActionDialogFeature
  implements FacebookDialog.DialogFeature
{
  private int minVersion;
  
  static
  {
    OpenGraphActionDialogFeature[] arrayOfOpenGraphActionDialogFeature = new OpenGraphActionDialogFeature[1];
    arrayOfOpenGraphActionDialogFeature[0] = OG_ACTION_DIALOG;
    $VALUES = arrayOfOpenGraphActionDialogFeature;
  }
  
  private FacebookDialog$OpenGraphActionDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  }
  
  public int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.OpenGraphActionDialogFeature
 * JD-Core Version:    0.7.0.1
 */