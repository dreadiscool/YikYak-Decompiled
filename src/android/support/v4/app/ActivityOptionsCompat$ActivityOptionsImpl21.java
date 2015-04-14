package android.support.v4.app;

import android.os.Bundle;

class ActivityOptionsCompat$ActivityOptionsImpl21
  extends ActivityOptionsCompat
{
  private final ActivityOptionsCompat21 mImpl;
  
  ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21 paramActivityOptionsCompat21)
  {
    this.mImpl = paramActivityOptionsCompat21;
  }
  
  public Bundle toBundle()
  {
    return this.mImpl.toBundle();
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat)
  {
    if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl21))
    {
      ActivityOptionsImpl21 localActivityOptionsImpl21 = (ActivityOptionsImpl21)paramActivityOptionsCompat;
      this.mImpl.update(localActivityOptionsImpl21.mImpl);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat.ActivityOptionsImpl21
 * JD-Core Version:    0.7.0.1
 */