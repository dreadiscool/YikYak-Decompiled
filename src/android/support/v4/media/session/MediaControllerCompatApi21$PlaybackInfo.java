package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.session.MediaController.PlaybackInfo;

public class MediaControllerCompatApi21$PlaybackInfo
{
  private static final int FLAG_SCO = 4;
  private static final int STREAM_BLUETOOTH_SCO = 6;
  private static final int STREAM_SYSTEM_ENFORCED = 7;
  
  public static AudioAttributes getAudioAttributes(Object paramObject)
  {
    return ((MediaController.PlaybackInfo)paramObject).getAudioAttributes();
  }
  
  public static int getCurrentVolume(Object paramObject)
  {
    return ((MediaController.PlaybackInfo)paramObject).getCurrentVolume();
  }
  
  public static int getLegacyAudioStream(Object paramObject)
  {
    return toLegacyStreamType(getAudioAttributes(paramObject));
  }
  
  public static int getMaxVolume(Object paramObject)
  {
    return ((MediaController.PlaybackInfo)paramObject).getMaxVolume();
  }
  
  public static int getPlaybackType(Object paramObject)
  {
    return ((MediaController.PlaybackInfo)paramObject).getPlaybackType();
  }
  
  public static int getVolumeControl(Object paramObject)
  {
    return ((MediaController.PlaybackInfo)paramObject).getVolumeControl();
  }
  
  private static int toLegacyStreamType(AudioAttributes paramAudioAttributes)
  {
    int i = 3;
    if ((0x1 & paramAudioAttributes.getFlags()) == 1) {
      i = 7;
    }
    for (;;)
    {
      return i;
      if ((0x4 & paramAudioAttributes.getFlags()) == 4) {
        i = 6;
      } else {
        switch (paramAudioAttributes.getUsage())
        {
        case 1: 
        case 11: 
        case 12: 
        case 14: 
        default: 
          break;
        case 2: 
          i = 0;
          break;
        case 13: 
          i = 1;
          break;
        case 3: 
          i = 8;
          break;
        case 4: 
          i = 4;
          break;
        case 6: 
          i = 2;
          break;
        case 5: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
          i = 5;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo
 * JD-Core Version:    0.7.0.1
 */