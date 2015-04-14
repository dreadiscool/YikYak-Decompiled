import android.os.Message;
import com.yik.yak.ui.activity.MainActivity;

class FU
  extends BY<FR>
{
  public FU(FR paramFR)
  {
    super(paramFR);
  }
  
  public boolean a(FR paramFR, Message paramMessage)
  {
    ((MainActivity)paramFR.getActivity()).b();
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FU
 * JD-Core Version:    0.7.0.1
 */