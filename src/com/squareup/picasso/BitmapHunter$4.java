package com.squareup.picasso;

final class BitmapHunter$4
  implements Runnable
{
  BitmapHunter$4(Transformation paramTransformation) {}
  
  public void run()
  {
    throw new IllegalStateException("Transformation " + this.val$transformation.key() + " mutated input Bitmap but failed to recycle the original.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter.4
 * JD-Core Version:    0.7.0.1
 */