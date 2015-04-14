import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class hw
  implements DialogInterface.OnClickListener
{
  private final Activity a;
  private final Fragment b;
  private final Intent c;
  private final int d;
  
  public hw(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.a = paramActivity;
    this.b = null;
    this.c = paramIntent;
    this.d = paramInt;
  }
  
  public hw(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.a = null;
    this.b = paramFragment;
    this.c = paramIntent;
    this.d = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.c != null) && (this.b != null)) {
        this.b.startActivityForResult(this.c, this.d);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        break;
        if (this.c != null) {
          this.a.startActivityForResult(this.c, this.d);
        }
      }
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException) {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hw
 * JD-Core Version:    0.7.0.1
 */