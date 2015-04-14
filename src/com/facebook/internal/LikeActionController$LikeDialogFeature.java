package com.facebook.internal;

import com.facebook.widget.FacebookDialog.DialogFeature;

 enum LikeActionController$LikeDialogFeature
  implements FacebookDialog.DialogFeature
{
  private int minVersion;
  
  static
  {
    LikeDialogFeature[] arrayOfLikeDialogFeature = new LikeDialogFeature[1];
    arrayOfLikeDialogFeature[0] = LIKE_DIALOG;
    $VALUES = arrayOfLikeDialogFeature;
  }
  
  private LikeActionController$LikeDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.LIKE_DIALOG";
  }
  
  public int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.LikeDialogFeature
 * JD-Core Version:    0.7.0.1
 */