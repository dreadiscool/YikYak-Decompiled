import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

class vc
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  vc(vb paramvb) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    synchronized ()
    {
      vb.a(this.a);
      vb.a(false);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vc
 * JD-Core Version:    0.7.0.1
 */