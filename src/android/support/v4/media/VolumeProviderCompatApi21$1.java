package android.support.v4.media;

import android.media.VolumeProvider;

final class VolumeProviderCompatApi21$1
  extends VolumeProvider
{
  VolumeProviderCompatApi21$1(int paramInt1, int paramInt2, int paramInt3, VolumeProviderCompatApi21.Delegate paramDelegate)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onAdjustVolume(int paramInt)
  {
    this.val$delegate.onAdjustVolume(paramInt);
  }
  
  public void onSetVolumeTo(int paramInt)
  {
    this.val$delegate.onSetVolumeTo(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.VolumeProviderCompatApi21.1
 * JD-Core Version:    0.7.0.1
 */