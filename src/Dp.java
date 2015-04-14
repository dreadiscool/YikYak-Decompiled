import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.activity.PeekSearchActivity;

public class Dp
  implements jI
{
  public Dp(PeekSearchActivity paramPeekSearchActivity) {}
  
  public void a(LatLng paramLatLng)
  {
    PeekSearchActivity.a(this.a, PeekSearchActivity.a(this.a).b().b);
    PeekSearchActivity.a(this.a, new YakkerLocation("Peek"));
    PeekSearchActivity.b(this.a).setLatitude(paramLatLng.a);
    PeekSearchActivity.b(this.a).setLongitude(paramLatLng.b);
    this.a.a(PeekSearchActivity.b(this.a));
    PeekSearchActivity.b(this.a).setProvider(PeekSearchActivity.b(this.a, PeekSearchActivity.b(this.a)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dp
 * JD-Core Version:    0.7.0.1
 */