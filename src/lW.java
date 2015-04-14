import android.os.Bundle;
import android.os.Parcelable;

public final class lW
{
  public static void a(Bundle paramBundle, String paramString, Parcelable paramParcelable)
  {
    paramBundle.setClassLoader(lW.class.getClassLoader());
    Bundle localBundle = paramBundle.getBundle("map_state");
    if (localBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.setClassLoader(lW.class.getClassLoader());
    localBundle.putParcelable(paramString, paramParcelable);
    paramBundle.putBundle("map_state", localBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lW
 * JD-Core Version:    0.7.0.1
 */