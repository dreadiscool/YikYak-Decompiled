package com.squareup.picasso;

final class BitmapHunter$3
  implements Runnable
{
  BitmapHunter$3(Transformation paramTransformation) {}
  
  public void run()
  {
    throw new IllegalStateException("Transformation " + this.val$transformation.key() + " returned input Bitmap but recycled it.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter.3
 * JD-Core Version:    0.7.0.1
 */