package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

class BundleUtil
{
  public static Bundle[] getBundleArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    Bundle[] arrayOfBundle;
    if (((arrayOfParcelable instanceof Bundle[])) || (arrayOfParcelable == null)) {
      arrayOfBundle = (Bundle[])arrayOfParcelable;
    }
    for (;;)
    {
      return arrayOfBundle;
      arrayOfBundle = (Bundle[])Arrays.copyOf(arrayOfParcelable, arrayOfParcelable.length, [Landroid.os.Bundle.class);
      paramBundle.putParcelableArray(paramString, arrayOfBundle);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BundleUtil
 * JD-Core Version:    0.7.0.1
 */