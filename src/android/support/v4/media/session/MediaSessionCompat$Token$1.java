package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MediaSessionCompat$Token$1
  implements Parcelable.Creator<MediaSessionCompat.Token>
{
  public MediaSessionCompat.Token createFromParcel(Parcel paramParcel)
  {
    return new MediaSessionCompat.Token(paramParcel.readParcelable(null));
  }
  
  public MediaSessionCompat.Token[] newArray(int paramInt)
  {
    return new MediaSessionCompat.Token[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token.1
 * JD-Core Version:    0.7.0.1
 */