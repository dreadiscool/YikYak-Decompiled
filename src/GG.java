import android.os.Message;
import android.support.v4.app.FragmentManager;

class GG
  extends BY<Gz>
{
  public GG(Gz paramGz)
  {
    super(paramGz);
  }
  
  public boolean a(Gz paramGz, Message paramMessage)
  {
    paramGz.getFragmentManager().executePendingTransactions();
    if (paramGz.isAdded()) {
      paramGz.a(CV.c());
    }
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GG
 * JD-Core Version:    0.7.0.1
 */