package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import java.util.Iterator;
import java.util.Set;

public final class MediaMetadataCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new MediaMetadataCompat.1();
  private static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap();
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  private static final int METADATA_TYPE_BITMAP = 2;
  private static final int METADATA_TYPE_LONG = 0;
  private static final int METADATA_TYPE_RATING = 3;
  private static final int METADATA_TYPE_TEXT = 1;
  private static final String TAG = "MediaMetadata";
  private final Bundle mBundle;
  private Object mMetadataObj;
  
  static
  {
    METADATA_KEYS_TYPE.put("android.media.metadata.TITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
    METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
  }
  
  private MediaMetadataCompat(Bundle paramBundle)
  {
    this.mBundle = new Bundle(paramBundle);
  }
  
  private MediaMetadataCompat(Parcel paramParcel)
  {
    this.mBundle = paramParcel.readBundle();
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject)
  {
    MediaMetadataCompat localMediaMetadataCompat;
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
      localMediaMetadataCompat = null;
    }
    for (;;)
    {
      return localMediaMetadataCompat;
      MediaMetadataCompat.Builder localBuilder = new MediaMetadataCompat.Builder();
      Iterator localIterator = MediaMetadataCompatApi21.keySet(paramObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Integer localInteger = (Integer)METADATA_KEYS_TYPE.get(str);
        if (localInteger != null) {
          switch (localInteger.intValue())
          {
          default: 
            break;
          case 0: 
            localBuilder.putLong(str, MediaMetadataCompatApi21.getLong(paramObject, str));
            break;
          case 2: 
            localBuilder.putBitmap(str, MediaMetadataCompatApi21.getBitmap(paramObject, str));
            break;
          case 3: 
            localBuilder.putRating(str, RatingCompat.fromRating(MediaMetadataCompatApi21.getRating(paramObject, str)));
            break;
          case 1: 
            localBuilder.putText(str, MediaMetadataCompatApi21.getText(paramObject, str));
          }
        }
      }
      localMediaMetadataCompat = localBuilder.build();
      localMediaMetadataCompat.mMetadataObj = paramObject;
    }
  }
  
  public boolean containsKey(String paramString)
  {
    return this.mBundle.containsKey(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    try
    {
      localBitmap = (Bitmap)this.mBundle.getParcelable(paramString);
      return localBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bitmap localBitmap = null;
      }
    }
  }
  
  public long getLong(String paramString)
  {
    return this.mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata()
  {
    if ((this.mMetadataObj != null) || (Build.VERSION.SDK_INT < 21)) {}
    for (Object localObject1 = this.mMetadataObj;; localObject1 = this.mMetadataObj)
    {
      return localObject1;
      Object localObject2 = MediaMetadataCompatApi21.Builder.newInstance();
      Iterator localIterator = keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Integer localInteger = (Integer)METADATA_KEYS_TYPE.get(str);
        if (localInteger != null) {
          switch (localInteger.intValue())
          {
          default: 
            break;
          case 0: 
            MediaMetadataCompatApi21.Builder.putLong(localObject2, str, getLong(str));
            break;
          case 2: 
            MediaMetadataCompatApi21.Builder.putBitmap(localObject2, str, getBitmap(str));
            break;
          case 3: 
            MediaMetadataCompatApi21.Builder.putRating(localObject2, str, getRating(str).getRating());
            break;
          case 1: 
            MediaMetadataCompatApi21.Builder.putText(localObject2, str, getText(str));
          }
        }
      }
      this.mMetadataObj = MediaMetadataCompatApi21.Builder.build(localObject2);
    }
  }
  
  public RatingCompat getRating(String paramString)
  {
    try
    {
      localRatingCompat = (RatingCompat)this.mBundle.getParcelable(paramString);
      return localRatingCompat;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RatingCompat localRatingCompat = null;
      }
    }
  }
  
  public String getString(String paramString)
  {
    CharSequence localCharSequence = this.mBundle.getCharSequence(paramString);
    if (localCharSequence != null) {}
    for (String str = localCharSequence.toString();; str = null) {
      return str;
    }
  }
  
  public CharSequence getText(String paramString)
  {
    return this.mBundle.getCharSequence(paramString);
  }
  
  public Set<String> keySet()
  {
    return this.mBundle.keySet();
  }
  
  public int size()
  {
    return this.mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaMetadataCompat
 * JD-Core Version:    0.7.0.1
 */