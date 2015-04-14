import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class Iv
  implements DialogInterface.OnClickListener
{
  Iv(Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.run();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Iv
 * JD-Core Version:    0.7.0.1
 */