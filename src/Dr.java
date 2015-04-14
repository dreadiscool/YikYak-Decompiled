import android.location.Address;
import android.location.Geocoder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.activity.PeekSearchActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Dr
  implements AdapterView.OnItemClickListener
{
  public Dr(PeekSearchActivity paramPeekSearchActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)paramAdapterView.getItemAtPosition(paramInt);
    PeekSearchActivity.e(this.a);
    Geocoder localGeocoder = new Geocoder(PeekSearchActivity.f(this.a));
    try
    {
      ArrayList localArrayList = (ArrayList)localGeocoder.getFromLocationName(str, 1);
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        Toast.makeText(PeekSearchActivity.f(this.a), "Could not find map coordinates for location.", 0).show();
      }
      else
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Address localAddress = (Address)localIterator.next();
          double d1 = localAddress.getLongitude();
          double d2 = localAddress.getLatitude();
          PeekSearchActivity.a(this.a, new YakkerLocation(str));
          PeekSearchActivity.b(this.a).setLatitude(d2);
          PeekSearchActivity.b(this.a).setLongitude(d1);
          this.a.a(PeekSearchActivity.b(this.a));
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dr
 * JD-Core Version:    0.7.0.1
 */