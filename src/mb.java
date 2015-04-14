import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public final class mb
{
  private LatLng a;
  private float b;
  private float c;
  private float d;
  
  public CameraPosition a()
  {
    return new CameraPosition(this.a, this.b, this.c, this.d);
  }
  
  public mb a(float paramFloat)
  {
    this.b = paramFloat;
    return this;
  }
  
  public mb a(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public mb b(float paramFloat)
  {
    this.c = paramFloat;
    return this;
  }
  
  public mb c(float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mb
 * JD-Core Version:    0.7.0.1
 */