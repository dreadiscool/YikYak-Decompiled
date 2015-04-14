package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new MediaSessionCompat.Token.1();
  private final Parcelable mInner;
  
  MediaSessionCompat$Token(Parcelable paramParcelable)
  {
    this.mInner = paramParcelable;
  }
  
  public int describeContents()
  {
    return this.mInner.describeContents();
  }
  
  public Object getToken()
  {
    return this.mInner;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mInner, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * JD-Core Version:    0.7.0.1
 */