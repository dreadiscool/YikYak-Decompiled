package com.squareup.picasso;

import java.util.concurrent.ThreadFactory;

class Utils$PicassoThreadFactory
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Utils.PicassoThread(paramRunnable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Utils.PicassoThreadFactory
 * JD-Core Version:    0.7.0.1
 */