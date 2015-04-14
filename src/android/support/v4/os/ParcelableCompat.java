package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class ParcelableCompat
{
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      ParcelableCompatCreatorHoneycombMR2Stub.instantiate(paramParcelableCompatCreatorCallbacks);
    }
    return new ParcelableCompat.CompatCreator(paramParcelableCompatCreatorCallbacks);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.ParcelableCompat
 * JD-Core Version:    0.7.0.1
 */