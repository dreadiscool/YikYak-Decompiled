import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class EE
  extends FragmentStatePagerAdapter
{
  public boolean a = false;
  private Handler b;
  
  public EE(FragmentManager paramFragmentManager, Handler.Callback paramCallback)
  {
    super(paramFragmentManager);
    this.b = new Handler(paramCallback);
  }
  
  public int getCount()
  {
    return 4;
  }
  
  public Fragment getItem(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = new FR();
      continue;
      localObject = new Gz();
      ((Gz)localObject).a(null);
      continue;
      localObject = new Gd();
      ((Gd)localObject).a(null);
      continue;
      localObject = new Go();
      ((Go)localObject).a(null);
      this.a = true;
      if (this.b != null) {
        this.b.sendMessage(new Message());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EE
 * JD-Core Version:    0.7.0.1
 */