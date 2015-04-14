import android.os.IInterface;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract interface kv
  extends IInterface
{
  public abstract StreetViewPanoramaOrientation a(gU paramgU);
  
  public abstract gU a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  
  public abstract void a(LatLng paramLatLng);
  
  public abstract void a(LatLng paramLatLng, int paramInt);
  
  public abstract void a(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong);
  
  public abstract void a(String paramString);
  
  public abstract void a(lH paramlH);
  
  public abstract void a(lK paramlK);
  
  public abstract void a(lN paramlN);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d();
  
  public abstract StreetViewPanoramaCamera e();
  
  public abstract StreetViewPanoramaLocation f();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kv
 * JD-Core Version:    0.7.0.1
 */