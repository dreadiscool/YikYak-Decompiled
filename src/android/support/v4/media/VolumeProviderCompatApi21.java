package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21
{
  public static Object createVolumeProvider(int paramInt1, int paramInt2, int paramInt3, VolumeProviderCompatApi21.Delegate paramDelegate)
  {
    return new VolumeProviderCompatApi21.1(paramInt1, paramInt2, paramInt3, paramDelegate);
  }
  
  public static void setCurrentVolume(Object paramObject, int paramInt)
  {
    ((VolumeProvider)paramObject).setCurrentVolume(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.VolumeProviderCompatApi21
 * JD-Core Version:    0.7.0.1
 */