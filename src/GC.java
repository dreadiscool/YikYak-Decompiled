import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import java.util.List;

class GC
  implements AdapterView.OnItemLongClickListener
{
  GC(Gz paramGz) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CG localCG = (CG)Gz.b(this.a).get(paramInt);
    if ((!localCG.a()) && (localCG.a.equals("My Peeks")))
    {
      Gz.d(this.a).vibrate(250L);
      Gz.a(this.a, localCG);
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GC
 * JD-Core Version:    0.7.0.1
 */