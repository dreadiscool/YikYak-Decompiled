package android.support.v4.app;

import android.os.Bundle;

class ActivityOptionsCompat$ActivityOptionsImplJB
  extends ActivityOptionsCompat
{
  private final ActivityOptionsCompatJB mImpl;
  
  ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
  {
    this.mImpl = paramActivityOptionsCompatJB;
  }
  
  public Bundle toBundle()
  {
    return this.mImpl.toBundle();
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat)
  {
    if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
    {
      ActivityOptionsImplJB localActivityOptionsImplJB = (ActivityOptionsImplJB)paramActivityOptionsCompat;
      this.mImpl.update(localActivityOptionsImplJB.mImpl);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat.ActivityOptionsImplJB
 * JD-Core Version:    0.7.0.1
 */