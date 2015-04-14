import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.yik.yak.ui.activity.SendAYak;

public class DW
  implements DialogInterface.OnClickListener
{
  public DW(SendAYak paramSendAYak) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SendAYak.c(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DW
 * JD-Core Version:    0.7.0.1
 */