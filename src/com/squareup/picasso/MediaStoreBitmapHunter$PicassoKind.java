package com.squareup.picasso;

 enum MediaStoreBitmapHunter$PicassoKind
{
  final int androidKind;
  final int height;
  final int width;
  
  static
  {
    FULL = new PicassoKind("FULL", 2, 2, -1, -1);
    PicassoKind[] arrayOfPicassoKind = new PicassoKind[3];
    arrayOfPicassoKind[0] = MICRO;
    arrayOfPicassoKind[1] = MINI;
    arrayOfPicassoKind[2] = FULL;
    $VALUES = arrayOfPicassoKind;
  }
  
  private MediaStoreBitmapHunter$PicassoKind(int paramInt1, int paramInt2, int paramInt3)
  {
    this.androidKind = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MediaStoreBitmapHunter.PicassoKind
 * JD-Core Version:    0.7.0.1
 */