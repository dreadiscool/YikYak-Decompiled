import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class nz
  implements ComponentCallbacks2
{
  nz(nw paramnw) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt == 20) {
      this.a.a();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nz
 * JD-Core Version:    0.7.0.1
 */