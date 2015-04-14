import android.support.v4.app.Fragment;
import com.yik.yak.ui.adapter.viewholder.YakDetailViewHolder;

class EU
  implements Runnable
{
  EU(ET paramET) {}
  
  public void run()
  {
    if (this.a.a.fragment.getActivity() != null) {}
    for (;;)
    {
      try
      {
        new HA(this.a.a.fragment.getActivity(), 25, 2130837721, 4000L).a(0.1F, 0.25F).b(100.0F).a(new Hv(100, 0, 500L, 3000L)).a(this.a.a.shareButton, 25, 300);
        return;
      }
      catch (Exception localException)
      {
        G.a(6, "YikYak", "Particle system crashed for reason: " + localException.getMessage());
        continue;
      }
      G.a(6, "YikYak", "Particle system tried to animate, but there was a null activity!");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EU
 * JD-Core Version:    0.7.0.1
 */