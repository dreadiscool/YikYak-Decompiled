package android.support.v4.media;

import android.os.Build.VERSION;

public abstract class VolumeProviderCompat
{
  public static final int VOLUME_CONTROL_ABSOLUTE = 2;
  public static final int VOLUME_CONTROL_FIXED = 0;
  public static final int VOLUME_CONTROL_RELATIVE = 1;
  private VolumeProviderCompat.Callback mCallback;
  private final int mControlType;
  private int mCurrentVolume;
  private final int mMaxVolume;
  private Object mVolumeProviderObj;
  
  public VolumeProviderCompat(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mControlType = paramInt1;
    this.mMaxVolume = paramInt2;
    this.mCurrentVolume = paramInt3;
  }
  
  public final int getCurrentVolume()
  {
    return this.mCurrentVolume;
  }
  
  public final int getMaxVolume()
  {
    return this.mMaxVolume;
  }
  
  public final int getVolumeControl()
  {
    return this.mControlType;
  }
  
  public Object getVolumeProvider()
  {
    if ((this.mVolumeProviderObj != null) || (Build.VERSION.SDK_INT < 21)) {}
    for (Object localObject = this.mVolumeProviderObj;; localObject = this.mVolumeProviderObj)
    {
      return localObject;
      this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new VolumeProviderCompat.1(this));
    }
  }
  
  public void onAdjustVolume(int paramInt) {}
  
  public void onSetVolumeTo(int paramInt) {}
  
  public void setCallback(VolumeProviderCompat.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public final void setCurrentVolume(int paramInt)
  {
    if (this.mCallback != null) {
      this.mCallback.onVolumeChanged(this);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.VolumeProviderCompat
 * JD-Core Version:    0.7.0.1
 */