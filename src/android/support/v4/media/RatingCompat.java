package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new RatingCompat.1();
  public static final int RATING_3_STARS = 3;
  public static final int RATING_4_STARS = 4;
  public static final int RATING_5_STARS = 5;
  public static final int RATING_HEART = 1;
  public static final int RATING_NONE = 0;
  private static final float RATING_NOT_RATED = -1.0F;
  public static final int RATING_PERCENTAGE = 6;
  public static final int RATING_THUMB_UP_DOWN = 2;
  private static final String TAG = "Rating";
  private Object mRatingObj;
  private final int mRatingStyle;
  private final float mRatingValue;
  
  private RatingCompat(int paramInt, float paramFloat)
  {
    this.mRatingStyle = paramInt;
    this.mRatingValue = paramFloat;
  }
  
  public static RatingCompat fromRating(Object paramObject)
  {
    RatingCompat localRatingCompat = null;
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {}
    int i;
    for (;;)
    {
      return localRatingCompat;
      i = RatingCompatApi21.getRatingStyle(paramObject);
      if (!RatingCompatApi21.isRated(paramObject)) {
        break;
      }
      switch (i)
      {
      }
    }
    localRatingCompat = newHeartRating(RatingCompatApi21.hasHeart(paramObject));
    for (;;)
    {
      localRatingCompat.mRatingObj = paramObject;
      break;
      localRatingCompat = newThumbRating(RatingCompatApi21.isThumbUp(paramObject));
      continue;
      localRatingCompat = newStarRating(i, RatingCompatApi21.getStarRating(paramObject));
      continue;
      localRatingCompat = newPercentageRating(RatingCompatApi21.getPercentRating(paramObject));
      continue;
      localRatingCompat = newUnratedRating(i);
    }
  }
  
  public static RatingCompat newHeartRating(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F) {
      return new RatingCompat(1, f);
    }
  }
  
  public static RatingCompat newPercentageRating(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 100.0F)) {}
    for (RatingCompat localRatingCompat = null;; localRatingCompat = new RatingCompat(6, paramFloat)) {
      return localRatingCompat;
    }
  }
  
  public static RatingCompat newStarRating(int paramInt, float paramFloat)
  {
    RatingCompat localRatingCompat = null;
    float f;
    switch (paramInt)
    {
    default: 
      new StringBuilder().append("Invalid rating style (").append(paramInt).append(") for a star rating").toString();
      return localRatingCompat;
    case 3: 
      f = 3.0F;
    }
    while ((paramFloat >= 0.0F) && (paramFloat <= f))
    {
      localRatingCompat = new RatingCompat(paramInt, paramFloat);
      break;
      f = 4.0F;
      continue;
      f = 5.0F;
    }
  }
  
  public static RatingCompat newThumbRating(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F) {
      return new RatingCompat(2, f);
    }
  }
  
  public static RatingCompat newUnratedRating(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (RatingCompat localRatingCompat = null;; localRatingCompat = new RatingCompat(paramInt, -1.0F)) {
      return localRatingCompat;
    }
  }
  
  public int describeContents()
  {
    return this.mRatingStyle;
  }
  
  public float getPercentRating()
  {
    if ((this.mRatingStyle != 6) || (!isRated())) {}
    for (float f = -1.0F;; f = this.mRatingValue) {
      return f;
    }
  }
  
  public Object getRating()
  {
    if ((this.mRatingObj != null) || (Build.VERSION.SDK_INT < 21)) {}
    label72:
    for (Object localObject = this.mRatingObj;; localObject = null)
    {
      return localObject;
      if (!isRated()) {
        break;
      }
      switch (this.mRatingStyle)
      {
      }
    }
    this.mRatingObj = RatingCompatApi21.newHeartRating(hasHeart());
    for (;;)
    {
      localObject = this.mRatingObj;
      break;
      this.mRatingObj = RatingCompatApi21.newThumbRating(isThumbUp());
      continue;
      this.mRatingObj = RatingCompatApi21.newStarRating(this.mRatingStyle, getStarRating());
      continue;
      this.mRatingObj = RatingCompatApi21.newPercentageRating(getPercentRating());
      break label72;
      this.mRatingObj = RatingCompatApi21.newUnratedRating(this.mRatingStyle);
    }
  }
  
  public int getRatingStyle()
  {
    return this.mRatingStyle;
  }
  
  public float getStarRating()
  {
    switch (this.mRatingStyle)
    {
    }
    for (float f = -1.0F;; f = this.mRatingValue)
    {
      return f;
      if (!isRated()) {
        break;
      }
    }
  }
  
  public boolean hasHeart()
  {
    int i = 1;
    boolean bool = false;
    if (this.mRatingStyle != i) {
      return bool;
    }
    if (this.mRatingValue == 1.0F) {}
    for (;;)
    {
      bool = i;
      break;
      i = 0;
    }
  }
  
  public boolean isRated()
  {
    if (this.mRatingValue >= 0.0F) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isThumbUp()
  {
    boolean bool = false;
    if (this.mRatingStyle != 2) {}
    for (;;)
    {
      return bool;
      if (this.mRatingValue == 1.0F) {
        bool = true;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Rating:style=").append(this.mRatingStyle).append(" rating=");
    if (this.mRatingValue < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.mRatingValue)) {
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRatingStyle);
    paramParcel.writeFloat(this.mRatingValue);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */